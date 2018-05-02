<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String firstName = request.getParameter("FirstName");
String lastName = request.getParameter("LastName");
String password = request.getParameter("Password");


int result = studentInt.editProfile(firstName, lastName, password);
if (result != -1)
	response.sendRedirect("StudentMenu.jsp");
else
	response.sendRedirect("ManageMyProfile.jsp?Error=-1");

%>
</body>
</html>