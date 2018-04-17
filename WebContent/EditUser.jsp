<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.HashMap" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>
<html>
<head>
<title>Edit User Form</title>
</head>
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
<td style="vertical-align: top;"><input name="FirstName" value=<%=u.getFirstName()%>><br>
</td>
</tr>
<tr>
<tr>
<td style="vertical-align: top;">Last Name<br>
</td>
<td style="vertical-align: top;"><input name="LastName" value=<%=u.getLastName()%>><br>
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
	   if(!validLength)
		   {
		  	 alert("Password must be at least 6 characters long");
		   }
	   else if(!containsCapital)
		   {
		  	 alert("Password must contain at least one capital letter");
		   }
	   else if(!containsLower)
		   {
		   	 alert("Password must contain at least one lower case letter");
		   }
	   else if(!containsNum)
		   {
		   	 alert("Password must contain at least one number");
		   }
	   else if(!containsSpecialChar)
		   {
		   	 alert("Password must contain at least one special character");
		   }
	}
</script>
</tr>
<tr>
<td style="vertical-align: top;">Type<br>
</td>
<td style="vertical-align: top;"><input name="Type" value=<%=u.getType()%>> </td>
</tr>
<tr>
<td style="vertical-align: top;">Status<br>
</td>
<td style="vertical-align: top;"><input name="Status" value=<%=u.getActivationStatus()%>> </td>
</tr>

<tr>
<td style="vertical-align: top;"><input value="Edit"
name="Edit" type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td style="vertical-align: top;"><input value="Reset"
name="Reset" type="reset"></td>
</tr>
</tbody>
</table>
<br>
</form>
<br>
</body>
</html>

