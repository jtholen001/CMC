package Test.FunctionalTests;

<<<<<<< HEAD
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
=======
import entityClasses.*;


import java.util.HashMap;
import org.junit.*;

>>>>>>> e783eb32a5a1cc20ab061fe0ae8c3f8cc813ef33

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
	}
	
	@After
	public void destroy()
	{
		dbCont.deleteUser("cputer001");
		dbCont.deleteUser("culator001");
	}
	//TODO:U1 Login
	/**
	 * u1 main scenario
	 */
	@Test
	public void testU1()
	{
		adminInt.login(username, password)
	}
	
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