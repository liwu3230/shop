package org.example.backend.common.service.impl;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.backend.common.config.DbConstant;
import org.example.backend.common.model.dto.SysDeptDto;
import org.example.backend.common.model.param.SysDeptParam;
import org.example.backend.common.primary.base.dao.SysDeptDao;
import org.example.backend.common.primary.base.dao.SysUserDao;
import org.example.backend.common.primary.entity.SysDept;
import org.example.backend.common.primary.entity.SysDeptExample;
import org.example.backend.common.primary.entity.SysUserExample;
import org.example.backend.common.security.utils.AuthenticationUtil;
import org.example.backend.common.service.SysDeptService;
import org.example.backend.common.util.Delimiters;
import org.example.backend.common.util.T;
import org.example.backend.common.util.TreeBuildFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/2 12:31
 */
@Slf4j
@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Resource
    private SysDeptDao sysDeptDao;
    @Resource
    private SysUserDao sysUserDao;

    @Override
    public List<SysDeptDto> listTree(SysDeptParam param) {
        SysDeptExample example = new SysDeptExample();
        SysDeptExample.Criteria criteria = example.createCriteria();
        if (T.isNotBlank(param.getName())) {
            criteria.andNameLike("%" + param.getName() + "%");
        }
        if (T.nonNull(param.getParentId())) {
            criteria.andParentIdEqualTo(param.getParentId());
        }
        example.setOrderByClause(" sort asc");
        List<SysDeptDto> sysDeptList = sysDeptDao.selectByExample(example)
                .stream().map(entity -> {
                    SysDeptDto dto = new SysDeptDto();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                }).collect(Collectors.toList());
        return TreeBuildFactory.transToTree(sysDeptList, Comparator.nullsLast(Comparator.comparing(SysDeptDto::getSort, Comparator.nullsLast(Integer::compareTo))));
    }

    @Override
    public List<SysDeptDto> findAll() {
        List<SysDeptDto> sysDeptList = sysDeptDao.selectByExample(null)
                .stream().map(entity -> {
                    SysDeptDto dto = new SysDeptDto();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                }).collect(Collectors.toList());
        Map<Integer, SysDeptDto> deptMap = sysDeptList.stream()
                .collect(Collectors.toMap(SysDeptDto::getId, Function.identity(), (key1, key2) -> key2));
        for (SysDeptDto deptDto : sysDeptList) {
            deptDto.setFullName(deptMap, deptDto.getName(), deptDto.getParentId());
        }
        return sysDeptList;
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void addOrEdit(SysDeptParam param) {
        boolean isUpdate = param.getId() != null && param.getId() > 0;
        SysDeptExample checkExp = new SysDeptExample();
        SysDeptExample.Criteria criteria = checkExp.createCriteria();
        criteria.andNameEqualTo(param.getName());
        if (isUpdate) {
            criteria.andIdNotEqualTo(param.getId());
        }
        if (sysDeptDao.countByExample(checkExp) > 0) {
            throw new IllegalArgumentException("该名称已存在！");
        }

        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(param, sysDept);
        sysDept.setPath(getPathByPid(sysDept.getParentId()));
        if (isUpdate) {
            SysDept old = sysDeptDao.selectByPrimaryKey(param.getId());
            if (T.isNull(old)) {
                throw new IllegalArgumentException("该记录不存在！");
            }
            sysDept.setCreateTime(old.getCreateTime());
            sysDept.setCreator(old.getCreator());
            sysDept.setUpdater(AuthenticationUtil.getUserName());
            sysDept.setUpdateTime(new Date());
            sysDeptDao.updateByPrimaryKey(sysDept);

            if (!Objects.equals(old.getParentId(), sysDept.getParentId())) {
                //更新其他以当前菜单为父菜单的path
                SysDeptExample example = new SysDeptExample();
                example.createCriteria().andIdNotEqualTo(sysDept.getId()).andPathLike(old.getPath() + Delimiters.DOT + old.getId() + "%");
                List<SysDept> sysDepts = sysDeptDao.selectByExample(example).stream()
                        .sorted(Comparator.comparing(e -> {
                            if (T.isBlank(e.getPath())) {
                                return 0;
                            }
                            String[] level = e.getPath().split("\\" + Delimiters.DOT);
                            return level.length;
                        })).collect(Collectors.toList());
                for (SysDept entity : sysDepts) {
                    updatePathById(entity.getId());
                }
            }
        } else {
            sysDept.setCreator(AuthenticationUtil.getUserName());
            sysDept.setCreateTime(new Date());
            int id = sysDeptDao.insert(sysDept);
            sysDept.setId(id);
        }
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        SysDept sysDept = sysDeptDao.selectByPrimaryKey(id);
        if (T.isNull(sysDept)) {
            throw new IllegalArgumentException("该记录不存在！");
        }
        SysUserExample exp = new SysUserExample();
        exp.createCriteria().andDeptIdEqualTo(id);
        long count = sysUserDao.countByExample(exp);
        if (count > 0) {
            throw new RuntimeException("该部门下还存在关联用户，不能删除！");
        }
        sysDeptDao.deleteByPrimaryKey(id);
    }

    private void updatePathById(Integer id) {
        SysDept sysDept = sysDeptDao.selectByPrimaryKey(id);
        if (T.isNull(sysDept)) {
            throw new IllegalArgumentException("该记录不存在！");
        }
        sysDept.setPath(getPathByPid(sysDept.getParentId()));
        sysDeptDao.updateByPrimaryKey(sysDept);
    }

    private String getPathByPid(Integer parentId) {
        String path = "0";
        if (Objects.nonNull(parentId) && parentId > 0) {
            SysDept parent = sysDeptDao.selectByPrimaryKey(parentId);
            if (T.isNull(parent)) {
                throw new IllegalArgumentException("找不到父级！");
            }
            String parentPath = parent.getPath();
            StringJoiner joiner = new StringJoiner(Delimiters.DOT);
            if (StringUtils.isNotBlank(parentPath)) {
                joiner.add(parentPath);
                String[] level = parentPath.split("\\" + Delimiters.DOT);
                Preconditions.checkState(level.length < 6, "最多只允许创建6层！");
            }
            joiner.add(String.valueOf(parent.getId()));
            path = joiner.toString();
        }
        return path;
    }
}
