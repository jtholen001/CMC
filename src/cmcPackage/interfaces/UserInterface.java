/**
 * UserInterface is the entry point for the user in the application
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/21/18
 */
package cmcPackage.interfaces;

import java.util.ArrayList;

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
  
  /**
   * This method calculates if a given password meets the minimum criteria
   * @param password
   * @return true if the password meets requirements, false otherwise
   */
	protected boolean meetsPasswordCriteria(String password)
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
