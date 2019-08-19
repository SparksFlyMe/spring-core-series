package com.kaizhang.demo;

import com.kaizhang.bean.Person;
import com.kaizhang.ConditionalConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author ：kaizhang
 * @date ：2019/7/14 16:27
 * @description：
 * @Conditional:
 */
public class ConditionalTest {
    @Test
    public void conditionalTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionalConfig.class);
        Map<String, Person> personMap = applicationContext.getBeansOfType(Person.class);

        System.out.println(personMap);
    }
}
