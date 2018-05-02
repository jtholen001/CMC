<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.HashMap" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String userName = request.getParameter("Username");
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
	HashMap<String, User> users = adminInt.viewUsers();
    out.println("Edit user : " + userName);
	User u = users.get(userName);
%>
<html>
<head>
<title>Edit_action</title>
</head>
<body>
<%
int result = adminInt.editUser(userName, request.getParameter("FirstName"), request.getParameter("LastName"), request.getParameter("Password"), request.getParameter("Type"), request.getParameter("Status"), "false");

if (result != -1)//success
	response.sendRedirect("ManageUsers.jsp?editSuccess=1&editedName="+userName);
else//fail
	response.sendRedirect("EditUser.jsp?error=-1");
%>
