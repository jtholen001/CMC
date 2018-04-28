
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
<br><a href="Search.jsp"><br><img src="assets/img/SearchForUniversities.png"></a><br>
<br><a href="ManageSavedUniversities.jsp"><img src="assets/img/ManageMySavedUniversities.png"></a><br>
<br><a href="ManageMyProfile.jsp"><img src="assets/img/ManageMyProfile.png"></a><br>
<br><a href="Logout_Action.jsp"><img src="assets/img/Logout.png"></a>
<br>

</body>
</html>