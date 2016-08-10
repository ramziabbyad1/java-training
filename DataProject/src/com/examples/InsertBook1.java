package com.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertBook1 {

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
			System.out.println("Enter book title");
			t = br.readLine();
			System.out.println("Enter book author: ");
			a = br.readLine();
			System.out.println("Enter price:");
			p = Float.parseFloat(br.readLine());
			System.out.println("Enter date published:");
			String s = br.readLine();
			/*
			 *DateFormat df = new SimpleDateFormal("MM-dd-yyyy")
			 *d = df.parse(s); 
			 * */
			//java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			d = Date.valueOf(s);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url + dbname,username,password);
			Statement statement = conn.createStatement();
			int k = statement.executeUpdate("insert into books values('"+i+"','" +t+"', '"+a+"','" +p+"', '"+d+")");
			if(k==1)
				System.out.println("Query OK. 1 row added.");
			conn.close();
			//ResultSet resultSet =statement.executeQuery("select * from books");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
