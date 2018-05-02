<link rel="stylesheet" type="text/css" href="styles.css">
<html>
<head>
<title>Student Menu</title>
</head>
<%@include file="verifyLoginStudent.jsp"%>
<h2>Main Menu</h2>
<body><p>
	<%
		StudentInterface studentInt = (StudentInterface) session.getAttribute("userInt");
		String error = request.getParameter("Error");
		if ("-1".equals(error))
			out.print("Uh Oh! Looks like you tried to access a page Students do not have access to!");
	%></p>
	<a href="Search.jsp"><br> <img src="assets/img/search_for_universities.png" alt="Search" class="imgFancy"></a>
	<a href="ManageSavedUniversities.jsp"><br> <img src="assets/img/manage_my_universities.png" alt="Search" class="imgFancy"></a>
	<a href="ManageMyProfile.jsp"><br> <img src="assets/img/manage_my_profile.png" alt="Search" class="imgFancy"></a>
	<a href="Logout_Action.jsp"><br> <img src="assets/img/logout.png" alt="Search" class="imgFancy"></a>
	<br>
	<br>

</body>
</html>