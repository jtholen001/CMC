/**
 * Class that represents a DBController
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */
package cmcPackage.Controllers;

import java.util.ArrayList;

import dblibrary.project.csci230.*;
import cmcPackage.entityClasses.*;

import java.util.HashMap;

public class DBController implements Runnable
{
	HashMap<String,University> storedUniversities;
	/**
	 * Construct a database controller
	 */
	private UniversityDBLibrary univDBlib;
	private boolean run;
	Thread thread;

	public DBController()
	{
		univDBlib =  new UniversityDBLibrary("byteme","byteme","csci230");
		this.startThread();
		//this.storedUniversities = this.viewUniversities();
	}

	private void startThread()
	{
		this.run = true;
		thread = new Thread(this);
		thread.getThreadGroup().setDaemon(true);
		//thread.start();
	}

	public void stop()
	{
		this.run = false;
	}

	private void updateSavedSchools()
	{
		String[][] universities = univDBlib.university_getUniversities();

		for(int index = 0; index < universities.length; index++)
		{
			if(!(this.storedUniversities.containsKey(universities[index][0]))) 
			{
				this.storedUniversities.put(universities[index][0], new University(universities[index][0], universities[index][1],
						universities[index][2],universities[index][3],
						Integer.parseInt(universities[index][4]), Integer.parseInt(universities[index][5]),
						Integer.parseInt(universities[index][6]), Integer.parseInt(universities[index][7]), Integer.parseInt(universities[index][8]),
						Integer.parseInt(universities[index][9]), Integer.parseInt(universities[index][10]),Integer.parseInt(universities[index][11]),
						Integer.parseInt(universities[index][12]), Integer.parseInt(universities[index][13]), Integer.parseInt(universities[index][14]),
						Integer.parseInt(universities[index][15]), getUniversityEmphases(universities[index][0]))); //not sure how emphases are stored
			}
		}
	}


	/**
	 * This method gets a user's data based on their username
	 * 
	 * @param username the username of the user to find
	 * @return a user object
	 */
	public User getUser(String username)
	{
		if(username == null)
			throw new IllegalArgumentException("username is a null value");

		username = username.trim();
		String[][] users = univDBlib.user_getUsers();
		boolean status = false;

		for(int index = 0; index < users.length; index++)
		{
			if(users[index][2].equals(username)) 
			{
				if(users[index][5].equals("Y"))
					status = true;

				if(users[index][4].equals("u"))
				{

					return new Student(users[index][0],users[index][1],users[index][2],users[index][3],'u',
							status, false, this.getUniversitiesForStudent(username));
				}
				else
				{
					return new Admin(users[index][0],users[index][1],users[index][2],users[index][3],'a',
							status, false);
				}
			}
		}
		throw new IllegalArgumentException("user was not found in the database");
	}

	/**
	 * This method gets the list of schools that the given user has saved.
	 * 
	 * @param username the username of the user to get the saved schools for
	 * 
	 * @return an ArrayList of universities the student has saved
	 */
	private ArrayList<University> getUniversitiesForStudent(String username)
	{
		String[][] usersUniversities = univDBlib.user_getUsernamesWithSavedSchools();
		ArrayList<University> list = new ArrayList<University>();

		if(username == null)
			throw new IllegalArgumentException("username is a null value");
		for(int i = 0; i < usersUniversities.length; i++)
		{
			if(usersUniversities[i][0].equals(username))
			{
				list.add(this.getUniversity(usersUniversities[i][1]));
			}
		}
		return list;
	}


	/**
	 * This method gets a list of all users in the database
	 * 
	 * @return a hashmap of all users
	 */
	public HashMap<String,User> getUsers()
	{
		String[][] users = univDBlib.user_getUsers();
		HashMap<String, User> userMap = new HashMap<String, User>();
		boolean status;

		for(int index = 0; index < users.length; index++)
		{
			//gets the char character of if they are activated and sets a bool value to be used when creating the user
			if(users[index][5].equals("Y"))
				status = true;
			else
				status = false;
			//creates the user and puts it in the map
			if(users[index][4].equals("u"))
			{
				userMap.put(users[index][2],new Student(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
						status, false, this.getUniversitiesForStudent(users[index][0])));
			}
			else if(users[index][4].equals("a")) {
				userMap.put(users[index][2],new Admin(users[index][0],users[index][1],users[index][2],users[index][3],users[index][4].charAt(0),
						status, false));
			}
		}
		return userMap;
	}

	/**
	 * This method saves edits to a user to the data base
	 * 
	 * @param user the user who's profile was edited
	 */

	//TODO: change saveEditiedUser to not save schools and to create a save schools method
	public <t extends User> int saveEditedUser(t user)
	{
		if(user == null)
			throw new IllegalArgumentException("user is a null value");
		char temp;
		if(user.getActivationStatus() == false)
			temp = 'N';
		else
			temp = 'Y';

		return univDBlib.user_editUser(user.getUsername(),user.getFirstName(),user.getLastName(),user.getPassword(),user.getType(),
				temp);
	}

	/**
	 * method to add a user to the database
	 *
	 * @param user the user to add to the database
	 * 
	 * @return an int representing the success of adding a user
	 */

