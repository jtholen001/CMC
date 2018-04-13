/**
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 3/20/18
 */
package cmcPackage.drivers;


import cmcPackage.interfaces.*;
import cmcPackage.entityClasses.*;
import cmcPackage.Controllers.*;
import java.util.*;

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
		Scanner sc = new Scanner(System.in);
		System.out.print("Username: ");
		String username = sc.next();
		System.out.print("Password: ");
		String password = sc.next();
		
		System.out.println("\n2-Step Verification");
		System.out.print("Enter secret key from authenticator app: ");
		String authKey = sc.next();
		
		if(userInt.login(username, password, authKey) instanceof StudentInterface)
			System.out.println("\nUser successfully logged in because he was brought to a StudentInterface");
		else
			System.out.println("\nUser failed to login because he was not brought to a StudentInterface");
		System.out.println("\n");
	}
	

	/**
	 * @param argsAdd User failed; us
	 */
	public static void main(String[] args)
	{
		LoginDriver driver = new LoginDriver();
		System.out.println("Testing U1: Login\n");
		driver.login();
		System.out.println("\n ----------END OF DRIVER----------");
	}
}
