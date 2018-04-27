<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.HashMap" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
	HashMap<String, User> users = adminInt.viewUsers();
    out.println("Edit user : " + request.getParameter("Username"));
	User u = users.get(request.getParameter("Username"));
%>
<html>
<head>
<title>Edit_action</title>
</head>
<body>
<%
adminInt.editUser(request.getParameter("Username"), request.getParameter("FirstName"), request.getParameter("LastName"), request.getParameter("Password"), request.getParameter("Type"), request.getParameter("Status"), "false");
response.sendRedirect("ManageUsers.jsp");
%>
