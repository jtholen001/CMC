package Test.EntityTests;
import org.junit.*;
import entityClasses.*;

/**
 * for JUnit testing of Admin.java
 * 
 * @author Michael Carroll
 * @version 04/04/18
 */
public class AdminTest {
	/**
	 * Test that the default constructor works for correct/valid parameters
	 */    
	@Test
	public void constructorSucceedsForValidInput() {
		Assert.assertTrue("Constructor should succeed for admin as all fields meet constructor criteria", 
				new Admin("John","Miller","jmill", "password0", 'a', true, false) instanceof Admin);
	}
	
	/**
	 * Test that the default constructor fails for empty firstName parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForEmptyFirstNameParameter() {
		new Admin("", "miller","jmill", "password0",'a', true, false);
}

	/**
	 * Test that the default constructor fails for empty lastName parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForEmptyLastNameParameter() {
		new Admin("John", "","jmill", "password0", 'a', true, false);
	}
	
	/**
	 * Test that the default constructor fails for empty username parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForEmptyUsernameParameter() {
		new Admin("John","Miller", "", "password0", 'a', true, false);
	}
	
	/**
	 * Test that the default constructor fails for empty password parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForEmptyPasswordParameter() {
		new Admin("John","Miller", "jmill", "", 'a', true, false);
	}

	/**
	 * Test that the default constructor fails for invalid type parameter
	 */   
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidType() {
		new Admin("John","Miller", "jmill", "password0", 'q', true, false);
	}
}