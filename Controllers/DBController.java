/**
 * Class that represents a DBController
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
*/
package Controllers;

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
	  boolean status;

	  for(int index = 0; index < users.length; index++)
	  {
		  if(users[index][2].equals(username)) {
			  if(users[index][5].equals("Y"))
				  status = true;
			  else
				  status = false;
			  if(users[index][4].equals("u"))
			  {

				  return new Student(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
						  status, false, this.getUniversitiesForStudent(username));
			  }
			  else if(users[index][4].equals("a")) {
				  return new Admin(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
						  status, false);
			  }
			  else
				  return null;
		  }
	  }
	  return null;
  }

  /**
   * This method gets the list of schools that the given user has saved.
   * 
   * @param username the username of the user to get the saved schools for
   * 
   * @return an ArrayList of universities the student has saved
   */
  public ArrayList<University> getUniversitiesForStudent(String username)
  {
   String[][] universities = univDBlib.user_getUsernamesWithSavedSchools();
   ArrayList<University> list = new ArrayList<University>();
   
   for(int i = 0; i < universities.length; i++)
   {
    if(universities[i][0].equals(username))
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
      if(users[index][4].equals("u"))
  {
    userMap.put(users[index][0],new Student(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
                status, false, this.getUniversitiesForStudent(users[index][0])));
  }
  else if(users[index][4].equals("a")) {
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

  public <t extends User> int saveEditedUser(t user)
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
    //returns -1 if an error is encountered
    return univDBlib.user_editUser(user.getUsername(),user.getFirstName(),user.getLastName(),user.getPassword(),user.getType(),
                            temp);
  }

  /**
   * method to add a user to the database
   *
   * @param user the user to add to the database
   * 
   * @return -1 if unsuccessful, 0 otherwise
   */

  public int addUser(User user)
  {
    int success = univDBlib.user_addUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getType());
    return success;
  }

  /**
   * method to delete a user from the database
   * 
   * @param username the user to be deleted
   * 
   * @return -1 if unsuccessful, 0 otherwise
   */
  public int deleteUser(String username)
  {
  return univDBlib.user_deleteUser(username);
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
                                         Integer.parseInt(universities[index][15]), getUniversityEmphases(universities[index][0]))); //not sure how emphases are stored
    }
    return universityMap;
  }

  /**
   * method to get a specific university off of the name
   *
   * @param name the string of the university to find
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
                                         Integer.parseInt(universities[index][15]), getUniversityEmphases(name)));  
    }

    return universityMap.get(name.toUpperCase());



  }
  
  private ArrayList<String> getUniversityEmphases(String universityName) {
    
   ArrayList<String>  retList = new ArrayList<String>();
   String[][] emphases = univDBlib.university_getNamesWithEmphases();
   
   for(int i = 0; i < emphases.length; i++)
   {
    if(emphases[i][0].equals(universityName)) {
     retList.add(emphases[i][1]);
    }   
   }
   return retList;
  }

  /**
   * method to to save an editied university
   *
   * @param university the university object to edit
   * 
   * @return -1 if unsucessfull, 0 otherwise
   */
  public int saveEditedUniversity(University university)
  {
    int success = univDBlib.university_editUniversity(university.getName(), university.getState(), university.getLocation(),
                              university.getControl(), university.getNumStudents(), university.getPercentFemale(),
                              university.getSATVerbal(), university.getSATMath(), university.getExpenses(),
                              university.getPercentFinancialAid(), university.getNumApplicants(),
                              university.getPercentEnrolled(), university.getPercentEnrolled(),
                              university.getAcademicScale(), university.getSocialScale(),
                              university.getQualityOfLifeScale());

    ArrayList<String> storedVals = getUniversityEmphases(university.getName());
    for(String emphases: university.getEmphases())
    {
     if(!(storedVals.contains(emphases))){
      univDBlib.university_addUniversityEmphasis(university.getName(), emphases);
     }
    }
    return success;
  }

  /**
   * method to add a university to the database
   *
   * @param university the University object to add to the database
   * 
   * @return -1 if unsucessful, 0 otherwise
   */
  public int addUniversity(University university)
  {
    int ret =  univDBlib.university_addUniversity(university.getName().toUpperCase(), university.getState().toUpperCase(), university.getLocation().toUpperCase(),
                              university.getControl().toUpperCase(), university.getNumStudents(), university.getPercentFemale(),
                              university.getSATVerbal(), university.getSATMath(), university.getExpenses(),
                              university.getPercentFinancialAid(), university.getNumApplicants(),
                              university.getPercentAdmitted(), university.getPercentEnrolled(),
                              university.getAcademicScale(), university.getSocialScale(),
                              university.getQualityOfLifeScale());
    
    if (!(university.getEmphases().equals(null)))
    {
     for(int i = 0; i < university.getEmphases().size(); i++)
     {
      univDBlib.university_addUniversityEmphasis(university.getName(), university.getEmphases().get(i));
     }
    }
    return ret;
  }
  
  /**
   * this method removes a University from the database
   * 
   * @param university the university to remove from the database
   * @return -1 if unsucessfull, 0 otherwise
   */
  public int deleteUniversity(University university)
  {
   return univDBlib.university_deleteUniversity(university.getName());
  }

  /**
   * method to remove a university from a specific student
   *
   * @param student the Student object to remove the university from
   * @param university the University object to remove from the student's list of saved schools
   */
  public int removeUniversityFromStudent(Student student, University university)
  {
    return univDBlib.user_removeSchool(student.getUsername(),university.getName());
  }


  /**
   * method to get the recommended universities based off of a university
   *
   * @param u the university object to base the other schools off of
   *
   * @return an ArrayList of university objects similar to the provided university
   */
  public ArrayList<University> getRecommendedUniversities(University u)
  {
    HashMap<String, University> universityMap = this.viewUniversities();
    Set<String> keys = universityMap.keySet();
    HashMap<String, Double> distanceMap = new HashMap<String, Double>();

    int maxNumStudents = u.getNumStudents();
    int minNumStudents = u.getNumStudents();
    double maxPercentFemale = u.getPercentFemale();
    double minPercentFemale = u.getPercentFemale();
    double maxSATVerbal = u.getSATVerbal();
    double minSATVerbal = u.getSATVerbal();
    double maxSATMath = u.getSATMath();
    double minSATMath = u.getSATMath();
    double maxExpenses = u.getExpenses();
    double minExpenses = u.getExpenses();
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
      if (maxNumStudents != -1 || minNumStudents != -1 || university.getNumStudents() != -1)
      {
    	  if (maxNumStudents < university.getNumStudents())
    		  maxNumStudents = university.getNumStudents();
    	  if (minNumStudents > university.getNumStudents())
    		  minNumStudents = university.getNumStudents();
      }

      if (maxPercentFemale != -1 || minPercentFemale != -1 || university.getPercentFemale() != -1)
      {
    	  if (maxPercentFemale < university.getPercentFemale())
    		  maxPercentFemale = university.getPercentFemale();
    	  if (minPercentFemale > university.getPercentFemale())
    		  minPercentFemale = university.getPercentFemale();
      }

      if (maxSATVerbal != -1 || minSATVerbal != -1 || university.getSATVerbal() != -1)
      {
    	  if (maxSATVerbal < university.getSATVerbal())
    		  maxSATVerbal = university.getSATVerbal();
    	  if (minSATVerbal > university.getSATVerbal())
    		  minSATVerbal = university.getSATVerbal();
      }

      if (maxSATMath != -1 || minSATMath != -1 || university.getSATMath() != -1)
      {
    	  if (maxSATMath < university.getSATMath())
    		  maxSATMath = university.getSATMath();
    	  if (minSATMath > university.getSATMath())
    		  minSATMath = university.getSATMath();
      }

      if (maxExpenses != -1 || minExpenses != -1 || university.getExpenses() != -1)
      {
    	  if (maxExpenses < university.getExpenses())
    		  maxExpenses = university.getExpenses();
    	  if (minExpenses > university.getExpenses())
    		  minExpenses = university.getExpenses();
      }

      if (maxPercentFinancialAid != -1 || minPercentFinancialAid != -1 || university.getPercentFinancialAid() != -1)
      {
    	  if (maxPercentFinancialAid < university.getPercentFinancialAid())
    		  maxPercentFinancialAid = university.getPercentFinancialAid();
    	  if (minPercentFinancialAid > university.getPercentFinancialAid())
    		  minPercentFinancialAid = university.getPercentFinancialAid();
      }

      if (maxNumApplicants != -1 || minNumApplicants != -1 || university.getNumApplicants() != -1)
      {
    	  if (maxNumApplicants < university.getNumApplicants())
    		  maxNumApplicants = university.getNumApplicants();
    	  if (minNumApplicants > university.getNumApplicants())
    		  minNumApplicants = university.getNumApplicants();
      }

      if (maxPercentAdmitted != -1 || minPercentAdmitted != -1 || university.getPercentAdmitted() != -1)
      {
    	  if (maxPercentAdmitted < university.getPercentAdmitted())
    		  maxPercentAdmitted = university.getPercentAdmitted();
    	  if (minPercentAdmitted > university.getPercentAdmitted())
    		  minPercentAdmitted = university.getPercentAdmitted();
      }
      
      if (maxPercentEnrolled != -1 || minPercentEnrolled != -1 || university.getPercentEnrolled() != -1)
      {
    	  if (maxPercentEnrolled < university.getPercentEnrolled())
    		  maxPercentEnrolled = university.getPercentEnrolled();
    	  if (minPercentEnrolled > university.getPercentEnrolled())
    		  minPercentEnrolled = university.getPercentEnrolled();
      }

      if (maxAcademicScale != -1 || minAcademicScale != -1 || university.getAcademicScale() != -1)
      {
    	  if (maxAcademicScale < university.getAcademicScale())
    		  maxAcademicScale = university.getAcademicScale();
    	  if (minAcademicScale > university.getAcademicScale())
    		  minAcademicScale = university.getAcademicScale();
      }

      if (maxSocialScale != -1 || minSocialScale != -1 || university.getSocialScale() != -1)
      {
    	  if (maxSocialScale < university.getSocialScale())
    		  maxSocialScale = university.getSocialScale();
    	  if (minSocialScale > university.getSocialScale())
    		  minSocialScale = university.getSocialScale();
      }

      if (maxQualityOfLifeScale != -1 || minQualityOfLifeScale != -1 || university.getQualityOfLifeScale() != -1)
      {
    	  if (maxQualityOfLifeScale < university.getQualityOfLifeScale())
    		  maxQualityOfLifeScale = university.getQualityOfLifeScale();
    	  if (minQualityOfLifeScale > university.getQualityOfLifeScale())
    		  minQualityOfLifeScale = university.getQualityOfLifeScale();
      }

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

        double numStudentsDistance = 0;
        double percentFemaleDistance = 0;
        double SATVerbalDistance = 0;
        double SATMathDistance = 0;
        double expensesDistance = 0;
        double percentFinancialAidDistance = 0;
        double numApplicantsDistance = 0;
        double percentAdmittedDistance  = 0;
        double percentEnrolledDistance = 0;
        double academicScaleDistance = 0;
        double socialScaleDistance = 0;
        double qualityOfLifeScaleDistance = 0;
        
        if (maxNumStudents != -1 || minNumStudents != -1)
          numStudentsDistance = (Math.abs(universityMap.get(universityName).getNumStudents() - u.getNumStudents()) /
                                        Math.abs(maxNumStudents - minNumStudents));

        if (maxPercentFemale != -1 || minPercentFemale != -1)
          percentFemaleDistance = (Math.abs(universityMap.get(universityName).getPercentFemale() - u.getPercentFemale()) /
                                          Math.abs(maxPercentFemale - minPercentFemale));

        if (maxSATVerbal != -1 || minSATVerbal != -1)
          SATVerbalDistance = (Math.abs(universityMap.get(universityName).getSATVerbal() - u.getSATVerbal()) /
                                      Math.abs(maxSATVerbal - minSATVerbal));

        if (maxSATMath != -1 || minSATMath != -1)
          SATMathDistance = (Math.abs(universityMap.get(universityName).getSATMath() - u.getSATMath()) /
                                    Math.abs(maxSATMath - minSATMath));

        if (maxExpenses != -1 || minExpenses != -1)
          expensesDistance = (Math.abs(universityMap.get(universityName).getExpenses() - u.getExpenses()) /
                                     Math.abs(maxExpenses - minExpenses));

        if (maxPercentFinancialAid != -1 || minPercentFinancialAid != -1)
          percentFinancialAidDistance = (Math.abs(universityMap.get(universityName).getPercentFinancialAid() - u.getPercentFinancialAid()) /
                                                Math.abs(maxPercentFinancialAid - minPercentFinancialAid));

        if (maxNumApplicants != -1 || minNumApplicants != -1)
          numApplicantsDistance = (Math.abs(universityMap.get(universityName).getNumApplicants() - u.getNumApplicants()) /
                                          Math.abs(maxNumApplicants - minNumApplicants));

        if (maxPercentAdmitted != -1 || minPercentAdmitted != -1)
          percentAdmittedDistance = (Math.abs(universityMap.get(universityName).getPercentAdmitted() - u.getPercentAdmitted()) /
                                          Math.abs(maxPercentAdmitted - minPercentAdmitted));

        if (maxPercentEnrolled != -1 || minPercentEnrolled != -1)
          percentEnrolledDistance = (Math.abs(universityMap.get(universityName).getPercentEnrolled() - u.getPercentEnrolled()) /
                                            Math.abs(maxPercentEnrolled - minPercentEnrolled));

        if (maxAcademicScale != -1 || minAcademicScale != -1)
          academicScaleDistance = (Math.abs(universityMap.get(universityName).getAcademicScale() - u.getAcademicScale()) /
                                          Math.abs(maxAcademicScale - minAcademicScale));

        if (maxSocialScale != -1 || minSocialScale != -1)
          socialScaleDistance = (Math.abs(universityMap.get(universityName).getSocialScale() - u.getSocialScale()) /
                                        Math.abs(maxSocialScale - minSocialScale));

        if (maxQualityOfLifeScale != -1 || minQualityOfLifeScale != -1)
          qualityOfLifeScaleDistance = (Math.abs(universityMap.get(universityName).getQualityOfLifeScale() - u.getQualityOfLifeScale()) /
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
     if (!(u.getName().equals(universityName)))
     {
      if (distanceMap.get(universityName) == temp)
       recommendedUniversityNames.add(universityName);
     }
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
