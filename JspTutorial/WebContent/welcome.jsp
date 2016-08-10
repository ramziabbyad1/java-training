<%@page import="java.util.Enumeration"%>
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
	String s = request.getParameter("uname");
	Enumeration<String> initparams = config.getInitParameterNames();
	out.println("Hello from welcome app " + s);
	out.println("Driver : " + application.getInitParameter("ndriver"));
%>
</body>
</html>