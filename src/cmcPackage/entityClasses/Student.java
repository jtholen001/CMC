/**
 * Class that represents a Student
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */
package cmcPackage.entityClasses;

import java.util.ArrayList;

public class Student extends User
{
  /**
   * Array to store a student's saved schools
   */
  private ArrayList<University> savedUniversities;

  /**
   * Constructor for a Student
   * 
   * @param firstName the first name for the Student
   * @param lastName the last name for the Student
   * @param username the username for the Student
   * @param password the password for the Student
   * @param type the type of User the Student is
   * @param activated the current activation status of the Student
   * @param logged a boolean to show if the Student is logged in
   * @param universities the saved universities for the Student
   */
  public Student(String firstName, String lastName, String username, String password, char type, boolean activated, boolean logged, ArrayList<University> universities)
  {
   super(firstName, lastName, username, password, type, activated, logged);
   if (universities == null)
	   	throw new IllegalArgumentException("Null arraylist parameter");
   this.savedUniversities = universities;
  }

  /**
   * Method to return an array of this Student's saved universities
   * 
   * @return a University array
   */
  public ArrayList<University> getSavedSchools()
  {
   return this.savedUniversities;
  }

   /**
   * Method to return a specific saved University from the user’s savedUniversities
   * 
   * @param universityName the name of the university to get information for
   * 
   * @return an University
   */
  public University getSpecificSchool(String universityName)
  {
	if (universityName == null || universityName.trim().equals(""))
		throw new IllegalArgumentException();
	  
    for (University u: savedUniversities)
    {
     if (u.getName().equals(universityName))
     {
      return u;
     }
    }
    throw new IllegalArgumentException("University not found in user's saved schools");
  }

   /**
   * Method to add a new University to a Student's saved universities
   * 
   * @param newUniversity the University to add to the Student
   * 
   * @return an int representing the success of adding a university to a student
   */
  public void addSchool(University newUniversity)
  { 
    if (this.savedUniversities.contains(newUniversity))
    	throw new IllegalArgumentException("Can't save a university twice");
    else
    	this.savedUniversities.add(newUniversity);
  }

   /**
   * Method to remove a University from a Student's saved universities
   * 
   * @param oldUniversity  the University that is to be removed
   */
  public void removeUniversity(University oldUniversity)
  {
	if (!this.savedUniversities.contains(oldUniversity))
		throw new IllegalArgumentException();
	else	  
		this.savedUniversities.remove(oldUniversity);
  }

  /**
   * toString() method to display a Student entity
   * 
   * @return a concatenated string representing a Students and its attributes
   */
  public String toString()
  {
	  String s = "First name: " + this.getFirstName() +
            "\nLast name: " + this.getLastName() +
            "\nUsername: " + this.getUsername() +
            "\nType: " + this.getType() +
            "\nActivated: " + this.getActivationStatus() +
            "\nLogged in: " + this.getLoggedInStatus() + 
            "\nUniversities: ";

    for(University u : savedUniversities)
    	s += u.getName() + ", ";   	
    
    return s.substring(0, s.length()-2);
  }
  
  @Override
  public boolean equals(Object o)
  {
	  if(!(o instanceof Student)) // U1
		  return false;
	  Student other = (Student) o;
	  if(!other.getUsername().equals(this.getUsername())) // U2
		  return false;
	  else if(!other.getFirstName().equals(this.getFirstName())) // U3
		  return false;
	  else if(!other.getLastName().equals(this.getLastName())) // U4
		  return false;
	  else if(!other.getPassword().equals(this.getPassword())) // U5
		  return false;
	  else if(!(other.getType() == this.getType())) // U6
		  return false;
	  else if(!(other.getSavedSchools().equals(this.getSavedSchools())))
		  return false;
	  else
		  return true;
  }
}
