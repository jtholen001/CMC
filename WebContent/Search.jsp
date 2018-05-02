<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="styles.css">
<meta content="text/html; charset=ISO-8859-1"
http-equiv="content-type">
<html>
<head>
<title>Search</title>
</head>
<body>
<%@include file="verifyLogin.jsp"  %>
</head>
<body>

<h2>Search</h2>
<p>
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
 </p>
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
<td style="vertical-align: top;"> <select name="State" style="width: 172px;">
		<option value=""></option>
		<option value="Foreign">Foreign</option>
		<option value="Alabama">Alabama</option>
		<option value="Alaska">Alaska</option>
		<option value="Arizona">Arizona</option>
		<option value="Arkansas">Arkansas</option>
		<option value="California">California</option>
		<option value="Colorado">Colorado</option>
		<option value="Connecticut">Connecticut</option>
		<option value="Delaware">Delaware</option>
		<option value="Florida">Florida</option>
		<option value="Georgia">Georgia</option>
		<option value="Hawaii">Hawaii</option>
		<option value="Idaho">Idaho</option>
		<option value="Illinois">Illinois</option>
		<option value="Indiana">Indiana</option>
		<option value="Iowa">Iowa</option>
		<option value="Kansas">Kansas</option>
		<option value="Kentucky">Kentucky</option>
		<option value="Louisiana">Louisiana</option>
		<option value="Maine">Maine</option>
		<option value="Maryland">Maine</option>
		<option value="Massachusetts">Massachusetts</option>
		<option value="Michigan">Michigan</option>
		<option value="Minnesota">Minnesota</option>
		<option value="Mississippi">Mississippi</option>
		<option value="Missouri">Missouri</option>
		<option value="Montana">Montana</option>
		<option value="Nebraska">Nebraska</option>
		<option value="Nevada">Nevada</option>
		<option value="New Hampshire">New Hampshire</option>
		<option value="New Jersey">New Jersey</option>
		<option value="New Mexico">New Mexico</option>
		<option value="New York">New York</option>
		<option value="North Carolina">North Carolina</option>
		<option value="North Dakota">North Dakota</option>
		<option value="Ohio">Ohio</option>
		<option value="Oklahoma">Oklahoma</option>
		<option value="Oregon">Oregon</option>
		<option value="Pennsylvania">Pennsylvania</option>
		<option value="Rhode Island">Rhode Island</option>
		<option value="South Carolina">South Carolina</option>
		<option value="South Dakota">South Dakota</option>
		<option value="Tennessee">Tennessee</option>
		<option value="Texas">Texas</option>
		<option value="Utah">Utah</option>
		<option value="Vermont">Vermont</option>
		<option value="Virginia">Virginia</option>
		<option value="Washington">Washington</option>
		<option value="West Virginia">West Virginia</option>
		<option value="Wisconsin">Wisconsin</option>
		<option value="Wyoming">Wyoming</option>
	</select> <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by LOCATION<br>
</td>
<td style="vertical-align: top;"><select name="Location" style="width: 172px;">
		<option value=""></option>
		<option value="SURBURAN">Suburban</option>
		<option value="URBAN">Urban</option>
		<option value="SMALL-CITY">Small-City</option>		
		</select><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by CONTROL<br>
</td>
<td style="vertical-align: top;"><select name="Control" style="width: 172px;">
		<option value=""></option>
		<option value="PRIVATE">Private</option>
		<option value="STATE">State</option>
		<option value="CITY">City</option>		
		</select><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by NUMBER OF STUDENTS<br>
</td>
 <td style="vertical-align: top;">between <input name="NumStudentsLower" id="NumStudentsLower" onblur='meetsCriteria("NumStudents", 0, 1000000, "int")'> 
 and <input name="NumStudentsUpper" id="NumStudentsUpper" onblur='meetsCriteria("NumStudents", 0, 100000, "int")'>
 <font color="red" id="NumStudentsError"></font><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by % FEMALE<br>
</td>
<td style="vertical-align: top;">between <input name="PercentFemaleLower" id="PercentFemaleLower" onblur='meetsCriteria("PercentFemale", 0.0, 100.0, "double")'>
 and <input name="PercentFemaleUpper" id="PercentFemaleUpper" onblur='meetsCriteria("PercentFemale", 0.0, 100.0, "double")'> 
 <font color="red" id="PercentFemaleError"></font> <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by SAT VERBAL<br>
