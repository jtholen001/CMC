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


<form method="post" action="Login_action.jsp" name="Login"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">Username<br>
</td>
<td style="vertical-align: top;"><input name="Username"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Password<br>
</td>
<td style="vertical-align: top;"><input type = "password" name="Password"> </td>
</tr>
<tr>
<td><input value="Log in"
name="Log in" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input value="Reset"
name="Reset" type="reset"></td>
</tr>
<br>
</form>
<br>
</body>
</html>