package com.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
	/*	Cookie cookie = new Cookie("name",name);
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);*/
	/*	HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");*/
		
		out.println("<h1>Welcome : " + name.toUpperCase()+"</h1>");
		out.println("<form action=\"Servlet2\">");
		out.println("<br/>Enter no1 : <input type = \"text\" name=\"no1\"/>");
		out.println("<br/>Enter no2 : <input type = \"text\" name=\"no2\"/>");
		out.println("<br/> <input type =\"submit\" value=\"Submit\">");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
