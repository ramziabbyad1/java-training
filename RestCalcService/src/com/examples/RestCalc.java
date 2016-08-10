package com.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("/RestCalc")
public class RestCalc {
	@GET
	@Path("/listBooks")
	@Produces(MediaType.APPLICATION_XML)
	public List<Book> listBooks(){
		List<Book> books = new ArrayList<>();
		Connection connection=null;
		Book book = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/source_mantra_db","root","ClaraPark728!");
			Statement statement  = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from books");
			while(rs.next()){
				book = new Book();
				book.setId(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getFloat(4));
				book.setDatePub(rs.getDate(5));
				books.add(book);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return books;
	}
	
	
}
