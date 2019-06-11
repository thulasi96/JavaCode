package com.webpage.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.webpage.model.Cart;


@Transactional							
@Repository("cartDAO")

public class Cartdaoimpl implements Cartdao
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addtocart(Cart cart) 
	{
		try
		{
		
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deletecart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updatecart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Cart getCart(int cartId) 
	{
		Session session=sessionFactory.openSession();
		Cart cart=session.get(Cart.class, cartId);
		session.close();
		return cart;
	}

	public List<Cart> listCartitems() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart");
		
		List<Cart> cartList=query.list();
		session.close();
		return cartList;
	}

	

}
