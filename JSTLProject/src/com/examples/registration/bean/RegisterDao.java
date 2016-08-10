package com.examples.registration.bean;
import java.sql.*;

public class RegisterDao {
	public static int register(User u){
		int status = 0;
		try{
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into user432 (name,email,password) values(?,?,?)");
			ps.setString(1, u.getUname());
			ps.setString(2, u.getUemail());
			ps.setString(3, u.getUpass());
			status = ps.executeUpdate();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
}
