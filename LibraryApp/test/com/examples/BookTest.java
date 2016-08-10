package com.examples;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void testBook() {
		Book b1 = new Book("Learning Java");
		assertEquals("Learning Java", b1.title);
		assertEquals("Unknown Author", b1.author);
	}
	
	@Test
	public void testGetPerson(){
		Book b2 = new Book("Learning Spring");
		Person p2 = new Person();
		p2.setName("Pee pee");
		b2.setPerson(p2);
		Person testPerson = b2.getPerson();
		String testName = testPerson.getName();
		assertEquals("Pee pee", testName);
		
	}
	
	@Test
	public void testToString(){
		/*
		 * Learn Java available
		 * Learn Java checkout out to John Doe
		 */
		Book b = new Book("Learn Java");
		assertEquals("Learn Java is available", b.toString());
	}

}
