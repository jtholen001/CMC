/**
 * Class that will be used as an interface for a Student
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
public class StudentInterface
{
  
  /**
   * Student that will be associated with the StudentInterface
   */
  private Student student;
  
  /**
   * ProfileController that will be associated with the StudentInterface
   */
  private ProfileController pc;
  
  /**
   * SearchController that will be associated with the StudentInterface
   */
  private SearchController sc;
  
  /**
   * StudentUniversitiesController that will be associated with the StudentInterface
   */
  private StudentUniversitiesController suc;
  
  /**
   * LoginController that will be associated with the StudentInterface
   */
  private LoginController lc;
  
  /**
   * Constructor for a StudentInterface
   * @param student the student that will be associated with the StudentInterface
   */
  public StudentInterface(Student student)
  {
    this.student = student;
    this.pc = new ProfileController(this.student);
    this.sc = new SearchController();
    this.suc = new StudentUniversitiesController(this.student);
    this.lc = new LoginController(); 
  }
  
  /**
   * Method to veiw the Student's profile
   */
  public void viewProfile()
  {
   this.pc.viewProfile(this.student); 
  }
  
  /**
   * Method to edit the Student's profile 
   * 
   * @param firstName a String representing the first name of a Student
   * @param lastName a String representing the last name of a Student
   * @param password a String representing the password of a Student
   */
  public void editProfile(String firstName, String lastName, String password)
  {
   this.pc.editProfile(firstName, lastName, password); 
  }
  
  /**
   * Method to view the Student's saved universities
   */
  public void viewSavedUniversities()
  {
   this.suc.viewSavedUniversities(this.student);
  }
  
  /**
   * TODO: possible boolean return type
   * Method to view a specific university
   * @param university the University to be viewed 
   */
  public void viewUniversity(University university)
  {
    this.suc.viewUniversity(university);
  }

  /**
   * TODO: possible boolean return type
   * Method to save a university to the Student's current list of saved universities
   * @param university the University to be saved to the Student
   */
  public void saveUniversity(University university)
  {
   this.sc.saveUniversity(this.student, university);
  }
  
  /**
   * TODO: possible boolean return type
   * Method to remove a university from the Student's saved universities
   * @param university the University to be removed from the student
   */
  public void removeUniversity(University university)
  {
    this.suc.removeUniversity(university);
  }
  
  /**
   * TODO: possible boolean return type
   * Method to search the database for universities based on search criteria
   */
  public void searchUniversities()
  {
   ArrayList<University> foundUniversities = sc.searchUniversities(); 
   sc.viewSchools(foundUniversities);
  }
  
  /**
   * TODO: possible boolean return type
   * Method to log the student out
   */
  public void logout()
  {
    lc.logout(this.student);
  }
}  

