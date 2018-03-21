/**
 * Class that emcompasses functionalities relating to a Student's saved universities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
package Controllers;

import java.util.ArrayList;
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
   * @return a string representation of all the universities saved by this student
   */
  public String viewSavedUniversities()
  {
    ArrayList<University> universities = this.student.getSavedSchools(); 
    String output = "";
    for (University u : universities)
    {
      output += u.getName() + ", ";
    }
    
    return output.substring(0, output.length()-2);
  }
  
  /**
   * Method to view an University
   * @param university the University to be viewed
   * @return a String representation of the University
   */
  public String viewUniversity(University university)
  {
    return university.toString();
  }
  
  /**
   * TODO: possible boolean return type
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

