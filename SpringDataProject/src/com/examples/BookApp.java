package com.examples;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.beans.Book;
import com.examples.dao.BookDao;
import com.examples.dao.HibernateDao;

public class BookApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext();
		BookDao dao = context.getBean("bookDao",BookDao.class);
		List<Book> books = dao.getBooks();
		for(Book b:books){
			System.out.println(b);
		}
		System.out.println("------hibernate-------------");
		HibernateDao hibdao = context.getBean("hibDao",HibernateDao.class);
		List<?> listOfBooks = hibdao.getAllBooks();
		Book b = null;
		for(Object o:listOfBooks){
			b = (Book) o;
			System.out.println(b);
		}
	}

}
