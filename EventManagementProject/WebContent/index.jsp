<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.dao.EventDao" import="java.util.List"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
	EventDao dao = new EventDao();
	List<?> events = dao.getAllEvents();
	request.setAttribute("events", events);
	
%>
	<c:out value="${events}"></c:out>
	<h1>List of books</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Event Name</th>
				<th>Event Details</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${events}" var="e">
				<tr>
					<td><c:out value="${e.name }"></c:out></td>
					<td><a href="details.jsp?id=<c:out value="${e.id}"/>">Details</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>