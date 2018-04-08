package Test.ControllerTests;
import Controllers.*;

import entityClasses.*;
import java.util.*;
import org.junit.*;

/**
 * A JUnit test case class for the SearchController Class
 * 
 */

public class SearchControllerTest {

	private SearchController sc;
	
	private DBController dbc;

	private ArrayList<University> universities1, universities2;

	private University u1, u2, u3, u4, u5, u6, searchUniversity1, searchUniversity2;

	private Student student;

	@Before
	public void init() {
		sc = new SearchController();
		dbc = new DBController();
		ArrayList<String> emphases = new ArrayList<String>();
		emphases.add("MATH");
		universities1 = new ArrayList<University>();
		universities2 = new ArrayList<University>();
		searchUniversity1 = new University("SEARCH UNIVERSITY 1", "MINNESOTA", "URBAN", "PRIVATE", 100, 10.0, 100, 100, 100, 10, 100, 10, 10, 1, 1, 1, emphases );
		searchUniversity2 = new University("SEARCH UNIVERSITY 2", "WISCONSIN", "RURAL", "PUBLIC", 1000, 100.0, 800, 800, 1000, 100, 1000, 100, 100, 5, 5, 5, new ArrayList<String>() );
		u1 = new University("TestUniversity1", "MINNESOTA", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, emphases );
		u2 = new University("TestUniversity2", "MINNESOTA", "URBAN", "PRIVATE", 5000, 65.0, 701, 600, 40000, 50, 49000, 31, 25, 4, 3, 2, emphases );
		u3 = new University("TestUniversity3", "MINNESOTA", "URBAN", "PRIVATE", 5000, 54.0, 702, 601, 39000, 51, 48000, 32, 40, 3, 4, 2, emphases );
		u4 = new University("TestUniversity4", "MINNESOTA", "URBAN", "PRIVATE", 5000, 53.0, 703, 602, 38000, 52, 47000, 33, 40, 2, 4, 3, emphases );
		u5 = new University("TestUniversity5", "MINNESOTA", "URBAN", "PRIVATE", 5000, 62.0, 704, 603, 37000, 53, 46000, 34, 40, 1, 5, 4, emphases );
		u6 = new University("TestUniversity6", "IOWA", "URBAN", "PRIVATE", 5000, 63.0, 705, 604, 36000, 54, 45000, 35, 40, 4, 5, 5, emphases );
		universities1.add(u1);
		universities1.add(u2);
		student = new Student("Test", "Student", "user", "password", 'a', true, true, new ArrayList<University>());
		dbc.addUser(student);
		dbc.addUniversity(u1);
		dbc.addUniversity(u2);
		dbc.addUniversity(u3);
		dbc.addUniversity(u4);
		dbc.addUniversity(u5);
		dbc.addUniversity(u6);
		dbc.addUniversity(searchUniversity1);
		dbc.addUniversity(searchUniversity2);
	}

//	@Test
//	public void testcompareStatsNormalRangeCase() {
//		Assert.assertTrue("comparing 5 to the range 5 to 5 should return 1", sc.compareStats(5, 5, 5) == 1);
//		Assert.assertTrue("comparing 5 to the range 5 to 6 should return 1", sc.compareStats(5, 5, 6) == 1);
//		Assert.assertTrue("comparing 5 to the range 4 to 5 should return 1", sc.compareStats(5, 4, 5) == 1);
//		Assert.assertTrue("comparing 5 to the range 4 to 6 should return 1", sc.compareStats(5, 4, 6) == 1);		
//	}
//
//	@Test
//	public void testcompareStatsLowerInputEqualsZeroCase() {
//		Assert.assertTrue("comparing 1 to the range 0 to 1 should return 1", sc.compareStats(1, 0, 1) == 1);
//		Assert.assertTrue("comparing 1 to the range 0 to 2 should return 1", sc.compareStats(1, 0, 2) == 1);		
//	}
//
//	@Test
//	public void testcompareStatsUpperInputEqualsZeroCase() {
//		Assert.assertTrue("comparing 1 to the range 1 to 0 should return 1", sc.compareStats(1, 1, 0) == 1);
//		Assert.assertTrue("comparing 2 to the range 1 to 0 should return 1", sc.compareStats(2, 1, 0) == 1);		
//	}
//
//	@Test
//	public void testcompareStatsLowerAndUperInputsEqualZeroCase() {
//		Assert.assertTrue("comparing 1 to the range 0 to 0 should return 1", sc.compareStats(1, 0, 0) == 1);		
//	}
//
//	@Test
//	public void testcompareStatsNoMatchCase() {
//		Assert.assertTrue("comparing 2 to the range 3 to 5 should return 0", sc.compareStats(2, 3, 5) == 0);
//		Assert.assertTrue("comparing 2 to the range 0 to 1 should return 0", sc.compareStats(2, 0, 1) == 0);
//		Assert.assertTrue("comparing 2 to the range 3 to 0 should return 0", sc.compareStats(2, 3, 0) == 0);
//
//	}

	@Test
	public void testViewUniversity() {
		Assert.assertTrue("returned university should match expected result for viewing a university", sc.viewUniversity(u1.getName()).equals(u1));
	}

	@Test
	public void testViewUniversities() {
		HashMap<String, University> universities = sc.viewUniversities(universities1);
		Assert.assertTrue("TestUniversity1 should be saved to the student", universities.containsKey(u1.getName()));
		Assert.assertTrue("TestUniversity2 should be saved to the student", universities.containsKey(u2.getName()));
		Assert.assertTrue("Saved Universities size should be 2", universities.size() == 2);
	}

