package com.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i;
		i = Integer.parseInt(request.getParameter("bookId"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "source_mantra_db";
		String user = "root";
		String password = "ClaraPark728!";
		try{
			//add password
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/source_mantra_db",user,password);
			String ps = "delete from books where bookId=?;";
			PreparedStatement statement = conn.prepareStatement(ps);
			statement.setInt(1,i);
			int k = statement.executeUpdate();
			if(k == 1){
				out.println("<h1> Book successfully deleted!");
			}else{
				out.println("<h1> Book not successfully deleted :(");
			}
			
			conn.close();
		}catch(Exception ce){
			ce.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
