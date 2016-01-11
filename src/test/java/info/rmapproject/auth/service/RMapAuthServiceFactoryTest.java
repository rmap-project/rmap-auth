package info.rmapproject.auth.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class RMapAuthServiceFactoryTest {

	@Test
	public void testCreateRMapAuthService() {
		try {
			RMapAuthService authService = RMapAuthServiceFactory.createService();
			assertTrue(authService instanceof RMapAuthService);
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
			e.printStackTrace();
		}
	}

}
