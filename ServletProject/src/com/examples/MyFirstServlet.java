package com.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet(name = "MyFirstServletCanChange", description = "This is my first servlet", urlPatterns = { "/MyFirstServletCanChange" })
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doProcess(request, response);
		response.setContentType("text/html");//can also send pdf and other learn about MIME types
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1> Peee from my first servlet.</h1>");
		out.println("<br/>Resquest Method: " + request.getMethod());
		out.println("<br/>Protocol used: " + request.getProtocol());
		out.println("<br/>you ip address : " + request.getRemoteAddr());
		out.println("<br/>server ip address : " + request.getLocalAddr());
		out.println("<br/>server port : " + request.getServerPort());
		Enumeration<String> e = request.getHeaderNames();

		while(e.hasMoreElements()){
			String s = e.nextElement();
			out.println("<br/>"+s+" : " + request.getHeader(s));
		}
		out.println("<br/><h2>Welcome "+request.getParameter("name")+"</h2>");
		out.println("<br/><h3>You are a " + request.getParameter("desig")+"</h2>");
		out.println("<br/><h3>Your password is:  " + request.getParameter("pswd")+"</h2>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doProcess(request, response);
		doGet(request,response);
		
	}
	
/*	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//can also send pdf and other learn about MIME types
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1> Hello from my first servlet.</h1>");
		out.println("<br/>Resquest Method: " + request.getMethod());
		out.println("<br/>Protocol used: " + request.getProtocol());
		out.println("<br/>you ip address : " + request.getRemoteAddr());
		out.println("<br/>server ip address : " + request.getLocalAddr());
		out.println("<br/>server port : " + request.getServerPort());
		Enumeration<String> e = request.getHeaderNames();

		while(e.hasMoreElements()){
			String s = e.nextElement();
			out.println("<br/>"+s+" : " + request.getHeader(s));
		}
		out.println("<br/><h2>Welcome "+request.getParameter("name")+"</h2>");
		out.println("<br/><h3>You are a " + request.getParameter("desig")+"</h2>");
		out.println("<br/><h3>Your password is:  " + request.getParameter("pswd")+"</h2>");
		out.println("</body></html>");
	}*/

}
