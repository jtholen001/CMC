/**
 * A controller class 1manages a User
 * 
 *  @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
public class UsersController
{
  /**
   * an array of Users
   */
  private User[] users;
  
  /**
   * an instance of a DBController
   */
  private DBController dbCont;
  
  /**
   * Constuctor for UsersController
   */
  public UsersController()
  {
    this.dbCont = new DBController();
  }
  
  /**
   * a method to view all Users in the Database
   */
  public void viewUsers()
  {
    
  }
  
  /**
   * a method to edit a single User
   * 
   * @param username a string representing the username of a User
   */
  public void editUser(String username)
  {
    
  }
  
  /**
   * a method to add a User to the Database
   */
  public void addUser()
  {
    
  }
  
  /**
   * a method to deactivate a User
   * 
   * @param user a User object to be deactivated
   */
  public void deactivate(User user)
  {
  }
}