<%@page language="java" import="cmcPackage.interfaces.*"%>
<%@include file="verifyLoginStudent.jsp"%>
<%

StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");

String tfaUrl = studentInt.enableTfa();
session.setAttribute("tfaUrl", tfaUrl);
response.sendRedirect("ManageMyProfile.jsp?gtpl=1");
%>
