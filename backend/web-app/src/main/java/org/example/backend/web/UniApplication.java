package org.example.backend.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/26 16:46
 */
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableAsync
@ComponentScan(basePackages = {"org.example"})
@EnableTransactionManagement
@SpringBootApplication
public class UniApplication {

    private final static Logger logger = LoggerFactory.getLogger(UniApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(UniApplication.class, args);
        logger.info(">>> " + UniApplication.class.getSimpleName() + " is success!");
    }

}
