<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="cmcPackage.entityClasses.*" import="java.util.HashMap" import="java.util.Set"%>
<%@include file="verifyLogin.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Manage Saved Universities</title>
</head>
<body>

<%
	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>

<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top; text-align: center;">School
</td>

<%
Set<String> savedUniversities = studentInt.viewSavedUniversities().keySet();


for(String u: savedUniversities)
{
%>
	<tr>
	<td style="vertical-align: top;">
	<form method="post" action="RemoveStudentUniversity_action.jsp" name="Remove">
	    <input name="Remove" value="Remove" type="submit">
	    <input name="University" value='<%=u %>' type="hidden">
	</form>
	<td style="vertical-align: top;"><%=u%>
	</td>
	<td style="vertical-align: top;">
	<form method="post" action="ViewUniversity.jsp" name="View">
	    <input name="View" value="View" type="submit">
	    <input name="University" value='<%=u %>' type="hidden">
	</form>
	</td>
	</tr>
<%}
%>
</tbody>
</table>
</body>
</html>

