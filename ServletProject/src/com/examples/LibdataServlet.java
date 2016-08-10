package com.examples;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LibdataServlet
 */
@WebServlet(urlPatterns="/LibdataServlet", loadOnStartup=1)
public class LibdataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn;
    private String driver;
    private String url;
    private String dbName;
    private String user;
    private String password;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibdataServlet() {
        super();
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/";
        dbName = "source_mantra_db";
        user = "root";
        password = "ClaraPark728!";
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = null;
		//this gets the driver and registers it{
		
			try {
				try {
					Class.forName(driver).newInstance();
					conn = DriverManager.getConnection(url + dbName,user,password);
					Statement statement = conn.createStatement();
					
					ResultSet resultSet =statement.executeQuery("select * from books");
					int i = 0; String t=null; String a=null; float p = 0.0f;Date d=null;
					while(resultSet.next()){
						i = resultSet.getInt("bookId");
						t = resultSet.getString("title");
						a = resultSet.getString("author");
						p = resultSet.getFloat("price");
						d = resultSet.getDate("datePub");
						System.out.println(i + "\t" +t+"\t"+a+"\t"+p+"\t"+d);
					}
					
				}finally{
					conn.close();
				}
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
