
<%@include file="verifyLogin.jsp"  %>
<html>
<head>
<title>Student Menu</title>
</head>
<body>
<%
	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>

Hello <%out.print(studentInt.getStudent().getFirstName() + " " + studentInt.getStudent().getLastName()); %>!
<br><a href="Search.jsp"><br>Search For Universities</a><br>
<br><a href="ManageSavedUniversities.jsp">Manage My Saved Universities</a><br>
<br><a href="ManageMyProfile.jsp">Manage My Profile</a><br>
<br><a href="Logout_Action.jsp">Logout</a>
<br>

</body>
</html>