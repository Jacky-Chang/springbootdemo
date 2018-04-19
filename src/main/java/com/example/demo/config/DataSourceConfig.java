package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by JackyChang on 2018/4/19.
 *
 */
@Configuration
@MapperScan(value = "com.example.demo.dao")
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    private static String jdbcUrl = "jdbc:mysql://10.37.251.224:3307/qding_demo";

    private static String userName = "dev";

    private static String password = "458kT*!W";

    @Bean
    public DataSource datasource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(100);
        dataSource.setMinIdle(15);
        dataSource.setMaxWait(60000);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        try {
            dataSource.setFilters("stat,log4j");
        } catch (SQLException e) {
            logger.info("MybatisConfig init dataSource setFilters error.", e);
        }
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigurationProperties(getProperties());
        sqlSessionFactoryBean.setMapperLocations(getMapperLocations());
        return sqlSessionFactoryBean;
    }

    private static Resource[] getMapperLocations(){
        return new Resource[]{
                new ClassPathResource("mapper/account.xml")};
    }

    private static Properties getProperties(){
        Properties properties = new Properties();
        properties.put("cacheEnabled", true);
        properties.put("useGeneratedKeys", true);
        properties.put("defaultExecutorType", "REUSE");
        properties.put("lazyLoadingEnabled", true);
        properties.put("defaultStatementTimeout", 25000);
        return properties;
    }
}
