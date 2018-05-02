<link rel="stylesheet" type="text/css" href="styles.css">
<html>
<head>
<title>Student Menu</title>
</head>
<%@include file="verifyLogin.jsp"%>
<h2>Main Menu</h2>
<body>
	<%
		StudentInterface studentInt = (StudentInterface) session.getAttribute("userInt");
	%>
	<a href="Search.jsp"><br> <img src="assets/img/search_for_universities.png" alt="Search" class="imgFancy"></a>
	<a href="ManageSavedUniversities.jsp"><br> <img src="assets/img/manage_my_universities.png" alt="Search" class="imgFancy"></a>
	<a href="ManageMyProfile.jsp"><br> <img src="assets/img/manage_my_profile.png" alt="Search" class="imgFancy"></a>
	<a href="Logout_Action.jsp"><br> <img src="assets/img/logout.png" alt="Search" class="imgFancy"></a>

</body>
</html>