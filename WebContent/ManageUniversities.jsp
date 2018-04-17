<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"  %>
    <%@page language="java" import="cmcPackage.interfaces.*" import= "cmcPackage.entityClasses.University" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Universities</title>
</head>
<body>

<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
<tbody>
<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top;"><a
href="AddUniversity.jsp">ADD A UNIVERSITY</a>
</td>

</tr>
<tr>
<td></td>
<td style="vertical-align: top; text-align: center;">School
</td>
<td style="vertical-align: top; text-align: center;">State
</td>
<td style="vertical-align: top; text-align: center;">Location
</td>
<td style="vertical-align: top; text-align: center;">Control
</td>
<td style="vertical-align: top; text-align: center;"># of Students
</td>
<td style="vertical-align: top; text-align: center;">% Females
</td>
<td style="vertical-align: top; text-align: center;">SAT Verbal
</td>
<td style="vertical-align: top; text-align: center;">SAT Math
</td>
<td style="vertical-align: top; text-align: center;">Expenses
</td>
<td style="vertical-align: top; text-align: center;">% with Financial Aid
</td>
<td style="vertical-align: top; text-align: center;"># of Applicants
</td>
<td style="vertical-align: top; text-align: center;">% Admitted
</td>
<td style="vertical-align: top; text-align: center;">% Enrolled
</td>
<td style="vertical-align: top; text-align: center;">Academic Scale (1-5)
</td>
<td style="vertical-align: top; text-align: center;">Social Scale (1-5)
</td>
<td style="vertical-align: top; text-align: center;">Quality of Life Scale (1-5)
</td>
<td style="vertical-align: top; text-align: center;">
</td>
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
    <input name="Delete" value="Delete" type="submit">
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
    <input name="Edit" value="Edit" type="submit">
    <input name="UniversityName" value= '<%=university.getName()%>' type="hidden">
</form>
</td>
<%}%>
</tr>
</tbody>
</table>
	
</body>
</html>