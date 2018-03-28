/**
 * 
 */
package Test.ControllerTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Controllers.DBController;
import entityClasses.Admin;
import entityClasses.Student;
import entityClasses.University;

/**
 * @author jtholen001
 *
 */
public class TestDBController {
	
	University university;
	DBController dbController;
	Student student, student1;
	Admin admin;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		dbController = new DBController();
		student = new Student("Jordan","Tholen","jtholen","password",'u',true,false,new ArrayList<University>());
		university = new University("UNIVERSITY OF CMC", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		student1 = new Student("Jordan","Tholen","jtholen001","password",'u',true,false,new ArrayList<University>());
		admin = new Admin("Rahal","Imad","irahal","admin",'a',true,false);
		
		dbController.addUniversity(university);
		student1.addSchool(university);
		dbController.addUser(student);
		dbController.addUser(student1);
		dbController.addUser(admin);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		dbController.deleteUniversity(university);
		dbController.deleteUser(student1.getUsername());
		dbController.deleteUser(student.getUsername());
	}


	/**
	 * Test method for {@link Controllers.DBController#getUser(java.lang.String)}.
	 */
	@Test
	public void testGetUserForStudentWithoutSchools() {
		Assert.assertTrue("test failed for getting user " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
	}
	
	@Test
	public void testGetUserForStudentWithSchools() {
		Assert.assertTrue("test failed for getting user " + student1.getUsername(), 
				dbController.getUser(student1.getUsername()).equals(student1));
	}
	
	@Test
	public void testGetUserForAdmin() {
		Assert.assertTrue("test failed for getting user " + admin.getUsername(), 
				dbController.getUser(admin.getUsername()).equals(admin));
	}
	
	@Test
	public void testGetUserForInvalidUser() {
		Assert.assertNull("test did not fail for getting an invalid user testuser001",dbController.getUser("testuser001"));
	}

	/**
	 * Test method for {@link Controllers.DBController#getUniversitiesForStudent(java.lang.String)}.
	 */
	@Test
	public void testGetUniversitiesForStudentWithUniversities() {
		Assert.assertTrue("did not return with the correct univerisites for " +student1.getUsername(),
				dbController.getUniversitiesForStudent(student1.getUsername()).equals(student1.getSavedSchools()));
	}
	
	@Test
	public void testGetUniversitiesForStudentWithoutUniversities() {
		Assert.assertTrue("did not return with the correct univerisites for " +student.getUsername(),
				dbController.getUniversitiesForStudent(student.getUsername()).equals(student.getSavedSchools()));
	}
	
	@Test
	public void testGetUniversitiesForAdmin() {
		Assert.assertTrue("did not return and empty list for " +admin.getUsername(),
				dbController.getUniversitiesForStudent(admin.getUsername()).isEmpty());
	}
//
//	/**
//	 * Test method for {@link Controllers.DBController#getUsers()}.
//	 */
//	@Test
//	public void testGetUsers() {
//		fail("Not yet implemented");
//	}
//
	/**
	 * Test method for {@link Controllers.DBController#saveEditedUser(entityClasses.User)}.
	 */
	@Test
	public void testSaveEditedUserForStudentActivationStatus() {
		student.setActivationStatus(false);
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
	}
	
	@Test
	public void testSaveEditedUserForFirstName() {
		student.setFirstName("john");
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
	}
	
	@Test
	public void testSaveEditedUserForLastName() {
		student.setLastName("john");
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
	}
	
	@Test
	public void testSaveEditedUserForType() {
		student.setType('a');
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
	}
	
	@Test
	public void testSaveEditedUserForLoggedIn() {
		student.setLoggedInStatus(true);
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
	}
	
	@Test
	public void testSaveEditedUserForPassword() {
		student.setPassword("sadlkfj");
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
	}
	
	@Test
	public void testSaveEditedStudentForNewSchool() {
		student.addSchool(university);
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
	}
	
	@Test
	public void testSaveEditedStudentForDeletedSchool() {
		student1.removeUniversity(university);
		dbController.saveEditedUser(student1);
		Assert.assertTrue("user was not save correctly " + student1.getUsername(), 
				dbController.getUser(student1.getUsername()).equals(student1));
	}
// 
//	/**
//	 * Test method for {@link Controllers.DBController#addUser(entityClasses.User)}.
//	 */
//	@Test
//	public void testAddUser() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Controllers.DBController#deleteUser(java.lang.String)}.
//	 */
//	@Test
//	public void testDeleteUser() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Controllers.DBController#viewUniversities()}.
//	 */
//	@Test
//	public void testViewUniversities() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Controllers.DBController#getUniversity(java.lang.String)}.
//	 */
//	@Test
//	public void testGetUniversity() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Controllers.DBController#saveEditedUniversity(entityClasses.University)}.
//	 */
//	@Test
//	public void testSaveEditedUniversity() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Controllers.DBController#addUniversity(entityClasses.University)}.
//	 */
//	@Test
//	public void testAddUniversity() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Controllers.DBController#deleteUniversity(entityClasses.University)}.
//	 */
//	@Test
//	public void testDeleteUniversity() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Controllers.DBController#removeUniversityFromStudent(entityClasses.Student, entityClasses.University)}.
//	 */
//	@Test
//	public void testRemoveUniversityFromStudent() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Controllers.DBController#getRecommendedUniversities(entityClasses.University)}.
//	 */
//	@Test
//	public void testGetRecommendedUniversities() {
//		fail("Not yet implemented");
//	}

}
