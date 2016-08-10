package com.examples.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.examples.service.LoginService;

public class LoginController implements Controller {
	//analagous to doGet method of HttpServlet
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String userID = request.getParameter("uname");
		String password = request.getParameter("upass");
		LoginService service = new LoginService();
		boolean result = service.authenticate(userID,password);
		ModelAndView mv = null;
		if(result){
			mv = new ModelAndView("success");
			mv.addObject("userID", userID);
		}else{
			mv = new ModelAndView("error");
			mv.addObject("msg", "Incorrect userID or password");
		}
		return mv;
	}

}
