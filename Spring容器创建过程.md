#### 1、Spring容器的refresh()【创建刷新】;

##### 	1、prepareRefresh()刷新前的预处理：

```
    1）、initPropertySources()，初始化一些属性设置；子类自定义个性化的属性设置；
	2）、getEnvironment().validateRequiredProperties()，检验属性的合法性等
    3）、earlyApplicationListeners = new LinkedHashSet<>(this.applicationListeners)，
    	保存容 器中的一些早期的事件
```

##### 	2、ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory()，获取BeanFactory；

```
	1）、refreshBeanFactory()，刷新BeanFactory；
        创建了一个beanFactory：this.beanFactory = new DefaultListableBeanFactory()；
        设置id：this.beanFactory.setSerializationId(getId());
    2）、getBeanFactory();返回刚才GenericApplicationContext创建的BeanFactory对象；
```

​    

##### 	3、prepareBeanFactory(beanFactory)，BeanFactory的预准备工作（BeanFactory进行一些设置）

```
    1）、设置BeanFactory的类加载器、支持表达式解析器...
    2）、添加部分BeanPostProcessor【ApplicationContextAwareProcessor】
    3）、设置忽略的自动装配的接口EnvironmentAware、EmbeddedValueResolverAware、
        ResourceLoaderAware、xxx
        这些接口的实现类不能通过接口类型来自动注入
    4）、注册可以解析的自动装配；我们能直接在任何组件中自动注入；BeanFactory、ResourceLoader、 
        ApplicationEventPublisher、ApplicationContext
    5）、添加BeanPostProcessor【ApplicationListenerDetector】
    6）、添加编译时的AspectJ;
    7）、给BeanFactory中注册一些能用的组件；
        environment【ConfigurableEnvironment】
        systemProperties【Map<String, Object>】
        systemEnvironment【Map<String, Object>】
```

##### 	4、postProcessBeanFactory(beanFactory)，BeanFactory准备工作完成后进行的后置处理工作

```
    1)、子类通过重写这个方法在BeanFactory创建并预准备完成以后做进一步的设置
```

##### 		======================以上是BeanFactory的创建及预准备工作=======================

#####  	5、invokeBeanFactoryPostProcessors(beanFactory)；执行BeanFactoryPostProcessors的方法；

​			BeanFactoryPostProcessors：BeanFactory的后置处理器。在BeanFactory标准初始化之后执行的

​			两个接口：BeanFactoryPostProcessor、BeanDefinitionRegistryPostProcessor

```
    1）、执行BeanFactoryPostProcessor的方法
        先执行BeanDefinitionRegistryPostProcessor
        1）、获取所有的BeanDefinitionRegistryPostProcessor；
        2）、先执行实现了PriorityOrdered顺序接口的BeanDefinitionRegistryPostProcessor，
            接着执行postProcessor.postProcessBeanDefinitionRegistry(registry);
        3）、再执行实现了Ordered顺序接口的BeanDefinitionRegistryPostProcessor，
            接着执行postProcessor.postProcessBeanDefinitionRegistry(registry);
        4）、最后执行没有实现任何优先级或者是顺序接口的BeanDefinitionRegistryPostProcessor，
            接着执行postProcessor.postProcessBeanDefinitionRegistry(registry);

        再执行BeanFactoryPostProcessor
        1）、获取所有的BeanFactoryPostProcessor；
        2）、先执行实现了PriorityOrdered顺序接口的BeanFactoryPostProcessor，
            接着执行postProcessor.postProcessBeanFactory(beanFactory);
        3）、再执行实现了Ordered顺序接口的BeanFactoryPostProcessor，
            接着执行postProcessor.postProcessBeanFactory(beanFactory);
        4）、最后执行没有实现任何优先级或者是顺序接口的BeanFactoryPostProcessor，
            接着执行postProcessor.postProcessBeanFactory(beanFactory);
	
```

##### 6、registerBeanPostProcessors(beanFactory);注册BeanPostProcessors（Bean的后置处理器）【作用：			intercept bean creation】

```
	1）、获取所有的BeanPostProcessor
```

