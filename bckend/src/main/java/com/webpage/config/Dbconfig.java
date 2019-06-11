package com.webpage.config;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.webpage.dao.Categorydaoimpl;
import com.webpage.model.Cart;
import com.webpage.model.Category;
import com.webpage.model.Product;
import com.webpage.model.Supplier;
import com.webpage.model.Userdetail;

@Configuration 	//@Configuration annotation allows us to use annotations for dependency injection
@EnableTransactionManagement //creates a proxy that implements the same interface(s) as the class
@ComponentScan("com.webpage")//automatically import the beans into the container and inject to dependencies
public class Dbconfig 
{

	
	@Bean(name="dataSource")  //is used to represent any class or method as logical unit of reusable code in an application
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecomdb");
		dataSource.setUsername("ecom");
		dataSource.setPassword("ecom");
		
		System.out.println("DataSource object Created");
		return dataSource;
	}
	
	

	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties properties=new Properties();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		
		DataSource dataSource=this.getH2DataSource();
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(dataSource);
		factory.addProperties(properties);
		
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Product.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(Userdetail.class);
		factory.addAnnotatedClass(Cart.class);
		
		System.out.println("Session Factory Object created");
		SessionFactory sessionFactory=factory.buildSessionFactory();
		return sessionFactory;
	}
	
	
	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Transaction Manager Object Created");
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean(name="categoryDAO")
	public Categorydaoimpl getCategoryDAO()
	{
		return new Categorydaoimpl();
	}
}
