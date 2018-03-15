/**
 * UserInterface is the entry point for the user in the application
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/21/18
 */
package Interfaces;

import Controllers.LoginController;
import entityClasses.*;

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
   * Default constructor
   */
  public UserInterface()
  {
    lc = new LoginController();
  }
  
  /**
   * This method logs the user into the system
   * 
   * @param username of the user
   * @param password of the user
   * @return boolean successful
   */
  public boolean login(String username, String password)
  {
    User user = lc.login(username, password);
    if (user != null)
    {
      char type = user.getType();
      if (type == 'u')
      {
        this.passToStudentInterface((Student)user);
      }
      else
      {
        this.passToAdminInterface((Admin)user);
      }
      return true;
    }
    return false;
  }
  
  /**
   * This method passes the logged in Student to the StudentInterface
   * 
   * @param student object to be passed
   */
  public void passToStudentInterface(Student student)
  {
    si = new StudentInterface(student);
  }
  
  /**
   * This method passes the logged in Admin to the AdminInterface
   * 
   * @param admin object to be passed
   */
  public void passToAdminInterface(Admin admin)
  {
    ai = new AdminInterface(admin);
  }
  
  /**
   * A method that logs out a user
   * 
   * @param user the user to log out
   * @return true if successful log out
   */
  public boolean logout(User user)
  {
    return lc.logout(user);
  }
}
