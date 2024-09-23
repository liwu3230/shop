package org.example.backend.common.util;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/9/23 11:24
 */
public class CacheNames {

    /**
     * 本地缓存默认过期时间(单位:秒,-1永不过期)
     */
    public static final long DEFAULT_TTL = 120;

    /**
     * 本地缓存默认最大数量
     */
    public static final long DEFAULT_MAX_SIZE = 100000;

    /**
     * Redis缓存固定前缀
     */
    public static final String REDIS_KEY_PREFIX = "spring:cache:";

    /**
     * 是否缓存空值
     */
    public static final boolean CACHE_NULL_VALUES = false;

    public static final String USER_ROLE_IDS = "userRoleIds";
    public static final String URL_PERMISSIONS = "urlPermissions";

    /**
     * 缓存自定义配置，不配置的话则使用默认配置
     */
    public static final Map<String, Config> CACHE_EXPIRE_CONFIG_MAP = new HashMap<String, Config>() {
        {
            put(USER_ROLE_IDS, new Config(120));
        }
    };

    @Getter
    @Setter
    public static class Config {
        private long duration = DEFAULT_TTL;
        private long maximumSize = DEFAULT_MAX_SIZE;

        public Config() {
        }

        public Config(long duration) {
            this.duration = duration;
        }

        public Config(long duration, long maximumSize) {
            this.duration = duration;
            this.maximumSize = maximumSize;
        }

    }


}
