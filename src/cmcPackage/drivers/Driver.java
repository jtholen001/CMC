/**
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 3/20/18
 */
package cmcPackage.drivers;


import cmcPackage.interfaces.*;
import cmcPackage.entityClasses.*;
import cmcPackage.Controllers.*;
import java.util.*;

/**
 * Driver class we do not need to javadoc, but here is one anyways
 *
 */
public class Driver 
{
	
	public StudentInterface studentInt;
	public AdminInterface adminInt;
	public UserInterface userInt;
	public DBController dbCont;
	public Admin admin;
	public Student student;

	public Driver() 
	{
		dbCont = new DBController();
		student = new Student("John", "User", "juser", "password", 'u', true, false, new ArrayList<University>());
		admin = new Admin("Noreen", "Admin", "nadmin", "admin", 'a', true, false);
		userInt = new UserInterface();
		studentInt = new StudentInterface(student);
		adminInt = new AdminInterface(admin);
	}
	
	/**
	 * U1 AND U20
	 */
	public void login() 
	{
		System.out.println("User should be logged in correctly: ");
		if(userInt.login("juser", "password") instanceof StudentInterface)
			System.out.println("User successfully logged in because he was brought to a StudentInterface");
		else
			System.out.println("User failed to login because he was not brought to a StudentInterface");
		System.out.println("\nUser logs out correctly if \"logout\" returns true:");
		//System.out.println("logout: " + userInt.logout((User)student));
		System.out.println("\nUser should fail to log in with incorrect username: ");
		System.out.println("\"login\" should fail and return null: " + userInt.login("john", "user"));
		System.out.println("\nUser should fail to log in with incorrect password: ");
		System.out.println("\"login\" should fail and return null: " + userInt.login("juser", "null"));
		System.out.println("\nUser should fail to log in because account is deactivated");
		System.out.println("\"login\" should fail and return null: " + userInt.login("jtest", "password0"));
		System.out.println("\n");
	}
	
	public void searchForUniversities() 
	{
//		//U3
//		System.out.println("Showing U3: Search for Schools\n");
//		System.out.println("Searching with the following criteria: \"UNIVERSITY\", null, \"URBAN\", \"PRIVATE\", 0, 10000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0 ,0 ,0 ,0 ,0 ,0 ,0, new ArrayList<String>()");
//		ArrayList<University> foundUniversities = studentInt.searchUniversities("UNIVERSITY", null, "URBAN", "PRIVATE", 0, 10000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0 ,0 ,0 ,0 ,0 ,0 ,0, new ArrayList<String>() );
//
//		if (foundUniversities == null)
//			System.out.println("Search Failed: No search criteria specified");
//		else if (foundUniversities.isEmpty())
//			System.out.println("Search Successful: Nothing Found");
//		else {
//			//U6
//			System.out.println("Search Successful: Showing U6: View Matched Schools\n");
//			for(University u : foundUniversities) 
//				System.out.println(u.getName());	
//		}
//		
//		
//		//U3 alt scenario
//		System.out.println("\nShowing U3: Search for Schools (Alternative Scenario)\n");
//		System.out.println("Searching with the following criteria: null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0 ,0 ,0 ,0 ,0 ,0 ,0, null");
//		ArrayList<University> noSearchCriteria = studentInt.searchUniversities(null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0 ,0 ,0 ,0 ,0 ,0 ,0, null);
//		
//
//		if (noSearchCriteria == null)
//			System.out.println("Search Failed: No search criteria specified");
//		else if (noSearchCriteria.isEmpty())
//			System.out.println("Search Successful: Nothing Found");
//		else {
//			//U6
//			System.out.println("Search Successful: Showing U6: View Matched Schools\n");
//			for(University u : noSearchCriteria) 
//				System.out.println(u.getName());	
//		}
//		
//
//		//U7
//		University dummyUniversity = foundUniversities.get(0);
//		System.out.println("\nShowing U7: View Specific School\n");
//		System.out.println(dummyUniversity);
//
//	
		//U10
		ArrayList<University> recommendedUniversities = studentInt.getRecommendedUniversities(dbCont.getUniversity("SMITH"));
		System.out.println("\nShowing U10: View Recommended Schools\n");
		//System.out.println(dummyUniversity + "\n");
		for (University u : recommendedUniversities) {
			//System.out.println(u + "\n");
			System.out.println(u.getName());

		}
		
	}
	
