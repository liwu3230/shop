package org.example.backend.common.service;

import org.example.backend.common.model.Page;
import org.example.backend.common.model.param.SysAttachmentParam;
import org.example.backend.common.primary.entity.SysAttachment;
import org.example.backend.common.storage.config.FileModuleType;
import org.example.backend.common.storage.config.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/23 9:15
 */
public interface FileStorageService {

    Page<SysAttachment> listAttByPage(SysAttachmentParam req);

    PutObjectResult upload(MultipartFile file, FileModuleType bizType, Integer pid) throws Exception;

    void delete(Long attId) throws Exception;

    void deleteByAttIds(List<Long> attIds) throws Exception;

    SysAttachment getAttachmentByKey(String objectKey) throws Exception;

    void updateFileName(Long attId, String realName);

    void updatePidByAttIds(List<Long> attIds, Integer pid);

}
