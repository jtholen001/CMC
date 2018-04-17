<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cmcPackage.entityClasses.*, cmcPackage.Controllers.*"%>
<%@include file="verifyLogin.jsp"%>
<%
StudentInterface studentInt = (StudentInterface)session.getAttribute("userInt");
ArrayList<University> foundUniversities = new ArrayList<University>();

String name = request.getParameter("Name");
String state = request.getParameter("State");
String location = request.getParameter("Location");
String control = request.getParameter("Control");
String numStudentsLower = request.getParameter("NumStudentsLower");
String numStudentsUpper = request.getParameter("NumStudentsUpper");
String percentFemaleLower = request.getParameter("PercentFemaleLower");
String percentFemaleUpper = request.getParameter("PercentFemaleUpper");
String SATVerbalLower = request.getParameter("SATVerbalLower");
String SATVerbalUpper = request.getParameter("SATVerbalUpper");
String SATMathLower = request.getParameter("SATMathLower");
String SATMathUpper = request.getParameter("SATMathUpper");
String expensesLower = request.getParameter("ExpensesLower");
String expensesUpper = request.getParameter("ExpensesUpper");
String percentFinancialAidLower = request.getParameter("PercentFinancialAidLower");
String percentFinancialAidUpper = request.getParameter("PercentFinancialAidUpper");
String numApplicantsLower = request.getParameter("NumApplicantsLower");
String numApplicantsUpper = request.getParameter("NumApplicantsUpper");
String percentAdmittedLower = request.getParameter("PercentAdmittedLower");
String percentAdmittedUpper = request.getParameter("PercentAdmittedUpper");
String percentEnrolledLower = request.getParameter("PercentEnrolledLower");
String percentEnrolledUpper = request.getParameter("PercentEnrolledUpper");
String academicScaleLower = request.getParameter("AcademicScaleLower");
String academicScaleUpper = request.getParameter("AcademicScaleUpper");
String socialScaleLower = request.getParameter("SocialScaleLower");
String socialScaleUpper = request.getParameter("SocialScaleUpper");
String qualityOfLifeScaleLower = request.getParameter("QualityOfLifeScaleLower");
String qualityOfLifeScaleUpper = request.getParameter("QualityOfLifeScaleUpper");
String emphases1 = request.getParameter("Emphases1");
String emphases2 = request.getParameter("Emphases2");
String emphases3 = request.getParameter("Emphases3");
String emphases4 = request.getParameter("Emphases4");
String emphases5 = request.getParameter("Emphases5");

ArrayList<String> emphases = new ArrayList<String>();
if (!emphases1.isEmpty())
	emphases.add(emphases1);
if (!emphases2.isEmpty())
	emphases.add(emphases2);
if (!emphases3.isEmpty())
	emphases.add(emphases3);
if (!emphases4.isEmpty())
	emphases.add(emphases4);
if (!emphases5.isEmpty())
	emphases.add(emphases5);
	
try {
    foundUniversities = studentInt.searchUniversities(name, state, location, control, numStudentsLower, numStudentsUpper, percentFemaleLower, 
    	percentFemaleUpper, SATVerbalLower, SATVerbalUpper, SATMathLower, SATMathUpper, expensesLower, expensesUpper, percentFinancialAidLower, 
    	percentFinancialAidUpper, numApplicantsLower, numApplicantsUpper, percentAdmittedLower, percentAdmittedUpper, percentEnrolledLower, 
    	percentEnrolledUpper, academicScaleLower, academicScaleUpper, socialScaleLower, socialScaleUpper, qualityOfLifeScaleLower, qualityOfLifeScaleUpper, emphases);
} 
catch (NumberFormatException nfe) {
  	response.sendRedirect("Search.jsp?Error=-1");
}
catch (IllegalArgumentException iae) {
  	response.sendRedirect("Search.jsp?Error=-2");
}
catch (InputMismatchException ime) {
  	response.sendRedirect("Search.jsp?Error=-3");
}
String universityList = "?";
for(University u : foundUniversities) {
	universityList += "Universities=" + u.getName() + "&";
}
int length = universityList.length();
if (length == 1) {
	universityList = "";
} 
else {
	universityList = universityList.substring(0, length - 1);
}
response.sendRedirect("ViewMatchedResults.jsp"+ universityList);
%>