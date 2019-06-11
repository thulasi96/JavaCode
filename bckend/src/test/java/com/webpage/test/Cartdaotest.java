package com.webpage.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webpage.dao.Cartdao;
import com.webpage.model.Cart;




public class Cartdaotest 
{
static Cartdao cartDAO;

@BeforeClass
public static void executeFirst()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.webpage");
	context.refresh();
	
	cartDAO=(Cartdao)context.getBean("cartDAO");
}
//@Ignore
@Test 
public void addCartTest()
{
	
	Cart cart=new Cart();
	cart.setProductName("Mac");
	cart.setStatus("Available");
	cart.setOrderId(1);
	cart.setPrice(2000);
	cart.setQuantity(1);
	cart.setUsername("John");
	cart.setStatus("NP");
	
	assertTrue("Problem in Adding Cart",cartDAO.addtocart(cart));
}
@Ignore
@Test
public void deleteCartTest()
{
	Cart cart=cartDAO.getCart(2);
	assertTrue("Problem in Deleting Cart",cartDAO.deletecart(cart));
}
@Ignore
@Test
public 
void updateCartTest()
{
	Cart cart=cartDAO.getCart(33);
	
	cart.setUsername("kumar");
	
	assertTrue("Problem in Updating Cart",cartDAO.updatecart(cart));
	
}

@Test
public void listCartTest()
{
	List<Cart> cartList=cartDAO.listCartitems();
	
	assertTrue("Problem in Listing Carts",cartList.size()>0);
	
	for(Cart cart:cartList)
	{
		
		System.out.print(cart.getProductName()+"--");
		System.out.println(cart.getUsername()+"--");
		System.out.println(cart.getProductId()+"--");
	}
}


}