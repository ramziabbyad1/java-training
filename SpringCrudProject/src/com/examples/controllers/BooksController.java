package com.examples.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import com.examples.beans.Book;
import com.examples.dao.HibernateDao;

@Controller
@RequestMapping(value="BooksController")
public class BooksController {
	@RequestMapping(method=RequestMethod.GET, value="BooksController/list")
	public ModelAndView list(){
		ModelAndView mv = null;
		HibernateDao hibDao = new HibernateDao();
		List<Book> books = hibDao.getAllBooks();
		mv = new ModelAndView("listBooks");
		mv.addObject("books", books);
		return mv;
	}
	@RequestMapping(method=RequestMethod.GET, value="BooksController/add")
	public String add(){
		return "books";
	}
}
