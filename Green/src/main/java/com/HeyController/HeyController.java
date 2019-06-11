package com.HeyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeyController
{
@RequestMapping("/hello")
public String getclick()
{
	return "hello";
}
}