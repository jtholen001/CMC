
<%@page language="java" import="cmcPackage.interfaces.*"%>
<%

String key = request.getParameter("key");
String username = request.getParameter("Username");
StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");

if (studentInt.twoFactorAuthenticate(key, username))
	response.sendRedirect("StudentMenu.jsp");
else
	response.sendRedirect("index.jsp?Error=-1");


%>
