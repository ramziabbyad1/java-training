package com.tutorial.eventlistener;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/fetch"})
public class FetchData extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			ServletContext context = getServletContext();
			Connection conn = (Connection)context.getAttribute("myconn");
			if(conn==null)System.out.println("Something very very wrong");
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			try {
				PreparedStatement ps = conn.prepareStatement("select firstName,lastName from customers;");
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					out.println("<br/>firstName: "+rs.getString(1) +" lastName: "+rs.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				out.close();
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
	
	}
}
