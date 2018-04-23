<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.*" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Add User Form</title>

</head>
<body>
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
<td style="vertical-align: top;"><input name="FirstName" id="First" onblur="isValidFirst()"><br>
<font color="red" id="errorFN"></font>
<script>
	function isValidFirst()
	{
		var s = document.getElementById("First").value;
		if(s == null)
			{
				document.getElementById("Add").disabled = true;
	   			document.getElementById("errorFN").innerHTML = "Name cannot be empty";
		   }
		else
		{
				alert(:got here";)
		   document.getElementById("Add").disabled = false;
	  	   document.getElementById("errorFN").innerHTML = "";
		} 
	}
</script>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Last Name<br>
</td>
<td style="vertical-align: top;"><input name="LastName"><br>
<font color="red" id="errorLN"></font>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Username<br>
</td>
<td style="vertical-align: top;"><input name="Username"><br>
<font color="red" id="errorUN"></font> </td>
</tr>
<tr>
<td style="vertical-align: top;">Password<br>
</td>
<td style="vertical-align: top;"><input name="Password" id="Password" onblur="meetsPasswordCriteria()">
<font color="red" id="errorP"></font>
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

		for (var i = 0; i < s.length; i++)
		{
			if(!isNaN(s.charAt(i)))
			{
				containsNum = true;
			}
			else if(/^[a-zA-Z0-9- ]*$/.test(s.charAt(i)) == false)
			{
				containsSpecialChar = true;
			}
		    else if(s.charAt(i) == s.charAt(i).toUpperCase())
			{
		    	containsCapital = true;
			}
		   else if(s.charAt(i) == s.charAt(i).toLowerCase())
			{
			   containsLower = true;
			}
		}

	   if(!validLength || !containsCapital || !containsLower || !containsNum || !containsSpecialChar)
	   {
		   document.getElementById("Add").disabled = true;
		   if(!validLength)
		   {
	   			document.getElementById("errorP").innerHTML = "Passwords must contain at least 6 characters";
		   }
		   else if(!containsCapital)
			   {
			   	document.getElementById("errorP").innerHTML = "Passwords must contain at least one capital letter";
			   }
		   else if(!containsLower)
			   {
			   document.getElementById("errorP").innerHTML = "Passwords must contain at least one lower case letter";
			   }
		   else if(!containsNum)
			   {
			   document.getElementById("errorP").innerHTML = "Passwords must contain at least one number";
			   }
		   else
			   {
			   document.getElementById("errorP").innerHTML = "Passwords must contain at least one special character";
			   }
	   }
	   else
		{
		   document.getElementById("Add").disabled = false;
	  	   document.getElementById("error").innerHTML = "";
		}
	}
</script>
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
<td style="vertical-align: top;"><button name = "Add" id="Add" type ="submit">Add</button></td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
<br>
</form>
<form method="post" action="ManageUsers.jsp">
	    <input name="Cancel" value="Cancel" type="submit">
	</form>
<br>
</body>
</html>
