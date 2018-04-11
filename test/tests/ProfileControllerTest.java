package tests;

import cmcPackage.entityClasses.*;
import cmcPackage.Controllers.ProfileController;
import cmcPackage.Controllers.DBController;
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
		dbc.addUser(stud1);
		dbc.saveUniversityToStudent(stud1, (dbc.getUniversity("BOSTON UNIVERSITY")));
		pc = new ProfileController(stud1);
	}

	// @After annotation forces method to re-execute after each test method
	@After
	public void destroy(){
		dbc.deleteUser("pct");
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
	 * Test that method "editProfile" works for correct/valid firstName parameter
	 */ 
	@Test
	public void editProfileSucceedsForValidFirstNameParameterAdditional(){
		pc.editProfile("j", "Miller", "password1");
		Student edited = (Student) dbc.getUser("pct");
		Assert.assertTrue("User's firstName should be j", edited.getFirstName().equals("j"));
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
	 * Test that method "editProfile" works for correct/valid lastName parameter
	 */ 
	@Test
	public void editProfileSucceedsForValidLastNameParameterAdditional(){
		pc.editProfile("John", "m", "password1");
		Student edited = (Student) dbc.getUser("pct");
		Assert.assertTrue("User's lastName should be m", edited.getLastName().equals("m"));
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
	 * Test that method "editProfile" works for correct/valid password parameter
	 */ 
	@Test
	public void editProfileSucceedsForValidPasswordParameterAdditional(){
		pc.editProfile("John", "Miller", "p");
		Student edited = (Student) dbc.getUser("pct");
		Assert.assertTrue("User's password should be password1", edited.getPassword().equals("p"));
	}
	
	/**
	 * Test that method "editProfile" fails for empty firstName parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForEmptyFirstNameParameter(){
		pc.editProfile("", "Miller", "password1");
	}
	
	/**
	 * Test that method "editProfile" fails for empty firstName parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForEmptyFirstNameParameterAdditional(){
		pc.editProfile(" ", "Miller", "password1");
	}

	/**
	 * Test that method "editProfile" fails for empty lastName parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForEmptyLastNameParameter(){
		pc.editProfile("John", "", "password1");
	}
	
	/**
	 * Test that method "editProfile" fails for empty lastName parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForEmptyLastNameParameterAdditional(){
		pc.editProfile("John", " ", "password1");
	}

	/**
	 * Test that method "editProfile" fails for empty password parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForEmptyPasswordParameter(){
		pc.editProfile("John", "Miller", "");
	}
	
	/**
	 * Test that method "editProfile" fails for empty password parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForEmptyPasswordParameterAdditional(){
		pc.editProfile("John", "Miller", " ");
	}
	
	/**
	 * Test that method "editProfile" fails for null firstName parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForNullFirstNameParameter(){
		pc.editProfile(null, "Miller", "password1");
	}

	/**
	 * Test that method "editProfile" fails for null lastName parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForNullLastNameParameter(){
		pc.editProfile("John", null, "password1");
	}

	/**
	 * Test that method "editProfile" fails for null password parameter
	 */
	@Test (expected = IllegalArgumentException.class)
	public void editProfileFailsForNullPasswordParameter(){
		pc.editProfile("John", "Miller", null);
	}

	/**
	 * Test that method "viewProfile" works
	 */    
	@Test
	public void testViewProfile(){
		Assert.assertTrue("viewProfile() output should match Student.toString() output", pc.viewProfile().equals(stud1.toString()));
	}
}