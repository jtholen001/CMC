/**
 * LoginController class controls the login logic for a user
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/21/18
*/

public class LoginController
{
  /**
   *  Database controller allows LoginController to communicate with Database
   */
  private DBController dbc;

  /**
   * Default constructor
   */
   public LoginController()
   {
     dbc = new DBController();
   }

   /**
    * This method controls the log in logic of the system
    * @param username of the user
    * @param password of the user
    * @return user object that logged in
    */
   public User login(String username, String password)
   {
     User user = dbc.getUser(username);
     if (user != null)
     {
      String correctPassword = user.getPassword();
      boolean loggedIn = user.getLoggedInStatus();
      boolean activated = user.getActivationStatus();

      if ((password.equals(correctPassword)) && (!loggedIn) && (activated)) // successful login
      {
        user.setLoggedInStatus(true);
        dbc.saveEditedUser(user);
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
    else // invalid username
    {
      this.invalidCredentials();
      return null;
    }
   }

   /**
    * This method prints a login error message indicating that the account is already logged in
    */
   public void loggedInAccount()
   {
     System.err.println("Account already logged in from a different location.");
   }

   /**
    * This method prints a login error message indicating that the account is deactivated
    */
   public void deactivatedAccount()
   {
     System.err.println("Account deactivated. Contact system administrator.");
   }

   /**
    * This method prints a login error message indicating that the credentials are invalid
    */
   public void invalidCredentials()
   {
     System.err.println("Username or password is incorrect.");
   }

   /**
    * This method controls the log in logic of the system
    * @param User user entity for the user
    * @return user object that logged in
    */
   public void logout(User user)
   {
    user.setLoggedInStatus(false);
    dbc.saveEditedUser(user);
    System.out.println("Successfuly logged out.");
   }
 }
