/**
 * Class that represents a DBController
 *
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 5/2/18
 */
package cmcPackage.Controllers;


import java.security.GeneralSecurityException;
import java.util.ArrayList;

import dblibrary.project.csci230.*;
import cmcPackage.entityClasses.*;

import java.util.HashMap;

import com.j256.twofactorauth.*;

public class DBController implements Runnable
{
	HashMap<String,University> storedUniversities;
	HashMap<String, University> allUniversities;
	HashMap<String,User> users;
	private UniversityDBLibrary univDBlib;
	private boolean run;
	private Thread thread;
	/**
	 *  2-factor authentication utility
	 */
	TimeBasedOneTimePasswordUtil tfaUtil;

	/**
	 * Construct a database controller
	 */

	public DBController()
	{
		this.storedUniversities = new HashMap<String, University>();
		this.allUniversities = new HashMap<String, University>();
		this.users = new HashMap<String,User>();
		univDBlib =  new UniversityDBLibrary("byteme","byteme","csci230");
		this.startThread();
		//this.storedUniversities = this.viewUniversities();
	}

	private void startThread()
	{
		this.run = true;
		thread = new Thread(this);
		thread.getThreadGroup().setDaemon(true);
		thread.start();
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
				synchronized(this.storedUniversities) {
					if(!universities[index][0].contains("%2FA-MASTER%")) {
						this.storedUniversities.put(universities[index][0], new University(universities[index][0], universities[index][1],
								universities[index][2],universities[index][3],
								Integer.parseInt(universities[index][4]), new Double(universities[index][5]),
								new Double(universities[index][6]), new Double(universities[index][7]), new Double(universities[index][8]),
								new Double(universities[index][9]), Integer.parseInt(universities[index][10]),new Double(universities[index][11]),
								new Double(universities[index][12]), Integer.parseInt(universities[index][13]), Integer.parseInt(universities[index][14]),
								Integer.parseInt(universities[index][15]), getUniversityEmphases(universities[index][0])));  
					}
				}
			}
		}

		for(int index = 0; index < universities.length; index++)
		{
			allUniversities.put(universities[index][0], new University(universities[index][0], universities[index][1],
					universities[index][2],universities[index][3],
					Integer.parseInt(universities[index][4]), Double.parseDouble(universities[index][5]),
					Double.parseDouble(universities[index][6]), Double.parseDouble(universities[index][7]), Double.parseDouble(universities[index][8]),
					Double.parseDouble(universities[index][9]), Integer.parseInt(universities[index][10]),Double.parseDouble(universities[index][11]),
					Double.parseDouble(universities[index][12]), Integer.parseInt(universities[index][13]), Integer.parseInt(universities[index][14]),
					Integer.parseInt(universities[index][15]), getUniversityEmphases(universities[index][0])));
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

		if(this.users.isEmpty())
		{
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
		else
		{
			User user = this.users.get(username);
			if(user == null)
				throw new IllegalArgumentException("user was not found in the database");
			if(user instanceof Student)
				return (Student) user;
			else if(user instanceof Admin)
				return (Admin) user;
			else
				throw new IllegalArgumentException("could not find type of user");
		}
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
		if(this.users.isEmpty())
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
			this.users = new HashMap<String,User>(userMap);
			return userMap;
		}
		else
			return this.users;
	}

	/**
	 * This method saves edits to a user to the data base
	 * 
	 * @param user the user who's profile was edited
	 */

	public <t extends User> int saveEditedUser(t user)
	{
		if(user == null)
			throw new IllegalArgumentException("user is a null value");
		char temp;
		if(user.getActivationStatus() == false)
			temp = 'N';
		else
			temp = 'Y';

		univDBlib.user_editUser(user.getUsername(),user.getFirstName(),user.getLastName(),user.getPassword(),user.getType(),
				temp);
		if(!this.users.isEmpty())
		{
			if(this.users.containsKey(user.getUsername()))
			{
				synchronized(this.users)
				{
					this.users.replace(user.getUsername(), user);
					return 1;
				}
			}
			else
				throw new IllegalArgumentException("user not in database");
		}
		return 1;
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
			univDBlib.user_addUser(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getType());
			if(!this.users.isEmpty())
			{
				this.users.put(user.getUsername(), user);
			}
			return 1;
		}
		throw new IllegalArgumentException("User is already in databse");		
	}

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
		if(user instanceof Student) 
		{
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
			univDBlib.user_deleteUser(stu.getUsername());
			if(!this.users.isEmpty())
			{
				synchronized(this.users)
				{
					this.users.remove(username);
					return 1;
				}
			}
		}
		else if(user == null)
		{
			throw new IllegalArgumentException("user was not found in the database");
		}
		univDBlib.user_deleteUser(username);
		synchronized(this.users)
		{
			this.users.remove(username);
		}
		return 1;
	}

	/**
	 * method to get all universities in the databse
	 *
	 * @return a hashmap of all universities where the univ name is the key and the University object is a value
	 */
	public HashMap<String, University> viewUniversities()
	{
		if(!(this.storedUniversities.isEmpty())) {
			return new HashMap<String,University>(this.storedUniversities);
		}
		String[][] universities = univDBlib.university_getUniversities();
		storedUniversities= new HashMap<String, University>();

		for(int index = 0; index < universities.length; index++)
		{
			if(!universities[index][0].contains("%2FA-MASTER%")) {
				storedUniversities.put(universities[index][0], new University(universities[index][0], universities[index][1],
						universities[index][2],universities[index][3],
						Integer.parseInt(universities[index][4]), Double.parseDouble(universities[index][5]),
						Double.parseDouble(universities[index][6]), Double.parseDouble(universities[index][7]), Double.parseDouble(universities[index][8]),
						Double.parseDouble(universities[index][9]), Integer.parseInt(universities[index][10]),Double.parseDouble(universities[index][11]),
						Double.parseDouble(universities[index][12]), Integer.parseInt(universities[index][13]), Integer.parseInt(universities[index][14]),
						Integer.parseInt(universities[index][15]), getUniversityEmphases(universities[index][0]))); //not sure how emphases are stored
			}
		}

		allUniversities = new HashMap<String, University>(storedUniversities);

		for(int index = 0; index < universities.length; index++)
		{
			if (universities[index][0].contains("%2FA-MASTER%"))
				allUniversities.put(universities[index][0], new University(universities[index][0], universities[index][1],
						universities[index][2],universities[index][3],
						Integer.parseInt(universities[index][4]), Double.parseDouble(universities[index][5]),
						Double.parseDouble(universities[index][6]), Double.parseDouble(universities[index][7]), Double.parseDouble(universities[index][8]),
						Double.parseDouble(universities[index][9]), Integer.parseInt(universities[index][10]),Double.parseDouble(universities[index][11]),
						Double.parseDouble(universities[index][12]), Integer.parseInt(universities[index][13]), Integer.parseInt(universities[index][14]),
						Integer.parseInt(universities[index][15]), getUniversityEmphases(universities[index][0]))); //not sure how emphases are stored
			else
				break;
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

		if (name.contains("%2FA-MASTER%"))
			synchronized(this.allUniversities)
			{
				if(allUniversities.containsKey(name))
					return allUniversities.get(name);
			}

		if(!(this.storedUniversities.isEmpty()))
		{
			if(storedUniversities.containsKey(name))
				return storedUniversities.get(name);
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
		ArrayList<String> universityEmphases = university.getEmphases();

		for(String emphases: university.getEmphases())
		{
			if(!(storedVals.contains(emphases))){
				univDBlib.university_addUniversityEmphasis(university.getName(), emphases);
				storedVals.add(emphases);
			}
		}
		for(String emphasis : storedVals)
		{
			if(!(universityEmphases.contains(emphasis)))
			{
				univDBlib.university_removeUniversityEmphasis(university.getName(), emphasis);
			}
		}
		if(success !=-1)
			synchronized(this.storedUniversities)
			{
				this.storedUniversities.put(university.getName(), university);
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
		if(!(this.storedUniversities.isEmpty()))
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
		synchronized(this.storedUniversities) {
			if(storedUniversities.remove(university.getName()) == null)
			{
				return -1;
			}
			univDBlib.university_deleteUniversity(university.getName());

		}
		return -1;
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
			if(this.users.isEmpty())
			{
				synchronized(this.users)
				{
					this.getUsers();
				}
			}

			try {
				Thread.sleep((8 * 1000));
			}
			catch(InterruptedException j)
			{
				j.printStackTrace();
			}
		}
	}

	/**
	 * Method to enable 2FA for a user. If 2FA is already enabled, a new master key will be set
	 *
	 * @return string representing URL of QR code for user to scan
	 */
	@SuppressWarnings("static-access")
	public String enableTfa(User user) {	  
		String uTfa = "%2FA-MASTER%_";
		uTfa = uTfa.concat(user.getUsername());

		if (this.isTfaEnabled(user.getUsername())){ // user already has 2FA enabled, this will reset it
			this.deleteUniversity(this.getUniversity(uTfa));
			String newMasterKey = tfaUtil.generateBase32Secret();
			String qrCodeUrl = tfaUtil.qrImageUrl("CMC" + " (" + user.getUsername() + ")", newMasterKey);
			University univTfa = new University(uTfa, newMasterKey, "-1", "-1", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, new ArrayList<String>());
			this.addUniversity(univTfa);
			return qrCodeUrl;
		}
		else {
			String masterKey = tfaUtil.generateBase32Secret();
			String qrCodeUrl = tfaUtil.qrImageUrl("CMC" + "%20" + "("+ user.getUsername() + ")", masterKey);
			University univTfa = new University(uTfa, masterKey, "-1", "-1", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, new ArrayList<String>());
			this.addUniversity(univTfa);
			return qrCodeUrl;
		}
	}

	public void disableTfa(User user) {
		if (this.isTfaEnabled(user.getUsername())) {
			String uTfa = "%2FA-MASTER%_";
			uTfa = uTfa.concat(user.getUsername().toUpperCase());
			this.deleteUniversity(this.getUniversity(uTfa));
		}
		else {
			throw new IllegalArgumentException("User does not have 2FA enabled");
		}
	}

	public boolean isTfaEnabled(String username) {
		try {
			String uTfa = "%2FA-MASTER%_";
			uTfa = uTfa.concat(username);
			this.getUniversity(uTfa);
			return true;
		}
		catch (IllegalArgumentException iae) {
			return false;
		}
	}

	public String getMasterKey(User user) {
		if (this.isTfaEnabled(user.getUsername())) {
			String uTfa = "%2FA-MASTER%_";
			uTfa = uTfa.concat(user.getUsername());
			return this.getUniversity(uTfa).getState();

		}
		else {
			throw new IllegalArgumentException("User does not have 2FA enabled");
		}
	}

	@SuppressWarnings("static-access")
	public boolean tfaAuthenticate(String key, String username) {
		try {
			return key.equals(tfaUtil.generateCurrentNumberString(this.getMasterKey(this.getUser(username))));
		}
		catch (GeneralSecurityException e) { return false;}   
	}
}
