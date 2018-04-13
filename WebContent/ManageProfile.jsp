<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage My Profile</title>
</head>
<body>
<table style="text-align: left; width: 50%;" border="1" cellpadding="2" cellspacing="2">
  <tbody>
<tr>
	<td style="vertical-align: top">First Name</td>
	<td style="vertical-align: top"><input name="firstName" value=<%studentInt.getStudent().getFirstName();%>></td>
</tr>
<tr>
	<td style="vertical-align: top">Last Name</td>
	<td style="vertical-align: top"><input name="lastName" value=<%studentInt.getStudent().getLastName();%>></td>
</tr>  
<tr>
	<td style="vertical-align: top">Username</td>
	<td style="vertical-align: top"><input readonly="readonly" name="Username" value=<%studentInt.getStudent().getUsername();%>></td>
</tr> 
<tr>
	<td style="vertical-align: top">Password</td>
	<td style="vertical-align: top"><input name="Password" value=<%studentInt.getStudent().getPassword();%>></td>
</tr> 
<tr>
	<td style="vertical-align: top">Type</td>
	<td style="vertical-align: top"><input readonly="readonly" name="Type" value=<%studentInt.getStudent().getType();%>></td>
</tr> 
</tbody>
</table>
</body>
</html>