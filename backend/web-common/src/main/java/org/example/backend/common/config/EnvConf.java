package org.example.backend.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/26 17:13
 */
@Component
public class EnvConf {

    @Value("${spring.profiles.active}")
    private String env;

    @Resource
    private Environment environment;

    public String getEnv() {
        return env;
    }

    public boolean isDev() {
        return "dev".equals(env);
    }

    public boolean isOnline() {
        return !isDev();
    }

    public static boolean isLocal() {
        String osName = System.getProperty("os.name");
        return osName.toLowerCase().contains("window") || osName.toLowerCase().contains("mac");
    }

    public String getEnvProperty(String key) {
        return environment.getProperty(key);
    }

}
