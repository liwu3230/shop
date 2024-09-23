package org.example.backend.common.storage.config;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/3/28 17:51
 */
@Data
@ConfigurationProperties(prefix = "storage")
@Configuration
public class FileStorageProperties implements InitializingBean {

    private String platform;

    private String domain;
    private String localDir;
    private Integer thumbnailSize = 400;
    private String thumbnailFormat = "jpg";

    @NestedConfigurationProperty
    private StorageConf oss;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtils.isNotBlank(localDir)) {
            this.localDir = toRealPath(localDir);
            if (!this.localDir.endsWith(File.separator)) {
                this.localDir += File.separator;
            }
        }
    }

    private String toRealPath(String directory) throws IOException {
        Path path = Paths.get(directory);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
        return path.toRealPath().toString();
    }
}
