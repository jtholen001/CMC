<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.HashMap" pageEncoding="UTF-8"%>
    <%@include file="verifyLoginAdmin.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
//TODO: can a university be deleted if students have it saved in their  saveduniversities?
	String deletedName = request.getParameter("UniversityName");
		
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
    University toDelete = adminInt.getUniversity(deletedName);
	adminInt.deleteUniversity(toDelete);
	response.sendRedirect("ManageUniversities.jsp?DeleteSuccess=1&deletedName=" + deletedName);
%>
<html>
<head>
<title>DeleteUniversity_action</title>
</head>
<body>
<%

%>
