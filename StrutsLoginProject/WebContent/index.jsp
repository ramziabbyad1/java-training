<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<s:form action="login">
	<s:textfield name="userId" label="User ID" />
	<s:password name="password" label="Password"/>
	<s:submit value="Submit"/>
</s:form>
</body>
</html>

<!--  
<form action="login">

	<br/>User ID: <input type="text" name="userId"/>
	<br/>Password: <input type="password" name="password"/>
	<br/><input type="submit" value="Submit"/>
	
</form>
-->
