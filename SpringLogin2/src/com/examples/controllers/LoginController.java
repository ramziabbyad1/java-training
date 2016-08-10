package com.examples.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("login")
public class LoginController {
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView handleRequest(@RequestParam("uname") String userID,@RequestParam("upass") String password){
		ModelAndView result = null;
		if(userID.equals("admin") && password.equals("password")){
			result = new ModelAndView("success");
			result.addObject("userID", userID);
		}else{
			result = new ModelAndView("error");
			result.addObject("msg","Incorrect login credentials...");
		}
		return result;
	}
}
