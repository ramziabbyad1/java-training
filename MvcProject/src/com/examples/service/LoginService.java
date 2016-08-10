package com.examples.service;

import java.util.HashMap;

import com.examples.model.User;

public class LoginService {
	HashMap<String, String> users = new HashMap<>();
	public LoginService(){
		users.put("john", "John Doe");
		users.put("jane", "Jane Doe");
		users.put("Java", "Java man");
	}
	public boolean authenticate(String userId, String password){
		boolean result = false;
		if(userId.length() > 0 && !userId.trim().equals("")){
			if(password.length()>0 && !password.trim().equals("")){
				result = true;
			}
		}
		return result;
	}
	
	public String getUserName(String userId){
		String userName;
		userName = users.get(userId);
		return userName;
	}
	
	public User getUserDetails(String userId){
		User user = new User();
		user.setUserId(userId);
		user.setUserName(user.getUserId());
		user.setPhone("1-512-327-6372");
		return user;
	}
}
