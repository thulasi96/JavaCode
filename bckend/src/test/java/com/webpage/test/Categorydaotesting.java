package com.webpage.test;

import org.junit.BeforeClass;
import org.junit.Ignore;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webpage.dao.Categorydao;
import com.webpage.model.Category;

public class Categorydaotesting 
{
	
	static Categorydao categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.webpage");
		context.refresh();
		
		categoryDAO=(Categorydao)context.getBean("categoryDAO");
	}
	//@Ignore
	@Test 
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("TShirt");
		category.setCategoryDesc("Round Neck Collar");
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
	}
	

	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(5);
		assertTrue("Problem in Deleting Category",categoryDAO.deleteCategory(category));
	}
	
	@Test
	public 
	void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(8);
		category.setCategoryName("Trouser");
		
		assertTrue("Problem in Updating Category",categoryDAO.updateCategory(category));
		
	}
	@Ignore
	@Test
	public void addCategoryTest3()
	{
		Category category=new Category();
		category.setCategoryName("Shoe");
		category.setCategoryDesc("Formal & Casual");
		
		assertTrue("Problem in Adding Category",categoryDAO.addCategory(category));
	
	}
	
	@Test
	public void listCategoryTest()
	{
		List<Category> categoryList=categoryDAO.listCategories();
		
		assertTrue("Problem in Listing Categories",categoryList.size()>0);
		
		for(Category category:categoryList)
		{
			System.out.print(category.getCategoryId()+"--");
			System.out.print(category.getCategoryName()+"--");
			System.out.println(category.getCategoryDesc());
		}
	}
	
	}

	
	

