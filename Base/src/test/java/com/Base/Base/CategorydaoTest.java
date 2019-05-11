package com.Base.Base;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategorydaoTest 
{

	public static void main(String arg[]) 
	
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.Base");
		context.refresh();
	}

}
