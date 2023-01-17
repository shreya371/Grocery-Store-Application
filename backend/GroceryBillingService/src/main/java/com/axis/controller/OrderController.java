package com.axis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.feignclient.BillingClient;
import com.axis.model.Customer;
import com.axis.model.Order;
import com.axis.service.OrderService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/ms4")
public class OrderController {
	
	@Autowired
	BillingClient billingClient;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/greet")
	public String greet() {
		return "hello from billing";
	}
	
	@GetMapping("/customer/{username}")
	public Customer getCustomerByUsername(@PathVariable String username) {
		return billingClient.getCustomer(username);
		
	}
	//same like adding order to the collection
	@PostMapping("/order/{username}")
	public Order getOrder(@PathVariable String username) {
		return orderService.getOrder(username);
		
	}
	
	
	
	
	

}
