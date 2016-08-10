package com.examples.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.examples.model.Book;
import com.examples.utils.DataUtils;

public class BookDao {
	private Connection conn;
	public BookDao(){
		conn = DataUtils.getConnection();
	}
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		Book b = null;
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from books;");
			while(rs.next()){
				b = new Book();
				b.setBookId(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getFloat(4));
				b.setDatePub(rs.getDate(5));
				books.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return books;
	}
	public void addBook(Book b) {
		try {
			PreparedStatement ps = conn.prepareStatement("insert into books (title,author,price,datePub,bookId) values(?,?,?,?,?);");
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setFloat(3, b.getPrice());
			ps.setDate(4, b.getDatePub());
			ps.setInt(5, b.getBookId());
			int k = ps.executeUpdate();
			if(k==1){
				System.out.println("Book added successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void editBook(Book b){
		System.out.println("Hello from edit");
		try {
			PreparedStatement ps = conn.prepareStatement("update books set title=?, author=?, price=?, datePub=? where bookId=?;");
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setFloat(3, b.getPrice());
			ps.setDate(4, b.getDatePub());
			ps.setInt(5, b.getBookId());
			int k = ps.executeUpdate();
			if(k==1){
				System.out.println("Book edited successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Book getCurrentBook(int id){
		Book b = new Book();
		//store result of
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("select * from books where bookId="+id+";");
			rs.next();
			b.setBookId(rs.getInt(1));
			b.setTitle(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getFloat(4));
			b.setDatePub(rs.getDate(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
}
