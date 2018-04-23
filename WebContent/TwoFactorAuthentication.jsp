<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Login Form</title>
</head>
<body>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="cmcPackage.interfaces.*" %>
<% 
	String error = request.getParameter("Error");
	if(error != null) {
		if (error.equals("-1"))
			out.print("2-factor authentication failed.");
	}

	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>

<form method="post" action="TwoFactorAuthentication_action" name="Authenticate"><br>
<h2>2-Factor Authentication</h2>
This extra step shows it's really you trying to sign in.<br>
Get a verification code from the <strong>Google Authenticator</strong> app
<table style="text-align: left; width: 266px; height: 228px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">Authentication code<br>
</td>
<td style="vertical-align: top;"><input name="key"> </td>
</tr>
<tr>
</td>
<td style="vertical-align: top;"><input value="Authenticate"
name="Authenticate" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
</tbody>
</table>
</form>
<br>
</body>
</html>
