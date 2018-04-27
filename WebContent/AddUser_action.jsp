<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "java.util.*, cmcPackage.interfaces.*" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User Action</title>
</head>
<body>
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");

adminInt.addUser(request.getParameter("FirstName"), request.getParameter("LastName"), request.getParameter("Username"),
		request.getParameter("Password"), request.getParameter("Type"), request.getParameter("Status"), "false");
response.sendRedirect("ManageUsers.jsp");
%>
</body>
</html>