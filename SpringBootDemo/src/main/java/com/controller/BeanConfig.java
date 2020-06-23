package com.controller;
/*package controller;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.entity.EmployeeEntity;
import com.entity.GarmentDetail;
import com.entity.GarmentMain;
import com.entity.StrMain;
import com.entity.UsrMain;

@Configuration
@EntityScan("entity")
public class BeanConfig {

	@Value("${spring.datasource.driver-class-name}")
	public String driverClassName;
	@Value("${spring.datasource.url}")
	public String url;
	@Value("${spring.datasource.username}")
	public String userName;
	@Value("${spring.datasource.password}")
	public String password;
	@Value("${spring.jpa.properties.hibernate.dialect}")
	public String dialact;
	public String hbm2ddlAuto;
	
	
	@Bean
	public SessionFactory sessionFactory() {
		System.out.println("######################## Session Factory is going to Buid ########################");
		org.hibernate.cfg.Configuration configurration = new org.hibernate.cfg.Configuration();
		configurration.configure();
		configurration.addPackage("com.entity");

		//configurration.addPackage("entity");
		configurration.addAnnotatedClass(GarmentMain.class);
		configurration.addAnnotatedClass(GarmentDetail.class);
		configurration.addAnnotatedClass(StrMain.class);
		configurration.addAnnotatedClass(UsrMain.class);

		return configurration.buildSessionFactory();
	}
	
	
	@Bean
    public HibernateTransactionManager transactionManager() throws IOException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFacotry().getObject());
        return transactionManager;
    }

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUsername(userName);
		driverManagerDataSource.setPassword(password);
		System.out.println(url+" ===================url ");
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setDriverClassName(driverClassName);
		return driverManagerDataSource;
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean sessionFactory() throws IOException {
		LocalContainerEntityManagerFactoryBean localSessionFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setPackagesToScan("controller");
		 
		Properties properties = new Properties();
		properties.put("spring.jpa.properties.hibernate.dialect", dialact);
		properties.put("spring.jpa.hibernate.ddl-auto", "update");

		localSessionFactoryBean.setJpaProperties(properties);
		//localSessionFactoryBean.setPackagesToScan("controller");
		localSessionFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		localSessionFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		System.out.println(localSessionFactoryBean.getPersistenceUnitName() +" Persistence #####################");
		//localSessionFactoryBean.afterPropertiesSet();
		
		
		H2ConsoleProperties h2ConsoleProperties = new H2ConsoleProperties();
		h2ConsoleProperties.setEnabled(true);
		h2ConsoleProperties.setPath("h2-console");
		H2ConsoleAutoConfiguration h2ConsoleAutoConfiguration = new H2ConsoleAutoConfiguration(h2ConsoleProperties);
		
		return localSessionFactoryBean.gets;
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFacotry() {
	    return new HibernateJpaSessionFactoryBean();
	}
	
	@Bean
	public HibernateJpaSessionFactoryBean sessionFacotry() {
		return new HibernateJpaSessionFactoryBean();
	}
	
	@Bean
	ServletRegistrationBean h2servletRegistration(){

		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebdavServlet());

		registrationBean.addUrlMappings("/console/*");

		return registrationBean;

	}

}
*/