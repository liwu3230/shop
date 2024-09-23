package org.example.backend.common.util;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/2 11:34
 */
@Slf4j
public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.warn("Task {} rejected from {}", r.toString(), executor.toString());
    }

}