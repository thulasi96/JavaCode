package com.webpage.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Orderdetail 
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderId;
	String username;
	Date orderDate;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getShoppigAmount() {
		return shoppigAmount;
	}
	public void setShoppigAmount(int shoppigAmount) {
		this.shoppigAmount = shoppigAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	int shoppigAmount;
	String paymentMode;
	
	
	
	
}
