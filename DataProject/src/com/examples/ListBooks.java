package com.examples;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbname = "source_mantra_db";
		String username = "root";
		String password = "ClaraPark728!";
		Connection conn = null;
		//this gets the driver and registers it{
		
			try {
				try {
					Class.forName(driver).newInstance();
					conn = DriverManager.getConnection(url + dbname,username,password);
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

}
