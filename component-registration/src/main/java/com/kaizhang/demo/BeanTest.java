package com.kaizhang.demo;

import com.kaizhang.bean.Person;
import com.kaizhang.BeanConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ：kaizhang
 * @date ：2019/7/7 16:06
 * @description：测试类
 */

public class BeanTest {

    /**
     * 从配置文件中读取属性
     */
    @Test
    public void testXmlConfig() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

    /**
     * 从注解中读取属性--Person
     */
    @Test
    public void testAnnotationBean() {
        // 配置类 == 配置文件： MainConfig == xml文件
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        // 通过类获取 类型为返回值的类型，id默认是方法名作为id
        Person person = context.getBean(Person.class);
        System.out.println(person);

        Person person1 = (Person) context.getBean("person1");
        System.out.println(person1);

        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }
}
