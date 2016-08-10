package com.tutorial.session;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet({"/session1"})
public class FirstServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String n = req.getParameter("name");
		HttpSession session = req.getSession();
		session.setAttribute("uname", n);
		out.println("<html><body>");
		out.println("<a href='session2'>Go!</a>");
		out.println("</body></html>");
		out.close();
	
	}
}
