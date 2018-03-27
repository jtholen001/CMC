package Test.EntityTests;

import entityClasses.*;
import Controllers.DBController;
import org.junit.*;
import java.util.*;

/**
 * for JUnit testing of ProfileController.java
 */

public class UserTest{
	private DBController dbc;
	private User user1;
  
  // @Before annotation forces method to re-execute before each test method
  @Before
  public void init(){ 
    System.out.println("Setting up test objects...");
    user1 = new User("Rasanjalee", "Dissanayaka", "rdiss", "password1", 'u', true, false);
    dbc = new DBController();
    dbc.addUser(user1);
  }
}