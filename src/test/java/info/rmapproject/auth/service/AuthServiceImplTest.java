package info.rmapproject.auth.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;
import info.rmapproject.auth.model.User;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration({ "classpath*:/spring-*-context.xml" })
public class AuthServiceImplTest {
	
	@Autowired
	private RMapAuthService rmapAuthService;
	
	@Test
	public void testAuthObj() {
		User user = null;
		try {
			user = rmapAuthService.getUserById(3);
		} catch (RMapAuthException e) {
			fail("Exception thrown " + e.getMessage());
		}
		String name = user.getName();
		assertEquals("Portico", name);	
	}
	
	@Test
	public void testKeySecret() {
		String accessKey = "rmaptest";
		String secret = "rmaptest";
		ApiKey apiKey = null;
		try {
			apiKey = rmapAuthService.getApiKeyByKeySecret(accessKey,secret);
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
			agentUri = rmapAuthService.getAgentUriByKeySecret(accessKey,secret);
		} catch (RMapAuthException e) {
			e.printStackTrace();
		}
		assertEquals(agentUri.toString(), "ark:/22573/rmaptestagent");
	}
	
	@Test
	public void testGetUserById() {
		int userId = 3;
		User user = null;
		try {
			user = rmapAuthService.getUserById(userId);
		} catch (RMapAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(user.getRmapAgentUri(),"ark:/22573/rmd18m7mj4");
	}
	
	@Test
	public void testValidateKey() {
		String accessKey = "jhu";
		String secret = "jhu";
		try {
			rmapAuthService.validateApiKey(accessKey, secret);
		} catch (RMapAuthException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGetUserByKeySecret() {
		String accessKey = "jhu";
		String secret = "jhu";
		try {
			rmapAuthService.getUserByKeySecret(accessKey, secret);
		} catch (RMapAuthException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
	
	
	
		
}
