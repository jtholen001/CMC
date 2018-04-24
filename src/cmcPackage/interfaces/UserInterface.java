/**
 * UserInterface is the entry point for the user in the application
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/21/18
 */
package cmcPackage.interfaces;

import java.util.ArrayList;
import cmcPackage.Controllers.DBController;
import cmcPackage.Controllers.LoginController;
import cmcPackage.entityClasses.*;


public class UserInterface
{  
  /**
   *  LoginController for the UserInterface
   */
  private LoginController lc;
  
  /**
   *  StudentInterface for the UserInterface
   */
  private StudentInterface si;
  
  /**
   *  AdminInterface for the UserInterface
   */
  private AdminInterface ai;
  
  /**
   *  Database controller for the UserInterface
   */
  private DBController dbc;
  
  /**
   * Default constructor
   */
  public UserInterface()
  {
    this.lc = new LoginController(new DBController());
  }
  
  public UserInterface(DBController temp)
  {
    this.lc = new LoginController(temp);
  }
  
  /**
   * This method logs the user into the system
   * 
   * @param username of the user
   * @param password of the user
   * @return boolean successful
   */
  public <t extends UserInterface> UserInterface login(String username, String password)
  {
	try {
    User user = lc.login(username, password);
    if (user != null)
    {
      char type = user.getType();
      if (type == 'u')
      {
        return new StudentInterface((Student) user);
      }
      else if(type == 'a')
      {
    	  return new AdminInterface((Admin) user);
      }
    }
      return null;
	  }
	  catch (IllegalArgumentException iae)
	  {
		  return null;
	  }
  }
  
  public boolean twoFactorAuthenticate(String key, String username) {
	   return dbc.tfaAuthenticate(key, username);
  }
  
  /**
   * A method that logs out a user
   * 
   * @param user the user to log out
   * @return UserInterface brings the user back to a UserInterface to login as a different user
   */
  public UserInterface logout()
  {
    return lc.logout();
  } 
}
