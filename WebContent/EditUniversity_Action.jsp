<%@ page language="java" contentType="text/html; charset=UTF-8" import="cmcPackage.interfaces.*,
cmcPackage.entityClasses.*, java.util.ArrayList"
    pageEncoding="UTF-8" %>
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

int numStudents;
int academicScale;
int socialScale;
int qualityOfLifeScale;
int numApplicants;

double percentFemale;
double SATVerbal;
double SATMath;
double expenses;
double percentFinancialAid;
double percentAdmitted;
double percentEnrolled;


	numStudents = Integer.parseInt(request.getParameter("numStudents"));
	academicScale = Integer.parseInt(request.getParameter("academicScale"));
	socialScale = Integer.parseInt(request.getParameter("socialScale"));
	qualityOfLifeScale = Integer.parseInt(request.getParameter("qualityOfLife"));
	numApplicants = Integer.parseInt(request.getParameter("numberOfApplicants"));
	
	percentFemale = Double.parseDouble(request.getParameter("percentFemale"));
	SATVerbal = Double.parseDouble(request.getParameter("SATVerbal"));
	SATMath = Double.parseDouble(request.getParameter("SATMath"));
	expenses = Double.parseDouble(request.getParameter("expenses"));
	percentFinancialAid = Double.parseDouble(request.getParameter("percentFinancialAid"));
	percentAdmitted = Double.parseDouble(request.getParameter("percentAdmitted"));
	percentEnrolled = Double.parseDouble(request.getParameter("percentEnrolled"));



adminInt.editUniversity(university, request.getParameter("state"), request.getParameter("location"), request.getParameter("control"), 
		numStudents, percentFemale, SATVerbal, 
		SATMath, expenses, percentFinancialAid, 
		numApplicants, percentAdmitted, percentEnrolled, 
		academicScale, socialScale, 
		qualityOfLifeScale, emphases);

response.sendRedirect("AdminMenu.jsp");


%>

</body>
</html>