<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Admin Menu</title>
</head>
<%@include file="verifyLoginAdmin.jsp"  %>
<h2>Admin Menu</h2>
<body>
<p>
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
	String error = request.getParameter("Error");
	if ("-1".equals(error))
		out.print("Uh Oh! Looks like you tried to access a page Admins do not have access to!");
%>
</p>
	<a href="ManageUsers.jsp"><br> <img src="assets/img/manage_users.png" alt="Search" class="imgFancy"></a>
	<a href="ManageUniversities.jsp"><br> <img src="assets/img/manage_universities.png" alt="Manage Universities" class="imgFancy"></a>
	<a href="Logout_Action.jsp"><br> <img src="assets/img/logout.png" alt="Logout" class="imgFancy"></a>

	<br>
	<br>
</body>
</html>