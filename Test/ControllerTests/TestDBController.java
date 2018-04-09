/**
 * 
 */
package Test.ControllerTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Controllers.DBController;
import entityClasses.Admin;
import entityClasses.Student;
import entityClasses.University;
import entityClasses.User;

/**
 * @author jtholen001
 *
 */
public class TestDBController {

	University university;
	DBController dbController = new DBController();
	Student student, student1;
	Admin admin;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		student = new Student("Jordan","Tholen","jtholen","password",'u',true,false,new ArrayList<University>());
		university = new University("UNIVERSITY OF CMC", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		student1 = new Student("Jordan","Tholen","jtholen001","password",'u',true,false,new ArrayList<University>());
		admin = new Admin("Rahal","Imad","irahal","admin",'a',true,false);

		dbController.addUniversity(university);
		//student1.addSchool(university);
		dbController.addUser(student);
		dbController.addUser(student1);
		dbController.saveUniversityToStudent(student1, university);
		dbController.addUser(admin);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{
		dbController.deleteUser(student1.getUsername());
		dbController.deleteUser(student.getUsername());
		dbController.deleteUser(admin.getUsername());
		dbController.deleteUniversity(university);
	}


	/**
	 * Test method for {@link Controllers.DBController#getUser(java.lang.String)}.
	 */
	@Test
	public void testGetUserForStudent() {
		//without schools
		Assert.assertTrue("test failed for getting user " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
		//with schools
		Assert.assertTrue("test failed for getting user " + student1.getUsername(), 
				dbController.getUser(student1.getUsername()).equals(student1));
	}

	@Test
	public void testGetUserForAdmin() {
		Assert.assertTrue("test failed for getting user " + admin.getUsername(), 
				dbController.getUser(admin.getUsername()).equals(admin));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetUserForInvalidUser() {
		Assert.assertNull("test did not fail for getting an invalid user testuser001",dbController.getUser("testuser001"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetUserForEmpty() {
		Assert.assertNull("test did not fail for getting an invalid user testuser001",dbController.getUser(""));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetUserForNull() {
		Assert.assertNull("test did not fail for getting an invalid user testuser001",dbController.getUser(null));
	}

	/**
	 * Test method for {@link Controllers.DBController#getUsers()}.
	 */
	@Test
	public void testGetUsers() {
		HashMap<String,User> temp = dbController.getUsers();
		Assert.assertNotNull("User object was null",temp.get("jtholen001"));
		Assert.assertNotNull("User object was null",temp.get("irahal"));
		Assert.assertNotNull("User object was null",temp.get("jtholen"));
	}
	
	@Test
	public void testGetUsersInvalid() {
		HashMap<String,User> temp = dbController.getUsers();
		Assert.assertNull("User object was not null",temp.get(" "));
		Assert.assertNull("User object was not null",temp.get(null));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSaveEditedUserForNull() {
		dbController.saveEditedUser(null);
	}

	/**
	 * Test method for {@link Controllers.DBController#saveEditedUser(entityClasses.User)}.
	 */
	@Test
	public void testSaveEditedUserForActivationStatus() {
		admin.setActivationStatus(false);
		dbController.saveEditedUser(admin);
		Assert.assertTrue("user was not save correctly " + admin.getUsername(), 
				dbController.getUser(admin.getUsername()).equals(admin));
		student.setActivationStatus(true);
		dbController.saveEditedUser(admin);
		Assert.assertTrue("user was not save correctly " + admin.getUsername(), 
				dbController.getUser(admin.getUsername()).equals(admin));
	}

	@Test
	public void testSaveEditedUserForFirstName() {
		student.setFirstName("john");
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
		admin.setFirstName("dummie");
		dbController.saveEditedUser(admin);
		Assert.assertTrue("user was not save correctly " + admin.getUsername(), 
				dbController.getUser(admin.getUsername()).equals(admin));
	}

	@Test
	public void testSaveEditedUserForLastName() {
		student.setLastName("john");
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
		admin.setLastName("fjsk");
		dbController.saveEditedUser(admin);
		Assert.assertTrue("user was not save correctly " + admin.getUsername(), 
				dbController.getUser(admin.getUsername()).equals(admin));
	}

	@Test
	public void testSaveEditedUserForType() {
		student.setType('a');
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
		admin.setType('u');
		dbController.saveEditedUser(admin);
		Assert.assertTrue("user was not save correctly " + admin.getUsername(), 
				admin.equals(dbController.getUser(admin.getUsername())));
	}

	@Test
	public void testSaveEditedUserForLoggedIn() {
		student.setLoggedInStatus(true);
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
		admin.setLoggedInStatus(true);
		dbController.saveEditedUser(admin);
		Assert.assertTrue("user was not save correctly " + admin.getUsername(), 
				dbController.getUser(admin.getUsername()).equals(admin));
	}

	@Test
	public void testSaveEditedUserForPassword() {
		student.setPassword("sadlkfj");
		dbController.saveEditedUser(student);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
		admin.setPassword("dumb");
		dbController.saveEditedUser(admin);
		Assert.assertTrue("user was not save correctly " + admin.getUsername(), 
				dbController.getUser(admin.getUsername()).equals(admin));
	}

	/**
	 * Test method for {@link Controllers.DBController#addUser(entityClasses.User)}.
	 */
	@Test
	public void testAddUserStudent() {
		Student stu = new Student("Jordan","Tholen","stu","password",'u',true,false,new ArrayList<University>());
		dbController.addUser(stu);
		Assert.assertTrue("new user does not match the databse", dbController.getUser(stu.getUsername())
				.equals(stu));
		dbController.deleteUser(stu.getUsername());
	}
	
	@Test
	public void testAddUserAdmin() {
		Admin ad = new Admin("Jordan","Tholen","ad","password",'a',true,false);
		dbController.addUser(ad);
		Assert.assertTrue("new user does not match the databse", dbController.getUser(ad.getUsername())
				.equals(ad));
		dbController.deleteUser(ad.getUsername());
	}
	
	@Test
	public void testAddUserStudentWithSavedSchools() {
		Student stu = new Student("Jordan","Tholen","stu","password",'u',true,false,new ArrayList<University>());
		stu.addSchool(university);
		dbController.addUser(stu);
		Assert.assertFalse("new user does not match the databse", dbController.getUser(stu.getUsername())
				.equals(stu));
		dbController.deleteUser(stu.getUsername());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddUserSpace() {
		Student stu = new Student(" ","Tholen","a;lskjdf","password ",'u',true,false,new ArrayList<University>());
		dbController.addUser(stu);
		dbController.deleteUser(stu.getUsername());
	}
	@Test (expected = IllegalArgumentException.class)
	public void testAddUserAdminSpace() {

		Admin ad = new Admin(" ","Tholen","a;lskjdf","password",'a',true,false);
		dbController.addUser(ad);
		Assert.assertTrue("new user does not match the databse", dbController.getUser(ad.getUsername())
				.equals(ad));
		dbController.deleteUser(ad.getUsername());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testAddUserInDatabase() {
		dbController.addUser(student);
	}

//	@Test
//	public void testAddStudentWithSavedSchools() {
//		Student stu = new Student("Jordan","Tholen","a;lskjdf","password",'u',true,false,new ArrayList<University>());
//		stu.addSchool(university);
//		dbController.addUser(stu);
//		Assert.assertTrue("new user does not match the databse", dbController.getUser(stu.getUsername())
//				.equals(stu));
//		dbController.deleteUser(stu.getUsername());
//	}
//
//	@Test (expected = IllegalArgumentException.class)
//	public void testAddStudentWithInvalidSavedSchools() {
//		Student stu = new Student("Jordan","Tholen","a;lskjdf","password",'u',true,false,new ArrayList<University>());
//		stu.addSchool(new University("Jordan", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>()));
//		dbController.addUser(stu);
//	}

	@Test
	public void testAddAdmin() {
		Admin ad = new Admin("sdf","sdfsdf","irahal001","admin",'a',true,false);		
		dbController.addUser(ad);
		Assert.assertTrue("new user does not match the databse", dbController.getUser(ad.getUsername())
				.equals(ad));
		dbController.deleteUser(ad.getUsername());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddNull() {
		dbController.addUser(null);
	}

	@Test
	public void testSaveUniversityToNewStudent() {
		//student.addSchool(university);
		dbController.saveUniversityToStudent(student, university);
		Assert.assertTrue("user was not save correctly " + student.getUsername(), 
				dbController.getUser(student.getUsername()).equals(student));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSaveUniversityToNewStudentForInvalidSchool() {
		University temp = new University("Jordan", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		dbController.saveUniversityToStudent(student, temp);
	}


	/**
	 * Test method for {@link Controllers.DBController#deleteUser(java.lang.String)}.
	 */
	@Test
	public void testDeleteStudent() {
		Student stu = new Student("Jordan","Tholen","user001","password",'u',true,false,new ArrayList<University>());
		dbController.addUser(stu);
		assertTrue("User was not deleted from the databse " + stu.getUsername(),
				dbController.deleteUser(stu.getUsername()) == 1);
	}

	@Test
	public void testDeleteStudentWithSavedSchools() {
		Student stu = new Student("Jordan","Tholen","user001","password",'u',true,false,new ArrayList<University>());
		stu.addSchool(university);
		dbController.addUser(stu);
		assertTrue("User was not deleted from the databse " + stu.getUsername(),
				dbController.deleteUser(stu.getUsername()) == 1);
	}

	@Test
	public void testDeleteAdmin() {
		Admin ad = new Admin("Imad","Rahal","irahal001","admin",'a',true,false);
		dbController.addUser(ad);
		assertTrue("User was not deleted from the databse " + ad.getUsername(),
				dbController.deleteUser(ad.getUsername()) == 1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDeleteInvalidUser() {
		Admin ad = new Admin("Imad","Rahal","irahal001","admin",'a',true,false);
		dbController.deleteUser(ad.getUsername());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testDeleteNull() {
		dbController.deleteUser(null);
	}

	/**
	 * Test method for {@link Controllers.DBController#viewUniversities()}.
	 */
	@Test
	public void testViewUniversities() {
		HashMap<String,University> temp = dbController.viewUniversities();
		Assert.assertNotNull("University object was null", temp.get("ABILENE CHRISTIAN UNIVERSITY"));
		Assert.assertNotNull("University object was null", temp.get("YANKTOWN COLLEGE"));
	}
	
	@Test
	public void testViewUniversitiesInvalid() {
		HashMap<String,University> temp = dbController.viewUniversities();
		Assert.assertNull("University object was null", temp.get("Jordan"));
		Assert.assertNull("University object was null", temp.get(null));
	}

	/**
	 * Test method for {@link Controllers.DBController#getUniversity(java.lang.String)}.
	 */
	@Test
	public void testGetUniversityWithoutEmphases() {
		University uni = dbController.getUniversity(university.getName());
		assertTrue("retrieved universtiy does not equal",uni.equals(university));
		
		 uni = dbController.getUniversity(" University of CMC ");
		assertTrue("retrieved universtiy does not equal",uni.equals(university));
	}

	@Test
	public void testGetUniversityWithEmphases() {
		ArrayList<String> temp = university.getEmphases();
		temp.add("Computer Science");
		university.setEmphases(temp);
		dbController.saveEditedUniversity(university);
		assertTrue("retrieved universtiy does not equal",dbController.getUniversity(university.getName())
				.equals(university));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetUniversityInvalid() {
		dbController.getUniversity("Univeristy of Jordan");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetUniversityNull() {
		dbController.getUniversity(null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetUniversitySpace() {
		dbController.getUniversity(" ");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSaveEditedUniversityInvalid() {
		dbController.saveEditedUniversity(null);
	}


	/**
	 * Test method for {@link Controllers.DBController#saveEditedUniversity(entityClasses.University)}.
	 */
	@Test
	public void testSaveEditedUniversityState() {
		university.setState("Minnesota");
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityAcademicScale() {
		university.setAcademicScale(5);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityControl() {
		university.setControl("private");
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityExpenses() {
		university.setExpenses(20.0);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityLocation() {
		university.setLocation("urban");
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityApplicants() {
		university.setNumApplicants(5000);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityStudents() {
		university.setNumStudents(500);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityPercentAdmitted() {
		university.setPercentAdmitted(90.0);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityPercentEnrolled() {
		university.setPercentEnrolled(95.0);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityPercentFemale() {
		university.setPercentFemale(100.0);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityPercentFinancialAid() {
		university.setPercentFinancialAid(100.0);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityQualityOfLife() {
		university.setQualityOfLifeScale(5);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversitySATMath() {
		university.setSATMath(200.5);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversitySATVerbal() {
		university.setSATVerbal(400.0);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversitySocialScale() {
		university.setSocialScale(5);
		dbController.saveEditedUniversity(university);
		assertTrue("University did not mached the saved university",university.equals(dbController.getUniversity(university.getName())));
	}

	@Test
	public void testSaveEditedUniversityAddedEmphases() {
		ArrayList<String> temp = university.getEmphases();
		temp.add("Biology");
		university.setEmphases(temp);
		dbController.saveEditedUniversity(university);
		assertTrue("",university.equals(dbController.getUniversity(university.getName())));
	}

	/**
	 * Test method for {@link Controllers.DBController#addUniversity(entityClasses.University)}.
	 */
	@Test
	public void testAddUniversity() {
		University university1 = new University("JORDAN", "MINNESOTA", "RURAL", "PRIVATE", 10, 55.0, 100.0, 120.0, 85.0, 25.0, 10, 50.0, 20.0, 2, 1, 4, new ArrayList<String>());
		dbController.addUniversity(university1);
		Assert.assertTrue("The database did not contain the same information for the university", 
				dbController.getUniversity(university1.getName()).equals(university1));
		dbController.deleteUniversity(university1);
	}

	@Test
	public void testAddUniversityWithEmphases() {
		University university1 = new University("JORDAN", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		ArrayList<String> emphases = university1.getEmphases();
		emphases.add("BIOLOGY");
		emphases.add("COMPUTER SCIENCE");
		dbController.addUniversity(university1);
		Assert.assertTrue("The database did not contain the same information for the university", 
				dbController.getUniversity(university1.getName()).equals(university1));
		dbController.deleteUniversity(university1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddUniversityAlreadyInDatabase() {
		dbController.addUniversity(university);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddUniversityForUniversityNameInDatabase() {
		University university1 = new University("University of cmc","MINNESOTA", "RURAL", "PRIVATE", 10, 55.0, 100.0, 120.0, 85.0, 25.0, 10, 50.0, 20.0, 2, 1, 4, new ArrayList<String>());
		dbController.addUniversity(university1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testAddUniversityForNullValue() {
		University university1 = null;
		dbController.addUniversity(university1);
	}
	/**
	 * Test method for {@link Controllers.DBController#deleteUniversity(entityClasses.University)}.
	 */
	@Test
	public void testDeleteUniversity() {
		University university1 = new University("JORDAN", "MINNESOTA", "RURAL", "PRIVATE", 10, 55.0, 100.0, 120.0, 85.0, 25.0, 10, 50.0, 20.0, 2, 1, 4, new ArrayList<String>());
		dbController.addUniversity(university1);
		dbController.deleteUniversity(university1);
		try{
			dbController.getUniversity(university1.getName());
			Assert.fail();
		}
		catch(IllegalArgumentException j) {
			
		}
	}

	@Test
	public void testDeleteUniversityWithEmphases() {
		University university1 = new University("JORDAN", "MINNESOTA", "RURAL", "PRIVATE", 10, 55.0, 100.0, 120.0, 85.0, 25.0, 10, 50.0, 20.0, 2, 1, 4, new ArrayList<String>());
		ArrayList<String> emphases = university1.getEmphases();
		emphases.add("BIOLOGY");
		dbController.addUniversity(university1);
		dbController.deleteUniversity(university1);
		try{
			dbController.getUniversity(university1.getName());
			Assert.fail();
		}
		catch(IllegalArgumentException j) {
			
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDeleteUniversityForUniversityNotInDatabase() {
		University university1 = new University("JORDAN", "MINNESOTA", "RURAL", "PRIVATE", 10, 55.0, 100.0, 120.0, 85.0, 25.0, 10, 50.0, 20.0, 2, 1, 4, new ArrayList<String>());
		dbController.deleteUniversity(university1);
	}

	/**
	 * Test method for {@link Controllers.DBController#removeUniversityFromStudent(entityClasses.Student, entityClasses.University)}.
	 */
	@Test
	public void testRemoveUniversityFromStudent() {
		dbController.removeUniversityFromStudent(student1, university);
		Assert.assertTrue("School was not removed", dbController.getUser(student1.getUsername()).equals(student1));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testRemoveUniversityFromStudentForStudentNotInDatabase() {
		Student temp = new Student("Donald","Trump","fakeNews","password",'u',true,false,new ArrayList<University>());
		dbController.removeUniversityFromStudent(temp, university);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testRemoveUniversityFromStudentForUniveristyNotInDatabase() {
		University temp = new University("JORDAN", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		dbController.removeUniversityFromStudent(student, temp);
	}

}
