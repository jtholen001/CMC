/**
 * Class that will emcompass all the functionalities relating to searching
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

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
  public void searchUniversities()
  {
    HashMap<String, University> universities = dbc.viewUniversities();
    
    
    String name, state, location, control;
    int numStudentsLower, numStudentsUpper, percentFemaleLower, percentFemaleUpper, SATVerbalLower, SATVerbalUpper, SATMathLower, SATMathUpper,
      expensesLower, expensesUpper, numApplicantsLower, numApplicantsUpper, academicScaleLower, academicScaleUpper, socialScaleLower, socialScaleUpper, qualityOfLifeScaleLower, qualityOfLifeScaleUpper; 
    double percentFinancialAidLower, percentFinancialAidUpper, percentAdmittedLower, percentAdmittedUpper, percentEnrolledLower, percentEnrolledUpper; 
    ArrayList<String> emphases;
    
    name = null;
    state = null;    
    location = null;
    control = null;
    numStudentsLower = 0;
    numStudentsUpper = 0;
    percentFemaleLower = 0;
    percentFemaleUpper = 0;
    SATMathLower = 0;
    SATMathUpper = 0;
    expensesLower = 0;
    expensesUpper = 0;
    numApplicantsLower = 0;
    numApplicantsUpper = 0;
    academicScaleLower = 0;
    academicScaleUpper = 0;
    socialScaleLower = 0;
    socialScaleUpper = 0;
    qualityOfLifeScaleLower = 0;
    qualityOfLifeScaleUpper = 0;
    percentFinancialAidLower = 0.0;
    percentFinancialAidUpper = 0.0;
    percentAdmittedLower = 0.0;
    percentAdmittedUpper = 0.0;
    percentEnrolledLower = 0.0;
    percentEnrolledUpper = 0.0;
    emphases = new ArrayList<String>();
    
    Set<String> universityNames = universities.keySet();
    
    for (String u : universityNames)
    {
      
 
    }
    
    
    
    //ArrayList<University> foundUniversities = dbc.searchUniversities(name, state, location, control, numStudents, 
    //                percentFemale, SATVerbal, SATMath, expenses, percentFinancialAid, 
    //                numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale,
    //                qualityOfLifeScale, emphases);
    
    
    //viewSchools(foundUniversities);
  }

  /**
   * Method to view Universitiess from searching
   * @param foundUniversities the universities to be viewed from searching
   */
  public void viewSchools(ArrayList<University> foundUniversities)
  {
    for (University u : foundUniversities)
    {
     System.out.println(u.toString()); 
    }
  }
  
  /**
   *TODO: Method might be replaced with method in StudentUniversitiesController
   * Method to view a specific university from searching
   * @param university the University to be viewed
   */
  public void viewUniversity(University university)
  {
    System.out.println(university.toString());
  }
  
   /**
   * TODO: possible boolean return type
   * Method to add a new University to a Student's saved universities
   * @param student the Student to whom the university needs to be added
   * @param newUniversity the University to add the a Student's saved universities
   */
  public void saveUniversity(Student student, University newUniversity)
  {
   student.addSchool(newUniversity);
   dbc.saveEditedUser(student);
  }
}
