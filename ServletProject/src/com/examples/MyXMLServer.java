package com.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyXMLServer extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1> Hello from my xml servlet. </h1>");
		out.println("<br/> abc = " + getServletContext().getInitParameter("admin"));
	}

}
