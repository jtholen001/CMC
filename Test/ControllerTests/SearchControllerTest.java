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
	
	private ArrayList<University> universities1, universities2;
	
	private University u1, u2;
	
	private Student student;
	
	@Before
	public void init() {
		sc = new SearchController();
		ArrayList<String> emphases = new ArrayList<String>();
		emphases.add("MATH");
		universities1 = new ArrayList<University>();
		universities2 = new ArrayList<University>();
		u1 = new University("TestUniversity1", "Minnesota", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, emphases );
		u2 = new University("TestUniversity2", "IOWA", "SUBURBAN", "PRIVATE", 5000, 65.0, 1000, 850, 15000, 50, 25000, 50, 40, 2, 1, 4, emphases );
		universities1.add(u1);
		universities1.add(u2);
		student = new Student("Test", "Student", "user", "password", 'a', true, true, new ArrayList<University>());
	}
	
	@Test
	public void testcompareStatsreturns1() {
		Assert.assertTrue("comparing 5 to the range 5 to 8 should return 1", sc.compareStats(5, 5, 8) == 1);
		Assert.assertTrue("comparing 5 to the range 0 to 8 should return 1", sc.compareStats(5, 0, 8) == 1);
		Assert.assertTrue("comparing 5 to the range 3 to 0 should return 1", sc.compareStats(5, 3, 0) == 1);
		Assert.assertTrue("comparing 5 to the range 5 to 8 should return 1", sc.compareStats(5, 0, 0) == 1);		
	}
	
	@Test
	public void testcompareStatsreturns0() {
		Assert.assertTrue("comparing 4 to the range 5 to 8 should return 0", sc.compareStats(4, 5, 8) == 0);
		Assert.assertTrue("comparing 9 to the range 0 to 8 should return 0", sc.compareStats(9, 0, 8) == 0);
		Assert.assertTrue("comparing 2 to the range 3 to 0 should return 1", sc.compareStats(2, 3, 0) == 0);		
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
		Assert.assertTrue("returned string should match expected result", sc.viewSchools(universities1).equals(u1.toString() + '\n' + u2.toString() + '\n'));
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
		DBController dbcont = new DBController();
		dbcont.deleteUser("user");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
