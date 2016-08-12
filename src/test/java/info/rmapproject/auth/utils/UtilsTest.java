package info.rmapproject.auth.utils;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testBase64String() {
		String random = Utils.generateRandomString(64);
		assertTrue(random.length()==64);
	}

	@Test
	public void testSha264String() {
		try {
			String sha256 = Utils.getSha256Hash("orcid.orghttp://orcid.org/0000-0000-0000-0000");
			assertTrue(sha256.equals("fa93c80c6f7f93e3c7e798a27adb29bfe8f671085a195f831d16bbf9a5220930"));
		} catch(Exception e) {
			fail("sha256 not calculated correctly");
		}
	}

}
