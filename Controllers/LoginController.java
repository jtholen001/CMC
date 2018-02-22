/**
 * Class that represents a User
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/19/18
*/

public class LoginController
{
  /**
   *  Database controller allowing LoginController to communicate with Database
   */
  private DBController dbc;

  /**
   * Default constructor
   */
   public LoginController()
   {
     dbc = new DBController();
   }

   public User login(String username, String password)
   {
     User user = dbc.getUser(username);
     if (user != null)
     {
      String correctPassword = user.getPassword();
      boolean loggedIn = user.getLoggedInStatus();
      boolean activated = user.getActivationStatus();
    }
    else // invalid username
    {
      this.invalidCredentials();
      return null;
    }

    if ((password.equals(correctPassword)) && (!loggedIn) && (activated)) // successful login
    {
      return user;
    }
    else if (loggedIn) // user already logged in
    {
      this.loggedInAccount();
      return null;
    }
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

   public void loggedInAccount()
   {
     System.err.println("Account already logged in from a different location.");
   }

   public void deactivatedAccount()
   {
     System.err.println("Account deactivated. Contact system administrator.");
   }

   public void invalidCredentials()
   {
     System.err.println("Username or password is inccorect.");
   }
 }
