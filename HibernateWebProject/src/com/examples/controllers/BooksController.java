package com.examples.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.dao.BookDao;
import com.examples.entity.Book;

@WebServlet("/BooksController")
public class BooksController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		BookDao dao = new BookDao();
		List<?> books = dao.getAllBooks();
		Book b = null;
		out.println("Title"+"\t"+"Author"+"\t"+"Price"+"\t"+"Date");
		for(Object o:books){
			b = (Book) o;
			out.println(b.getTitle()+"\t" + b.getAuthor()+"\t"+b.getPrice()+"\t"+b.getDatePub());
		}
		out.println("</body></html>");
		
	
	}

}
