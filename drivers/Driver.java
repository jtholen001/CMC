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
	public Admin admin;
	public Student student;

	public Driver() 
	{
		student = new Student("John", "User", "juser", "user", 'u', true, false, new ArrayList<University>());
		admin = new Admin("Noreen", "Admin", "nadmin", "admin", 'a', true, false);
		userInt = new UserInterface();
		studentInt = new StudentInterface(student);
		adminInt = new AdminInterface(admin);
		//this.viewUsers();
	}
	
	/**
	 * U1 AND U20
	 */
	public void login() 
	{
		System.out.println("User should be logged in correctly: " + userInt.login("juser", "user"));
		System.out.println("User should be logged out correctly");
		userInt.logout((User)student);
		System.out.println("User should fail to log in with incorrect username: ");
		userInt.login("john", "user");
		System.out.println("User should fail to log in with incorrect password: ");
		userInt.login("juser", "null");
		//TODO: Deactivate user for next test
		System.out.println("User should fail to log in because account is deactivated");
		userInt.login("mcarroll001", "password0");
		
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
		}
		
	}
	
	//U4 and U7 probably U8
	public void viewSavedSchools() 
	{
		System.out.println("Viewing John's saved schools");
		System.out.println(studentInt.viewSavedUniversities());
		
	}
	
	//U5 and U9
	public void viewMyProfile() 
	{
		System.out.println("Viewing John's profile");
		System.out.println(studentInt.viewProfile());
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
			System.out.println("Add User failed because Database returned -1");
		else
			System.out.println("Add User successful, Database did not return -1");
		
		//creating temporary User object to show manipulating functionalities
		User missPelled = new User("Miss", "Pelled", "mpelled001", "password0", 'u', true, false);
		
		//showing deactivate User functionality
		System.out.println("\nDeactivate the added User: Miss Pelled");
		success = adminInt.deactivate(missPelled);
		if (success == -1)
			System.out.println("Deactivate User failed because Database returned -1");
		else
			System.out.println("Deactivate User successful, Database did not return -1");
		
		
		//showing edit User functionality works
		System.out.println("\nEdit User Miss Pelled's last name to 'Takes'");
		success = adminInt.editUser("mpelled001", "Miss", "Takes", "mpelled001", 'u', false, false);
		if (success == -1)
			System.out.println("Edit User failed because Database returned -1");
		else
			System.out.println("Edit User success, Database did not return -1");
		
		//showing edit User functionality does not work
		System.out.println("\nEdit User Miss Pelled's last name to \"[Empty String]\"");
		success = adminInt.editUser("mpelled001", "Miss", "", "mpelled001", 'u', false, false);
		if (success == -1)
			System.out.println("Edit User failed because Database returned -1");
		else
			System.out.println("Edit User success, Database did not return -1");
			
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
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Driver driver = new Driver();
		//driver.viewUniversities();
		//driver.viewUsers();
		driver.searchForUniversities();

		// TODO Auto-generated method stub
	}
}
