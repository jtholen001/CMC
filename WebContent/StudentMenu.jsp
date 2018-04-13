
<%@include file="verifyLogin.jsp"  %>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>
Hello User <%out.print(studentInt.getStudent().getUsername()); %><br>
<a href="Search.jsp">Search For Universities</a><br>
<a href="ManageSavedUniversities.jsp">Manage My Saved Universities</a><br>
<a href="ManageProfile.jsp">Manage My Profile</a><br>
</body>
</html>