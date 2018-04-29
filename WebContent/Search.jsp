<%@include file="verifyLogin.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Search</title>
</head>
<body>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<title></title>
</head>
<body>

<%
String error = request.getParameter("Error");
if(error != null) {
	if (error.equals("-1"))
		out.print("Please enter valid numbers");
	else if (error.equals("-2"))
		out.print("Please enter a valid search range");
	else if (error.equals("-3"))
		out.print("You must fill in at least one field to search");
	else if (error.equals("-4"))
		out.print("No universities match your criteria");
}
 %>
<br>
<form action="Search_action.jsp" name="Search"><br>
<table style="text-align: left; width: 1621px; height: 161px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">by UNIVERSITY NAME<br>
</td>
<td style="vertical-align: top;">contains <input name="Name"> <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by STATE<br>
</td>
<td style="vertical-align: top;">contains <input name="State"> <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by LOCATION<br>
</td>
<td style="vertical-align: top;">contains <input name="Location"> (SURBURAN, URBAN, SMALL-CITY, -1 for UNKNOWN)<br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by CONTROL<br>
</td>
<td style="vertical-align: top;">contains <input name="Control"> (PRIVATE, STATE, CITY, -1 for UNKNOWN)<br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by NUMBER OF STUDENTS<br>
</td>
<td style="vertical-align: top;">between <input name="NumStudentsLower"> and <input name="NumStudentsUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by % FEMALE<br>
</td>
<td style="vertical-align: top;">between <input name="PercentFemaleLower"> and <input name="PercentFemaleUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by SAT VERBAL<br>
</td>
<td style="vertical-align: top;">between <input name="SATVerbalLower"> and <input name="SATVerbalUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by SAT MATH<br>
</td>
<td style="vertical-align: top;">between <input name="SATMathLower"> and <input name="SATMathUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by EXPENSES<br>
</td>
<td style="vertical-align: top;">between <input name="ExpensesLower"> and <input name="ExpensesUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by % FINANCIAL AID<br>
</td>
<td style="vertical-align: top;">between <input name="PercentFinancialAidLower"> and <input name="PercentFinancialAidUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by NUMBER OF APPLICANTS<br>
</td>
<td style="vertical-align: top;">between <input name="NumApplicantsLower"> and <input name="NumApplicantsUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by % ADMITTED<br>
</td>
<td style="vertical-align: top;">between <input name="PercentAdmittedLower"> and <input name="PercentAdmittedUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by % ENROLLED<br>
</td>
<td style="vertical-align: top;">between <input name="PercentEnrolledLower"> and <input name="PercentEnrolledUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by ACADEMIC SCALE (1-5)<br>
</td>
<td style="vertical-align: top;">between <input name="AcademicScaleLower"> and <input name="AcademicScaleUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by SOCIAL SCALE (1-5)<br>
</td>
<td style="vertical-align: top;">between <input name="SocialScaleLower"> and <input name="SocialScaleUpper"><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by QUALITY OF LIFE SCALE (1-5)<br>
</td>
<td style="vertical-align: top;">between <input name="QualityOfLifeScaleLower" id = "QualityOfLifeScaleLower" onkeydown="meetsCriteria()">
 and <input name="QualityOfLifeScaleUpper"> <font color="red" id="error"></font><br>
 <script>
	function meetsCriteria()
	{
		
		var s = document.getElementById("QualityOfLifeScaleLower").value;
		var validLength = false;
		var value = Integer.parseInt(s);
		if(s.contains("-1"))
			validLength = true;

	   if(!validLength)
	   {
		   document.getElementById("Submit").disabled = true;
	   	   document.getElementById("error").innerHTML = "Try harder";
	   else
		{
		   document.getElementById("Submit").disabled = false;
	  	   document.getElementById("error").innerHTML = "";
		}
	}
</script>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by EMPHASES<br>
</td>
<td style="vertical-align: top;">contains either<br>
<input name="Emphases1"><br>
<input name="Emphases2"><br>
<input name="Emphases3"><br>
<input name="Emphases4"><br>
<input name="Emphases5"><br>
</td>
</tr>

</tbody>
</table>
<br>
<button value="Search for Universities"
name="Search" id="Submit" type="submit">Search </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input value="Reset Form"
name="Reset" type="reset">
</form>
</body>

</html>
