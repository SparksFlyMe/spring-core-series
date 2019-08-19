package com.kaizhang.demo;

import com.kaizhang.bean.PersonWithPropertyValue;
import com.kaizhang.PropertyPutValueConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import utils.ApplicationContextUtils;

/**
 * @author ：kaizhang
 * @date ：2019/7/18 22:48
 * @description：属性赋值测试类
 */
public class PropertyPutValueTest {

    @Test
    public void propertyPutValueTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PropertyPutValueConfig.class);
        ApplicationContextUtils.getBeanDefinitionNamesFromAnnotationConfigApplicationContext(applicationContext);

        PersonWithPropertyValue personWithPropertyValue = applicationContext.getBean(PersonWithPropertyValue.class);
        System.out.println(personWithPropertyValue);
    }
}
