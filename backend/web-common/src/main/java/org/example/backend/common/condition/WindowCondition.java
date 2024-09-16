package org.example.backend.common.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/6/11 16:21
 */
public class WindowCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        String osName = System.getProperty("os.name");

        boolean flag = osName.toLowerCase().contains("window") || osName.toLowerCase().contains("mac");
        return flag;
    }
}
