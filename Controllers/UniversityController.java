/**
 * A controller class that handles University functionalities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */

//import ArrayList
import java.util.ArrayList;

//import HashMap
import java.util.HashMap;

//import Set
import java.util.Set;

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
    HashMap<String, University> listAll = dbCont.viewUniversities();
    
    Set<String> universityNames = listAll.keySet();
    
    for (String u : universityNames)
    {
      listAll.get(u).toString();   
    } 
  }
  
  /**
   * A method that allows an Admin to edit a University
   * 
   * @param university the University object to be edited
   */
  public void editUniversity(University university)
  {
    // TODO: not sure how we are setting stuff yet, so right now everything will be null
    
    //setting school name cannot be set to the name of a University that already exists in the DB
    //if the Admin tries to duplicate, do not allow changes to the University object
    university.setSchoolName(null);
    university.setState(null);
    university.setLocation(null);
    university.setControl(null);
    university.setNumStudents(0);
    university.setPercentFemale(0);
    university.setSATVerbal(0);
    university.setSATMath(0);
    university.setExpenses(0);
    university.setPercentFinancialAid(0);
    university.setNumApplicants(0);
    university.setPercentAdmitted(0);
    university.setPercentEnrolled(0);
    university.setAcademicScale(0);
    university.setSocialScale(0);
    university.setQualityOfLifeScale(0);
    university.setEmphases(null);
    
    dbCont.saveEditedUniversity(university);
  }
  
  /**
   * A method that allows an Admin to add a University
   */
  public void addUniversity()
  {
    //TODO: variables to be set by the driver or something. Same as editUniversity method above^
    String name;
    String state;
    String location;
    String control;
    int numStudents;
    int percentFemale;
    int satVerbal;
    int satMath;
    int expenses;
    double percentFinancialAid;
    int numApplicants;
    double percentAdmitted;
    double percentEnrolled;
    int academicScale;
    int socialScale;
    int qualityOfLifeScale;
    ArrayList<String> emphases;
    
    dbCont.addUniversity(new University(name, state, location, control, numStudents, percentFemale, satVerbal, satMath, 
                                        expenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, 
                                        academicScale, socialScale, qualityOfLifeScale, emphases));
  }
}