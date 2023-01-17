package com.axis.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.feignclient.BillingClient;
import com.axis.model.Customer;
import com.axis.model.Order;
import com.axis.model.Product;
import com.axis.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    BillingClient billingClient;
	
    @Autowired
    OrderRepository orderRepository;
    
    
    @Override
	public Order getOrder(String username) {
		Customer customer=billingClient.getCustomer(username);
		List<Product> products=customer.getCart();
		for(Product product:products) {
			product.setTotal(product.getProductQuantity()*product.getProductPrice());
		}
		String name=customer.getFirstName()+" "+customer.getLastName();
		
		Order order=new Order(LocalDateTime.now(),name,customer.getAddress(),customer.getCart());
		
		orderRepository.insert(order);
		
		return order;
	}

}
