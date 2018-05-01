<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Admin Menu</title>
</head>
<%@include file="verifyLogin.jsp"  %>
<body>
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
%>
<table>
	<tr>
	<td>Hello <%out.print(adminInt.getAdmin().getFirstName() + " " + adminInt.getAdmin().getLastName()); %>!</td>
	</tr>
	<tr>
	<td><a href="ManageUsers.jsp"><img src="assets/img/ManageUsers.png"></a></td>
	</tr>
	<tr>
	<td><a href="ManageUniversities.jsp"><img src="assets/img/ManageUniversities.png"></a></td>
	</tr>
	<tr>
	<td><a href="Logout_Action.jsp"><img src="assets/img/Logout.png"></a></td>
	</tr>
</table>
</body>
</html>