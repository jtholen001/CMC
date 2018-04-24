<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage My Profile</title>
</head>
<h2>Manage My Profile</h2>
<body>
<form action="EditProfile_action.jsp" name="EditProfile">
<table style="text-align: left; width: 50%;" border="1" cellpadding="2" cellspacing="2">
  <tbody>
<tr>
	<td style="vertical-align: top">First Name</td>
	<td style="vertical-align: top"><input name="firstName" value=<%out.print(studentInt.getStudent().getFirstName());%>></td>
</tr>
<tr>
	<td style="vertical-align: top">Last Name</td>
	<td style="vertical-align: top"><input name="lastName" value=<%out.print(studentInt.getStudent().getLastName());%>></td>
</tr>  
<tr>
	<td style="vertical-align: top">Username</td>
	<td style="vertical-align: top"><input readonly="readonly" name="Username" value=<%out.print(studentInt.getStudent().getUsername());%>></td>
</tr> 
<tr>
	<td style="vertical-align: top">Password</td>
<td style="vertical-align: top;"><input name="Password" id="Password" onblur="meetsPasswordCriteria()" value=<%out.print(studentInt.getStudent().getPassword());%>>
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
		   document.getElementById("Submit").disabled = true;
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
		   document.getElementById("Submit").disabled = false;
	  	   document.getElementById("error").innerHTML = "";
		}
	}
</script>
	</td>
</tr> 
<tr>
	<td style="vertical-align: top">Type</td>
	<td style="vertical-align: top"><input readonly="readonly" name="Type" value=<%out.print(studentInt.getStudent().getType());%>></td>
</tr> 

</tbody>
</table>
<br>
<button name = "Submit" id="Submit" type ="submit">Submit</button>
<input value="Reset Form"
name="Reset" type="reset">
</form>
<br>

Security
<table style="text-align: left; width: 50%;" border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
	<td style="vertical-align: top">2-Factor Authentication</td>
	<%
	if (studentInt.isTfaEnabled()) {
	 %>
	 <td style="vertical-align: top"><form action="Enable2FA_action.jsp"><input type="submit" value="Reset 2FA" /></form></td>
	 <td style="vertical-align: top"><form action="Disable2FA_action.jsp"><input type="submit" value="Disable 2FA" /></form></td>
	 <%
	 } 
	 else {%>
	<td style="vertical-align: top"><form action="Enable2FA_action.jsp"><input type="submit" value="Enable 2FA" /></form></td>
	<%}%>
</tr>
<%
String error = request.getParameter("Error");
if(error != null) {
	if (error.equals("-9"))
		out.print("2FA is not enabled.");
		}
		
String disabled = request.getParameter("Disabled");
if(disabled != null) {
	if (disabled.equals("1"))
		out.print("2FA is now disabled.");
		}
		
String enabled = request.getParameter("Enabled");
if(disabled != null) {
	if (disabled.equals("1")) {
		out.print("2FA is now enabled.");
		out.println(request.getParameter("tfaUrl"));
		}
		}
 %>

</tbody>
</table>
</body>
</html>