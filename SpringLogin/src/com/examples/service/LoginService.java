package com.examples.service;

public class LoginService {
	public boolean authenticate(String userID, String password){
		boolean result = false;
		if(userID.equals("admin") && password.equals("password")){
			result = true;
		}
		return result;
	}
}
