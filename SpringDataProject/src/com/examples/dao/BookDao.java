package com.examples.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.examples.beans.Book;

public class BookDao {
	private DataSource dataSource;
	private List<Book> books;
	private JdbcTemplate jdbcTemplate;
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	public List<Book> getBooks() {
		String sql = "select * from books";
		List<Book> books = jdbcTemplate.query(sql, new BookMapper());
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
}
