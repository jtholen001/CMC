<head>
<title>Search Results</title>
</head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmcPackage.entityClasses.*"%>
<%@include file="verifyLoginStudent.jsp"%>

<html>
<body>
<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top; text-align: center;">University
</td>

<%
String[] values=request.getParameterValues("Universities");
StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");

for(int i=0;i<values.length;i++)
{
	University u = studentInt.viewUniversity(values[i]);
%>
	<%
	Student student = studentInt.getStudent();
	ArrayList<University> savedUniversities = student.getSavedSchools();
	  %>
	<tr>
		<td style="vertical-align: top;">
		<% if (!savedUniversities.contains(u)) { %>
	<form method="post" action="SaveUniversity_action.jsp" name="SaveUniversity">
	    <input name="Save" value="Save" type="submit" class="buttonstyle">
	    <input name="University" value='<%=u.getName()%>' type="hidden">
	    <input name="FromWhere" value="0" type="hidden">
	    <%for (int j=0;j<values.length;j++) { %>
	    <input name="Universities" value='<%=values[j]%>' type="hidden">
	    <%
	    }
	     %>
	</form> <%}
		else { out.print("Saved"); }
		 %></td>
	<td style="vertical-align: top;"><%=u.getName()%>
	</td>
	<td style="vertical-align: top;">
	<form method="post" action="ViewSearchedUniversity.jsp" name="ViewUniversity">
	    <input name="View" value="View" type="submit" class="buttonstyle">
	    <input name="University" value='<%=u.getName()%>' type="hidden">
	   	<%for (int j=0;j<values.length;j++) { %>
	    <input name="Universities" value='<%=values[j]%>' type="hidden">
	    <%
	    }%>
	</form></td>
	</tr>
<%}
%>
		</tbody>
	</table>
		<form method="post" action="Search.jsp">
	    <input name="Return" value="Return to Menu" type="submit" class="buttonstyle">
	</form>
</body>
</html>