package Test.EntityTests;

import entityClasses.*;
import org.junit.*;

/**
 * for JUnit testing of ProfileController.java
 */

public class UserTest{
	private User user1;

	// @Before annotation forces method to re-execute before each test method
	@Before
	public void init(){ 
		user1 = new User("Johnnie", "Miller", "jmill", "password1", 'a', true, false);
	}

	@Test
	public void constructorSucceedsForValidInput() {
		Assert.assertTrue("Constructor should succeed for user as all fields meet constructor criteria",
				new User("John","Miller","jmill", "password0", 'u', true, false) instanceof User);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidFirstName() {
		new User("", "miller","jmill", "password0", 'u', true, false);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidLastName() {
		new User("John", "","jmill", "password0", 'u', true, false);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidUsername() {
		new User("John","Miller", "", "password0", 'u', true, false);
	}

	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidPassword() {
		new User("John","Miller", "jmill", "", 'u', true, false);
	}

	/**
	 * Test method for {@link entityClasses.User#getFirstName()}.
	 */
	@Test
	public void testGetFirstName(){
		String expected = "Johnnie";
		Assert.assertTrue("Should return \"Johnnie\" for firstName variable", user1.getFirstName().equals(expected));
	}

	/**
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test
	public void testSetFirstName(){
		String newFirstName = "John";
		user1.setFirstName(newFirstName);
		Assert.assertTrue("Should return new name \"John\" for firstName variable", user1.getFirstName().equals(newFirstName));
	}
	
	/**
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetFirstNameFailsForEmptyParameter(){
		String newFirstName = "";
		user1.setFirstName(newFirstName);
	}

	/**
	 * Test method for {@link entityClasses.User#getLastName()}.
	 */
	@Test
	public final void testGetLastName() {
		String expected = "Miller";
		Assert.assertTrue("Should return \"Miller\" for lastName variable", user1.getLastName().equals(expected));
	}

	/**
	 * Test method for {@link entityClasses.User#setLastName(java.lang.String)}.
	 */
	@Test
	public final void testSetLastName() {
		String newLastName = "Cash";
		user1.setLastName(newLastName);
		Assert.assertTrue("Should return new name \"Cash\" for lastName variable", user1.getLastName().equals(newLastName));
	}
	
	/**
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetLastNameFailsForEmptyParameter(){
		String newLastName = "";
		user1.setLastName(newLastName);
	}

	/**
	 * Test method for {@link entityClasses.User#getUsername()}.
	 */
	@Test
	public void testGetUsername(){
		String expected = "jmill";
		Assert.assertTrue("Should return \"jmill\" for username variable", user1.getUsername().equals(expected));
	}

	/**
	 * Test method for {@link entityClasses.User#getPassword()}.
	 */
	@Test
	public void testGetPassword(){
		String expected = "password1";
		Assert.assertTrue("Should return \"password1\" for password variable", user1.getPassword().equals(expected));
	}

	/**
	 * Test method for {@link entityClasses.User#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPassword(){
		String newPassword = "password0";
		user1.setPassword(newPassword);
		Assert.assertTrue("Should return new password \"password0\" for password variable", user1.getPassword().equals(newPassword));
	}
	
	/**
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetPasswordFailsForEmptyParameter(){
		String newPassword = "";
		user1.setFirstName(newPassword);
	}

	/**
	 * Test method for {@link entityClasses.User#getType()}.
	 */
	@Test
	public void testGetType(){
		char expected = 'a';
		Assert.assertTrue("Should return \'a\' for type variable", user1.getType() == expected);
	}

	/**
	 * Test method for {@link entityClasses.User#setType(char)}.
	 */
	@Test
	public void testSetType(){
		char newType = 'u';
		user1.setType(newType);
		Assert.assertTrue("Should return new type \'u\' for type variable", user1.getType() == newType);
	}
	
	/**
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetTypeForInvalidParameter(){
		char newType = 'q';
		user1.setType(newType);
	}

	/**
	 * Test method for {@link entityClasses.User#getActivationStatus()}.
	 */
	@Test
	public void testGetActivationStatus(){
		boolean expected = true;
		Assert.assertTrue("Should return true for activationStatus variable", user1.getActivationStatus() == expected);
	}

	/**
	 * Test method for {@link entityClasses.User#setActivationStatus(boolean)}.
	 */
	@Test
	public void testSetActivationStatus(){
		boolean newActivationStatus = false;
		user1.setActivationStatus(newActivationStatus);
		Assert.assertTrue("Should return new password false for activationStatus variable", user1.getActivationStatus() == newActivationStatus);
	}

	/**
	 * Test method for {@link entityClasses.User#getLoggedInStatus()}.
	 */
	@Test
	public void testGetLoggedInStatus(){
		boolean expected = false;
		Assert.assertTrue("Should return true for isActivated variable", user1.getLoggedInStatus() == expected);
	}

	/**
	 * Test method for {@link entityClasses.User#setLoggedInStatus(boolean)}.
	 */
	@Test
	public void testSetLoggedInStatus(){
		boolean newLoggedInStatus = true;
		user1.setLoggedInStatus(newLoggedInStatus);
		Assert.assertTrue("Should return new true for isLoggedIn variable", user1.getLoggedInStatus() == newLoggedInStatus);
	}

	/**
	 * Test method for {@link entityClasses.User#toString()}.
	 */
	@Test
	public void testToString(){
		String expected = ("First name: " + user1.getFirstName() +
				"\nLast name: " + user1.getLastName() +
				"\nUsername: " + user1.getUsername() +
				"\nType: " + user1.getType() +
				"\nActivated: " + user1.getActivationStatus() +
				"\nLoggedInStatus: " + user1.getLoggedInStatus());
		Assert.assertTrue("Should return toString matching toString in User entity", user1.toString().equals(expected));
	}

	/**
	 * Test method for {@link entityClasses.User#equals(java.lang.Object)}.
	 */
	@Test
	public void testEquals(){
		//TODO: white box testing? if statements?
	}
}