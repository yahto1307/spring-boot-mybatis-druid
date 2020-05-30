//package com.yahto.hydra.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * Created by yahto on 2019-05-27 17:01
// *
// * @author yahto
// */
//@Configuration
//@Slf4j
//public class DruidConfig {
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Value("${spring.datasource.url}")
//    private String url;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.type}")
//    private String dbType;
//
//    @Value("${spring.datasource.max-active}")
//    private Integer maxActive;
//
//    @Value("${spring.datasource.initial-size}")
//    private Integer initialSize;
//
//    @Value("${spring.datasource.min-idle}")
//    private Integer minIdle;
//
//    @Value("${spring.datasource.max-wait}")
//    private Long maxWait;
//
//    @Value("${spring.datasource.time-between-eviction-runs-millis}")
//    private Integer timeBetweenEvictionRunsMillis;
//
//    @Value("${spring.datasource.min-evictable-idle-time-millis}")
//    private Integer minEvictableIdleTimeMillis;
//
//    @Value("${spring.datasource.validation-query}")
//    private String validationQuery;
//
//    @Value("${spring.datasource.test-while-idle}")
//    private Boolean testWhileIdle;
//
//    @Value("${spring.datasource.test-on-borrow}")
//    private Boolean testOnBorrow;
//
//    @Value("${spring.datasource.test-on-return}")
//    private Boolean testOnReturn;
//
//    @Bean(name = "druidDataSource")
//    @Primary
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setUrl(url);
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setDbType(dbType);
//        dataSource.setMaxActive(maxActive);
//        dataSource.setMaxWait(maxWait);
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        dataSource.setValidationQuery(validationQuery);
//        dataSource.setTestWhileIdle(testWhileIdle);
//        dataSource.setTestOnBorrow(testOnBorrow);
//        dataSource.setTestOnReturn(testOnReturn);
//        return dataSource;
//    }
//
//
//    @Bean
//    @Primary
//    public DataSourceTransactionManager transactionManager(@Qualifier("druidDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//}
