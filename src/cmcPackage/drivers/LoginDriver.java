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
		System.out.println("Username: ");
		String username = sc.nextLine();
		System.out.println("Password: ");
		String password = sc.nextLine();
		
		System.out.println("2-Step Verification");
		System.out.println("Enter secret key from authenticator app: ");
		String authKey = sc.nextLine();
		
		if(userInt.login(username, password, authKey) instanceof StudentInterface)
			System.out.println("User successfully logged in because he was brought to a StudentInterface");
		else
			System.out.println("User failed to login because he was not brought to a StudentInterface");
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
