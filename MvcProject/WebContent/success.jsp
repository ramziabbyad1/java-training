<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@page import="com.examples.model.User" %>
<body>
	<h1>Login Successful!!</h1>
	<%
		//User u = (User) request.getSession().getAttribute("user");
		User u = (User) request.getAttribute("user");
	%>
	<h2>Welcome : <%=u.getUserName() %></h2>
	<h2>Phone : <%=u.getPhone() %></h2>
	<hr/>
	<h1>Using use bean</h1>
	<%-- <jsp:useBean id="user" class="com.examples.model.User" scope="session"></jsp:useBean>--%>
	<jsp:useBean id="user" class="com.examples.model.User" scope="request"></jsp:useBean>
	<h2>Welcome : <jsp:getProperty property="userName" name="user"/></h2>
	<br/>Phone : <jsp:getProperty property="phone" name="user"/>
</body>
</html>