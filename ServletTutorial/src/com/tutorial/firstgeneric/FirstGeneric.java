package com.tutorial.firstgeneric;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns={"/FirstGeneric"})
public class FirstGeneric extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		ServletContext c = req.getServletContext();
		AsyncContext ac = req.getAsyncContext();
		String path = c.getContextPath();
		PrintWriter out = res.getWriter();
		out.println("Request Servlet Context Path : " + path);
		out.println("Async context pathh "+ac.ASYNC_CONTEXT_PATH);
		//c.getServletRegistrations();
		//c.getSessionCookieConfig();

	}

}
