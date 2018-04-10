package Test.ControllerTests;

import Controllers.*;
import entityClasses.*;
import java.util.*;
import org.junit.*;

public class UniversityControllerTest 
{
	private UniversityController uniCont;
	private University university, university2, university3, university4;
	private DBController dbCont;
	private HashMap<String, University> listAll; 
	
	/**
	 * Method that sets up the tests
	 */
	@Before
	public void init() 
	{
		dbCont = new DBController();
		uniCont = new UniversityController(dbCont);
		university = new University("UNIVERSITY OF CMC", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		//listAll = uniCont.viewUniversities();
		dbCont.addUniversity(university);
	}
	
	@After
	public void destroy()
	{
		uniCont.deleteUniversity(university);
	}
	
	/**
	 * Test method to test viewing universities
	 */
	@Test
	public void testViewUniversities()
	{
		listAll = uniCont.viewUniversities();
		Set<String> names = listAll.keySet();
		boolean contains1 = false;
		boolean contains2 = false;
		boolean contains3 = false;

		for(String name : names)
		{
			
			if (name.equals("ABILENE CHRISTIAN UNIVERSITY"))
				contains1 = true;
			if (name.equals("MICHIGAN STATE"))
				contains2 = true;
			if (name.equals("YANKTOWN COLLEGE"))
				contains3 = true;	
		}
		
		Assert.assertTrue(contains1);
		Assert.assertTrue(contains2);
		Assert.assertTrue(contains3);
	}
	
	/**
	 * Test method to test editing a university
	 */
	@Test
	public void testEditUniversity()
	{
		uniCont.editUniversity(university, "MINNESOTA", "CITY", "PRIVATE", 4, 20.0, 100.0, 100.0, 80.0, 1.0, 6, 60.0, 60.0, 2, 2, 2, new ArrayList<String>());
		University temp = dbCont.getUniversity("UNIVERSITY OF CMC");
		Assert.assertTrue("STATE: MINNESOTA", temp.getState().equals("MINNESOTA"));
		Assert.assertTrue("Location: CITY", temp.getLocation().equals("CITY"));
		Assert.assertTrue("Control: PRIVATE", temp.getControl().equals("PRIVATE"));
		Assert.assertTrue("NumStudents : 4", temp.getNumStudents() == 4);
		Assert.assertTrue("PercentFemale : 20.0", temp.getPercentFemale() == 20.0);
		Assert.assertTrue("SATVerbal : 100.0", temp.getSATVerbal() == 100.0);
		Assert.assertTrue("SATMath : 100.0", temp.getSATMath() == 100.0);
		Assert.assertTrue("Expenses : 1.0", temp.getExpenses() == 80.0);
		Assert.assertTrue("PercentFinancialAid : 80.0", temp.getPercentFinancialAid() == 1.0);
		Assert.assertTrue("NumApplicants : ", temp.getNumApplicants() == 6);
		Assert.assertTrue("PercentAdmitted : 80.0", temp.getPercentAdmitted() == 60.0);
		Assert.assertTrue("PercentEnrolled : 60.0", temp.getPercentEnrolled() == 60.0);
		Assert.assertTrue("AcademicScale : 2", temp.getAcademicScale() == 2);
		Assert.assertTrue("SocialScale : 2", temp.getSocialScale() == 2);
		Assert.assertTrue("QualityOfLifeScale : 2", temp.getQualityOfLifeScale() == 2);	
	}
	
	/**
	 * Test method to test editing a university fails because invalid input
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEditUniversityFails_invalidInput()
	{
		uniCont.editUniversity(university, "", "CITY", "PRIVATE", 4, 20.0, 100.0, 100.0, 80.0, 1.0, 6, 60.0, 60.0, 2, 2, 2, new ArrayList<String>());
	}
	
	/**
	 * Test method to test adding a university
	 */
	@Test
	public void testAddUniversitySuccess()
	{
		university2 = new University("CSCI College", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		int result = uniCont.addUniversity("CSCI College", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, (new ArrayList<String>()));
		Assert.assertTrue(result != -1);
		uniCont.deleteUniversity(university2);
	}
	
	/**
	 * Test method to test adding a university fails because duplicate name
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddUniversityFailsForInvalidInput()
	{
		university3 = new University("AUBURN", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		uniCont.addUniversity("AUBURN", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
	}
	
	/**
	 * Test method to delete a university
	 */
	@Test
	public void testDeleteUniversity()
	{
		uniCont.addUniversity("MY NEW COLLEGE", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		university4 = new University("MY NEW COLLEGE", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		int result = uniCont.deleteUniversity(university4);
		Assert.assertTrue(result != -1);
	}
	
}
