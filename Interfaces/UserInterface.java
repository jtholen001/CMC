/**
 * Class that represents a User
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/19/18
*/

/**
 *  LoginController for the UserInterface
 */
private LoginController lc;

/**
 *  StudentInterface for the UserInterface
 */
private StudentInterface si;

/**
 *  AdminInterface for the UserInterface
 */
private AdminInterface ai;

public class UserInterface
{
  /**
   * Default constructor
   */
   public UserInterface()
   {
     lc = new LoginController();
   }

   /**
    * This method logs the user into the system
    * @param username of the user
    * @param password of the user
    */
   public void login(String username, String password)
   {
     lc.login(username, password);
   }

   /**
    * This method passes the logged in Student to the StudentInterface
    */
   public void passToStudentInterface(Student student)
   {
     si = new StudentInterface(student);
   }

   /**
    * This method passes the logged in Admin to the AdminInterface
    */
   public void passToStudentInterface(Student student)
   {
     ai = new AdminInterface(student);
   }
 }
