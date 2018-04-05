package Test.ControllerTests;

import entityClasses.*;
import Controllers.ProfileController;
import Controllers.DBController;
import org.junit.*;
import java.util.*;

/**
 * for JUnit testing of ProfileControllerTest.java
 * 
 * @author Michael Carroll
 * @version 04/04/18
 */
public class ProfileControllerTest{
	private ProfileController pc;
	private DBController dbc;
	private Student stud1;

	// @Before annotation forces method to re-execute before each test method
	@Before
	public void init(){ 
		stud1 = new Student("ProfileControllerTest", "lastName", "pct", "password", 'u', true, false, new ArrayList<University>());
		dbc = new DBController();
//		stud1.addSchool(dbc.getUniversity("BOSTON UNIVERSITY"));
		dbc.addUser(stud1);
		pc = new ProfileController(stud1);
	}

	// @After annotation forces method to re-execute after each test method
	@After
	public void destroy(){
		dbc.deleteUser("pct");
	}

	/**
	 * Test that the default constructor works for correct/valid parameters
	 */ 
	@Test
	public void constructorSucceedsForValidInput(){
		stud1 = new Student("ProfileControllerTest", "lastName", "pct", "password", 'u', true, false, new ArrayList<University>());
		dbc = new DBController();
		dbc.addUser(stud1);
		Assert.assertTrue("Constructor should succeed for ProfileController as all fields meet constructor criteria",
				new ProfileController(stud1) instanceof ProfileController);
	}

	/**
	 * Test that method "editProfile" works for correct/valid firstName parameter
	 */ 
	@Test
	public void editProfileSucceedsForValidFirstNameParameter(){
		pc.editProfile("John", "Miller", "password1");
		Student edited = (Student) dbc.getUser("pct");
		Assert.assertTrue("User's firstName should be John", edited.getFirstName().equals("John"));
	}
	
	/**
	 * Test that method "editProfile" works for correct/valid lastName parameter
	 */ 
	@Test
	public void editProfileSucceedsForValidLastNameParameter(){
		pc.editProfile("John", "Miller", "password1");
		Student edited = (Student) dbc.getUser("pct");
		Assert.assertTrue("User's lastName should be Miller", edited.getLastName().equals("Miller"));
	}
	
	/**
	 * Test that method "editProfile" works for correct/valid password parameter
	 */ 
	@Test
	public void editProfileSucceedsForValidPasswordParameter(){
		pc.editProfile("John", "Miller", "password1");
		Student edited = (Student) dbc.getUser("pct");
		Assert.assertTrue("User's password should be password1", edited.getPassword().equals("password1"));
	}
	
	/**
	 * Test that method "editProfile" fails for empty firstName parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForEmptyFirstNameParameter(){
		pc.editProfile("", "Miller", "password1");
	}

	/**
	 * Test that method "editProfile" fails for empty lastName parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForEmptyLastNameParameter(){
		pc.editProfile("John", "", "password1");
	}

	/**
	 * Test that method "editProfile" fails for empty password parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForEmptyPasswordParameter(){
		pc.editProfile("John", "Miller", "");
	}

	/**
	 * Test that method "viewProfile" works
	 */    
	@Test
	public void testViewProfile(){
		Assert.assertTrue("viewProfile() output should match Student.toString() output", pc.viewProfile().equals(stud1.toString()));
	}
}