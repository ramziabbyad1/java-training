package com.examples;

import java.util.ArrayList;
import java.util.List;

public class BookBean {
	private List<Book> books;
	private Book book;
	private BookDao dao;
	public BookBean(){
		books= new ArrayList<>();
		book = new Book();
		dao = new BookDao();
	}
	
	public String add(){
		dao.addBook(book);
		return "book added";
	}

	public List<Book> getBooks() {
		books=dao.getAllBooks();
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
}
