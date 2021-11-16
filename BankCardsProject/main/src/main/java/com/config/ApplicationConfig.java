package com.config;

import com.connection.MyConnectionHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:liquibase.properties")
public class ApplicationConfig {
    @Bean
    public Connection getConnection(@Value("${url}") String url, @Value("${name}") String username, @Value("${password}") String password) throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    @Bean
    public ModelMapper getMMbean(){
        return new ModelMapper();
    }

    @Bean
    public ObjectMapper getOMbean(){
        return new ObjectMapper();
    }
}
