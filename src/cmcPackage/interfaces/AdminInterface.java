/**
` * An interaction/interface class that an Admin uses to perform its functionalities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 5/2/18
 */
package cmcPackage.interfaces;

import java.util.*;
import cmcPackage.Controllers.*;
import cmcPackage.entityClasses.*;

public class AdminInterface extends UserInterface
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
	 * 
	 * @param admin the admin object to use
	 */
	public AdminInterface(Admin admin)
	{
		DBController db = new DBController();
		this.admin = admin;
		this.uCont = new UsersController(db);
		this.uniCont = new UniversityController(db);
		this.lc = new LoginController(db);
	}

	public AdminInterface(Admin admin, DBController temp)
	{
		super(temp);
		this.admin = admin;
		this.uCont = new UsersController(temp);
		this.uniCont = new UniversityController(temp);
		this.lc = new LoginController(temp);
	}

  /**
   * A method that displays all User objects in the Database
   * 
   * @return a hashmap containing all users in the database
   */
  public HashMap<String, User> viewUsers()
  {
    return uCont.viewUsers();
  }
  
  /**
   * Method to check if admin is deactivated
   * 
   * @return boolean representation of activation status
   */
  public Boolean isActivated()
  {
	  return this.admin.getActivationStatus(); 
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
   * 
   * @return -1 if unsucessfull, 0 otherwise
   */
  public void editUser(String username, String newFirst, String newLast, String newPassword, String newType, String newActivation, String newLoggedIn)
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
   * 
   * @return -1 if unsucessfull, 0 otherwise
   */
  public void addUser(String firstName, String lastName, String username, String password, String type ,String isActivated,
                        String isLoggedIn)
  {
		  uCont.addUser(firstName, lastName, username, password, type, isActivated, isLoggedIn);

  }
  
  /**
   * A method that allows an Admin to deactivate a User
   * 
   * @param user a User object to be deactivated
   * 
   * @return -1 if unsucessfull, 0 otherwise
   */
  public int deactivate(User user)
  {
    return uCont.deactivate(user);
  }
  
  /**
   * a method to delete a user'
   * @param username the user to delete
   * @return an integer representing the success/fail of the method
   * 
   * @return -1 if unsucessfull, 0 otherwise
   */
  public int deleteUser(String username)
  {
   return uCont.deleteUser(username);
  }
  
  public University getUniversity(String name)
  {
    try {
    	return uniCont.getUniversity(name);
    }
    catch(IllegalArgumentException j)
	  {
		  return null; 
	  }
  }
  
  /**
   * A method that displays all University objects in the Database
   * 
   * @return a string representation of all universities in the database
   */
  public HashMap<String, University> viewUniversities()
  {
    return uniCont.viewUniversities();
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
   * @param percentFemale a double representing the edited percentFemale of the University
   * @param SATVerbal an double representing the edited SATVerbal of the University
   * @param SATMath an double representing the edited SATMath of the University
   * @param expenses an double representing the edited expenses of the University
   * @param percentFinancialAid a double representing the edited percentFinancialAid of the University
   * @param numApplicants an int representing the edited numApplicants of the University
   * @param percentAdmitted a double representing the edited percentAdmitted of the University
   * @param percentEnrolled a double representing the edited percentEnrolled of the University
   * @param academicScale an int representing the edited academicScale of the University
   * @param socialScale an intrepresenting the edited socialScale of the University
   * @param qualityOfLifeScale an int representing the edited qualityOfLifeScale of the University
   * @param emphases an ArrayList<String> representing the edited emphases of the 
   * 
   * @return -1 if unsucessfull, 0 otherwise
   */
  
  public int editUniversity(University university, String state, String location, String control, 
                             String numStudents, String percentFemale, String SATVerbal, String SATMath,
                             String expenses, String percentFinancialAid, String numApplicants, String percentAdmitted,
                             String percentEnrolled,
                             String academicScale, String socialScale, String qualityOfLifeScale, ArrayList<String> emphases)
  {
    return uniCont.editUniversity(university,state,location,control,numStudents,percentFemale,SATVerbal,SATMath,
                             expenses,percentFinancialAid,numApplicants,percentAdmitted,percentEnrolled,
                             academicScale,socialScale,qualityOfLifeScale,emphases);
  }
  
  /**String
   * A method that allows an Admin to add a new University
   * 
   * @param name a String representing the edited name of the University
   * @param state a String representing the edited state of the University
   * @param location a String representing the edited location of the University
   * @param control a String representing the edited control of the University
   * @param numStudents an int representing the edited numStudents of the University
   * @param percentFemale an double representing the edited percentFemale of the University
   * @param SATVerbal an double representing the edited SATVerbal of the University
   * @param SATMath an double representing the edited SATMath of the University
   * @param expenses an double representing the edited expenses of the University
   * @param percentFinancialAid a double representing the edited percentFinancialAid of the University
   * @param numApplicants an int representing the edited numApplicants of the University
   * @param percentAdmitted a double representing the edited percentAdmitted of the University
   * @param percentEnrolled a double representing the edited percentEnrolled of the University
   * @param academicScale an int representing the edited academicScale of the University
   * @param socialScale an intrepresenting the edited socialScale of the University
   * @param qualityOfLifeScale an int representing the edited qualityOfLifeScale of the University
   * @param emphases an ArrayList<String> representing the edited emphases of the 
   * 
   * @return -1 if unsucessfull, 0 otherwise
   */
  public int addUniversity(String name, String state, String location, String control, String numStudents, String percentFemale, String SATVerbal, String SATMath,
         String expenses, String percentFinancialAid, String numApplicants, String percentAdmitted, String percentEnrolled,
                             String academicScale, String socialScale, String qualityOfLifeScale, ArrayList<String> emphases)
  {
	  try {
		  return uniCont.addUniversity(name,state,location,control,numStudents,percentFemale,SATVerbal,SATMath,
                  expenses,percentFinancialAid,numApplicants,percentAdmitted,percentEnrolled,
                  academicScale,socialScale,qualityOfLifeScale,emphases);
	  }
	  catch(IllegalArgumentException e)
	  {
		  return -1;
	  }
  }
  
  /**
   * this method removes a University from the database
   * 
   * @param university the university to remove from the database
   * @return -1 if unsucessfull, 0 otherwise
   */
  public int deleteUniversity(University university)
  {
   return uniCont.deleteUniversity(university);
  }
  
  /**
   * This method get the admin that is currently logged in
   * 
   * @return admin the admin logged into this interface
   */
  public Admin getAdmin()
  {
	  return this.admin;
  }
  
  /**
   * A method that logs out the Admin
   * 
   * @return UserInterface brings the user back to a UserInterface to login as a different user
   */
  public UserInterface logout()
  {
    return super.logout();
  }
}