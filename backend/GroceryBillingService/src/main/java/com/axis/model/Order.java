package com.axis.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	@Id
	private String orderId;
	private LocalDateTime orderDate;
	private String customerName;
	private String DeliveryAddress;
	private List<Product> Bcart;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDeliveryAddress() {
		return DeliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}
	public List<Product> getBcart() {
		return Bcart;
	}
	public void setCart(List<Product> Bcart) {
		this.Bcart = Bcart;
	}
	public Order(LocalDateTime orderDate, String customerName, String deliveryAddress, List<Product> Bcart) {
		super();
		this.orderDate = orderDate;
		this.customerName = customerName;
		DeliveryAddress = deliveryAddress;
		this.Bcart = Bcart;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
