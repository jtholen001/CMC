/**
 * Class that emcompasses functionalities relating to a Student's saved universities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
package Controllers;

import java.util.ArrayList;
import java.util.HashMap;

import entityClasses.*;

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
  public StudentUniversitiesController(Student student)
  {
    this.student = student;
    this.dbc = new DBController(); 
  }
  
  /**
   * Method to view a Student's saved universities
   * 
   * @return a HashMap representing of all the universities saved by this student
   */
  public HashMap<String, University> viewSavedUniversities()
  {
	HashMap<String, University> universities = new HashMap<String, University>();
	ArrayList<University> savedUniversities = student.getSavedSchools();
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
    return dbc.getUniversity(universityName);
  }
  
  /**
   * Method to remove a University from a Student's saved universities
   * 
   * @param oldUniversity the University to be removed
   * @return integer representing success of remove
   */
  public int removeUniversity(University oldUniversity)
  {
    this.student.removeUniversity(oldUniversity);
    return this.dbc.removeUniversityFromStudent(this.student, oldUniversity);
  }
}  

