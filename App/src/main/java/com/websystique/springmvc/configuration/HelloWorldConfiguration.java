package com.websystique.springmvc.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.model.EmployeeImpDAO;
import com.websystique.springmvc.model.Entreprise;

import java.util.Date;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.joda.time.LocalDate;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.websystique.springmvc")
@PropertySource(value="classpath:config.properties" ,ignoreResourceNotFound=true)
public class HelloWorldConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean(name="HelloWorld")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}
	
	 @Bean
	    public MessageSource messageSource() {
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasename("messages");
	        return messageSource;
	    }
	
	@Bean
	public Entreprise InstanceEmtreprise(){
		Entreprise ent = new Entreprise() ; 
		ent.setEmployees(new Employee());
		ent.setName("Ausy Corporation");
		System.out.println("prop:"+env.getProperty("mongodb.url"));
		return ent ; 
	}

	@Bean(name="Employee")
	public Employee InstanceEmployee(){
		Employee emp = new Employee("Nadir " + Math.random() , new Date(), 858, "SSN:"+Math.random()) ;  
		System.out.println("prop:"+env.getProperty("mongodb.db"));
		return emp ; 
	}
	
	  @Bean(name="sessionFactory")
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(dataSource());
	        sessionFactory.setPackagesToScan(new String[] { "com.websystique.springmvc.model" });
	        sessionFactory.setHibernateProperties(hibernateProperties());
	        return sessionFactory;
	     }
	     
	    @Bean(name="DataSource")
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
	        dataSource.setUrl(env.getRequiredProperty("jdbc.url"));
	        dataSource.setUsername(env.getRequiredProperty("jdbc.username"));
	        dataSource.setPassword(env.getRequiredProperty("jdbc.password"));
	        System.out.println("database has been activate.");
	        return dataSource;
	    }
	     
	    private Properties hibernateProperties() {
	        Properties properties = new Properties();
	        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
	        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
	        properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
	        return properties;        
	    }
	     
	    @Bean
	    @Autowired
	    public HibernateTransactionManager transactionManager(SessionFactory s) {
	       HibernateTransactionManager txManager = new HibernateTransactionManager();
	       txManager.setSessionFactory(s);
	       return txManager;
	    }
	    
	    @Bean
	    @Autowired
	    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
	    {
	        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
	        hibernateTemplate.setCheckWriteOperations(false);
	        return hibernateTemplate;
	    }
	    
	    @Bean(name="EmployeeImpDAO")
	    public EmployeeImpDAO getInstanceEmployeeImpDAO(){
	    	return new EmployeeImpDAO() ; 
	    }
	   
	
}