/**
 * Class that will be used as an interface for a Student
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
public class StudentInterface
{
  /**
   * TODO: Constructor and Instance Variables
   */
  
  /**
   * Student that will be associated with the StudentInterface
   */
  private Student student;
  
  /**
   * TODO: Constructor
   */
  public StudentInterface();
    
    /**
     * Method to veiw the Student's profile
     */
    public void viewProfile();
  
  /**
   * Method to edit the Student's profile 
   */
  public void editProfile();
  
  /**
   * Method to view the Student's saved universities
   */
  public void viewSavedUniversities();
  
  /**
   * TODO: possible boolean return type
   * Method to view a specific university
   */
  public void viewUniversity(University university);
  
  /**
   * TODO: possible boolean return type
   * Method to save a new university to the Student's saved universities
   */
  public void viewUniversity(University university);
  
  /**
   * TODO: possible boolean return type
   * Method to remove a university from the Student's saved universities
   */
  public void removeUniversity();
  
  /**
   * TODO: possible boolean return type
   * Method to search the database for universities based on search criteria
   */
  public void searchUniversities();
  
  /**
   * TODO: possible boolean return type
   * Method to search the database for universities based on search criteria
   */
  public void searchUniversities();
  
  /**
   * TODO: possible boolean return type
   * Method to log the student out
   */
  public void logout();
}  

