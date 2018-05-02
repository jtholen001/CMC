<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Login Form</title>
</head>
<body>
<center>
<h2>2-Factor Authentication</h2>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="cmcPackage.interfaces.*" %>
<p><% 
	String error = request.getParameter("Error");
	if(error != null) {
		if (error.equals("-1"))
			out.print("2-factor authentication failed.");
	}

	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>
</p>
<form method="post" action="TwoFactorAuthentication_action.jsp" name="Authenticate"><br>
<img src="assets/img/2FA_auth.png" alt="CMC Logo">
<br>
<br>

This extra step shows it's really you trying to sign in.<br>
Get a verification code from the <strong>Google Authenticator</strong> app
<br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;"><center><input name="key"></center></td>
</tr>
<tr>
<td style="vertical-align: top;"><center><input value="Authenticate"
name="Authenticate" type="submit" class="buttonstyle"></center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
</tbody>
</table>
</form>
</center>
<br>
</body>
</html>
