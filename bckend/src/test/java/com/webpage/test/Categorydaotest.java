package com.webpage.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Categorydaotest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.webpage");
		context.refresh();
	}
}
