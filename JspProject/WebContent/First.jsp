<%@page import="com.examples.Calculator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix = "ex" uri="/WEB-INF/custom.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--<%@ include file="another.jsp" %> --%>
	<jsp:include page="another.jsp"></jsp:include>
	<%--<jsp:include page="..//..//com.examples.Calculator.java"></jsp:include> --%>
	<form action="ans.jsp">
		<br/>Enter name: <input type="text" name="name"/>
		<br/><input type="submit" value="Submit"/>
	</form>
	<jsp:useBean id="calc1" class="com.examples.Calculator"></jsp:useBean>
	<%
		Calculator calc = new Calculator();
		//out.println("admin : " + )
		out.println("Result of calculation : " +calc.multiply(2,10));
	%>
	<%-- <ex:Hello attr="value">Adfdsdfs</ex:Hello>--%>
	<br/><ex:Hello msg="3601 Flamevine">moo!</ex:Hello>
</body>
</html>