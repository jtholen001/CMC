package Test.FunctionalTests;

import entityClasses.*;

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
	
	/**
	 * Init method
	 */
	@Before
	public void init()
	{
		
	}
	//TODO:U1
	
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