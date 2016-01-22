package info.rmapproject.auth.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testBase64String() {
		String random = Utils.generateRandomString(64);
		assertTrue(random.length()==64);
	}

}
