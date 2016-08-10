package com.tutorial.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
@WebServlet(name = "FirstServlet", description = "This is my first servlet", urlPatterns = { "/FirstServlet" },
			initParams={
				@WebInitParam(name= "variable", value="1000"),
				@WebInitParam(name="Hello", value="World")
})
public class First implements Servlet {

	@Override
	public void destroy() {
		System.out.println("Destroying servlet now.");

	}

	@Override
	public ServletConfig getServletConfig() {
		
		return config;
	}

	@Override
	public String getServletInfo() {
		return "Copy right 2014 March 8";
	}
	ServletConfig config = null;
	ServletContext context = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		context = config.getServletContext();
		//System.out.println(context);
		System.out.println("First servlet implementing Servlet created");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("I just served a request!!!");
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.println("<h>I can talk!</h>");
		out.println("<h2>Here is my config info:</h2>");
		out.println(getServletConfig());
		out.println("<h2>Here is when I was born:</h2>");
		out.println(getServletInfo());
		out.println("<h2>Check out these cool web init params...</h2>");
		Enumeration<String> names = config.getInitParameterNames();
		
		while(names.hasMoreElements()){
			String name = names.nextElement();
			out.println("<h2>variable name =    </h2>" + name);
			out.println("<h2>variable value =   </h2>"+config.getInitParameter(name));
		}
		out.close();
		
	}

}
