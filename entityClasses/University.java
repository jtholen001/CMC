/**
 * This class represents a University
 * @Author Michael Carroll, Brandan Kalsow, Nicholas Tawil, Jordan Tholen, Ryan Strelow
 * @Version 2/20/2020
 */
import java.util.ArrayList;

public class University
{
  /**
   * The name of this university
   */
  private String name;
  
  /**
   * The state this university is located in
   */
  private String state;
  
  /**
   * Whether this university is in an urban or rural location
   */
  private String location;
  
  /**
   * Whether this university is publicly or privatley or owned
   */
  private String control;
  
  /**
   * The number of students enrolled at this university
   */
  private int numStudents;
  
  /**
   * The percentage of enrolled students that are female
   */
  private int percentFemale;
  
  /**
   * The average SAT Verbal score of students enrolled at the university
   */
  private int SATVerbal;
  
  /**
   * The average SAT Math score of students enrolled at the university
   */
  private int SATMath;
  
  /**
   * The average cost to attend the university
   */
  private int expenses;
  
  /**
   * The percentage of students enrolled at the university that recieve financial aid
   */
  private double percentFinancialAid;
  
  /**
   * The number of people who apply to the university
   */
  private int numApplicants;
  
  /**
   * The percentage of applicants who are admitted to the university
   */
  private double percentAdmitted;
  
  /**
   * The percentage of accepted applicants who enroll at the university
   */
  private double percentEnrolled;
  
  /**
   * How the university rates academically
   */
  private int academicScale;
  
  /**
   * How the university rates socially
   */
  private int socialScale;
  
  /**
   * How the quality of life at the university rates compared to other universities
   */
  private int qualityOfLifeScale;
  
  /**
   * The areas of study that the university emphasizes in
   */
  private ArrayList<String> emphases;
  
  /**
   * Creates a new instance of the University class
   * 
   * @param name the name of this university as a String
   * @param state the state this university is located in as a String
   * @param location whether the university is located in and urban or rural setting
   * @param control whether this university is publicly
   * @param numStudents the number of students enrolled at this university
   * @param percentFemale the percentage of enrolled students that are female
   * @param SATVerbal the average SAT Verbal score of the students enrolled at this university
   * @param SATMath the average SAT Math score of the students enrolled at this university
   * @param expenses the cost to attend this university
   * @param percentFinancialAid the percentage of enrolled students who recieve financial aid
   * @param numApplicants the number of students that apply to this university
   * @param percentAdmitted the percent of applicants that are addmitted to this university
   * @param percentEnrolled the percent of addmitted students that enroll at this university
   * @param academicScale how this university rates academically
   * @param socialScale how this university rates socially
   * @param qualityOfLifeScale the quality of life at this university
   * @param emphases what areas of study this university emphasizes
   */
  public University(String name,String state,String location, String control, int numStudents, 
                    int percentFemale, int SATVerbal, int SATMath, int expenses, double percentFinancialAid, 
                    int numApplicants, double percentAdmitted, double percentEnrolled, int academicScale, int socialScale,
                    int qualityOfLifeScale, ArrayList<String> emphases)
  {
   this.name = name;
   this.state = state;
   this.location = location;
   this.control = control;
   this.numStudents = numStudents;
   this.percentFemale = percentFemale;
   this.SATVerbal = SATVerbal;
   this.SATMath = SATMath;
   this.expenses = expenses;
   this.percentFinancialAid = percentFinancialAid;
   this.numApplicants = numApplicants;
   this.percentAdmitted = percentAdmitted;
   this.percentEnrolled = percentEnrolled;
   this.academicScale = academicScale;
   this.socialScale = socialScale;
   this.qualityOfLifeScale = qualityOfLifeScale;
   this.emphases = emphases;
  }
  
  /**
   * This method gets the name of the university for use elsewhere
   * 
   * @return the name of this university as a String
   */
  private String getName()
  {
    return this.name;
  }
  
  /**
   * This method gets the state where this university is located
   * 
   * @return the state this university is located in as a String
   */
  private String getState()
  {
    return this.state;
  }
  
  /**
   * This method gets what setting the university is located in
   * 
   * @return the location of the university (Urban or rural) as a String
   */
  private String getLocation()
  {
    return this.location;
  }
  
  /**
   * This method gets the control of the university
   * 
   * @param the control of the university (public, private, etc) as a String
   */
  private String getControl()
  {
    return this.control;
  }
  
  /**
   * This method gets the number of students enrolled at the university
   * 
   * @return the number of students enrolled at the university as an integer
   */
  private int getNumStudents()
  {
    return this.numStudents;
  }
  
  /**
   * This method gets the percentage of enrolled students that are female
   * 
   * @return the percentage of students that are female as an int
   */
  private int getPercentFemale()
  {
    return this.percentFemale;
  }
  
  /**
   * This method gets the average SAT Verbal score of students at the university
   * 
   * @return the average SAT Verbal score of students enrolled at the university as an int
   */
  private int getSATVerbal()
  {
    return this.SATVerbal;
  }
  
  /**
   * This method gets the average SAT Math score of students enrolled at the university
   * 
   * @return the average SAT Math score of students enrolled at the university as an int
   */
  private int getSATMath()
  {
    return this.SATMath;
  }
  
  /**
   * This method gets the average expenses to attend the university
   * 
   * @return the average expenses to attend the university as an int
   */
  private int getExpenses()
  {
    return this.expenses;
  }
  
  /**
   * This method gets the percentage of students enrolled at this university that recieve financial aid
   * 
   * @return the percentage of students  enrolled at this university that recieve financial aid as a double
   */
  private double getPercentFinancialAid()
  {
    return this.percentFinancialAid;
  }
  
