/**
 * A controller class that handles University functionalities
 * 
 *  @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
public class UniversityController
{
  /**
   * an instance of the DBController
   */
  private DBController dbCont;
  
  /**
   * Constructor for a UniversityController object
   */
  public UniversityController()
  {
    this.dbCont = new DBController();
  }
  
  /**
   * A method that displays all University objects in the Database
   */
  public void viewUniversities()
  {
  }
  
  /**
   * A method that allows an Admin to edit a University
   * 
   * @param university the University object to be edited
   */
  public void editUniversity(University university)
  {
  }
  
  /**
   * A method that allows an Admin to add a University
   */
  public void addUniversity()
  {
  }
}