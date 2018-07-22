package com.aouty.area.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @author Aouty
 * @date 2018-07-21 22:08
 * @description service层事务管理
 */

@Configuration //告诉Spring，这是一个配置类
@EnableTransactionManagement  //开启事务管理
public class MyTransactionManagementConfigurer implements TransactionManagementConfigurer {

    /**
     * 需要实现TransactionManagementConfigurer接口,
     * 并重写annotationDrivenTransactionManager方法
     */

    @Autowired
    private DataSource dataSource;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
