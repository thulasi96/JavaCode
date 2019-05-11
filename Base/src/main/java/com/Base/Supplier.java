package com.Base;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.swing.Spring;

@Entity
@Table
public class Supplier 
{

	@Id
	@GeneratedValue
	Spring name;
	public Spring getName() 
	{
		return name;
	}
	public void setName(Spring name) 
	{
		this.name = name;
	}
	public int getId() 
	{
		return Id;
	}
	public void setId(int id) 
	{
		Id = id;
	}
	int Id;
}
