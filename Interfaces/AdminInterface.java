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
   * 
   * @param firstName the new user's first name
   * @param lastName the new user's last name
   * @param username the new user's username
   * @param password the new user's password
   * @param type the type of user this is
   * @param isActivated the activation status of the new user
   * @param isLoggedIn the logged-in status of the new user
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
   * 
   * @param university the University object to be edited
   * @param name a String representing the edited name of the University
   * @param state a String representing the edited state of the University
   * @param location a String representing the edited location of the University
   * @param control a String representing the edited control of the University
   * @param numStudents an int representing the edited numStudents of the University
   * @param percentFemale an int representing the edited percentFemale of the University
   * @param SATVerbal an int representing the edited SATVerbal of the University
   * @param SATMath an int representing the edited SATMath of the University
   * @param expenses an int representing the edited expenses of the University
   * @param percentFinancialAid a double representing the edited percentFinancialAid of the University
   * @param numApplicants an int representing the edited numApplicants of the University
   * @param percentAdmitted a double representing the edited percentAdmitted of the University
   * @param percentEnrolled a double representing the edited percentEnrolled of the University
   * @param academicScale an int representing the edited academicScale of the University
   * @param socialScale an intrepresenting the edited socialScale of the University
   * @param qualityOfLifeScale an int representing the edited qualityOfLifeScale of the University
   * @param emphases an ArrayList<String> representing the edited emphases of the 
   */
  
  public void editUniversity(University university, String name, String state, String location, String control, 
                             int numStudents, int percentFemale, int SATVerbal, int SATMath,
                             int expenses, double percentFinancialAid, int numApplicants, double percentAdmitted,
                             double percentEnrolled,
                             int academicScale, int socialScale, int qualityOfLifeScale, ArrayList<String> emphases)
  {
    uniCont.editUniversity(university,name,state,location,control,numStudents,percentFemale,SATVerbal,SATMath,
                             expenses,percentFinancialAid,numApplicants,percentAdmitted,percentEnrolled,
                             academicScale,socialScale,qualityOfLifeScale,emphases);
  }
  
  /**
   * A method that allows an Admin to add a new University
   * 
   * @param name a String representing the edited name of the University
   * @param state a String representing the edited state of the University
   * @param location a String representing the edited location of the University
   * @param control a String representing the edited control of the University
   * @param numStudents an int representing the edited numStudents of the University
   * @param percentFemale an int representing the edited percentFemale of the University
   * @param SATVerbal an int representing the edited SATVerbal of the University
   * @param SATMath an int representing the edited SATMath of the University
   * @param expenses an int representing the edited expenses of the University
   * @param percentFinancialAid a double representing the edited percentFinancialAid of the University
   * @param numApplicants an int representing the edited numApplicants of the University
   * @param percentAdmitted a double representing the edited percentAdmitted of the University
   * @param percentEnrolled a double representing the edited percentEnrolled of the University
   * @param academicScale an int representing the edited academicScale of the University
   * @param socialScale an intrepresenting the edited socialScale of the University
   * @param qualityOfLifeScale an int representing the edited qualityOfLifeScale of the University
   * @param emphases an ArrayList<String> representing the edited emphases of the 
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