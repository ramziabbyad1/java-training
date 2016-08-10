<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List</title>
</head>
<body>
	<h1>List of Books</h1>
	<table>
	<thead>
		<tr>
			<th>bookId</th>
			<th>Title</th>
			<th>Author</th>
			<th>Price</th>
			<th>Date Published</th>
		</tr>
	</thead>
		<s:iterator value="books" var="b">
			<tr>
				<td><s:property value="bookId"/> </td>
				<td><s:property value="title"/> </td>
				<td><s:property value="author"/> </td>
				<td><s:property value="price"/> </td>
				<td><s:property value="datePub"/> </td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>