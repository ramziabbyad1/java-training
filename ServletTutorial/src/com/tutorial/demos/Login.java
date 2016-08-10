package com.tutorial.demos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/servlet1")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n = request.getParameter("userName");
		String p = request.getParameter("userPass");
		
		RequestDispatcher rd = null;
		if(p.equals("servlet")){
			rd = request.getRequestDispatcher("servlet2");
			rd.forward(request, response);
		}else{
			out.println("User name or password error");
			rd = request.getRequestDispatcher("/index1.html");
			rd.include(request, response);
		}
	}

}
