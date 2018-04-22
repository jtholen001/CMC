<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmcPackage.entityClasses.*"%>
<%@include file="verifyLogin.jsp"%>
<%
StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
String universityName = request.getParameter("University");
String fromWhere = request.getParameter("FromWhere");
studentInt.saveUniversity(studentInt.viewUniversity(universityName));

String[] values=request.getParameterValues("Universities");

String universityList = "";
for(int i = 0; i < values.length; i++) {
	universityList += "Universities=" + values[i] + "&";
}
int length = universityList.length();
if (length == 1) {
	universityList = "";
} 
else {
	universityList = universityList.substring(0, length - 1);
}
if (fromWhere.equals("0")) {
	response.sendRedirect("ViewMatchedResults.jsp"+ universityList);
}
else {
	String startFrom = request.getParameter("StartFrom");
	if(startFrom == null)
		response.sendRedirect("ViewSearchedUniversity.jsp?University=" + universityName + "&" + universityList);
	else
		response.sendRedirect("ViewSearchedUniversity.jsp?University=" + startFrom + "&" + universityList);
}
%>