/**
 * Class that represents a Student
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
public class Student extends User
{
  /**
   * Array to store a student's saved schools
   */
  private University [] savedUniversities;
  
  /**
   * Constructor that takes a first name, last name,  username, password, type ,activation status, logged in status, and currently saved schools
   */
  public Student(String firstName, String lastName, String username, String password, char type, boolean activated, boolean logged, University[] universities)
  {
   super(firstName, lastName, username, password, type, activated, logged);
   this.savedUniversities = universities;
  }
  
  /**
   * Method to return an array of this Student's saved universities
   * @return a University array
   */
  public University[] getSavedSchools()
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
    
  }
  
   /**
   * TODO: possible boolean return type
   * Method to remove a University from a Student's saved universities
   */
  public void removeSchool(University oldUniversity)
  {
    
  }
}  

 