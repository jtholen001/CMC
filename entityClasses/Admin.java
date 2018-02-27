/**
 * An entity class that represents an Admin
 *
 *  @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */
public class Admin extends User
{
  /**
   * Constructor for an Admin
   * @param firstName a string representing the first name of an Admin
   * @param lastName a string representing the last name of an Admin
   * @param username a string representing the username of an Admin
   * @param password a string representing the password of an Admin
   * @param type a char representing the type of User and Admin is
   * @param activated a boolean representing the activation status of an Admin
   * @param logged a boolean reperesenting the login status of an Admin
   */
  public Admin(String firstName, String lastName, String username, String password, char type, boolean activated, boolean logged)
  {
    super (firstName, lastName, username, password, type, activated, logged);
  }
<<<<<<< HEAD
=======

  /**
   * toString() method to display an Admin entity
   * @return a concatenated string representing an Admin and its attributes
   */
  public String toString()
  {
    return ("First name: " + this.getFirstName() +
            "\nLast name: " + this.getLastName() +
            "\nUsername: " + this.getUsername() +
            "\nType: " + this.getType() +
            "\nActivated: " + this.getActivationStatus());
  }
>>>>>>> ce7f5eeca497dcb5593e8c796d84525e64156add
}
