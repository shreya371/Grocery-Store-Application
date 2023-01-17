package com.axis.service;

import java.util.List;
import java.util.Map;

import com.axis.model.Customer;

import com.axis.model.Product;
import com.axis.model.jsonResponse;

public interface CustomerService {
	public String greet();
	
	public List<Customer> getAllCustomers();
	public Product updateCart(String username,Product product); 
	
	public jsonResponse cartTotal(String username);

	public String addCustomer(Customer customer);
	
    public double totalAmount(String username);

	public Map<String,String> getLoginDetails(String username);

	public Customer getCustomer(String username);

	public List<Product> customerCart(String username);

	public String deleteFromCart(String username, String productId);

	public Product updateDeleteCart(String username, Product product);

}
