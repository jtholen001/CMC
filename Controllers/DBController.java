/**
 * Class that represents a DBController
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
*/
package Controllers;

import java.lang.Math;
import java.util.ArrayList;
import dblibrary.project.csci230.*;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
import entityClasses.*;
import entityClasses.Student;

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
   * This method gets a user's data based on their username
   * 
   * @param username the username of the user to find
   * @return a user object
   */
  public User getUser(String username)
  {
    String[][] users = univDBlib.user_getUsers();
    HashMap<String, User> userMap = new HashMap<String, User>();
    boolean status;

    for(int index = 0; index < users.length; index++)
      {
    	if(users[index][0].equals(username)) {
    		if(users[index][5].equals("Y"))
    	        status = true;
    		else
    			status = false;
    		if(users[index][4].equals('u'))
    		{
 
    			return new Student(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
                      status, false, this.getUniversitiesForStudent(username));
    		}
    		else if(users[index][4].equals('a')) {
    			return new Admin(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
                        status, false);
    		}
    		else
    			return null;
    	}
      }
	return null;
  }
  
  public ArrayList<University> getUniversitiesForStudent(String username){
	  String[][] universities = univDBlib.user_getUsernamesWithSavedSchools();
	  ArrayList<University> list = new ArrayList();
	  
	  for(int i = 0; i < universities.length; i++)
	  {
		  if(universities[i].equals(username))
		  {
			  list.add(this.getUniversity(universities[i][1]));
		  }
	  }
	  return list;
  }

   
   /**
    * This method gets a list of all users in the database
    * 
    * @return a hashmap of all users
   */
  public HashMap<String,User> getUsers()
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
      if(users[index][4].equals('u'))
		{
			 userMap.put(users[index][0],new Student(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
                status, false, this.getUniversitiesForStudent(users[index][0])));
		}
		else if(users[index][4].equals('a')) {
			 userMap.put(users[index][0],new Admin(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
                  status, false));
		}
    }
    return userMap;
  }

  /**
   * This method saves edits to a user to the data base
   * 
   * @param user the user who's profile was edited
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
   * @param user the user to add to the database
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


    for(String emphasis: university.getEmphases())
    {
      univDBlib.university_addUniversityEmphasis(university.getName(), emphasis);
    }
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
   */
  public void removeUniversityFromStudent(Student s, University u)
  {
    univDBlib.user_removeSchool(s.getUsername(),u.getName());
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
    Set<String> keys = universityMap.keySet();
    HashMap<String, Double> distanceMap = new HashMap<String, Double>();

    int maxNumStudents = u.getNumStudents();
    int minNumStudents = u.getNumStudents();
    int maxPercentFemale = u.getPercentFemale();
    int minPercentFemale = u.getPercentFemale();
    int maxSATVerbal = u.getSATVerbal();
    int minSATVerbal = u.getSATVerbal();
    int maxSATMath = u.getSATMath();
    int minSATMath = u.getSATMath();
    int maxExpenses = u.getExpenses();
    int minExpenses = u.getExpenses();
    double maxPercentFinancialAid = u.getPercentFinancialAid();
    double minPercentFinancialAid = u.getPercentFinancialAid();
    int maxNumApplicants = u.getNumApplicants();
    int minNumApplicants = u.getNumApplicants();
    double maxPercentAdmitted = u.getPercentAdmitted();
    double minPercentAdmitted = u.getPercentAdmitted();
    double maxPercentEnrolled = u.getPercentEnrolled();
    double minPercentEnrolled = u.getPercentEnrolled();
    int maxAcademicScale = u.getAcademicScale();
    int minAcademicScale = u.getAcademicScale();
    int maxSocialScale = u.getSocialScale();
    int minSocialScale = u.getSocialScale();
    int maxQualityOfLifeScale = u.getQualityOfLifeScale();
    int minQualityOfLifeScale = u.getQualityOfLifeScale();

    for (String universityName : keys)
    {
      University university = universityMap.get(universityName);
      if (maxNumStudents < university.getNumStudents())
        maxNumStudents = university.getNumStudents();
      if (minNumStudents > university.getNumStudents())
        minNumStudents = university.getNumStudents();

      if (maxPercentFemale < university.getPercentFemale())
        maxPercentFemale = university.getPercentFemale();
      if (minPercentFemale > university.getPercentFemale())
        minPercentFemale = university.getPercentFemale();

      if (maxSATVerbal < university.getSATVerbal())
        maxSATVerbal = university.getSATVerbal();
      if (minSATVerbal > university.getSATVerbal())
        minSATVerbal = university.getSATVerbal();

      if (maxSATMath < university.getSATMath())
        maxSATMath = university.getSATMath();
      if (minSATMath > university.getSATMath())
        minSATMath = university.getSATMath();

      if (maxExpenses < university.getExpenses())
        maxExpenses = university.getExpenses();
      if (minExpenses > university.getExpenses())
        minExpenses = university.getExpenses();

      if (maxPercentFinancialAid < university.getPercentFinancialAid())
        maxPercentFinancialAid = university.getPercentFinancialAid();
      if (minPercentFinancialAid > university.getPercentFinancialAid())
        minPercentFinancialAid = university.getPercentFinancialAid();

      if (maxPercentAdmitted < university.getPercentAdmitted())
        maxPercentAdmitted = university.getPercentAdmitted();
      if (minPercentAdmitted > university.getPercentAdmitted())
        minPercentAdmitted = university.getPercentAdmitted();

      if (maxPercentEnrolled < university.getPercentAdmitted())
        maxPercentAdmitted = university.getPercentAdmitted();
      if (minPercentAdmitted > university.getPercentAdmitted())
        minPercentAdmitted = university.getPercentAdmitted();

      if (maxAcademicScale < university.getAcademicScale())
        maxAcademicScale = university.getAcademicScale();
      if (minAcademicScale > university.getAcademicScale())
        minAcademicScale = university.getAcademicScale();

      if (maxSocialScale < university.getSocialScale())
        maxSocialScale = university.getSocialScale();
      if (minSocialScale > university.getSocialScale())
        minSocialScale = university.getSocialScale();

      if (maxQualityOfLifeScale < university.getQualityOfLifeScale())
        maxQualityOfLifeScale = university.getQualityOfLifeScale();
      if (minQualityOfLifeScale > university.getQualityOfLifeScale())
        minQualityOfLifeScale = university.getQualityOfLifeScale();

      // emphases
    }

    int stateDistance, locationDistance, controlDistance;
    // Finds distances between all instance variables in parameter University with corresponding variables of all universities in database
    for (String universityName : keys)
    {
       // if universityName != parameter?
      if (!(u.getName().equals(universityName))) // University u can't recommend itself
      {
        // Compares state name of parameter University with universities in database
        if (universityMap.get(universityName).getName().equals(u.getName()))
          stateDistance = 0; // state names equal
        else
          stateDistance = 1; // state names not equal

        // Compares location String of parameter University with universities in database
        if (universityMap.get(universityName).getState().equals(u.getState()))
          locationDistance = 0; // location equal
        else
          locationDistance = 1; // location not equal

        // Compares control String of parameter University with universities in database
        if (universityMap.get(universityName).getControl().equals(u.getControl()))
          controlDistance = 0; // control equal
        else
          controlDistance = 1; // control not equal

          double numStudentsDistance = (Math.abs(universityMap.get(universityName).getNumStudents() - u.getNumStudents()) /
                                        Math.abs(maxNumStudents - minNumStudents));

          double percentFemaleDistance = (Math.abs(universityMap.get(universityName).getPercentFemale() - u.getPercentFemale()) /
                                          Math.abs(maxPercentFemale - minPercentFemale));

          double SATVerbalDistance = (Math.abs(universityMap.get(universityName).getSATVerbal() - u.getSATVerbal()) /
                                      Math.abs(maxSATVerbal - minSATVerbal));

          double SATMathDistance = (Math.abs(universityMap.get(universityName).getSATMath() - u.getSATMath()) /
                                    Math.abs(maxSATMath - minSATMath));

          double expensesDistance = (Math.abs(universityMap.get(universityName).getExpenses() - u.getExpenses()) /
                                     Math.abs(maxExpenses - minExpenses));

          double percentFinancialAidDistance = (Math.abs(universityMap.get(universityName).getPercentFinancialAid() - u.getPercentFinancialAid()) /
                                                Math.abs(maxPercentFinancialAid - minPercentFinancialAid));

          double numApplicantsDistance = (Math.abs(universityMap.get(universityName).getNumApplicants() - u.getNumApplicants()) /
                                          Math.abs(maxNumApplicants - minNumApplicants));

          double percentAdmittedDistance = (Math.abs(universityMap.get(universityName).getPercentAdmitted() - u.getPercentAdmitted()) /
                                          Math.abs(maxPercentAdmitted - minPercentAdmitted));

          double percentEnrolledDistance = (Math.abs(universityMap.get(universityName).getPercentEnrolled() - u.getPercentEnrolled()) /
                                            Math.abs(maxPercentEnrolled - minPercentEnrolled));

          double academicScaleDistance = (Math.abs(universityMap.get(universityName).getAcademicScale() - u.getAcademicScale()) /
                                          Math.abs(maxAcademicScale - minAcademicScale));

          double socialScaleDistance = (Math.abs(universityMap.get(universityName).getSocialScale() - u.getSocialScale()) /
                                        Math.abs(maxSocialScale - minSocialScale));

          double qualityOfLifeScaleDistance = (Math.abs(universityMap.get(universityName).getQualityOfLifeScale() - u.getQualityOfLifeScale()) /
                                               Math.abs(maxQualityOfLifeScale - minQualityOfLifeScale));

          ArrayList<String> emphases = universityMap.get(universityName).getEmphases();

          int emphasesDistance = 0;
          for (String emphasis : emphases)
          {
            if (!(u.getEmphases().contains(emphasis)))
              emphasesDistance = emphasesDistance - 1;
          }

          double totalDistance = stateDistance + locationDistance + controlDistance + numStudentsDistance + percentFemaleDistance + SATVerbalDistance +
          SATMathDistance + expensesDistance + percentFinancialAidDistance + numApplicantsDistance + percentAdmittedDistance + percentEnrolledDistance +
          academicScaleDistance + socialScaleDistance + qualityOfLifeScaleDistance + emphasesDistance;

          distanceMap.put(universityName, totalDistance);
    }
  }

    // sorts distance map by value in ascending order, adds universityNames to ArrayList to return
    HashMap<String, Double> sortedDistances = new HashMap<String, Double>();
    List<Double> sortedValues = new ArrayList<Double>(distanceMap.values());
    Collections.sort(sortedValues);
    Iterator<Double> values = sortedValues.iterator();

    ArrayList<String> recommendedUniversityNames = new ArrayList<String>();
    while ((values.hasNext()) && (recommendedUniversityNames.size() < 5))
    {
      double temp = values.next();
      for (String universityName : keys)
      {
        if (distanceMap.get(universityName) == temp)
          recommendedUniversityNames.add(universityName);
      }
    }
    
    // creates University objects from sorted University names to return
    ArrayList<University> recommendedUniversities = new ArrayList<University>();
    for (String universityName : recommendedUniversityNames)
    {
      recommendedUniversities.add(this.getUniversity(universityName));
    }
    
    return recommendedUniversities;
  }
}
