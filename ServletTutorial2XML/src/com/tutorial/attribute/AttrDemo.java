package com.tutorial.attribute;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AttrDemo
 */
@WebServlet("/AttrDemo")
public class AttrDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		context.setAttribute("company", "IBM");
		out.println("<html><body>");
		out.println("<h1>Welcome to the first servlet</h1>");
		out.println("<br/><a href='servletAttrReceive'>Visit</a>");
		out.println("</body></html>");
		out.close();
	}

}
