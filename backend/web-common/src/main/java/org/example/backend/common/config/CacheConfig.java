package org.example.backend.common.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.utils.CacheNames;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description: 默认使用redis，需要使用caffeine本地缓存可在注解中设置cacheManager参数
 * @Author: liwu3
 * @Date: 2021/6/22 15:59
 */
@Slf4j
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    public static final String REDIS = "redisCacheManager";
    public static final String CAFFEINE = "caffeineCacheManager";

//    @Bean(name = "redisTemplate")
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//        jackson2JsonRedisSerializer.setObjectMapper(mapper);
//        // 配置序列化
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        redisTemplate.setValueSerializer(stringRedisSerializer);
//        redisTemplate.setHashValueSerializer(stringRedisSerializer);
//        redisTemplate.setEnableTransactionSupport(true);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }

    @Bean(name = CAFFEINE)
    public CacheManager caffeineCacheManager() {
        return new SimpleCaffeineCacheManager();
    }

//    @Primary
//    @Bean(name = REDIS)
//    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        mapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//        jackson2JsonRedisSerializer.setObjectMapper(mapper);
//        //默认配置
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofSeconds(CacheNames.DEFAULT_TTL))
//                .computePrefixWith(cacheName -> CacheNames.REDIS_KEY_PREFIX + cacheName)
//                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer));
//        if (!CacheNames.CACHE_NULL_VALUES) {
//            config = config.disableCachingNullValues();
//        }
//        //对每个缓存空间应用不同的配置
//        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
//        for (Map.Entry<String, CacheNames.Config> entry : CacheNames.CACHE_EXPIRE_CONFIG_MAP.entrySet()) {
//            configMap.put(entry.getKey(), config.entryTtl(Duration.ofSeconds(entry.getValue().getDuration())));
//        }
//        RedisCacheManager cacheManager = RedisCacheManager
//                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
//                .cacheDefaults(config)
//                .initialCacheNames(configMap.keySet())
//                .withInitialCacheConfigurations(configMap)
//                .build();
//        return cacheManager;
//    }

    /**
     * 自定义key生成策略
     *
     * @return
     */
    @Override
    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName()).append(".");
            sb.append(method.getName()).append(".");
            String join = String.join("&", Arrays.stream(params).map(Object::toString)
                    .collect(Collectors.toList()));
            String format = String.format("%s{%s}", sb.toString(), join);
            log.debug("缓存key：" + format);
            return format;
        };
    }

    /**
     * 缓存异常处理
     *
     * @return
     */
    @Bean
    @Override
    public CacheErrorHandler errorHandler() {
        return new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException e, Cache cache, Object key) {
                log.error("缓存获取异常：" + key, e);
            }

            @Override
            public void handleCachePutError(RuntimeException e, Cache cache, Object key, Object value) {
                log.error("缓存添加异常：" + key, e);
            }

            @Override
            public void handleCacheEvictError(RuntimeException e, Cache cache, Object key) {
                log.error("缓存删除异常：" + key, e);
            }

            @Override
            public void handleCacheClearError(RuntimeException e, Cache cache) {
                log.error("缓存清理异常", e);
            }

        };
    }

    /**
     * Caffeine缓存配置
     */
    private static class SimpleCaffeineCacheManager extends SimpleCacheManager {

        @Override
        protected Cache getMissingCache(String name) {
            CacheNames.Config config = CacheNames.CACHE_EXPIRE_CONFIG_MAP.get(name);
            Caffeine<Object, Object> caffeineBuilder = Caffeine.newBuilder();
//                    //缓存写入/删除的通知回调
//                    .writer(new CacheWriter<Object, Object>() {
//
//                        @Override
//                        public void write(@NonNull Object key, @NonNull Object value) {
//                            log.debug("key={}, CacheWriter write", key);
//                        }
//
//                        @Override
//                        public void delete(@NonNull Object key, @Nullable Object value, @NonNull RemovalCause cause) {
//                            log.debug("key={}, cause={}, CacheWriter delete", key, cause);
//                        }
//
//                    })
//                    //记录缓存的统计数据
//                    .recordStats();
            if (Objects.nonNull(config)) {
                if (config.getDuration() > 0) {
                    caffeineBuilder.expireAfterWrite(config.getDuration(), TimeUnit.SECONDS);
                }
                return new CaffeineCache(name, caffeineBuilder
                        .maximumSize(config.getMaximumSize()).build());
            }
            //默认配置
            return new CaffeineCache(name, caffeineBuilder
                    .expireAfterWrite(CacheNames.DEFAULT_TTL, TimeUnit.SECONDS)
                    .maximumSize(CacheNames.DEFAULT_MAX_SIZE).build());
        }
    }


}