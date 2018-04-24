<%@page language="java" import="cmcPackage.interfaces.*"%>
<%

StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");

if (!studentInt.isTfaEnabled())
	response.sendRedirect("ManageMyProfile.jsp?Error=-9");
else {
	studentInt.disableTfa();
	response.sendRedirect("TwoFactorAuthentication.jsp?Disabled=1");
	}
%>
