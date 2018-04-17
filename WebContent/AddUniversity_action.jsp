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
adminInt.addUniversity(request.getParameter("SchoolName"), request.getParameter("State"), 
		request.getParameter("Location"), request.getParameter("Control"), parseInt(request.getParameter("numberOfStudents")), 
		parseDouble(request.getParameter("percentFemale")), parseDouble(request.getParameter("SATVerbal")), parseInt(request.getParameter("SATMath")),
		parseDouble(request.getParameter("Expenses")), parseDouble(request.getParameter("percentFinancialAid")), parseInt(request.getParameter("numberOfApplicants")), 
		parseDouble(request.getParameter("percentAdmitted")), parseDouble(request.getParameter("percentEnrolled")), parseInt(request.getParameter("academicScale")),
		parseInt(request.getParameter("socialScale")), parseInt(request.getParameter("qualityOfLifeScale")), request.getParameter("emphases"));
response.sendRedirect("ManageUniversities.jsp");
%>
</body>
</html>