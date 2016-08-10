package com.dao;

import java.sql.DriverManager;

public class OracleConnect {

	public static void main(String[] args) {
		Class.forName("oracle.jdbc.driver.OraceDriver").newInstance();
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","root","ClaraPark728!");
		

	}

}
