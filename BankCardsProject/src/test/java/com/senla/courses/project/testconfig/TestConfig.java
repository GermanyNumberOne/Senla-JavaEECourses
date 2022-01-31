package com.senla.courses.project.testconfig;

import com.senla.courses.project.config.ApplicationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import liquibase.integration.spring.SpringLiquibase;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:h2.properties")
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(value = "com",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {ApplicationConfig.class}))
public class TestConfig {
    @Value("${h2.driver}")
    private String dbDriver;
    @Value("${h2.url}")
    private String dbUrl;
    @Value("${h2.username}")
    private String dbUsername;
    @Value("${h2.password}")
    private String dbPassword;
    @Value("${liquibase.changelog}")
    private String liquibase;

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(dbDriver);
        driverManagerDataSource.setUrl(dbUrl);
        driverManagerDataSource.setUsername(dbUsername);
        driverManagerDataSource.setPassword(dbPassword);

        return driverManagerDataSource;
    }

    @Bean
    public TransactionManager getTransactionManager() throws Exception {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(getLocalContainerEntityManagerFactoryBean().getObject());

        return  jpaTransactionManager;
    }

    @Bean
    public SpringLiquibase springLiquibase(){
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog(liquibase);
        springLiquibase.setDataSource(getDataSource());

        return springLiquibase;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(getDataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.model");


        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaProperties(additionalJPAProperties());

        return localContainerEntityManagerFactoryBean;
    }

    public Properties additionalJPAProperties() {
        Properties properties = new Properties();


        //properties.setProperty("hibernate.hdb2ddl.auto", "create-drop");
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        return properties;
    }

}
