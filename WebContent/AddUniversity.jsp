<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Add University Form</title>
</head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.*" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>
<body>
<br>
Add University:<br>
<br>
<p>
<%
String error = request.getParameter("Error");
	if(error!=null){
		if (error.equals("-1"))
			out.print("Uh-Oh! Something went wrong. Please check your input again and make sure your University name is unique.");
	}
%>
</p>
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
		<option value="-1">Not Applicable</option>
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
	</select>
</td>
</tr>
<tr>
<td>Location</td>
<td><select name="Location" style="width: 172px;">
		<option value="-1">Not Applicable</option>
		<option value="Suburban">Suburban</option>
		<option value="Urban">Urban</option>
		<option value="Small-City">Small-City</option>		
		</select></td>
</tr>
<tr>
<td>Control</td>
<td><input type="radio" name="Control" value="City">City
	<input type="radio" name="Control" value="Private">Private
	<input type="radio" name="Control" value="State">State
</td>
</tr>
<tr>
<td>Number Of Students</td>
<td><input name="numberOfStudents" id="numberOfStudents" onblur ='meetsCriteria("numberOfStudents", 0, 1000000, "int")'><br>  
<font color="red" id="numberOfStudentsError"></font></td>
</tr>
<tr>
<td>% Female</td>
<td><input name="percentFemale" id="percentFemale" onblur ='meetsCriteria("percentFemale", 0.0, 100.0, "double")'><br>  
<font color="red" id="percentFemaleError"></font></td>
</tr>
<tr>
<td>SAT Verbal</td>
<td><input name="SATVerbal" id="SATVerbal" onblur ='meetsCriteria("SATVerbal", 0.0, 800.0, "double")'><br>  
<font color="red" id="SATVerbalError"></font></td>
</tr>
<tr>
<td>SAT Math</td>
<td><input name="SATMath" id="SATMath" onblur ='meetsCriteria("SATMath", 0.0, 800.0, "double")'><br>  
<font color="red" id="SATMathError"></font></td>
</tr>
<tr>
<td>Expenses</td>
<td><input name="Expenses" id="Expenses" onblur ='meetsCriteria("Expenses", 0.0, 1000000.0, "double")'><br>  
<font color="red" id="ExpensesError"></font></td>
</tr>
<tr>
<td>% Financial Aid</td>
<td><input name="percentFinancialAid" id="percentFinancialAid" onblur ='meetsCriteria("percentFinancialAid", 0.0, 100.0, "double")'><br>  
<font color="red" id="percentFinancialAidError"></font></td>
</tr>
<tr>
<td>Number Of Applicants</td>
<td><input name="numberOfApplicants" id="numberOfApplicants" onblur ='meetsCriteria("numberOfApplicants", 0, 1000000, "int")'><br>  
<font color="red" id="numberOfApplicantsError"></font></td>
</tr>
<tr>
<td>% Admitted</td>
<td><input name="percentAdmitted" id="percentAdmitted" onblur ='meetsCriteria("percentAdmitted", 0.0, 100.0, "double")'><br>  
<font color="red" id="percentAdmittedError"></font></td>
</tr>
<tr>
<td>% Enrolled</td>
<td><input name="percentEnrolled" id="percentEnrolled" onblur ='meetsCriteria("percentEnrolled", 0.0, 100.0, "double")'><br>  
<font color="red" id="percentEnrolledError"></font></td>
</tr>
<tr>
<td>Academic Scale (1-5)</td>
<td><input type="radio" name="academicScale" value="1">1
	<input type="radio" name="academicScale" value="2">2
	<input type="radio" name="academicScale" value="3">3
	<input type="radio" name="academicScale" value="4">4
	<input type="radio" name="academicScale" value="5">5</td>
</tr>
<tr>
<td>Social Scale (1-5)</td>
<td><input type="radio" name="socialScale" value="1">1
	<input type="radio" name="socialScale" value="2">2
	<input type="radio" name="socialScale" value="3">3
	<input type="radio" name="socialScale" value="4">4
	<input type="radio" name="socialScale" value="5">5</td>
</tr>
<tr>
<td>Quality Of Life Scale (1-5)</td>
<td><input type="radio" name="qualityOfLifeScale" value="1">1
	<input type="radio" name="qualityOfLifeScale" value="2">2
	<input type="radio" name="qualityOfLifeScale" value="3">3
	<input type="radio" name="qualityOfLifeScale" value="4">4
	<input type="radio" name="qualityOfLifeScale" value="5">5</td>
</tr>
<tr>
<td>Emphases<br><br>*You may add more<br>emphases later</td>
<td><input name="emphases1"><br><input name="emphases2"><br><input name="emphases3">
</td>
</tr>

<tr>
<td><button value="Add"
name="Add" id="Submit" type="submit" class="buttonstyle">Add</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input value="Reset"
name="Reset" type="reset" class="buttonstyle"></td>
</tr>
</tbody>
</table>
<br>
</form>
	<form method="post" action="ManageUniversities.jsp">
	    <input name="Cancel" value="Cancel" type="submit" class="buttonstyle">
	</form>
<br>
</body>
<script>
	function meetsCriteria(name, minRequired, maxRequired, type)
	{
		var value = document.getElementById(name).value;
			var valid = false;
			var invalidRange = false;
			if (type == "int") {
				if (value == "") {
					valid = true;
				}
				else if (!value.match(/[^0-9]/g)) {
					var num1 = parseInt(value);					
					if (num1 >= minRequired && num1 <= maxRequired)
						valid = true;
					else
						invalidRange = true;
				}
			} else {
				var firstDot = value.indexOf(".");
				var lastDot = value.lastIndexOf(".");

				var validDots = false;
				if (firstDot == lastDot) {
					if (lastDot == -1 || lastDot != value.length - 1)
						validDots = true;
				}
				if (value == "") {
					valid = true;
				}
				else if (!value.match(/[^0-9.]/g)&& validDots) {
					var num1 = parseFloat(value);					
					if (num1 >= minRequired && num1 <= maxRequired)
						valid = true;
					else
						invalidRange = true; 										
				}
							
			}
			if (valid) {
				document.getElementById("Submit").disabled = false;
				document.getElementById(name+"Error").innerHTML = "";
			} else {
				document.getElementById("Submit").disabled = true;
				if (maxRequired == 1000000.0 || maxRequired == 1000000) //place value for no maximum
					document.getElementById(name+"Error").innerHTML = "enter a valid number above " + minRequired;
				else if(type == "int")
					document.getElementById(name+"Error").innerHTML = "enter a valid number between " + minRequired + " and " + maxRequired;
				else 
					document.getElementById(name+"Error").innerHTML = "enter a valid number between " + minRequired + ".0 and " + maxRequired + ".0";
			}
		}
	</script>
</html>
