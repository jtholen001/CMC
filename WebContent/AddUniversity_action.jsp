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

String name = request.getParameter("SchoolName");
String state = request.getParameter("State");
String location = request.getParameter("Location");
String control = request.getParameter("Control");
int numberOfStudents;
numberOfStudents = Integer.parseInt(request.getParameter("numberOfStudents"));
double percentFemale = Double.parseDouble(request.getParameter("percentFemale"));
double SATVerbal = Double.parseDouble(request.getParameter("SATVerbal"));
double SATMath = Double.parseDouble(request.getParameter("SATMath"));
double expenses = Double.parseDouble(request.getParameter("Expenses"));
double percentFinancialAid = Double.parseDouble(request.getParameter("percentFinancialAid"));
int numberOfApplicants = Integer.parseInt(request.getParameter("numberOfApplicants"));
double percentAdmitted = Double.parseDouble(request.getParameter("percentAdmitted"));
double percentEnrolled = Double.parseDouble(request.getParameter("percentEnrolled"));
int academicScale = Integer.parseInt(request.getParameter("academicScale"));
int socialScale = Integer.parseInt(request.getParameter("socialScale"));
int qualityOfLifeScale = Integer.parseInt(request.getParameter("qualityOfLifeScale"));

adminInt.addUniversity(name, state, location, control, numberOfStudents, 
						percentFemale, SATVerbal, SATMath, expenses, 
						percentFinancialAid, numberOfApplicants, percentAdmitted,
						percentEnrolled, academicScale, socialScale,
						qualityOfLifeScale, new ArrayList<String>());


response.sendRedirect("ManageUniversities.jsp");
%>
</body>
</html>