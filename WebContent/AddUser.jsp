<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Add User Form</title>
</head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.*" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>
<body>
<p>
<%
String error = request.getParameter("error");
if (error!=null && error.equals(-1))
	out.print("Uh-oh! Something went wrong! Please check your input and try again.");
%>
</p>
<br>
Add User form:<br>
<br>
<form method="post" action="AddUser_action.jsp" name="addUser"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
<td style="vertical-align: top;">First Name<br>
</td>
<td style="vertical-align: top;"><input name="FirstName" id="FirstName" onblur='isNotEmptyField("FirstName", "First name")'><br>
<font color="red" id="FirstNameError"></font>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Last Name<br>
</td>
<td style="vertical-align: top;"><input name="LastName" id="LastName" onblur='isNotEmptyField("LastName", "Last name")'><br>
<font color="red" id="LastNameError"></font>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Username<br>
</td>
<td style="vertical-align: top;"><input name="Username" id="UserName" onblur='isNotEmptyField("UserName", "Username")'><br>
<font color="red" id="UserNameError"></font> 
</td>
</tr>
<tr>
<td style="vertical-align: top;">Password<br>
</td>
<td style="vertical-align: top;"><input name="Password" id="Password" onblur="meetsPasswordCriteria()">
<font color="red" id="PasswordError"></font>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Type<br>
</td>
<td><input type="radio" name="Type" value='u' checked="checked">Student
	<input type="radio" name="Type" value='a'>Admin
	</td>
</tr>
<tr>
<td style="vertical-align: top;">Status<br>
</td>
<td><input type="radio" name="Status" value='true' checked="checked">Active
	<input type="radio" name="Status" value='false'>Inactive</td>
</tr>

<tr>
<td style="vertical-align: top;"><button name = "Add" id="Add" type ="submit" class="buttonstyle">Add</button></td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset" class="buttonstyle"></td>
</tr>
</tbody>
</table>
<br>
</form>
<form method="post" action="ManageUsers.jsp">
	    <input name="Cancel" value="Cancel" type="submit" class="buttonstyle">
	</form>
<br>
</body>

<script>
	function meetsPasswordCriteria()
	{
		var validLength = false;
		var containsCapital = false;
		var containsLower = false;
		var containsNum = false;
		var containsSpecialChar = false;
		var s = document.getElementById("Password").value;

		if(s.length >= 6)
			validLength = true;
		if(s.match(/[0-9]/g))			
				containsNum = true;			
		if(s.match(/[^a-zA-Z0-9]/g))
 				containsSpecialChar = true;
 		if(s.match(/[A-Z]/g))
 		    	containsCapital = true;
 		if(s.match(/[a-z]/g))
 			   containsLower = true;

	   if(!validLength || !containsCapital || !containsLower || !containsNum || !containsSpecialChar)
	   {
		   document.getElementById("Add").disabled = true;
		   if(!validLength)
	   			document.getElementById("PasswordError").innerHTML = "Passwords must contain at least 6 characters";
		   else if(!containsCapital)
			   	document.getElementById("PasswordError").innerHTML = "Passwords must contain at least one capital letter";
		   else if(!containsLower)
			   document.getElementById("PasswordError").innerHTML = "Passwords must contain at least one lower case letter";
		   else if(!containsNum)
			   document.getElementById("PasswordError").innerHTML = "Passwords must contain at least one number";
		   else
			   document.getElementById("PasswordError").innerHTML = "Passwords must contain at least one special character";
	   }
	   else
		{
		   document.getElementById("Add").disabled = false;
	  	   document.getElementById("PasswordError").innerHTML = "";
		}
	}
</script>


<script>
	function isNotEmptyField(fieldId, value)
	{
		var s = document.getElementById(fieldId).value;
		if(s == "")
			{
				document.getElementById("Add").disabled = true;
	   			document.getElementById(fieldId +"Error").innerHTML = value + " cannot be empty";
		   }
		else
		{
				
		   document.getElementById("Add").disabled = false;
	  	   document.getElementById(fieldId + "Error").innerHTML = "";
		} 
	}
</script>
</html>
