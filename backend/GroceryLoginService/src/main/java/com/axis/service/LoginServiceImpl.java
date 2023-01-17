package com.axis.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.NullException;
import com.axis.feignclient.LoginClient;
import com.axis.model.Login;
import com.axis.repository.LoginRepository;

import feign.FeignException;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginClient loginClient;
	
	@Autowired
	LoginRepository loginRepository;
	@Override
	public String authentication(String username, String password) {
		try {
			Map<String,String> login=loginClient.getLoginDetails(username);
			int s=login.size();
			System.out.println(s);
			if (s>0) {
				//throw new InvalidLoginDetailsException(AppConstants.INVALID_LOGIN_DETAILS_MESSAGE);
				 for (Map.Entry<String,String> entry : login.entrySet()) {
					 String key=entry.getKey();
					 String value=entry.getValue();
					 
					 if(key.equals(username) && value.equals(password)) {
						 return "LOGIN SUCCESSFULL";
					 }
				 }	
			}
			}catch(FeignException e) {
				throw new NullException("user not found");
			}
			  
			 
		           
			  return "invalid details";
	}
	@Override
	public String login(Login login) {
		String username = login.getUsername();
		String password = login.getPassword();
		try {
			Map<String,String> login1=loginClient.getLoginDetails(username);
			int s=login1.size();
			System.out.println(s);
			if (s>0) {
				//throw new InvalidLoginDetailsException(AppConstants.INVALID_LOGIN_DETAILS_MESSAGE);
				 for (Map.Entry<String,String> entry : login1.entrySet()) {
					 String key=entry.getKey();
					 String value=entry.getValue();
					 
					 if(key.equals(username) && value.equals(password)) {
						 return "LOGIN SUCCESSFULL";
					 }
				 }	
			}
			}catch(FeignException e) {
				throw new NullException("user not found");
			}
			  
			 
		           
			  return "invalid details";
		
		
	}
	

}
