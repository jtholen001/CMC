<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="cmcPackage.entityClasses.University,cmcPackage.interfaces.*,cmcPackage.Controllers.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit University</title>
</head>
<%
	//AdminInterface adminInt = (AdminInterface) session.getAttribute("userInt");
	//University universtiy = //adminInt.getUniversity(request.getParameter("university"));

	DBController db = new DBController();
	University universtiy = db.getUniversity("ADELPHI");
%>
<body>
	<form action="EditProfile_action.jsp" name="EditProfile">
		<table style="text-align: left; width: 50%;" border="1"
			cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top; width: 200px">NAME</td>
					<td style="vertical-align: top"><input readonly="readonly"
						name="Name" value=<%out.println(universtiy.getName());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
				<td style="vertical-align: top; width: 200px">STATE</td>
					<td style="vertical-align: top"><input readonly="readonly"
						name="Name" value=<%out.println(universtiy.getState());%>
						style="width: 258px;"></td>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
				<tr>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>