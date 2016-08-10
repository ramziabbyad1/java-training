package com.tutorial.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextVConfig
 */

public class ContextVConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();
		out.println("<html><body>");
		out.println("<br/> <h1> Hi from servlet " + getServletName()+"</h1>");
		out.println("<br/><h3> configParam :</h3><h2> " + config.getInitParameter("config")+"</h2>");
		out.println("<br/><h3> conextParam : </h3><h2>" + context.getInitParameter("context")+"</h3>");
		out.println("</body></html>");
	}

}
