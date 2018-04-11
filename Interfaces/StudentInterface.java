/**
 * Class that will be used as an interface for a Student
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/27/18
 */
package Interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import entityClasses.Student;
import entityClasses.University;
import Controllers.*;

public class StudentInterface extends UserInterface
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
   * 
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
   * 
   * @return a string representation of this student's profile
   */
  public String viewProfile()
  {
   return this.pc.viewProfile(); 
  }
  
  /**
   * Method to edit the Student's profile 
   * 
   * @param firstName a String representing the first name of a Student
   * @param lastName a String representing the last name of a Student
   * @param password a String representing the password of a Student
   * @return integer representing success of edit
   */
  public int editProfile(String firstName, String lastName, String password)
  {
	  try {
   return this.pc.editProfile(firstName, lastName, password); 
	  }
	  catch (IllegalArgumentException iae) {
		  return -1;
	  }
  }
  
  /**
   * Method to view the Student's saved universities
   * 
   * @return a HashMap representing this student's saved universities
   */
  public HashMap<String, University> viewSavedUniversities()
  {
   return this.suc.viewSavedUniversities();
  }
  
	/**
	 * Method to view a specific university from searching
	 * @param universityName  the name of the university to be viewed
	 * @return a Unviersity
	 */
	public University viewUniversity(String universityName)
	{
		return sc.viewUniversity(universityName);
	}

  /**
   * Method to save a university to the Student's current list of saved universities
   * 
   * @param university the University to be saved to the Student
   * @return integer representing success of save
   */
  public int saveUniversity(University university)
  {
   return this.sc.saveUniversity(this.student, university);
  }
  
  /**
   * Method to remove a university from the Student's saved universities
   * 
   * @param university the University to be removed from the student
   * @return university 
   */
  public int removeUniversity(University university)
  {
    return this.suc.removeUniversity(university);
  }
  
  /**
	 * Method to search for universities
	 * 
	 * @param name the name of this university as a String
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
	 * @param percentFinancialAidLower  the lower bound of the percentage of enrolled students who receive financial aid
	 * @param percentFinancialAidUpper  the upper bound of the percentage of enrolled students who receive financial aid
	 * @param numApplicantsLower  the lower bound of the number of students that apply to this university
	 * @param numApplicantsUpper  the upper bound of the number of students that apply to this university
	 * @param percentAdmittedLower  the lower bound of the percent of applicants that are addmitted to this university
	 * @param percentAdmittedUpper  the upper bound of the percent of applicants that are addmitted to this university
	 * @param percentEnrolledLower  the lower bound of the percent of addmitted students that enroll at this university
	 * @param percentEnrolledUpper  the upper bound of the percent of addmitted students that enroll at this university
	 * @param academicScaleLower the lower bound of how this university rates academically 
	 * @param academicScaleUpper the upper bound of how this university rates academically
	 * @param socialScaleLower  the lower bound of how this university rates socially
	 * @param socialScaleUpper  the upper bound of how this university rates socially
	 * @param qualityOfLifeScaleLower  the lower bound of the quality of life at this university
	 * @param qualityOfLifeScaleUpper  the upper bound of the quality of life at this university
	 * @param searchEmphases  areas of study
	 * @return ArrayList<University>  found Universities
	 */
	public ArrayList<University> searchUniversities(String name, String state, String location, String control, int numStudentsLower, int numStudentsUpper, double percentFemaleLower, double percentFemaleUpper,
			double SATVerbalLower, double SATVerbalUpper, double SATMathLower, double SATMathUpper, double expensesLower, double expensesUpper, double percentFinancialAidLower, double percentFinancialAidUpper, 
			int numApplicantsLower, int numApplicantsUpper, double percentAdmittedLower, double percentAdmittedUpper, double percentEnrolledLower, double percentEnrolledUpper, 
			int academicScaleLower, int academicScaleUpper, int socialScaleLower, int socialScaleUpper, int qualityOfLifeScaleLower, int qualityOfLifeScaleUpper,  
		  ArrayList<String> searchEmphases)
  {
    return sc.searchUniversities(name, state, location, control, numStudentsLower, numStudentsUpper, percentFemaleLower, percentFemaleUpper,
                                                                    SATVerbalLower, SATVerbalUpper, SATMathLower, SATMathUpper, expensesLower, expensesUpper,percentFinancialAidLower, percentFinancialAidUpper, numApplicantsLower, numApplicantsUpper,
                                                                    percentAdmittedLower, percentAdmittedUpper, percentEnrolledLower, percentEnrolledUpper,
                                                                    academicScaleLower, academicScaleUpper, socialScaleLower, socialScaleUpper, qualityOfLifeScaleLower, qualityOfLifeScaleUpper,  
                                                                      searchEmphases); 
  }
	
	/**
	 * Method to view Universities from searching
	 * 
	 * @param foundUniversities the universities to be viewed from searching
	 * @return a HashMap representing all the schools to be viewed
	 */
	public HashMap<String, University> viewUniversities(ArrayList<University> foundUniversities)
	{
		return sc.viewUniversities(foundUniversities);
	}
  
  /**
   * method to get the recommended universities based off of a university
   *
   * @param university the university object to base the other schools off of
   *
   * @return an ArrayList of university objects
   */
  public ArrayList<University> getRecommendedUniversities(University university)
  {
   return sc.getRecommendedUniversities(university);
   
  }
  
  /**
   * Method to log the student out
   * @return true if successful log out
   */ /*
  public boolean logout()
  {
    return super.logout(this.student);
  } */
}  

