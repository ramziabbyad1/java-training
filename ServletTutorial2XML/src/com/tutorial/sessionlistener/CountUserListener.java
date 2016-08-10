package com.tutorial.sessionlistener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.Session;

@WebListener
public class CountUserListener implements HttpSessionListener {
	ServletContext context = null;
	static int total=0,current=0;
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		context = event.getSession().getServletContext();
		total++;
		current++;
		context.setAttribute("total", total);
		context.setAttribute("current", current);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		current--;
		context.setAttribute("current", current);
	}

}
