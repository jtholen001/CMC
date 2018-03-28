package Test.ControllerTests;
import Controllers.*;

import entityClasses.*;
import java.util.*;
import org.junit.*;

/**
 * A JUnit test case class for the SearchController Class
 * 
 */

public class SearchControllerTest {

	private SearchController sc;
	
	private DBController dbc;

	private ArrayList<University> universities1, universities2;

	private University u1, u2;

	private Student student;

	@Before
	public void init() {
		sc = new SearchController();
		dbc = new DBController();
		ArrayList<String> emphases = new ArrayList<String>();
		emphases.add("MATH");
		universities1 = new ArrayList<University>();
		universities2 = new ArrayList<University>();
		u1 = new University("TestUniversity1", "Minnesota", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, emphases );
		u2 = new University("TestUniversity2", "IOWA", "SUBURBAN", "PRIVATE", 5000, 65.0, 800, 800, 15000, 50, 25000, 50, 40, 2, 1, 4, emphases );
		universities1.add(u1);
		universities1.add(u2);
		student = new Student("Test", "Student", "user", "password", 'a', true, true, new ArrayList<University>());
		dbc.addUser(student);
	}

	@Test
	public void testcompareStatsNormalRangeCase() {
		Assert.assertTrue("comparing 5 to the range 5 to 5 should return 1", sc.compareStats(5, 5, 5) == 1);
		Assert.assertTrue("comparing 5 to the range 5 to 6 should return 1", sc.compareStats(5, 5, 6) == 1);
		Assert.assertTrue("comparing 5 to the range 4 to 5 should return 1", sc.compareStats(5, 4, 5) == 1);
		Assert.assertTrue("comparing 5 to the range 4 to 6 should return 1", sc.compareStats(5, 4, 6) == 1);		
	}

	@Test
	public void testcompareStatsLowerInputEqualsZeroCase() {
		Assert.assertTrue("comparing 1 to the range 0 to 1 should return 1", sc.compareStats(1, 0, 1) == 1);
		Assert.assertTrue("comparing 1 to the range 0 to 2 should return 1", sc.compareStats(1, 0, 2) == 1);		
	}

	@Test
	public void testcompareStatsUpperInputEqualsZeroCase() {
		Assert.assertTrue("comparing 1 to the range 1 to 0 should return 1", sc.compareStats(1, 1, 0) == 1);
		Assert.assertTrue("comparing 2 to the range 1 to 0 should return 1", sc.compareStats(2, 1, 0) == 1);		
	}

	@Test
	public void testcompareStatsLowerAndUperInputsEqualZeroCase() {
		Assert.assertTrue("comparing 1 to the range 0 to 0 should return 1", sc.compareStats(1, 0, 0) == 1);		
	}

	@Test
	public void testcompareStatsNoMatchCase() {
		Assert.assertTrue("comparing 2 to the range 3 to 5 should return 0", sc.compareStats(2, 3, 5) == 0);
		Assert.assertTrue("comparing 2 to the range 0 to 1 should return 0", sc.compareStats(2, 0, 1) == 0);
		Assert.assertTrue("comparing 2 to the range 3 to 0 should return 0", sc.compareStats(2, 3, 0) == 0);

	}

	@Test
	public void testViewUniversity() {
		Assert.assertTrue("returned string should match expected result for viewing a university", sc.viewUniversity(u1).equals("name: " + u1.getName() + "\n" +
				"state: " + u1.getState() + "\n" +
				"location: " + u1.getLocation() + "\n" +
				"control: " + u1.getControl() + "\n" +
				"numStudents: " + u1.getNumStudents() + "\n" +
				"percentFemale: " + u1.getPercentFemale() + "\n" +
				"SATVerbal: " + u1.getSATVerbal() + "\n" +
				"SATMath: " + u1.getSATMath() + "\n" +
				"expenses: " + u1.getExpenses() + "\n" +
				"percentFinancialAid: " + u1.getPercentFinancialAid() + "\n" +
				"numApplicants: " + u1.getNumApplicants() + "\n" +
				"percentAdmitted: " + u1.getPercentAdmitted() + "\n" +
				"percentEnrolled: " + u1.getPercentEnrolled() + "\n" +
				"academicScale: " + u1.getAcademicScale() + "\n" +
				"socialScale: " + u1.getSocialScale() + "\n" +
				"qualityOfLifeScale: " + u1.getQualityOfLifeScale() + "\n" +
				"emphases: " + u1.getEmphases()));
	}

	@Test
	public void testViewSchools() {
		Assert.assertTrue("returned string should match expected result", sc.viewSchools(universities1).equals("name: " + u1.getName() + "\n" +
				"state: " + u1.getState() + "\n" +
				"location: " + u1.getLocation() + "\n" +
				"control: " + u1.getControl() + "\n" +
				"numStudents: " + u1.getNumStudents() + "\n" +
				"percentFemale: " + u1.getPercentFemale() + "\n" +
				"SATVerbal: " + u1.getSATVerbal() + "\n" +
				"SATMath: " + u1.getSATMath() + "\n" +
				"expenses: " + u1.getExpenses() + "\n" +
				"percentFinancialAid: " + u1.getPercentFinancialAid() + "\n" +
				"numApplicants: " + u1.getNumApplicants() + "\n" +
				"percentAdmitted: " + u1.getPercentAdmitted() + "\n" +
				"percentEnrolled: " + u1.getPercentEnrolled() + "\n" +
				"academicScale: " + u1.getAcademicScale() + "\n" +
				"socialScale: " + u1.getSocialScale() + "\n" +
				"qualityOfLifeScale: " + u1.getQualityOfLifeScale() + "\n" +
				"emphases: " + u1.getEmphases()+ '\n' +
				"name: " + u2.getName() + "\n" +
				"state: " + u2.getState() + "\n" +
				"location: " + u2.getLocation() + "\n" +
				"control: " + u2.getControl() + "\n" +
				"numStudents: " + u2.getNumStudents() + "\n" +
				"percentFemale: " + u2.getPercentFemale() + "\n" +
				"SATVerbal: " + u2.getSATVerbal() + "\n" +
				"SATMath: " + u2.getSATMath() + "\n" +
				"expenses: " + u2.getExpenses() + "\n" +
				"percentFinancialAid: " + u2.getPercentFinancialAid() + "\n" +
				"numApplicants: " + u2.getNumApplicants() + "\n" +
				"percentAdmitted: " + u2.getPercentAdmitted() + "\n" +
				"percentEnrolled: " + u2.getPercentEnrolled() + "\n" +
				"academicScale: " + u2.getAcademicScale() + "\n" +
				"socialScale: " + u2.getSocialScale() + "\n" +
				"qualityOfLifeScale: " + u2.getQualityOfLifeScale() + "\n" +
				"emphases: " + u2.getEmphases() + '\n'));
		Assert.assertTrue("empty ArrayList should not display any universities", sc.viewSchools(universities2).equals(""));
	}


	@Test
	public void testSaveUniversityReturns1() {
		Assert.assertTrue("saving school to student should return 1", sc.saveUniversity(student, u1) == 1);

	}

	@Test
	public void testSaveUniversityReturnsNegative1() {
		sc.saveUniversity(student, u1);
		Assert.assertTrue("saving school to student should return -1", sc.saveUniversity(student, u1) == -1);
	}


	@Test
	public void testGetRecommededSchools() {
		//TODO: should not need to check much since this method doesn't do any work
	}

	@Test
	public void testSearchUniversities() {
		//TODO: needs a hella work
	}

	@After
	public void destroy() {		
		dbc.deleteUser("user");
	}














}
