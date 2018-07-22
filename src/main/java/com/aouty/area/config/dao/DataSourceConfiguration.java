package com.aouty.area.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aouty
 * @date 2018-07-21 21:35
 * @description 数据库连接配置类(利用连接池连接上了数据库)
 */

/**
 * SSM 在xml里面做配置
 * SpringBoot在代码里面做配置
 *
 * @Configuration注解告诉Spring来到这个类检索相关的Bean Spring在初始化时就调用@Bean来注入Bean，进行数据库的一些操作
 */
@Configuration
@MapperScan("com.aouty.area.mapper") //扫描mapper接口类
public class DataSourceConfiguration {

    //使用@Value("${}"),可以获取application.properties中的属性值

    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;//驱动类

    @Value("${spring.datasource.url}")
    private String url;//连接字符串URL

    @Value("${spring.datasource.username}")
    private String username;//用户名

    @Value("${spring.datasource.password}")
    private String password;//密码

    @Bean(name = "dataSource")  //@Bean还有value属性，待研究
    public ComboPooledDataSource createDataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        //关闭连接后取消自动提交
        dataSource.setAutoCommitOnClose(false);

        //输入dataSource.return 此时IDEA会自动解析为return dataSource;
        return dataSource;
    }
}
