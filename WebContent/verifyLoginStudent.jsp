<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmcPackage.interfaces.*, java.util.*"%>
       
<%
UserInterface loggedUser = (UserInterface)session.getAttribute("userInt");
if (loggedUser == null) {
	response.sendRedirect("index.jsp?Error=-4");
	return;
}
else if (loggedUser instanceof AdminInterface)
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>