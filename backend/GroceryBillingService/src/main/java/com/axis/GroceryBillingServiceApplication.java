package com.axis;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class GroceryBillingServiceApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(GroceryBillingServiceApplication.class, args);
		
	}

}
