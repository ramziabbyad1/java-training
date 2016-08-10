package com.sourcemantra.deletedb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteBook1 {

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
			/*
			 *DateFormat df = new SimpleDateFormal("MM-dd-yyyy")
			 *d = df.parse(s); 
			 * */
			//java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbname,username,password);
			Statement statement = conn.createStatement();
			int k = statement.executeUpdate("delete from books where bookId="+i);
			if(k==1)
				System.out.println("Query OK. 1 row deleted.");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
