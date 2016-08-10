package com.libdata;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertBookServlet
 */
@WebServlet("/InsertBookServlet")
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i; String t = null; String a = null; float p= 0.0f; Date d = null;
		i = Integer.parseInt(request.getParameter("bookId"));
		t = request.getParameter("title");
		a = request.getParameter("author");
		p = Float.parseFloat(request.getParameter("price"));
		d = Date.valueOf(request.getParameter("datePub"));
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
			String ps = "insert into books (title,author,price,datePub,bookId) values(?,?,?,?,?);";
			PreparedStatement statement = conn.prepareStatement(ps);
			statement.setString(1, t);
			statement.setString(2, a);
			statement.setFloat(3, p);
			statement.setDate(4,d);
			statement.setInt(5,i);
			int k = statement.executeUpdate();
			if(k == 1){
				out.println("<h1> Book successfully inserted!");
			}else{
				out.println("<h1> Book not successfully inserted :(");
			}
			
			conn.close();
		}catch(Exception ce){
			ce.printStackTrace();
		}
	}

}
