<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="myError.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome!! <%=session.getAttribute("name") %></h1>
	<%int i = Integer.parseInt(request.getParameter("no")); %>
	<h2>Ans = <%=i*i %></h2>
	<h3>Creator: <%=config.getInitParameter("creator") %></h3>
</body>
</html>