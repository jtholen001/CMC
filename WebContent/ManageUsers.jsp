<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "cmcPackage.entityClasses.*, java.util.HashMap" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
	HashMap<String, User> users = adminInt.viewUsers();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Users</title>
</head>
<body>
	<table style="text-align: left; width: 100%;" border="1" cellpadding="2"
cellspacing="2">
		<tbody>
			<tr align="center">

<td colspan="8" rowspan="1" style="vertical-align: top;"><a
href="AddUser.jsp">ADD A USER</a>
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
	<form method="post" action="Deactivate_action.jsp" name="Deactivate">
	    <input name="Deactivate" value="Deactivate" type="submit">
	    <input name="Username" value=<%=u.getUsername()%> type="hidden">
	</form></td>
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
	    <input name="Edit" value="Edit" type="submit">
	    <input name="Username" value= <%=u.getUsername()%> type="hidden">
	</form>
	</td>
	<td style="vertical-align: top;">
	<form method="post" action="DeleteUser.jsp" name="Delete">
	    <input name="Delete" value="Delete" type="submit">
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