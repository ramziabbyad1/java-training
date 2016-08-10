package com.examples.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Student {
	
	private int id;
	private String name;
	public Book book;
	public Book getBook() {
		return book;
	}
	@Autowired
	public void setBook(Book book) {
		this.book = book;
	}
	public int getId() {
		return id;
	}
	@Required
	@Value("1000")
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Value("Ramzi")
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", book=" + book + "]";
	}
	
}
