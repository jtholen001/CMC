
<%@page language="java" import="cmcPackage.interfaces.*" import="java.io.*"%>
<%
String username = request.getParameter("Username");
String password = request.getParameter("Password");
UserInterface ui = new UserInterface();

UserInterface userInt = ui.login(username, password);
if (userInt == null){
	response.sendRedirect("index.jsp?Error=-1"); // invalid password
}
else if (userInt instanceof StudentInterface) {
	HttpSession requestSession = request.getSession();
	requestSession.setAttribute("userInt",userInt);
			session.setAttribute("userInt", userInt);
	StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
	if (!studentInt.isActivated())
		response.sendRedirect("index.jsp?Error=-2"); // deactivated
	else if (studentInt.isTfaEnabled())
		response.sendRedirect("TwoFactorAuthentication.jsp"); // 2FA enabled
	else {
	response.sendRedirect("StudentMenu.jsp"); // successful login
	}
}
else {
	AdminInterface adminInt = (AdminInterface)userInt;
	if (!adminInt.isActivated())
		response.sendRedirect("index.jsp?Error=-2");
	else {
	session.setAttribute("userInt", userInt);
	response.sendRedirect("AdminMenu.jsp");
	}
}

%>
