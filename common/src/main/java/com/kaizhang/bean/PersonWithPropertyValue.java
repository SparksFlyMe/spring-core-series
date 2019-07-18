package com.kaizhang.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ：kaizhang
 * @date ：2019/7/18 23:07
 * @description：属性赋值测试实体
 */

@Data
public class PersonWithPropertyValue {
    /**
     * 姓名
     * 使用@value赋值：
     * 1、基本数值
     * 2、SpEL：#{}
     * 3、可以写${}：取出配置文件【properties】中的值（在运行环境变量里面的值）
     */
    @Value("王五")
    private String name;

    /**
     * 年龄
     */
    @Value("#{20-8}")
    private Integer age;

    /**
     * 昵称
     */
    @Value("${personWithPropertyValue.nickName}")
    private String nickName;

}
