package com.webpage.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webpage.dao.Cartdao;

import com.webpage.dao.Productdao;
import com.webpage.model.Cart;

import com.webpage.model.Product;

@Controller
public class Cartcontroller 
{
	@Autowired
	Cartdao cartDAO;
	
	@Autowired
	Productdao productDAO;
	
	@RequestMapping(value="/mycart")
	public String cart1(Model m)
	{
		List<Cart>cartList=cartDAO.listCartitems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
		return "cart";
	}
	
	@RequestMapping(value="/addcart/{productId}")
	public String showcart(@PathVariable("productId")int productId,Model m,HttpSession session)
	{
		Product product=productDAO.getProduct(productId);
		System.out.println(productId);
		
		
		
		String username=(String)session.getAttribute("username");
		
		Cart cart=new Cart();
		cart.setProductId(product.getProductId());
		cart.setProductName(product.getProductName());
		
		cart.setPrice(product.getPrice());
		cart.setUsername(username);
		cart.setStatus("status");
		
		cartDAO.addtocart(cart);
		
		List<Cart>cartList=cartDAO.listCartitems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
		
		
		System.out.println("--Add Cart--");
		return "cart";
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
	
	@RequestMapping(value="/Removecart/{cartId}")
	public String remove(@PathVariable("cartId")int cartId,Model m,HttpSession session) 
	{
		Cart cart=cartDAO.getCart(cartId);
		cartDAO.deletecart(cart);
		
		String username=(String)session.getAttribute("username");
		
		List<Cart>cartList=cartDAO.listCartitems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
	
		
		return "cart";		
	}
	
	@RequestMapping(value="/orderconfirm")
	public String show(Model m,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		
		List<Cart>cartList=cartDAO.listCartitems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
		
		return "orderconfirm";
	}
	
	@RequestMapping("/updatecart/{cartId}")
	public String updatecart1(@PathVariable("cartId")int cartId,@RequestParam("quantity")int quantity,Model m,HttpSession session)
	{
		Cart cart=cartDAO.getCart(cartId);
		cart.setQuantity(quantity);
		cartDAO.updatecart(cart);
		
		String username=(String)session.getAttribute("username");
		
		List<Cart>cartList=cartDAO.listCartitems();
		m.addAttribute("cartList",cartList);
		m.addAttribute("grandtotal",this.grandtotal(cartList));
		
		System.out.println(cartId);
		return "cart";
		
	}
		
}
