package com.kaizhang.config;

import com.kaizhang.bean.Person;
import com.kaizhang.demo.BeanTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kaizhang
 * @date ：2019/7/9 23:28
 * @description：bean注解参数 {@link BeanTest}
 */

// 配置类 == 配置文件
@Configuration // 告诉Spring这是一个配置文件
public class BeanConfig {

    @Bean // 给容器中注册一个Bean，类型为返回值的类型，id默认是方法名作为id，如果需要更改bean名称，可以通过添加（value=""）来修改
    public Person person1() {
        return new Person("lisi", 19);
    }
}
