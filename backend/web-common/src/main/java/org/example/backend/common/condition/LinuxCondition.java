package org.example.backend.common.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/6/11 16:21
 */
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        boolean flag = false;
        String osName = System.getProperty("os.name");

        if (osName.toLowerCase().contains("linux")) {
            flag = true;
        }
        return flag;
    }
}
