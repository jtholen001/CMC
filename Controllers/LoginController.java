/**
 * LoginController class controls the login logic for a user
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
*/
package Controllers;

import entityClasses.User;

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
    * 
    * @param username the username of the user
    * @param password the user's password of the user
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
        return user;
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

   //TODO: same thing, the loggedInStatus is not saved in the DB, so all this method will eventually do is 
   //	bring the user back to a non-logged in home page
   /**
    * This method controls the log off logic of the system
    * 
    * @param user the user to log off
    * @return true if the user was successfully logged out, false otherwise
    */
   public boolean logout(User user)
   {
    user.setLoggedInStatus(false);
    dbc.saveEditedUser(user);
    System.out.println("Successfuly logged out.");
    return true;
   }
 }
