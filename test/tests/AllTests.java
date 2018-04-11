package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FunctionalTests.class, LoginControllerTest.class, ProfileControllerTest.class,
		SearchControllerTest.class, StudentTest.class, StudentUniversitiesControllerTest.class, TestDBController.class,
		UniversityControllerTest.class, UniversityTest.class, UsersControllerTest.class, UserTest.class })
public class AllTests {

}
