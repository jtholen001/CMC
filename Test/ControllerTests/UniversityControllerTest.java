package Test.ControllerTests;

import Controllers.*;
import entityClasses.*;
import java.util.*;
import org.junit.*;

public class UniversityControllerTest 
{
	
	private UniversityController uniCont;
	private University university;
	private DBController dbCont;
	private HashMap<String, University> listAll; 
	
	@Before
	public void init() 
	{
		uniCont = new UniversityController();
		university = new University("UNIVERSITY OF CMC", "ARIZONA", "URBAN", "PUBLIC", 5, 0.0, 500.0, 500.0, 90.0, 0.0, 5, 90.0, 90.0, 1, 1, 1, new ArrayList<String>());
		dbCont = new DBController();
		listAll = dbCont.viewUniversities();
		dbCont.addUniversity(university);
	}
	
	@Test
	public void testEditUniversity()
	{
		uniCont.editUniversity(university, "MINNESOTA", "CITY", "PRIVATE", 4, 20.0, 100.0, 100.0, 80.0, 1.0, 6, 80.0, 60.0, 2, 2, 2, new ArrayList<String>());
		Assert.assertTrue("STATE: MINNESOTA", dbCont.getUniversity("UNIVERSITY OF CMC").getState().equals("MINNESOTA"));
		Assert.assertTrue("Location: CITY", dbCont.getUniversity("UNIVERSITY OF CMC").getLocation().equals("CITY"));
		Assert.assertTrue("Control: PRIVATE", dbCont.getUniversity("UNIVERSITY OF CMC").getControl().equals("PRIVATE"));
		Assert.assertTrue("NumStudents : 4", dbCont.getUniversity("UNIVERSITY OF CMC").getNumStudents() == 4);
		Assert.assertTrue("PercentFemale : 20.0", dbCont.getUniversity("UNIVERSITY OF CMC").getPercentFemale() == 20.0);
		Assert.assertTrue("SATVerbal : 100.0", dbCont.getUniversity("UNIVERSITY OF CMC").getSATVerbal() == 100.0);
		Assert.assertTrue("SATMath : 100.0", dbCont.getUniversity("UNIVERSITY OF CMC").getSATMath() == 100.0);
		Assert.assertTrue("Expenses : 1.0", dbCont.getUniversity("UNIVERSITY OF CMC").getExpenses() == 80.0);
		Assert.assertTrue("PercentFinancialAid : 80.0", dbCont.getUniversity("UNIVERSITY OF CMC").getPercentFinancialAid() == 1.0);
		Assert.assertTrue("NumApplicants : ", dbCont.getUniversity("UNIVERSITY OF CMC").getNumApplicants() == 6);
		Assert.assertTrue("PercentAdmitted : 80.0", dbCont.getUniversity("UNIVERSITY OF CMC").getPercentAdmitted() == 80.0);
		Assert.assertTrue("PercentEnrolled : 60.0", dbCont.getUniversity("UNIVERSITY OF CMC").getPercentEnrolled() == 60.0);
		Assert.assertTrue("AcademicScale : 2", dbCont.getUniversity("UNIVERSITY OF CMC").getAcademicScale() == 2);
		Assert.assertTrue("SocialScale : 2", dbCont.getUniversity("UNIVERSITY OF CMC").getSocialScale() == 2);
		Assert.assertTrue("QualityOfLifeScale : 2", dbCont.getUniversity("UNIVERSITY OF CMC").getQualityOfLifeScale() == 2);
		
		
		
	}
	
	@After
	public void destroy()
	{
		dbCont.deleteUniversity(university);
	}
}
