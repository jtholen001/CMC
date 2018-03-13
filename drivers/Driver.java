/**
 * 
 */
package drivers;
import Interfaces.*;
import entityClasses.*;
import Controllers.*;
import java.util.ArrayList;

/**
 * @author @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 *
 */
public class Driver {
	
	public StudentInterface studentInt;
	public AdminInterface adminInt;
	public UserInterface userInt;
	public Admin admin;
	public Student student;

	public Driver() {
		student = new Student("John", "User", "juser", "user", 'u', true, false, new ArrayList<University>());
		admin = new Admin("Noreen", "Admin", "nadmin", "admin", 'a', true, false);
		userInt = new UserInterface();
		studentInt = new StudentInterface(student);
		adminInt = new AdminInterface(admin);
	}
	
	/**
	 * U1 AND U20
	 */
	public void login() {
		boolean status = userInt.login("johnmiller", "")
		
	}
	
	public void searchForUniversities() {
		boolean status = userInt.login("johnmiller", "")
		
	}	
	//U6 and U7 and U10 maybe U11
	public void viewMatchedSchools() {
		boolean status = userInt.login("johnmiller", "")
		
	}	
	
	//U4 and U7 probably U8
	public void viewSavedSchools() {
		boolean status = userInt.login("johnmiller", "")
		
	}
	
	//U5 and U9
	public void viewMyProfile() {

		
	}
	
	//U13 and U17, U18, U19
	public void viewUsers() {
		
	}
	
	//U14 and U15 and U16
	public void viewUniversities() {

		
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
