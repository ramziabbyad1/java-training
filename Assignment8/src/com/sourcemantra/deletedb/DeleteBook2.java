package com.sourcemantra.deletedb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteBook2 {
	public static void main(String[] args) {
		int i=0;String t=null;String a=null;
		float p=0.0f; Date d = null;
		Connection conn = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbname = "source_mantra_db";
		String username = "root";
		String password = "ClaraPark728!";
		BufferedReader br = new BufferedReader(
								new InputStreamReader(System.in));
		try{
			System.out.println("Delete row by book ID");
			System.out.println("Enter Book Id: ");
			i = Integer.parseInt(br.readLine());

			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbname,username,password);
			PreparedStatement ps = conn.prepareStatement("delete from books where bookId=?");
			ps.setInt(1, i);
			int k = ps.executeUpdate();
			if(k==1)
				System.out.println("Query OK. 1 row deleted.");
			conn.close();
			//ResultSet resultSet =statement.executeQuery("select * from books");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
