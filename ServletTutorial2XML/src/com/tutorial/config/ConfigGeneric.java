package com.tutorial.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet({"/servlet4"})
public class ConfigGeneric extends GenericServlet {
	ServletContext context = null;
	ServletConfig config =null;
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		context = getServletContext();
		config = getServletConfig();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String conf = config.getInitParameter("config");
		String cont = context.getInitParameter("context");
		out.println("<html><body>");
		out.println("<br/> <h1> Hi from servlet " + getServletName()+"</h1>");
		out.println("<br/><h3> configParam :</h3><h2> " + conf+"</h2>");
		out.println("<br/><h3> conextParam : </h3><h2>" + cont+"</h3>");
		out.println("</body></html>");

	}

}
