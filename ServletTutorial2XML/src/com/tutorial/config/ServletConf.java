package com.tutorial.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet({"/servlet5"})
public class ServletConf implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	ServletConfig config = null;
	ServletContext context = null;
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		context = config.getServletContext();

	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String conf = config.getInitParameter("config");
		String cont = context.getInitParameter("context");
		out.println("<html><body>");
		out.println("<br/> <h1> Hi from servlet " + config.getServletName()+"</h1>");
		out.println("<br/><h3> configParam :</h3><h2> " + conf+"</h2>");
		out.println("<br/><h3> conextParam : </h3><h2>" + cont+"</h3>");
		out.println("</body></html>");

	}

}
