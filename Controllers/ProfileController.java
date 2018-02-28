public class ProfileController
{
  // Student entity to edit
  Student student;

  // Database controller allows ProfileController to communicate with Database
  DBController dbc;

  /**
   * Default controller controller for the given student
   * @param student the name of this student
   */
  public ProfileController(Student student)
  {
    this.student = student;
    dbc = new DBController();
  }

  /**
   * TODO: implement acquiring data to change
   * method to edit the profile of the given student
   */
  public void editProfile()
  {
    this.student.setFirstName(null);
    this.student.setLastName(null);
    this.student.setPassword(null);

    dbc.saveEditedUser(this.student);
  }

  /**
   * method to view the profile of the given student
   */
  public void viewProfile()
  {
    System.out.println(this.student.toString());
  }
}
