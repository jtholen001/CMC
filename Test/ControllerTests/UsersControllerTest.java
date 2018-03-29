package Test.ControllerTests;

import org.junit.*;
import java.util.HashMap;
import Controllers.UsersController;
import entityClasses.User;

public class UsersControllerTest 
{
	
	UsersController uCont;

	@Before
	public void test() 
	{
		uCont = new UsersController();
		uCont.addUser("Brandan", "Kalsow", "bkalsow", "password0", 'a', true, false);
		uCont.addUser("Nicholas", "Long", "nlong", "password0", 'u', true, false);
	}
	
	@After
	public void destroy()
	{
		uCont.deleteUser("bkalsow");
		uCont.deleteUser("nlong");
	}
	
	@Test
	public void testConstructor()
	{
		Assert.assertTrue("Constructor should return a new instance of UsersController", new UsersController() instanceof UsersController);;
	}
	
	@Test
	public void viewUsersReturnsArrayListContainingAllUsers()
	{
		HashMap<String, User> users = uCont.viewUsers();
		Assert.assertTrue("List of users should contain key bkalsow", users.containsKey("bkalsow"));
		Assert.assertTrue("List of users should contain key nlong", users.containsKey("nlong"));
	}

}
