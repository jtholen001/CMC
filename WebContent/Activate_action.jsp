<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.HashMap" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Activate_Action</title>
</head>
<body>
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
	HashMap<String, User> users = adminInt.viewUsers();
	User u = users.get(request.getParameter("Username"));
	try
	{
		adminInt.activate(u);
	}
	catch(IllegalArgumentException iae)
	{
		
	}
	response.sendRedirect("ManageUsers.jsp");
%>
</body>
</html>