package Test.EntityTests;
import org.junit.*;
import entityClasses.*;

public class AdminTest {
	@Test
	public void constructorSucseedsForValidInput()
	{
		Assert.assertTrue("Constructor should succeed for university as all fields meet constructor criteria", new Admin("John","Miller","jmill", "password0",
                'a', true, false) instanceof Admin);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorFailsForInvalidInput()
	{
		Assert.assertTrue("Constructor fails for university with name null:", new Admin(null, "miller","jmill", "password0",
                'a', true, false) instanceof Admin);
		Assert.assertTrue("Constructor fails for university with state field missing:", new Admin("John", null,"jmill", "password0",
                'a', true, false) instanceof Admin);
		Assert.assertTrue("Constructor suceeds for university with all fields meeting criteria:", new Admin("John","Miller", null, "password0",
                'a', true, false) instanceof Admin);
}