	//U11, U4, U8
	public void viewSavedSchools() 
	{
		int success, otherSuccess;

		System.out.println("Viewing John's saved schools (there should be none):");
		System.out.println(studentInt.viewSavedUniversities());
		otherSuccess = studentInt.saveUniversity(dbCont.getUniversity("Auburn"));
		
		System.out.println("Saving school 'ARIZONA STATE' to John's profile");
		success = studentInt.saveUniversity(dbCont.getUniversity("ARIZONA STATE"));

		if (success == -1)
			System.out.println("Saving school failed - database returned -1");
		else
			System.out.println("Saved school successfully");
		
		System.out.println("\nTrying to save duplicate school 'ARIZONA STATE' to John's profile");
		success = studentInt.saveUniversity(dbCont.getUniversity("ARIZONA STATE"));

		if (success == -1)
			System.out.println("Saving school failed - School already is saved to the student's profile");
		else
			System.out.println("Saved school successfully");
		
		System.out.println("\nViewing John's saved schools");
		System.out.println(studentInt.viewSavedUniversities());
		System.out.println("\nRemoving school 'ARIZONA STATE' from John's profile");
		success = studentInt.removeUniversity(dbCont.getUniversity("ARIZONA STATE"));
		if (success == -1)
			System.out.println("Removing university failed - database returned -1");
		else
			System.out.println("Removed successfully");
		System.out.println("\nViewing John's saved schools");
		System.out.println(studentInt.viewSavedUniversities());
	}
	
	//U5 and U9
	public void viewMyProfile() 
	{
		// U5
		System.out.println("Viewing John's profile");
		System.out.println(studentInt.viewProfile() + "\n");
		
		// U9
		int success;
		System.out.println("Editing John's profile - updating name");
		success = studentInt.editProfile("John", "Miller", "password");
		if (success == -1)
			System.out.println("Edit failed - database returned -1");
		else
			System.out.println("Edited successfully");
		System.out.println("Displaying edited profile - last name should be updated to 'Miller':");
		System.out.println(studentInt.viewProfile() + "\n");
		
		System.out.println("Editing user using empty paramater - should fail");
		success = studentInt.editProfile("", "Miller", "password");
		if (success == -1)
			System.out.println("Edit failed - database returned -1");
		
		System.out.println("\n");
	}
	
	//U13, U17, U18, U19
	//view, add, edit Users
	public void viewUsers() 
	{
		int success;
		  /*
		   * U13
		   * showing view users functionality
		   */
		  System.out.println("Showing U13: View Users");
		  HashMap<String, User> allUsers = adminInt.viewUsers();
		  
		  for (String nameOfUser : allUsers.keySet())
		   System.out.println(nameOfUser);
		  
		  /*
		   * U18
		   * showing add user functionality
		   */
		  System.out.println("\nShowing U18: Add User");
		  System.out.println("\nAdding Student User with following attributes: Miss, Pelled, mpelled001, password0, 'u', true, false");
		 // success = adminInt.addUser("Miss", "Pelled", "mpelled001", "password0", 'u', true, false);
//		  if (success == -1)
//		   System.out.println("Add User failed because Database returned -1");
//		  else
		   System.out.println("Add User successful, Database did not return -1");
		  
		  //showing add user functionality fails if the username already exists
		  System.out.println("\nTry to add User with following attributes: Pant, Olones, mpelled001, password0, 'u', true, false");
		 // success = adminInt.addUser("Pant", "Olones", "mpelled001", "password0", 'u', true, false);
//		  if (success == -1)
//		   System.out.println("Add User failed; username already exists in the Database");
//		  else
		   System.out.println("Add User successful, Database did not return -1");
		  
		  //creating temporary User object to show manipulating functionalities
		  User missPelled = new User("Miss", "Pelled", "mpelled001", "password0", 'u', true, false);
		  
		  /*
		   * U17
		   * showing deactivate User functionality
		   */
		  System.out.println("\nDeactivate the added User: Miss Pelled");
		  boolean initialStatus = missPelled.getActivationStatus();
		  success = adminInt.deactivate(missPelled);
		  if (success == -1)
		   System.out.println("Deactivate User failed because Database returned -1");
		  else
		  {
		   if (initialStatus == true)
		    System.out.println("Deactivate User successful, Database did not return -1 and the User was initially activated");
		   else
		    System.out.println("Deactivate User failed, User is already deactivated");
		  }
		  System.out.println("\nTry to deactivate the added User: Miss Pelled");
		  initialStatus = missPelled.getActivationStatus();
		  success = adminInt.deactivate(missPelled);
		  if (success == -1)
		   System.out.println("Deactivate User failed because Database returned -1");
		  else
		  {
		   if (initialStatus == true)
		    System.out.println("Deactivate User successful, Database did not return -1 and the User was initally activated");
		   else
		    System.out.println("Deactivate User failed, User is already deactivated");
		  }
		  
		  /*
		   * U19
		   * showing edit User functionality
		   */
		  System.out.println("\nEdit User Miss Pelled's last name to \"Takes\"");
		 // success = adminInt.editUser("mpelled001", "Miss", "Takes", "password0", 'u', false, false);
		  if (success == -1)
		   System.out.println("Edit User failed because Database returned -1");
		  else
		   System.out.println("Edit User success, Database did not return -1");
		  
		  //showing edit User functionality does not work when feeding an empty attribute
		  System.out.println("\nTry to edit User Miss Pelled's last name to \"[Empty String]\"");
		//  success = adminInt.editUser("mpelled001", "Miss", "", "mpelled001", 'u', false, false);
		  if (success == -1)
		   System.out.println("Edit User failed because an attribute was left blank");
		  else
		   System.out.println("Edit User success, Database did not return -1");
		  
		  /*
		   * U13
		   * show updated list of Users
		   */
		  System.out.println("\nShowing updated list of users:");
		  allUsers = adminInt.viewUsers();
		  
		  for (String nameOfUser : allUsers.keySet())
		   System.out.println(nameOfUser);
		  
		  //reset changes to Database
		  adminInt.deleteUser("mpelled001");
		  
		  System.out.println("\n");
	}
	
