/**
 * Class that emcompasses functionalities relating to a Student's saved universities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
public class StudentUniversitiesController
{
  /**
   * DBController that will be accessed by the SearchController
   */
  private DBController dbc;
  
  /**
   * Constructor for a StudentUniversitiesController
   */
  public StudentUniversitiesController()
  {
   this.dbc = new DBController(); 
  }

  
  /**
   * Method to view a Student's saved universities
   */
  public void viewSavedUniversities(Student student)
  {
   Array<University> universities = student.getSavedSchools(savedUniversities); 
  }
  
   /**
   * Method to view an University
   * @return an University 
   */
  public void viewUniversity(Student student, University university)
  {
    
  }
  
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

 