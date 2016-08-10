package com.examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/ProcessServlet")
public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("Passing through filter... request");
		if(name != null && name.length()>0 && !name.equals("")){
			name = name.toUpperCase();
			request.setAttribute("myUsername", name);
		}else{
			name = "DEFAULT_USERNAME";
			request.setAttribute("myUsername", name);
		}
		
		// pass the request along the filter chain acts as a seperator between request and response
		chain.doFilter(request, response);
		out.println("<br/>Passing through the filter...respnse");
		out.println("<br/><img src=\"farkaslemma.png\" height=\"200\" width=\"400\">");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
