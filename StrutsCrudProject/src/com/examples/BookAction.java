package com.examples;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Book> books = new ArrayList<>();
	private BookDao dao = new BookDao();
	@Override
	public String execute() throws Exception {
		//String result = null;
		books = dao.getAllBooks();
		
		return "list";
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	
}
