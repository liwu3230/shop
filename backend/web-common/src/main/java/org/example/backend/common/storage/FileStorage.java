package org.example.backend.common.storage;

import org.example.backend.common.primary.entity.SysAttachment;
import org.example.backend.common.storage.config.FileModuleType;
import org.example.backend.common.storage.config.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/3/28 12:15
 */
public interface FileStorage {

    PutObjectResult upload(MultipartFile file, FileModuleType moduleType) throws Exception;

    void delete(SysAttachment attachment) throws Exception;

    int getType();

}
