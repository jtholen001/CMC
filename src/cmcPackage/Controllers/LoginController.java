/**
 * Modified LoginController class controls the login logic for a user and allows for 2-factor authentication using Time-based One-time Password algorithm
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */
package cmcPackage.Controllers;
import java.security.GeneralSecurityException;

import com.j256.twofactorauth.*;

import cmcPackage.interfaces.UserInterface;
import cmcPackage.entityClasses.User;

public class LoginController
{
	/**
	 *  2-factor authentication utility
	 */
	TimeBasedOneTimePasswordUtil tfaUtil;
	/**
	 *  Database controller allows LoginController to communicate with Database
	 */
	private DBController dbc;
	
	private static final String SECRET_KEY = "VVDAKWRGH2NPTAN4";
	private static final String QR_CODE = "https://chart.googleapis.com/chart?chs=200x200&cht=qr&chl=200x200&chld=M|0&cht=qr&chl=otpauth://totp/CMC-internal%3Fsecret%3DVNBAZKGA4QRMBB6K";

	/**
	 * Default constructor
	 */
	public LoginController()
	{
		dbc = new DBController();
	}

	/**
	 * This method controls the log in logic of the system
	 * 
	 * @param username the username of the user
	 * @param password the user's password of the user
	 * @return user object that logged in
	 * @throws GeneralSecurityException 
	 */
	public User login(String username, String password, String authKey) throws GeneralSecurityException
	{				
		User user = dbc.getUser(username);
		if (user != null)
		{
			String correctPassword = user.getPassword();
			boolean loggedIn = user.getLoggedInStatus();
			boolean activated = user.getActivationStatus();

			if ((password.equals(correctPassword)) && (!loggedIn) && (activated)) // successful login
			{
				if (authKey.equals(tfaUtil.generateCurrentNumberString(SECRET_KEY))) {
					user.setLoggedInStatus(true);
					return user;
					}
				else {
					System.out.println("Two-step verification failed");
					return null;
				}
			}

			//TODO: maybe we don't need to check the user's loggedInStatus because it is saved locally, not in DB
			//      else if (loggedIn) // user already logged in
			//      {
			//        this.loggedInAccount();
			//        return null;
			//      }

			else if (!activated) // deactivated account
			{
				this.deactivatedAccount();
				return null;
			}
			else
			{
				this.invalidCredentials(); // invalid password
				return null;
			}
		}
		else // invalid username
		{
			this.invalidCredentials();
			return null;
		}

	}

	//TODO: maybe we don't need to check the user's loggedInStatus because it is saved locally, not in DB
	//   /**
	//    * This method prints a login outor message indicating that the account is already logged in
	//    */
	//   public void loggedInAccount()
	//   {
	//     System.out.println("Account already logged in from a different location.");
	//   }

	/**
	 * This method prints a login outor message indicating that the account is deactivated
	 */
	public void deactivatedAccount()
	{
		System.out.println("Account deactivated. Contact system administrator.");
	}

	/**
	 * This method prints a login outor message indicating that the credentials are invalid
	 */
	public void invalidCredentials()
	{
		System.out.println("Username or password is incorrect.");
	}

	/**
	 * This method controls the log off logic of the system
	 * 
	 * @param user the user to log off
	 * @return UserInterface brings the user back to a UserInterface to login as a different user
	 */
	public UserInterface logout()
	{
		return new UserInterface();
	}
}
