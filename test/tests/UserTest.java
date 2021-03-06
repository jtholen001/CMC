package tests;

import cmcPackage.entityClasses.*;

import java.util.ArrayList;

import org.junit.*;

/**
 * for JUnit testing of User.java
 * 
 * @author Michael Carroll
 * @version 04/04/18
 */
public class UserTest{
	private User user1, user2, user3;

	// @Before annotation forces method to re-execute before each test method
	@Before
	public void init(){ 
		user1 = new User("Johnnie", "Cash", "jcash", "password1", 'a', true, false);
		user2 = new User("Johnnie", "Miller", "jmill", "password1", 'a', true, false);
	}

	/**
	 * Test that the default constructor works for correct/valid parameters
	 */     
	@Test
	public void constructorSucceedsForValidInput() {
		Assert.assertTrue("Constructor should succeed for user as all fields meet constructor criteria",
				new User("John","Miller","jmill", "password0", 'u', true, false) instanceof User);
		Assert.assertTrue("Constructor should succeed for user as all fields meet constructor criteria",
				new User("j","m","jm", "p", 'a', false, true) instanceof User);
	}
	
	/**
	 * Test that the default constructor fails for empty firstName parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidFirstName() {
		new User("", "miller","jmill", "password0", 'u', true, false);
	}
	
	/**
	 * Test that the default constructor fails for empty firstName parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidFirstNameAdditional() {
		new User(" ", "miller","jmill", "password0", 'u', true, false);
	}

	/**
	 * Test that the default constructor fails for empty lastName parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidLastName() {
		new User("John", "","jmill", "password0", 'u', true, false);
	}
	
	/**
	 * Test that the default constructor fails for empty lastName parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidLastNameAdditional() {
		new User("John", " ","jmill", "password0", 'u', true, false);
	}

	/**
	 * Test that the default constructor fails for empty username parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidUsername() {
		new User("John","Miller", "", "password0", 'u', true, false);
	}
	
	/**
	 * Test that the default constructor fails for empty username parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidUsernameAdditional() {
		new User("John","Miller", " ", "password0", 'u', true, false);
	}

	/**
	 * Test that the default constructor fails for empty password parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidPassword() {
		new User("John","Miller", "jmill", "", 'u', true, false);
	}
	
	/**
	 * Test that the default constructor fails for empty password parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidPasswordAdditional() {
		new User("John","Miller", "jmill", " ", 'u', true, false);
	}
	
	/**
	 * Test that the default constructor fails for invalid type
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidType() {
		new User("John","Miller", "jmill", "password0", 'q', true, false);
	}
	
	/**
	 * Test that the default constructor fails for invalid type
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidTypeAlternate() {
		new User("John","Miller", "jmill", "password0", (char) 0, true, false);
	}
	
	/**
	 * Test that the default constructor fails for null firstName parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForNullFirstName() {
		new User(null,"Miller","jmill", "password0", 'u', true, false);
	}

	/**
	 * Test that the default constructor fails for null lastName parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForNullLastName() {
		new User("John", null, "jmill", "password0", 'u', true, false);
	}

	/**
	 * Test that the default constructor fails for null username parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForNullUsername() {
		new User("John", "Miller", null, "password0", 'u', true, false);
	}

	/**
	 * Test that the default constructor fails for null password parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForNullPassword() {
		new User("John","Miller","jmill", null, 'u', true, false);
	}

	/**
	 * Test that the getUser() method returns expected value
	 */
	@Test
	public void testGetFirstName(){
		String expected = "Johnnie";
		Assert.assertTrue("Should return \"Johnnie\" for firstName variable", user1.getFirstName().equals(expected));
	}

