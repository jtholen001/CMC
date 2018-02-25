/**
 * Class that emcompasses functionalities relating to a Student's saved universities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
public class StudentUniversitiesController
{
  /**
   * DBController that will be accessed by the SearchController
   */
  private DBController dbc;
  
  /**
   * Constructor for a StudentUniversitiesController
   */
  public StudentUniversitiesController()
  {
    this.dbc = new DBController(); 
  }
  
  /**
   * Method to view a Student's saved universities
   * @param student the Student with the universities you are trying to view
   */
  public void viewSavedUniversities(Student student)
  {
    Array<University> universities = student.getSavedSchools(savedUniversities); 
    for (University u : universities)
    {
      System.out.println(u.getName());
    }
  }
  
  /**
   * Method to view an University
   * @param student the Student with the university you are trying to view
   * @param university the Universiy to be viewed
   */
  public void viewUniversity(Student student, University university)
  {
    system.out.println(university.toString());
  }
  
  /**
   * TODO: possible boolean return type
   * Method to remove a University from a Student's saved universities
   * @param student the Student to whom the university needs to removed from
   * @param oldUniversity the University to be removed
   */
  public void removeSchool(Student student, University oldUniversity)
  {
    student.removeSchool(oldUniversity);
    this.dbc.saveEditedStudent(student);
  }
}  

