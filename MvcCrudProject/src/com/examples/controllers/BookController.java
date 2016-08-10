package com.examples.controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.examples.dao.BookDao;
import com.examples.model.Book;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LIST_BOOKS = "listbooks.jsp";
	private static final String INSERT_EDIT_BOOKS = "books.jsp";
	private static boolean add = false;
	private static boolean edit = false;
	private static boolean delete = false;
    private BookDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
    	super();
    	dao = new BookDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = null;
		
		String action =request.getParameter("action");
		Book b = null;
		//if(action != null)
			if(action.equals("list")){
				forward = LIST_BOOKS;		
				request.setAttribute("books", dao.getAllBooks());
	
			}else if(action.equals("edit")){
				forward=INSERT_EDIT_BOOKS;
				//request.setAttribute("edit", true);
				request.setAttribute("readonly", "readonly");
				
				//System.out.println("id = " + Integer.parseInt(request.getParameter("id")));
				edit = true;
				add = false;
				request.setAttribute("b", dao.getCurrentBook(Integer.parseInt(request.getParameter("id"))));
				
			}else if(action.equals("add")){
				forward = INSERT_EDIT_BOOKS;
				edit = false;
				add = true;
				//request.setAttribute("add", true);
				request.setAttribute("readonly", "");
				
			}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request,response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("bookId"));
		String t =request.getParameter("title");
		String a = request.getParameter("author");
		Float p = Float.parseFloat(request.getParameter("price"));
		Date d = Date.valueOf(request.getParameter("datePub"));
		Book b = null;
		b = new Book();
		b.setBookId(i);
		b.setTitle(t);
		b.setAuthor(a);
		b.setPrice(p);
		b.setDatePub(d);
		//boolean edit =Boolean.getBoolean(String.valueOf(request.getAttribute("edit")));
		//boolean add =Boolean.getBoolean(String.valueOf(request.getAttribute("add")));
		System.out.println("edit = " + edit);
		System.out.println("add = " + add);
		if(add)
			dao.addBook(b);
		else if(edit)
			dao.editBook(b);
		String forward = LIST_BOOKS;
		request.setAttribute("books", dao.getAllBooks());
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
		
	}

}
