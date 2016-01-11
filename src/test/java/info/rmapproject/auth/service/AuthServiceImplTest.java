package info.rmapproject.auth.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;
import info.rmapproject.auth.model.User;

import java.net.URI;

import org.junit.Before;
import org.junit.Test;

public class AuthServiceImplTest {
	private RMapAuthService authService = null;
	
	@Before
	public void setUp() throws Exception {
		try {
			authService = RMapAuthServiceFactory.createService();
		} catch (Exception e) {
			fail("Exception thrown " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAuthObj() {
		User user = null;
		try {
			user = authService.getUserById(4);
		} catch (RMapAuthException e) {
			fail("Exception thrown " + e.getMessage());
		}
		String name = user.getName();
		assertEquals("RMap test Agent", name);	
	}
	
	@Test
	public void testKeySecret() {
		String accessKey = "rmaptest";
		String secret = "rmaptest";
		ApiKey apiKey = null;
		try {
			apiKey = authService.getApiKeyByKeySecret(accessKey,secret);
		} catch (RMapAuthException e) {
			fail("Exception thrown " + e.getMessage());
		}
		assertEquals(apiKey.getLabel(), "RMap Test Agent");
	}
	
	@Test
	public void testGetAgentUriByKeySecret() {
		String accessKey = "rmaptest";
		String secret = "rmaptest";
		URI agentUri = null;
		try {
			agentUri = authService.getAgentUriByKeySecret(accessKey,secret);
		} catch (RMapAuthException e) {
			e.printStackTrace();
		}
		assertEquals(agentUri.toString(), "ark:/22573/rmaptestagent");
	}
	
	@Test
	public void testGetUserById() {
		int userId = 4;
		User user = null;
		try {
			user = authService.getUserById(userId);
		} catch (RMapAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(user.getRmapAgentUri(),"ark:/22573/rmaptestagent");
	}
	
	
		
}
