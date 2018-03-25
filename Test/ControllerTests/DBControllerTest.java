package Test.ControllerTests;

import Controllers.DBController;
import entityClasses.*;
import java.util.*;
import org.junit.*;

public class DBControllerTest {
	
	private DBController dbController;
	private Admin admin;
	private Student student;
	private University university;
	
	@Before
	public void init() {
		dbController = new DBController();
		student = new Student("John","User","juser","user",'u',true,false,new ArrayList<University>());
		admin = new Admin("Noreen","Admin","nAdmin","admin",'a',true,false);
		university = new University("University of CMC", "Arizona", "urban", "public", 5, 0.0, 500.0, 500.0, 100.0, 0.0, 5, 100.0, 100.0, 1, 1, 1, new ArrayList<String>());
		
	}
	
	@Test
	public void testGetUserForAdminReturnsTrue()
	{
		Admin testAdmin = (Admin)dbController.getUser("nAdmin");
		Assert.assertTrue("get admin user Noreen returned the correct admin", testAdmin.equals(admin));
	}

}
