package org.example.backend.common.service.impl;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.config.DbConstant;
import org.example.backend.common.model.Page;
import org.example.backend.common.model.dto.SysDictDto;
import org.example.backend.common.model.param.SysDictParam;
import org.example.backend.common.primary.base.dao.SysDictDao;
import org.example.backend.common.primary.entity.SysDict;
import org.example.backend.common.primary.entity.SysDictExample;
import org.example.backend.common.security.utils.AuthenticationUtil;
import org.example.backend.common.service.SysDictService;
import org.example.backend.common.util.T;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/27 17:10
 */
@Slf4j
@Service
public class SysDictServiceImpl implements SysDictService {

    @Resource
    private SysDictDao sysDictDao;

    @Override
    public List<SysDictDto> findByCode(String code) {
        SysDictExample example = new SysDictExample();
        example.createCriteria().andCodeEqualTo(code);
        return sysDictDao.selectByExampleWithBLOBs(example)
                .stream().map(SysDictDto::entity2Dto).collect(Collectors.toList());
    }

    @Override
    public Page<SysDictDto> pageList(SysDictParam param) {
        SysDictExample example = new SysDictExample();
        SysDictExample.Criteria criteria = example.createCriteria();
        if (T.isNotBlank(param.getCode())) {
            criteria.andCodeLike("%" + param.getCode() + "%");
        }
        if (T.isNotBlank(param.getName())) {
            criteria.andNameLike("%" + param.getName() + "%");
        }
        if (T.isNotNull(param.getStatus())) {
            criteria.andStatusEqualTo(param.getStatus());
        }

        long count = sysDictDao.countByExample(example);
        example.setLimit(param.getLimit());
        example.setOffset(param.getOffset());
        example.setOrderByClause(" sort asc");
        List<SysDictDto> list = sysDictDao.selectByExampleWithBLOBs(example)
                .stream().map(SysDictDto::entity2Dto).collect(Collectors.toList());
        return new Page<>(list, param.getPage(), param.getLimit(), count);
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void addOrEdit(SysDictParam param) {
        boolean isUpdate = param.getId() != null && param.getId() > 0;
        Preconditions.checkNotNull(param, "参数不能为空!");
        List<SysDictParam.SysDictData> dictData = param.getDataList();
        if (T.isEmpty(dictData)) {
            throw new IllegalArgumentException("字典值参数不能为空！");
        }
        Set<String> nameSet = Sets.newHashSet();
        Set<String> valueSet = Sets.newHashSet();
        dictData.stream().filter(Objects::nonNull).forEach(d -> {
            nameSet.add(d.getName());
            valueSet.add(d.getValue());
        });
        if (nameSet.size() != dictData.size() || valueSet.size() != dictData.size()) {
            throw new IllegalArgumentException("字典值name或value不能重复！");
        }

        SysDictExample example = new SysDictExample();
        SysDictExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(param.getName());
        if (isUpdate) {
            criteria.andIdNotEqualTo(param.getId());
        }
        if (sysDictDao.countByExample(example) > 0) {
            throw new IllegalArgumentException("该名称已存在！");
        }

        example = new SysDictExample();
        criteria = example.createCriteria();
        criteria.andCodeEqualTo(param.getCode());
        if (isUpdate) {
            criteria.andIdNotEqualTo(param.getId());
        }
        if (sysDictDao.countByExample(example) > 0) {
            throw new IllegalArgumentException("该编码已存在！");
        }

        SysDict sysDict = new SysDict();
        BeanUtils.copyProperties(param, sysDict);
        if (T.isNotEmpty(param.getDataList())) {
            sysDict.setData(JSON.toJSONString(param.getDataList()));
        }

        if (isUpdate) {
            SysDict old = sysDictDao.selectByPrimaryKey(param.getId());
            if (T.isNull(old)) {
                throw new IllegalArgumentException("该记录不存在！");
            }
            sysDict.setCreator(old.getCreator());
            sysDict.setCreateTime(old.getUpdateTime());
            sysDict.setUpdater(AuthenticationUtil.getUserName());
            sysDict.setUpdateTime(new Date());
            sysDictDao.updateByPrimaryKeyWithBLOBs(sysDict);
        } else {
            sysDict.setCreator(AuthenticationUtil.getUserName());
            sysDict.setCreateTime(new Date());
            sysDictDao.insert(sysDict);
        }
    }

    @Override
    public void deleteById(Integer id) {
        SysDict old = sysDictDao.selectByPrimaryKey(id);
        if (T.isNull(old)) {
            throw new IllegalArgumentException("该记录不存在！");
        }
        sysDictDao.deleteByPrimaryKey(id);
    }

}
