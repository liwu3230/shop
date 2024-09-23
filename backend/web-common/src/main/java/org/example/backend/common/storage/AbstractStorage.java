package org.example.backend.common.storage;

import cn.hutool.core.io.FileUtil;
import org.example.backend.common.storage.config.PutObjectResult;
import org.example.backend.common.util.T;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/23 14:34
 */
public abstract class AbstractStorage implements FileStorage {

    protected PutObjectResult buildPutObjectResult(MultipartFile file){
        String oriFileName = T.toString(file.getOriginalFilename(), "");
        String suffix = FileUtil.getSuffix(oriFileName);
        String objectKey = T.UUID();

        PutObjectResult putObjectResult = new PutObjectResult();
        putObjectResult.setObjectKey(objectKey);
        putObjectResult.setOriginalFileName(oriFileName);
        putObjectResult.setSuffix(suffix);
        return putObjectResult;
    }


}
