import java.util.ArrayList;

public class DBController
{
  /**
   * Construct a database controller
   */
  public DBController()
  {
  }

  /**
   * method to get a specific user based off of the given name
   *
   * @param username the username of the user
   *
   * @return a user object
   */
  public User getUser(String username)
  {
    return null;
  }

  /**
   * method to get all users from the database
   *
   * @return an ArrayList of all users
   */
  public ArrayList<User> getUsers()
  {
    return null;
  }

  /**
   * method to save an edited user to the database
   */
  public void saveEditedUser(User u)
  {

  }

  /**
   * method to add a user to the database
   *
   * @param User to add to the database
   */
  public void addUser(User u)
  {

  }

  /**
   * method to get all universities in the databse
   *
   * @return an ArrayList of all universities
   */
  public ArrayList<University> viewUniversities()
  {
    return null;
  }

  /**
   * method to get a specific university off of the name
   *
   * @param a string of the university name
   *
   * @return a University object
   */
  public University getUniversity(String name)
  {
    return null;
  }

  /**
   * method to to save an editied university
   *
   * @param university the university object to edit
   */
  public void saveEditedUniversity(University university)
  {
    university_editUniversity(university.getName(), university.getState(), university.getLocation(),
                              university.getControl(), university.getNumStudents(), university.getPercentFemale(),
                              university.getSATVerbal(), university.getSATMath(), university.getExpenses(),
                              university.getPercentFinancialAid(), university.getNumApplicants(),
                              university.percentAdmitted(), university.getPercentEnrolled(),
                              university.getAcademicScale(), university.getSocialScale(),
                              university.getQualityOfLifeScale(), university.getEmphases());
  }

  /**
   * method to add a university to the database
   *
   * @param a University object to add
   */
  public void addUniversity(University u)
  {

  }

  /**
   * method to remove a university from a specific student
   *
   * @param a Student object to remove from
   * @param a University object to remove from the student
   *
   */
  public void removeUniversityFromStudent(Student s, University u)
  {

  }

  /**
   * method to save an edited university
   *
   * @param a university object to save
   */
  public void saveUniversity(University u)
  {

  }

  /**
   * method to search all universities and return the mataching ones
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
   *
   * @return an ArrayList of all universities that match the criteria
   */
  public ArrayList<University> searchUniversities(String name,String state,String location, String control, int numStudents,
                    int percentFemale, int SATVerbal, int SATMath, int expenses, double percentFinancialAid,
                    int numApplicants, double percentAdmitted, double percentEnrolled, int academicScale, int socialScale,
                    int qualityOfLifeScale, ArrayList<String> emphases)
  {
    return null;
  }


  /**
   * method to get the recommended universities based off of a university
   *
   * @param a university object to base the other schools off of
   *
   * @return an ArrayList of univerity objects
   */
  public ArrayList<University> getRecommendedUniversities(University u)
  {
    return null;
  }



}
