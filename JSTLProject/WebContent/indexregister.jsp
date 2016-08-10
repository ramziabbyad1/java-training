<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<form action="processregister.jsp">
		Name : <input type="text" value="User Name" 
		name="uname" onclick="this.value=''"/>
		<br/>Email : <input type="email" value="User Email"
		 name="uemail" onclick="this.value=''"/>
		<br/>Password : <input type="password" value ="User Password" 
		name="upass" onclick="this.value=''"/>
		<br/><input type="submit" value="Submit"/> 
	</form>
</body>
</html>