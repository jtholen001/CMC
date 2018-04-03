import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Test.ControllerTests.*;
import Test.EntityTests.*;
import Test.InterfaceTests.*;

@RunWith(Suite.class)
@SuiteClasses({ ProfileControllerTest.class,
				SearchControllerTest.class,
				StudentUniversitiesControllerTest.class,
				TestDBController.class,
				UniversityControllerTest.class,
				UsersControllerTest.class,
				AdminTest.class,
				StudentTest.class,
				UniversityTest.class,
				UserTest.class,
				AdminInterfaceTest.class
})

public class TestSuite {

}
