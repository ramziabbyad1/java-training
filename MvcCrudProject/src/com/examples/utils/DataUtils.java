package com.examples.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataUtils {
	private static Connection conn;

	public static Connection getConnection() {
		if(conn != null)
			return conn;
		else{
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/source_mantra_db","root","ClaraPark728!");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
	}
	
}
