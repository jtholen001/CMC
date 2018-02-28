/**
 * Class that represents a DBController
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
*/


import java.util.ArrayList;
import dblibrary.project.csci230.*;
import java.util.HashMap;


public class DBController
{
  /**
   * Construct a database controller
   */
   private UniversityDBLibrary univDBlib = new UniversityDBLibrary("byteme","byteme","csci230");

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
    String[][] users = univDBlib.user_getUsers();
    HashMap<String, User> userMap = new HashMap<String, User>();
    boolean status;

    for(int index = 0; index < users.length; index++)
    {
      //gets the char character of if they are activated and sets a bool value to be used when creating the user
      if(users[index][5].equals("Y"))
        status = true;
      else
        status = false;
      //creates the user and puts it in the map
      userMap.put(users[index][0], new User(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
                                            status, false));
    }
    return userMap.get(username);
  }

  /**
   * method to get all users from the database
   *
   * @return a hashmap of all users
   */
  public HashMap<String, User> getUsers()
  {
    String[][] users = univDBlib.user_getUsers();
    HashMap<String, User> userMap = new HashMap<String, User>();
    boolean status;

    for(int index = 0; index < users.length; index++)
    {
      //gets the char character of if they are activated and sets a bool value to be used when creating the user
      if(users[index][5].equals("Y"))
        status = true;
      else
        status = false;
      //creates the user and puts it in the map
      userMap.put(users[index][0], new User(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
                                            status, false));
    }
    return userMap;
  }

  /**
   * method to save an edited user to the database
   */
  public <t extends User> void saveEditedUser(t user)
  {
    char temp;
    if(user.getActivationStatus() == false)
      temp = 'N';
    else
      temp = 'Y';
    
    if(user instanceof Student)
    {
      Student stu = (Student)user;
      for(University univ: stu.getSavedSchools())
      {
        univDBlib.user_saveSchool(user.getUsername(),univ.getName());
      }
    }
    univDBlib.user_editUser(user.getUsername(),user.getFirstName(),user.getLastName(),user.getPassword(),user.getType(),
                            temp);
  }

  /**
   * method to add a user to the database
   *
   * @param User to add to the database
   */
  public void addUser(User user)
  {
    univDBlib.user_addUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getType());
  }

  /**
   * method to get all universities in the databse
   *
   * @return a hashmap of all universities where the univ name is the key and the University object is a value
   */
  public HashMap<String, University> viewUniversities()
  {
    String[][] universities = univDBlib.university_getUniversities();
    HashMap<String, University> universityMap = new HashMap<String, University>();

    for(int index = 0; index < universities.length; index++)
    {
      universityMap.put(universities[index][0], new University(universities[index][0], universities[index][1],
                                                               universities[index][2],universities[index][3],
                                                               Integer.parseInt(universities[index][4]), Integer.parseInt(universities[index][5]),
                                         Integer.parseInt(universities[index][6]), Integer.parseInt(universities[index][7]), Integer.parseInt(universities[index][8]),
                                         Integer.parseInt(universities[index][9]), Integer.parseInt(universities[index][10]),Integer.parseInt(universities[index][11]),
                                         Integer.parseInt(universities[index][12]), Integer.parseInt(universities[index][13]), Integer.parseInt(universities[index][14]),
                                         Integer.parseInt(universities[index][15]), null)); //not sure how emphases are stored
    }
    return universityMap;
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
    String[][] universities = univDBlib.university_getUniversities();
    HashMap<String, University> universityMap = new HashMap<String, University>();

    for(int index = 0; index < universities.length; index++)
    {
      universityMap.put(universities[index][0], new University(universities[index][0], universities[index][1],
                                                               universities[index][2],universities[index][3],
                                                               Integer.parseInt(universities[index][4]), Integer.parseInt(universities[index][5]),
                                         Integer.parseInt(universities[index][6]), Integer.parseInt(universities[index][7]), Integer.parseInt(universities[index][8]),
                                         Integer.parseInt(universities[index][9]), Integer.parseInt(universities[index][10]),Integer.parseInt(universities[index][11]),
                                         Integer.parseInt(universities[index][12]), Integer.parseInt(universities[index][13]), Integer.parseInt(universities[index][14]),
                                         Integer.parseInt(universities[index][15]), null)); //not sure how emphases are stored
    }

    return universityMap.get(name);



  }

  /**
   * method to to save an editied university
   *
   * @param university the university object to edit
   */
  public void saveEditedUniversity(University university)
  {
    univDBlib.university_editUniversity(university.getName(), university.getState(), university.getLocation(),
                              university.getControl(), university.getNumStudents(), university.getPercentFemale(),
                              university.getSATVerbal(), university.getSATMath(), university.getExpenses(),
                              university.getPercentFinancialAid(), university.getNumApplicants(),
                              university.getPercentEnrolled(), university.getPercentEnrolled(),
                              university.getAcademicScale(), university.getSocialScale(),
                              university.getQualityOfLifeScale());
  }

  /**
   * method to add a university to the database
   *
   * @param a University object to add
   */
  public void addUniversity(University university)
  {
    univDBlib.university_addUniversity(university.getName(), university.getState(), university.getLocation(),
                              university.getControl(), university.getNumStudents(), university.getPercentFemale(),
                              university.getSATVerbal(), university.getSATMath(), university.getExpenses(),
                              university.getPercentFinancialAid(), university.getNumApplicants(),
                              university.getPercentEnrolled(), university.getPercentEnrolled(),
                              university.getAcademicScale(), university.getSocialScale(),
                              university.getQualityOfLifeScale());
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
    univDBlib.user_removeSchool(s.getUsername(),u.getName());
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
    HashMap<String, University> universityMap = this.viewUniversities();
    HashMap<String, University> distanceMap = new HashMap<String, double>();

    String[] keys = universityMap.keySet();
    for (String universityName : keys)
    {
      University targetUniversity = universityMap.get(universityName);

    }

  }



}
