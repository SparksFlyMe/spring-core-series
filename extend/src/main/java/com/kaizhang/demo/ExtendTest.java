package com.kaizhang.demo;

import com.kaizhang.config.ExtendConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：kaizhang
 * @date ：2019/8/10 15:09
 */
public class ExtendTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtendConfig.class);
//        applicationContext.getBean(MyBeanFactoryPostProcessor.class);
        applicationContext.close();
    }
}
