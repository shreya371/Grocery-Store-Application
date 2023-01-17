package com.axis.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.axis.model.Customer;




@FeignClient(name="GROCERY-CUSTOMER-SERVICE")
public interface BillingClient {
	
	@GetMapping("/ms2/customer/{username}")
	public Customer getCustomer(@PathVariable String username);

}
