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
  public void searchUniversities()
  {
    String name, state, location, control;
    int numStudents, percentFemale, SATVerbal, SATMath, expenses, numApplicants, academicScale, socialScale, qualityOfLifeScale; 
    double percentFinancialAid, percentAdmitted, percentEnrolled; 
    ArrayList<String> emphases;
    
    ArrayList<University> foundUniversities = dbc.searchUniversities(name, state, location, control, numStudents, 
                    percentFemale, SATVerbal, SATMath, expenses, percentFinancialAid, 
                    numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale,
                    qualityOfLifeScale, emphases);
    viewSchools(foundUniversities);
  }

  /**
   * Method to view Universitiess from searching
   * @param foundUniversities the universities to be viewed from searching
   */
  public void viewSchools(ArrayList<Universit> foundUniversities)
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
    System.out.println(unviersity.toString());
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
