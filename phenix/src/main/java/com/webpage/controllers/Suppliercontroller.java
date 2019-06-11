package com.webpage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webpage.dao.Supplierdao;
import com.webpage.model.Supplier;




@Controller
public class Suppliercontroller 
{

	@Autowired(required=true)    
	Supplierdao supplierDAO;
	
	@RequestMapping(value="/supplier") 
	public String showsupplier(Model m)
	{
		List<Supplier>supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",supplierList);
		
		System.out.println("---Original List---");
		return "supplier";
	}
	

	
	
	@RequestMapping(value="/insertsupplier",method=RequestMethod.POST)
	public String insertSupplier(@RequestParam("supplierName")String SupplierName,@RequestParam("supplierDesc")String SupplierDesc,Model m)
	{
		
		Supplier supplier=new Supplier();
		supplier.setSupplierName(SupplierName);
		supplier.setSupplierDesc(SupplierDesc);
		
		
		supplierDAO.addSupplier(supplier);
		
		List<Supplier>supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",supplierList);
		
		System.out.println("---Insert List---");
		return "supplier";
	}
	
	@RequestMapping(value="/EditSupplier/{supplierId}")
	public String editsupplier(@PathVariable("supplierId")int supplierId,Model m) 
	
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		m.addAttribute("supplier",supplier);
		
		System.out.println("---Edit List---");
		return "UpdateSupplier";
	}
	
	@RequestMapping(value="/DeleteSupplier/{supplierId}")
	public String deletesupplier(@PathVariable("supplierId")int SupplierId,Model m) 
	
	{
		Supplier supplier= supplierDAO.getSupplier(SupplierId);
		supplierDAO.deleteSupplier(supplier);

		List<Supplier>supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",supplierList);
		
		System.out.println("---Deleted---");
		return "supplier";
	}
	
	@RequestMapping(value="/updatesupplier",method=RequestMethod.POST)
	public String updatesupplier(@RequestParam("supplierId")int SupplierId,@RequestParam("supplierName")String SupplierName,@RequestParam("supplierDesc")String SupplierDesc,Model m)
	{
		
		Supplier supplier=supplierDAO.getSupplier(SupplierId);
		supplier.setSupplierName(SupplierName);
		supplier.setSupplierDesc(SupplierDesc);
		
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier>supplierList=supplierDAO.listSuppliers();
		m.addAttribute("supplierList",supplierList);
		
		System.out.println("---Update List---");
		return "supplier";
	}
	
}
