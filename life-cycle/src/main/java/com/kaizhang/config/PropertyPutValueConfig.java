package com.kaizhang.config;

import com.kaizhang.bean.PersonWithPropertyValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author ：kaizhang
 * @date ：2019/7/18 22:46
 * @description：属性赋值配置类
 */

// 使用@PropertySource读取外部配置文件的key/value保存到运行的环境变量中
@PropertySource(value = {"classpath:/personWithPropertyValue.properties"})
@Configuration
public class PropertyPutValueConfig {
    @Bean
    public PersonWithPropertyValue personWithPropertyValue() {
        return new PersonWithPropertyValue();
    }
}
