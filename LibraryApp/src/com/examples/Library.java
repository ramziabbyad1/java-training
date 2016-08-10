package com.examples;

import java.util.ArrayList;

public class Library {

	
	public String name;
	private int total_books = 0;
	private int counter = 0;
	public ArrayList<Book> books;
	public ArrayList<Person> persons;

	public Library(String name) {
		this.name = name;
		books = new ArrayList<>();
		persons = new ArrayList<>();
		
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public void addBook(Book b1) {
		counter++;
		total_books++;
		books.add(b1);
		
	}

	public void removePerson(Person p1) {
		persons.remove(p1);
		
	}

	public void addPerson(Person p1) {
		persons.add(p1);
		
	}

	public ArrayList<Person> getPeople() {
		return persons;
	}

	public void removeBook(Book b1) {
		total_books--;
		books.remove(b1);
		
	}

	public boolean checkoutBook(Book b1, Person p1) throws MaxBooksException, CheckOutException {
		if(p1.getBooks().size()<p1.getMaxBooks() && !b1.isCheckedOut()){
			b1.setPerson(p1);
			counter--;
			return true;
		}else{
			if(p1.getBooks().size()>=p1.getMaxBooks()){
				throw new MaxBooksException(p1.getName());
			}
			if(b1.isCheckedOut()){
				throw new CheckOutException(b1.getTitle());
			}
			return false;
		}
	}

	public boolean checkinBook(Book b1) {
		if(b1.isCheckedOut()){
			b1.setCheckedOut(false);
			counter++;
			return true;
		}else{
			System.out.println(b1+" hasn't been checkedout yet! Can't return.");
			return false;
		}
	}
	
	private void status(){
		/*
		 * Name:-
		 * No of Books:-5 books
		 * No of Persons- 5 persons
		 * Available Books:-3
		 */
		System.out.println("Total number of books : " +books.size());
		System.out.println("No of books available: " + counter);
		System.out.println("No of library members : " + persons.size());
		System.out.println("------Summarry of all books---------");
		for(int i =0; i < books.size(); i++){
			System.out.println(books.get(i));
		}
		System.out.println("------Summary of all people-----");
		for(int i =0; i < persons.size(); i++){
			System.out.println(persons.get(i));
		}
	}
	@Override
	public String toString() {
		return "Library [name=" + name + ", books=" + books + ", persons="
				+ persons + "]";
	}
	
	public void init(){
		
	}

	public static void main(String[] args){
		/*
		 * create lib
		 * create Persons and Books
		 * display the status of lib
		 * checkout books
		 * display the status
		 * checkout books
		 * checkin book
		 * display the status
		 */
		//System.out.println("DO");
		Library library = new Library("Comic books library");
		
		Book b1 = new Book("The Fantastic Four");
		b1.setAuthor("Billy Bob");
		Book b2 = new Book("X-Men");
		b2.setAuthor("Billy Bo");
		Book b3 = new Book("Aliens");
		b3.setAuthor("Jimbo James");
		Book b4 = new Book("Predator");
		b4.setAuthor("Santa Sally");
		library.addBook(b1);
		library.addBook(b2);
		library.addBook(b3);
		library.addBook(b4);
		
		Person p1 = new Person("Ramzi Abbyad");
		Person p2 = new Person("Ramzi White");
		Person p3 = new Person("Han Solo");
		Person p4 = new Person("Chewy");
		library.addPerson(p1);
		library.addPerson(p2);
		library.addPerson(p3);
		library.addPerson(p4);
		
		library.status();
		
		try {
			library.checkoutBook(b1, p1);
			library.checkoutBook(b2, p1);
			library.checkoutBook(b3, p2);
			library.checkoutBook(b4, p4);
		} catch (MaxBooksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CheckOutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		library.status();
		
		library.checkinBook(b1);
		library.checkinBook(b3);
		
		library.status();
		

	}

}
