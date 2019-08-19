package com.kaizhang.config;

import com.kaizhang.bean.Car;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.*;

/**
 * @author ：kaizhang
 * @date ：2019/8/10 14:47
 *
 * 扩展原理：
 * BeanPostProcessor：bean后置处理器，bean创建对象初始化前后进行拦截工作的
 * 1、BeanFactoryPostProcessor：beanFactory的后置处理器，在BeanFactory标准初始化之后调用，所有的bean定义已经保存加载到beanFactory，但是bean的实例还未创建
 *       1）、ioc容器创建对象
 *       2）、invokeBeanFactoryPostProcessors(beanFactory);执行BeanFactoryPostProcessors
 *           如何找到所有BeanFactoryPostProcessor并执行他们的方法：
 *              1）、直接在BeanFactory中找到所有类型是BeanFactoryPostProcessor的组件，并执行他们的方法
 *              2）、在初始化创建其他组件前面执行
 *
 * 2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *      1）、使用：
 *          postProcessBeanDefinitionRegistry();
 *          在所有bean定义信息将要被加载，bean实例还未创建。优先于BeanFactoryPostProcessor执行，
 *          利用BeanDefinitionRegistryPostProcessor给容器中再额外添加一些组件{@link MyBeanDefinitionRegistryPostProcessor}
 *      2）、原理：
 *          1）、ioc创建对象
 *          2）、refresh()->invokeBeanFactoryPostProcessors(beanFactory);
 *          3）、从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件{@link PostProcessorRegistrationDelegate#invokeBeanFactoryPostProcessors(org.springframework.beans.factory.config.ConfigurableListableBeanFactory, java.util.List)}。
 *              1、依次触发所有的postProcessBeanDefinitionRegistry({@link BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry(org.springframework.beans.factory.support.BeanDefinitionRegistry)})
 *              2、再来触发postProcessBeanFactory({@link PostProcessorRegistrationDelegate#invokeBeanFactoryPostProcessors(java.util.Collection, org.springframework.beans.factory.config.ConfigurableListableBeanFactory)})
 *          4）、再来从容器中找到BeanFactoryPostProcessor组件，然后依次触发postProcessBeanFactory()方法
 *
 * 3、ApplicationListener：监听容器中发布的事件。事件驱动模型开发；
 *      public interface ApplicationListener<E extends ApplicationEvent> extends EventListener
 *      监听ApplicationEvent及其下面的子事件
 *      步骤：
 *          1）、写一个监听器，来监听某个事件（ApplicationEvent及其子类）
 *              两种方式：① 实现{@link ApplicationListener} 接口。eg:{@link com.kaizhang.config.MyApplicationListener}
 *                      ② 在方法上添加@EventListener注解。eg:{@link MyEventListenerByAnnotation}
 *          2）、把监听器加入到容器中
 *          3）、只要容器中有相关事件的发布，我们就能监听到这个事件；
 *              ContextRefreshedEvent：容器刷新完成（所有bean都完全创建）会发布这个事件
 *              ContextClosedEvent：容器关闭会发布这个事件
 *          4）、发布一个事件
 *              applicationContext。publishEvent();
 *       原理：
 *          1）、容器创建对象：refresh();
 *          2）、finishRefresh();容器刷新完成
 *          3）、publishEvent(new ContextRefreshedEvent(this));
 *              事件发布流程：
 *                  1）、获取事件的多播器（播发器）：getApplicationEventMulticaster()
 *                  2）、multicastEvent派发事件：
 *                  3）、获取到所有的ApplicationListener;
 *                      for (ApplicationListener<?> listener : getApplicationListeners(event, type))
 *                      1）、如果有Executor，可以支持使用Executor进行异步派发
 *                          Executor executor = getTaskExecutor();
 *                      2）、否则同步的方式直接执行listener方法；invokeListener(listener, event);
 *                          拿到listener回调onApplicationEvent
 *                          invokeListener(listener, event)--》doInvokeListener(listener, event)--》listener.onApplicationEvent(event);
 */
@ComponentScan("com.kaizhang")
@Configuration
public class ExtendConfig {

    @Bean
    public Car car() {
        return new Car();
    }

}
