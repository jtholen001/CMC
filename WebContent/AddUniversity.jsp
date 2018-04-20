<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.*" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Add University Form</title>

</head>
<body>
<br>
Add University Form:<br>
<br>
<form method="post" action="AddUniversity_action.jsp" name="addUniversity"><br>
<table style="width: 400; height: 128px;">
<tbody>
<tr>
<td>School Name</td>
<td><input name="SchoolName"></td>
</tr>
<tr>
<td>State</td>
<td><input name="State"></td>
</tr>
<tr>
<td>Location</td>
<td><input name="Location"></td>
</tr>
<tr>
<td>Control</td>
<td><input name="Control"></td>
</tr>
<tr>
<td>Number Of Students</td>
<td><input name="numberOfStudents"></td>
</tr>
<tr>
<td>% Female</td>
<td><input name="percentFemale"></td>
</tr>
<tr>
<td>SAT Verbal</td>
<td><input name="SATVerbal"></td>
</tr>
<tr>
<td>SAT Math</td>
<td><input name="SATMath"></td>
</tr>
<tr>
<td>Expenses</td>
<td><input name="Expenses"></td>
</tr>
<tr>
<td>% Financial Aid</td>
<td><input name="percentFinancialAid"></td>
</tr>
<tr>
<td>Number Of Applicants</td>
<td><input name="numberOfApplicants"></td>
</tr>
<tr>
<td>% Admitted</td>
<td><input name="percentAdmitted"></td>
</tr>
<tr>
<td>% Enrolled</td>
<td><input name="percentEnrolled"></td>
</tr>
<tr>
<td>Academic Scale (1-5)</td>
<td><input name="academicScale"></td>
</tr>
<tr>
<td>Social Scale (1-5)</td>
<td><input name="socialScale"></td>
</tr>
<tr>
<td>Quality Of Life Scale (1-5)</td>
<td><input name="qualityOfLifeScale"></td>
</tr>
<tr>
<td>Emphases<br><br>*You may add more<br>emphases later</td>
<td><input name="emphases1"><br><input name="emphases2"><br><input name="emphases3">
</td>
</tr>

<tr>
<td><input value="Add"
name="Add" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
<br>
</form>
	<form method="post" action="ManageUniversities.jsp">
	    <input name="Cancel" value="Cancel" type="submit">
	</form>
<br>
</body>
</html>
