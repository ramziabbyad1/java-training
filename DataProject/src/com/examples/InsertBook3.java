package com.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertBook3 {

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
			System.out.println("Enter Book Id: ");
			i = Integer.parseInt(br.readLine());

			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbname,username,password);
			CallableStatement cs = conn.prepareCall("call deleteBook(?)");
			conn.setAutoCommit(false);
			cs.setInt(1, i);
			int k = cs.executeUpdate();
			//this is the old style enterprise java beans are typically used JP technology
			if(k==1){
				conn.commit();
				System.out.println("Query OK. 1 row deleted.");
			}else{
				conn.rollback();
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
