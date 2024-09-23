package org.example.backend.common.storage.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/3/28 17:47
 */
@Getter
@Setter
public class StorageConf {

    private String bucketName;
    private String endpoint;
    private String accessKey;
    private String secretKey;

}
