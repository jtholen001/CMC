/**
 * An interaction/interface class that an Admin uses to perform its functionalities
 * 
 * @author Nicholas Tawil
 * @version 2/20/18
 */
public class AdminInterface
{
  //TODO: give methods a return type so we can verify that they worked
  
  
  /**
   * an Admin object that is interacting with the program
   */
  private Admin admin;
  
  /**
   * Constructor for an AdminInterface
   */
  public AdminInterface(){}
  
  /**
   * TODO: what does this method do?
   */
  public void setAdmin(Admin admin){}
  
  /**
   * A method that displays all User objects in the Database
   */
  public void viewUsers(){};
  
  /**
   * A method that allows an Admin to edit a specific User
   */
  public void editUser(){}
  
  /**
   * A method that allows an Admin to add a new User
   */
  public void addUser(){}
  
  /**
   * A method that allows an Admin to deactivate a User
   * 
   * @param u a User object to be deactivated
   */
  public void deactivate(User u){}
  
  /**
   * A method that displays all University objects in the Database
   */
  public void viewUniversities(){}
  
  /**
   * A method that allows an Admin to edit a specific University
   */
  
  public void editUniversity(){}
  
  /**
   * A method that allows an Admin to add a new University
   */
  public void addUniversity(){}
  
  /**
   * A method that logs out the Admin
   */
  public void logout(){}
}