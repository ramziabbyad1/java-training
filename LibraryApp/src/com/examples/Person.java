package com.examples;

import java.util.ArrayList;

public class Person {
	private String name;
	private int maxBooks;
	private ArrayList<Book> books;
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	public Person(){
		this.name = "Unknown";
		this.maxBooks = 3;
		books = new ArrayList<>();
	}
	public Person(String name){
		this.name = name;
		this.maxBooks = 3;
		books = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxBooks() {
		return maxBooks;
	}
	public void setMaxBooks(int maxBooks) {
		this.maxBooks = maxBooks;
	}
	public void checkInBook(Book b1){
		books.remove(b1);
	}
	public void checkOutBook(Book b2){
		books.add(b2);
	}

	@Override
	public String toString() {
		return name + " ("+maxBooks+" Books)";
	}
	
	
}
