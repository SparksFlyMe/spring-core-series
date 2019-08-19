package com.kaizhang.demo;

import com.kaizhang.TransactionConfig;
import com.kaizhang.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：kaizhang
 * @date ：2019/8/10 10:42
 */
public class TransactionTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TransactionConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.insertUser();
    }
}
