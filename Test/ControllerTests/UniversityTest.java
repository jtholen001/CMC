/**
 * This class is used to test the University class
 * 
 * @author Michael Carroll, Brandan Kalsow, Nicholas Tawil, Jordan Tholen, Ryan Strelow
 * 
 * @version Mar 25,2018
 */
package Test.ControllerTests;
import entityClasses.University;
import org.junit.*;
import java.util.ArrayList;

public class UniversityTest 
{
	private University emptyUniversity, University1, University2;
	ArrayList<String> emphases;
	
	@Before
	public void init()
	{
		 emptyUniversity = new University("","","", "", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0,
				 						  0.0, 0.0, 0, 0, 0, new ArrayList<String>());
		 emphases = new ArrayList<String>();
		 emphases.add("Computer Science");
		 emphases.add("Accounting");
		 emphases.add("Nursing");
		 University1 = new University("Saint John's University","Minnesota","Collegeville", "Private",
				                      10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases);
		 
		 emphases = new ArrayList<String>();
		 emphases.add("Chemistry");
		 emphases.add("Music");
		 emphases.add("Computer Science");
		 University2 = new University("Univeristy of CMC","Hawii","Honalulu", "Public", 20000, 75.0, 100.0, 100.0, 
				                      30000.0, 25.0, 7500, 50.0, 25.0, 2, 5, 3, emphases);
	}
	
	@Test
	public void constructorSucseedsForValidInput()
	{
		Assert.assertTrue("Constructor suceeds for university with all fields meeting criteria:", new University("Saint John's University","Minnesota","Collegeville", "Private",
                10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidInput()
	{
		Assert.assertTrue("Constructor fails for university with name null:", new University(null,"Minnesota","Collegeville", "Private",
                10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
		Assert.assertTrue("Constructor fails for university with state field missing:", new University("Saint John's University", null,"Collegeville", "Private",
                10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
		Assert.assertTrue("Constructor suceeds for university with all fields meeting criteria:", new University("Saint John's University","Minnesota","Collegeville", "Private",
                10000, 50.0, 100.0, 100.0, 50000.0, 75.0, 1000, 75.0, 90.0, 4, 2, 4, emphases) instanceof University);
	}
	
	@Test
	public void getNameReturnsUniversityName()
	{
		Assert.assertTrue("Name for University1 is Saint John's University", University1.getName().equals("Saint John's University"));
		Assert.assertTrue("Name for University2 is University of CMC", University2.getName().equals("University of CMC"));
	}
}