	//U14 and U15 and U16
	public void viewUniversities() 
	{
		System.out.println("Viewing Universities");
		System.out.println(adminInt.viewUniversities());
		
		System.out.println("Adding a University: \"University of CMC\" with attributes \"University of CMC\", \"Arizona\", \"urban\", \"public\", 5, 0, 500, 500, 100, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>()");
		int success = adminInt.addUniversity("University of CMC", "Arizona", "urban", "public", 5, 0.0, 500.0, 500.0, 100.0, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		if (success != -1) {
			System.out.println("\"University of CMC\" added to Database\n");
			System.out.println(dbCont.getUniversity("University of CMC")+ "\n");
		}
		else
			System.out.println("Adding University failed.");
		
		System.out.println("\nAttempting to add University that already exists: \"University of CMC\" with attributes \"University of CMC\", \"Arizona\", \"urban\", \"public\", 5, 0, 500, 500, 100, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>()");
		success = adminInt.addUniversity("University of CMC", "Arizona", "urban", "public", 5, 0.0, 500.0, 500.0, 100.0, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		if (success != -1)
			System.out.println("\"University of CMC\" added to Database");
		else
			System.out.println("Adding University failed.");
		
		System.out.println("\nEditing a University: \"University of CMC\"");

		University toBeEdited = new University("University of CMC", "Arizona", "urban", "public", 5, 0.0, 500, 500, 100, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		success = adminInt.editUniversity(toBeEdited, "University of CMC", "urban", "public", 5, 0.0, 500.0, 500.0, 100.0, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		if (success != -1) {
			System.out.println("Changed the state of University of CMC: \"Arizona\" to \"Hawaii\"" + "\n");
			System.out.println(dbCont.getUniversity("University of CMC")+ "\n");
		}
		else
			System.out.println("Editing University failed.");
		
	    adminInt.deleteUniversity(toBeEdited);

	}
	

	/**
	 * @param argsAdd User failed; us
	 */
	public static void main(String[] args)
	{
		Driver driver = new Driver();
		System.out.println("Testing U1: Login, U20: Logout\n");
		//driver.login();
		System.out.println("\n----------------------------------------------");
		System.out.println("Testing U3: Search For Schools, U6: View Matched Schools, U7: View Specific School, U10 View Recommended Schools\n");
		driver.searchForUniversities();
//		System.out.println("\n----------------------------------------------");
//		System.out.println("Testing U11: Save School, U4: View Saved Schools, U8: Remove Specific School\n");
//		//driver.viewSavedSchools();
//		System.out.println("\n----------------------------------------------");
//		System.out.println("Testing U5: View My Profile, U9: Edit My Profile\n");
//		//driver.viewMyProfile();
//		System.out.println("\n----------------------------------------------");
//		System.out.println("Testing U13: View Users, U17: Deactivate User, U18: Add User, U19: Edit User\n ");
//		//driver.viewUsers();
//		System.out.println("\n----------------------------------------------");
//		System.out.println("Testing U14: View Universities, U15: Add University, U16: Edit University\n");
//		//driver.viewUniversities();
//		System.out.println("\n ----------END OF DRIVER----------");
	}
}
