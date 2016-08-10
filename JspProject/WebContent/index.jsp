<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Date date = new Date();
		out.println("<br> date : " + date);
	%>
<h1>Hello from first JSP.</h1>
<h2>Source mantra</h2>
	<% 
		int i = 10;
		int j = 20;
		out.println("<br/> i = " + i);
		out.println("<br/> j = " + j);
		String s = "Hello";
		if(i > j)
			out.println("<br/> i is greater");
		else
			out.println("<br/> j is greater");
		for(int k=1; k <=5;k++){
	%>
	<p>Hello</p>
	<%
			out.println("<br/> k = " + k);
		}
		
	%>
	<%!
		public int add(int a, int b){
			return a+b;
		}
	%>
	<br/> 5*25 = <%--<%=5*25 %> --%>
	<br/> 6+25 = <!--<%=add(6,25) %>-->
	<br/>10+20 =
	<jsp:expression>
		add(10,20)
	</jsp:expression>
	
	<%@ include file="another.jsp" %>
	<form action="ans.jsp">
		<br/>Enter name: <input type="text" name="name"/>
		<br/><input type="submit" value="Submit"/>
	</form>
</body>
</html>