package Test.ControllerTests;

import Controllers.DBController;
import entityClasses.*;
import java.util.*;
import org.junit.*;

public class DBControllerTest {
	
	private DBController dbController;
	private Admin admin;
	private Student student;
	private University university;
	
	@Before
	public void init() {
		dbController = new DBController();
		student = new Student("Jordan","Tholen","jtholen","password",'u',true,false,new ArrayList<University>());
		university = new University("UNIVERSITY OF CMC", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		ArrayList<String> al = new ArrayList<String>();
		al.add("Computer Science");
		university.setEmphases(al);
		//student.addSchool(university);
		dbController.addUser(student);
		//dbController.saveEditedUser(student);
		admin = new Admin("Rahal","Imad","irahal","admin",'a',true,false);
		dbController.addUser(admin);
		dbController.addUniversity(university);
	}
	
	@After
	public void destroy()
	{
		dbController.deleteUniversity(university);
		dbController.deleteUser(student.getUsername());
		dbController.deleteUser(admin.getUsername());
	}
	
	@Test
	public void testGetUserForAdminReturnsTrue()
	{
		Admin testAdmin = (Admin)dbController.getUser(admin.getUsername());
		Assert.assertTrue("get admin user " + admin.getFirstName() + " " + admin.getLastName() + " did not equal the same admin", testAdmin.equals(admin));
	}
	
//	@Test
//	public void testGetUserForStudentReturnsTrue()
//	{
//		Assert.assertEquals(student, (Student)dbController.getUser(student.getUsername()));
//	}
	
	@Test
	public void testGetIncorrectUser()
	{
		Assert.assertTrue("get non existent user returned something besides null",dbController.getUser("wrong") == null);
	}
	
//	@Test
//	public void testGetUniversitiesForValidStudent()
//	{
//		for(University univ : dbController.getUniversitiesForStudent(student.getUsername()))
//		{
//			Assert.assertTrue(student.getSpecificSchool(univ.getName()).equals(univ));
//		}
//	}
	
	@Test
	public void testSaveEditedStudent()
	{
		student.setActivationStatus(false);
		dbController.saveEditedUser(student);
		Assert.assertTrue(dbController.getUser(student.getUsername()).equals(student));
		
		student.setFirstName("John");
		dbController.saveEditedUser(student);
		Assert.assertTrue(dbController.getUser(student.getUsername()).equals(student));
		
		student.setLastName("newLastName");
		dbController.saveEditedUser(student);
		Assert.assertTrue(dbController.getUser(student.getUsername()).equals(student));
		
		student.setLoggedInStatus(true);
		dbController.saveEditedUser(student);
		Assert.assertTrue(dbController.getUser(student.getUsername()).equals(student));
		
		student.setPassword("sldkfjsal;kjfd");
		dbController.saveEditedUser(student);
		Assert.assertTrue(dbController.getUser(student.getUsername()).equals(student));
		
		student.setType('a');
		dbController.saveEditedUser(student);
		Assert.assertTrue(dbController.getUser(student.getUsername()).equals(student));
	}

}
