<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit University</title>
</head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="cmcPackage.entityClasses.University,cmcPackage.interfaces.*,cmcPackage.Controllers.*,java.util.ArrayList"%>
<%@include file="verifyLogin.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	AdminInterface adminInt = (AdminInterface) session.getAttribute("userInt");
	University university = adminInt.getUniversity(request.getParameter("UniversityName"));

// 	DBController db = new DBController();
// 	University university = db.getUniversity("ADELPHI");
%>
<body>
<p>
<%
String error = request.getParameter("Error");
	if(error!=null){
		if (error.equals("-1"))
			out.print("Uh-Oh! Something went wrong. Please check your input again before submitting your changes.");
	}
%>
</p>
	<form action="EditUniversity_Action.jsp" name="Edit University">
		<table>
			<tbody>
				<tr>
					<td>NAME</td>
					<td><input readonly="readonly"
						name="name" value='<%out.println(university.getName());%>'></td>
				</tr>
				<tr>
					<td>STATE</td>
					<td><select name="state" style="width: 172px;">
								<option value=<%out.println(university.getState());%>><%out.println(university.getState());%></option>
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
								<option value="Virrginia">Virrginia</option>
								<option value="Washington">Washington</option>
								<option value="West Virginia">West Virginia</option>
								<option value="Wisconsin">Wisconsin</option>
								<option value="Wyoming">Wyoming</option>
							</select>
						</td>
				</tr>
				<tr>
					<td>LOCATION</td>
					<td><select name="location" style="width: 172px;">
								<option value=<%out.println(university.getLocation());%>><%out.println(university.getLocation());%></option>
								<option value="Suburban">Suburban</option>
								<option value="Urban">Urban</option>
								<option value="Small-City">Small-City</option>		
						</select>
						</td>
				</tr>
				<tr>
					<td>CONTROL</td>
					<td><%String control = university.getControl(); %>
						<input type="radio" name="control" value="City"<%if (control.equals("CITY")){ %>checked="checked"<%}%>>City
						<input type="radio" name="control" value="Private"<%if (control.equals("PRIVATE")){ %>checked="checked"<%}%>>Private
						<input type="radio" name="control" value="State"<%if (control.equals("STATE")){ %>checked="checked"<%}%>>State
						</td>
				</tr>
				<tr>
					<td>NUMBER OF STUDENTS</td>
					<td><input name="numberOfStudents" id="numberOfStudents" value=<%out.println(university.getNumStudents());%> onblur ='meetsCriteria("numberOfStudents", 0, 1000000, "int")'><br>  
					<font color="red" id="numberOfStudentsError"></font></td>
				</tr>
				<tr>
					<td>% FEMALE</td>			
					<td><input name="percentFemale" id="percentFemale" value=<%out.println(university.getPercentFemale());%> onblur ='meetsCriteria("percentFemale", 0.0, 100.0, "double")'><br>  
					<font color="red" id="percentFemaleError"></font></td>
				</tr>
				<tr>
					<td>% SAT VERBAL</td>
					<td><input name="SATVerbal" id="SATVerbal" value=<%out.println(university.getSATVerbal());%> onblur ='meetsCriteria("SATVerbal", 0.0, 800.0, "double")'><br>  
					<font color="red" id="SATVerbalError"></font></td>
				</tr>
				<tr>
					<td>% SAT MATH</td>
					<td><input name="SATMath" id="SATMath" value=<%out.println(university.getSATMath());%> onblur ='meetsCriteria("SATMath", 0.0, 800.0, "double")'><br>  
					<font color="red" id="SATMathError"></font></td>
				</tr>
				<tr>
					<td>EXPENSES</td>
					<td><input name="Expenses" id="Expenses" value=<%out.println(university.getExpenses());%> onblur ='meetsCriteria("Expenses", 0.0, 1000000.0, "double")'><br>  
					<font color="red" id="ExpensesError"></font></td>
				</tr>
				<tr>
					<td>% FINANCIAL AID</td>
					<td><input name="percentFinancialAid" id="percentFinancialAid" value=<%out.println(university.getPercentFinancialAid());%> onblur ='meetsCriteria("percentFinancialAid", 0.0, 100.0, "double")'><br>  
					<font color="red" id="percentFinancialAidError"></font></td>
				</tr>
				<tr>
					<td>NUMBER OF
						APPLICANTS</td>
					<td><input name="numberOfApplicants" id="numberOfApplicants" value=<%out.println(university.getNumApplicants());%> onblur ='meetsCriteria("numberOfApplicants", 0, 1000000, "int")'><br>  
					<font color="red" id="numberOfApplicantsError"></font></td>
				</tr>
				<tr>
					<td>% ADMITTED</td>
					<td><input name="percentAdmitted" id="percentAdmitted" value=<%out.println(university.getPercentAdmitted());%> onblur ='meetsCriteria("percentAdmitted", 0.0, 100.0, "double")'><br>  
					<font color="red" id="percentAdmittedError"></font></td>
				</tr>
				<tr>
					<td>% ENROLLED</td>
					<td><input name="percentEnrolled" id="percentEnrolled" value=<%out.println(university.getPercentEnrolled());%> onblur ='meetsCriteria("percentEnrolled", 0.0, 100.0, "double")'><br>  
					<font color="red" id="percentEnrolledError"></font></td>
				</tr>
				<tr>
					<td>ACADEMICS SCALE (1-5)</td>
					<td>
						<%int cAcademicScale = university.getAcademicScale();%>
						<input type="radio" name="academicScale" value="1"<%if(cAcademicScale==1){%> checked = "checked"<%}%>>1
						<input type="radio" name="academicScale" value="2"<%if(cAcademicScale==2){%> checked = "checked"<%}%>>2
						<input type="radio" name="academicScale" value="3"<%if(cAcademicScale==3){%> checked = "checked"<%}%>>3
						<input type="radio" name="academicScale" value="4"<%if(cAcademicScale==4){%> checked = "checked"<%}%>>4
						<input type="radio" name="academicScale" value="5"<%if(cAcademicScale==5){%> checked = "checked"<%}%>>5
						</td>
				</tr>
				<tr>
					<td>SOCIAL SCALE</td>
					<td>
						<%int cSocialScale = university.getSocialScale();%>
						<input type="radio" name="socialScale" value="1"<%if(cSocialScale==1){%> checked = "checked"<%}%>>1
						<input type="radio" name="socialScale" value="2"<%if(cSocialScale==2){%> checked = "checked"<%}%>>2
						<input type="radio" name="socialScale" value="3"<%if(cSocialScale==3){%> checked = "checked"<%}%>>3
						<input type="radio" name="socialScale" value="4"<%if(cSocialScale==4){%> checked = "checked"<%}%>>4
						<input type="radio" name="socialScale" value="5"<%if(cSocialScale==5){%> checked = "checked"<%}%>>5
						</td>
				</tr>
				<tr>
					<td>QUALITY OF LIFE SCALE (1-5)</td>
					<td>
						<%int cQualityScale = university.getQualityOfLifeScale();%>
						<input type="radio" name="qualityOfLife" value="1"<%if(cQualityScale==1){%> checked = "checked"<%}%>>1
						<input type="radio" name="qualityOfLife" value="2"<%if(cQualityScale==2){%> checked = "checked"<%}%>>2
						<input type="radio" name="qualityOfLife" value="3"<%if(cQualityScale==3){%> checked = "checked"<%}%>>3
						<input type="radio" name="qualityOfLife" value="4"<%if(cQualityScale==4){%> checked = "checked"<%}%>>4
						<input type="radio" name="qualityOfLife" value="5"<%if(cQualityScale==5){%> checked = "checked"<%}%>>5
						</td>
				</tr>
				<tr>
				<td>EMPHASES</td>
				<td>
					<%
						ArrayList<String> temp = university.getEmphases();
						Integer i = new Integer(temp.size());
						for (i = 0; i < temp.size(); i++) {
					%>
								
						<input
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
						<input 
						name=<%out.println("end");%> value="">
					</td>
				</tr>
				<tr>

					<td><input value="Submit" name="Log in" type="submit" class="buttonstyle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input value="Cancel" name="Reset" type="reset" class="buttonstyle"></td>

					<td><button value="Submit" id="Edit" type="submit"> Edit </button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td><input value="Cancel" name="Reset" type="reset"></td>

					


				</tr>
			</tbody>
		</table>
	</form>
	<form method="post" action="AdminMenu.jsp">
	    <input name="Return" value="Return to Menu" type="submit" class="buttonstyle">
	</form>
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
				document.getElementById("Edit").disabled = false;
				document.getElementById(name+"Error").innerHTML = "";
			} else {
				document.getElementById("Edit").disabled = true;
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