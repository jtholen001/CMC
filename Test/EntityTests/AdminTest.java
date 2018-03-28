package Test.EntityTests;
import org.junit.*;
import entityClasses.*;

public class AdminTest {
	@Test
	public void constructorSucseedsForValidInput() {
		Assert.assertTrue("Constructor should succeed for admin as all fields meet constructor criteria", new Admin("John","Miller","jmill", "password0",
                'a', true, false) instanceof Admin);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidFirstName() {
		Admin admin1 = new Admin("", "miller","jmill", "password0",'a', true, false);
}

	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidLastName() {
		Admin admin1 = new Admin("John", "","jmill", "password0", 'a', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidUsername() {
		Admin admin1 = new Admin("John","Miller", "", "password0", 'a', true, false);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidPassword() {
		Admin admin1 = new Admin("John","Miller", "jmill", "", 'a', true, false);
	}
}