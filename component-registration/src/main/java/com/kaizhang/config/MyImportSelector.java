package com.kaizhang.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ：kaizhang
 * @date ：2019/7/14 21:04
 * @description：  自定义MyImportSelector实现ImportSelector，返回需要导入的组件的全类名数据组。beanName就是全类名
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值，就是导入容器中的组件全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 方法不要返回null，否则容器运行时会报空指针
        return new String[]{"com.kaizhang.bean.Student"};
    }
}
