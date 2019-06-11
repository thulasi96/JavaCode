package com.webpage.dao;

import com.webpage.model.Userdetail;

public interface Userdetaildao 
{
	public boolean addUserdetail(Userdetail userdetail);
	
	public boolean updateUserdetail(Userdetail userdetail);
	
	public Userdetail getUserdetail(String username);
	
	
}
