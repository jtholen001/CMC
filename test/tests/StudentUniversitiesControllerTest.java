/**
 * 
 */
package tests;

import org.junit.*;
import cmcPackage.Controllers.*;
import cmcPackage.entityClasses.*;
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
		u2 = new University("TestUniversity2", "IOWA", "SUBURBAN", "PRIVATE", 5000, 65.0, 600, 800, 15000, 50, 25000, 50, 40, 2, 1, 4, emphases );
		universities1.add(u1);
		universities1.add(u2);
		student = new Student("Test", "Student", "user", "password", 'a', true, false, new ArrayList<University>());
		suc = new StudentUniversitiesController(student);
		dbc = new DBController();
		dbc.addUser(student);
		dbc.addUniversity(u1);
		dbc.addUniversity(u2);
	}

	@After
	public void destroy(){
		dbc.deleteUser("user");
		dbc.deleteUniversity(u1);
		dbc.deleteUniversity(u2);
	}

	/**
	 * Test method for {@link Controllers.StudentUniversitiesController#viewSavedUniversities()}.
	 */
	@Test
	public void testViewSavedUniversities() {
		student.addSchool(u1);
		student.addSchool(u2);
		HashMap<String, University> savedUniversities = suc.viewSavedUniversities();
		Assert.assertTrue("TestUniversity1 should be saved to the student", savedUniversities.containsKey(u1.getName()));
		Assert.assertTrue("TestUniversity2 should be saved to the student", savedUniversities.containsKey(u2.getName()));
		Assert.assertTrue("Saved Universities size should be 2", savedUniversities.size() == 2);
	}
	
	@Test
	public void testViewSavedUniversitiesWithNoUniversities() {
		HashMap<String, University> savedUniversities = suc.viewSavedUniversities();
		Assert.assertTrue("Saved Universities should be empty", savedUniversities.isEmpty());
	}

	/**
	 * Test method for {@link Controllers.StudentUniversitiesController#viewUniversity(entityClasses.University)}.
	 */
	@Test
	public void testViewUniversity() {
		Assert.assertTrue("returned University should match expected result for viewing a university", suc.viewUniversity(u1.getName()).equals(u1));

	}

	/**
	 * Test method for {@link Controllers.StudentUniversitiesController#removeUniversity(entityClasses.University)}.
	 */
	@Test
	public void testRemoveUniversity() {
		dbc.saveUniversityToStudent(student, u1);
		Assert.assertTrue("Removing university should return 1", suc.removeUniversity(u1) == 1);
	}

	
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveUniversityAlreadyRemoved() {
		suc.removeUniversity(u1);
	}

}
