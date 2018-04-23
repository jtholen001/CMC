
<%@page language="java" import="cmcPackage.interfaces.*"%>
<%

String username = request.getParameter("Username");
String password = request.getParameter("Password");
UserInterface ui = new UserInterface();

UserInterface userInt = ui.login(username, password);
if (userInt == null){
	response.sendRedirect("index.jsp?Error=-1");
}
else if (userInt instanceof StudentInterface) {
	StudentInterface studentInt = (StudentInterface)userInt;
	if (!studentInt.isActivated())
		response.sendRedirect("index.jsp?Error=-2");
	else {
	session.setAttribute("userInt", userInt);
	response.sendRedirect("StudentMenu.jsp");	
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
