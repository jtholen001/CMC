/**
 * 
 */
package Test.EntityTests;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import Controllers.DBController;
import entityClasses.*;

/**
 * @author Michael Carroll
 *
 */
public class StudentTest {

	private Student student1, student2;
	private DBController dbc;

	// @Before annotation forces method to re-execute before each test method
	@Before
	public void init(){
		dbc = new DBController();
		ArrayList<University> savedUniversities = new ArrayList<University>();
		savedUniversities.add(dbc.getUniversity("YALE UNIVERSITY"));
		savedUniversities.add(dbc.getUniversity("BOSTON UNIVERSITY"));
		student1 = new Student("Johnnie", "Miller", "jmill", "password1", 'a', true, false, savedUniversities);
	}
	
	/**
	 * Test method for {@link entityClasses.Student#Student(java.lang.String, java.lang.String, java.lang.String, java.lang.String, char, boolean, boolean, java.util.ArrayList)}.
	 */
	@Test
	public void testStudent() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link entityClasses.Student#getSavedSchools()}.
	 */
	@Test
	public void testGetSavedSchools() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link entityClasses.Student#getSpecificSchool(java.lang.String)}.
	 */
	@Test
	public void testGetSpecificSchool() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link entityClasses.Student#addSchool(entityClasses.University)}.
	 */
	@Test
	public void testAddSchool() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link entityClasses.Student#removeUniversity(entityClasses.University)}.
	 */
	@Test
	public void testRemoveUniversity() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link entityClasses.Student#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test that equals method works with equal objects
	 */
	@Test
	public void testEqualsTrue(){
		student2 = this.student1;
		Assert.assertTrue("Should return true as objects are equal", student1.equals(student2));
	}
	
	/**
	 * Test that equals method fails at first if statement (not instanceof student)
	 */
	@Test
	public void testEqualsFalseNotInstance(){
		boolean randomUnrelatedObject = false;
		Assert.assertFalse("Should return false as objects are of different types", student1.equals(randomUnrelatedObject));
	}
	
	/**
	 * Test that equals method fails at second if statement (studentnames not equal)
	 */
	@Test
	public void testEqualsFalseDifferentStudentnames(){
		student2 = new Student("Johnnie", "Miller", "mjill", "password1", 'a', true, false);
		Assert.assertFalse("Should return false as objects have different studentnames", student1.equals(student2));
	}
	
	/**
	 * Test that equals method fails at third if statement (firstNames not equal)
	 */
	@Test
	public void testEqualsFalseDifferentFirstNames(){
		student2 = new Student("John", "Miller", "jmill", "password1", 'a', true, false);
		Assert.assertFalse("Should return false as objects have different firstNames", student1.equals(student2));
	}
	
	/**
	 * Test that equals method fails at fourth if statement (lastNames not equal)
	 */
	@Test
	public void testEqualsFalseDifferentLastNames(){
		student2 = new Student("John", "Killer", "jmill", "password1", 'a', true, false);
		Assert.assertFalse("Should return false as objects have different lastNames", student1.equals(student2));
	}
	
	/**
	 * Test that equals method fails at fifth if statement (passwords not equal)
	 */
	@Test
	public void testEqualsFalseDifferentPassword(){
		student2 = new Student("John", "Miller", "jmill", "password0", 'a', true, false);
		Assert.assertFalse("Should return false as objects have different passwords", student1.equals(student2));
	}
	
	/**
	 * Test that equals method fails at sixth if statement (types not equal)
	 */
	@Test
	public void testEqualsFalseDifferentType(){
		student2 = new Student("John", "Miller", "jmill", "password1", 'u', true, false);
		Assert.assertFalse("Should return false as objects have different types", student1.equals(student2));
	}

}
