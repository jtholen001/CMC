<html>
<title>Manage Users</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><link rel="stylesheet" type="text/css" href="styles.css">
</head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.HashMap" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
	HashMap<String, User> users = adminInt.viewUsers();
%>
<body>
	<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
		<tbody>
			<tr align="center">

<td colspan="9" rowspan="1" style="vertical-align: top; text-align: center; font-size: 16px;">
<a href="AddUser.jsp">ADD A USER</a>
</td>

</tr>
	<td style="vertical-align: top;"></td>
	<td style="vertical-align: top;">First</td>
	<td style="vertical-align: top;">Last</td>
	<td style="vertical-align: top;">Username</td>
	<td style="vertical-align: top;">Password</td>
	<td style="vertical-align: top;">Type</td>
	<td style="vertical-align: top;">Status</td>
	<td style="vertical-align: top;"></td>
	<td style="vertical-align: top;"></td>
<%
for(User u: users.values())
{
%>
	<tr>
		<td style="vertical-align: top;">
		<% if (u.getActivationStatus()) { %>
		<form method="post" action="Deactivate_action.jsp" name="Deactivate">
	    <input name="Deactivate" value="Deactivate" type="submit">
		<input name="Username" value=<%=u.getUsername()%> type="hidden">
		</form> 
	    <%
	    } else { %> 
		<form method="post" action="Activate_action.jsp" name="Activate">
	    <input name="Activate" value="Activate" type="submit">
		<input name="Username" value=<%=u.getUsername()%> type="hidden">
		</form>
	    <%
	    } %>		
		</td>
	<td style="vertical-align: top;"><%=u.getFirstName()%>
	</td>
	<td style="vertical-align: top;"><%=u.getLastName() %>
	</td>
	<td style="vertical-align: top;"><%=u.getUsername()%>
	</td>
	<td style="vertical-align: top;"><%=u.getPassword()%>
	</td>
	<td style="vertical-align: top;"><%=u.getType()%>
	</td>
	<td style="vertical-align: top;"><%=u.getActivationStatus()%>
	</td>
	<td style="vertical-align: top;">
	<form method="post" action="EditUser.jsp" name="Edit">
	    <input name="Edit" type="image" src="assets/img/Edit.png" type="submit">
	    <input name="Username" value= <%=u.getUsername()%> type="hidden">
	</form>
	</td>
	<td style="vertical-align: top;">
	<form method="post" action="DeleteUser.jsp" name="Delete">
	    <input name="Delete" type="image" src="assets/img/Delete.png" type="submit">
	    <input name="Username" value=<%=u.getUsername()%> type="hidden">
	</form></td>
	</tr>
	
<%}
%>
		</tbody>
	</table>
	<form method="post" action="AdminMenu.jsp" align="middle">
	    <input name="Return" value="Return to Menu" type="submit"
	    align="right">
	</form>

</body>
</html>