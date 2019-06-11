package com.webpage.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.webpage.dao.Supplierdao;
import com.webpage.model.Supplier;

public class Supplierdaotest 
{
	static Supplierdao supplierDAO;
	
	@BeforeClass
	public static void test() 
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.webpage");
		context.refresh();
		
		supplierDAO=(Supplierdao)context.getBean("supplierDAO");
	}
	//@Ignore
	@Test 
	public void addSupplier()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Rajesh");
		supplier.setSupplierDesc("Chennai");
		
		
		assertTrue("Problem in Adding Supplier",supplierDAO.addSupplier(supplier));
	}
	//@Ignore
	@Test 
	public void addSupplier1()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Ananad");
		supplier.setSupplierDesc("Delhi");
		
		assertTrue("Problem in Adding Supplier",supplierDAO.addSupplier(supplier));
	}
	@Ignore
	@Test 
	public void deleteSupplier()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Rajesh");
		supplier.setSupplierDesc("Chennai");
		
		assertTrue("Problem in Deleting Supplier",supplierDAO.deleteSupplier(supplier));
	}
	@Ignore
	@Test
	public void updateSupplier()
	{
		Supplier supplier=supplierDAO.getSupplier(16);
		supplier.setSupplierName("Kumar");
		
		assertTrue("Problem in Updating Supplier",supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void listSuppliertest()
	{
		List<Supplier> supplierList=supplierDAO.listSuppliers();
		
		assertTrue("Problem in List Suppliers",supplierList.size()>0);
		
		for(Supplier supplier:supplierList)
		{
			System.out.println(supplier.getSupplierName()+"--");
			System.out.println(supplier.getSupplierDesc()+"--");
		}
	}
}
	
	

