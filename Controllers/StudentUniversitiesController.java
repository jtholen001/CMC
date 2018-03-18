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
   */
  public String viewSavedUniversities()
  {
    ArrayList<University> universities = this.student.getSavedSchools(); 
    String output = "";
    for (University u : universities)
    {
      output.concat(u.getName());
    }
    
    return output;
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
   */
  public void removeUniversity(University oldUniversity)
  {
    this.student.removeUniversity(oldUniversity);
    this.dbc.saveEditedUser(this.student);
  }
}  

