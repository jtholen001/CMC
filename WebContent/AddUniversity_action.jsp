<%@ page language="java" contentType="text/html; charset=UTF-8"
    import= "java.util.*, cmcPackage.interfaces.*" pageEncoding="UTF-8"%>
    <%@include file="verifyLogin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add University Action</title>
</head>
<body>
<%
AdminInterface adminInt = (AdminInterface)session.getAttribute("userInt");
ArrayList<String> emphases = new ArrayList<String>();
if(!request.getParameter("emphases1".toString()).trim().equals(""))
	emphases.add(request.getParameter("emphases1"));
if(!request.getParameter("emphases2".toString()).trim().equals(""))
	emphases.add(request.getParameter("emphases2"));
if(!request.getParameter("emphases3".toString()).trim().equals(""))
	emphases.add(request.getParameter("emphases3"));

/* 
which page to direct the admin to.
0: no errors, back to ManageUniversities.jsp
1: error1, Database duplicate name, back to AddUniversities.jsp
2: error2. not all field were filled out. back to AddUniversities.jsp
*/
int next = 0;
try{
String name = request.getParameter("SchoolName");
String state = request.getParameter("State");
String location = request.getParameter("Location");
String control = request.getParameter("Control");
String numberOfStudents = request.getParameter("numberOfStudents");
String percentFemale = request.getParameter("percentFemale");
String SATVerbal = request.getParameter("SATVerbal");
String SATMath = request.getParameter("SATMath");
String expenses = request.getParameter("Expenses");
String percentFinancialAid = request.getParameter("percentFinancialAid");
String numberOfApplicants = request.getParameter("numberOfApplicants");
String percentAdmitted = request.getParameter("percentAdmitted");
String percentEnrolled = request.getParameter("percentEnrolled");
String academicScale = request.getParameter("academicScale");
String socialScale = request.getParameter("socialScale");
String qualityOfLifeScale = request.getParameter("qualityOfLifeScale");

int result = adminInt.addUniversity((String)name, state, location, control, numberOfStudents, 
									percentFemale, SATVerbal, SATMath, expenses, 
									percentFinancialAid, numberOfApplicants, percentAdmitted,
									percentEnrolled, academicScale, socialScale,
									qualityOfLifeScale, emphases);
if (result==-1){
	next = 1;
	}
}
catch(NumberFormatException nfe){
	next = 2;
}

if (next == 0)
	response.sendRedirect("ManageUniversities.jsp");
else if(next == 1)
	response.sendRedirect("AddUniversity.jsp?Error=-1");
else if(next == 2)
	response.sendRedirect("AddUniversity.jsp?Error=-2");
%>
</body>
</html>