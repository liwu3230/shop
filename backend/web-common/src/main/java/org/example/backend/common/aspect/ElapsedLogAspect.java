package org.example.backend.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/6/11 16:21
 */
@Slf4j
@Component
@Aspect
public class ElapsedLogAspect {

    @Around("@annotation(org.example.backend.common.aspect.ElapsedLog)")
    public Object doMetricProcess(ProceedingJoinPoint joinPoint) throws Throwable {
        final long startMs = System.currentTimeMillis();
        Signature sign = joinPoint.getSignature();
        String name = sign.getDeclaringTypeName() + "#" + sign.getName();
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            log.error("invoke method filter failed by ", e);
            throw e;
        } finally {
            log.info("current method [{}] invoke elapsed {} milliseconds!", name, System.currentTimeMillis() - startMs);
        }
    }

}
