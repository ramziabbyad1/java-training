package com.tutorial.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Cookie[] cookies = req.getCookies();
		out.println("cookies size: " + cookies.length);
		String n = cookies[0].getValue();
		out.println("<html><body>");
		out.println("<h1> Howdy " +n +"!</h1>");
		out.println("</body></html>");
		out.close();
	}

}
