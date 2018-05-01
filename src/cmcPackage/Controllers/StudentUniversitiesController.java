/**
 * Class that emcompasses functionalities relating to a Student's saved universities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 5/2/18
 */
package cmcPackage.Controllers;

import java.util.ArrayList;
import java.util.HashMap;

import cmcPackage.entityClasses.*;

public class StudentUniversitiesController
{
  /**
   * DBController that will be accessed by the SearchController
   */
  private DBController dbc;
  
  /**
   * Student that has the Universities to be controlled
   */
  private Student student;
  
  /**
   * Constructor for a StudentUniversitiesController
   * @param student the student that has the Universities to be controlled
   */
  public StudentUniversitiesController(Student student, DBController db)
  {
    this.student = student;
    this.dbc = db;
  }
  
  /**
   * Method to view a Student's saved universities
   * 
   * @return a HashMap representing of all the universities saved by this student
   */
  public HashMap<String, University> viewSavedUniversities() //throws NoSuchElementException
  {
	HashMap<String, University> universities = new HashMap<String, University>();
	ArrayList<University> savedUniversities = this.student.getSavedSchools();
	for (University u : savedUniversities)
	{
		universities.put(u.getName(), u);
	}
	return universities;
  }
  
  /**
   * Method to view an University
   * @param university the University to be viewed
   * @return a University
   */
  public University viewUniversity(String universityName)
  {
    return this.dbc.getUniversity(universityName);
  }
  
  /**
   * Method to remove a University from a Student's saved universities
   * 
   * @param oldUniversity the University to be removed
   * @return integer representing success of remove
   */
  public int removeUniversity(University oldUniversity)
  {
    return this.dbc.removeUniversityFromStudent(this.student, oldUniversity);
  }
}  

