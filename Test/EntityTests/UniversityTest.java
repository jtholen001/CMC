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
	private University University1, University2;
	ArrayList<String> emphases;
	
	@Before
	public void init()
	{
		 emphases = new ArrayList<String>();
		 emphases.add("Computer Science");
		 emphases.add("Accounting");
		 emphases.add("Nursing");
		 University1 = new University("Saint John's University","Minnesota","Rural", "Private",
				                      10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases);
		 
		 emphases = new ArrayList<String>();
		 emphases.add("Chemistry");
		 emphases.add("Music");
		 emphases.add("Computer Science");
		 University2 = new University("University of CMC","Hawaii","Urban", "Public", 20000, 75.0, 100.0, 100.0, 
				                      30000.0, 25.0, 7500, 50.0, 25.0, 2, 5, 3, emphases);
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
		University1.setSchoolName("College of Saint Benedict");
		Assert.assertTrue("Name for University1 is now College of Saint Benedict", University1.getName().equals("COLLEGE OF SAINT BENEDICT"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setNameFailsForInvalidInput()
	{
		University1.setSchoolName(null);
		
	}
	
	@Test
	public void setStateCorrectlyChangesUniversityState()
	{
		University1.setState("Wisconsin");
		Assert.assertTrue("State for University1 is now Wisconsin", University1.getState().equals("WISCONSIN"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setStateFailsForInvalidInput()
	{
		University1.setState(null);
	}
	
	@Test
	public void setLocationCorrectlyChangesUniversityLocation()
	{
		University1.setLocation("Urban");
		Assert.assertTrue("Location for University1 is now Urban", University1.getLocation().equals("URBAN"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setLocationFailsForInvalidInput()
	{
		University1.setLocation(null);	
	}
	
	@Test
	public void setControlCorrectlyChangesUniversityControl()
	{
		University1.setControl("Public");
		Assert.assertTrue("Control for University1 is now public", University1.getControl().equals("PUBLIC"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setControlFailsForInvalidInput()
	{
		University1.setControl(null);	
	}
	
	@Test
	public void setNumStudentsCorrectlyChangesUniversityNumStudents()
	{
		University1.setNumStudents(50);
		Assert.assertTrue("numStudents for University1 is now 50", University1.getNumStudents() == 50);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setNumStudentsFailsForInvalidInput()
	{
		University1.setNumStudents(-1);	
	}
	
	@Test
	public void setPercentFemaleCorrectlyChangesUniversityPercentFemale()
	{
		University1.setPercentFemale(10);
		Assert.assertTrue("percentFemale for University1 is now 10%", University1.getPercentFemale() == 10);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFemaleFailsForInvalidInputLessthanNegOne()
	{
		University1.setPercentFemale(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFemaleFailsForInvalidInputGreaterthanOneHundred()
	{
		University1.setPercentFemale(110);	
	}
	
	@Test
	public void setSATVerbalCorrectlyChangesUniversitySATVerbal()
	{
		University1.setSATVerbal(750);
		Assert.assertTrue("SATVerbal for University1 is now 750", University1.getSATVerbal() == 750);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATVerbalFailsForInvalidInputLessthanNegOne()
	{
		University1.setSATVerbal(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATVerbalFailsForInvalidInputGreaterthanEightHundred()
	{
		University1.setSATVerbal(801);	
	}
	
	@Test
	public void setSATMathCorrectlyChangesUniversitySATMath()
	{
		University1.setSATMath(200);
		Assert.assertTrue("SATMath for University1 is now 200", University1.getSATMath() == 200);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATMathFailsForInvalidInputLessthanNegOne()
	{
		University1.setSATMath(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATMathFailsForInvalidInputGreaterthanOneHundred()
	{
		University1.setSATMath(801);	
	}
	
	
}