</td>
<td style="vertical-align: top;">between <input name="SATVerbalLower" id="SATVerbalLower" onblur='meetsCriteria("SATVerbal", 0.0, 800.0, "double")'>
 and <input name="SATVerbalUpper" id="SATVerbalUpper" onblur='meetsCriteria("SATVerbal", 0.0, 800.0, "double")'> 
 <font color="red" id="SATVerbalError"></font> <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by SAT MATH<br>
</td>
<td style="vertical-align: top;">between <input name="SATMathLower" id="SATMathLower" onblur='meetsCriteria("SATMath", 0.0, 800.0, "double")'>
 and <input name="SATMathUpper" id="SATMathUpper" onblur='meetsCriteria("SATMath", 0.0, 800.0, "double")'> 
 <font color="red" id="SATMathError"></font> <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by EXPENSES<br>
</td>
<td style="vertical-align: top;">between <input name="ExpensesLower" id="ExpensesLower" onblur='meetsCriteria("Expenses", 0.0, 1000000.0, "double")'>
 and <input name="ExpensesUpper" id="ExpensesUpper" onblur='meetsCriteria("Expenses", 0.0, 100.0, "double")'> 
 <font color="red" id="ExpensesError"></font> <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by % FINANCIAL AID<br>
</td>
<td style="vertical-align: top;">between <input name="PercentFinancialAidLower" id="PercentFinancialAidLower" onblur='meetsCriteria("PercentFinancialAid", 0.0, 100.0, "double")'>
 and <input name="PercentFinancialAidUpper" id="PercentFinancialAidUpper" onblur='meetsCriteria("PercentFinancialAid", 0.0, 100.0, "double")'> 
 <font color="red" id="PercentFinancialAidError"></font> <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by NUMBER OF APPLICANTS<br>
</td>
 <td style="vertical-align: top;">between <input name="NumApplicantsLower" id="NumApplicantsLower" onblur='meetsCriteria("NumApplicants", 0, 1000000, "int")'> 
 and <input name="NumApplicantsUpper" id="NumApplicantsUpper" onblur='meetsCriteria("NumApplicants", 0, 100000, "int")'>
 <font color="red" id="NumApplicantsError"></font><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by % ADMITTED<br>
</td>
<td style="vertical-align: top;">between <input name="PercentAdmittedLower" id="PercentAdmittedLower" onblur='meetsCriteria("PercentAdmitted", 0.0, 100.0, "double")'>
 and <input name="PercentAdmittedUpper" id="PercentAdmittedUpper" onblur='meetsCriteria("PercentAdmitted", 0.0, 100.0, "double")'> 
 <font color="red" id="PercentAdmittedError"></font> <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by % ENROLLED<br>
</td>
<td style="vertical-align: top;">between <input name="PercentEnrolledLower" id="PercentEnrolledLower" onblur='meetsCriteria("PercentEnrolled", 0.0, 100.0, "double")'>
 and <input name="PercentEnrolledUpper" id="PercentEnrolledUpper" onblur='meetsCriteria("PercentEnrolled", 0.0, 100.0, "double")'> 
 <font color="red" id="PercentEnrolledError"></font> <br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by ACADEMIC SCALE (1-5)<br>
</td>
<td style="vertical-align: top;">between <input name="AcademicScaleLower" id="AcademicScaleLower" onblur='meetsCriteria("AcademicScale", 1, 5, "int")'> 
and <input name="AcademicScaleUpper" id="AcademicScaleUpper" onblur='meetsCriteria("AcademicScale", 1, 5, "int")'>
 <font color="red" id="AcademicScaleError"></font><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by SOCIAL SCALE (1-5)<br>
</td>
<td style="vertical-align: top;">between <input name="SocialScaleLower" id="SocialScaleLower" onblur='meetsCriteria("SocialScale", 1, 5, "int")'> 
 and <input name="SocialScaleUpper" id="SocialScaleUpper" onblur='meetsCriteria("SocialScale", 1, 5, "int")'>
 <font color="red" id="SocialScaleError"></font><br>
