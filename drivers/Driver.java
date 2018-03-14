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
		//System.out.println("User should be logged in correctly: " + userInt.login("juser", "user"));
		//System.out.println("User should be logged out correctly");
		//userInt.logout((User)student);
		//System.out.println("User should fail to log in with incorrect username: " + userInt.login("john", "user"));
		//System.out.println("User should fail to log in with incorrect password: " + userInt.login("juser", "null"));
		//TODO: Deactivate user for next test
		//System.out.println("User should fail to log in because account is deactivated" + userInt.login("juser", "user"));
		
	}
	
	public void searchForUniversities() 
	{
		ArrayList<University> foundUniversities = studentInt.searchUniversities("UNIVERSITY", null, "URBAN", "PRIVATE", 0, 15000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,0 ,0 ,0 ,0 ,0 ,0 ,0, new ArrayList<String>() );
		if (foundUniversities.isEmpty())
			System.out.println("Nothing Found");
		for(University u : foundUniversities) {
			System.out.println(u);
		}
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
		
		
		
	}
	
	//U13 and U17, U18, U19
	public void viewUsers() 
	{
		
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
		driver.searchForUniversities();
		// TODO Auto-generated method stub
		
		
	}
}
