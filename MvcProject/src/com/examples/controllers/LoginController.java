package com.examples.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.model.User;
import com.examples.service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		LoginService ls = new LoginService();
		boolean result = ls.authenticate(userId, password);
		if(result){
			String userName = ls.getUserName(userId);
			//request.getSession().setAttribute("userName", userName);
			User user = ls.getUserDetails(userId);
			//request.getSession().setAttribute("user", user);
			//response.sendRedirect("success.jsp");
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}else{
			response.sendRedirect("error.jsp");
		}
		
	}

}
