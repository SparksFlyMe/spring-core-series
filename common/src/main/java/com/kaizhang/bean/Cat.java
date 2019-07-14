package com.kaizhang.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author ：kaizhang
 * @date ：2019/7/15 1:23
 * @description：
 */

@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat constructor...");
    }

    /**
     * 容器创建完成，并且属性都赋值完成后执行
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat...afterPropertiesSet...");
    }

    /**
     * 容器销毁时执行
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("cat...destroy...");
    }
}