	/**
	 * Test that the setUser() method sets correctly
	 */
	@Test
	public void testSetFirstName(){
		String newFirstName = "John";
		user1.setFirstName(newFirstName);
		Assert.assertTrue("Should return new name \"John\" for firstName variable", user1.getFirstName().equals(newFirstName));
	
		newFirstName = "j";
		user1.setFirstName(newFirstName);
		Assert.assertTrue("Should return new name \"j\" for firstName variable", user1.getFirstName().equals(newFirstName));
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
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetFirstNameFailsForEmptyParameterAlternate(){
		String newFirstName = " ";
		user1.setFirstName(newFirstName);
	}
	
	/**
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetFirstNameFailsForNullParameter(){
		String newFirstName = null;
		user1.setFirstName(newFirstName);
	}

	/**
	 * Test method for {@link entityClasses.User#getLastName()}.
	 */
	@Test
	public final void testGetLastName() {
		String expected = "Cash";
		Assert.assertTrue("Should return \"Cash\" for lastName variable", user1.getLastName().equals(expected));
	}

	/**
	 * Test method for {@link entityClasses.User#setLastName(java.lang.String)}.
	 */
	@Test
	public final void testSetLastName() {
		String newLastName = "Miller";
		user1.setLastName(newLastName);
		Assert.assertTrue("Should return new name \"Miller\" for lastName variable", user1.getLastName().equals(newLastName));
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
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetLastNameFailsForEmptyParameterAlternate(){
		String newLastName = " ";
		user1.setLastName(newLastName);
	}
	
	/**
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetLastNameFailsForNullParameter(){
		String newLastName = null;
		user1.setLastName(newLastName);
	}

	/**
	 * Test method for {@link entityClasses.User#getUsername()}.
	 */
	@Test
	public void testGetUsername(){
		String expected = "jcash";
		Assert.assertTrue("Should return \"jcash\" for username variable", user1.getUsername().equals(expected));
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
		newPassword = "p";
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
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetPasswordFailsForEmptyParameterAlternate(){
		String newPassword = " ";
		user1.setFirstName(newPassword);
	}
	
	/**
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetPasswordFailsForNullParameter(){
		String newPassword = null;
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
		newType = 'a';
		user1.setType(newType);
		Assert.assertTrue("Should return new type \'a\' for type variable", user1.getType() == newType);
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
	 * Test method for {@link entityClasses.User#setFirstName(java.lang.String)}.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testSetTypeForInvalidParameterZero(){
		char newType = (char) 0;
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
		newActivationStatus = true;
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
		newLoggedInStatus = false;
		user1.setLoggedInStatus(newLoggedInStatus);
		Assert.assertTrue("Should return new false for isLoggedIn variable", user1.getLoggedInStatus() == newLoggedInStatus);
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
	 * Test that equals method works with equal objects
	 */
	@Test
	public void testEqualsTrue(){
		user3 = this.user2;
		Assert.assertTrue("Should return true as objects are equal", user2.equals(user3));
	}
	
	/**
	 * Test that equals method fails at first if statement (not instanceof user)
	 */
	@Test
	public void testEqualsFalseNotInstance(){
		boolean randomUnrelatedObject = false;
		Assert.assertFalse("Should return false as objects are of different types", user2.equals(randomUnrelatedObject));
	}
	
	/**
	 * Test that equals method fails at second if statement (usernames not equal)
	 */
	@Test
	public void testEqualsFalseDifferentUsernames(){
		user3 = new User("Johnnie", "Miller", "mjill", "password1", 'a', true, false);
		Assert.assertFalse("Should return false as objects have different usernames", user2.equals(user3));
	}
	
	/**
	 * Test that equals method fails at third if statement (firstNames not equal)
	 */
	@Test
	public void testEqualsFalseDifferentFirstNames(){
		user3 = new User("John", "Miller", "jmill", "password1", 'a', true, false);
		Assert.assertFalse("Should return false as objects have different firstNames", user2.equals(user3));
	}
	
	/**
	 * Test that equals method fails at fourth if statement (lastNames not equal)
	 */
	@Test
	public void testEqualsFalseDifferentLastNames(){
		user3 = new User("Johnnie", "Killer", "jmill", "password1", 'a', true, false);
		Assert.assertFalse("Should return false as objects have different lastNames", user2.equals(user3));
	}
	
	/**
	 * Test that equals method fails at fifth if statement (passwords not equal)
	 */
	@Test
	public void testEqualsFalseDifferentPassword(){
		user3 = new User("Johnnie", "Miller", "jmill", "password0", 'a', true, false);
		Assert.assertFalse("Should return false as objects have different passwords", user2.equals(user3));
	}
	
	/**
	 * Test that equals method fails at sixth if statement (types not equal)
	 */
	@Test
	public void testEqualsFalseDifferentType(){
		user3 = new User("Johnnie", "Miller", "jmill", "password1", 'u', true, false);
		Assert.assertFalse("Should return false as objects have different types", user2.equals(user3));
	}
}