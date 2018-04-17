<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmcPackage.entityClasses.*"%>
<%@include file="verifyLogin.jsp"%>
<%
StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
String universityName = request.getParameter("University");
studentInt.saveUniversity(studentInt.viewUniversity(universityName));
%>