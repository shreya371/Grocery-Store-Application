package com.axis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.feignclient.LoginClient;
import com.axis.model.Login;
import com.axis.service.LoginService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/ms3")
public class LoginController {
	
	@Autowired
	LoginClient loginClient;
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/getLogin/{username}")
	public Map<String,String> showLogin(@PathVariable String username) {
		return loginClient.getLoginDetails(username);
	}
	
	@GetMapping("/auth/{username}/{password}")
	public String authentication(@PathVariable String username,@PathVariable String password) {
		return loginService.authentication(username, password);
	}
	
	
	@CrossOrigin(origins="http://localhost:3000")
	@PostMapping("/login")
	public String login(@RequestBody Login login) {
		return loginService.login(login);
	}
	
	
	

	
	
}
