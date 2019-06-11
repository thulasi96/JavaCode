package com.webpage.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webpage.dao.Productdao;
import com.webpage.model.Product;

public class Productdaotest 
{
	static Productdao productDAO;
	
	@BeforeClass
	public static void First() 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.webpage");
		context.refresh();
	
		productDAO=(Productdao)context.getBean("productDAO");
	}
	//@Ignore
	@Test
	public void addProduct()
	{
		Product product=new Product();
		product.setProductName("Apple");
		product.setProductDesc("Ios");
		product.setPrice(2000);
		product.setStock(2);
		
		
		assertTrue("Problem in Adding Product",productDAO.addProduct(product));
	}
	
	@Test
	public void addProduct1()
	{
		Product product=new Product();
		product.setProductName("Laptop");
		product.setProductDesc("Lenovo");
		
		assertTrue("Problem in Adding Product",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void addProduct2()
	{
		Product product=new Product();
		product.setProductName("Laptop");
		product.setProductDesc("HP");
		
		assertTrue("Problem in Adding Product",productDAO.addProduct(product));
	}
	@Ignore
	@Test
	public void deleteProduct()
	{
		Product product=productDAO.getProduct(13);
		assertTrue("Problem in Deleting Product",productDAO.deleteProduct(product));
	}
	@Ignore
	@Test
	public 
	void updateProductTest()
	{
		Product product=productDAO.getProduct(12);
		product.setProductName("Acer");
		
		assertTrue("Problem in Updating Product",productDAO.updateProduct(product));
		
	}
	@Ignore
	@Test
	public void listProductTest()
	{
		List<Product> productList=productDAO.listProducts();
		
		assertTrue("Problem in Listing Products",productList.size()>0);
		
		for(Product product:productList)
		{
			System.out.print(product.getProductId()+"--");
			System.out.print(product.getProductName()+"--");
			System.out.println(product.getProductDesc());
		}
	}
}
