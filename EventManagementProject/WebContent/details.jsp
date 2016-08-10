<%@page import="com.entity.Event"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.dao.DetailsDao"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body>
	
<%
	String id = request.getParameter("id");
	int id_in = Integer.parseInt(id);
	DetailsDao dao = new DetailsDao();
	Event event = dao.getEvent(id_in);
	session.setAttribute("event",event);
	request.setAttribute("location", event.getLocation());
	request.setAttribute("speakers", dao.getSpeakers(id_in));
	request.setAttribute("attendees_size", dao.getAttendeesSize(id_in));
	//request.setAttribute("location", event.getLocation());
	//request.setAttribute(arg0, arg1)
	
	//out.println("event id = " + id);
%>
	<h1>Event Details</h1>
	<h2>Event name:  <c:out value="${event.getName()}"/></h2>
	<h2>Location: <c:out value="${location.getName() }"/></h2>
	<a href="crud.jsp?action=update_location&id=${location.getId()}">Change Location</a>
	<h2>Speakers:</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Speaker</th>
				<th>Remove Speaker</th>
				<th>Update Speaker</th>
			</tr>
		</thead>
		<c:set var="i" value="${0}" />
		<c:forEach items="${speakers}" var="s">
			<tr>
				<c:set var="speaker_id" value="${s.getId()}"/>
				<td><c:out value="${s }"></c:out></td>
				<td><a href="crud.jsp?action=delete_speaker&id=${speaker_id}">Remove</a></td>
				<td><a href="crud.jsp?action=update_speaker&id=${speaker_id}">Update</a></td>
			</tr>
			<c:set var="i" value="${i+1}" />
		</c:forEach>
	</table>
	<a href="crud.jsp?action=add_speaker">Add a speaker.</a>
	<h2>Number of attendees</h2>
	<h3><c:out value="${attendees_size }"/></h3>
	<br><a href="crud.jsp?action=add_attendee">Add/update an attendee.</a>
	<br><a href="crud.jsp?action=delete_attendee">Delete attendee.</a>
	
	
</body>
</html>