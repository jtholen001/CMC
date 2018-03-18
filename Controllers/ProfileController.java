/**
 * This class represents a profile controller
 * 
 * @Author: Michael Carroll, Brandan Kalsow, Nicholas Tawil, Ryan Strelow, Jordan Tholen
 */

package Controllers;

import entityClasses.*;

public class ProfileController
{
  // Student entity to edit
  Student student;

  // Database controller allows ProfileController to communicate with Database
  DBController dbc;

  /**
   * Default controller controller for the given student
   * 
   * @param student the name of this student
   */
  public ProfileController(Student student)
  {
    this.student = student;
    dbc = new DBController();
  }

  /**
   * method to edit the profile of the given student
   * 
   * @param firstName a String representing the edited first name of a Student
   * @param lastName a String representing the edited last name of a Student
   * @param password a String representing the edited password name of a Student
   */
  public void editProfile(String firstName, String lastName, String password)
  {
    this.student.setFirstName(firstName);
    this.student.setLastName(lastName);
    this.student.setPassword(password);

    dbc.saveEditedUser(this.student);
  }

  /**
   * method to view the profile of the given student
   * @return a String representation of this student
   */
  public String viewProfile()
  {
    return this.student.toString();
  }
}
