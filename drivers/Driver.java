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
	
	//U13, U17, U18, U19
	//view, add, edit Users
	public void viewUsers() 
	{
		int success;
		//showing view users functionality
		System.out.println("Showing all Users in the DataBase:\n");
		adminInt.viewUsers();
		
		//showing add user functionality
		System.out.println("Adding Student User with following attributes: Miss, Pelled, mpelled001, password0, 'u', true, false");
		success = adminInt.addUser("Miss", "Pelled", "mpelled001", "password0", 'u', true, false);
		if (success == -1)
			System.err.println("Add User failed");
		else
			System.out.println("Add User success");
		
		//creating temporary User object to show manipulating functionalities
		User missPelled = new User("Miss", "Pelled", "mpelled001", "password0", 'u', true, false);
		
		//showing deactivate User functionality
		System.out.println("Deactivate the added User: Miss Pelled");
		success = adminInt.deactivate(missPelled);
		if (success == -1)
			System.err.println("Deactivate User failed");
		else
			System.out.println("Deactivate User success");
		
		//showing edit User functionality
		System.out.println("Edit User Miss Pelled's last name to 'Takes'");
		success = adminInt.editUser("mpelled001", "Miss", "Takes", "mpelled001", 'u', false, false);
		if (success == -1)
			System.err.println("Edit User failed");
		else
			System.out.println("Edit User success");
	}
	
	//U14 and U15 and U16
	public void viewUniversities() 
	{

		
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
