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
 *  LoginController for the UserInterface
 */
private Student student;

/**
 *  LoginController for the UserInterface
 */
private Admin admin;

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

   }

   /**
    * This method gets the user's username
    * @return username the username of this user as a String
    */
   public String getUsername()
   {
     return this.username;
   }

   /**
    * This method gets the user's password
    * @return password this user's password as a String
    */
   public String getPassword()
   {
     return this.password;
   }

   /**
    * This method gets the user's type
    * @return type the type of this user as a char
    */
   public char getType()
   {
     return this.type;
   }

   /**
    * This method gets the user's activation status
    * @return activationStatus the activation status of this user as a boolean
    */
   public boolean getActivationStatus()
   {
     return this.isActivated;
   }

   /**
    * This method gets the user's logged in status
    * @return isLoggedIn this user's logged in status as a boolean
    */
   public boolean getLoggedInStatus()
   {
     return this.isLoggedIn;
   }

   /**
    * This method sets the user's first lastName
    * @param newFirstName the new first name for this user
    */
   public void setFirstName(String newFirstName)
   {
     this.firstName = newFirstName;
   }

   /**
    * This method sets the user's last lastName
    * @param newLastName the new last name for this user
    */
   public void setLastName(String newLastName)
   {
     this.lastName = newLastName;
   }

   /**
    * This method sets the user's username
    * @param newUsername the new username for this user
    */
   public void setUsername(String newUsername)
   {
     this.username = newUsername;
   }

   /**
    * This method sets the user's password
    * @param newPassword the new password for this user
    */
   public void setPassword(String newPassword)
   {
     this.password = newPassword;
   }

   /**
    * This method gets the user's type
    * @param newType the new type of this user as a char
    */
   public void setType(char newUserType)
   {
     this.type = newUserType;
   }

   /**
    * This method gets the user's activation status
    * @param newActivationStatus the new activation status of this user as a boolean
    */
   public void setActivationStatus(boolean newActivationStatus)
   {
     this.isActivated = newActivationStatus;
   }

   /**
    * This method gets the user's logged in status
    * @param newLoggedInStatus this user's new logged in status as a boolean
    */
   public void setLoggedInStatus(boolean newLoggedInStatus)
   {
     this.isLoggedIn = newLoggedInStatus;
   }

   /**
   */
}
