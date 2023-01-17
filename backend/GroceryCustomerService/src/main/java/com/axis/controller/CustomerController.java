package com.axis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.axis.model.Customer;
import com.axis.model.Product;
import com.axis.model.jsonResponse;
import com.axis.service.CustomerService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/ms2")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/greet")
	public String greet() {
		return customerService.greet();
	}
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/register")
	public String addCustomer(@RequestBody Customer customer){
		return customerService.addCustomer(customer);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customer/{username}")
	public Customer getCustomer(@PathVariable String username){
		return customerService.getCustomer(username);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/customerup/{username}")
	public Product updateCart(@PathVariable String username, @RequestBody Product product) {
		return customerService.updateCart(username, product);
	}
	
	@GetMapping("/cartTotal/{username}")
	public jsonResponse cartTotalc(@PathVariable String username) {
		jsonResponse js=customerService.cartTotal(username);
		System.out.println(js);
		return js;
	}
	
	@GetMapping("/total/{username}")
	public double totalAmountc(@PathVariable String username) {
		return customerService.totalAmount(username);
		
	}
	//--------------------------add to cart-------------------------------
	@GetMapping("/cart/{username}")
	public List<Product> customerCart(@PathVariable String username){
		return customerService.customerCart(username);
		
	}
	
	//--------------------------------delete from cart---------------------------
	@DeleteMapping("/cartdelete/{username}/")
	public String deleteFromCart(@PathVariable String username,@RequestParam String productId) {
		return customerService.deleteFromCart(username,productId);
		
	}
	
	
	//----------------updated delete function with product as request body---------------------
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/cartdelete/{username}")
	public Product updateDeleteCart(@PathVariable String username,@RequestBody Product product){
		return customerService.updateDeleteCart(username,product);
		
		
	}
	
	
	
	
	//-------------------------------login------------------------------------------
	
	//get username and password
	//get customer by username
	@GetMapping("/login/{username}")
	public Map<String,String> getLoginDetails(@PathVariable String username){
		return customerService.getLoginDetails(username);
		
	}
	
	
	
	
	
	

}
