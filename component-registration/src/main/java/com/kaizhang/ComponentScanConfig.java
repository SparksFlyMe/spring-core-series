package com.kaizhang;

import com.kaizhang.demo.ComponentScanTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author ：kaizhang
 * @date ：2019/7/7 16:46
 * @description： {@link ComponentScanTest}
 */


// 配置类 == 配置文件
@Configuration // 告诉Spring这是一个配置文件

/*@ComponentScan(value = "com.kaizhang",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {
        Controller.class, Service.class})}
        )*/

// includeFilters
/*
@ComponentScan(value = "com.kaizhang", useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class), @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = BeanTest.class)}
)
*/


// FilterType.CUSTOM 自定义扫描类型

@ComponentScan(value = "com.kaizhang", useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, value = MyTypeFilter.class)}
)



// @ComponentScan value: 指定要扫描的包
// excludeFilters: Filter[]：指定扫描的时候按照什么规则排除哪些组件
// includeFilters: Filter[]：指定扫描的时候只需要包含哪些组件
public class ComponentScanConfig {

}