  /**
   * This method gets the number of students that applied to study at the university
   * 
   * @return the number of students that applied to study at this university as an int
   */
  private int getNumApplicants()
  {
    return this.numApplicants;
  }
  
  /**
   * This method gets the number of applicants that were addmitted to the university
   * 
   * @return the percentage of applicants that were accepted to the university as a double
   */
  private double percentAdmitted()
  {
    return this.percentAdmitted;
  }
  
  /**
   * This method gets the percentage of accepted applicants that enroll at the university
   * 
   * @param the percentage of accepted applicants that there enrolled at the university as a double
   */
  private double getPercentEnrolled()
  {
    return this.percentEnrolled;
  }
  
  /**
   * This method gets how the university rates academically
   * 
   * @return the academic rating of this university as an integer
   */
  private int getAcademicScale()
  {
    return this.academicScale;
  }
  
  /**
   * This method gets how the university rates socially
   * 
   * @return the social rating of this school as an integer
   */
  private int getSocialScale()
  {
    return this.socialScale;
  }
  
  /**
   * This method gets how the quality of life rates at the university
   *
   * @return the rating of the quality of life at the university as an integer
   */
  private int getQualityOfLifeScale()
  {
    return this.qualityOfLifeScale;
  }
  
  /**
   * This method gets the areas of study that this university emphasizes in
   * 
   * @return the emphases of this university as an ArrayList of Strings
   */
  private ArrayList<String> getEmphases()
  {
    return this.emphases;
  }
  
    /**
   * This method sets the name of this university
   * 
   * @param newName the new name for this university
   */
  private void setName(String newName)
  {
    this.name = newName;
  }
  
  /**
   * This method sets the state where this university is located
   * 
   * @param newState the new state this university is located in
   */
  private void setState(String newState)
  {
    this.state = newState;
  }
  
  /**
   * This method sets what setting the university is located in
   * 
   * @param newLocation the new location of the university (Urban or rural)
   */
  private void setLocation(String newLocation)
  {
    this.location = newLocation;
  }
  
  /**
   * This method sets the control of the university
   * 
   * @param the new control of the university (public, private, etc)
   */
  private void setControl(String newControl)
  {
    this.control = newControl;
  }
  
  /**
   * This method sets the number of students enrolled at the university
   * 
   * @param newNumStudents the  new number of students enrolled at the university
   */
  private void setNumStudents(int newNumStudents)
  {
    this.numStudents = newNumStudents;
  }
  
  /**
   * This method sets the percentage of enrolled students that are female
   * 
   * @param the new percentage of students that are female
   */
  private  void setPercentFemale(int newPercentFemale)
  {
    this.percentFemale = newPercentFemale;
  }
  
  /**
   * This method sets the average SAT Verbal score of students at the university
   * 
   * @param newSATVerbal the new average SAT Verbal score of students enrolled at the university
   */
  private void setSATVerbal(int newSATVerbal)
  {
    this.SATVerbal = newSATVerbal;
  }
  
  /**
   * This method sets the average SAT Math score of students enrolled at the university
   * 
   * @param newSATMath the new average SAT Math score of students enrolled at the university
   */
  private void setSATMath(int newSATMath)
  {
    this.SATMath = newSATMath;
  }
  
  /**
   * This method sets the average expenses to attend the university
   * 
   * @param newExpenses the average expenses to attend the university
   */
  private void setExpenses(int newExpenses)
  {
    this.expenses = newExpenses;
  }
  
  /**
   * This method sets the percentage of students enrolled at this university that recieve financial aid
   * 
   * @param newPercentFinancialAid the new percentage of students  enrolled at this university that recieve financial aid
   */
  private void setPercentFinancialAid(double newPercentFinancialAid)
  {
    this.percentFinancialAid = newPercentFinancialAid;
  }
  
  /**
   * This method sets the number of students that applied to study at the university
   * 
   * @param newNumApplicants the new number of students that applied to study at this university
   */
  private void setNumApplicants(int newNumApplicants)
  {
    this.numApplicants = newNumApplicants;
  }
  
  /**
   * This method sets the number of applicants that were addmitted to the university
   * 
   * @param newPercentAdmitted the new percentage of applicants that were accepted to the university
   */
  private void percentAdmitted(double newPercentAdmitted) 
  {
    this.percentAdmitted = newPercentAdmitted;
  }
  
  /**
   * This method sets the percentage of accepted applicants that enroll at the university
   * 
   * @param newPercentEnrolled the new percentage of accepted applicants that there enrolled at the university
   */
  private void setPercentEnrolled(double newPercentEnrolled)
  {
    this.percentEnrolled = newPercentEnrolled;
  }
  
  /**
   * This method sets how the university rates academically
   * 
   * @param newAcademicScale the new academic rating of this university
   */
  private void setAcademicScale(int newAcademicScale)
  {
    this.academicScale = newAcademicScale;
  }
  
  /**
   * This method sets how the university rates socially
   * 
   * @param newSocialScale the new social rating of this school
   */
  private void setSocialScale(int newSocialScale)
  {
    this.socialScale = newSocialScale;
  }
  
  /**
   * This method sets how the quality of life rates at the university
   *
   * @param newQualityOfLifeScale the new rating of the quality of life at the university
   */
  private void setQualityOfLifeScale(int newQualityOfLifeScale)
  {
    this.qualityOfLifeScale = newQualityOfLifeScale;
  }
  
  /**
   * This method sets the areas of study that this university emphasizes in
   * 
   * @param newEmphases the new emphases of this university
   */
  private void setEmphases(ArrayList<String> newEmphases)
  {
    this.emphases = newEmphases;
  }
}