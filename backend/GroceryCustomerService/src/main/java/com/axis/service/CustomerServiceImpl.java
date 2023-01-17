package com.axis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.axis.exception.DataNotFoundException;
import com.axis.exception.InvalidLoginDetailsException;
import com.axis.exception.InvalidPasswordException;
import com.axis.exception.NullException;
import com.axis.model.Customer;
import com.axis.model.Product;
import com.axis.model.jsonResponse;
import com.axis.repository.CustomerRepository;
import com.axis.utils.AppConstants;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Autowired
	MongoOperations mongoOperations;

	@Override
	public String greet() {
		// TODO Auto-generated method stub
		return "hello from service layer";
	}

	@Override
	public String addCustomer(Customer customer) {
		if (customer.getPassword().length() < 5) {
			throw new InvalidPasswordException(AppConstants.INVALID_PASSWORD_MESSAGE);

		}
		Customer customer1 = customerRepository.insert(customer);
		return "valid";
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findAll();
		if (customers.size() == 0) {
			throw new DataNotFoundException(AppConstants.DATE_NOT_FOUND_MESSAGE);
		}
		return customers;
	}

	@Override
	public Product updateCart(String username, Product product) {
		Query query = new Query(Criteria.where("username").is(username));
		System.out.println(query);
		Update update = new Update();
		System.out.println(update.push("cart", product));
//		System.out.println(update.p("cart", product));

		System.out.println(mongoTemplate.updateFirst(query, update, Customer.class));

		return product;

	}

	@Override
	public jsonResponse cartTotal(String username) {
		// TODO Auto-generated method stub
		return customerRepository.cartTotalR(username);
	}

	@Override
	public double totalAmount(String username) {
		Customer customer = customerRepository.getCustomerByUsername(username);
		List<Product> products = customer.getCart();
		System.out.println(products);
		double total = 0.0;
		for (Product product : products) {
			total = total + product.getProductPrice();
		}
		System.out.println("cart total:" + total);

		return total;
	}

	@Override
	public Map<String, String> getLoginDetails(String username) {

		Customer customer = customerRepository.getCustomerByUsername(username);

		Map<String, String> loginDetails = new HashMap<>();
		try {
			loginDetails.put(customer.getUsername(), customer.getPassword());
		} catch (NullPointerException e) {

			throw new NullException("no customer");
		}
		int s = loginDetails.size();
		System.out.println(s);
		if (s <= 0) {
			throw new InvalidLoginDetailsException(AppConstants.INVALID_LOGIN_DETAILS_MESSAGE);
		}
		return loginDetails;
	}

	@Override
	public Customer getCustomer(String username) {

		return customerRepository.getCustomerByUsername(username);

	}

	@Override
	public List<Product> customerCart(String username) {
		Customer customer = customerRepository.getCustomerByUsername(username);
		System.out.println(customer.getCart());

		return customer.getCart();
	}

	@Override
	public String deleteFromCart(String username, String productId) {
		
		// TODO Auto-generated method stub
		Customer customerd = customerRepository.getCustomerByUsername(username);
		List<Product> products = customerd.getCart();
		for (Product product : products) {
			
//			System.out.println(product.toString());
			if (product.getProductId().equals(productId)) {
				
				
				System.out.println(product.getProductId());
			}
			
		}

		return "not found";
	}

	//-------------------------------------------------------------------------
	@Override
	public Product updateDeleteCart(String username, Product product) {
		Query queryd = new Query(Criteria.where("username").is(username));
		System.out.println(queryd);
		Update update = new Update();
		System.out.println(update.pull("cart", product));
//		System.out.println(update.p("cart", product));

		System.out.println(mongoTemplate.updateFirst(queryd, update, Customer.class));

		return product;
	}

}
