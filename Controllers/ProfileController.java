public class ProfileController
{
  //Student variable to edit
  DBController dbc;

  // Constructor
  /**
   * Construct a Profile controller with the given student.
   * @param queueName the name of this queue
   */
  public ProfileController()
  {
    dbc = new DBController();
  }

  /**
   * method to edit the profile of the given student
   * @param Student the name of this student
   */
  public void editProfile(Student student)
  {
    student.setFirstName(null);
    student.setLastName(null);
    student.setPassword(null);

    dbc.saveEditedUser(student);
  }

  /**
   * method to view the profile of the given student
   * @param Student the name of this student
   */
  public void viewProfile(Student student)
  {
    System.out.println(student.toString());
  }
}
