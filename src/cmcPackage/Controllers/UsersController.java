/**
 * A controller class 1manages a User
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */
package cmcPackage.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import cmcPackage.entityClasses.*;

public class UsersController
{

  /**
   * an instance of a DBController
   */
  private DBController dbCont;
  private HashMap<String, User> users;

  /**
   * Constuctor for UsersController
   */
  public UsersController()
  {
    this.dbCont = new DBController();
    users = dbCont.getUsers();
  }

  /**
   * a method to view all Users in the Database
   * 
   * @return a HashMap containing all the users in the database
   */
  public HashMap<String,User> viewUsers()
  {
    users = dbCont.getUsers();
    return users;
  }

  /**
   * a method to edit a single User
   *
   * @param username the username of the user to edit
   * @param firstName the new first name for this user
   * @param lastName the new last name for this user
   * @param password the new password for this user
   * @param type the new account type for this user
   * @param isActivated the new activation status for this user
   * @param isLoggedIn the new logged in status for this user
   * @throws IllegalArgumentException
   * @return an int representing the success of editing a user
   */
  public void editUser(String username,String firstName, String lastName, String password, char type ,boolean isActivated,
                        boolean isLoggedIn)
  {
 if (username.equals("") || firstName.equals("") || lastName.equals("") || !meetsPasswordCriteria(password) || type != 'a' && type != 'u')
  throw new IllegalArgumentException("Fields cannot be empty");
 else
 {
    User toEdit = dbCont.getUser(username);

    //admin can edit anything except for username
    toEdit.setFirstName(firstName);
    toEdit.setLastName(lastName);
    toEdit.setPassword(password);
    toEdit.setType(type);
    toEdit.setActivationStatus(isActivated);
    toEdit.setLoggedInStatus(isLoggedIn);
    
    dbCont.saveEditedUser(toEdit);
 }
  }

  /**
   * a method to add a User to the Database
   * 
   * @param username the username of the user to edit
   * @param firstName the new first name for this user
   * @param lastName the new last name for this user
   * @param password the new password for this user
   * @param type the new account type for this user
   * @param isActivated the new activation status for this user
   * @param isLoggedIn the new logged in status for this user
   * @throws IllegalArgumentException
   * @return an int representing the success of adding a user
   */
  public void addUser(String firstName, String lastName, String username, String password, char type ,boolean isActivated,
                        boolean isLoggedIn)
  {
	  if (firstName.equals("") || lastName.equals("") || username.equals("") || !meetsPasswordCriteria(password) || type != 'a' && type != 'u')
		  throw new IllegalArgumentException("Fields cannot be empty");
	  else
		  dbCont.addUser(new User(firstName, lastName, username, password, type, isActivated, isLoggedIn));
	      users.put(username, new User(firstName, lastName, username, password, type ,isActivated, isLoggedIn));
  }

  /**
   * a method to deactivate a User
   *
   * @param user a User object to be deactivated
   * @throws IllegalArgumentException
   * @return an int representing the success of deactivating a user
   */
  public int deactivate(User user) throws IllegalArgumentException
  {
	  if(users.get(user.getUsername()).getActivationStatus() == false)
		  throw new IllegalArgumentException("User is already deactivated");
	  else
		  user.setActivationStatus(false);
	  		users.get(user.getUsername()).setActivationStatus(false);
	  	  return dbCont.saveEditedUser(user);
  }
  
  /**
   * a method to delete a user
   * @param username the user to delete from the Database
   * @return an integer representing the success/fail of the method
   */
  public int deleteUser(String username)
  {
   return dbCont.deleteUser(username);
  }
  
  /**
   * This method calculates if a given password meets the minimum criteria
   * @param password
   * @return true if the password meets requirements, false otherwise
   */
	private boolean meetsPasswordCriteria(String password)
	  {
				boolean validLength = false;
				boolean containsCapital = false;
				boolean containsLower = false;
				boolean containsNum = false;
				boolean containsSpecialChar = false;
				ArrayList<Character> specialChars = new ArrayList<Character>();
				specialChars.add('!');
				specialChars.add('@');
				specialChars.add('#');
				specialChars.add('$');
				specialChars.add('%');
				specialChars.add('^');
				specialChars.add('&');
				specialChars.add('*');
				specialChars.add('(');
				specialChars.add(')');
				specialChars.add('`');
				specialChars.add('~');
				specialChars.add('[');
				specialChars.add(']');
				specialChars.add('{');
				specialChars.add('}');
				specialChars.add('-');
				specialChars.add('_');
				specialChars.add('=');
				specialChars.add('+');
				specialChars.add('\\');
				specialChars.add('|');
				specialChars.add(';');
				specialChars.add(':');
				specialChars.add('\'');
				specialChars.add('\"');
				specialChars.add(',');
				specialChars.add('<');
				specialChars.add('.');
				specialChars.add('>');
				specialChars.add('/');
				specialChars.add('?');
				
				
				if(password.length() >= 6)
					validLength = true;
	
				for (int i = 0; i < password.length(); i++)
				{
					if(Character.isDigit(password.charAt(i)))
					{
						containsNum = true;
	
					}
					else if(specialChars.contains(password.charAt(i)))
					{
						containsSpecialChar = true;
					}
				    else if(Character.isUpperCase(password.charAt(i)))
					{
				    	containsCapital = true;
					}
				   else if(Character.isLowerCase(password.charAt(i)))
					{
					   containsLower = true;
					}
				}
	
			   if(!validLength || !containsCapital || !containsLower || !containsNum || !containsSpecialChar)
			   {
				   return false;
			   }
			   else
				{
				   return true;
				}
	  }
}
