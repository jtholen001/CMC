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
		 University2 = new University("University of CMC","Hawaii","Honalulu", "Public", 20000, 75.0, 100.0, 100.0, 
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
	
	@Test
	public void getStateReturnsCorrectState()
	{
		Assert.assertTrue("State of University1 is Minnesota", University1.getState().equals("Minnesota"));
		Assert.assertTrue("State for University2 is Hawaii", University2.getState().equals("Hawaii"));
	}
	
	@Test
	public void getLocationReturnsCorrectLocation()
	{
		Assert.assertTrue("Location of University1 is Collegeville", University1.getLocation().equals("Collegeville"));
		Assert.assertTrue("State for University2 is Honalulu", University2.getLocation().equals("Honalulu"));
	}
	
	@Test
	public void getControlReturnsCorrectControl()
	{
		Assert.assertTrue("Control of University1 is Minnesota", University1.getControl().equals("Private"));
		Assert.assertTrue("Control for University2 is Hawaii", University2.getControl().equals("Public"));
	}
	
	@Test
	public void getNumStudentsReturnsCorrectNumberOfStudents()
	{
		Assert.assertTrue("numStudents of University1 is 20000", University1.getNumStudents() == 10000);
		Assert.assertTrue("State for University2 is Hawaii", University2.getNumStudents() == 20000);
	}
	
	@Test
	public void getPercentFemaleReturnsCorrectPercentageOfFemales()
	{
		Assert.assertTrue("percentFemale of University1 is 50%", University1.getPercentFemale() == 50.0);
		Assert.assertTrue("percentFemale for University2 is 75%", University2.getPercentFemale() == 75.0);
	}
	
	@Test
	public void getSATVerbalReturnsCorrectSATVerbal()
	{
		Assert.assertTrue("SATVerbal of University1 is 100", University1.getSATVerbal() == 100.0);
		Assert.assertTrue("SATVerbal for University2 is 100", University2.getSATVerbal() == 100.0);
	}
	
	@Test
	public void getSATMathReturnsCorrectSATMath()
	{
		Assert.assertTrue("SATMath of University1 is 100", University1.getSATMath() == 100.0);
		Assert.assertTrue("SATMath for University2 is 100", University2.getSATMath() == 100.0);
	}
	
	@Test
	public void getExpensesReturnsCorrectExpenses()
	{
		Assert.assertTrue("Expenses of University1 is 50000", University1.getExpenses() == 50000.0);
		Assert.assertTrue("Expenses for University2 is 100", University2.getExpenses() == 30000.0);
	}
	
	@Test
	public void getPercentFinancialAidReturnsCorrectPercentFinancialAid()
	{
		Assert.assertTrue("PercentFinancialAid of University1 is 50%", University1.getPercentFinancialAid() == 50.0);
		Assert.assertTrue("Expenses for University2 is 25%", University2.getPercentFinancialAid() == 25.0);
	}
	
	@Test
	public void setNameCorrectlyChangesUniversityName()
	{
		University1.setSchoolName("College of Saint Benedict");
		Assert.assertTrue("Name for University1 is now College of Saint Benedict", University1.getName().equals("College of Saint Benedict"));
		University2.setSchoolName("University of ACM");
		Assert.assertTrue("Name for University2 is now University of ACM", University2.getName().equals("University of ACM"));
	}
	
	
}
