<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmcPackage.entityClasses.*"%>
<%@include file="verifyLoginStudent.jsp"%>
<%
StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
String universityName = request.getParameter("University");
/*
fromWhere - equals 0 if from ViewMatchedResults.jsp
		  - equals 1 if from ViewSearchedUniversity.jsp
*/
String fromWhere = request.getParameter("FromWhere");
studentInt.saveUniversity(studentInt.viewUniversity(universityName));

/*
Search results need to continually be passed as parameters 
*/
String[] values=request.getParameterValues("Universities");

String universityList = "";
for(int i = 0; i < values.length; i++) {
	universityList += "Universities=" + values[i] + "&";
}
int length = universityList.length();
universityList = universityList.substring(0, length - 1);

if (fromWhere.equals("0")) {
	response.sendRedirect("ViewMatchedResults.jsp?"+ universityList);
}
else {
	/*
	startFrom - equals null if the current university being saved was being viewed
	          - equals !null if the current university being saved is a recommended university of the university being viewed
	*/
	String startFrom = request.getParameter("StartFrom");
	if(startFrom == null)
		response.sendRedirect("ViewSearchedUniversity.jsp?University=" + universityName + "&" + universityList);
	else
		response.sendRedirect("ViewSearchedUniversity.jsp?University=" + startFrom + "&" + universityList);
}
%>