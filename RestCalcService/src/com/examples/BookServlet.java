package com.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/xml");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String ans = null;
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource webResource = null;
		webResource = client.resource("http://localhost:8081/RestCalcService/jaxrs/RestCalc/listBooks");
		ans = webResource.accept(MediaType.APPLICATION_XML).get(String.class);
		//pw.println(ans);
		List<Book> books = new ArrayList<>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=null;
		Document document = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			document = builder.parse(new InputSource(new StringReader(ans)));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NodeList nodeListBookId = document.getElementsByTagName("bookId");
		NodeList nodeListBookAuthor = document.getElementsByTagName("title");
		NodeList nodeListBookTitle = document.getElementsByTagName("author");
		NodeList nodeListBookPrice = document.getElementsByTagName("price");
		NodeList nodeListBookDate = document.getElementsByTagName("datePub");
		
		Book b = null;
		for(int i = 0; i < nodeListBookId.getLength();i++){
			b = new Book();
			Element bid = (Element)nodeListBookId.item(i);
			Element btit = (Element)nodeListBookTitle.item(i);
			Element bauth = (Element)nodeListBookAuthor.item(i);
			Element bprice = (Element)nodeListBookPrice.item(i);
			Element bdpub = (Element)nodeListBookDate.item(i);
			b.setId(Integer.parseInt(bid.getFirstChild().getNodeValue()));
			b.setTitle(btit.getFirstChild().getNodeValue());
			b.setAuthor(bauth.getFirstChild().getNodeValue());
			b.setPrice(Float.parseFloat(bprice.getFirstChild().getNodeValue()));
			String d = bdpub.getFirstChild().getNodeValue();
			DateFormat df = new SimpleDateFormat("YYYY-MM-DD");
			try {
				b.setDatePub(df.parse(d));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			books.add(b);
		}
		pw.println("<table border=\"1\">");
		for(Book book:books){
			pw.println("<tr>");
			pw.println("<td>");
			pw.println(book.getTitle());
			pw.println("</td>");
			pw.println("<td>");
			pw.println(book.getAuthor());
			pw.println("</td>");
			pw.println("<td>");
			pw.println(book.getPrice());
			pw.println("</td>");
			pw.println("<td>");
			pw.println(book.getDatePub());
			pw.println("</td>");
			pw.println("</tr>");
		}
		pw.println("<table/>");
	}

}
