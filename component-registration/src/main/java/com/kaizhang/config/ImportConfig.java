package com.kaizhang.config;

import com.kaizhang.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ：kaizhang
 * @date ：2019/7/14 18:18
 * @description： 通过@import注解给容器中添加组件, id默认为组件的全类名（e.g. :com.kaizhang.com.kaizhang.bean.Person）
 */
@Configuration
@Import({Person.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class ImportConfig {


    /*@Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }*/
}
