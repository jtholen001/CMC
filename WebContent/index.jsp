<html>
<head>

<title>Login Form</title>
</head>
<body>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="cmcPackage.*" %>
<% 
String error = request.getParameter("Error");
if(error != null) {
	if (error.equals("-1"))
		out.print("Incorrect password or username");
	else if (error.equals("-4"))
		out.print("User must be logged in to access system pages");
}
 %>

<form method="post" action="Login_action.jsp" name="Login">
Username <input name="Username"> <br>
Password <input name="Password"><br>
<input value="Log in"
name="Log in" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input value="Reset"
name="Reset" type="reset">

<br>
</form>
<br>
</body>
</html>