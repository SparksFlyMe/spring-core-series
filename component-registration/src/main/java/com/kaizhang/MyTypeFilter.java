package com.kaizhang;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author ：kaizhang
 * @date ：2019/7/8 23:11
 * @description： 自定义TypeFilter，用在{@link com.kaizhang.ComponentScanConfig}
 */


/**
 * metadataReader：读取到当前正在扫描的类的信息
 * metadataReaderFactory：可以获取到其他任何类信息的
 *
 */
public class MyTypeFilter implements TypeFilter {

    /**
     *
     * @param metadataReader 读取到当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他任何类信息的
     * @return boolean类型，返回true说明包含在内
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取当前类的注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类的资源（比如类的路径）
        Resource resource = metadataReader.getResource();

        Class<? extends MetadataReader> aClass = metadataReader.getClass();
        System.out.println("class: " + aClass);

        String className = classMetadata.getClassName();
        if (className.contains("er")) {
            System.out.println(className);
            return true;
        }
        return false;
    }
}
