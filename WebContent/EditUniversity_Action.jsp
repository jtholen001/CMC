<%@ page language="java" contentType="text/html; charset=UTF-8" import="cmcPackage.interfaces.*,
cmcPackage.entityClasses.*, java.util.ArrayList"
    pageEncoding="UTF-8" %>
        <%@include file="verifyLoginAdmin.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
University university = adminInt.getUniversity(request.getParameter("name"));
ArrayList<String> emphases = new ArrayList<String>();
Integer i;

for(i = 0; i < university.getEmphases().size(); i++)
{
	if(!request.getParameter("emphasis"+i.toString()).trim().equals(""))
		emphases.add(request.getParameter("emphasis"+i.toString()));
}

if(!request.getParameter("end").trim().equals(""))
	emphases.add(request.getParameter("end"));

String state = request.getParameter("state");
String location = request.getParameter("location");
String control = request.getParameter("control");
String numStudents = request.getParameter("numberOfStudents");
String academicScale = request.getParameter("academicScale");
String socialScale = request.getParameter("socialScale");
String qualityOfLifeScale = request.getParameter("qualityOfLife");
String numApplicants = request.getParameter("numberOfApplicants");
String percentFemale = request.getParameter("percentFemale");
String SATVerbal = request.getParameter("SATVerbal");
String SATMath = request.getParameter("SATMath");
String expenses = request.getParameter("Expenses");
String percentFinancialAid = request.getParameter("percentFinancialAid");
String percentAdmitted = request.getParameter("percentAdmitted");
String percentEnrolled = request.getParameter("percentEnrolled");
	
int result = adminInt.editUniversity(university, state, location, control, 
		numStudents, percentFemale, SATVerbal, 
		SATMath, expenses, percentFinancialAid, 
		numApplicants, percentAdmitted, percentEnrolled, 
		academicScale, socialScale, 
		qualityOfLifeScale, emphases);

if (result == -1)
{
	response.sendRedirect("EditUniversity.jsp?Error=-1&UniversityName="+ university.getName());
	return;
}	

response.sendRedirect("ManageUniversities.jsp?EditSuccess=1&editedName="+ university.getName());
%>
</body>
</html>