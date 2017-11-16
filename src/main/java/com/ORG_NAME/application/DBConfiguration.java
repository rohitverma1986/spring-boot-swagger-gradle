package com.ORG_NAME.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by UGAM\rohit.verma on 16/11/17.
 */
@Configuration
public class DBConfiguration {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    Environment env;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    public DataSource setDataSource() {
        System.out.println("---------------------------------Was called");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setUsername(env.getProperty("db.user"));
        dataSource.setPassword(env.getProperty("db.password"));
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
