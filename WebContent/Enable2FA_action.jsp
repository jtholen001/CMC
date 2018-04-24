<%@page language="java" import="cmcPackage.interfaces.*"%>
<%

StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");

String URL = studentInt.enableTfa();
session.setAttribute("tfaUrl", URL);
response.sendRedirect("TwoFactorAuthentication.jsp?Enabled=1");
%>
