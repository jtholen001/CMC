/**
 * This class controlls the functionality of the data base
 * 
 * @Author: Michael Carroll, Brandan Kalsow, Nicholas Tawil, Jordan Tholen, Ryan Strelow
 * @version: 2/21/2018
 */

public class DatabaseController
{
  /**
   * This method gets the data for a specified user
   * 
   * @param username the username of the user to find
   * 
   * @return User the data for the specified user
   */
  public User getUser(String username)
  {
    //TODO logic here
    User user = new User("John", "Doe", "jdoe", "abc123", "s", true, false);
    return user;
  }
}