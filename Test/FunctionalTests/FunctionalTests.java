package Test.FunctionalTests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entityClasses.*;

import java.util.ArrayList;
import java.util.HashMap;
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
		student = new Student("Calc", "Ulator", "culator001", "password", 'u', true, false, null);
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
		dbCont.removeAllUniversitiesFromStudent(student);
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
	@Test (expected = IllegalArgumentException.class)
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
	}
	
	//U2(ABSTRACT USE CASE)
	
	//TODO:U3
	
	//TODO:U4
	
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
	
	//TODO:U7
	
	//U8 Remove Specific School from Student's saved universities
	
	/**
	 * U8 main scenario
	 */
	@Test
	public void testU8()
	{
		studentInt.saveUniversity(university);
		int success = studentInt.removeUniversity(university);
		dbCont.removeUniversityFromStudent(student, university);
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
	@Test
	public void testU9_A1()
	{
		int success = studentInt.editProfile("", "lastName", "password");
		Assert.assertTrue(success == -1);
	}
	
	
	
	//TODO:U10
	
	
	
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
	
	//TODO:U13
	
	//TODO:U14
	
	//TODO:U15
	
	//TODO:U16
	
	//TODO:U17
	
	//TODO:U18
	
	//TODO:U19
	@Test
	public void U19Main()
	{
		UsersController uC = new UsersController();
		Admin test = new Admin("John", "Tested", "test", "newPass", 'a', true, false);
		uC.addUser("Andy", "Tester", "test", "password", 'u', true, false);
		uC.editUser("test", "John", "Tested", "newPass", 'a', true, true);
		HashMap<String, User> users = uC.viewUsers();
		Assert.assertTrue(users.get("test").equals(test));
		uC.deleteUser("test");
	}
	//TODO:U20
}