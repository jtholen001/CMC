
<%@include file="verifyLogin.jsp"  %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>

Hello <%out.print(studentInt.getStudent().getFirstName() + " " + studentInt.getStudent().getLastName()); %>!
<br><a href="Search.jsp"><br>Search For Universities</a><br>
<br><a href="ManageSavedUniversities.jsp">Manage My Saved Universities</a><br>
<br><a href="ManageMyProfile.jsp">Manage My Profile</a>
<br>

</body>
</html>