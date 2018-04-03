package Test.ControllerTests;

import entityClasses.*;
import Controllers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginControllerTest 
{
	private User user1,user2;
	private LoginController loginCont;
	private UsersController uCont;
	
	@Before
	public void init()
	{
		user2 = new User("New", "User", "nUser", "password", 'u', false, false);
		loginCont = new LoginController();
		uCont = new UsersController();
		uCont.addUser("Nicholas", "Tawil", "ntawil001", "password", 'u', true, false);
		uCont.addUser("New", "User", "nUser", "password", 'u', true, false);
		uCont.deactivate(user2);
	}
	
	@After
	public void destroy()
	{
		uCont.deleteUser("ntawil001");
		uCont.deleteUser("nUser");
	}
	
	@Test
	public void testLogin() 
	{
		user1 = loginCont.login("ntawil001", "password");
		Assert.assertNotNull(user1);
	}
	
	@Test
	public void testLoginFails_invalidUsername()
	{
		user1 = loginCont.login("badUser", "password");
		Assert.assertNull(user1);
	}
	
	@Test
	public void testLoginFails_passwordDoesNotMatch()
	{
		user1 = loginCont.login("ntawil001", "password0");
		Assert.assertNull(user1);
	}
	
	@Test
	public void testLoginFails_deactivatedUser()
	{
		user1 = loginCont.login("nUser", "password");
		Assert.assertNull(user1);
	}

}
