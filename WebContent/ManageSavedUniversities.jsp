<html>
<head>
<title>Manage Saved Universities</title>
</head>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="cmcPackage.entityClasses.*" import="java.util.HashMap" import="java.util.Set"%>
<%@include file="verifyLoginStudent.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="styles.css">
<body>

<%
	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>
<h2>Manage Saved Universities</h2>

<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top; text-align: center;">School
</td>

<%

Set<String> savedUniversities = studentInt.viewSavedUniversities().keySet();
TreeSet<String> sortedUniversities = new TreeSet(savedUniversities);


for(String u: sortedUniversities)
{
%>
	<tr>
	<td style="vertical-align: top;">
	<form method="post" action="DeleteSavedUniversity_action.jsp" name="Remove">
	    <input name="Remove" value="Remove" type="submit" class="buttonstyle">
	    <input name="University" value='<%=u %>' type="hidden">
	</form>
	<td style="vertical-align: top;"><%=u%>
	</td>
	<td style="vertical-align: top;">
	<form method="post" action="ViewSavedUniversity.jsp" name="View">
	    <input name="View" value="View" type="submit" class="buttonstyle">
	    <input name="University" value='<%=u %>' type="hidden">
	</form>
	</td>
	</tr>
<%}
%>
</tbody>
</table>
		<form method="post" action="StudentMenu.jsp">
	    <input name="Return" value="Return to Menu" type="submit" class="buttonstyle">
	</form>
</body>
</html>

