/**
 * This class represents a profile controller
 * 
 * @Author: Michael Carroll, Brandan Kalsow, Nicholas Tawil, Ryan Strelow, Jordan Tholen
 */

package cmcPackage.Controllers;

import java.util.ArrayList;

import cmcPackage.entityClasses.*;

public class ProfileController
{
  // Student entity to edit
  Student student;

  // Database controller allows ProfileController to communicate with Database
  DBController dbc;

  /**
   * Default controller controller for the given student
   * 
   * @param student the name of this student
   */
  public ProfileController(Student student, DBController db)
  {
    this.student = student;
    dbc = db;
  }

  /**
   * method to edit the profile of the given student
   * 
   * @param firstName a String representing the edited first name of a Student
   * @param lastName a String representing the edited last name of a Student
   * @param password a String representing the edited password name of a Student
   * @return integer representing success of edit
   */
  public int editProfile(String firstName, String lastName, String password)
  {
	  if (firstName == null || lastName == null || !meetsPasswordCriteria(password) ||
			  firstName.trim().isEmpty() || lastName.trim().isEmpty())
		  throw new IllegalArgumentException();
	  
    this.student.setFirstName(firstName);
    this.student.setLastName(lastName);
    this.student.setPassword(password);

    return dbc.saveEditedUser(this.student);
  }

  /**
   * method to view the profile of the given student
   * @return a String representation of this student
   */
  public String viewProfile()
  {
    return this.student.toString();
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
