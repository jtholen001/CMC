package Test.ControllerTests;

import entityClasses.*;
import Controllers.*;
import Interfaces.UserInterface;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
 
public class LoginControllerTest 
{
	private User user1,user2,user3;
	private LoginController loginCont;
	private UsersController uCont;
	private DBController dbCont;
	
	@Before
	public void init()
	{
		user2 = new User("New", "User", "nUser", "password", 'u', false, false);
		loginCont = new LoginController();
		uCont = new UsersController();
		uCont.addUser("Nicholas", "Tawil", "ntawil001", "password", 'u', true, false);
		uCont.addUser("New", "User", "nUser", "password", 'u', true, false);
		uCont.deactivate(user2);
		uCont.addUser("Michael", "Carroll", "mcarroll001", "password", 'a', true, true);
	}
	
	@After
	public void destroy()
	{
		uCont.deleteUser("ntawil001");
		uCont.deleteUser("nUser");
		uCont.deleteUser("mcarroll001");
	}
	
	/**
	 * Test method to test successful login
	 */
	@Test
	public void testLogin() 
	{
		user1 = loginCont.login("ntawil001", "password");
		Assert.assertNotNull(user1);
	}
	
	/**
	 * Test method to test that login fails for an invalid username
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testLoginFails_invalidUsername()
	{
		user1 = loginCont.login("badUser", "password");
	}
	
	/**
	 * Test method to test that login fails for a correct username but an incorrect password
	 */
	@Test
	public void testLoginFails_passwordDoesNotMatch()
	{
		user1 = loginCont.login("ntawil001", "password0");
		Assert.assertNull(user1);
	}
	
	/**
	 * Test method to test that login fails for a user that is deactivated
	 */
	@Test 
	public void testLoginFails_deactivatedUser()
	{
		user1 = loginCont.login("nUser", "password");
		Assert.assertNull(user1);
	}
	
	/**
	 * Test method to test logout
	 */
	@Test
	public void testLogout()
	{
		Assert.assertTrue(loginCont.logout() instanceof UserInterface);
	}
}
