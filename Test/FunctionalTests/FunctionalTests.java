package Test.FunctionalTests;

import entityClasses.*;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.*;


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
	
	
	/**
	 * Init method
	 */
	@Before
	public void init()
	{
		admin = new Admin("Com", "Puter", "cputer001", "password", 'a', true, false);
		student = new Student("Calc", "Ulator", "culator001", "password", 'u', true, false, new ArrayList<University>());
		adminInt = new AdminInterface(admin);
		studentInt = new StudentInterface(student);
		userInt = new UserInterface();
	}
	//TODO:U1 Login
	//@Test
	//public void testU1()
	//{
		//Assert.assertTrue(true);
//	}
	
	//U2(ABSTRACT USE CASE)
	
	//TODO:U3
	
	//TODO:U4
	
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
		Admin control = new Admin("Noreen", "Admin", "nadmin", "admin", 'a', true, true);
		AdminInterface aI = new AdminInterface(control);
		Admin test = new Admin("John", "Tested", "test", "newPass", 'a', true, false);
		aI.addUser("Andy", "Tester", "test", "password", 'a', true, false);
		aI.editUser("test", "John", "Tested", "newPass", 'a', true, true);
		HashMap<String, User> users = aI.viewUsers();
		Assert.assertTrue(users.get("test").equals(test));
		aI.deleteUser("test");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void U19Alternate()
	{
		Admin control = new Admin("Noreen", "Admin", "nadmin", "admin", 'a', true, true);
		AdminInterface aI = new AdminInterface(control);
		Admin test = new Admin("John", "Tested", "test", "newPass", 'a', true, false);
		aI.addUser("Andy", "Tester", "test", "password", 'a', true, false);
		aI.editUser("test", "", "Tested", "newPass", 'a', true, true);
		aI.deleteUser("test");
		HashMap<String, User> users = aI.viewUsers();
		Assert.assertTrue(users.get("test").equals(test));
		
	}
	//TODO:U20
}