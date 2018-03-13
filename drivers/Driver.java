/**
 * 
 */
package drivers;
import Interfaces.*;
import entityClasses.*;
import Controllers.*;

/**
 * @author @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 *
 */
public class Driver {
	
	public StudentInterface studentInt;
	public AdminInterface adminInt;
	public UserInterface userInt;
	public Admin admin = new Admin("John", "Miller", "jmiller", "password0", 'a', true, true);
	public Student student;

	public Driver() {
		userInt = new UserInterface();
		student = new StudentInterface(null);
	}
	
	/**
	 * 
	 */
	public static void testLogin() {
		boolean status = userInt.login("johnmiller", "")
		
	}
	
	public void createUser() {
		
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
