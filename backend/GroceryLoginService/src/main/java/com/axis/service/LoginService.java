package com.axis.service;

import com.axis.model.Login;

public interface LoginService {
	public String authentication(String username,String password);

	public String login(Login login);

}
