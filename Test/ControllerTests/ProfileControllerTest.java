package Test.ControllerTests;

import entityClasses.*;
import Controllers.ProfileController;
import Controllers.DBController;
import org.junit.*;
import java.util.*;

/**
 * JUnit testing of ProfileController.java
 */

public class ProfileControllerTest{
	private ProfileController pc;
	private DBController dbc;
	private Student stud1;
  
  // @Before annotation forces method to re-execute before each test method
  @Before
  public void init(){ 
    System.out.println("Setting up test objects...");
    stud1 = new Student("ProfileControllerTest", "lastName", "pct", "password", 'u', true, false, new ArrayList<University>());
    dbc = new DBController();
    dbc.addUser(stud1);
    pc = new ProfileController(stud1);
  }
  
  // @After annotation forces method to re-execute after each test method
  @After
  public void destroy(){
    System.out.println("Tearing down test objects...");
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
   * Test that method "editProfile" fails for empty firstName parameter
   * Test that method "editProfile" fails for empty lastName parameter
   * Test that method "editProfile" fails for empty password parameter
   * Test that method "editProfile" works for editing a user's firstName
   * Test that method "editProfile" works for editing a user's lastName
   * Test that method "editProfile" works for editing a user's password
   */    
  @Test
  public void testEditProfile(){
    Assert.assertTrue("Should return -1 for empty firstName parameter", pc.editProfile("", "Miller", "password1")==-1);
    Assert.assertTrue("Should return -1 for empty lastName parameter", pc.editProfile("John", "", "password1")==-1);
    Assert.assertTrue("Should return -1 for empty password parameter", pc.editProfile("John", "Miller", "")==-1);
    
	pc.editProfile("John", "Miller", "password1");
	Student edited = (Student) dbc.getUser("pct");
	Assert.assertTrue("User's firstName should be John", edited.getFirstName().equals("John"));
	Assert.assertTrue("User's lastName should be Miller", edited.getLastName().equals("Miller"));
	Assert.assertTrue("User's password should be password1", edited.getPassword().equals("password1"));
  }
  
  /**
   * Test that method "viewProfile" works
   */    
  @Test
  public void testViewProfile(){
    Assert.assertTrue("viewProfile() output should match Student.toString() output", pc.viewProfile().equals(stud1.toString()));
  }
}