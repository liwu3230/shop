package org.example.backend.common.service;

import org.example.backend.common.primary.entity.SysAttachment;
import org.example.backend.common.storage.config.FileModuleType;
import org.example.backend.common.storage.config.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/23 9:15
 */
public interface FileStorageService {

    PutObjectResult upload(MultipartFile file, FileModuleType bizType, Integer pid) throws Exception;

    void delete(Long attId) throws Exception;

    SysAttachment getAttachmentByKey(String objectKey) throws Exception;

}
