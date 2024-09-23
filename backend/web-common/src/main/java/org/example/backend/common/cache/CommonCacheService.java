package org.example.backend.common.cache;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.util.T;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/17 16:25
 */
@Slf4j
@Service
public class CommonCacheService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static final String CACHE_LIST_KEY = "menuList";

    public static final Map<String, Long> CACHE_EXPIRE_CONFIG_MAP = new HashMap<String, Long>() {
        {
            put(CACHE_LIST_KEY, 3600L);
        }
    };

    public static final Map<String, Cache<String, Object>> allCacheMap = new ConcurrentHashMap<>();

    private Cache<String, Object> getLoadingCache(String key) {
        long expireSeconds = CACHE_EXPIRE_CONFIG_MAP.getOrDefault(key, 3600L);
        allCacheMap.putIfAbsent(key, CacheBuilder.newBuilder()
                .expireAfterWrite(expireSeconds, TimeUnit.SECONDS).build());
        return allCacheMap.get(key);
    }

    public <V> V getCacheByKey(String key, TypeReference<V> type) {
        Cache<String, Object> caches = getLoadingCache(key);
        if (T.isNull(caches)) {
            return null;
        }
        Object obj = caches.getIfPresent(key);
        if (obj == null) {
            return null;
        }
        return MAPPER.convertValue(obj, type);
    }

    public void putCache(String key, Object value) {
        Cache<String, Object> caches = getLoadingCache(key);
        caches.put(key, value);
    }

    public void deleteByKey(String key) {
        Cache<String, Object> caches = getLoadingCache(key);
        if (T.nonNull(caches)) {
            caches.invalidate(key);
        }
    }

}
