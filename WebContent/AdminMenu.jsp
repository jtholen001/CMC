<%@include file="verifyLogin.jsp"  %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title></title>
</head>
<body>
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
%>

Hello <%out.print(adminInt.getAdmin().getFirstName() + " " + adminInt.getAdmin().getLastName()); %>!
<br><a href="ManageUsers.jsp"><br><img src="assets/img/ManageUsers.png"></a><br>
<br><a href="ManageUniversities.jsp"><img src="assets/img/ManageUniversities.png"></a><br>
<br><a href="Logout_Action.jsp"><img src="assets/img/Logout.png"></a><br>
<br>

</body>
</html>