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
	  boolean status = false;

	  for(int index = 0; index < users.length; index++)
	  {
		  if(users[index][2].equals(username)) 
		  {
			  if(users[index][5].equals("Y"))
				  status = true;
			  
			  if(users[index][4].equals("u"))
			  {

				  return new Student(users[index][0],users[index][1],users[index][2],users[index][3],'u',
						  status, false, this.getUniversitiesForStudent(username));
			  }
			  else
			  {
				  return new Admin(users[index][0],users[index][1],users[index][2],users[index][3],'a',
						  status, false);
			  }
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
    userMap.put(users[index][2],new Student(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
                status, false, this.getUniversitiesForStudent(users[index][0])));
  }
  else if(users[index][4].equals("a")) {
    userMap.put(users[index][2],new Admin(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
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

  //TODO: change saveEditiedUser to not save schools and to create a save schools method
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
      if(this.checkSavedUniversities(stu) == -1)
    	  return -1;
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
   * @return an int representing the success of adding a user
   */

  public int addUser(User user)
  {
    int success = univDBlib.user_addUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getType());
    
    if(user instanceof Student)
	  {
		  Student temp = (Student)user;
		  if(!((Student) temp).getSavedSchools().isEmpty())
		  {
			  this.checkSavedUniversities(temp);
		  }
	  }
    
    return success;
  }

  /**
   * method to delete a user from the database
   * 
   * @param username the user to be deleted
   * 
   * @return an int representing the success of deleting a user
   */
  public int deleteUser(String username)
  {
	  User user = this.getUser(username);
	  if(user instanceof Student) {
		  return univDBlib.user_deleteUser(username);
	  }
	  return 1;
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
                                                               Integer.parseInt(universities[index][4]), new Double(universities[index][5]),
                                         new Double(universities[index][6]), new Double(universities[index][7]), new Double(universities[index][8]),
                                         new Double(universities[index][9]), Integer.parseInt(universities[index][10]),new Double(universities[index][11]),
                                         new Double(universities[index][12]), Integer.parseInt(universities[index][13]), Integer.parseInt(universities[index][14]),
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
   * @return an int representing the success of saving an edited university
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
   * @return int representing success of adding university
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
   * @return int representing success of removing university
   */
  public int deleteUniversity(University university)
  {
	  if(!(this.deleteUniversityEmphases(university) == 1))
	  {
		  return -1;
	  }
	  
	  if(!(this.deleteSavedUsersForUniversity(university) == 1))
	  {
		  return -1;
	  }
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

  
  private int deleteUniversityEmphases(University university)
  {
	  ArrayList<String> emphases = this.getUniversityEmphases(university.getName());
	  
	  for(String str : emphases)
	  {
		  if(!(univDBlib.university_removeUniversityEmphasis(university.getName(), str) == 1))
			  return -1;
	  }
	  
	  return 1;
  }
  
  private int deleteSavedUsersForUniversity(University university)
  {
	   String[][] universities = univDBlib.user_getUsernamesWithSavedSchools();
	   
	   for(int i = 0; i < universities.length; i++)
	   {
	    if(universities[i][1].equals(university.getName()))
	    {
	    	if(!(univDBlib.user_removeSchool(universities[i][0], universities[i][1]) == 1))
	    		return -1;
	    }
	   }
	  
	  return 1;
  }
  
  private int checkSavedUniversities(Student student)
  {
	  ArrayList<University> databaseList = this.getUniversitiesForStudent(student.getUsername());
	  
	  for(University uni : student.getSavedSchools())
	  {
		  if(!(databaseList.contains(uni)))
		  {
			  if(this.getUniversity(uni.getName()) == null)
			  {
				  throw new IllegalArgumentException("Saved schools in student contains a school not in the databse");
			  }
			  univDBlib.user_saveSchool(student.getUsername(), uni.getName());
			  databaseList.add(uni);
		  }
			  
	  }
	  ArrayList<University> studentList = student.getSavedSchools();
	  for(University uni : this.getUniversitiesForStudent(student.getUsername()))
	  {
		  if(!(studentList.contains(uni)))
		  {
			  univDBlib.user_removeSchool(student.getUsername(), uni.getName());
			  databaseList.remove(uni);
		  }
	  }
	  if(databaseList.size() != studentList.size())
	  {
		  throw new IndexOutOfBoundsException("Saved schools in student and database do not match in size "
		  		+ "after an attempted save");
	  }
  return 1;
  }
}
