package com.webpage.controllers;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webpage.dao.Productdao;
import com.webpage.dao.Userdetaildao;
import com.webpage.model.Userdetail;

@Controller
public class Usercontroller 
{

	@Autowired
	Productdao productDAO;
	
	@Autowired
	Userdetaildao userdetailDAO;

	
	@RequestMapping("/registration")
	public String register(@RequestParam("firstname")String firstname,@RequestParam("lastname")String lastname,@RequestParam("dob")String dob,@RequestParam("username")String username,@RequestParam("password")String password,Model m)
	{
		Userdetail userdetail=new Userdetail();
		userdetail.setUsername(username);
		userdetail.setDob(dob);
		userdetail.setFirstname(firstname);
		userdetail.setLastname(lastname);
		userdetail.setPassword(password);
		
		userdetailDAO.addUserdetail(userdetail);
		
		return "register";
	}
		
		
	
	@RequestMapping("/login_success")
	public String loginsuccess(HttpSession session,Model m)
	{
		String page="";
		boolean loggedIn=false;
		
		SecurityContext secontext=SecurityContextHolder.getContext();
		Authentication authentication=secontext.getAuthentication();
		
			
		String username=authentication.getName();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="adminhome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				
				loggedIn=true;
				page="userhome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
				
			}
		}
		
		return page;
	}
	
	@RequestMapping("home")
	public String home(Model m)
	{
		return "home";
	}
	@RequestMapping("homeus")
	public String home1(Model m)
	{
		return "homeus";
	}	
	
	
}
