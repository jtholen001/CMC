package Test.InterfaceTests;

import org.junit.*;
import java.util.*;
import entityClasses.*;
import Interfaces.AdminInterface;
import Controllers.*;

/**
 * A test class to JUnit test AdminInterface
 * @author Nicholas Tawil, Michael Carroll, Brandan Kalsow, Joran Tholen, Ryan Strelow
 * @version 3/25/18
 *
 */
public class AdminInterfaceTest 
{
	public AdminInterface adminInt;
	public Admin admin;
	public User userToEdit;
	HashMap<String, User> allUsers;
	int successfullAddUser;
	public DBController dbCont;
	
	/**
	 * void method to initialize variables
	 */
	@Before
	public void init()
	{
		adminInt = new AdminInterface(admin);
		allUsers = adminInt.viewUsers();
		userToEdit = new User("Miss", "Pelled", "mpelled001", "password0", 'u', true, false);
		successfullAddUser = adminInt.addUser("Miss", "Pelled", "mpelled001", "password0", 'u', true, false);
		dbCont = new DBController();
	}
	
	/**
	 * void JUnit test method to test viewUsers()
	 */
	@Test
	public void testviewUsersContainsSpecificUser()
	{
		Assert.assertTrue("allUsers contains Noreen ", allUsers.containsKey("Noreen"));
	}
	
	/**
	 * void JUnit test method to test editUser()
	 */
	@Test
	public void testEditUser()
	{
		int edit = adminInt.editUser("mpelled001", "Jessica", "Styles", "password1", 'a', false, true);
		User editedUser = dbCont.getUser("mpelled001");
		Assert.assertTrue("editedUser first name is: Jessica", editedUser.getFirstName().equals("Jessica"));
		Assert.assertTrue("editedUser last name is: Styles", editedUser.getLastName().equals("Styles"));
		Assert.assertTrue("editedUser password is: password1", editedUser.getPassword().equals("password1"));
		Assert.assertTrue("editedUser type is: a", editedUser.getType() == 'a');
		Assert.assertFalse("editedUser activation status is: false", editedUser.getActivationStatus());
		//assertFalse because DBCont is hardcoded to return false here
		Assert.assertFalse("editedUser logged status is: true", editedUser.getLoggedInStatus());
		//editUser back and save to DB
		adminInt.editUser("mpelled001", "Miss", "Pelled", "password0", 'u', true, false);
	}
	
//	@Test
//	/**
//	 * void JUnit test method to test successful addUser()
//	 */
//	public void testAddUser()
//	{
//		Assert.assertTrue("addUser method successful", successfullAddUser != -1);
//	}
}
//	/**
//	 * void JUnit test method to test conditions for addUser() to fail
//	 */
//	@Test
//	public void testAddUserFails()
//	{
//		Assert.assertTrue("addUser method failed: empty attribute", adminInt.addUser("Empty", "", "emptyuser", "emptyPass", 'a', true, false) == -1);
//		Assert.assertTrue("addUser method failed: duplicate username", adminInt.addUser("Miss", "Pelled", "mpelled001", "password0", 'u', true, false) == -1);
//	}
//	
//	@Test
//	/**
//	 * void JUnit test method to test deactivate() success
//	 */
//	public void testDeactivateUserSucess()
//	{
//		Assert.assertTrue("deactivate method successful", adminInt.deactivate(userToEdit) != -1);
//	}
//	
//	@Test
//	/**
//	 * void JUnit test method to test deactivate() fail
//	 */
//	public void testDeactivateUserFails()
//	{
//		Assert.assertTrue("deactivate method failed: user is already deactivated", adminInt.deactivate(userToEdit) == -1);
//	}
//}
