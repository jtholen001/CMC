<%@page language="java" import="cmcPackage.interfaces.*"%>
<%

String key = request.getParameter("key");
StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
String username = studentInt.getStudent().getUsername();

if (studentInt.twoFactorAuthenticate(key, username))
	response.sendRedirect("StudentMenu.jsp");
else
	response.sendRedirect("TwoFactorAuthentication.jsp?Error=-1");
%>
