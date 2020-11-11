package com.in28minutes.springboot.web.springbootfirstapplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String userId, String password) {
		return userId.equalsIgnoreCase("Abhi") && password.equalsIgnoreCase("Bajpai");
	}
}
