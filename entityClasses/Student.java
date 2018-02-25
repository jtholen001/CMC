/**
 * Class that represents a Student
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */

import java.util.ArrayList;

public class Student extends User
{
  /**
   * Array to store a student's saved schools
   */
  private ArrayList<University> savedUniversities;

  /**
   * Constructor for a Student
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
   this.savedUniversities = universities;
  }

  /**
   * Method to return an array of this Student's saved universities
   * @return a University array
   */
  public ArrayList<University> getSavedSchools()
  {
   return this.savedUniversities;
  }

   /**
   * Method to return the University associated with the name passed
   * @return an University
   */
  public University getSpecificSchool(String universityName)
  {
    return null;
  }

   /**
   * TODO: possible boolean return type
   * Method to add a new University to a Student's saved universities
   */
  public void addSchool(University newUniversity)
  {
    boolean added = this.savedUniversities.add(newUniversity);
  }

   /**
   * TODO: possible boolean return type
   * Method to remove a University from a Student's saved universities
   */
  public void removeSchool(University oldUniversity)
  {
    University removedUniversity = this.savedUniversities.remove(oldUniversity);
  }

  public String toString()
  {
    return ("First name: " + this.getFirstName() +
            "\nLast name: " + this.getLastName() +
            "\nUsername: " + this.getUsername() +
            "\nType: " + this.getType() +
            "\nActivated: " + this.getActivationStatus() +
            "\nUniversities: " + this.savedUniversities.toString());
  }
}
