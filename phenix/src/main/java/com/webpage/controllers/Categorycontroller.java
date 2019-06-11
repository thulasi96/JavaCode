package com.webpage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webpage.dao.Categorydao;
import com.webpage.model.Category;

@Controller   //indicates that a particular class serves the role of a controller
public class Categorycontroller 
{
	@Autowired(required=true)    //enables you to inject the object dependency implicitly
	Categorydao categoryDAO;
	
	@RequestMapping(value="/category") //annotation is used to map web requests onto specific handler classes and handler methods
	public String showcate1(Model m)
	{
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",categoryList);
		
		System.out.println("---Original List---");
		return "category";
	}
	

	//@RequestParam-automatically binds the request parameters to the arguments of your handler method
	@RequestMapping(value="/insertcategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("categoryName")String CategoryName,@RequestParam("categoryDesc")String CategoryDesc,Model m)
	{
		
		Category category=new Category();
		category.setCategoryName(CategoryName);
		category.setCategoryDesc(CategoryDesc);
		
		categoryDAO.addCategory(category);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",categoryList);
		
		System.out.println("---Insert List---");
		return "category";
	}
	
	@RequestMapping(value="/EditCategory/{categoryId}")
	public String editcategory(@PathVariable("categoryId")int categoryId,Model m) 
	//@PathVariable-annotation is used to bind the URI template variables to the handler method parameters of a controller
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		m.addAttribute("category",category);
		
		System.out.println("---Edit List---");
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/DeleteCategory/{categoryId}")
	public String deletecategory(@PathVariable("categoryId")int CategoryId,Model m) 
	
	{
		Category category= categoryDAO.getCategory(CategoryId);
		categoryDAO.deleteCategory(category);

		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",categoryList);
		
		System.out.println("---Deleted---");
		return "category";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updatecategory(@RequestParam("categoryId")int CategoryId,@RequestParam("categoryName")String CategoryName,@RequestParam("categoryDesc")String CategoryDesc,Model m)
	{
		Category category=categoryDAO.getCategory(CategoryId);
		category.setCategoryName(CategoryName);
		category.setCategoryDesc(CategoryDesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category>categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",categoryList);
		
		System.out.println("---Update List---");
		return "category";
	}
	
}

