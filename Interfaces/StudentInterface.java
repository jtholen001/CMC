/**
 * Class that will be used as an interface for a Student
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/27/18
 */

import java.util.ArrayList;

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
   this.pc.viewProfile(); 
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
   this.suc.viewSavedUniversities();
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
   * Method to search for universities
   * @param state the state this university is located in as a String
   * @param location  whether the university is located in and urban or rural setting
   * @param control  whether this university is publicly
   * @param numStudentsLower  the lower bound of number of students
   * @param numStudentsUpper  the upper bound of number of students
   * @param percentFemaleLower  the lower bound of the percentage of enrolled students that are female
   * @param percentFemaleUpper  the upper bound of the percentage of enrolled students that are female
   * @param SATVerbalLower  the lower bound of the average SAT Verbal score of the students enrolled at this university
   * @param SATVerbalUpper  the upper bound of the average SAT Verbal score of the students enrolled at this university
   * @param SATMathLower the lower bound of the average SAT Math score of the students enrolled at this university
   * @param SATMathUpper the upper bound of the average SAT Math score of the students enrolled at this university
   * @param expensesLower  the lower bound of the cost to attend this university
   * @param expensesUpper  the upper bound of the cost to attend this university
   * @param numApplicantsLower  the lower bound of the number of students that apply to this university
   * @param numApplicantsUpper  the upper bound of the number of students that apply to this university
   * @param academicScaleLower the lower bound of how this university rates academically 
   * @param academicScaleUpper the upper bound of how this university rates academically
   * @param socialScaleLower  the lower bound of how this university rates socially
   * @param socialScaleUpper  the upper bound of how this university rates socially
   * @param qualityOfLifeScaleLower  the lower bound of the quality of life at this university
   * @param qualityOfLifeScaleUpper  the upper bound of the quality of life at this university
   * @param percentFinancialAidLower  the lower bound of the percentage of enrolled students who recieve financial aid
   * @param percentFinancialAidUpper  the upper bound of the percentage of enrolled students who recieve financial aid
   * @param percentAdmittedLower  the lower bound of the percent of applicants that are addmitted to this university
   * @param percentAdmittedUpper  the upper bound of the percent of applicants that are addmitted to this university
   * @param percentEnrolledLower  the lower bound of the percent of addmitted students that enroll at this university
   * @param percentEnrolledUpper  the upper bound of the percent of addmitted students that enroll at this university
   * @param searchEmphases  areas of study
   */
  public void searchUniversities(String name, String state, String location, String control, int numStudentsLower, int numStudentsUpper, int percentFemaleLower, int percentFemaleUpper,
                                 int SATVerbalLower, int SATVerbalUpper, int SATMathLower, int SATMathUpper, int expensesLower, int expensesUpper, int numApplicantsLower, int numApplicantsUpper,
                                 int academicScaleLower, int academicScaleUpper, int socialScaleLower, int socialScaleUpper, int qualityOfLifeScaleLower, int qualityOfLifeScaleUpper,  
                                 double percentFinancialAidLower, double percentFinancialAidUpper, double percentAdmittedLower, double percentAdmittedUpper, double percentEnrolledLower, 
                                 double percentEnrolledUpper, ArrayList<String> searchEmphases)
  {
    ArrayList<University> foundUniversities = sc.searchUniversities(name, state, location, control, numStudentsLower, numStudentsUpper, percentFemaleLower, percentFemaleUpper,
                                                                    SATVerbalLower, SATVerbalUpper, SATMathLower, SATMathUpper, expensesLower, expensesUpper, numApplicantsLower, numApplicantsUpper,
                                                                    academicScaleLower, academicScaleUpper, socialScaleLower, socialScaleUpper, qualityOfLifeScaleLower, qualityOfLifeScaleUpper,  
                                                                    percentFinancialAidLower, percentFinancialAidUpper, percentAdmittedLower, percentAdmittedUpper, percentEnrolledLower, 
                                                                    percentEnrolledUpper, searchEmphases); 
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

