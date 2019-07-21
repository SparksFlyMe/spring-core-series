package com.kaizhang.demo;

import com.kaizhang.bean.Student;
import com.kaizhang.config.AutowiredConfig;
import com.kaizhang.service.BookService;
import com.kaizhang.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：kaizhang
 * @date ：2019/7/21 16:42
 * @description：
 */
public class AutowiredDemo {
    @Test
    public void autowiredTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);

//        BookDao bookDao = applicationContext.getBean(BookDao.class);
        // 这里可以看到，上下文中获取的bookDao与上面bookService中的bookDao是同一个
//        System.out.println(bookDao);

        PersonService personService = applicationContext.getBean(PersonService.class);
        System.out.println(personService);
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student.hashCode());
        applicationContext.close();

    }
}
