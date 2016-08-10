package com.tutorial.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String n = req.getParameter("name");
		Cookie cookie = new Cookie("name", n);
		resp.addCookie(cookie);
		out.println("<html><body>");
		out.println("<form action='servlet2' method='POST'>");
		out.println("<input type='submit' value='Go'/>");
		out.println("</form>");
		out.println("</body></html>");
		out.close();
	}
}
