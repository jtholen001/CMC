/**
 * A controller class 1manages a User
 *
 *  @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/20/18
 */
public class UsersController
{
  /**
   * an array of Users
   */
  private User[] users;

  /**
   * an instance of a DBController
   */
  private DBController dbCont;

  /**
   * Constuctor for UsersController
   */
  public UsersController()
  {
    this.dbCont = new DBController();
  }

  /**
   * a method to view all Users in the Database
   */
  public void viewUsers()
  {
    for (int i = 0; i <= users.length; i++)
    {
      char type = users[i].getType();
      if (type == 'a')
        (Admin)users[i].toString();
      if (type == 's')
        (Student)users[i].toString();
      System.out.println("\n\n");
    }
  }

  /**
   * a method to edit a single User
   *
   * @param String username a string representing the username of a User
   */
  public void editUser(String username)
  {
    User toEdit = dbCont.getUser(username);

    //admin can edit anything except for username
    toEdit.setFirstName(null);
    toEdit.setLastName(null);
    toEdit.setPassword(null);
    toEdit.setType(null);
    toEdit.setActivationStatus(null);
    toEdit.setLoggedInStatus(null);

    dbCont.saveEditedUser(toEdit);
  }

  /**
   * a method to add a User to the Database
   */
  public void addUser()
  {
    String firstName;
    String lastName;
    String password;
    char type;
    boolean isActivated;
    boolean isLoggedIn;
    dbCont.addUser(new User(firstName, lastName, username, password, type, isActivated, isLoggedIn));
  }

  /**
   * a method to deactivate a User
   *
   * @param user a User object to be deactivated
   */
  public void deactivate(User user)
  {
    user.setActivationStatus(false);
  }
}
