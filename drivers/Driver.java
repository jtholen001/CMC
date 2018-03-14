/**
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 3/12/18
 */
package drivers;
import Interfaces.*;
import entityClasses.*;
import Controllers.*;
import java.util.ArrayList;

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
	}
	
	/**
	 * U1 AND U20
	 */
	public void login() 
	{
		System.out.println("User should be logged in correctly: " + userInt.login("juser", "user"));
		System.out.println("User should be logged out correctly");
		userInt.logout((User)student);
		System.out.println("User should fail to log in with incorrect username: " + userInt.login("john", "user"));
		System.out.println("User should fail to log in with incorrect password: " + userInt.login("juser", "null"));
		//TODO: Deactivate user for next test
		System.out.println("User should fail to log in because account is deactivated" + userInt.login("juser", "user"));
		
	}
	
	public void searchForUniversities() 
	{
		
		
	}	
	//U6 and U7 and U10 maybe U11
	public void viewMatchedSchools() 
	{
		
		
	}	
	
	//U4 and U7 probably U8
	public void viewSavedSchools() 
	{
		
		
	}
	
	//U5 and U9
	public void viewMyProfile() 
	{
		userInt.login("juser", "user")
		
		
	}
	
	//U13 and U17, U18, U19
	public void viewUsers() 
	{
		
	}
	
	//U14 and U15 and U16
	public void viewUniversities() 
	{
		System.out.println("Viewing Universities");
		System.out.println(adminInt.viewUniversities());
		
		System.out.println("Adding a University: \"University of CMC\" with attributes \"University of CMC\", \"Arizona\", \"urban\", \"public\", 5, 0, 500, 500, 100, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>()");
		int success = adminInt.addUniversity("University of CMC", "Arizona", "urban", "public", 5, 0, 500, 500, 100, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		if (success == 1)
			System.out.println("\"University of CMC\" added to Database");
		else
			System.err.println("Adding University failed.");
		
		System.out.println("Editing a University: \"University of CMC\"");
		University toBeEdited = new University("University of CMC", "Arizona", "urban", "public", 5, 0, 500, 500, 100, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		success = adminInt.editUniversity(toBeEdited, "University of ACM", "Arizona", "urban", "public", 5, 0, 500, 500, 100, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		if (success == 1)
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
		// TODO Auto-generated method stub
		
		
	}
}
