package com.axis.model;

public class Product {
	private String productId;
	private double productPrice;
	private int productQuantity;
	private double total;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Product(double productPrice, int productQuantity, double total) {
		super();
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.total = total;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
