package com.webpage.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.webpage.dao.Categorydao;
import com.webpage.dao.Productdao;
import com.webpage.dao.Supplierdao;
import com.webpage.model.Category;
import com.webpage.model.Product;
import com.webpage.model.Supplier;



@Controller
public class Productcontroller 
{

	@Autowired(required=true)    
	Productdao productDAO;
	
	@Autowired
	Categorydao categoryDAO;
	
	@Autowired
	Supplierdao supplierDAO;
	
	@RequestMapping(value="/product")
	public String showproduct(Model m)
	{
		Product product=new Product();
		m.addAttribute("product",product);
		
		List<Product>productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategory(categoryList));
		
		List<Supplier>supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		System.out.println("---Original List---");
		return "product";
	}
	
	@RequestMapping(value="/insertproduct",method=RequestMethod.POST)
	public String insertproduct(@ModelAttribute("product")Product product,@RequestParam("productimage") MultipartFile fileImage,Model m)
	{
		
		productDAO.addProduct(product);
		
		String path="D:\\ECOMMERCE_WORKSPACE\\phenix\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(product.getProductId())+".jpg";
		File imageFile=new File(path);
		
		if(!fileImage.isEmpty())
		{
			try
			{
				byte[] buffer=fileImage.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(buffer);
				bs.close();
			}
			catch(Exception e)
			{
				System.out.println("Exception"+e);
			}
		}
		else
		{
			System.out.println("Error");
		}
			
		
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategory(categoryList));
		
		List<Supplier>supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		System.out.println("---Insert List---");
		return "product";
	}
	
	
	private LinkedHashMap<Integer,String> getSupplierList(List<Supplier> supplierList) 
	{
		LinkedHashMap<Integer,String> listSupplier=new LinkedHashMap<Integer,String>();
		
		int i=0;
		while(i<supplierList.size())
		{
			Supplier supplier=supplierList.get(i);
			listSupplier.put(supplier.getSupplierId(),supplier.getSupplierName());
			i++;
		}
		
		return listSupplier;
	}

	

	private LinkedHashMap<Integer,String> getCategory(List<Category> categoryList) 
	
	{
	LinkedHashMap<Integer,String> listCategory=new LinkedHashMap<Integer,String>();
		
		int i=0;
		while(i<categoryList.size())
		{
			Category category=categoryList.get(i);
			listCategory.put(category.getCategoryId(),category.getCategoryName());
			i++;
		}
		
		return listCategory;
		
	}
	

	@RequestMapping(value="/EditProduct/{productId}")
	public String editproduct(@PathVariable("productId")int productId,Model m) 
	
	{
		Product product=productDAO.getProduct(productId);
		
		m.addAttribute("product",product);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategory(categoryList));
		
		List<Supplier>supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		System.out.println("---Edit List---");
		return "UpdateProduct";
	}
	
	@RequestMapping(value="/DeleteProduct/{productId}")
	public String deleteproduct(@PathVariable("productId")int productId,Model m) 
	
	{
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);

		List<Product>productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategory(categoryList));
		
		List<Supplier>supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		
		System.out.println("---Deleted---");
		return "product";
	}
	

	@RequestMapping(value="/updateproduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")Product product,Model m)
	{
		
		productDAO.updateProduct(product);
		
		List<Product>productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategory(categoryList));
		
		List<Supplier>supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",this.getSupplierList(supplierList));
		
		System.out.println("---Update List---");
		return "product";
	}
	
	@RequestMapping(value="/productpage")
	public String showproducts(Model m)
	{
		List<Product>productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		
		return "productpage";
	}
	
	@RequestMapping(value="/productsDisplay/{productId}")
	public String displaydetail(@PathVariable("productId")int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		
		m.addAttribute("product",product);
		
		List<Product>productList=productDAO.listProducts();
		m.addAttribute("productList",productList);
		
		return "productsDisplay";
		
	}
	
	
	
	
	
	

}