</td>
</tr>
<tr>
<td style="vertical-align: top;">by QUALITY OF LIFE SCALE (1-5)<br>
</td>
<td style="vertical-align: top;">between <input name="QualityOfLifeScaleLower" id = "QualityOfLifeScaleLower" onblur='meetsCriteria("QualityOfLifeScale", 1, 5, "int")'>
 and <input name="QualityOfLifeScaleUpper" id="QualityOfLifeScaleUpper" onblur='meetsCriteria("QualityOfLifeScale", 1, 5, "int")'> 
 <font color="red" id="QualityOfLifeScaleError"></font><br>
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
name="Search" id="Submit" type="submit">Search</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input value="Reset Form"
name="Reset" type="reset">
</form>
<form method="post" action="StudentMenu.jsp">
	    <input name="Return" value="Return to Menu" type="submit">
	</form>
</body>
 <script>
	function meetsCriteria(name, minRequired, maxRequired, type)
	{
		var lowerValue = document.getElementById(name+"Lower").value;
	    var upperValue = document.getElementById(name+"Upper").value;
			var valid = false;
			var invalidRange = false;
			if (type == "int") {
				if (lowerValue == "" && upperValue == "") {
					valid = true;
				}
				else if (!lowerValue.match(/[^0-9]/g) && upperValue == "") {
					var num1 = parseInt(lowerValue);					
					if (num1 >= minRequired && num1 <= maxRequired)
						valid = true;
				}
				else if (lowerValue == "" && !upperValue.match(/[^0-9]/g)) {
					var num2 = parseInt(upperValue);					
					if (num2 >= minRequired && num2 <= maxRequired)
						valid = true;
				}
				else if (!lowerValue.match(/[^0-9]/g) && !upperValue.match(/[^0-9]/g)) {
					var num1 = parseInt(lowerValue);
					var num2 = parseInt(upperValue);
					if (num1 >= minRequired && num2 <= maxRequired && num1 <= num2)
						valid = true;
					else
						invalidRange = true; 
				}
			} else {
				var firstDotLowerValue = lowerValue.indexOf(".");
				var lastDotLowerValue = lowerValue.lastIndexOf(".");
				var firstDotUpperValue = upperValue.indexOf(".");
				var lastDotUpperValue = upperValue.lastIndexOf(".");
				var validDots = false;
				if (firstDotLowerValue == lastDotLowerValue && firstDotUpperValue == lastDotUpperValue) {
					if ((lastDotLowerValue == -1 || lastDotLowerValue != lowerValue.length - 1) && (lastDotUpperValue == -1 || lastDotUpperValue != upperValue.length - 1))
						validDots = true;
				}
				if (lowerValue == "" && upperValue == "") {
					valid = true;
				}
				else if (!lowerValue.match(/[^0-9.]/g) && upperValue == "" && validDots) {
					var num1 = parseFloat(lowerValue);					
					if (num1 >= minRequired && num1 <= maxRequired)
						valid = true;
				}
				else if (lowerValue == "" && !upperValue.match(/[^0-9.]/g) && validDots) {
					var num2 = parseFloat(upperValue);					
					if (num2 >= minRequired && num2 <= maxRequired)
						valid = true;
				}
				else if (!lowerValue.match(/[^0-9.]/g) && !upperValue.match(/[^0-9.]/g) && validDots) {
					var num1 = parseFloat(lowerValue);
					var num2 = parseFloat(upperValue);
					if (num1 >= minRequired && num2 <= maxRequired && num1 <= num2)
						valid = true;
					else
						invalidRange = true; 						
				}				
			}
			if (valid) {
				document.getElementById("Submit").disabled = false;
				document.getElementById(name+"Error").innerHTML = "";
			} else if (invalidRange) {
				document.getElementById("Submit").disabled = true;
				document.getElementById(name+"Error").innerHTML = "invalid range";
			}
			else {
				document.getElementById("Submit").disabled = true;
				if (maxRequired == 1000000.0 || maxRequired == 1000000) //place value for no maximum
					document.getElementById(name+"Error").innerHTML = "enter valid numbers above " + minRequired;
				else if(type == "int")
					document.getElementById(name+"Error").innerHTML = "enter valid numbers between " + minRequired + " and " + maxRequired;
				else 
					document.getElementById(name+"Error").innerHTML = "enter valid numbers between " + minRequired + ".0 and " + maxRequired + ".0";
			}
		}
	</script>
</html>
