<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Date"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Date date = new Date();

%>
<c:set var="d" value="<%=date %>"></c:set>
<br/>Date : <c:out value="${d }"></c:out>
	<c:out value="100+50"></c:out>
	<c:set var="i" value="${10 }"></c:set>
	<c:set var="j" value ="${20 }"></c:set>
	<c:if test="${i>j }">
		<br><c:out value="i is greater"></c:out>
	</c:if>
	<c:choose>
		<c:when test="${i>j }">
			<br/><c:out value="i is greater"></c:out>
		</c:when>
		<c:otherwise>
			<br/><c:out value="j is greater"></c:out>
		</c:otherwise>
	</c:choose>
	
<br/>without formatting: <c:out></c:out>
<br/>with formatting: <c:out></c:out>

</body>
</html>