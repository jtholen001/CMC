<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"  %>
    <%@page language="java" import="cmcPackage.interfaces.*" import= "cmcPackage.entityClasses.University" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Universities</title>
</head>
<body>
<p style="color:green;">
<%
//message for adding a University
String addSuccess = request.getParameter("addSuccess");
String addedUniversity = request.getParameter("addedUniversity");
if (addSuccess != null && addSuccess.equals("1") && addedUniversity != null)
	out.print("Successfully added " + addedUniversity);
		
//message for editing a University
String editSuccess = request.getParameter("EditSuccess");
String editedUniversity = request.getParameter("editedName");
if (editSuccess != null && editSuccess.equals("1") && editedUniversity != null)
	out.print("Successfully edited " + editedUniversity);
		
//message for deleting a University
String deleteSuccess = request.getParameter("DeleteSuccess");
String deletedUniversity = request.getParameter("deletedName");
if (deleteSuccess != null && deleteSuccess.equals("1") && deletedUniversity != null)
	out.print("Successfully deleted " + deletedUniversity);%>
</p>

<table>
<tbody>
<tr align="center">

<td colspan="18" style="vertical-align: top; text-align: center; font-size: 16px">
	<form method="post" action="AdminMenu.jsp">
	    <input name="Return" value="Return to Menu" type="submit"> 
	    <a href="AddUniversity.jsp">ADD A UNIVERSITY</a>
	</form>
</td>
</tr>

<tr>
<th></th>
<th>School</th>
<th>State</th>
<th>Location</th>
<th>Control</th>
<th># of Students</th>
<th>% Female</th>
<th>SAT Verbal</th>
<th>SAT Math</th>
<th>Expenses</th>
<th>% with Financial Aid</th>
<th># of Applicants</th>
<th>% Admitted</th>
<th>% Enrolled</th>
<th>Academic Scale (1-5)</th>
<th>Social Scale (1-5)</th>
<th>Quality of Life Scale (1-5)</th>
<th></th>
</tr>
<%AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
HashMap<String, University> allUniversities = adminInt.viewUniversities();
University university;
TreeMap<String, University> sortedUniversities = new TreeMap<String, University>();
sortedUniversities.putAll(allUniversities);
for(String u: sortedUniversities.keySet())
{university = sortedUniversities.get(u);%>
<tr>
<td>
<form method="post" action="DeleteUniversity_action.jsp" name="Delete">
	<input name="Delete" type="image" src="assets/img/Delete.png" type="submit">
    <input name="UniversityName" value= <%=university.getName()%> type="hidden">
</form>
</td>
<td><%=university.getName()%></td>
<td><%=university.getState()%></td>
<td><%=university.getLocation()%></td>
<td><%=university.getControl()%></td>
<td><%=university.getNumStudents()%></td>
<td><%=university.getPercentFemale()%></td>
<td><%=university.getSATVerbal()%></td>
<td><%=university.getSATMath()%></td>
<td><%=university.getExpenses()%></td>
<td><%=university.getPercentFinancialAid()%></td>
<td><%=university.getNumApplicants()%></td>
<td><%=university.getPercentAdmitted()%></td>
<td><%=university.getPercentEnrolled()%></td>
<td><%=university.getAcademicScale()%></td>
<td><%=university.getSocialScale()%></td>
<td><%=university.getQualityOfLifeScale()%></td>
<td>
<form method="post" action="EditUniversity.jsp" name="Edit">
    <input name="Edit" type="image"	src="assets/img/Edit.png" type="submit">
    <input name="UniversityName" value= '<%=university.getName()%>' type="hidden">
</form>
</td>
<%}%>
</tr>
</tbody>
</table>
	
</body>
</html>