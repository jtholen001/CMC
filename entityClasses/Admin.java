/**
 * An entity class that represents an Admin
 * 
 * @author Nicholas Tawil
 * @version 2/20/18
 */
public class Admin extends User
{
  /**
   * Constructor that takes firstName, lastName,
   * username, password, type, activated, logged
   */
  public Admin (String firstName, String lastName, String username, String password, char type, boolean activated, boolean logged)
  {
    super (firstName, lastName, username, password, type, activated, logged);
  }
}