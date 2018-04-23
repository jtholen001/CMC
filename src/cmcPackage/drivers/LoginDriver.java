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
public class LoginDriver 
{
	
	public StudentInterface studentInt;
	public AdminInterface adminInt;
	public UserInterface userInt;
	public DBController dbCont;
	public Admin admin;
	public Student student;

	public LoginDriver() 
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
		//System.out.println("Testign 2FA functonalities");
		//System.out.println("Is 2FA working for juser (should be false): " + dbCont.isTfaEnabled("juser"));
		//System.out.println("2FA enabled for juser" + dbCont.enableTfa(dbCont.getUser("juser")));
		//System.out.println("Authenticated: " + dbCont.tfaAuthenticate("570415", "juser"));
		//dbCont.disableTfa(dbCont.getUser("juser"));
		
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
	

	/**
	 * @param argsAdd User failed; us
	 */
	public static void main(String[] args)
	{
		LoginDriver driver = new LoginDriver();
		System.out.println("Testing U1: Login, U20: Logout\n");
		driver.login();
		
		System.out.println("\n ----------END OF DRIVER----------");
	}
}
