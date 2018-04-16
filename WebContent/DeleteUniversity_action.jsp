<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.HashMap" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
//TODO: can a university be deleted if students have it saved in their  saveduniversities?
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
    University toDelete = adminInt.getUniversity(request.getParameter("UniversityName"));
	adminInt.deleteUniversity(toDelete);
	response.sendRedirect("ManageUniversities.jsp");
%>
<html>
<head>
<title>DeleteUniversity_action</title>
</head>
<body>
<%

%>
