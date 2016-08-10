<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Insert Edit Form</h1>
	<form action="BookController" method="POST">
		<%-- <c:out value="${edit }"></c:out>
		<c:choose>
			<c:when test="${edit}">
				
				<c:set var = "readonly" value="readonly"></c:set>
			</c:when>
			<c:otherwise>
				
				<c:set var = "readonly" value=""></c:set>
			</c:otherwise>
		</c:choose>--%>
		<br/>BookId: <input type="text" value='<c:out value="${b.bookId}"/>'  name="bookId" ${readonly}/>
		<br/>Author: <input type="text" value='<c:out value="${b.author}"/>' name="author"/>
		<br/>Title: <input type="text" value='<c:out value="${b.title}"/>' name="title"/>
		<br/>Price: <input type="text" value='<c:out value="${b.price}"/>' name="price" />
		<br/>Date Published(YYYY-MM-DD): <input type="text" value='<c:out value="${b.datePub}"/>' name="datePub"/>
		<br/><input type="submit" value="Update"/>
	</form>
</body>
</html>