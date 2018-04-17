<%@include file="verifyLogin.jsp"  %>
<html>
<head>
<title></title>
</head>
<body>
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
%>

Hello <%out.print(adminInt.getAdmin().getFirstName() + " " + adminInt.getAdmin().getLastName()); %>!
<br><a href="ManageUsers.jsp"><br>Manage Users</a><br>
<br><a href="ManageUniversities.jsp">Manage Universities</a><br>
<br><a href="Logout_Action.jsp">Logout</a><br>
<br>

</body>
</html>