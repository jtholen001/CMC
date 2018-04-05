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
 * for JUnit testing of Student.java
 * 
 * @author Michael Carroll
 * @version 04/04/18
 */
public class StudentTest {

	private Student student1, student2;
	private DBController dbc;

	// @Before annotation forces method to re-execute before each test method
	@Before
	public void init(){
		dbc = new DBController();
		student1 = new Student("Johnnie", "Miller", "jmill", "password1", 'u', true, false, new ArrayList<University>());
		student1.addSchool(dbc.getUniversity("YALE"));
		student1.addSchool(dbc.getUniversity("BOSTON UNIVERSITY"));
	}
	
	/**
	 * Test that the default constructor works for correct/valid parameters
	 */     
	@Test
	public void constructorSucceedsForValidInput() {
		Assert.assertTrue("Constructor should succeed for user as all fields meet constructor criteria",
				new Student("John","Miller","jmill", "password0", 'u', true, false, new ArrayList<University>()) instanceof Student);
	}

	/**
	 * Test that the default constructor fails for empty firstName parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidFirstName() {
		new Student("","Miller","jmill", "password0", 'u', true, false, new ArrayList<University>());
	}

	/**
	 * Test that the default constructor fails for empty lastName parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidLastName() {
		new Student("John","","jmill", "password0", 'u', true, false, new ArrayList<University>());
	}

	/**
	 * Test that the default constructor fails for empty username parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidUsername() {
		new Student("John","Miller","", "password0", 'u', true, false, new ArrayList<University>());
	}

	/**
	 * Test that the default constructor fails for empty password parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidPassword() {
		new Student("John","Miller","jmill", "", 'u', true, false, new ArrayList<University>());
	}
	/**
	 * Test method for {@link entityClasses.Student#getSavedSchools()}.
	 */
	@Test
	public void testGetSavedSchools() {
		ArrayList<University> expected = new ArrayList<University>();
		expected.add(dbc.getUniversity("YALE"));
		expected.add(dbc.getUniversity("BOSTON UNIVERSITY"));
		Assert.assertTrue("GetSavedSchools should succeed for user as ArrayList<University> \"expected\" is equal to user's saved schools",
				student1.getSavedSchools().equals(expected));
	}

	/**
	 * Test that method getSpecificSchool() works for a University that exists in user's saved schools
	 */
	@Test
	public void testGetSpecificSchoolThatExists() {
		Assert.assertTrue("GetSpecificSchool should succeed for user as \"BOSTON UNIVERSITY\" is one of their saved schools",
				student1.getSpecificSchool("BOSTON UNIVERSITY") instanceof University);
	}
	
	/**
	 * Test that method getSpecificSchool() fails for a University that does not exist in user's saved schools
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testGetSpecificSchoolThatDoesNotExist() {
		student1.getSpecificSchool("University of Carrot");
	}

	/**
	 * Test that method addSchool() works for a unique University not saved to user already
	 */
	@Test
	public void testAddUniqueSchool() {
		student1.addSchool(dbc.getUniversity("ARIZONA STATE"));
		Assert.assertTrue("addSchool() should succeed as \"ARIZONA STATE\" is not yet one of the user's saved schools",
				student1.getSpecificSchool("ARIZONA STATE") instanceof University);
	}
	
	/**
	 * Test that method addSchool() fails for an existing University already saved to user
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testAddExistingSchool() {
		student1.addSchool(dbc.getUniversity("BOSTON UNIVERSITY"));
	}
	
	/**
	 * Test that method removeSchool() works for a University saved to user
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveExistingUniversity() {
		student1.removeUniversity(dbc.getUniversity("BOSTON UNIVERSITY"));
		student1.getSpecificSchool("BOSTON UNIVERSITY");
	}
	
	/**
	 * Test that method removeSchool() fails for a University not saved to user
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveNonExistingUniversity() {
		student1.removeUniversity(dbc.getUniversity("ARIZONA STATE"));
	}
	
	/**
	 * Test method for {@link entityClasses.Student#toString()}.
	 */
	@Test
	public void testToString(){
		String expected = ("First name: " + student1.getFirstName() +
				"\nLast name: " + student1.getLastName() +
				"\nUsername: " + student1.getUsername() +
				"\nType: " + student1.getType() +
				"\nActivated: " + student1.getActivationStatus() +
				"\nLogged in: " + student1.getLoggedInStatus() +
				"\nUniversities: YALE, BOSTON UNIVERSITY");
		System.out.println(student1.toString());
		Assert.assertTrue("Should return toString matching toString in Student entity", student1.toString().equals(expected));
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
	 * Test that equals method fails at second if statement (usernames not equal)
	 */
	@Test
	public void testEqualsFalseDifferentUsernames(){
		student2 = new Student("Johnnie", "Miller", "mjill", "password1", 'u', true, false, new ArrayList<University>());
		student2.addSchool(dbc.getUniversity("YALE"));
		student2.addSchool(dbc.getUniversity("BOSTON UNIVERSITY"));
		
		Assert.assertFalse("Should return false as objects have different usernames", student1.equals(student2));
	}
	
	/**
	 * Test that equals method fails at third if statement (firstNames not equal)
	 */
	@Test
	public void testEqualsFalseDifferentFirstNames(){
		student2 = new Student("John", "Miller", "jmill", "password1", 'u', true, false, new ArrayList<University>());
		student2.addSchool(dbc.getUniversity("YALE"));
		student2.addSchool(dbc.getUniversity("BOSTON UNIVERSITY"));
		Assert.assertFalse("Should return false as objects have different firstNames", student1.equals(student2));
	}
	
	/**
	 * Test that equals method fails at fourth if statement (lastNames not equal)
	 */
	@Test
	public void testEqualsFalseDifferentLastNames(){
		student2 = new Student("John", "Killer", "jmill", "password1", 'u', true, false, new ArrayList<University>());
		student2.addSchool(dbc.getUniversity("YALE"));
		student2.addSchool(dbc.getUniversity("BOSTON UNIVERSITY"));
		Assert.assertFalse("Should return false as objects have different lastNames", student1.equals(student2));
	}
	
	/**
	 * Test that equals method fails at fifth if statement (passwords not equal)
	 */
	@Test
	public void testEqualsFalseDifferentPassword(){
		student2 = new Student("John", "Miller", "jmill", "password0", 'u', true, false, new ArrayList<University>());
		student2.addSchool(dbc.getUniversity("YALE"));
		student2.addSchool(dbc.getUniversity("BOSTON UNIVERSITY"));
		Assert.assertFalse("Should return false as objects have different passwords", student1.equals(student2));
	}
	
	/**
	 * Test that equals method fails at sixth if statement (types not equal)
	 */
	@Test
	public void testEqualsFalseDifferentType(){
		student2 = new Student("John", "Miller", "jmill", "password1", 'a', true, false, new ArrayList<University>());
		student2.addSchool(dbc.getUniversity("YALE"));
		student2.addSchool(dbc.getUniversity("BOSTON UNIVERSITY"));
		Assert.assertFalse("Should return false as objects have different types", student1.equals(student2));
	}
	
	/**
	 * Test that equals method fails at seventh if statement (saved schools not equal)
	 */
	@Test
	public void testEqualsFalseDifferentSavedSchools(){
		student2 = new Student("John", "Miller", "jmill", "password1", 'a', true, false, new ArrayList<University>());
		student2.addSchool(dbc.getUniversity("ARIZONA STATE"));
		student2.addSchool(dbc.getUniversity("BOSTON UNIVERSITY"));
		
		Assert.assertFalse("Should return false as objects have different saved schools", student1.equals(student2));
	}

}
