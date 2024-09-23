package org.example.backend.common.service.impl;

import cn.hutool.core.io.FileUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.primary.base.dao.SysAttachmentDao;
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

import java.util.Date;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/23 9:15
 */
@Slf4j
@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Resource
    SysAttachmentDao sysAttachmentDao;
    @Resource
    FileStorageHandler fileStorageHandler;

    @Override
    public SysAttachment getAttachmentByKey(String objectKey) throws Exception {
        SysAttachmentExample example = new SysAttachmentExample();
        example.createCriteria().andNameEqualTo(objectKey);
        return T.findFirst(sysAttachmentDao.selectByExample(example));
    }

    @Override
    public void delete(Long attId) throws Exception {
        SysAttachment attachment = sysAttachmentDao.selectByPrimaryKey(attId);
        if (attachment == null) {
            throw new RuntimeException("文件不存在");
        }
        fileStorageHandler.getStorage().delete(attachment);
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
            attachment.setCreateTime(new Date());
            attachment.setUserName(AuthenticationUtil.getUserName());
            sysAttachmentDao.insert(attachment);

            return putObjectResult;
        } catch (Exception e) {
            log.error("saveFile error", e);
            throw new RuntimeException("文件上传失败！", e);
        }
    }

}
