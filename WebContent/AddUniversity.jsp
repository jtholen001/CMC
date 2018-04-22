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
<td> <select name="State" style="width: 172px;">
		<option value="Alabama"></option>
		<option value="Alaska"></option>
		<option value="Arizona"></option>
		<option value="Arkansas"></option>
		<option value="California"></option>
		<option value="Colorado"></option>
		<option value="Connecticut"></option>
		<option value="Delaware"></option>
		<option value="Florida"></option>
		<option value="Georgia"></option>
		<option value="Hawaii"></option>
		<option value="Idaho"></option>
		<option value="Illinois"></option>
		<option value="Indiana"></option>
		<option value="Iowa"></option>
		<option value="Kansas"></option>
		<option value="Kentucky"></option>
		<option value="Louisiana"></option>
		<option value="Maine"></option>
		<option value="Maryland"></option>
		<option value="Massachusetts"></option>
		<option value="Michigan"></option>
		<option value="Minnesota"></option>
		<option value="Mississippi"></option>
		<option value="Missouri"></option>
		<option value="Montana"></option>
		<option value="Nebraska"></option>
		<option value="Nevada"></option>
		<option value="New Hampshire"></option>
		<option value="New Jersey"></option>
		<option value="New Mexico"></option>
		<option value="New York"></option>
		<option value="North Carolina"></option>
		<option value="North Dakota"></option>
		<option value="Ohio"></option>
		<option value="Oklahoma"></option>
		<option value="Oregon"></option>
		<option value="Pennsylvania"></option>
		<option value="Rhode Island"></option>
		<option value="South Carolina"></option>
		<option value="South Dakota"></option>
		<option value="Tennessee"></option>
		<option value="Texas"></option>
		<option value="Utah"></option>
		<option value="Vermont"></option>
		<option value="Virrginia"></option>
		<option value="Washington"></option>
		<option value="West Virginia"></option>
		<option value="Wisconsin"></option>
		<option value="Wyoming"></option>
	</select>
</td>
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
