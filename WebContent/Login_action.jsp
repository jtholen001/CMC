
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
	if (!userInt.isActivated())
		response.sendRedirect("index.jsp?Error=-2");
	else {
	session.setAttribute("userInt", userInt);
	response.sendRedirect("StudentMenu.jsp");	
	}
}
else {
	if (!userInt.isActivated())
		response.sendRedirect("index.jsp?Error=-2");
	else {
	session.setAttribute("userInt", userInt);
	response.sendRedirect("AdminMenu.jsp");
	}
}

%>
