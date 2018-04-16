<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmcPackage.entityClasses.*, cmcPackage.Controllers.*"%>
<%@include file="verifyLogin.jsp"%>
<%
String universityName = request.getParameter("University");
StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
University u = studentInt.viewUniversity(universityName);
 %>
<form method="post" action="SaveUniversity_action.jsp" name="SaveUniversity">
	    <input name="Save" value="Save" type="submit">
	    <input name="University" value='<%=u.getName()%>' type="hidden">
	</form>
<table style="text-align: left; width: 700px; height: 228px;"
border="1" >
<tbody>
<tr>
<td style="vertical-align: top;">UNIVERSITY<br>
</td>
<td style="vertical-align: top;"><input name="University" value='<%=u.getName()%>' readonly style="width: 320px; "><br>
</td>
</tr>
<tr>
<tr>
<td style="vertical-align: top;">STATE<br>
</td>
<td style="vertical-align: top;"><input name="State" value='<%=u.getState()%>' readonly><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">LOCATION<br>
</td>
<td style="vertical-align: top;"><input name="Location" value=<%=u.getLocation()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">CONTROL<br>
</td>
<td style="vertical-align: top;"><input name="Control" value=<%=u.getControl()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">NUMBER OF STUDENTS<br>
</td>
<td style="vertical-align: top;"><input name="NumStudents" value=<%=u.getNumStudents()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">% FEMALE<br>
</td>
<td style="vertical-align: top;"><input name="PercentFemale" value=<%=u.getPercentFemale()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">SAT VERBAL<br>
</td>
<td style="vertical-align: top;"><input name="SATVerbal" value=<%=u.getSATVerbal()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">SAT MATH<br>
</td>
<td style="vertical-align: top;"><input name="SATMath" value=<%=u.getSATMath()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">EXPENSES<br>
</td>
<td style="vertical-align: top;"><input name="Expenses" value=<%=u.getExpenses()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">% FINANCIAL AID<br>
</td>
<td style="vertical-align: top;"><input name="PercentFinancialAid" value=<%=u.getPercentFinancialAid()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">NUMBER OF APPLICANTS<br>
</td>
<td style="vertical-align: top;"><input name="NumApplicants" value=<%=u.getNumApplicants()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">% ADMITTED<br>
</td>
<td style="vertical-align: top;"><input name="PercentAdmitted" value=<%=u.getPercentAdmitted()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">% ENROLLED<br>
</td>
<td style="vertical-align: top;"><input name="PercentEnrolled" value=<%=u.getPercentEnrolled()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">ACADEMIC SCALE (1-5)<br>
</td>
<td style="vertical-align: top;"><input name="AcademicScale" value=<%=u.getAcademicScale()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">SOCIAL SCALE (1-5)<br>
</td>
<td style="vertical-align: top;"><input name="SocialScale" value=<%=u.getSocialScale()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">QUALITY OF LIFE SCALE (1-5)<br>
</td>
<td style="vertical-align: top;"><input name="QualityOfLifeScale" value=<%=u.getQualityOfLifeScale()%> readonly> 
 </td>
</tr>
<tr>
<td style="vertical-align: top;">EMPHASES<br>
</td>
<td style="vertical-align: top;">
<% 
ArrayList<String> emphases = u.getEmphases();
for(String emphasis: emphases){
%>
<input value='<%=emphasis%>' readonly> <br>
 <%} %>
 </td>
</tr>
</tbody>
</table>
MAY WE ALSO RECOMMEND<br>

<%
ArrayList<University> recommendedUniversities = studentInt.getRecommendedUniversities(u);
for (University uni: recommendedUniversities) {
 %>
<form method="post" action="SaveUniversity_action.jsp" name="SaveUniversity">
	    <input name="Save" value="Save" type="submit">
	    <input name="University" value='<%=uni.getName()%>' type="hidden">
</form>
<table style="text-align: left; width: 700px; height: 228px;"
border="1" >
<tbody>
<tr>
<td style="vertical-align: top;">UNIVERSITY<br>
</td>
<td style="vertical-align: top;"><input name="University" value='<%=uni.getName()%>' readonly style="width: 320px; "><br>
</td>
</tr>
<tr>
<tr>
<td style="vertical-align: top;">STATE<br>
</td>
<td style="vertical-align: top;"><input name="State" value='<%=uni.getState()%>' readonly><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">LOCATION<br>
</td>
<td style="vertical-align: top;"><input name="Location" value=<%=uni.getLocation()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">CONTROL<br>
</td>
<td style="vertical-align: top;"><input name="Control" value=<%=uni.getControl()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">NUMBER OF STUDENTS<br>
</td>
<td style="vertical-align: top;"><input name="NumStudents" value=<%=uni.getNumStudents()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">% FEMALE<br>
</td>
<td style="vertical-align: top;"><input name="PercentFemale" value=<%=uni.getPercentFemale()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">SAT VERBAL<br>
</td>
<td style="vertical-align: top;"><input name="SATVerbal" value=<%=uni.getSATVerbal()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">SAT MATH<br>
</td>
<td style="vertical-align: top;"><input name="SATMath" value=<%=uni.getSATMath()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">EXPENSES<br>
</td>
<td style="vertical-align: top;"><input name="Expenses" value=<%=uni.getExpenses()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">% FINANCIAL AID<br>
</td>
<td style="vertical-align: top;"><input name="PercentFinancialAid" value=<%=uni.getPercentFinancialAid()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">NUMBER OF APPLICANTS<br>
</td>
<td style="vertical-align: top;"><input name="NumApplicants" value=<%=uni.getNumApplicants()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">% ADMITTED<br>
</td>
<td style="vertical-align: top;"><input name="PercentAdmitted" value=<%=uni.getPercentAdmitted()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">% ENROLLED<br>
</td>
<td style="vertical-align: top;"><input name="PercentEnrolled" value=<%=uni.getPercentEnrolled()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">ACADEMIC SCALE (1-5)<br>
</td>
<td style="vertical-align: top;"><input name="AcademicScale" value=<%=uni.getAcademicScale()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">SOCIAL SCALE (1-5)<br>
</td>
<td style="vertical-align: top;"><input name="SocialScale" value=<%=uni.getSocialScale()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">QUALITY OF LIFE SCALE (1-5)<br>
</td>
<td style="vertical-align: top;"><input name="QualityOfLifeScale" value=<%=uni.getQualityOfLifeScale()%> readonly> 
 </td>
</tr>
<tr>
<td style="vertical-align: top;">EMPHASES<br>
</td>
<td style="vertical-align: top;">
<% 
emphases = uni.getEmphases();
for(String emphasis: emphases){
%>
<input value='<%=emphasis%>' readonly> <br>
 <%} %>
 </td>
</tr>
</tbody>
</table>
<%} %>