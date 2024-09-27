package org.example.backend.common.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.Page;
import org.example.backend.common.model.param.SysAttachmentParam;
import org.example.backend.common.primary.dao.ISysAttachmentDao;
import org.example.backend.common.primary.entity.SysAttachment;
import org.example.backend.common.primary.entity.SysAttachmentExample;
import org.example.backend.common.security.utils.AuthenticationUtil;
import org.example.backend.common.service.FileStorageService;
import org.example.backend.common.storage.FileStorage;
import org.example.backend.common.storage.FileStorageHandler;
import org.example.backend.common.storage.config.FileModuleType;
import org.example.backend.common.storage.config.PutObjectResult;
import org.example.backend.common.util.T;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/23 9:15
 */
@Slf4j
@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Resource
    ISysAttachmentDao iSysAttachmentDao;
    @Resource
    FileStorageHandler fileStorageHandler;

    @Override
    public Page<SysAttachment> listAttByPage(SysAttachmentParam req) {
        SysAttachmentExample example = new SysAttachmentExample();
        SysAttachmentExample.Criteria criteria = example.createCriteria();
        if (T.GT(req.getPid(), 0)) {
            criteria.andPidEqualTo(req.getPid());
        }
        long count = iSysAttachmentDao.countByExample(example);
        example.setLimit(req.getLimit());
        example.setOffset(req.getOffset());
        example.setOrderByClause(" create_time desc");
        List<SysAttachment> list = iSysAttachmentDao.selectByExample(example);
        if (T.isEmpty(list)) {
            return new Page<>(Collections.emptyList(), req.getPage(), req.getLimit(), count);
        }
        return new Page<>(list, req.getPage(), req.getLimit(), count);
    }

    @Override
    public SysAttachment getAttachmentByKey(String objectKey) throws Exception {
        SysAttachmentExample example = new SysAttachmentExample();
        example.createCriteria().andNameEqualTo(objectKey);
        return T.findFirst(iSysAttachmentDao.selectByExample(example));
    }

    @Override
    public void updateFileName(Long attId, String realName) {
        SysAttachment attachment = iSysAttachmentDao.selectByPrimaryKey(attId);
        if (attachment == null) {
            throw new RuntimeException("文件不存在");
        }
        attachment.setRealName(realName);
        attachment.setUpdateTime(new Date());
        iSysAttachmentDao.updateByPrimaryKey(attachment);
    }

    @Override
    public void updatePidByAttIds(List<Long> attIds, Integer pid) {
        iSysAttachmentDao.updatePidByAttIds(attIds, pid);
    }

    @Override
    public void delete(Long attId) throws Exception {
        SysAttachment attachment = iSysAttachmentDao.selectByPrimaryKey(attId);
        if (attachment == null) {
            throw new RuntimeException("文件不存在");
        }
        fileStorageHandler.getStorage().delete(attachment);
        iSysAttachmentDao.deleteByPrimaryKey(attId);
    }

    @Override
    public void deleteByAttIds(List<Long> attIds) throws Exception {
        if (T.isEmpty(attIds)) {
            return;
        }
        for (Long attId : attIds) {
            SysAttachment attachment = iSysAttachmentDao.selectByPrimaryKey(attId);
            if (attachment == null) {
                continue;
            }
            fileStorageHandler.getStorage().delete(attachment);
            iSysAttachmentDao.deleteByPrimaryKey(attId);
        }
    }

    @Override
    public PutObjectResult upload(MultipartFile file, FileModuleType moduleType, Integer pid) throws Exception {

        try {
            int size = file.getInputStream().available();
            FileStorage fileStorage = fileStorageHandler.getStorage();
            PutObjectResult putObjectResult = fileStorage.upload(file, moduleType);

            SysAttachment attachment = new SysAttachment();
            attachment.setName(putObjectResult.getObjectKey());
            attachment.setRealName(putObjectResult.getOriginalFileName());
            attachment.setAttDir(putObjectResult.getPath());
            attachment.setSattDir(putObjectResult.getSnapshotPath());
            attachment.setAttSize((long) size);
            attachment.setAttType(putObjectResult.getSuffix());
            attachment.setPid(pid);
            attachment.setImageType(fileStorage.getType());
            attachment.setModuleType(moduleType.getValue());
            attachment.setDownloadUrl(putObjectResult.getDownloadUrl());
            attachment.setCreateTime(new Date());
            attachment.setUserName(AuthenticationUtil.getUserName());
            iSysAttachmentDao.insert(attachment);

            return putObjectResult;
        } catch (Exception e) {
            log.error("saveFile error", e);
            throw new RuntimeException("文件上传失败！", e);
        }
    }

}
