package com.webpage.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.webpage.model.Orderdetail;

public class Orderdaoimpl implements Orderdao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean paymentProcess(Orderdetail orderdetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderdetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCartItemStatus(String username,int orderId)
	{
		try
		{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("update Cart set status='P',orderId=:ordid where username:uname and status='NP'");
		query.setParameter("username", username);
		query.setParameter("orderId", orderId);
		int row_eff=query.executeUpdate();
		if(row_eff>0)
			return true;
		else
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	
}
