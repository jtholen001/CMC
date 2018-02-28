import java.util.ArrayList;

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
   * 
   * @param username the username of the user to edit
   * @param newFirst the new first name for this user
   * @param newLast the new last name for this user
   * @param newPassword the new password for this user
   * @param newType the new account type for this user
   * @param newActivation the new activation status for this user
   * @param newLoggedIn the new logged in status for this user
   */
  public void editUser(String username, String newFirst, String newLast, String newPassword, char newType, boolean newActivation, boolean newLoggedIn)
  {
    uCont.editUser(username, newFirst, newLast, newPassword, newType, newActivation, newLoggedIn);
  }
  
  /**
   * A method that allows an Admin to add a new User
   */
  public void addUser(String firstName, String lastName, String username, String password, char type ,boolean isActivated,
                        boolean isLoggedIn)
  {
    uCont.addUser(firstName, lastName, username, password, type, isActivated, isLoggedIn);
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
  
  public void editUniversity(University university, String name, String state, String location, String control, int numStudents, int percentFemale, int SATVerbal, int SATMath,
                             int expenses, double percentFinancialAid, int numApplicants, double percentAdmitted, double percentEnrolled,
                             int academicScale, int socialScale, int qualityOfLifeScale, ArrayList<String> emphases)
  {
    uniCont.editUniversity(university,name,state,location,control,numStudents,percentFemale,SATVerbal,SATMath,
                             expenses,percentFinancialAid,numApplicants,percentAdmitted,percentEnrolled,
                             academicScale,socialScale,qualityOfLifeScale,emphases);
  }
  
  /**
   * A method that allows an Admin to add a new University
   */
  public void addUniversity(String name, String state, String location, String control, int numStudents, int percentFemale, int SATVerbal, int SATMath,
                             int expenses, double percentFinancialAid, int numApplicants, double percentAdmitted, double percentEnrolled,
                             int academicScale, int socialScale, int qualityOfLifeScale, ArrayList<String> emphases)
  {
    uniCont.addUniversity(name,state,location,control,numStudents,percentFemale,SATVerbal,SATMath,
                             expenses,percentFinancialAid,numApplicants,percentAdmitted,percentEnrolled,
                             academicScale,socialScale,qualityOfLifeScale,emphases);
  }
  
  /**
   * A method that logs out the Admin
   */
  public void logout()
  {
    lc.logout(admin);
  }
}