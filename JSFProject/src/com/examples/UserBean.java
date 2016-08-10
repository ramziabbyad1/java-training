package com.examples;

public class UserBean {
	private String userId;
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String authenticate(){
		String result = null;
		if("admin".equals(userId) && "password".equals(password)){
			result = "success";
		}else{
			result = "error";
		}
		return result;
	}
	
}
