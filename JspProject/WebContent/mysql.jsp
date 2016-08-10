<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Something here</h1>
	<%
		int i = 0; String t = null; String a = null; float p = 0.0f; Date d = null;
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/source_mantra_db","root","ClaraPark728!");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from books;");
			out.println("<table><tr><th>id</th><th>title</th><th>author</th><th>price</th><th>date</th></tr>");
			rs.g
			while(rs.next()){
				i = rs.getInt(1);
				t = rs.getString(2);
				a = rs.getString(3);
				p = rs.getFloat(4);
				d = rs.getDate(5);
				out.println("<tr><td>"+i+"</td><td>"+t+"</td><td>"+a+"</td><td>"+p+"</td><td>"+d+"</td></tr>");
			}
			out.println("</table>");
		conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	%>
</body>
</html>