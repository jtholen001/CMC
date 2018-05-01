<html>
<head>
<title>Edit User Form</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.HashMap" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>
<body>
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
<td style="vertical-align: top;"><input name="FirstName" id="First" onblur="isValidFirst()"value=<%=u.getFirstName()%>><br>
<font color="red" id="errorFN"></font>
<script>
	function isValidFirst()
	{
		var s = document.getElementById("First").value;
		if(s == "")
			{
				document.getElementById("Edit").disabled = true;
	   			document.getElementById("errorFN").innerHTML = "First name cannot be empty";
		   }
		else
		{
				
		   document.getElementById("Edit").disabled = false;
	  	   document.getElementById("errorFN").innerHTML = "";
		} 
	}
</script>
</td>
</tr>
<tr>
<tr>
<td style="vertical-align: top;">Last Name<br>
</td>
<td style="vertical-align: top;"><input name="LastName" id="Last" onblur="isValidLast()" value=<%=u.getLastName()%>><br>
<font color="red" id="errorLN"></font>
<script>
	function isValidLast()
	{
		var s = document.getElementById("Last").value;
		if(s == "")
			{
				document.getElementById("Edit").disabled = true;
	   			document.getElementById("errorLN").innerHTML = "Last name cannot be empty";
		   }
		else
		{
				
		   document.getElementById("Edit").disabled = false;
	  	   document.getElementById("errorLN").innerHTML = "";
		} 
	}
</script>
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
<font color="red" id="error"></font>
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
				containsNum = true
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
		   document.getElementById("Edit").disabled = true;
		   if(!validLength)
		   {
	   			document.getElementById("error").innerHTML = "Passwords must contain at least 6 characters";
		   }
		   else if(!containsCapital)
			   {
			   	document.getElementById("error").innerHTML = "Passwords must contain at least one capital letter";
			   }
		   else if(!containsLower)
			   {
			   document.getElementById("error").innerHTML = "Passwords must contain at least one lower case letter";
			   }
		   else if(!containsNum)
			   {
			   document.getElementById("error").innerHTML = "Passwords must contain at least one number";
			   }
		   else
			   {
			   document.getElementById("error").innerHTML = "Passwords must contain at least one special character";
			   }
	   }
	   else
		{
		   document.getElementById("Edit").disabled = false;
	  	   document.getElementById("error").innerHTML = "";
		}
	}
</script>
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
<td style="vertical-align: top;"><button name = "Edit" id="Edit" type ="submit">Submit</button></td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
</form>
<form method="post" action="ManageUsers.jsp">
	    <input name="Return" value="Return to Menu" type="submit">
	</form>
<br>
</body>
</html>

