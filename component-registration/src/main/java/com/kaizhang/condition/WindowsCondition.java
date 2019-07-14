package com.kaizhang.condition;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author ：kaizhang
 * @date ：2019/7/14 16:22
 * @description： 判断是否是windows系统
 */
public class WindowsCondition implements Condition {
    /**
     *
     * @param context 判断条件能使用的上下文（环境）
     * @param metadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        return StringUtils.isNotEmpty(property) && property.contains("Windows");
    }
}
