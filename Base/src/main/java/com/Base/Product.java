package com.Base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product 
{
	@Id
	@GeneratedValue
	int ProductId;
	String ProductName;
	String ProductDes;
	int Stock;
	int Price;
	public int getProductId() 
	{
		return ProductId;
	}
	public void setProductId(int productId) 
	{
		ProductId = productId;
	}
	public String getProductName() 
	{
		return ProductName;
	}
	public void setProductName(String productName) 
	{
		ProductName = productName;
	}
	public String getProductDes() 
	{
		return ProductDes;
	}
	public void setProductDes(String productDes) 
	{
		ProductDes = productDes;
	}
	public int getStock() 
	{
		return Stock;
	}
	public void setStock(int stock) 
	{
		Stock = stock;
	}
	public int getPrice() 
	{
		return Price;
	}
	public void setPrice(int price) 
	{
		Price = price;
	}
	

}
