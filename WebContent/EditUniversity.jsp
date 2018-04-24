<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="cmcPackage.entityClasses.University,cmcPackage.interfaces.*,cmcPackage.Controllers.*,java.util.ArrayList"%>
<%@include file="verifyLogin.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit University</title>
</head>
<%
	AdminInterface adminInt = (AdminInterface) session.getAttribute("userInt");
	University university = adminInt.getUniversity(request.getParameter("UniversityName"));

// 	DBController db = new DBController();
// 	University university = db.getUniversity("ADELPHI");
%>
<body>
	<form action="EditUniversity_Action.jsp" name="Edit University">
		<table style="text-align: left; width: 50%;" border="1"
			cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top; width: 200px">NAME</td>
					<td style="vertical-align: top"><input readonly="readonly"
						name="name" value='<%out.println(university.getName());%>'
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 200px">STATE</td>
					<td style="vertical-align: top"><input name="state"
						value=<%out.println(university.getState());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 200px">LOCATION</td>
					<td style="vertical-align: top"><input name="location"
						value=<%out.println(university.getLocation());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 200px">CONTROL</td>
					<td style="vertical-align: top"><input name="control"
						value=<%out.println(university.getControl());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">NUMBER OF
						STUDENTS</td>
					<td style="vertical-align: top"><input name="numStudents"
						value=<%out.println(university.getNumStudents());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">% FEMALE</td>
					<td style="vertical-align: top"><input name="percentFemale"
						value=<%out.println(university.getPercentFemale());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">% SAT VERBAL</td>
					<td style="vertical-align: top"><input name="SATVerbal"
						value=<%out.println(university.getSATVerbal());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">% SAT MATH</td>
					<td style="vertical-align: top"><input name="SATMath"
						value=<%out.println(university.getSATMath());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">EXPENSES</td>
					<td style="vertical-align: top"><input name="expenses"
						value=<%out.println(university.getExpenses());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">% FINANCIAL AID</td>
					<td style="vertical-align: top"><input
						name="percentFinancialAid"
						value=<%out.println(university.getPercentFinancialAid());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">NUMBER OF
						APPLICANTS</td>
					<td style="vertical-align: top"><input
						name="numberOfApplicants"
						value=<%out.println(university.getNumApplicants());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">% ADMITTED</td>
					<td style="vertical-align: top"><input name="percentAdmitted"
						value=<%out.println(university.getPercentAdmitted());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">% ENROLLED</td>
					<td style="vertical-align: top"><input name="percentEnrolled"
						value=<%out.println(university.getPercentEnrolled());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">ACADEMICS SCALE
						(1-5)</td>
					<td style="vertical-align: top"><input name="academicScale"
						value=<%out.println(university.getAcademicScale());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">SOCIAL SCALE</td>
					<td style="vertical-align: top"><input name="socialScale"
						value=<%out.println(university.getSocialScale());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">QUALITY OF LIFE
						SCALE (1-5)</td>
					<td style="vertical-align: top"><input name="qualityOfLife"
						value=<%out.println(university.getQualityOfLifeScale());%>
						style="width: 258px;"></td>
				</tr>
				<tr style="width: 617px;">
				<td style="vertical-align: top; width: 288px; height: 87px">EMPHASES</td>
				<td style="vertical-align: top; width: 288px; height: 87px">
					<%
						ArrayList<String> temp = university.getEmphases();
						Integer i = new Integer(temp.size());
						for (i = 0; i < temp.size(); i++) {
					%>
								
						<input style="vertical-align: top; width: 288px" style="vertical-align: top" style="width: 258px;"
						name=<%out.println("emphasis"+i);%>
						<%if(temp.size() > i){ %>
							value='<%out.println(temp.get(i));%>'
							<% }%>  
						<%if(temp.size() < i){
						%>
							value=""
						 <%} 
						 %>
						
						>
						<%} 
						%>
						<input style="vertical-align: top; width: 288px" style="vertical-align: top" style="width: 258px;"
						name=<%out.println("end");%> value="">
					</td>
				</tr>
				<tr>
					<td><input value="Submit" name="Log in" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input value="Cancel" name="Reset" type="reset"></td>
					


				</tr>
			</tbody>
		</table>
	</form>
	<form method="post" action="AdminMenu.jsp">
	    <input name="Return" value="Return to Menu" type="submit">
	</form>
</body>
</html>