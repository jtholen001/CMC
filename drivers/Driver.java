/**
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 3/14/18
 */
package drivers;
import Interfaces.*;
import entityClasses.*;
import Controllers.*;
import java.util.*;

/**
 * 
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
		System.out.println("User should be logged in correctly: " + userInt.login("juser", "user") + "\n");
		System.out.println("User should be logged out correctly");
		userInt.logout((User)student);
		System.out.println("\n");
		System.out.println("User should fail to log in with incorrect username: ");
		userInt.login("john", "user");
		System.out.println("\n");
		System.out.println("User should fail to log in with incorrect password: ");
		userInt.login("juser", "null");
		System.out.println("\n");
		//TODO: Deactivate user for next test
		System.out.println("User should fail to log in because account is deactivated");
		userInt.login("mcarroll001", "password0");
		System.out.println("\n");
		
	}
	
	public void searchForUniversities() 
	{
		//U3
		ArrayList<University> foundUniversities = studentInt.searchUniversities("UNIVERSITY", null, "URBAN", "PRIVATE", 0, 10000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0 ,0 ,0 ,0 ,0 ,0 ,0, new ArrayList<String>() );
		
		//U6
		if (foundUniversities.isEmpty())
			System.out.println("Nothing Found");
		for(University u : foundUniversities) {
			System.out.println(u.getName());
		}
		
		System.out.println();
		
		University dummyUniversity = foundUniversities.get(0);
		//U7
		System.out.println(dummyUniversity);
		System.out.println();
		
		//U10
		ArrayList<University> recommendedUniversities = studentInt.getRecommendedUniversities(dummyUniversity);
		for (University u : recommendedUniversities) {
			System.out.println(u);
			System.out.println();
		}
		
	}
	
	//U11, U4, U8
	public void viewSavedSchools() 
	{
		int success;
		System.out.println("Saving school 'ARIZONA STATE' to John's profile");
		success = studentInt.saveUniversity(dbCont.getUniversity("ARIZONA STATE"));
		if (success == -1)
			System.out.println("Saving school failed - database returned -1");
		else
			System.out.println("Saved school successfully");
		System.out.println("\nViewing John's saved schools");
		System.out.println(studentInt.viewSavedUniversities());
		System.out.println("\n Removing school 'ARIZONA STATE' from John's profile");
		success = studentInt.removeUniversity(dbCont.getUniversity("ARIZONA STATE"));
		if (success == -1)
			System.out.println("Removing university failed - database returned -1");
		else
			System.out.println("Removed successfully");
		
		
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
		System.out.println("Displaying edited profile - name should be updated:");
		System.out.println(studentInt.viewProfile() + "\n");
		
		System.out.println("Editing user using empty paramater - should fail");
		success = studentInt.editProfile("", "Miller", "password");
		if (success == -1)
			System.out.println("Edit failed - database returned -1");
		
	}
	
	//U13, U17, U18, U19
	//view, add, edit Users
	public void viewUsers() 
	{
		int success;
		//showing view users functionality
		System.out.println("Showing all Users in the DataBase:\n");
		HashMap<String, User> allUsers = adminInt.viewUsers();
		
		for (String nameOfUser : allUsers.keySet())
			System.out.println(nameOfUser);
		
		//showing add user functionality
		System.out.println("\nAdding Student User with following attributes: Miss, Pelled, mpelled001, password0, 'u', true, false");
		success = adminInt.addUser("Miss", "Pelled", "mpelled001", "password0", 'u', true, false);
		if (success == -1)
			System.out.println("Add User failed - database returned -1");
		else
			System.out.println("Added User successfully");
		
		//creating temporary User object to show manipulating functionalities
		User missPelled = new User("Miss", "Pelled", "mpelled001", "password0", 'u', true, false);
		
		//showing deactivate User functionality
		System.out.println("\nDeactivate the added User: Miss Pelled");
		success = adminInt.deactivate(missPelled);
		if (success == -1)
			System.out.println("Deactivate User failed - database returned -1");
		else
			System.out.println("Deactivated User successfully");
		
		
		//showing edit User functionality works
		System.out.println("\nEdit User Miss Pelled's last name to 'Takes'");
		success = adminInt.editUser("mpelled001", "Miss", "Takes", "mpelled001", 'u', false, false);
		if (success == -1)
			System.out.println("Edit User failed - database returned -1");
		else
			System.out.println("Edited User successfully");
		
		//showing edit User functionality does not work
		System.out.println("\nEdit User Miss Pelled's last name to \"[Empty String]\"");
		success = adminInt.editUser("mpelled001", "Miss", "", "mpelled001", 'u', false, false);
		if (success == -1)
			System.out.println("Edit User failed - database returned -1");
		else
			System.out.println("Edited User successfully");
			
	}
	
	//U14 and U15 and U16
	public void viewUniversities() 
	{
		System.out.println("Viewing Universities");
		System.out.println(adminInt.viewUniversities());
		
		System.out.println("Adding a University: \"University of CMC\" with attributes \"University of CMC\", \"Arizona\", \"urban\", \"public\", 5, 0, 500, 500, 100, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>()");
		int success = adminInt.addUniversity("University of CMC", "Arizona", "urban", "public", 5, 0.0, 500.0, 500.0, 100.0, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		if (success != -1)
			System.out.println("\"University of CMC\" added to Database");
		else
			System.err.println("Adding University failed.");
		
		System.out.println("Editing a University: \"University of CMC\"");
		University toBeEdited = new University("University of CMC", "Arizona", "urban", "public", 5, 0.0, 500, 500, 100, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		success = adminInt.editUniversity(toBeEdited, "University of ACM", "Arizona", "urban", "public", 5, 0.0, 500.0, 500.0, 100.0, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		if (success != -1)
			System.out.println("Changed title of University: \"University of CMC\" to \"University of ACM\"");
		else
			System.err.println("Editing University failed.");
		
		//TODO: force remove school at the end of this method so Driver successfuly runs next time
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Driver driver = new Driver();
		System.out.println("Testing U1: Login, U20: Logout");
		driver.login();
		System.out.println("----------------------------------------------");
		System.out.println("Testing U3: Search For Schools, U6: View Matched Schools, U7: View Specific School, U10 View Recommended Schools");
		driver.searchForUniversities();
		System.out.println("----------------------------------------------");
		System.out.println("Testing U11: Save School, U4: View Saved Schools, U8: Remove Specific School");
		driver.viewSavedSchools();
		System.out.println("----------------------------------------------");
		System.out.println("Testing U5: View My Profile, U9: Edit My Profile");
		driver.viewMyProfile();
		System.out.println("----------------------------------------------");
		System.out.println("Testing U13: View Users, U18: Add User, U19: Edit User");
		driver.viewUsers();
		System.out.println("----------------------------------------------");
		System.out.println("Testing U14: View Universities");
		driver.viewUniversities();

		// TODO Auto-generated method stub
	}
}
