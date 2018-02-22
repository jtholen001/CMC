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
  }
}