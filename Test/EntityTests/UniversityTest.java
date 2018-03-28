/**

 * This class is used to test the University class
 * 
 * @author Michael Carroll, Brandan Kalsow, Nicholas Tawil, Jordan Tholen, Ryan Strelow
 * 
 * @version Mar 25,2018
 */
package Test.EntityTests;
import entityClasses.University;
import org.junit.*;
import java.util.ArrayList;

public class UniversityTest 
{
	private University testingUniversity, University2;
	ArrayList<String> emphases;
	
	@Before
	public void init()
	{
		 emphases = new ArrayList<String>();
		 emphases.add("Computer Science");
		 emphases.add("Accounting");
		 emphases.add("Nursing");
		 testingUniversity = new University("Saint John's University","Minnesota","Rural", "Private",
				                      10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases);
	}
	
	@Test
	public void constructorSucceedsForValidInput()
	{
		Assert.assertTrue("Constructor succeeds for university with all fields meeting criteria:", new University("Saint John's University","Minnesota","Collegeville", "Private",
                10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidName()
	{
		Assert.assertTrue("Constructor fails for university with name null:", new University(null,"Minnesota","Collegeville", "Private",
                10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidState()
	{
		Assert.assertTrue("Constructor fails for university with state field missing:", new University("Saint John's University", null,"Collegeville", "Private",
            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidLocation()
	{
		Assert.assertTrue("Constructor fails for university with location field missing:", new University("Saint John's University","Minnesota",null, "Private",
            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidControl()
	{
		Assert.assertTrue("Constructor fails for university with control field missing:", new University("Saint John's University","Minnesota", "Collegeville" , null,
	            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForEmptyEmphases()
	{
		Assert.assertTrue("Constructor fails for university with emphases field missing:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, null) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentFemaleLessThanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with percentFemale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, -10, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentFemaleGreaterThanOneHundred()
	{
		Assert.assertTrue("Constructor fails for university with percentFemale > 100:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 190, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentAdmittedLessThanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with percentAdmitted < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, -5, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentAdmittedGreaterThanOneHundred()
	{
		Assert.assertTrue("Constructor fails for university with percentAdmitted > 100:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, 175, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentEnrolledLessThanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with percentEnrolled < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, -6, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentEnrolledGreaterThanOneHundred()
	{
		Assert.assertTrue("Constructor fails for university with percentEnrolled > 100:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 190.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATVerbalLessThanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with SATVerbal < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, -2, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATVerbalGreaterThanEightHundred()
	{
		Assert.assertTrue("Constructor fails for university with SATVerbal > 800:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 800.1, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATMathLessThanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with SATMath < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, -2, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATMathGreaterThanEightHundred()
	{
		Assert.assertTrue("Constructor fails for university with SATMath > 800:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 800.1, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForAcademicScaleLessthanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with academicScale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, -2, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForAcademicScaleGreaterthanFive()
	{
		Assert.assertTrue("Constructor fails for university with academicScale > 5:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 6, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSocialScaleLessthanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with socialScale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, -2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSociaScaleGreaterthanFive()
	{
		Assert.assertTrue("Constructor fails for university with socialScale > 5:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 6, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForQualityOfLifeScaleLessthanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with qualityOfLifeScale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 6, -4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSociaScaleLessGreaterthanFive()
	{
		Assert.assertTrue("Constructor fails for university with percentFemale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 6, 7, emphases) instanceof University);
	}
	
	@Test
	public void setNameCorrectlyChangesUniversityName()
	{
		testingUniversity.setSchoolName("College of Saint Benedict");
		Assert.assertTrue("Name for University1 is now College of Saint Benedict", testingUniversity.getName().equals("COLLEGE OF SAINT BENEDICT"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setNameFailsForInvalidInput()
	{
		testingUniversity.setSchoolName(null);
		
	}
	
	@Test
	public void setStateCorrectlyChangesUniversityState()
	{
		testingUniversity.setState("Wisconsin");
		Assert.assertTrue("State for University1 is now Wisconsin", testingUniversity.getState().equals("WISCONSIN"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setStateFailsForInvalidInput()
	{
		testingUniversity.setState(null);
	}
	
	@Test
	public void setLocationCorrectlyChangesUniversityLocation()
	{
		testingUniversity.setLocation("Urban");
		Assert.assertTrue("Location for University1 is now Urban", testingUniversity.getLocation().equals("URBAN"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setLocationFailsForInvalidInput()
	{
		testingUniversity.setLocation(null);	
	}
	
	@Test
	public void setControlCorrectlyChangesUniversityControl()
	{
		testingUniversity.setControl("Public");
		Assert.assertTrue("Control for University1 is now public", testingUniversity.getControl().equals("PUBLIC"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setControlFailsForInvalidInput()
	{
		testingUniversity.setControl(null);	
	}
	
	@Test
	public void setNumStudentsCorrectlyChangesUniversityNumStudents()
	{
		testingUniversity.setNumStudents(50);
		Assert.assertTrue("numStudents for University1 is now 50", testingUniversity.getNumStudents() == 50);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setNumStudentsFailsForInvalidInput()
	{
		testingUniversity.setNumStudents(-1);	
	}
	
	@Test
	public void setPercentFemaleCorrectlyChangesUniversityPercentFemale()
	{
		testingUniversity.setPercentFemale(10);
		Assert.assertTrue("percentFemale for University1 is now 10%", testingUniversity.getPercentFemale() == 10);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFemaleFailsForInvalidInputLessthanNegOne()
	{
		testingUniversity.setPercentFemale(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFemaleFailsForInvalidInputGreaterthanOneHundred()
	{
		testingUniversity.setPercentFemale(110);	
	}
	
	@Test
	public void setSATVerbalCorrectlyChangesUniversitySATVerbal()
	{
		testingUniversity.setSATVerbal(750);
		Assert.assertTrue("SATVerbal for University1 is now 750", testingUniversity.getSATVerbal() == 750);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATVerbalFailsForInvalidInputLessthanNegOne()
	{
		testingUniversity.setSATVerbal(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATVerbalFailsForInvalidInputGreaterthanEightHundred()
	{
		testingUniversity.setSATVerbal(801);	
	}
	
	@Test
	public void setSATMathCorrectlyChangesUniversitySATMath()
	{
		testingUniversity.setSATMath(200);
		Assert.assertTrue("SATMath for University1 is now 200", testingUniversity.getSATMath() == 200);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATMathFailsForInvalidInputLessthanNegOne()
	{
		testingUniversity.setSATMath(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATMathFailsForInvalidInputGreaterthanEightHundred()
	{
		testingUniversity.setSATMath(801);	
	}
	
	@Test
	public void setExpensesCorrectlyChangesUniversityExpenses()
	{
		testingUniversity.setExpenses(10);
		Assert.assertTrue("Expenses for University1 is now $10", testingUniversity.getExpenses() == 10);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setExpensesFailsForInvalidInputLessthanNegOne()
	{
		testingUniversity.setExpenses(-2);	
	}
	
	@Test
	public void setNumApplicantsCorrectlyChangesUniversityNumApplicants()
	{
		testingUniversity.setNumApplicants(10);
		Assert.assertTrue("NumApplicants for University1 is now 10", testingUniversity.getNumApplicants() == 10);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setNumApplicantsFailsForInvalidInputLessthanNegOne()
	{
		testingUniversity.setNumApplicants(-2);	
	}
	
	@Test
	public void setPercentAdmittedCorrectlyChangesUniversityPercentAdmitted()
	{
		testingUniversity.setPercentAdmitted(88);
		Assert.assertTrue("PercentAdmitted for University1 is now 88", testingUniversity.getPercentAdmitted() == 88);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentAdmittedFailsForInvalidInputLessthanNegOne()
	{
		testingUniversity.setPercentAdmitted(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentAdmittedFailsForInvalidInputGreaterthanOneHundred()
	{
		testingUniversity.setPercentAdmitted(101);	
	}
	
	@Test
	public void setPercentEnrolledCorrectlyChangesUniversityPercentEnrolled()
	{
		testingUniversity.setPercentEnrolled(40);
		Assert.assertTrue("PercentEnrolled for University1 is now 40", testingUniversity.getPercentEnrolled() == 40);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentEnrolledFailsForInvalidInputLessthanNegOne()
	{
		testingUniversity.setPercentEnrolled(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentEnrolledFailsForInvalidInputGreaterthanOneHundred()
	{
		testingUniversity.setPercentEnrolled(101);	
	}
	
	@Test
	public void setAcademicScaleCorrectlyChangesUniversityAcademicScale()
	{
		testingUniversity.setAcademicScale(4);
		Assert.assertTrue("AcademicScale for University1 is now 4", testingUniversity.getQualityOfLifeScale() == 4);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setAcademicScaleFailsForInvalidInputLessthanNegOne()
	{
		testingUniversity.setAcademicScale(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setAcademicScaleFailsForInvalidInputGreaterthanFive()
	{
		testingUniversity.setAcademicScale(6);	
	}
	
	@Test
	public void setSocialCorrectlyChangesUniversitySocialScale()
	{
		testingUniversity.setSocialScale(3);
		Assert.assertTrue("SocialScale for University1 is now 3", testingUniversity.getSocialScale() == 3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSocialScaleFailsForInvalidInputLessthanNegOne()
	{
		testingUniversity.setSocialScale(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSocialScaleFailsForInvalidInputGreaterthanFive()
	{
		testingUniversity.setSocialScale(6);	
	}
	
	@Test
	public void setQualityOfLifeScaleCorrectlyChangesUniversityQualityOfLifeScale()
	{
		testingUniversity.setQualityOfLifeScale(3);
		Assert.assertTrue("qualityOfLifeScale for University1 is now 3", testingUniversity.getQualityOfLifeScale() == 3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setQualityOfLIfeScaleFailsForInvalidInputLessthanNegOne()
	{
		testingUniversity.setQualityOfLifeScale(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setQualityOfLifeScaleFailsForInvalidInputGreaterthanFive()
	{
		testingUniversity.setQualityOfLifeScale(6);	
	}
	
	@Test
	public void setEmphasesCorrectlyChangesUniversityEmphases()
	{
		ArrayList<String> newEmphases = new ArrayList<String>();
		newEmphases.add("Music");
		newEmphases.add("Computer Science");
		testingUniversity.setEmphases(newEmphases);
		Assert.assertTrue("Emphases for University1 are now Music and Computer Science", testingUniversity.getEmphases() == newEmphases);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setEmphasesFailsForInvalidInput()
	{	
		testingUniversity.setEmphases(null);	
	}
	
	
}
