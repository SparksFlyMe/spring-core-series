package com.kaizhang.demo;

import com.kaizhang.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：kaizhang
 * @date ：2019/7/23 23:42
 * @description：
 */
public class AopDemo {
    
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(8, 0);
    }
}
