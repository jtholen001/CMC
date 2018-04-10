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
	private University university;
	
	
	/**
	 * Init method
	 */
	@Before
	public void init()
	{
		admin = new Admin("Com", "Puter", "cputer001", "password", 'a', true, false);
		student = new Student("Calc", "Ulator", "culator001", "password", 'u', true, false, new ArrayList<University>());
		university = new University("UNIVERSITY OF CMC", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		dbCont = new DBController();
		dbCont.addUser(admin);
		dbCont.addUser(student);
		dbCont.addUniversity(university);
		adminInt = new AdminInterface(admin);
		studentInt = new StudentInterface(student);
		userInt = new UserInterface();
	}
	
	@After
	public void destroy()
	{
		dbCont.deleteUser("cputer001");
		dbCont.deleteUser("culator001");
		dbCont.deleteUniversity(university);
	}
	//TODO:U1 Login
	/**
	 * u1 main scenario
	 */
	@Test
	public void testU1()
	{
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
		HashMap<String, University> temp = studentInt.viewSavedUniversities();
		Assert.assertTrue("student's saved schools was not null", 
				temp.isEmpty());
		
	}
	
	//TODO:U5
	
	//TODO:U6
	
	//TODO:U7
	
	//TODO:U8
	
	//TODO:U9
	
	//TODO:U10
	
	//TODO:U11
	
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