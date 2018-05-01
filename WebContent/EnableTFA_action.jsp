<%@page language="java" import="cmcPackage.interfaces.*"%>
<%

StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");

String tfaUrl = studentInt.enableTfa();
session.setAttribute("tfaUrl", tfaUrl);
response.sendRedirect("ManageMyProfile.jsp?gtpl=1");
%>
