package com.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//String name = request.getParameter("name");
		/*Cookie[] cookies = request.getCookies();
		String name = null;
		if(cookies != null){
			for(Cookie c:cookies){
				if(c.getName().equals("name")){
					name = c.getValue();
					name = name.toUpperCase();
				}
			}
		}*/
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		int no1 = Integer.parseInt(request.getParameter("no1"));
		int no2 = Integer.parseInt(request.getParameter("no2"));
		int ans = no1+no2;
		out.println("<h1>Welcome " + name + "</h1>");
		out.println("<h2> Ans : " + ans+"</h2>");
		RequestDispatcher rs = request.getRequestDispatcher("Servlet3");
		//ServletRequest arg0;
		rs.forward(request, response);
		//response.sendRedirect("Servlet3");
		
		
	}

}
