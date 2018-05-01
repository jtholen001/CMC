<link rel="stylesheet" type="text/css" href="styles.css">
<html>
<head>
<title>Student Menu</title>
</head>
<%@include file="verifyLogin.jsp"%>
<body>
	<%
		StudentInterface studentInt = (StudentInterface) session.getAttribute("userInt");
	%>
	<table>
		<tbody>
			<tr>
				<td>Hello <%
					out.print(studentInt.getStudent().getFirstName() + " " + studentInt.getStudent().getLastName());%>!
				</td>
			</tr>
			<tr>
				<td><a href="Search.jsp"><br> <img
						src="assets/img/SearchForUniversities.png"></a></td>
			</tr>
			<tr>
				<td><a href="ManageSavedUniversities.jsp"><img
						src="assets/img/ManageMySavedUniversities.png"></a></td>
			</tr>
			<tr>
				<td><a href="ManageMyProfile.jsp"><img
						src="assets/img/ManageMyProfile.png"></a></td>
			</tr>
			<tr>
			<td><a href="Logout_Action.jsp"><img src="assets/img/Logout.png"></a></td>
			</tr>
		</tbody>
	</table>
</body>
</html>