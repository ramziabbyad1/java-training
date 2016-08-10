package com.sourcemantra.updatedb;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class UpdateBook2 {

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
			System.out.println("Update on bookId");
			System.out.println("Enter Book Id: ");
			i = Integer.parseInt(br.readLine());
			System.out.println("Enter book title");
			t = br.readLine();
			System.out.println("Enter book author: ");
			a = br.readLine();
			System.out.println("Enter price:");
			p = Float.parseFloat(br.readLine());
			System.out.println("Enter date published(YYYY-MM-DD):");
			String s = br.readLine();
			/*
			 *DateFormat df = new SimpleDateFormal("MM-dd-yyyy")
			 *d = df.parse(s); 
			 * */
			//java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			//DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			//d = df.parse(s);
			d = Date.valueOf(s);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url + dbname,username,password);
			String preparedStatement = "update books set title=?, author=?, price=?, datePub=? WHERE bookId=?";
			PreparedStatement ps = conn.prepareStatement(preparedStatement);
			ps.setString(1, t);
			ps.setString(2, a);
			ps.setFloat(3, p);
			ps.setDate(4, d);
			ps.setInt(5, i);
			int k = ps.executeUpdate();
			if(k==1)
				System.out.println("Query OK. 1 row updated.");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
