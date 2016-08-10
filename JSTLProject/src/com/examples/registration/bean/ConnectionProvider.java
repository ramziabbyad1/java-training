package com.examples.registration.bean;
import java.sql.*;
import static com.examples.registration.bean.Provider.*;

public class ConnectionProvider {
	private static Connection con = null;
	static{
		try{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
		}catch(Exception e){e.printStackTrace();}
	}
	public static Connection getConnection(){
		return con;
	}
}
