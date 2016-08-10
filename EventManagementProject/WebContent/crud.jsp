<%@page import="com.entity.Attendee"%>
<%@page import="com.entity.Speaker"%>
<%@page import="com.entity.Event"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.dao.CrudDao"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change event details</title>
</head>
<%
	String action = request.getParameter("action");
	String temp = request.getParameter("id");
	
	int id;
	if(temp!=null){
		id = Integer.parseInt(temp);
	}else{
		id = -1;
	}
	request.setAttribute("action", action);
	//request.setAttribute("id", id);
	CrudDao dao = new CrudDao();
	//Event e = (Event)session.getAttribute("event");
	//out.println("<br/>"+e);
	//out.println("action: "+action);
	//out.println("<br/>id: "+id);
%>
<body>
	<c:choose>
		<c:when test="${action =='update_location' }">
			<c:set var="l" value="${event.getLocation()}"/>
			Hello...<c:out value="${l.getName() }"/>
			<%int loc_id =Integer.parseInt(request.getParameter("id"));
			request.setAttribute("loc_id", loc_id);%>
			<form action="updatedata.jsp" method="POST"> 
				<input type="hidden" value="update_location" name="action"/>
				<input type="hidden" value="${event.getId() }" name="event_id"/>
				<h3>Location ID: <input type="text" value="${loc_id}" name="id" readonly/></h3>
				<h3>Location Name: <input type="text" name="name" value="${l.getName()}" style="width:250px;" onclick="this.value=''"/></h3>
				<h3>Location Address: <input type="text" name="name" value="${l.getAddress()}" style="width:400px;" onclick="this.value=''"/></h3>
				<br/><input type="submit" value="Submit"/>
			</form>
		</c:when>
		<c:when test="${action=='update_speaker' || action=='add_speaker'}">
			<% 
				
				String readOnly = "";
				if(action.equals("update_speaker")){
					Speaker s = dao.fetchSpeaker(Speaker.class, id);
					request.setAttribute("s",s);
					readOnly = "readonly";
				}
				request.setAttribute("readonly",readOnly);
				//out.println("<br/> speaker..."+s);
			%>
			<form action="updatedata.jsp" method="POST">
				<input type="hidden" value="update_speaker" name="action"/>
				<input type="hidden" value="${event.getId() }" name="event_id"/>
				<h3>Speaker ID: <input name="id" type="text" value="${s.getId()}" readonly/></h3>
				<h3>Speaker Name: <input name="name" type="text" value="${s.getName() }" onclick="this.value=''"/></h3>
				<h3>Speaker Phone: <input name="telephone" type="text" value="${s.getTelephone() }" onclick="this.value=''"/></h3>
				<br/><input type="submit" value="Submit"/>
			</form>
		</c:when>
		<c:when test="${action=='update_attendee' || action=='add_attendee'}">
			<% 
				if(action.equals("update_attendee")){
					Attendee a = dao.fetchAttendee(Attendee.class, id);
					request.setAttribute("a",a);
				}
				
				//out.println("<br/> speaker..."+s);
			%>
			<form action="updatedata.jsp?" method="POST">
				<input type="hidden" value="update_attendee" name="action"/>
				<h3>Attendee ID: <input name="id" type="text" value="${a.getId()}" /></h3>
				<h3>Attendee Name: <input name="name" type="text" value="${a.getName() }" onclick="this.value=''"/></h3>
				<h3>Attendee Phone: <input name ="telephone" type="text" value="${a.getTelephone() }" onclick="this.value=''"/></h3>
				<br/><input type="submit" value="Submit"/>
			</form>
		</c:when>
		<c:when test="${action=='delete_speaker'}">
			<%
				
				dao.deleteSpeaker(Speaker.class, id);
				out.println("<h2>User ID delted... </h2>");
			%>
			
			<c:import url="details.jsp?id=${event.getId()}"/>
		</c:when>
		<c:when test="${action=='delete_attendee'}">
			<form action="updatedata.jsp">
				<input type="hidden" value="delete_attendee" name="action"/>
				<h3>Enter an id: <input type="text" onclick="this.value=''" name="id"/></h3>
				<br/><input type="submit" value="Submit"/>
			</form>
		</c:when>
	</c:choose>
</body>
</html>