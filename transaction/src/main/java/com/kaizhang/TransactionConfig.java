package com.kaizhang;

import com.kaizhang.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 声明式事务配置类
 *
 * @author ：kaizhang
 * @date ：2019/8/8 22:00
 *
 * 环境搭建：
 *      1、导入相关依赖
 *          数据源、数据库驱动、Spring-Jdbc模块
 *      2、配置数据源、jdbcTemplate（spring提供的简化数据库操作的工具）操作数据
 *      3、给方法上标注@Transactional，表示当前方法是一个事务方法；{@link UserService#insertUser()}
 *      4、@EnableTransactionManagement 开启给予注解的事务管理；（@EnableXXX，与之前aop一样开启某种功能）；{@link TransactionConfig}
 *      5、配置事务管理器来控制事务；{@link TransactionConfig#transactionManager()}
 */
@EnableTransactionManagement
@ComponentScan("com.kaizhang")
@Configuration
public class TransactionConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        // spring对@Configuration类会特殊处理；给容器中加组件的方法，多次调用都只是从容器中找组件获取
        return new JdbcTemplate(dataSource());
    }

    /**
     * 注册事务管理器在容器中
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
