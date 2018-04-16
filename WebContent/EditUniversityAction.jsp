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

for(int i = 1; i <= 4; i++)
{
	if(request.getParameter("emphases" + i) != null)
		emphases.add(request.getParameter("emphases" + i));
}

int numStudents;
int academicScale;
int socialScale;
int QualityOfLifeScale;
double percentFemale;
double SATVerbal;
double SATMath;
double expenses;
double percentFinancialAid;
double percentAdmitted;
double percentEnrolled;

try{
	numStudents = Integer.parseInt(request.getParameter("numStudents"));
	academicScale = Integer.parseInt(request.getParameter("academicScale"));
	socialScale = Integer.parseInt(request.getParameter("socialScale"));
	qualityOfLifeScale = Integer.parseInt(request.getParameter("qualityOfLifeScale"));
}

adminInt.editUniversity(university, request.getParameter("state"), request.getParameter("location"), request.getParameter("control"), 
		numStudents, request.getParameter("percentFemale"), request.getParameter("SATVerbal"), 
		request.getParameter("SATMath"), request.getParameter("expenses"), request.getParameter("percentFinancialAid"), 
		request.getParameter("numApplicants"), request.getParameter("percentAdmitted"), request.getParameter("percentEnrolled"), 
		request.getParameter("academicScale"), request.getParameter("socialScale"), 
		request.getParameter("qualityOfLifeScale"), emphases);


%>

</body>
</html>