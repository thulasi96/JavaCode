package com.webpage.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webpage.dao.Cartdao;
import com.webpage.dao.Productdao;
import com.webpage.model.Cart;

@Controller
public class Paycontroller 
{
	@Autowired
	Productdao productDAO;
	
	@Autowired
	Cartdao cartDAO;
	
	@RequestMapping(value="/payment")
	public String pay(Model m,HttpSession session)
	{
		
		List<Cart>cartList=cartDAO.listCartitems();
		m.addAttribute("cartList",cartList);
		
		return "payment";
	}
	
	@RequestMapping(value="/pay")
	public String pay1(Model m)
	{
		List<Cart>cartList=cartDAO.listCartitems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
		
		return "receipt";
	}
	
	public int grandtotal(List<Cart> listCartitems)
	{
		int count=0, grandtotal=0;
		while(count<listCartitems.size())
		{
			
			grandtotal=grandtotal+listCartitems.get(count).getQuantity()*listCartitems.get(count).getPrice();
			count++;
		}
		return grandtotal;
	}
	
}
