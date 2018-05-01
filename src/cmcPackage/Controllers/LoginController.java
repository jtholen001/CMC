/**
 * LoginController class controls the login logic for a user
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 5/2/18
*/
package cmcPackage.Controllers;

import cmcPackage.interfaces.UserInterface;
import cmcPackage.entityClasses.User;

public class LoginController
{
  /**
   *  Database controller allows LoginController to communicate with Database
   */
  private DBController dbc;

  /**
   * Default constructor
   */
   public LoginController(DBController db)
   {
     dbc = db;
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

      if ((password.equals(correctPassword)) && (!loggedIn)) // successful login
      {
        user.setLoggedInStatus(true);
        return user;
      }
      else
      {
        // invalid password
        return null;
      }
    }
    else // invalid username
    {
      return null;
    }

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
