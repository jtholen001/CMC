package Test.ControllerTests;

import org.junit.*;
import java.util.*;
import Controllers.UsersController;
import entityClasses.*;

public class UsersControllerTest 
{
	
	UsersController uCont;
	Student student1;

	@Before
	public void test() 
	{
		uCont = new UsersController();
		student1 = new Student("Brandan", "Kalsow", "bkalsow", "password0", 'a', true, false, new ArrayList<University>());
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
	
	@Test
	public void editUserSucceedsForValidParams()
	{
		Student student = new Student("Brian", "Coleslaw", "bkalsow", "abcde", 'u', false, false, new ArrayList<University>());
		uCont.editUser("bkalsow", "Brian", "Coleslaw", "abcde", 'u', false, false);
		HashMap<String, User> users = uCont.viewUsers();
		Assert.assertTrue("Users should match: ", users.get("bkalsow").equals(student));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void editUserFailsForInvalidUserName()
	{
		uCont.editUser("", "Brian", "Coleslaw", "abcde", 'u', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void editUserFailsForInvalidFirstName()
	{
		uCont.editUser("bkalsow", "", "Coleslaw", "abcde", 'u', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void editUserFailsForInvalidLastName()
	{
		uCont.editUser("bkalsow", "Brian", "", "abcde", 'u', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void editUserFailsForInvalidPassword()
	{
		uCont.editUser("bkalsow", "Brian", "Coleslaw", "", 'u', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void editUserFailsForInvalidType()
	{
		uCont.editUser("bkalsow", "Brian", "Coleslaw", "abcde", ' ', true, false);
	}
	
	@Test
	public void addUserSucceedsForValidInput()
	{
		uCont.addUser("Michael", "Carroller", "carols", "none", 'u', true, false);
		uCont.deleteUser("carols");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addUserFailsForInvalidFirstName()
	{
		uCont.addUser("", "Carroller", "carols", "none", 'u', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addUserFailsForInvalidLastName()
	{
		uCont.addUser("Michael", "", "carols", "none", 'u', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addUserFailsForInvalidUsername()
	{
		uCont.addUser("Michael", "Carroller", "", "none", 'u', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addUserFailsForInvalidPassword()
	{
		uCont.addUser("Michael", "Carroller", "carols", "", 'u', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addUserFailsForInvalidType()
	{
		uCont.addUser("Michael", "Carroller", "carols", "none", 'z', true, false);
	}
	
	@Test
	public void deactivateUserSucceeds()
	{
		uCont = new UsersController();
		uCont.deactivate(student1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void deactivateUserFailsForDeactivatedUser()
	{
		uCont = new UsersController();
		uCont.deactivate(student1);
		uCont.deactivate(student1);
	}
	
	@Test
	public void deleteUserSucceedsForUserInDatabase()
	{
		uCont.addUser("Michael", "Carroller", "carols", "none", 'u', true, false);
		uCont.deleteUser("carols");
	}

}
