<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.*" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>

<html>
<head>

<title>Add University Form</title>

</head>
<body>
<br>
Add University Form:<br>
<br>
<form method="post" action="AddUniversity_action.jsp" name="addUniversity"><br>
<table style="text-align: left; width: 400px; height: 128px;"
border="2" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">School Name<br>
</td>
<td style="vertical-align: top;"><input name="SchoolName"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">State<br>
</td>
<td style="vertical-align: top;"><input name="State"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Location<br>
</td>
<td style="vertical-align: top;"><input name="Location"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Control<br>
</td>
<td style="vertical-align: top;"><input name="Control"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Number Of Students<br>
</td>
<td style="vertical-align: top;"><input name="numberOfStudents"> </td>
</tr>
<tr>
<td style="vertical-align: top;">% Female<br>
</td>
<td style="vertical-align: top;"><input name="percentFemale"> </td>
</tr>
<tr>
<td style="vertical-align: top;">SAT Verbal<br>
</td>
<td style="vertical-align: top;"><input name="SATVerbal"> </td>
</tr>
<tr>
<td style="vertical-align: top;">SAT Math<br>
</td>
<td style="vertical-align: top;"><input name="SATMath"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Expenses<br>
</td>
<td style="vertical-align: top;"><input name="Expenses"> </td>
</tr>
<tr>
<td style="vertical-align: top;">% Financial Aid<br>
</td>
<td style="vertical-align: top;"><input name="percentFinancialAid"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Number Of Applicants<br>
</td>
<td style="vertical-align: top;"><input name="numberOfApplicants"> </td>
</tr>
<tr>
<td style="vertical-align: top;">% Admitted<br>
</td>
<td style="vertical-align: top;"><input name="percentAdmitted"> </td>
</tr>
<tr>
<td style="vertical-align: top;">% Enrolled<br>
</td>
<td style="vertical-align: top;"><input name="percentEnrolled"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Academic Scale (1-5)<br>
</td>
<td style="vertical-align: top;"><input name="academicScale"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Social Scale (1-5)<br>
</td>
<td style="vertical-align: top;"><input name="socialScale"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Quality Of Life Scale (1-5)<br>
</td>
<td style="vertical-align: top;"><input name="qualityOfLifeScale"> </td>
</tr>
<tr>
<td style="vertical-align: top;">Emphases<br>
</td>
<td style="vertical-align: top;"><input name="emphases"> </td>
</tr>

<tr>
<td style="vertical-align: top;"><input value="Add"
name="Add" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
<br>
</form>
<br>
</body>
</html>
