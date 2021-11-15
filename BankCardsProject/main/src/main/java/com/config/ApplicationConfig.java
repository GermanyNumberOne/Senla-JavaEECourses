package com.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfig {
    @Bean
    public Connection getConnection() throws SQLException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("liquibase");
        return DriverManager.getConnection(resourceBundle.getString("url"), resourceBundle.getString("username"), resourceBundle.getString("password"));
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
