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

String firstName = request.getParameter("firstName");
String lastName = request.getParameter("lastName");
String password = request.getParameter("Password");


studentInt.editProfile(firstName, lastName, password);

response.sendRedirect("StudentMenu.jsp");


%>
</body>
</html>