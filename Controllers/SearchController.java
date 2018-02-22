/**
 * Class that will emcompass all the functionalities relating to searching
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/21/18
 */
public class SearchController
{
  /**
   * TODO: Constructor and Instance Variables
   */
  
  /**
   * DBController that will be accessed by the SearchController
   */
  private DBController dbc;
  
  /**
   * Constructor for a SearchController
   * 
   */
  public SearchController()
  {
    this.dbc = new DBController(); 
  }
  
  /**
   * Method to search for universities
   */
  public void searchUniversities();
  
  /**
   * Method to view Universitiess from searching
   */
  public void viewSchools();
  
  /**
   *TODO: Method might be replaced with method in StudentUniversitiesController
   * Method to view a specific university from searching
   * @param university the University to be viewed
   */
  public void viewUniversity(University university);
  
  /**
   * TODO: possible boolean return type
   * Method to view a specific university
   */
  public void removeUniversity(University university);
  
  /**
   * TODO: possible boolean return type
   * Method to save a new university to the Student's saved universities
   */
  public void saveUniversity(University university);
  
}
