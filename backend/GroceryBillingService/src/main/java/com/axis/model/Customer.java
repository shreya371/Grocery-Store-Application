package com.axis.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Customer {

	private String cId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	
	private String address;
	
	private List<Product> cart;
	
	private LocalDateTime dateTime;

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Customer(String cId, String firstName, String lastName, String email, String username, String password,
			String address, List<Product> cart, LocalDateTime dateTime) {
		super();
		this.cId = cId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.cart = cart;
		this.dateTime = dateTime;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	
	
	
	
	
	

}
