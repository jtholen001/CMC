<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="cmcPackage.entityClasses.University,cmcPackage.interfaces.*,cmcPackage.Controllers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit University</title>
</head>
<%
	//AdminInterface adminInt = (AdminInterface) session.getAttribute("userInt");
	//University universtiy = //adminInt.getUniversity(request.getParameter("university"));

	DBController db = new DBController();
	University universtiy = db.getUniversity("BOSTON COLLEGE");
%>
<body>
	<form action="EditProfile_action.jsp" name="EditProfile">
		<table style="text-align: left; width: 50%;" border="1"
			cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top; width: 200px">NAME</td>
					<td style="vertical-align: top"><input readonly="readonly"
						name="name" value=<%out.println(universtiy.getName());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 200px">STATE</td>
					<td style="vertical-align: top"><input name="state"
						value=<%out.println(universtiy.getState());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 200px">LOCATION</td>
					<td style="vertical-align: top"><input name="location"
						value=<%out.println(universtiy.getLocation());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 200px">CONTROL</td>
					<td style="vertical-align: top"><input name="control"
						value=<%out.println(universtiy.getControl());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">NUMBER OF
						STUDENTS</td>
					<td style="vertical-align: top"><input name="numStudents"
						value=<%out.println(universtiy.getNumStudents());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">% FEMALE</td>
					<td style="vertical-align: top"><input name="percentFemale"
						value=<%out.println(universtiy.getPercentFemale());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">% SAT VERBAL</td>
					<td style="vertical-align: top"><input name="SATVerbal"
						value=<%out.println(universtiy.getSATVerbal());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">% SAT MATH</td>
					<td style="vertical-align: top"><input name="SATMath"
						value=<%out.println(universtiy.getSATMath());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">EXPENSES</td>
					<td style="vertical-align: top"><input name="expenses"
						value=<%out.println(universtiy.getExpenses());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">% FINANCIAL AID</td>
					<td style="vertical-align: top"><input
						name="percentFinancialAid"
						value=<%out.println(universtiy.getPercentFinancialAid());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
					<td style="vertical-align: top; width: 288px">NUMBER OF
						APPLICANTS</td>
					<td style="vertical-align: top"><input
						name="numberOfApplicants"
						value=<%out.println(universtiy.getNumApplicants());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
				<td style="vertical-align: top; width: 288px">% ADMITTED</td>
					<td style="vertical-align: top"><input name="percentAdmitted"
						value=<%out.println(universtiy.getPercentAdmitted());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
				<td style="vertical-align: top; width: 288px">% ENROLLED</td>
					<td style="vertical-align: top"><input name="percentEnrolled"
						value=<%out.println(universtiy.getPercentEnrolled());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
				<td style="vertical-align: top; width: 288px">ACADEMICS SCALE (1-5)</td>
					<td style="vertical-align: top"><input name="academicScale"
						value=<%out.println(universtiy.getAcademicScale());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
				<td style="vertical-align: top; width: 288px">SOCIAL SCALE</td>
					<td style="vertical-align: top"><input name="socialScale"
						value=<%out.println(universtiy.getSocialScale());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
				<td style="vertical-align: top; width: 288px">QUALITY OF LIFE SCALE (1-5)</td>
					<td style="vertical-align: top"><input name="qualityOfLife"
						value=<%out.println(universtiy.getQualityOfLifeScale());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
<!-- 				<td style="vertical-align: top; width: 288px">EMPHASES</td> -->
<!-- 					<td style="vertical-align: top"><input name="emphases" -->
<%-- 						value=<%out.println(universtiy.getQualityOfLifeScale());%> --%>
<!-- 						style="width: 258px;"></td> -->
<td>insert emphases
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>