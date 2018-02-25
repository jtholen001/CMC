/**
 * A controller class that handles University functionalities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */

//import ArrayList
import java.util.ArrayList;

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
    ArrayList<University> listAll = dbCont.viewUniversities();
    
    for (int i = 0; i <= listAll.size(); i++)
    {
      System.out.println((listAll.get(i)).getSchoolName());
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
    university.setNumStudents(null);
    university.setPercentFemales(null);
    university.setSATVerbal(null);
    university.setSATMath(null);
    university.setExpenses(null);
    university.setPercentFinancialAid(null);
    university.setNumApplicants(null);
    university.setPercentAdmitted(null);
    university.setPercentEnrolled(null);
    university.setAcademicScale(null);
    university.setSocialScale(null);
    university.setQualityOfLifeScale(null);
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
                                        academicScale, socialScale, qualityOfLifeScale, emphasis));
  }
}