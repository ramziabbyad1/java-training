<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	String n1 = request.getParameter("n1");
	String n2 = request.getParameter("n2");
	
	int a = Integer.parseInt(n1);
	int b = Integer.parseInt(n2);
	
	int c = a/b;
	out.println("a/b = " + c);
%>
</body>
</html>