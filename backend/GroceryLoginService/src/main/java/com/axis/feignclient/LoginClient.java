package com.axis.feignclient;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@FeignClient(name="GROCERY-CUSTOMER-SERVICE")
public interface LoginClient {
	
	@GetMapping("/ms2/login/{username}")
	public Map<String,String> getLoginDetails(@PathVariable String username);
	
	

}
