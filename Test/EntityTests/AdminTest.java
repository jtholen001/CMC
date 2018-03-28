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
		Assert.assertTrue("Constructor fails for admin with empty firstName parameter:", new Admin("", "miller","jmill", "password0",
                'a', true, false) instanceof Admin);
}

	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidLastName() {
		Assert.assertTrue("Constructor fails for admin with empty lastName parameter:", new Admin("John", "","jmill", "password0",
                'a', true, false) instanceof Admin);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidUsername() {
		Assert.assertTrue("Constructor fails for admin with empty username parameter:", new Admin("John","Miller", "", "password0",
                'a', true, false) instanceof Admin);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidPassword() {
		Assert.assertTrue("Constructor fails for admin with empty password parameter:", new Admin("John","Miller", "jmill", "",
                'a', true, false) instanceof Admin);
	}
}