package com.webpage.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webpage.model.Userdetail;

@Repository("userdetailDAO")
@Transactional
public class Userdetaildaoimpl implements Userdetaildao 
{
	@Autowired
	SessionFactory sessionFactory;
	

	public boolean addUserdetail(Userdetail userdetail) 
	{
		
		try
		{
			sessionFactory.getCurrentSession().save(userdetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}

	
	public boolean updateUserdetail(Userdetail userdetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(userdetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public Userdetail getUserdetail(String username) 
	{
		Session session=sessionFactory.openSession();
		Userdetail userdetail=session.get(Userdetail.class,username);
		session.close();
		return userdetail;
		
	}
	
}
