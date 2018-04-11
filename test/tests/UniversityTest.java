/**

 * This class is used to test the University class
 * 
 * @author Michael Carroll, Brandan Kalsow, Nicholas Tawil, Jordan Tholen, Ryan Strelow
 * 
 * @version Mar 25,2018
 */
package tests;
import cmcPackage.entityClasses.University;
import org.junit.*;
import java.util.ArrayList;

public class UniversityTest 
{
	private University testingUniversity;
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
		Assert.assertTrue("Constructor succeeds for university with all fields meeting criteria:", new University("Saint John's University","Minnesota","Collegeville", "Private",
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, emphases) instanceof University);
		Assert.assertTrue("Constructor succeeds for university with all fields meeting criteria:", new University("Saint John's University","Minnesota","Collegeville", "Private",
                10000, 100, 100.0, 100.0, 50000.0, 100, 1000, 100, 100.0, 5, 5, 5, emphases) instanceof University);
		Assert.assertTrue("Constructor succeeds for university with all fields meeting criteria:", new University("Saint John's University","Minnesota","Collegeville", "Private",
                10000, 100, 800.0, 800.0, 50000.0, 100, 1000, 100, 100.0, 5, 5, 5, emphases) instanceof University);
	}
	
	@Test
	public void testGetName()
	{
		Assert.assertTrue(testingUniversity.getName().equals("SAINT JOHN'S UNIVERSITY"));
	}
	
	@Test
	public void testGetState()
	{
		Assert.assertTrue(testingUniversity.getState().equals("MINNESOTA"));
	}
	
	@Test
	public void testGetLocation()
	{
		Assert.assertTrue(testingUniversity.getLocation().equals("RURAL"));
	}
	
	@Test
	public void testGetControl()
	{
		Assert.assertTrue(testingUniversity.getControl().equals("PRIVATE"));
	}
	
	@Test
	public void testGetNumStudents()
	{
		Assert.assertTrue(testingUniversity.getNumStudents() == 10000);
	}
	
	@Test
	public void testGetPercentFemale()
	{
		Assert.assertTrue(testingUniversity.getPercentFemale() == 50.0);
	}
	
	@Test
	public void testGetSATVerbal()
	{
		Assert.assertTrue(testingUniversity.getSATVerbal() == 100.0);
	}
	
	@Test
	public void testGetSATMath()
	{
		Assert.assertTrue(testingUniversity.getSATMath() == 100.0);
	}
	
	@Test
	public void testGetExpenses()
	{
		Assert.assertTrue(testingUniversity.getExpenses() == 50000.0);
	}
	
	@Test
	public void testGetPercentFinancialAid()
	{
		Assert.assertTrue(testingUniversity.getPercentFinancialAid() == 75.0);
	}
	
	@Test
	public void testGetNumApplicants()
	{
		Assert.assertTrue(testingUniversity.getNumApplicants() == 1000);
	}
	
	@Test
	public void testGetPercentAdmitted()
	{
		Assert.assertTrue(testingUniversity.getPercentAdmitted() == 75.0);
	}
	
	@Test
	public void testGetPercentEnrolled()
	{
		Assert.assertTrue(testingUniversity.getPercentEnrolled() == 90.0);
	}
	
	@Test
	public void testGetAcademicScale()
	{
		Assert.assertTrue(testingUniversity.getAcademicScale() == 4);
	}
	
	@Test
	public void testGetSocialScale()
	{
		Assert.assertTrue(testingUniversity.getSocialScale() == 2);
	}
	
	@Test
	public void testGetQualityOfLifeScale()
	{
		Assert.assertTrue(testingUniversity.getQualityOfLifeScale() == 4);
	}
	
	@Test
	public void testGetEmphases()
	{
		Assert.assertTrue(testingUniversity.getEmphases().equals(emphases));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidName()
	{
		Assert.assertTrue("Constructor fails for university with name null:", new University(null,"Minnesota","Collegeville", "Private",
                10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForEmptyName()
	{
		Assert.assertTrue("Constructor fails for university with name null:", new University("","Minnesota","Collegeville", "Private",
                10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidState()
	{
		Assert.assertTrue("Constructor fails for university with state field missing:", new University("Saint John's University", null,"Collegeville", "Private",
            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForEmptyState()
	{
		Assert.assertTrue("Constructor fails for university with state field missing:", new University("Saint John's University", "","Collegeville", "Private",
            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidLocation()
	{
		Assert.assertTrue("Constructor fails for university with location field missing:", new University("Saint John's University","Minnesota",null, "Private",
            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForEmptyLocation()
	{
		Assert.assertTrue("Constructor fails for university with location field missing:", new University("Saint John's University","Minnesota","", "Private",
            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidControl()
	{
		Assert.assertTrue("Constructor fails for university with control field missing:", new University("Saint John's University","Minnesota", "Collegeville" , null,
	            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForEmptyControl()
	{
		Assert.assertTrue("Constructor fails for university with control field missing:", new University("Saint John's University","Minnesota", "Collegeville" , "",
	            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidNumStudentsNegative2()
	{
		Assert.assertTrue("Constructor fails for university with no students:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            -2, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidNumStudentsNegative20()
	{
		Assert.assertTrue("Constructor fails for university with no students:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            -20, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForEmptyEmphases()
	{
		Assert.assertTrue("Constructor fails for university with emphases field missing:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, null) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentFemaleNegative2()
	{
		Assert.assertTrue("Constructor fails for university with percentFemale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, -2, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentFemaleNegative20()
	{
		Assert.assertTrue("Constructor fails for university with percentFemale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, -20, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentFemale101()
	{
		Assert.assertTrue("Constructor fails for university with percentFemale > 100:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 101, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentFemale120()
	{
		Assert.assertTrue("Constructor fails for university with percentFemale > 100:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 120, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentAdmittedNegative2()
	{
		Assert.assertTrue("Constructor fails for university with percentAdmitted < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, -2, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentAdmittedNegative20()
	{
		Assert.assertTrue("Constructor fails for university with percentAdmitted < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, -20, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentAdmitted101()
	{
		Assert.assertTrue("Constructor fails for university with percentAdmitted > 100:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, 101, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentAdmitted120()
	{
		Assert.assertTrue("Constructor fails for university with percentAdmitted > 100:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, 120, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentEnrolledNegative2()
	{
		Assert.assertTrue("Constructor fails for university with percentEnrolled < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, -2, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentEnrolledNegative20()
	{
		Assert.assertTrue("Constructor fails for university with percentEnrolled < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, -20, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentEnrolled101()
	{
		Assert.assertTrue("Constructor fails for university with percentEnrolled > 100:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 101.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForPercentEnrolled120()
	{
		Assert.assertTrue("Constructor fails for university with percentEnrolled > 100:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 120.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATVerbalNegative2()
	{
		Assert.assertTrue("Constructor fails for university with SATVerbal < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, -2, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATVerbalNegative20()
	{
		Assert.assertTrue("Constructor fails for university with SATVerbal < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, -20, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATVerbalGreaterThanEightHundred()
	{
		Assert.assertTrue("Constructor fails for university with SATVerbal > 800:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 800.1, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATVerbalMuchGreaterThanEightHundred()
	{
		Assert.assertTrue("Constructor fails for university with SATVerbal > 800:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 820.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATMathLessThanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with SATMath < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, -2, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATMathNegative20()
	{
		Assert.assertTrue("Constructor fails for university with SATMath < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, -20, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATMathGreaterThanEightHundred()
	{
		Assert.assertTrue("Constructor fails for university with SATMath > 800:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 800.1, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSATMathMuchGreaterThanEightHundred()
	{
		Assert.assertTrue("Constructor fails for university with SATMath > 800:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100.0, 820.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForAcademicScaleLessthanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with academicScale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, -2, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForAcademicScaleMuchLessthanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with academicScale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, -20, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForAcademicScaleZero()
	{
		Assert.assertTrue("Constructor fails for university with academicScale = 0:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 0, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForAcademicScaleGreaterthanFive()
	{
		Assert.assertTrue("Constructor fails for university with academicScale > 5:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 6, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForAcademicScaleMuchGreaterthanFive()
	{
		Assert.assertTrue("Constructor fails for university with academicScale > 5:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 20, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSocialScaleLessthanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with socialScale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, -2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSocialScaleZero()
	{
		Assert.assertTrue("Constructor fails for university with socialScale = 0:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 0, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSocialScaleMuchLessthanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with socialScale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, -20, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSociaScaleGreaterthanFive()
	{
		Assert.assertTrue("Constructor fails for university with socialScale > 5:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 6, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForSociaScaleMuchGreaterthanFive()
	{
		Assert.assertTrue("Constructor fails for university with socialScale > 5:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 20, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForQualityOfLifeScaleLessthanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with qualityOfLifeScale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 5, -2, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForQualityOfLifeScaleMuchLessthanNegOne()
	{
		Assert.assertTrue("Constructor fails for university with qualityOfLifeScale < -1:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 5, -20, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForQualityOfLifeScaleGreaterthanFive()
	{
		Assert.assertTrue("Constructor fails for university with qualityOfLifeScale > 5:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 5, 6, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForQualityOfLifeScaleMuchGreaterthanFive()
	{
		Assert.assertTrue("Constructor fails for university with qualityOfLifeScale > 5:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 5, 20, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForQualityOfLifeScaleZero()
	{
		Assert.assertTrue("Constructor fails for university with qualityOfLifeScale = 0:", new University("Saint John's University","Minnesota", "Collegeville" , "Private",
	            10000, 50, 100, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 5, 0, emphases) instanceof University);
	}
	
	@Test
	public void getNameReturnsCorrectName()
	{
		Assert.assertTrue("Name should be Saint John's University: ", testingUniversity.getName().equals("SAINT JOHN'S UNIVERSITY"));
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
	
	@Test (expected = IllegalArgumentException.class)
	public void setStateFailsForEmptyInput()
	{
		testingUniversity.setState("");
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
	
	@Test (expected = IllegalArgumentException.class)
	public void setLocationFailsForEmptyInput()
	{
		testingUniversity.setLocation("");	
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
	
	@Test (expected = IllegalArgumentException.class)
	public void setControlFailsForEmptyInput()
	{
		testingUniversity.setControl("");	
	}
	
	@Test
	public void setNumStudentsCorrectlyChangesUniversityNumStudents_20()
	{
		testingUniversity.setNumStudents(20);
		Assert.assertTrue("numStudents for University1 is now 20", testingUniversity.getNumStudents() == 20);
	}
	
	@Test
	public void setNumStudentsCorrectlyChangesUniversityNumStudents_neg1()
	{
		testingUniversity.setNumStudents(-1);
		Assert.assertTrue("numStudents for University1 is now -1", testingUniversity.getNumStudents() == -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setNumStudentsFailsForInvalidInput_neg2()
	{
		testingUniversity.setNumStudents(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setNumStudentsFailsForInvalidInput_neg20()
	{
		testingUniversity.setNumStudents(-20);	
	}
	
	@Test
	public void setPercentFemaleCorrectlyChangesUniversityPercentFemale_20()
	{
		testingUniversity.setPercentFemale(20);
		Assert.assertTrue("percentFemale for University1 is now 20%", testingUniversity.getPercentFemale() == 20);
	}
	
	@Test
	public void setPercentFemaleCorrectlyChangesUniversityPercentFemale_neg1()
	{
		testingUniversity.setPercentFemale(-1);
		Assert.assertTrue("percentFemale for University1 is now -1%", testingUniversity.getPercentFemale() == -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFemaleFailsForInvalidInputLessthanNegOne_neg2()
	{
		testingUniversity.setPercentFemale(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFemaleFailsForInvalidInputLessthanNegOne_neg20()
	{
		testingUniversity.setPercentFemale(-20);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFemaleFailsForInvalidInputGreaterthanOneHundred_120()
	{
		testingUniversity.setPercentFemale(120);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFemaleFailsForInvalidInputGreaterthanOneHundred_101()
	{
		testingUniversity.setPercentFemale(101);	
	}
	
	@Test
	public void setSATVerbalCorrectlyChangesUniversitySATVerbal_750()
	{
		testingUniversity.setSATVerbal(750);
		Assert.assertTrue("SATVerbal for University1 is now 750", testingUniversity.getSATVerbal() == 750);
	}
	
	@Test
	public void setSATVerbalCorrectlyChangesUniversitySATVerbal_800()
	{
		testingUniversity.setSATVerbal(800);
		Assert.assertTrue("SATVerbal for University1 is now 800", testingUniversity.getSATVerbal() == 800);
	}
	
	@Test
	public void setSATVerbalCorrectlyChangesUniversitySATVerbal_100()
	{
		testingUniversity.setSATVerbal(100);
		Assert.assertTrue("SATVerbal for University1 is now 100", testingUniversity.getSATVerbal() == 100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATVerbalFailsForInvalidInputLessthanNegOne_neg2()
	{
		testingUniversity.setSATVerbal(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATVerbalFailsForInvalidInputLessthanNegOne_neg20()
	{
		testingUniversity.setSATVerbal(-20);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATVerbalFailsForInvalidInputGreaterthanEightHundred_801()
	{
		testingUniversity.setSATVerbal(801);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATVerbalFailsForInvalidInputGreaterthanEightHundred_820()
	{
		testingUniversity.setSATVerbal(820);	
	}
	
	@Test
	public void setSATMathCorrectlyChangesUniversitySATMath_750()
	{
		testingUniversity.setSATMath(750);
		Assert.assertTrue("SATMath for University1 is now 750", testingUniversity.getSATMath() == 750);
	}
	
	@Test
	public void setSATMathCorrectlyChangesUniversitySATMath_800()
	{
		testingUniversity.setSATMath(800);
		Assert.assertTrue("SATMath for University1 is now 800", testingUniversity.getSATMath() == 800);
	}
	
	@Test
	public void setSATMathCorrectlyChangesUniversitySATMath_100()
	{
		testingUniversity.setSATMath(100);
		Assert.assertTrue("SATMath for University1 is now 100", testingUniversity.getSATMath() == 100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATMathFailsForInvalidInputLessthanNegOne_neg2()
	{
		testingUniversity.setSATMath(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATMathFailsForInvalidInputLessthanNegOne_neg20()
	{
		testingUniversity.setSATMath(-20);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATMathFailsForInvalidInputGreaterthanEightHundred_801()
	{
		testingUniversity.setSATMath(801);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSATMathFailsForInvalidInputGreaterthanEightHundred_820()
	{
		testingUniversity.setSATMath(820);	
	}
	
	@Test
	public void setExpensesCorrectlyChangesUniversityExpenses_20()
	{
		testingUniversity.setExpenses(20);
		Assert.assertTrue("Expenses for University1 is now $20", testingUniversity.getExpenses() == 20);
	}
	
	@Test
	public void setExpensesCorrectlyChangesUniversityExpenses_neg1()
	{
		testingUniversity.setExpenses(-1);
		Assert.assertTrue("Expenses for University1 is now -$1", testingUniversity.getExpenses() == -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setExpensesFailsForInvalidInputLessthanNegOne_neg2()
	{
		testingUniversity.setExpenses(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setExpensesFailsForInvalidInputLessthanNegOne_neg20()
	{
		testingUniversity.setExpenses(-20);	
	}
	
	@Test
	public void setPercentFinancialAidSucceedsForValidParameter_20()
	{
		testingUniversity.setPercentFinancialAid(20);
		Assert.assertTrue("New percentFinancialAid should be 20%: ", testingUniversity.getPercentFinancialAid() == 20);
	}
	
	@Test
	public void setPercentFinancialAidSucceedsForValidParameter_neg1()
	{
		testingUniversity.setPercentFinancialAid(-1);
		Assert.assertTrue("New percentFinancialAid should be -1%: ", testingUniversity.getPercentFinancialAid() == -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFinancialAidFailsForPercentLessThanNeg1_neg2()
	{
		testingUniversity.setPercentFinancialAid(-2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFinancialAidFailsForPercentLessThanNeg1_neg20()
	{
		testingUniversity.setPercentFinancialAid(-20);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFinancialAidFailsForPercentGreaterThanOneHundred_101()
	{
		testingUniversity.setPercentFinancialAid(101);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentFinancialAidFailsForPercentGreaterThanOneHundred_120()
	{
		testingUniversity.setPercentFinancialAid(120);
	}
	
	@Test
	public void setNumApplicantsCorrectlyChangesUniversityNumApplicants()
	{
		testingUniversity.setNumApplicants(20);
		Assert.assertTrue("NumApplicants for University1 is now 20", testingUniversity.getNumApplicants() == 20);
	}
	
	@Test
	public void setNumApplicantsCorrectlyChangesUniversityNumApplicants_neg1()
	{
		testingUniversity.setNumApplicants(-1);
		Assert.assertTrue("NumApplicants for University1 is now -1", testingUniversity.getNumApplicants() == -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setNumApplicantsFailsForInvalidInputLessthanNegOne_neg2()
	{
		testingUniversity.setNumApplicants(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setNumApplicantsFailsForInvalidInputLessthanNegOne_neg20()
	{
		testingUniversity.setNumApplicants(-20);	
	}
	
	@Test
	public void setPercentAdmittedCorrectlyChangesUniversityPercentAdmitted_20()
	{
		testingUniversity.setPercentAdmitted(20);
		Assert.assertTrue("PercentAdmitted for University1 is now 20", testingUniversity.getPercentAdmitted() == 20);
	}
	
	@Test
	public void setPercentAdmittedCorrectlyChangesUniversityPercentAdmitted_neg1()
	{
		testingUniversity.setPercentAdmitted(-1);
		Assert.assertTrue("PercentAdmitted for University1 is now -1", testingUniversity.getPercentAdmitted() == -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentAdmittedFailsForInvalidInputLessthanNegOne_neg2()
	{
		testingUniversity.setPercentAdmitted(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentAdmittedFailsForInvalidInputLessthanNegOne_neg20()
	{
		testingUniversity.setPercentAdmitted(-20);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentAdmittedFailsForInvalidInputGreaterthanOneHundred_101()
	{
		testingUniversity.setPercentAdmitted(101);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentAdmittedFailsForInvalidInputGreaterthanOneHundred_120()
	{
		testingUniversity.setPercentAdmitted(120);	
	}
	
	@Test
	public void setPercentEnrolledCorrectlyChangesUniversityPercentEnrolled_20()
	{
		testingUniversity.setPercentEnrolled(20);
		Assert.assertTrue("PercentEnrolled for University1 is now 20", testingUniversity.getPercentEnrolled() == 20);
	}
	
	@Test
	public void setPercentEnrolledCorrectlyChangesUniversityPercentEnrolled_neg1()
	{
		testingUniversity.setPercentEnrolled(-1);
		Assert.assertTrue("PercentEnrolled for University1 is now -1", testingUniversity.getPercentEnrolled() == -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentEnrolledFailsForInvalidInputLessthanNegOne_neg2()
	{
		testingUniversity.setPercentEnrolled(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentEnrolledFailsForInvalidInputLessthanNegOne_neg20()
	{
		testingUniversity.setPercentEnrolled(-20);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentEnrolledFailsForInvalidInputGreaterthanOneHundred_101()
	{
		testingUniversity.setPercentEnrolled(101);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setPercentEnrolledFailsForInvalidInputGreaterthanOneHundred_120()
	{
		testingUniversity.setPercentEnrolled(120);	
	}
	
	@Test
	public void setAcademicScaleCorrectlyChangesUniversityAcademicScale_4()
	{
		testingUniversity.setAcademicScale(4);
		Assert.assertTrue("AcademicScale for University1 is now 4", testingUniversity.getAcademicScale() == 4);
	}
	
	@Test
	public void setAcademicScaleCorrectlyChangesUniversityAcademicScale_5()
	{
		testingUniversity.setAcademicScale(5);
		Assert.assertTrue("AcademicScale for University1 is now 5", testingUniversity.getAcademicScale() == 5);
	}
	
	@Test
	public void setAcademicScaleCorrectlyChangesUniversityAcademicScale_1()
	{
		testingUniversity.setAcademicScale(1);
		Assert.assertTrue("AcademicScale for University1 is now 1", testingUniversity.getAcademicScale() == 1);
	}
	
	@Test
	public void setAcademicScaleCorrectlyChangesUniversityAcademicScale_neg1()
	{
		testingUniversity.setAcademicScale(-1);
		Assert.assertTrue("AcademicScale for University1 is now -1", testingUniversity.getAcademicScale() == -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setAcademicScaleFailsForInvalidInputLessthanNegOne_neg2()
	{
		testingUniversity.setAcademicScale(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setAcademicScaleFailsForInvalidInputLessthanNegOne_neg20()
	{
		testingUniversity.setAcademicScale(-20);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setAcademicScaleFailsForInvalidInput_0()
	{
		testingUniversity.setAcademicScale(0);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setAcademicScaleFailsForInvalidInputGreaterthanFive_6()
	{
		testingUniversity.setAcademicScale(6);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setAcademicScaleFailsForInvalidInputGreaterthanFive_20()
	{
		testingUniversity.setAcademicScale(20);	
	}
	
	@Test
	public void setSocialCorrectlyChangesUniversitySocialScale_4()
	{
		testingUniversity.setSocialScale(4);
		Assert.assertTrue("SocialScale for University1 is now 4", testingUniversity.getSocialScale() == 4);
	}
	
	@Test
	public void setSocialCorrectlyChangesUniversitySocialScale_5()
	{
		testingUniversity.setSocialScale(5);
		Assert.assertTrue("SocialScale for University1 is now 5", testingUniversity.getSocialScale() == 5);
	}
	
	@Test
	public void setSocialCorrectlyChangesUniversitySocialScale_1()
	{
		testingUniversity.setSocialScale(1);
		Assert.assertTrue("SocialScale for University1 is now 1", testingUniversity.getSocialScale() == 1);
	}
	
	@Test
	public void setSocialCorrectlyChangesUniversitySocialScale_neg1()
	{
		testingUniversity.setSocialScale(-1);
		Assert.assertTrue("SocialScale for University1 is now -1", testingUniversity.getSocialScale() == -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSocialScaleFailsForInvalidInputLessthanNegOne_neg2()
	{
		testingUniversity.setSocialScale(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSocialScaleFailsForInvalidInputLessthanNegOne_neg20()
	{
		testingUniversity.setSocialScale(-20);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSocialScaleFailsForInvalidInput_0()
	{
		testingUniversity.setSocialScale(0);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSocialScaleFailsForInvalidInputGreaterthanFive_6()
	{
		testingUniversity.setSocialScale(6);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setSocialScaleFailsForInvalidInputGreaterthanFive_20()
	{
		testingUniversity.setSocialScale(20);	
	}
	
	@Test
	public void setQualityOfLifeScaleCorrectlyChangesUniversityQualityOfLifeScale_4()
	{
		testingUniversity.setQualityOfLifeScale(4);
		Assert.assertTrue("qualityOfLifeScale for University1 is now 4", testingUniversity.getQualityOfLifeScale() == 4);
	}
	
	@Test
	public void setQualityOfLifeScaleCorrectlyChangesUniversityQualityOfLifeScale_5()
	{
		testingUniversity.setQualityOfLifeScale(5);
		Assert.assertTrue("qualityOfLifeScale for University1 is now 5", testingUniversity.getQualityOfLifeScale() == 5);
	}
	
	@Test
	public void setQualityOfLifeScaleCorrectlyChangesUniversityQualityOfLifeScale_1()
	{
		testingUniversity.setQualityOfLifeScale(1);
		Assert.assertTrue("qualityOfLifeScale for University1 is now 1", testingUniversity.getQualityOfLifeScale() == 1);
	}
	
	@Test
	public void setQualityOfLifeScaleCorrectlyChangesUniversityQualityOfLifeScale_neg1()
	{
		testingUniversity.setQualityOfLifeScale(-1);
		Assert.assertTrue("qualityOfLifeScale for University1 is now -1", testingUniversity.getQualityOfLifeScale() == -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setQualityOfLIfeScaleFailsForInvalidInput_0()
	{
		testingUniversity.setQualityOfLifeScale(0);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setQualityOfLIfeScaleFailsForInvalidInputLessthanNegOne_neg2()
	{
		testingUniversity.setQualityOfLifeScale(-2);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setQualityOfLIfeScaleFailsForInvalidInputLessthanNegOne_neg20()
	{
		testingUniversity.setQualityOfLifeScale(-20);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setQualityOfLifeScaleFailsForInvalidInputGreaterthanFive_6()
	{
		testingUniversity.setQualityOfLifeScale(6);	
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void setQualityOfLifeScaleFailsForInvalidInputGreaterthanFive_20()
	{
		testingUniversity.setQualityOfLifeScale(20);	
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
	
	@Test
	public void toStringReturnsCorrectString()
	{
		Assert.assertTrue("toString returns correctly: ", testingUniversity.toString().equals("name: SAINT JOHN'S UNIVERSITY\nstate: MINNESOTA\nlocation: RURAL\ncontrol: PRIVATE\nnumStudents: 10000\npercentFemale: 50.0\nSATVerbal: 100.0\nSATMath: 100.0\nexpenses: 50000.0\npercentFinancialAid: 75.0\nnumApplicants: 1000\npercentAdmitted: 75.0\npercentEnrolled: 90.0\nacademicScale: 4\nsocialScale: 2\nqualityOfLifeScale: 4\nemphases: [Accounting, Computer Science, Nursing]"));
	}
	
	
}
