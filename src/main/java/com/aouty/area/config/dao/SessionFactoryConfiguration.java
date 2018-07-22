package com.aouty.area.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author Aouty
 * @date 2018-07-21 21:51
 * @description Session工厂配置类
 */
@Configuration
public class SessionFactoryConfiguration {
    //mybatis-config.xml配置文件的路径
    @Value("${mybatis_config_file}")
    private String mybaticConfigFilePath;

    //mybatic mapper.xml文件所在路径
    @Value("${mapper_path}")
    private String mybaticMapperXMLPath;

    //entity所在的路径
    @Value("${entity_package}")
    private String entityPackage;

    @Autowired
    @Qualifier(value = "dataSource")//@Qualifier注解表示按照别名加载
            DataSource dataSource;//javax.sql.DataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //mybatis配置文件路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybaticConfigFilePath));

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        String packageScanPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mybaticMapperXMLPath;
        //session工厂设置mapper.xml路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageScanPath));
        //session工厂设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //session工厂设置mapper.xml中表对应的entity路径
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);

        return sqlSessionFactoryBean;
    }

}
