package com.kaizhang;

import com.kaizhang.bean.Person;
import com.kaizhang.bean.Student;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @author ：kaizhang
 * @date ：2019/7/14 15:25
 * @description：懒加载测试Config
 */
@Configuration
public class LazyBeanConfig {

    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(value = "person")
    public Person person() {
        System.out.println("Person Bean: 不是懒加载时，ioc容器启动会调用方法创建对象");
        return new Person("person 测试scope", 23);
    }

    @Lazy
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean
    public Student student() {
        System.out.println("StudentBean: 是懒加载时，第一次获取会创建对象，以后则不会");
        return new Student("student 测试scope", 25);
    }
}
