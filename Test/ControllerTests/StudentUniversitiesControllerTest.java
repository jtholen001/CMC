/**
 * 
 */
package Test.ControllerTests;

import org.junit.*;
import Controllers.*;
import entityClasses.*;
import java.util.*;

/**
 * @author rstrelow001
 *
 */
public class StudentUniversitiesControllerTest {

	private StudentUniversitiesController suc; 
	
	private DBController dbc;
	
	private Student student;

	private ArrayList<University> universities1, universities2;
	
	private University u1, u2;
	
	@Before
	public void init(){
		ArrayList<String> emphases = new ArrayList<String>();
		emphases.add("MATH");
		universities1 = new ArrayList<University>();
		universities2 = new ArrayList<University>();
		u1 = new University("TestUniversity1", "Minnesota", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, emphases );
		u2 = new University("TestUniversity2", "IOWA", "SUBURBAN", "PRIVATE", 5000, 65.0, 1000, 850, 15000, 50, 25000, 50, 40, 2, 1, 4, emphases );
		universities1.add(u1);
		universities1.add(u2);
		student = new Student("Test", "Student", "user", "password", 'a', true, true, universities1);
		suc = new StudentUniversitiesController(student);
		dbc = new DBController();
		dbc.addUser(student);
	}

	@After
	public void destroy(){
		dbc.deleteUser("user");
	}

	/**
	 * Test method for {@link Controllers.StudentUniversitiesController#viewSavedUniversities()}.
	 */
	@Test
	public void testViewSavedUniversities() {
		Assert.assertTrue("Viewing saved universities should match output", suc.viewSavedUniversities().equals(u1.getName() + ", " + u2.getName()));
		suc.removeUniversity(u1);
		suc.removeUniversity(u2);
		Assert.assertTrue("Student should not have any saved schools", suc.viewSavedUniversities().equals(""));
	}

	/**
	 * Test method for {@link Controllers.StudentUniversitiesController#viewUniversity(entityClasses.University)}.
	 */
	@Test
	public void testViewUniversity() {
		Assert.assertTrue("returned string should match expected result for viewing a university", suc.viewUniversity(u1).equals("name: " + u1.getName() + "\n" +
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

	/**
	 * Test method for {@link Controllers.StudentUniversitiesController#removeUniversity(entityClasses.University)}.
	 */
	@Test
	public void testRemoveUniversity() {
		Assert.assertTrue("Removing university should return 1", suc.removeUniversity(u1) == 0);
		Assert.assertTrue("Removing an already removed university should return -1", suc.removeUniversity(u1) == -1);
	}

}
