package Test.FunctionalTests;

import java.util.*;
import org.junit.*;

import entityClasses.*;
import Controllers.*;
import Interfaces.*;

/**
 * @author Nick Tawil, Michael Carroll, Ryan Strelow, Jordan Tholen, Brandan Kalsow
 * This class performs functional testing for the CMC system
 * Each Use Case and every alternate scenario has exactly one test method
 *
 */
public class FunctionalTests
{
	//private variables here
	private AdminInterface adminInt;
	private StudentInterface studentInt;
	private UserInterface userInt;
	private Admin admin;
	private Student student;
	private DBController dbCont;
	private University university, university2;

	
	
	/**
	 * Init method
	 */
	@Before
	public void init()
	{
		admin = new Admin("Com", "Puter", "cputer001", "password", 'a', true, false);
		student = new Student("Calc", "Ulator", "culator001", "password", 'u', true, false, new ArrayList<University>());
		dbCont = new DBController();
		dbCont.addUser(admin);
		dbCont.addUser(student);
		adminInt = new AdminInterface(admin);
		studentInt = new StudentInterface(student);
		userInt = new UserInterface();
		university = new University("TestUniversity1", "Minnesota", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>() );
		university2 = new University("TestUniversity2", "IOWA", "SUBURBAN", "PRIVATE", 5000, 65.0, 600, 800, 15000, 50, 25000, 50, 40, 2, 1, 4, new ArrayList<String>() );
		dbCont.addUniversity(university2);
		studentInt.saveUniversity(university2);
		dbCont.addUniversity(university);
	}
	
	@After
	public void destroy()
	{
		dbCont.deleteUser("cputer001");
		dbCont.deleteUser("culator001");
		dbCont.deleteUniversity(university);
		dbCont.deleteUniversity(university2);
	}
	
	//U1 Login
	/**
	 * u1 main scenario
	 */
	@Test
	public void testU1()
	{
		UserInterface addedUser = userInt.login(student.getUsername(), student.getPassword());
		Assert.assertNotNull(addedUser);
	}
	
	/**
	 * U1A1 password is incorrect
	 */
	@Test
	public void testU1_A1()
	{
		UserInterface addedUser = userInt.login(student.getUsername(), "incorrectPassword");
		Assert.assertNull(addedUser);
	}
	
	/**
	 * U1_A2 username is incorrect
	 */
	@Test
	public void testU1_A2()
	{
		UserInterface addedUser = userInt.login("incorrectUsername", student.getPassword());
		Assert.assertNull(addedUser);
	}
	
	/**
	 * U1_A3 user is deactivated
	 */
	@Test
	public void testU1_A3()
	{
		adminInt.deactivate(student);
		UserInterface addedUser = userInt.login("incorrectUsername", student.getPassword());
		Assert.assertNull(addedUser);
		//adminInt.login(username, password)
	}
	
	//U2(ABSTRACT USE CASE)
	
	//TODO:U3
	
	@Test
	public void testU4()
	{
		dbCont.saveUniversityToStudent(student, university);
		HashMap<String, University> temp = studentInt.viewSavedUniversities();
		Assert.assertTrue(university.getName() + " was not in the students saved schools", 
				university.equals(temp.get(university.getName())));
		
	}
	
	@Test
	public void testU4A1()
	{
		studentInt.removeUniversity(university2);
		HashMap<String, University> temp = studentInt.viewSavedUniversities();
		Assert.assertTrue("student's saved schools was not null", 
				temp.isEmpty());
		
	}
	
	//U5 View My Profile
	
	/**
	 * U5 main scenario
	 */
	@Test
	public void testU5()
	{
		String profile = studentInt.viewProfile();
		Assert.assertTrue(profile.equals(student.toString()));
	}
	
	//TODO:U6
	
	@Test
	public void testU7()
	{
		Assert.assertTrue("University did not match saved university", 
				studentInt.viewUniversity(university.getName()).equals(university));
	}
	
	//U8 Remove Specific School from Student's saved universities
	
	/**
	 * U8 main scenario
	 */
	@Test
	public void testU8()
	{
		studentInt.saveUniversity(university);
		int success = studentInt.removeUniversity(university);
		Assert.assertTrue(success == 1);
	}
	
	//U9 Edit My Profile
	
	/**
	 * U9 Main scenario
	 */
	@Test
	public void testU9()
	{
		int success = studentInt.editProfile("firstName", "lastName", "password");
		Assert.assertFalse(success == -1);
	}
	
	/**
	 * U9A1 student leaves a field blank
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testU9_A1()
	{
		int success = studentInt.editProfile("", "lastName", "password");
		Assert.assertTrue(success == -1);
	}
	
	
	
	//TODO:U10
	@Test
	public void testU10()
	{
		
	}
	
	
	//U11 Save University to student's saved universities
	
	/**
	 * U11 main scenario
	 */
	@Test
	public void testU11()
	{
		int success = studentInt.saveUniversity(university);
		Assert.assertTrue(success != -1);
	}
	
	/**
	 * U11_A1
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testU11_A1()
	{
		studentInt.saveUniversity(university2);
	}
	
	//U12(ABSTRACT USE CASE)
	
	//U13
	
	/**
	 * U13 main scenario
	 */
	@Test
	public void testU13()
	{
		HashMap<String, User> allUsers = adminInt.viewUsers();
		Assert.assertTrue(allUsers.containsKey("nadmin"));
	}
	
	//U14 View Universities
	
	/**
	 * U14 main scenario
	 */
	@Test
	public void testU14()
	{
		HashMap<String, University> allUniversities = adminInt.viewUniversities();
		Assert.assertTrue(allUniversities.containsKey("AUBURN"));
	}
	
	//TODO:U15
	
	//TODO:U16
	@Test
	public void U16Main()
	{
		University editedUniversity = new University("TestUniversity1", "WISCONSIN", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>());
		adminInt.editUniversity(university, "Wisconsin", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>());
		Assert.assertTrue("University should be equal to editedUniversity", university.equals(editedUniversity));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void U16Alternate1()
	{
		University editedUniversity = new University("TestUniversity1", "WISCONSIN", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>());
		adminInt.editUniversity(university, "Wisconsin", "", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>());
		Assert.assertTrue("University should be equal to editedUniversity", university.equals(editedUniversity));
	}
	//U17
	@Test
	public void U17Main()
	{
		adminInt.deactivate(admin);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void U17MainAlt1()
	{
		adminInt.deactivate(admin);
		adminInt.deactivate(admin);
	}
	//U18
	@Test
	public void U18Main()
	{
		Admin admin2 = new Admin("Com", "Puter", "computer", "password", 'a', true, false);
		adminInt.addUser("Com", "Puter", "computer", "password", 'a', true, false);
		HashMap<String, User> users = adminInt.viewUsers();
		Assert.assertTrue(users.get("computer").equals(admin2));
		adminInt.deleteUser("computer");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void U18MainAlt1()
	{
		
		adminInt.addUser("Com", "Puter", "cputer001", "password", 'a', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void U18MainAlt2()
	{
		adminInt.addUser("Com", "", "computer", "password", 'a', true, false);
	}
	//U19
	@Test
	public void U19Main()
	{
		Admin admin2 = new Admin("John", "Puter", "cputer001", "password", 'a', true, false);
		adminInt.editUser("cputer001", "John", "Puter", "password", 'a', true, false);
		HashMap<String, User> users = adminInt.viewUsers();
		Assert.assertTrue(users.get("cputer001").equals(admin2));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void U19Alternate()
	{
		adminInt.editUser("cputer001", "", "Tested", "newPass", 'a', true, true);
	}
	//TODO:U20
}