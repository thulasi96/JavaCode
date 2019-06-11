package com.webpage.dao;

import com.webpage.model.Orderdetail;

public interface Orderdao 
{

	public boolean paymentProcess(Orderdetail orderdetail);
	public boolean updateCartItemStatus(String username,int orderId);
	
}
