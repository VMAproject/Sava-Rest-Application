package com.sava.config;


import javax.sql.DataSource;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j;
import org.hibernate.jpa.HibernatePersistenceProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.sava.repository")
@EnableTransactionManagement
public class JpaConfiguration {

    private static final String PERSISTENCE_UNIT_NAME = "spring_domain";

    private static final String DOMAIN_ROOT_PACKAGE = "com.sava";

    @Value("${spring.jpa.database-platf" +
            "orm}")
    private String hibernateDialect;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource());
        lcemfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        lcemfb.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        lcemfb.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
        lcemfb.setPackagesToScan(DOMAIN_ROOT_PACKAGE);
        lcemfb.setJpaProperties(jpaProperties());
        return lcemfb;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws SQLException {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }

    @Bean
    public Properties jpaProperties() {
        Properties jpaProps = new Properties();
        jpaProps.put("hibernate.dialect", hibernateDialect);
        jpaProps.put("hibernate.hbm2ddl.auto", "update");
        return jpaProps;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

