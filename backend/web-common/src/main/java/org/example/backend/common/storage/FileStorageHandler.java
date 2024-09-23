package org.example.backend.common.storage;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2023/3/2 11:33
 */
@Configuration
@SuppressWarnings("all")
public class FileStorageHandler implements ApplicationContextAware {

    private Map<String, FileStorage> storageMap = new HashMap<>(16);

    private ApplicationContext appContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    @Autowired
    public void setFileStorage(List<FileStorage> fileStorages) {
        if (CollectionUtils.isNotEmpty(fileStorages)) {
            for (FileStorage fileStorage : fileStorages) {
                storageMap.put(fileStorage.getClass().getSimpleName(), fileStorage);
            }
        }
    }

    public FileStorage getStorage() {
        FileStorage defaultStorage = appContext.getBean(LocalFileStorage.class);
        // todo 根据配置切换
        return defaultStorage;
    }
}
