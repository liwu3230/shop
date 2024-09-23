package org.example.backend.common.service.impl;

import com.google.common.base.Preconditions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.Page;
import org.example.backend.common.model.dto.SysAttCategoryTreeDto;
import org.example.backend.common.model.param.SysAttachmentCategoryParam;
import org.example.backend.common.model.param.SysAttachmentParam;
import org.example.backend.common.primary.base.dao.SysAttachmentCategoryDao;
import org.example.backend.common.primary.base.dao.SysAttachmentDao;
import org.example.backend.common.primary.entity.SysAttachment;
import org.example.backend.common.primary.entity.SysAttachmentCategory;
import org.example.backend.common.primary.entity.SysAttachmentCategoryExample;
import org.example.backend.common.primary.entity.SysAttachmentExample;
import org.example.backend.common.service.FileCategoryService;
import org.example.backend.common.util.T;
import org.example.backend.common.util.TreeBuildFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/23 15:29
 */
@Slf4j
@Service
public class FileCategoryServiceImpl implements FileCategoryService {

    @Resource
    SysAttachmentCategoryDao sysAttachmentCategoryDao;
    @Resource
    SysAttachmentDao sysAttachmentDao;

    @Override
    public Page<SysAttachment> listAttByPage(SysAttachmentParam req) {
        SysAttachmentExample example = new SysAttachmentExample();
        SysAttachmentExample.Criteria criteria = example.createCriteria();
        if (T.GT(req.getPid(), 0)) {
            criteria.andPidEqualTo(req.getPid());
        }
        long count = sysAttachmentDao.countByExample(example);
        example.setLimit(req.getLimit());
        example.setOffset(req.getOffset());
        example.setOrderByClause(" create_time desc");
        List<SysAttachment> list = sysAttachmentDao.selectByExample(example);
        if (T.isEmpty(list)) {
            return new Page<>(Collections.emptyList(), req.getPage(), req.getLimit(), count);
        }
        return new Page<>(list, req.getPage(), req.getLimit(), count);
    }

    @Override
    public List<SysAttCategoryTreeDto> listTree() {
        List<SysAttachmentCategory> list = sysAttachmentCategoryDao.selectByExample(null);
        List<SysAttCategoryTreeDto> dtoList = list.stream().map(entity -> {
            SysAttCategoryTreeDto dto = new SysAttCategoryTreeDto();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).collect(Collectors.toList());
        return TreeBuildFactory.transToTree(dtoList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOrUpdate(SysAttachmentCategoryParam req) {
        SysAttachmentCategory category = new SysAttachmentCategory();
        BeanUtils.copyProperties(req, category);
        validate(req);
        if (T.GT(category.getId(), 0)) {
            sysAttachmentCategoryDao.updateByPrimaryKey(category);
        } else {
            sysAttachmentCategoryDao.insert(category);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        SysAttachmentCategory category = sysAttachmentCategoryDao.selectByPrimaryKey(id);
        Preconditions.checkNotNull(category, "该分类不存在！");
        SysAttachmentExample example = new SysAttachmentExample();
        example.createCriteria().andPidEqualTo(id);
        long count = sysAttachmentDao.countByExample(example);
        Preconditions.checkState(count <= 0, "该分类下还存在附件！");
        sysAttachmentCategoryDao.deleteByPrimaryKey(id);
    }

    private void validate(SysAttachmentCategoryParam req) {
        SysAttachmentCategoryExample example = new SysAttachmentCategoryExample();
        SysAttachmentCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(req.getName());
        if (T.GT(req.getId(), 0)) {
            criteria.andIdNotEqualTo(req.getId());
        }
        long countName = sysAttachmentCategoryDao.countByExample(example);
        Preconditions.checkState(countName <= 0, "该分类名称已存在！");
    }

}
