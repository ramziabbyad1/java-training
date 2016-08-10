package com.examples;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;
	
	@Override
	public String execute() throws Exception {
		String result = null;
		if(userId != null && userId.equals("admin")){
			if(password!=null && password.equals("password")){
				result = "success";
			}else{
				result = "error";
			}
		}else{
			result="error";
		}
		return result;
	}
	
	@Override
	public void validate() {
		if(userId==null || userId.trim().equals("")){
			addFieldError("userId", "UserID cannot be blank or spaces!");
		}
		if(password==null || password.trim().equals("")){
			addFieldError("password", "Password cant be blank or spaces!");
		}
		
	}

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
}
