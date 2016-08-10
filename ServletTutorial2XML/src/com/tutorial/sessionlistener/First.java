package com.tutorial.sessionlistener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/welcomepage")
public class First extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String name = req.getParameter("name");
		//HttpSession session = req.getSession();
		ServletContext context = getServletContext();
		
		HttpSession session = req.getSession();
		session.setAttribute("uname", name);
		//int current = (Integer)context.getAttribute("current");
		//int total = (Integer)context.getAttribute("total");
		int current = (Integer) session.getServletContext().getAttribute("current");
		int total = (Integer)session.getServletContext().getAttribute("total");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<br>Total number of users " + total);
		out.println("<br>Current number of users " + current);
		out.println("<a href='LogoutServlet'>logout</a>");
		out.println("</body></html>");
	}
}
