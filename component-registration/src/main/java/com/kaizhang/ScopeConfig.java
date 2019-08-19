package com.kaizhang;

import com.kaizhang.bean.Person;
import com.kaizhang.bean.Student;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author ：kaizhang
 * @date ：2019/7/10 22:52
 * @description： 作用域
 */
@Configuration
public class ScopeConfig {

    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * ConfigurableBeanFactory#SCOPE_SINGLETON
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * PROTOTYPE：多实例的：ioc容器启动并不会去调用方法创建对象放到容器中，每次获取的时候才会调用方法创建。
     * SINGLETON：单实例的(默认值)：ioc容器启动会调用方法创建对象放到ioc容器中，以后每次获取就是直接从容器中拿。
     * REQUEST：同一个请求创建一个实例
     * SESSION：同一个session创建一个实例
     */
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean(value = "person")
    public Person person() {
        System.out.println("当scope为单实例时，ioc容器启动会调用方法创建对象");
        return new Person("person 测试scope", 23);
    }

    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public Student student() {
        System.out.println("当scope为多实例时，每次获取的时候才会调用方法创建");
        return new Student("student 测试scope", 25);
    }
}