	@Test
	public void testSaveUniversityReturns1() {
		Assert.assertTrue("saving school to student should return 1", sc.saveUniversity(student, u1) == 1);
	}

	@Test
	public void testSaveUniversityReturnsNegative1() {
		sc.saveUniversity(student, u1);
		Assert.assertTrue("saving school to student should return -1", sc.saveUniversity(student, u1) == -1);
	}
	
	@Test (expected = InputMismatchException.class)
	public void testSearchUniversities_AllEmptyParameters() {
		sc.searchUniversities("", "", "", "", 0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0, new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case1() {
		sc.searchUniversities(null, "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case2() {
		sc.searchUniversities("", null, "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case3() {
		sc.searchUniversities("", "", null, "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case4() {
		sc.searchUniversities("", "", "", null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case5() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  null);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case6() {
		sc.searchUniversities("", "", "", "", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case7() {
		sc.searchUniversities("", "", "", "", 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case8() {
		sc.searchUniversities("", "", "", "", 1000, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case9() {
		sc.searchUniversities("", "", "", "", 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case10() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case11() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case12() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case13() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case14() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case15() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case16() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case17() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case18() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0,  new ArrayList<String>());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSearchUniversities_AtleastOneInvalidParameter_Case19() {
		sc.searchUniversities("", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0,  new ArrayList<String>());
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case1() {
		ArrayList<University> foundUniversities = sc.searchUniversities("SEARCH UNIVERSITY 1","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case2() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","MIN","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case3() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","URBAN","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case4() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","PRIVATE", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case5() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case6() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case7() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case8() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case9() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case10() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 799, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case11() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case12() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 799, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case13() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case14() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case15() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case16() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case17() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case18() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case19() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case20() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case21() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case22() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case23() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case24() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case25() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case26() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case27() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case28() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case29() {
		ArrayList<String> emphases = new ArrayList<String>();
		emphases.add("MATH");
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  emphases);
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test 
	public void testSearchUniversities_Valid_Case30() {
		ArrayList<University> foundUniversities = sc.searchUniversities("","","","", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 5,  new ArrayList<String>());
		Assert.assertTrue("searchUniversity2 should be found in the search", foundUniversities.contains(searchUniversity2));
		Assert.assertFalse("searchUniversity1 should NOT be found in the search", foundUniversities.contains(searchUniversity1));
	}
	
//
//	@Test
//	public void testSearchUniversitiesAllFieldsFilled() {
//		ArrayList<String> emphases = new ArrayList<String>();
//		emphases.add("MATH");
//		ArrayList<University> foundUniversities = sc.searchUniversities("T", "MINNESOTA", "URBAN", "PRIVATE", 4000, 10000, 40, 80, 500, 800, 500,750, 20000, 50000, 20, 60, 5000, 55000, 20, 40, 10, 30, 1, 5, 1, 4, 1, 3, emphases );
//		Assert.assertTrue("TestUniversity1 should be found in the search", foundUniversities.contains(u1));
//		Assert.assertFalse("TestUniversity2 should NOT be found in the search", foundUniversities.contains(u6));
//	}
//
//	
//	@Test
//	public void testSearchUniversitiesSomeFieldsEmpty() {
//		ArrayList<String> emphases = new ArrayList<String>();
//		emphases.add("MATH");
//		ArrayList<University> foundUniversities = sc.searchUniversities("T", "MINNESOTA", "URBAN", "PRIVATE", 5000, 10000, 0, 0, 500, 0, 0, 750, 20000, 50000, 20, 60, 5000, 55000, 20, 40, 10, 30, 1, 5, 1, 4, 1, 3, null );
//		Assert.assertTrue("TestUniversity1 should be found in the search", foundUniversities.contains(u1));
//		Assert.assertFalse("TestUniversity2 should NOT be found in the search", foundUniversities.contains(u6));
//	}
//	
//	@Test (expected = IllegalArgumentException.class)
//	public void testSearchUniversitiesNoFieldsFilled() {
//		sc.searchUniversities(null, null, null, null, 0, 0,0,0,0,0,0,0, 0, 0, 0,0,0,0,0,0,0, 0, 0,0,0,0,0,0, null);
//	}
	
	@Test  //TODO : fix this
	public void testGetRecommendedUniversities() {
		ArrayList<University> recommendedUniversities = sc.getRecommendedUniversities(u1);		
//		Assert.assertTrue("TestUniversity2 should be recommended first", recommendedUniversities.get(0).equals(u2));
//		Assert.assertTrue("TestUniversity3 should be recommended second", recommendedUniversities.get(1).equals(u3));
//		Assert.assertTrue("TestUniversity4 should be recommended third", recommendedUniversities.get(2).equals(u4));
//		Assert.assertTrue("TestUniversity5 should be recommended fourth", recommendedUniversities.get(3).equals(u5));
//		Assert.assertTrue("TestUniversity6 should be recommended fifth", recommendedUniversities.get(4).equals(u6));
//		sc.getRecommendedUniversities(dbc.getUniversity("UNIVERSITY OF RYAN 2"));
		
	}
	
	@After
	public void destroy() {	
		dbc.deleteUser("user");
		dbc.deleteUniversity(u1);
		dbc.deleteUniversity(u2);
		dbc.deleteUniversity(u3);
		dbc.deleteUniversity(u4);
		dbc.deleteUniversity(u5);
		dbc.deleteUniversity(u6);
		dbc.deleteUniversity(searchUniversity1);
		dbc.deleteUniversity(searchUniversity2);
	}
}
