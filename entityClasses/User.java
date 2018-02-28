/**
 * Class that represents a User
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */
public class User
{
  /**
   *  first name to identify this user
   */
  private String firstName;
  
  /**
   * this user's last name
   */
  private String lastName;
  
  /**
   * username to identify this username
   */
  private String username;
  
  /**
   * User's password
   */
  private String password;
  
  /**
   * User's account type
   */
  private char type;
  
  /**
   * isActivated represents the activation status of a user
   */
  
  private boolean isActivated;
  
  /**
   * isLoggedIn to represent the logged in status of a user
   */
  private boolean isLoggedIn;
  
  /**
   * Constructor for an User
   * @param firstName a string representing the first name of an User
   * @param lastName a string representing the last name of an User
   * @param username a string representing the username of an User
   * @param password a string representing the password of an User
   * @param type a char representing the type of User and User is
   * @param activated a boolean representing the activation status of an User
   * @param logged a boolean reperesenting the login status of an User
   */
  public User(String firstName, String lastName, String username, String password, char type, boolean activated, boolean logged)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.password = password;
    this.type = type;
    this.isActivated = activated;
    this.isLoggedIn = logged;
  }
  
  /**
   * This method gets the user's first lastName
   * @return firstName the first name of this user as a String
   */
  public String getFirstName()
  {
    return this.firstName;
  }
  
  /**
   * This method gets the user's last lastName
   * @return lastName the last name of this user as a String
   */
  public String getLastName()
  {
    return this.lastName;
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
   * method to display a single User
   * @return a concatenated string representing an User and its attributes
   */
  public String toString()
  {
    return ("First name: " + this.getFirstName() +
            "\nLast name: " + this.getLastName() +
            "\nUsername: " + this.getUsername() +
            "\nType: " + this.getType() +
            "\nActivated: " + this.getActivationStatus() +
            "\nLoggedInStatus: " + this.getLoggedInStatus());
  }
}