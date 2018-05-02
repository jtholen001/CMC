<link rel="stylesheet" type="text/css" href="styles.css">
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>Saved University</title>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cmcPackage.entityClasses.*"%>
<%@include file="verifyLoginStudent.jsp"%>
<%
	String universityName = request.getParameter("University");
	StudentInterface studentInt = (StudentInterface) session.getAttribute("userInt");
	University u = studentInt.viewUniversity(universityName);
%>
<form>
	<table style="text-align: left; width: 700px; height: 228px;"
		border="1">
		<tbody>
			<tr>
				<td style="vertical-align: top;">UNIVERSITY<br>
				</td>
				<td style="vertical-align: top;"><input name="University"
					value='<%=u.getName()%>' readonly style="width: 320px;"><br>
				</td>
			</tr>
			<tr>
			<tr>
				<td style="vertical-align: top;">STATE<br>
				</td>
				<td style="vertical-align: top;"><input name="State"
					value='<%=u.getState()%>' readonly><br></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">LOCATION<br>
				</td>
				<td style="vertical-align: top;"><input name="Location"
					value=<%=u.getLocation()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">CONTROL<br>
				</td>
				<td style="vertical-align: top;"><input name="Control"
					value=<%=u.getControl()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">NUMBER OF STUDENTS<br>
				</td>
				<td style="vertical-align: top;"><input name="NumStudents"
					value=<%=u.getNumStudents()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">% FEMALE<br>
				</td>
				<td style="vertical-align: top;"><input name="PercentFemale"
					value=<%=u.getPercentFemale()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">SAT VERBAL<br>
				</td>
				<td style="vertical-align: top;"><input name="SATVerbal"
					value=<%=u.getSATVerbal()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">SAT MATH<br>
				</td>
				<td style="vertical-align: top;"><input name="SATMath"
					value=<%=u.getSATMath()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">EXPENSES<br>
				</td>
				<td style="vertical-align: top;"><input name="Expenses"
					value=<%=u.getExpenses()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">% FINANCIAL AID<br>
				</td>
				<td style="vertical-align: top;"><input
					name="PercentFinancialAid" value=<%=u.getPercentFinancialAid()%>
					readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">NUMBER OF APPLICANTS<br>
				</td>
				<td style="vertical-align: top;"><input name="NumApplicants"
					value=<%=u.getNumApplicants()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">% ADMITTED<br>
				</td>
				<td style="vertical-align: top;"><input name="PercentAdmitted"
					value=<%=u.getPercentAdmitted()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">% ENROLLED<br>
				</td>
				<td style="vertical-align: top;"><input name="PercentEnrolled"
					value=<%=u.getPercentEnrolled()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">ACADEMIC SCALE (1-5)<br>
				</td>
				<td style="vertical-align: top;"><input name="AcademicScale"
					value=<%=u.getAcademicScale()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">SOCIAL SCALE (1-5)<br>
				</td>
				<td style="vertical-align: top;"><input name="SocialScale"
					value=<%=u.getSocialScale()%> readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">QUALITY OF LIFE SCALE (1-5)<br>
				</td>
				<td style="vertical-align: top;"><input
					name="QualityOfLifeScale" value=<%=u.getQualityOfLifeScale()%>
					readonly></td>
			</tr>
			<tr>
				<td style="vertical-align: top;">EMPHASES<br>
				</td>
				<td style="vertical-align: top;">
					<% 
ArrayList<String> emphases = u.getEmphases();
for(String emphasis: emphases){
%> <input value='<%=emphasis%>' readonly> <br> <%} %>
				</td>
			</tr>
		</tbody>
	</table>
</form>
<form method="post" action="ManageSavedUniversities.jsp">
	<input name="Return" value="Return to Menu" type="submit" class="buttonstyle">
</form>