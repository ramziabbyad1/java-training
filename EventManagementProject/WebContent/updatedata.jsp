<%@page import="com.entity.Event"%>
<%@page import="com.dao.CrudDao"%>
<%@page import="com.entity.Attendee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change success</title>
</head>
<body>
	
	<%
		CrudDao dao = new CrudDao();
		String action = request.getParameter("action");
		out.println("action: "+action);
		Event event = (Event)session.getAttribute("event");
		out.println(event);
		String event_id = String.valueOf(event.getId());
		//out.println("<br/>"+request.getParameter("id"));
		request.setAttribute("event_id",event_id);
		//request.setAttribute("id", Integer.parseInt(idS));
		
		String objClass = "";
		if(action.equals("update_speaker")){
			objClass="com.entity.Speaker";
		}else if(action.equals("update_attendee")){
			objClass="com.entity.Attendee";
		}else if(action.equals("update_location")){
			objClass="com.entity.Location";
		}else{
			objClass="delete";
		}
		request.setAttribute("objClass",objClass);
		
		String id_in = request.getParameter("id");
		int id;
		if(id_in.equals("")){
			id = -1;
			out.println("<h1>empty id</h1>");
		}else{
			id = Integer.parseInt(id_in);
		}
		int event_id_in = Integer.parseInt((String)request.getAttribute("event_id"));
	%>
	
	<c:choose>
		<c:when test="${objClass == 'com.entity.Speaker' }">
			<jsp:useBean id="obj1" class="com.entity.Speaker" />
			<jsp:setProperty property="*" name="obj1"/>
			<%out.println("<br/>"+obj1); 
			
			dao.mergeSpeaker(obj1, id, event_id_in); %> 
		</c:when>
		<c:when test="${objClass == 'com.entity.Attendee' }">
			<jsp:useBean id="obj2" class="com.entity.Attendee" />
			<jsp:setProperty property="*" name="obj2"/>
			<%dao.mergeAttendee(obj2, id, event_id_in); %>
		</c:when>
		<c:when test="${objClass=='com.entity.Location' }">
			<jsp:useBean id="obj3" class="com.entity.Location"/>
			<jsp:setProperty property="*" name="obj3"/>
			<%dao.updateLocation(obj3,event_id_in);  %> 
		</c:when>
		<c:otherwise>
			<jsp:useBean id="obj4" class="com.entity.Attendee"/>
			<jsp:setProperty property="*" name="obj4"/>
			<%dao.deleteAttendee(event_id_in,id); %> 
		</c:otherwise>
	</c:choose>
	
	
	<jsp:forward page="details.jsp?id=${event_id}"/>
	
	
	
	
</body>
</html>