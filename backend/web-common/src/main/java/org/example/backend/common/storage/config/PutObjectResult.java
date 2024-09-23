package org.example.backend.common.storage.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/3/28 17:37
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutObjectResult {

    private String objectKey;
    private String originalFileName;
    private String suffix;
    private String path;
    private String snapshotPath;
    private String downloadUrl;

}
