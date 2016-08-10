package com.tutorial.eventlistener;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}
	ServletContext context = null;
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Anyone OUT THERE>!>!");
		String uName = "root";
		String pWord = "ClaraPark728!";
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/source_mantra_db";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, uName, pWord);
			if(conn==null) System.out.println("Internal error...");
			else	System.out.println("hi...");
			context = event.getServletContext();
			context.setAttribute("myconn", conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
