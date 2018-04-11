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
	private University university, university2, searchUniversity1, searchUniversity2, u1, u2, u3, u4, u5, u6, u7, u8, u9, u10, u11, u12, u13;

	
	
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
		university = new University("University 1", "Minnesota", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>() );
		university2 = new University("University 2", "IOWA", "SUBURBAN", "PRIVATE", 5000, 65.0, 600, 800, 15000, 50, 25000, 50, 40, 2, 1, 4, new ArrayList<String>() );
		dbCont.addUniversity(university2);
		studentInt.saveUniversity(university2);
		dbCont.addUniversity(university);

		//Used for searching and recommendedUniversities
		ArrayList<String> emphases = new ArrayList<String>();
		emphases.add("MATH");
		
		ArrayList<String> emphases2 = new ArrayList<String>();	
		emphases2.add("BUSINESS");
		emphases2.add("MATH");
		//Used for testing search
		searchUniversity1 = new University("SEARCH UNIVERSITY 1", "MINNESOTA", "URBAN", "PRIVATE", 100, 10.0, 100, 100, 100, 10, 100, 10, 10, 1, 1, 1, emphases );
		searchUniversity2 = new University("SEARCH UNIVERSITY 2", "WISCONSIN", "RURAL", "PUBLIC", 1000, 100.0, 800, 800, 1000, 100, 1000, 100, 100, 5, 5, 5, new ArrayList<String>() );

		//used for testing getRecommendedUniversities
		u1 = new University("TEST UNIVERSITY 1", "MINNESOTA", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, emphases2 );
		u2 = new University("TEST UNIVERSITY 2", "MINNESOTA", "URBAN", "PRIVATE", 5000, 65.0, 701, 600, 40000, 50, 49000, 31, 25, 4, 3, 2, emphases );
		u3 = new University("TEST UNIVERSITY 3", "MINNESOTA", "URBAN", "PRIVATE", 5000, 54.0, 702, 601, 39000, 51, 48000, 32, 40, 3, 4, 2, emphases );
		u4 = new University("TEST UNIVERSITY 4", "MINNESOTA", "URBAN", "PRIVATE", 5000, 53.0, 703, 602, 38000, 52, 47000, 33, 40, 2, 4, 3, emphases );
		u5 = new University("TEST UNIVERSITY 5", "MINNESOTA", "URBAN", "PRIVATE", 5000, 62.0, 704, 603, 37000, 53, 46000, 34, 40, 1, 5, 4, emphases2 );
		u6 = new University("TEST UNIVERSITY 6", "IOWA", "URBAN", "PRIVATE", 5000, 63.0, 705, 604, 36000, 54, 45000, 35, 40, 4, 5, 5, emphases );

		u7 = new University("TEST UNIVERSITY 7", "MONTANA", "RURAL", "PUBLIC", 1000, 90, 700, 550, 40200, 45, 21000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u8 = new University("TEST UNIVERSITY 8", "-1", "RURAL", "PUBLIC", 900, 88, 700, 550, 40200, 45, 20000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u9 = new University("TEST UNIVERSITY 9", "MONTANA", "-1", "PUBLIC", 800, 86, 700, 550, 40000, 40, 20000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u10 = new University("TEST UNIVERSITY 10", "MONTANA", "RURAL", "-1", 700, 86, 700, 550, 40000, 40, 22000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u11 = new University("TEST UNIVERSITY 11", "MONTANA", "RURAL", "PUBLIC", -1, 85, 700, 550, 40000, 39, 22000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u12 = new University("TEST UNIVERSITY 12", "MONTANA", "RURAL", "PUBLIC", 600, 85, 700, 550, 40500, 38, 23000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u13 = new University("TEST UNIVERSITY 13", "-1", "-1", "-1", -1, 85, 700, 550, 40500, 38, 23000, 30, 20, 1, 5, 4, new ArrayList<String>());

		dbCont.addUniversity(u1);
		dbCont.addUniversity(u2);
		dbCont.addUniversity(u3);
		dbCont.addUniversity(u4);
		dbCont.addUniversity(u5);
		dbCont.addUniversity(u6);		
		dbCont.addUniversity(u7);
		dbCont.addUniversity(u8);
		dbCont.addUniversity(u9);
		dbCont.addUniversity(u10);
		dbCont.addUniversity(u11);
		dbCont.addUniversity(u12);
		dbCont.addUniversity(searchUniversity1);
		dbCont.addUniversity(searchUniversity2);
	}
	
	@After
	public void destroy()
	{
		dbCont.deleteUser("cputer001");
		dbCont.deleteUser("culator001");
		dbCont.deleteUniversity(university);
		dbCont.deleteUniversity(university2);
		
		dbCont.deleteUniversity(u1);
		dbCont.deleteUniversity(u2);
		dbCont.deleteUniversity(u3);
		dbCont.deleteUniversity(u4);
		dbCont.deleteUniversity(u5);
		dbCont.deleteUniversity(u6);
		dbCont.deleteUniversity(u7);
		dbCont.deleteUniversity(u8);
		dbCont.deleteUniversity(u9);
		dbCont.deleteUniversity(u10);
		dbCont.deleteUniversity(u11);
		dbCont.deleteUniversity(u12);
		dbCont.deleteUniversity(searchUniversity1);
		dbCont.deleteUniversity(searchUniversity2);
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
	
	//U3(Search for Schools	
	@Test
	public void testU3()
	{
		ArrayList<String> emphases = new ArrayList<String>();
		emphases.add("MATH");
		ArrayList<University> foundUniversities = studentInt.searchUniversities("SEARCH", "MIN", "URBAN", "PRIVATE", 50, 150, 5, 15, 50, 100, 50, 100, 50, 100, 5, 15, 50, 100, 5, 15, 5, 15, 1, 3, 1, 3, 1, 3, emphases);
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));	
	}
	
	@Test (expected = InputMismatchException.class)
	public void testU3_A1()
	{
		studentInt.searchUniversities("", "", "", "", 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, new ArrayList<String>());	
	}
		
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
	
	@Test
	public void testU6()
	{
		ArrayList<String> emphases = new ArrayList<String>();
		emphases.add("MATH");
		ArrayList<University> foundUniversities =studentInt.searchUniversities("TEST", "MINNESOTA", "URBAN", "PRIVATE", 2000, 100000, 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,emphases);
		HashMap<String, University> formattedUniversities = studentInt.viewUniversities(foundUniversities);
		Assert.assertTrue("First University should be TEST UNIVERSITY 1", formattedUniversities.get(u1.getName()).equals(u1));	
		Assert.assertTrue("First University should be TEST UNIVERSITY 2", formattedUniversities.get(u2.getName()).equals(u2));
		Assert.assertTrue("First University should be TEST UNIVERSITY 3", formattedUniversities.get(u3.getName()).equals(u3));
		Assert.assertTrue("First University should be TEST UNIVERSITY 4", formattedUniversities.get(u4.getName()).equals(u4));		
		Assert.assertTrue("First University should be TEST UNIVERSITY 5", formattedUniversities.get(u5.getName()).equals(u5));
		Assert.assertTrue("Size of viewed Universites should be 5", formattedUniversities.size() == 5);
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
	@Test
	public void U15Main()
	{
		University U15 = new University("U15 University", "Minnesota", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>() );
		adminInt.addUniversity("U15 University", "Minnesota", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>() );
		HashMap<String, University> universities = adminInt.viewUniversities();
		Assert.assertTrue("University should be in the database", universities.containsValue(U15));
		adminInt.deleteUniversity(U15);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void U15Alt1()
	{
		
		adminInt.addUniversity("TestUniversity1", "Minnesota", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>() );
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void U15Alt2()
	{
		
		adminInt.addUniversity("", "Minnesota", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>() );
	}
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
		University editedUniversity = new University("UNIVERSITY1", "WISCONSIN", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, new ArrayList<String>());
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