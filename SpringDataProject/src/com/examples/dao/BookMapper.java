package com.examples.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.examples.beans.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int arg1) throws SQLException {
		Book b = new Book();
		b.setId(rs.getInt("bookID"));
		b.setAuthor(rs.getString("author"));
		b.setAuthor(rs.getString("title"));
		b.setPrice(rs.getFloat("price"));
		b.setDatePub(rs.getDate("datePub"));
		return b;
	}

}
