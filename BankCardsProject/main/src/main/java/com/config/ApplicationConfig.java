package com.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:application.properties")
@ComponentScan("com")
public class ApplicationConfig {
    @Bean
    public ModelMapper getModelMapperBean(){
        return new ModelMapper();
    }

    @Bean
    public ObjectMapper getObjectMapperBean(){
        return new ObjectMapper();
    }
}
