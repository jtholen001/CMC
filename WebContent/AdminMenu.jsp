<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Admin Menu</title>
</head>
<%@include file="verifyLogin.jsp"  %>
<h2>Admin Menu</h2>
<body>
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
%>
	<a href="ManageUsers.jsp"><br> <img src="assets/img/manage_users.png" alt="Search" class="imgFancy"></a>
	<a href="ManageUniversities.jsp"><br> <img src="assets/img/manage_universities.png" alt="Manage Universities" class="imgFancy"></a>
	<a href="Logout_Action.jsp"><br> <img src="assets/img/logout.png" alt="Search" class="Logout"></a>
	<br>
	<br>
</body>
</html>