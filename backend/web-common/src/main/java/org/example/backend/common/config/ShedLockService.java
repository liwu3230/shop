package org.example.backend.common.config;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.LockConfiguration;
import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.core.SimpleLock;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.MILLIS;

/**
 * @Description: 分布式锁调度
 * @Author: liwu3
 * @Date: 2021/12/24 11:52
 */
@Slf4j
@Component
public class ShedLockService {

    @Resource
    private LockProvider lockProvider;

    public void startCronTask(String name, long lockAtMostLen, long lockAtLeastLen, ShedCronTaskFunction shedCronTaskFunction) {
        Instant now = Instant.now();
        LockConfiguration configuration = new LockConfiguration(name, now.plus(lockAtMostLen, MILLIS), now.plus(lockAtLeastLen, MILLIS));
        Optional<SimpleLock> optional = lockProvider.lock(configuration);
        if (optional.isPresent()) {
            try {
                shedCronTaskFunction.run();
            } catch (Throwable e) {
                log.error("cronTask [{}] execute error ", name, e);
                throw e;
            } finally {
                optional.get().unlock();
            }
        } else {
            //log.info("lock failure, taskName={}", name);
        }
    }
}
