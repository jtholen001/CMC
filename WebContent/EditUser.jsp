<html>
<head>
<title>Edit User Form</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.HashMap" pageEncoding="UTF-8"%>
    <%@include file="verifyLoginAdmin.jsp"%>
<body>
<p>
<%
String error = request.getParameter("error");
if (error!=null && "-1".equals(error))
	out.print("Uh-oh! Something went wrong! Please check your input and try again.");
%>
</p>
<br>
Edit User form:<br>
<br>
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
	HashMap<String, User> users = adminInt.viewUsers();
    out.println("Edit user : " + request.getParameter("Username"));
	User u = users.get(request.getParameter("Username"));
%>
<form method="post" action="EditUser_action.jsp" name="editUser"><br>
<table style="text-align: left; width: 266px; height: 228px;"
border="1" >
<tbody>
<tr>
<td style="vertical-align: top;">First Name<br>
</td>
<td style="vertical-align: top;"><input name="FirstName" id="FirstName" onblur='isNotEmptyField("FirstName", "First name")' value=<%=u.getFirstName()%>><br>
<font color="red" id="FirstNameError"></font>
</td>
</tr>
<tr>
<tr>
<td style="vertical-align: top;">Last Name<br>
</td>
<td style="vertical-align: top;"><input name="LastName" id="LastName" onblur='isNotEmptyField("LastName", "Last name")' value=<%=u.getLastName()%>><br>
<font color="red" id="LastNameError"></font>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Username<br>
</td>
<td style="vertical-align: top;"><input name="Username" value=<%=u.getUsername()%> readonly> </td>
</tr>
<tr>
<td style="vertical-align: top;">Password<br>
</td>
<td style="vertical-align: top;"><input name="Password" id="Password" onblur="meetsPasswordCriteria()" value='<%=u.getPassword()%>'>
<font color="red" id="PasswordError"></font>
</tr>
<tr>
<td style="vertical-align: top;">Type<br>
</td>
<td>
<%
if(u.getType()=='u')
{
	out.println("<input type=\"radio\" name=\"Type\" value='u' checked=\"checked\">Student<input type=\"radio\" name=\"Type\" value='a'>Admin");
}
else
{
	out.println("<input type=\"radio\" name=\"Type\" value='u'>Student<input type=\"radio\" name=\"Type\" value='a' checked=\"checked\">Admin");
}
%>
</td>
</tr>
<tr>
<td style="vertical-align: top;">Status<br>
</td>
<td>
<%
if(u.getActivationStatus() == true)
{
	out.println("<input type=\"radio\" name=\"Status\" value='true' checked=\"checked\">Active<input type=\"radio\" name=\"Status\" value='false'>Inactive</td>");
}
else
{
	out.println("<input type=\"radio\" name=\"Status\" value='true'>Active<input type=\"radio\" name=\"Status\" value='false' checked=\"checked\">Inactive</td>");
}
%>
</td>
</tr>

<tr>
<td style="vertical-align: top;"><button name = "Edit" id="Edit" type ="submit" class="buttonstyle">Submit</button></td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset" class="buttonstyle"></td>
</tr>
</tbody>
</table>
</form>
<form method="post" action="ManageUsers.jsp">
	    <input name="Return" value="Return to Menu" type="submit" class="buttonstyle">
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
		   document.getElementById("Edit").disabled = true;
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
		   document.getElementById("Edit").disabled = false;
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
				document.getElementById("Edit").disabled = true;
	   			document.getElementById(fieldId +"Error").innerHTML = value + " cannot be empty";
		   }
		else
		{
				
		   document.getElementById("Edit").disabled = false;
	  	   document.getElementById(fieldId + "Error").innerHTML = "";
		} 
	}
</script>
</html>

