

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ShowBooksServlet
 */
@WebServlet("/ShowBooksServlet")
public class ShowBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		/*String url = "jdbc:mysql://localhost:3306/";
		String dbName = "source_mantra_db";
		String user = "root";
		String password = "ClaraPark728!";*/
		 
		try{
			//add password
			/*Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/source_mantra_db",user,password);*/
			Context context = new InitialContext();
			//for tomcat the following works java: prefix is universal, but env/jdbc is tomcat specific
			//and jdbc/mydatabase is from "name" in the xml file
			//DataSource dSource = (DataSource)context.lookup("java:comp/env/jdbc/mydatabase");
			DataSource dSource = (DataSource)context.lookup("java:comp/env/jdbc/MyDB");
			conn = dSource.getConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from books");
			out.println("<h1> List of Books");
			out.println("<table border=\"1\">");
			out.println("<tr><th>BookId</th><th>Title</th>"
					+ "<th>Author</th>thPrice</th><th>Date published</th></tr>");
			int i =0; String t = null; String a = null; float p= 0.0f; Date d = null;
			while(rs.next()){
				i = rs.getInt(1);
				t = rs.getString(2);
				a = rs.getString(3);
				p = rs.getFloat(4);
				d = rs.getDate(5);
				out.println("<tr><td>"+i+"</td><td>"+t+"</td><td>"+a+"</td><td>"+p+"</td><td>"+d+"</td></tr>");
			}
			conn.close();
		}catch(Exception ce){
			ce.printStackTrace();
		}
	}

}
