package com.learn.docker.firstrun.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class FirstRunConfig {

    @Value("${spring.datasource.url}")
    private String dbURL;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String dbDriverClassName;

    @Bean
    public DataSource createDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(this.dbURL);
        basicDataSource.setUsername(this.dbUsername);
        basicDataSource.setPassword(this.dbPassword);
        basicDataSource.setDriverClassName(this.dbDriverClassName);
        basicDataSource.setMaxTotal(10);
        basicDataSource.setMinIdle(1);
        basicDataSource.setMaxIdle(2);
        return basicDataSource;
    }

    @Bean
    public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

}
