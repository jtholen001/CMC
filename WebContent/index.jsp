<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Login Form</title>
</head>
<body>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="cmcPackage.*" %>
<p>
<% 
System.out.println("test");
String error = request.getParameter("Error");
if(error != null) {
	if (error.equals("-1"))
		out.print("Incorrect username or password");
	else if (error.equals("-2"))
		out.print("Account deactivated. Contact system administrator.<br>Phone: ");%><a href="tel:320-363-2837">(320) 363-2837</a><br>Email: <a href="https://sts.csbsju.edu/adfs/ls/?client-request-id=07d3d3c7-0a05-468b-b3a4-7ab81b3843b9&username=&wa=wsignin1.0&wtrealm=urn%3afederation%3aMicrosoftOnline&wctx=estsredirect%3d2%26estsrequest%3drQIIAY2RO2_TUABGe53EqBkAIbYugJhAN7l-25EYYuySJk5MSNykXaLrd9om1_jROln4ASyZI7EgpkwIltKVoVKnSt36CxATYmKkEQtjz3D0zed7VmAqTO0p-gcL14bI9xnoeOv1H_GD8v3zq6s7pfL77a-f5qdb8stvS1B2Ejs5yCqem63AkzBNo6RWrZIsPSLksEJ8f-x4nChUHDKpkhNcPQXgEoAVJYmcKCKZQxLLKkjgBAlVXAHzvucIkHM9BfKe5ECMGR7ysu06mPVsG-Nr6p5Zz9KQXYvE47n3m9r0STwZRSRJl4UF0Jy0oyU7ga6rITJStGft7MMBGuZGuz1XA-ZQw2luHhv8NJOavNVloD7rqcGbtht09wy9e7A7VQe5EjbJKJs5VtyTTt7mkk5yI-3byZGFGpo5brTkjsQpliabeRr1TP-1IPY7_akSvRrhoBmF7CgWu_Zxlvirwq3yfinQN40mZHpRoEnkTcfuZRH8LFLo7p8i-Fi6iW_yH2z13Xf97DP1-HxJbVyUqs8bfF80hnF9sKsoeD7UrJahzkhdqIfGAItptq3MiCS3VD54IdeYBQ0WNP2DBr_ojbPNW7x1XX7IIkaGSICIfYT4GhJqLLf_Fw2">irahal@csbsju.edu</a><%
	if (error.equals("-4"))
		out.print("User must be logged in to access system pages");
}
 %>
 </p>
 <img src="assets/img/Logo.png" alt="CMC Logo" class="center">
<center><form method="post" action="Login_action.jsp" name="Login"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1">
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
<td style="vertical-align: top;"><input value="Log in"
name="Log in" type="submit" class = "buttonstyle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset" class="buttonstyle"></td>
</tr>
</tbody>
</table>
</form></center>
<br>
</body>
</html>
