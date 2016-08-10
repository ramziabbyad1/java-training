package com.examples;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class LibraryTest {

	public Book b1;
	private Book b2;
	private Book b3;
	private Library lib;
	private Person p1;
	private Person p2;

	@Before
	public void setUp(){
		b1 = new Book("Learn Java");
		b2 = new Book("Learn Spring");
		b3 = new Book("Third Book");
		p1 = new Person();
		p2 = new Person();
		p1.setName("John Doe");
		p2.setName("Jane Doe");
		lib = new Library("Test");
		
	}

	@Test
	public void testLibrary() {
		Library test = new Library("Test");
		assertEquals("Test", test.name);
		assertTrue(test.books instanceof ArrayList);
		assertTrue(test.persons instanceof ArrayList);
	}

	@Test
	public void testAddBook(){
		setUp();
		assertEquals(0, lib.getBooks().size());
		lib.addBook(b1);
		lib.addBook(b2);
		assertEquals(2, lib.getBooks().size());
		assertEquals(0, lib.getBooks().indexOf(b1));
		assertEquals(1, lib.getBooks().indexOf(b2));
		lib.removeBook(b1);
		assertEquals(1, lib.getBooks().size());
		assertEquals(0, lib.getBooks().indexOf(b2));
		lib.removeBook(b2);
		assertEquals(0, lib.getBooks().size());
	}
	
	@Test
	public void testAddPeople(){
		setUp();
		assertEquals(0, lib.getPeople().size());
		lib.addPerson(p1);
		lib.addPerson(p2);
		assertEquals(2, lib.getPeople().size());
		assertEquals(0, lib.getPeople().indexOf(p1));
		assertEquals(1, lib.getPeople().indexOf(p2));
		lib.removePerson(p1);
		assertEquals(1, lib.getPeople().size());
		assertEquals(0, lib.getPeople().indexOf(p2));
		lib.removePerson(p2);
		assertEquals(0, lib.getPeople().size());
		
	}
	
	@Test
	public void testCheckoutBook(){
		setUp();
		//p1.setMaxBooks(1);
		addItems();
		//p1.checkOutBook(b2);
		System.out.println(p1.getBooks());
		try {
			assertTrue("The book did not checkout properly", lib.checkoutBook(b1, p1));
			assertFalse("Can't return a book that hasn't been checked out...", lib.checkinBook(b3));
		} catch (MaxBooksException | CheckOutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//assertFalse("Max Book limit exceeded", lib.checkoutBook(b2,p1);
		/*assertEquals("John Doe", b1.getPerson().getName());
		assertFalse("The book is already checked out", lib.checkoutBook(b1, p2));
		assertTrue("Book check in failed", lib.checkinBook(b1));
		assertFalse("Book is already checked in.", lib.checkinBook(b1));
		assertFalse("Book was never checked out.", lib.checkinBook(b2));*/
	}
	@Test
	public void testGetUnavailableBooks(){
		setUp();
		addItems();
		
	}
	
	@Test
	public void testGetAvailableBooks(){
		setUp();
		addItems();
	}
	@Test
	public void testToString(){
		/*show name of the library and the no of books and persons*/
	}

	private void addItems() {
		lib.addBook(b1);
		lib.addBook(b2);
		lib.addPerson(p1);
		lib.addPerson(p2);
	}

}
