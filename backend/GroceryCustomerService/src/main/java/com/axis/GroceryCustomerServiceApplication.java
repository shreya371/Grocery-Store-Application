package com.axis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GroceryCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryCustomerServiceApplication.class, args);
	}

}
