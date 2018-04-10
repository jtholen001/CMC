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

	private University u1, u2, u3, u4, u5, u6, searchUniversity1, searchUniversity2, u7, u8, u9, u10, u11, u12, u13;

	private Student student1, student2;

	@Before
	public void init() {
		dbc = new DBController();
		sc = new SearchController(dbc);
		
		ArrayList<String> emphases = new ArrayList<String>();
		emphases.add("MATH");
		
		ArrayList<String> emphases2 = new ArrayList<String>();	
		emphases2.add("BUSINESS");
		emphases2.add("MATH");

		//Used for testing search
		searchUniversity1 = new University("SEARCH UNIVERSITY 1", "MINNESOTA", "URBAN", "PRIVATE", 100, 10.0, 100, 100, 100, 10, 100, 10, 10, 1, 1, 1, emphases );
		searchUniversity2 = new University("SEARCH UNIVERSITY 2", "WISCONSIN", "RURAL", "PUBLIC", 1000, 100.0, 800, 800, 1000, 100, 1000, 100, 100, 5, 5, 5, new ArrayList<String>() );
		
		//used for testing getRecommendedUniversities
		u1 = new University("TEST UNIVERSITY 1", "MINNESOTA", "URBAN", "PRIVATE", 5000, 60.0, 700, 550, 40200, 45, 50000, 30, 20, 4, 3, 2, emphases2 );
		u2 = new University("TEST UNIVERSITY 2", "MINNESOTA", "URBAN", "PRIVATE", 5000, 65.0, 701, 600, 40000, 50, 49000, 31, 25, 4, 3, 2, emphases );
		u3 = new University("TEST UNIVERSITY 3", "MINNESOTA", "URBAN", "PRIVATE", 5000, 54.0, 702, 601, 39000, 51, 48000, 32, 40, 3, 4, 2, emphases );
		u4 = new University("TEST UNIVERSITY 4", "MINNESOTA", "URBAN", "PRIVATE", 5000, 53.0, 703, 602, 38000, 52, 47000, 33, 40, 2, 4, 3, emphases );
		u5 = new University("TEST UNIVERSITY 5", "MINNESOTA", "URBAN", "PRIVATE", 5000, 62.0, 704, 603, 37000, 53, 46000, 34, 40, 1, 5, 4, emphases2 );
		u6 = new University("TEST UNIVERSITY 6", "IOWA", "URBAN", "PRIVATE", 5000, 63.0, 705, 604, 36000, 54, 45000, 35, 40, 4, 5, 5, emphases );
		
		u7 = new University("TEST UNIVERSITY 7", "MONTANA", "RURAL", "PUBLIC", 1000, 90, 700, 550, 40200, 45, 21000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u8 = new University("TEST UNIVERSITY 8", "-1", "RURAL", "PUBLIC", 900, 88, 700, 550, 40200, 45, 20000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u9 = new University("TEST UNIVERSITY 9", "MONTANA", "-1", "PUBLIC", 800, 86, 700, 550, 40000, 40, 20000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u10 = new University("TEST UNIVERSITY 10", "MONTANA", "RURAL", "-1", 700, 86, 700, 550, 40000, 40, 22000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u11 = new University("TEST UNIVERSITY 11", "MONTANA", "RURAL", "PUBLIC", -1, 85, 700, 550, 40000, 39, 22000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u12 = new University("TEST UNIVERSITY 12", "MONTANA", "RURAL", "PUBLIC", 600, 85, 700, 550, 40500, 38, 23000, 30, 20, 1, 5, 4, new ArrayList<String>());
		u13 = new University("TEST UNIVERSITY 13", "-1", "-1", "-1", -1, 85, 700, 550, 40500, 38, 23000, 30, 20, 1, 5, 4, new ArrayList<String>());
		
		universities1 = new ArrayList<University>();
		universities1.add(u1);
		universities2 = new ArrayList<University>();
		universities2.add(u1);
		universities2.add(u2);
		
		student1 = new Student("Test", "Student", "testuser1", "password", 'u', true, true, new ArrayList<University>());
		student2 = new Student("Test", "Student", "testuser2", "password", 'u', true, true, universities1);
		dbc.addUser(student1);
		dbc.addUser(student2);
		
		dbc.addUniversity(u1);
		dbc.addUniversity(u2);
		dbc.addUniversity(u3);
		dbc.addUniversity(u4);
		dbc.addUniversity(u5);
		dbc.addUniversity(u6);		
		dbc.addUniversity(u7);
		dbc.addUniversity(u8);
		dbc.addUniversity(u9);
		dbc.addUniversity(u10);
		dbc.addUniversity(u11);
		dbc.addUniversity(u12);
		dbc.addUniversity(searchUniversity1);
		dbc.addUniversity(searchUniversity2);
	}

	@Test
	public void testViewUniversity() {
		Assert.assertTrue("returned university should match expected result for viewing a university", sc.viewUniversity(u1.getName()).equals(u1));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testViewUniversities_Invalid() {
		sc.viewUniversities(null);
		
	}
	
	@Test
	public void testViewUniversities_Valid_Case1() {
		HashMap<String, University> universities = sc.viewUniversities(new ArrayList<University>());
		Assert.assertTrue("Universities should be empty", universities.isEmpty());
	}	
	
	@Test
	public void testViewUniversities_Valid_Case2() {
		HashMap<String, University> universities = sc.viewUniversities(universities2);
		Assert.assertTrue("TestUniversity1 should be saved to the student", universities.containsKey(u1.getName()));
		Assert.assertTrue("TestUniversity2 should be saved to the student", universities.containsKey(u2.getName()));
		Assert.assertTrue("Saved Universities size should be 2", universities.size() == 2);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSaveUniversity_InvalidStudent() {
		sc.saveUniversity(null, u1);
	}

	@Test 
	public void testSaveUniversity_ValidStudent() {
		Assert.assertTrue("Saving university to student should return 1", sc.saveUniversity(student1, u1) == 1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testSaveUniversity_InvalidUniversity() {
		sc.saveUniversity(student2, null);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testSaveUniversity_ValidStudentCannotSaveAlreadySaved() {
		sc.saveUniversity(student2, u1);
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
	
	@Test 
	public void testSearchUniversities_Valid_Case31() {
		ArrayList<String> emphases = new ArrayList<String>();
		emphases.add("MATH");
		ArrayList<University> foundUniversities = sc.searchUniversities("SEARCH", "MIN", "URBAN", "PRIVATE", 50, 150, 5, 15, 50, 100, 50, 100, 50, 100, 5, 15, 50, 100, 5, 15, 5, 15, 1, 3, 1, 3, 1, 3, emphases);
		Assert.assertTrue("searchUniversity1 should be found in the search", foundUniversities.contains(searchUniversity1));
		Assert.assertFalse("searchUniversity2 should NOT be found in the search", foundUniversities.contains(searchUniversity2));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testGetRecommendedUniversities_InvalidUniversity() {
		ArrayList<University> recommendedUniversities = sc.getRecommendedUniversities(null);		
		
	}
	
	@Test  //TODO : fix this
	public void testGetRecommendedUniversities_Valid1() {
		ArrayList<University> recommendedUniversities = sc.getRecommendedUniversities(u1);		
		Assert.assertTrue("TEST UNIVERSITY 2 should be recommended first", recommendedUniversities.get(0).equals(u2));
		Assert.assertTrue("TEST UNIVERSITY 3 should be recommended second", recommendedUniversities.get(1).equals(u3));
		Assert.assertTrue("TEST UNIVERSITY 4 should be recommended third", recommendedUniversities.get(2).equals(u4));
		Assert.assertTrue("TEST UNIVERSITY 5 should be recommended fourth", recommendedUniversities.get(3).equals(u5));
		Assert.assertTrue("TEST UNIVERSITY 6 should be recommended fifth", recommendedUniversities.get(4).equals(u6));
		

	}
	
	@Test
	public void testGetRecommendedUniversities_Valid2() {
		ArrayList<University> recommendedUniversities = sc.getRecommendedUniversities(u7);		
		Assert.assertTrue("TEST UNIVERSITY 8 should be recommended first", recommendedUniversities.get(0).equals(u8));
		Assert.assertTrue("TEST UNIVERSITY 9 should be recommended second", recommendedUniversities.get(1).equals(u9));
		Assert.assertTrue("TEST UNIVERSITY 10 should be recommended third", recommendedUniversities.get(2).equals(u10));
		Assert.assertTrue("TEST UNIVERSITY 11 should be recommended fourth", recommendedUniversities.get(3).equals(u11));
		Assert.assertTrue("TEST UNIVERSITY 12 should be recommended fifth", recommendedUniversities.get(4).equals(u12));
		
	}
	
	@Test
	public void testGetRecommendedUniversities_Valid3() {
		ArrayList<University> recommendedUniversities = sc.getRecommendedUniversities(u13);		
		Assert.assertTrue("TEST UNIVERSITY 12 should be recommended first", recommendedUniversities.get(0).equals(u12));
		Assert.assertTrue("TEST UNIVERSITY 11 should be recommended second", recommendedUniversities.get(1).equals(u11));
		Assert.assertTrue("TEST UNIVERSITY 10 should be recommended third", recommendedUniversities.get(2).equals(u10));
		Assert.assertTrue("TEST UNIVERSITY 9 should be recommended fourth", recommendedUniversities.get(3).equals(u9));
		Assert.assertTrue("TEST UNIVERSITY 8 should be recommended fifth", recommendedUniversities.get(4).equals(u8));
		
	}
	
	@After
	public void destroy() {	
		dbc.deleteUser(student1.getUsername());
		dbc.deleteUser(student2.getUsername());
		dbc.deleteUniversity(u1);
		dbc.deleteUniversity(u2);
		dbc.deleteUniversity(u3);
		dbc.deleteUniversity(u4);
		dbc.deleteUniversity(u5);
		dbc.deleteUniversity(u6);
		dbc.deleteUniversity(u7);
		dbc.deleteUniversity(u8);
		dbc.deleteUniversity(u9);
		dbc.deleteUniversity(u10);
		dbc.deleteUniversity(u11);
		dbc.deleteUniversity(u12);
		dbc.deleteUniversity(searchUniversity1);
		dbc.deleteUniversity(searchUniversity2);
	}
}
