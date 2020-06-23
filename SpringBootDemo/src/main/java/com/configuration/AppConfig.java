package com.configuration;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.entity.EmployeeEntity;
import com.entity.GarmentDetail;
import com.entity.GarmentMain;
import com.entity.StrMain;
import com.entity.UsrMain;

@org.springframework.context.annotation.Configuration
//@Profile("test")
public class AppConfig {
	
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
	@Value("${spring.jpa.hibernate.ddl-auto}")
	public String hbm2ddlAuto;
	
	/*@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		Configuration configuration = new Configuration();
		configuration.configure();
		addAnnotatedClass(configuration);
		return configuration.buildSessionFactory();		
		
	}
	
	public void addAnnotatedClass(Configuration configuration) {
		configuration.addAnnotatedClass(GarmentDetail.class);
		configuration.addAnnotatedClass(GarmentMain.class);
		configuration.addAnnotatedClass(StrMain.class);
		configuration.addAnnotatedClass(UsrMain.class);
	}*/
	public void addAnnotatedClass(LocalSessionFactoryBean configuration) {
		//configuration.setAnnotatedPackages("com.entity");
		configuration.setAnnotatedClasses(GarmentDetail.class,GarmentMain.class,StrMain.class,UsrMain.class);
		/*configuration.setAnnotatedClasses(GarmentMain.class);
		configuration.setAnnotatedClasses(StrMain.class);
		configuration.setAnnotatedClasses(UsrMain.class);*/
	}
	
	/*@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUsername(userName);
		driverManagerDataSource.setPassword(password);
		System.out.println(userName+" ===================url======================== "+password);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setDriverClassName(driverClassName);
		return driverManagerDataSource;
	}*/
//	@Autowired
//	public DataSource dataSource;
//	
	
	/*@Bean
	public LocalSessionFactoryBean sessionFactory() throws IOException {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		//localSessionFactoryBean.setPackagesToScan("controller");
		 
		Properties properties = new Properties();
		System.out.println(dialact +" dialact =======================");
		properties.put("spring.jpa.properties.hibernate.dialect", dialact);
		System.out.println(hbm2ddlAuto +" hbm2ddlAuto   =============");
		properties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);
		//properties.put("spring.jpa.hibernate.ddl-auto", hbm2ddlAuto);

		localSessionFactoryBean.setHibernateProperties(properties);
		this.addAnnotatedClass(localSessionFactoryBean);
		//localSessionFactoryBean.setPackagesToScan("controller");
		//localSessionFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		//localSessionFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		//System.out.println(localSessionFactoryBean.getPersistenceUnitName() +" Persistence #####################");
		localSessionFactoryBean.afterPropertiesSet();
		Configuration configuration = localSessionFactoryBean.getConfiguration();
		configuration.buildSessionFactory();
		return localSessionFactoryBean;
	}*/
}
