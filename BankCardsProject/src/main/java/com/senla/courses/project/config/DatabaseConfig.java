package com.senla.courses.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DatabaseConfig {
   /* @Value("${database.driver}")
    private String dbDriver;
    @Value("${database.url}")
    private String dbUrl;
    @Value("${database.username}")
    private String dbUsername;
    @Value("${database.password}")
    private String dbPassword;
    @Value("${hibernate.show_sql}")
    private String showSql;
    @Value("${hibernate.hdb2ddl.auto}")
    private String hdb2ddlAuto;
    @Value("${hibernate.dialect}")
    private String hibernateDialect;

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

        properties.setProperty("hibernate.hdb2ddl.auto", hdb2ddlAuto);
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.dialect", hibernateDialect);

        return properties;
    }
    */
}
