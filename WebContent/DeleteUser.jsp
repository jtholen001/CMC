<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete User</title>
</head>
<body>
	<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
	String userName = request.getParameter("Username");
	int result = adminInt.deleteUser(userName);
	
	if (result != -1)
		response.sendRedirect("ManageUsers.jsp?deleteSuccess=1&deletedName="+userName);
	else
		response.sendRedirect("ManageUsers.jsp?deleteSuccess=-1");
%>
</body>
</html>