	public int addUser(User user)
	{ 
		if(user == null)
			throw new IllegalArgumentException("User value is null");
		try {
			this.getUser(user.getUsername());
		}
		catch(IllegalArgumentException i)
		{
			return univDBlib.user_addUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getType());
		}
		throw new IllegalArgumentException("User is already in databse");		
	}
	
	//TODO change save edited user to this

	  public int saveUniversityToStudent(Student student, University university)
	  {
		  String[][] savedUniversities = univDBlib.user_getUsernamesWithSavedSchools();
		  String[][] universities = univDBlib.university_getUniversities();
		  
		  for(int i = 0; i < universities.length; i++)
		  {
			  if(university.getName().equals(universities[i][0]))
			  {
				  for(int j = 0; j < savedUniversities.length; j++)
				  {
					  if(savedUniversities[j][1].equals(university.getName()) && savedUniversities[j][0].equals(student.getUsername()))
						  throw new IllegalArgumentException("Student already has school saved");
				  }
				  student.addSchool(university);
				 return univDBlib.user_saveSchool(student.getUsername(), university.getName());
			  }
		  }
		  throw new IllegalArgumentException("Saved schools in student contains a school not in the databse");
	  }


	/**
	 * method to delete a user from the database
	 * 
	 * @param username the user to be deleted
	 * 
	 * @return an int representing the success of deleting a user
	 */
	public int deleteUser(String username)
	{
		if (username == null)
			throw new IllegalArgumentException("user was not found in the database");

		User user = this.getUser(username);
		if(user instanceof Student) {
			Student stu = (Student) user;
			String[][] universities = univDBlib.user_getUsernamesWithSavedSchools();

			for(int i = 0; i < universities.length; i++)
			{
				if(universities[i][0].equals(stu.getUsername()))
				{
					if(!(univDBlib.user_removeSchool(universities[i][0], universities[i][1]) == 1))
						throw new IllegalArgumentException("Database error removing saved schools for " + stu.getUsername());
				}
			}
			return univDBlib.user_deleteUser(stu.getUsername());
		}
		else if(user == null)
		{
			throw new IllegalArgumentException("user was not found in the database");
		}
		return univDBlib.user_deleteUser(username);
	}

	/**
	 * method to get all universities in the databse
	 *
	 * @return a hashmap of all universities where the univ name is the key and the University object is a value
	 */
	public HashMap<String, University> viewUniversities()
	{
		if(!(this.storedUniversities == null)) {
			synchronized(this.storedUniversities)
			{
				return new HashMap<String,University>(this.storedUniversities);
			}
		}
		String[][] universities = univDBlib.university_getUniversities();
		storedUniversities= new HashMap<String, University>();

		for(int index = 0; index < universities.length; index++)
		{
			this.storedUniversities.put(universities[index][0], new University(universities[index][0], universities[index][1],
					universities[index][2],universities[index][3],
					Integer.parseInt(universities[index][4]), Integer.parseInt(universities[index][5]),
					Integer.parseInt(universities[index][6]), Integer.parseInt(universities[index][7]), Integer.parseInt(universities[index][8]),
					Integer.parseInt(universities[index][9]), Integer.parseInt(universities[index][10]),Integer.parseInt(universities[index][11]),
					Integer.parseInt(universities[index][12]), Integer.parseInt(universities[index][13]), Integer.parseInt(universities[index][14]),
					Integer.parseInt(universities[index][15]), getUniversityEmphases(universities[index][0]))); //not sure how emphases are stored
		}
		return this.storedUniversities;
	}

	/**
	 * method to get a specific university off of the name
	 *
	 * @param name the string of the university to find
	 *
	 * @return a University object
	 */
	public University getUniversity(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Given name was null");
		name = name.toUpperCase().trim();

		if(this.storedUniversities != null)
		{
			synchronized(this.storedUniversities)
			{
				if(storedUniversities.containsKey(name))
					return storedUniversities.get(name);
			}
		}

		String[][] universities = univDBlib.university_getUniversities();
		HashMap<String, University> universityMap = new HashMap<String, University>();

		for(int index = 0; index < universities.length; index++)
		{
			if(universities[index][0].toUpperCase().equals(name))
			{
				universityMap.put(universities[index][0], new University(universities[index][0], universities[index][1],
						universities[index][2],universities[index][3],
						Integer.parseInt(universities[index][4]), new Double(universities[index][5]),
						new Double(universities[index][6]), new Double(universities[index][7]), new Double(universities[index][8]),
						new Double(universities[index][9]), Integer.parseInt(universities[index][10]),new Double(universities[index][11]),
						new Double(universities[index][12]), Integer.parseInt(universities[index][13]), Integer.parseInt(universities[index][14]),
						Integer.parseInt(universities[index][15]), getUniversityEmphases(name)));  
				return universityMap.get(name);
			}
		}
		University temp = universityMap.get(name);
		if(temp == null)
		{
			throw new IllegalArgumentException("University does not exist in the databse");
		}
		return temp;
	}

	private ArrayList<String> getUniversityEmphases(String universityName) {

		ArrayList<String>  retList = new ArrayList<String>();
		String[][] emphases = univDBlib.university_getNamesWithEmphases();

		for(int i = 0; i < emphases.length; i++)
		{
			if(emphases[i][0].equals(universityName)) {
				retList.add(emphases[i][1]);
			}   
		}
		return retList;
	}

	/**
	 * method to to save an editied university
	 *
	 * @param university the university object to edit
	 * 
	 * @return an int representing the success of saving an edited university
	 */
	public int saveEditedUniversity(University university)
	{
		if(university == null)
			throw new IllegalArgumentException("Given university was null");

		int success = univDBlib.university_editUniversity(university.getName(), university.getState(), university.getLocation(),
				university.getControl(), university.getNumStudents(), university.getPercentFemale(),
				university.getSATVerbal(), university.getSATMath(), university.getExpenses(),
				university.getPercentFinancialAid(), university.getNumApplicants(),
				university.getPercentAdmitted(), university.getPercentEnrolled(),
				university.getAcademicScale(), university.getSocialScale(),
				university.getQualityOfLifeScale());

		ArrayList<String> storedVals = getUniversityEmphases(university.getName());
		for(String emphases: university.getEmphases())
		{
			if(!(storedVals.contains(emphases))){
				univDBlib.university_addUniversityEmphasis(university.getName(), emphases);
			}
		}
		return success;
	}

	/**
	 * method to add a university to the database
	 *
	 * @param university the University object to add to the database
	 * 
	 * @return int representing success of adding university
	 */
	public int addUniversity(University university)
	{
		if(university == null)
			throw new IllegalArgumentException("university is null");
		
		int ret =  univDBlib.university_addUniversity(university.getName().toUpperCase(), university.getState().toUpperCase(), university.getLocation().toUpperCase(),
				university.getControl().toUpperCase(), university.getNumStudents(), university.getPercentFemale(),
				university.getSATVerbal(), university.getSATMath(), university.getExpenses(),
				university.getPercentFinancialAid(), university.getNumApplicants(),
				university.getPercentAdmitted(), university.getPercentEnrolled(),
				university.getAcademicScale(), university.getSocialScale(),
				university.getQualityOfLifeScale());
		if(ret == -1)
		{
			throw new IllegalArgumentException("University already exists in databse");
		}

		if (!(university.getEmphases().equals(null)))
		{
			for(int i = 0; i < university.getEmphases().size(); i++)
			{
				univDBlib.university_addUniversityEmphasis(university.getName(), university.getEmphases().get(i).toUpperCase());
			}
		}
		if(this.storedUniversities!= null)
		{
			synchronized(this.storedUniversities)
			{
				this.storedUniversities.put(university.getName(), university);
			}
		}
		return ret;
	}

	/**
	 * this method removes a University from the database
	 * 
	 * @param university the university to remove from the database
	 * @return int representing success of removing university
	 */
	public int deleteUniversity(University university)
	{
		try
		{
			this.getUniversity(university.getName());
		}
		catch(IllegalArgumentException j)
		{
			throw j;
		}
		if(!(this.deleteUniversityEmphases(university) == 1))
		{
			return -1;
		}

		if(!(this.deleteSavedUsersForUniversity(university) == 1))
		{
			return -1;
		}
		return univDBlib.university_deleteUniversity(university.getName());
	}

	/**
	 * method to remove a university from a specific student
	 *
	 * @param student the Student object to remove the university from
	 * @param university the University object to remove from the student's list of saved schools
	 */
	public int removeUniversityFromStudent(Student student, University university)
	{
		if(this.getUniversity(university.getName()) == null)
			throw new IllegalArgumentException("University does not exist in the database");

		if(this.getUser(student.getUsername()) == null)
			throw new IllegalArgumentException("User does not exist in the database");

		student.removeUniversity(university);
		int temp = univDBlib.user_removeSchool(student.getUsername(),university.getName());

		if(temp == -1)
			throw new IllegalArgumentException("Deleting saved school returned an error");
		return temp;
	}


	private int deleteUniversityEmphases(University university)
	{
		ArrayList<String> emphases = this.getUniversityEmphases(university.getName());

		for(String str : emphases)
		{
			if(!(univDBlib.university_removeUniversityEmphasis(university.getName(), str) == 1))
				return -1;
		}

		return 1;
	}

	private int deleteSavedUsersForUniversity(University university)
	{
		String[][] universities = univDBlib.user_getUsernamesWithSavedSchools();

		for(int i = 0; i < universities.length; i++)
		{
			if(universities[i][1].equals(university.getName()))
			{
				if(!(univDBlib.user_removeSchool(universities[i][0], universities[i][1]) == 1))
					return -1;
			}
		}

		return 1;
	}

	@Override 
	public void run()
	{
		while(run != false) {
			if(!(this.storedUniversities == null))
				synchronized(this.storedUniversities){
					this.updateSavedSchools();
				}
			else
			{
				this.viewUniversities();
			}


			try {
				Thread.sleep((10 * 1000));
			}
			catch(InterruptedException j)
			{
				j.printStackTrace();
			}
		}
	}
}
