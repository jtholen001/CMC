/**
 * A controller class 1manages a User
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */
package Controllers;

import java.util.HashMap;
import entityClasses.*;

public class UsersController
{
  /**
   * an array of Users
   */
  private User[] users;

  /**
   * an instance of a DBController
   */
  private DBController dbCont;

  /**
   * Constuctor for UsersController
   */
  public UsersController()
  {
    this.dbCont = new DBController();
  }

  /**
   * a method to view all Users in the Database
   */
  public HashMap<String,User> viewUsers()
  {
    return dbCont.getUsers();
  }

  /**
   * a method to edit a single User
   *
   * @param username the username of the user to edit
   * @param newFirst the new first name for this user
   * @param newLast the new last name for this user
   * @param newPassword the new password for this user
   * @param newType the new account type for this user
   * @param newActivation the new activation status for this user
   * @param newLoggedIn the new logged in status for this user
   */
  public void editUser(String username,String firstName, String lastName, String password, char type ,boolean isActivated,
                        boolean isLoggedIn)
  {
    User toEdit = dbCont.getUser(username);

    //admin can edit anything except for username
    toEdit.setFirstName(null);
    toEdit.setLastName(null);
    toEdit.setPassword(null);
    toEdit.setType('q'); //cannot set an empty char, for this purpose, set to q
    toEdit.setActivationStatus(false);
    toEdit.setLoggedInStatus(false);

    dbCont.saveEditedUser(toEdit);
  }

  /**
   * a method to add a User to the Database
   * 
   * @param username the username of the user to edit
   * @param newFirst the new first name for this user
   * @param newLast the new last name for this user
   * @param newPassword the new password for this user
   * @param newType the new account type for this user
   * @param newActivation the new activation status for this user
   * @param newLoggedIn the new logged in status for this user
   */
  public void addUser(String firstName, String lastName, String username, String password, char type ,boolean isActivated,
                        boolean isLoggedIn)
  {

    dbCont.addUser(new User(firstName, lastName, username, password, type, isActivated, isLoggedIn));    
  }

  /**
   * a method to deactivate a User
   *
   * @param user a User object to be deactivated
   */
  public void deactivate(User user)
  {
    user.setActivationStatus(false);
    dbCont.saveEditedUser(user);
  }
}
