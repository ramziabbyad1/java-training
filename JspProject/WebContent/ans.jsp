<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	

	<%--<%= session.setAttribute("name", name) --%>
	<form action="calculate.jsp">
		<h2>Enter a number : <input type="text" name="no"/></h2>
		<input type="submit" value="Submit"/>
	</form>
	<%
		String name = request.getParameter("name");
		String desig = request.getParameter("desig");
		out.println("<h1>Welcom " + name+"</h1>");
		session.setAttribute("name",name);
		
	
	%>
	<br/><h2>Welcome !!<%=request.getParameter("name") %></h2>
	<br><h2>Parameter : <%=application.getInitParameter("admin") %></h2>
</body>
</html>