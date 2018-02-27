/**
 * An interaction/interface class that an Admin uses to perform its functionalities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */
public class AdminInterface
{  
  /**
   * an instance of UsersController
   */
  private UsersController uCont;
  
  /**
   * an instance of UniversityController
   */
  private UniversityController uniCont;
  
  /**
   * an instance of LoginController
   */
  private LoginController lc;
  
  /**
   * an Admin object that is interacting with the program
   */
  private Admin admin;
  
  /**
   * Constructor for an AdminInterface
   */
  public AdminInterface(Admin admin)
  {
    this.admin = admin;
    this.uCont = new UsersController();
    this.uniCont = new UniversityController();
    this.lc = new LoginController();
  }
  
  /**
   * A method that sets the type of User to an Admin, specified by character 'a'
   * 
   * @param admin the Admin who's type is being set to Admin's type
   */
  public void setAdmin(Admin admin)
  {
    admin.setType('a');
  }
  
  /**
   * A method that displays all User objects in the Database
   */
  public void viewUsers()
  {
    uCont.viewUsers();
  }
  
  /**
   * A method that allows an Admin to edit a specific User
   */
  public void editUser()
  {
    uCont.editUser(admin.getUsername());
  }
  
  /**
   * A method that allows an Admin to add a new User
   */
  public void addUser()
  {
    uCont.addUser();
  }
  
  /**
   * A method that allows an Admin to deactivate a User
   * 
   * @param u a User object to be deactivated
   */
  public void deactivate(User u)
  {
    uCont.deactivate(u);
  }
  
  /**
   * A method that displays all University objects in the Database
   */
  public void viewUniversities()
  {
    uniCont.viewUniversities();
  }
  
  /**
   * A method that allows an Admin to edit a specific University
   */
  
  public void editUniversity(University university)
  {
    uniCont.editUniversity(university);
  }
  
  /**
   * A method that allows an Admin to add a new University
   */
  public void addUniversity()
  {
    uniCont.addUniversity();
  }
  
  /**
   * A method that logs out the Admin
   */
  public void logout()
  {
    lc.logout(admin);
  }
}