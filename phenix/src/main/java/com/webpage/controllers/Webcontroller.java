package com.webpage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Webcontroller 
{
	@RequestMapping(value="/login")
	public String showlogin1()
	{
		return "login";
	}
	
	
	@RequestMapping(value="/register")
	public String showregister1()
	{
		return "register";
	}
}
