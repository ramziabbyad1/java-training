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
	<h1>List of books</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Date Published</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="b">
				<tr>
					<td><c:out value="${b.bookId }"></c:out></td>
					<td><c:out value="${b.title }"></c:out></td>
					<td><c:out value="${b.author }"></c:out></td>
					<td><c:out value="${b.price }"></c:out></td>
					<td><c:out value="${b.datePub }"></c:out></td>
					<td><a href="./BooksController?action=edit&id=<c:out value="${b.bookId}"/>">edit</a></td>
					<td><a href="./BooksController?action=delete&id=<c:out value="${b.bookId}"/>">delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br/> <a href = "./BookControllers?action=add">Add New Book</a>
</body>
</html>