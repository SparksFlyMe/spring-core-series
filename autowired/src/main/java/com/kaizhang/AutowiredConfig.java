package com.kaizhang;

import com.kaizhang.dao.BookDao;
import com.kaizhang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kaizhang
 * @date ：2019/7/21 16:12
 * @description：自动装配配置类 自动装配：Spring利用依赖注入（DI），完成对IOC容器中各种组件的依赖关系赋值
 * 1）、@Autowired：自动注入
 *      1、默认优先按照类型去容器中找对应的组件：applicationContext.getBean(BookDao.class);
 *      2、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找。
 *          即通过applicationContext.getBean("bookDao2")的方式去查找，这里bookDao2为 {@link BookService} 中注入的属性名bookDao2
 *      3、@Qualifier("bookDao)：使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 *      4、自动装配默认一定要将属性赋值好，没有就会报错。 @Autowired(required = true)，required默认为true，改为false后就不会报错
 *      5、@Primary：让Spring进行自动装配的时候，默认使用首先的bean，也可以继续使用@Qualifier指定需要装配的bean的名字
 *
 *          BookService{
 *              @Autowired
 *              BookDao bookDao;
 *          }
 *
 * 2）、Spring还支持使用@Resource（JSR250规范）和@Inject(JSR330规范)【java规范的注解】
 *      @Resource
 *          可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的，不支持@Primary,也不支持@Autowired（require=false）
 *      @Inject
 *          需要导入javax的包，和Autowired的功能一样。没有require=false的功能
 *
 * 3）、@Autowired：构造器（CONSTRUCTOR），参数（PARAMETER），方法（METHOD），属性（FIELD），注释类型（ANNOTATION_TYPE）
 *                  都能使用这个注解{@link Autowired}。且都是从容器中获取参数组件的值
 *                  1、标注在方法上：Spring容器创建当前对象，就会调用方法，完成赋值；方法使用的参数，自定义类型的值从ioc容器中获取
 *                  2、标注在构造器上：默认加载在ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作。
 *                     构造器要用的组件，都是从容器中获取。如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，
 *                     参数位置的组件还是可以自动从容器中获取。
 *                  3、放在参数位置
 */
@Configuration
@ComponentScan({"com.kaizhang.service", "com.kaizhang.dao", "com.kaizhang.bean"})
public class AutowiredConfig {

    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLable("2");
        return bookDao;
    }

}
