package com.examples;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void testPerson() {
		Person p1 = new Person();
		assertEquals("Unknown", p1.getName());
		assertEquals(3, p1.getMaxBooks());
	}

	@Test
	public void testSetName() {
		Person p2 = new Person();
		p2.setName("John Doe");
		assertEquals("John Doe", p2.getName());
	}

	@Test
	public void testSetMaxBooks() {
		Person p3 = new Person();
		p3.setMaxBooks(10);
		assertEquals(10, p3.getMaxBooks());
	}
	
	@Test
	public void testToString(){
		Person p4 = new Person();
		p4.setName("Jane Doe");
		p4.setMaxBooks(10);
		String s = "Jane Doe (10 Books)";
		assertEquals(s, p4.toString());
	}

}
