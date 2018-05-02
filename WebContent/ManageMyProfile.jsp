<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Manage My Profile</title>
</head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="verifyLoginStudent.jsp"  %>
<%
	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
%>
<h2>Manage My Profile</h2>
<body>
<form action="EditProfile_action.jsp" name="EditProfile">
<table style="text-align: left; width: 50%;" border="1" cellpadding="2" cellspacing="2">
  <tbody>
<tr>
	<td style="vertical-align: top">First Name</td>
	<td style="vertical-align: top;"><input name="FirstName" id="FirstName" onblur='isNotEmptyField("FirstName", "First name")'value=<%=studentInt.getStudent().getFirstName()%>>
<font color="red" id="FirstNameError"></font>
</td>
</tr>
<tr>
	<td style="vertical-align: top">Last Name</td>
	<td style="vertical-align: top;"><input name="LastName" id="LastName" onblur='isNotEmptyField("LastName", "Last name")' 
	value=<%=studentInt.getStudent().getLastName()%>>
	<font color="red" id="LastNameError"></font>
	</td>
</tr>  
<tr>
	<td style="vertical-align: top">Username</td>
	<td style="vertical-align: top"><input readonly="readonly" name="Username" value=<%=studentInt.getStudent().getUsername()%>></td>
</tr> 
<tr>
	<td style="vertical-align: top">Password</td>
<td style="vertical-align: top;"><input name="Password" id="Password" onblur="meetsPasswordCriteria()" value=<%=studentInt.getStudent().getPassword()%>>
<font color="red" id="PasswordError"></font>
	</td>
</tr> 
<tr>
	<td style="vertical-align: top">Type</td>
	<td style="vertical-align: top"><input readonly="readonly" name="Type" value=<%=studentInt.getStudent().getType()%>></td>
</tr> 

</tbody>
</table>
<br>
<button name = "Submit" id="Edit" type ="submit" class="buttonstyle">Edit</button>
<input value="Reset"
name="Reset" type="reset" class="buttonstyle">
</form>
<br>

<h2>Security</h2>
 <img src="assets/img/2FA_info.png" alt="2FA Info">
 <br>
 <br>
 <br>
<table style="text-align: left; width: 50%;" border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr>
	<td style="vertical-align: top">2-Factor Authentication</td>
	<%
	if (studentInt.isTfaEnabled()) {
	 %>
	 <td style="vertical-align: top"><form action="EnableTFA_action.jsp"><input type="submit" value="Reset 2FA" class="buttonstyle"/></form></td>
	 <td style="vertical-align: top"><form action="DisableTFA_action.jsp"><input type="submit" value="Disable 2FA" class="buttonstyle"/></form></td>
	 <%
	 } 
	 else {%>
	<td style="vertical-align: top"><form action="EnableTFA_action.jsp"><input type="submit" value="Enable 2FA" class="buttonstyle"/></form></td>
	<%}%>
</tr>
<%
String error = request.getParameter("Error");
if(error != null) {
	if (error.equals("-9"))
		out.print("2FA is not enabled.");
		}
		
String toggle = request.getParameter("gtpl");
if(toggle != null) {
	if (toggle.equals("2"))
		out.print("2FA is now disabled.");
		}
 %>

</tbody>
</table>
<br>

<%
if(toggle != null) {
	if (toggle.equals("1")) {
		String tfaUrl = (String)session.getAttribute("tfaUrl");
%>
	2FA is now enabled. To complete setup, download Google Authenticator for <a href="https://itunes.apple.com/us/app/google-authenticator/id388497605?mt=8">iOS</a> or <a href="https://play.google.com/store/apps/details?id=com.google.android.apps.authenticator2&hl=en_US">Android</a> and scan the QR code.
	<br>
	<br>
	<br>
	<img src=<%out.println(tfaUrl);%>>
	<br>
	<br>
	<br>
	<%}
	} %>

<form method="post" action="StudentMenu.jsp">
	    <input name="Return" value="Return to Menu" type="submit" class="buttonstyle">
</form>
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