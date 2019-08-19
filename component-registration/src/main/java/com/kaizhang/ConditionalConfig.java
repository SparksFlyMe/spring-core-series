package com.kaizhang;

import com.kaizhang.bean.Person;
import com.kaizhang.condition.LinuxCondition;
import com.kaizhang.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：kaizhang
 * @date ：2019/7/14 16:11
 * @description： @Conditional({Condition})注解：按照一定条件进行判断，满足条件则给容器中注册bean。
 *                  可以放在bean上，也可以放在类上，放在类上表示类中配置的所有bean注册才能生效
 */
//@Conditional(LinuxCondition.class)
@Configuration
public class ConditionalConfig {
    @Bean
    public Person person() {
        return new Person("lisi", 19);
    }

    @Conditional(value = {WindowsCondition.class})
    @Bean("bill")
    public Person person1() {
        return new Person("Bill Gates", 63);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean("linus")
    public Person person2() {
        return new Person("linus", 49);
    }
}
