package com.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import sun.org.mozilla.javascript.internal.Context;

public class MyServlet implements Servlet {
	ServletContext context;
	@Override
	public void destroy() {
		System.out.println("First servlet implementing Servlet destroyed");

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
		System.out.println("First servlet implementing Servlet created");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>Hello World from my servlet");
		out.println("<br/> Admin " + context.getInitParameter("admin"));
	}

}
