package utils;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：kaizhang
 * @date ：2019/7/18 22:51
 * @description：
 */
public class ApplicationContextUtils {
    private static final Log log = LogFactory.get();

    /**
     * 由AnnotationConfigApplicationContext获取此注册表中定义的所有bean的名称
     *
     * @param applicationContext
     */
    public static void getBeanDefinitionNamesFromAnnotationConfigApplicationContext(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            log.info("beanName is: {}", name);
        }
    }
}
