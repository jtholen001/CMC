/**
 * Class that emcompasses functionalities relating to a Student's saved universities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
public class StudentUniversitiesController
{
  /**
   * TODO: instance variables
   */
  
  /**
   * TODO: Constuctor
   */
  public StudentUniversitiesController();

  
  /**
   * Method to return an array of this Student's saved universities
   * @return a University array
   */
  public University[] viewSavedUniversities()
  {
   return this.savedUniversities; 
  }
  
   /**
   * Method to return the University associated with the name passed
   * @return an University 
   */
  public University getSpecificSchool(String universityName);
  
   /**
   * TODO: possible boolean return type
   * Method to add a new University to a Student's saved universities
   */
  public void addSchool(University newUniversity);
  
   /**
   * TODO: possible boolean return type
   * Method to remove a University from a Student's saved universities
   */
  public void removeSchool(University oldUniversity);
}  

 