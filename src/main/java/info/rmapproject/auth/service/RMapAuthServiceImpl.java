package info.rmapproject.auth.service;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;
import info.rmapproject.auth.model.User;
import info.rmapproject.auth.model.UserIdentityProvider;
import info.rmapproject.core.model.event.RMapEvent;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class RMapAuthServiceImpl implements RMapAuthService {
	
	@Autowired
	private ApiKeyServiceImpl apiKeyService; 
	@Autowired
	private UserServiceImpl userService; 
	@Autowired
	private UserRMapAgentServiceImpl agentService; 
	@Autowired
	private UserIdProviderServiceImpl userIdProviderService; 
	
	public int addApiKey(ApiKey apiKey) throws RMapAuthException{
		return apiKeyService.addApiKey(apiKey);
	}
	
	public void updateApiKey(ApiKey apiKey) throws RMapAuthException{
		apiKeyService.updateApiKey(apiKey);
	}
	public ApiKey getApiKeyById(int apiKeyId) throws RMapAuthException{
		return apiKeyService.getApiKeyById(apiKeyId);		
	}
	public List<ApiKey> listApiKeyByUser(int userId) throws RMapAuthException{
		return apiKeyService.listApiKeyByUser(userId);
	}

	public ApiKey getApiKeyByKeySecret(String accessKey, String secret) throws RMapAuthException {
		return apiKeyService.getApiKeyByKeySecret(accessKey,secret);		
	}
	
	public URI getAgentUriByKeySecret(String accessKey, String secret) throws RMapAuthException{
		return apiKeyService.getAgentUriByKeySecret(accessKey,secret);
	}

	public void validateApiKey(String accessKey, String secret) throws RMapAuthException {
		apiKeyService.validateApiKey(accessKey,secret);		
	}
	
	public int addUser(User user) throws RMapAuthException{
		return userService.addUser(user);
	}
	
	public void updateUser(User user) throws RMapAuthException{
		userService.updateUser(user);
	}
	
	public void updateUserSettings(User user) throws RMapAuthException{
		userService.updateUserSettings(user);
	}
	
	public User getUserById(int userId) throws RMapAuthException{
		return userService.getUserById(userId);
	}
	
	public User getUserByKeySecret(String key, String secret) throws RMapAuthException{
		return userService.getUserByKeySecret(key, secret);
	}

	public User getUserByProviderAccount(String idProvider, String idProviderId) throws RMapAuthException{
		return userService.getUserByProviderAccount(idProvider, idProviderId);
	}
	
	public RMapEvent createOrUpdateAgentFromUser(int userId) throws RMapAuthException {
		return agentService.createOrUpdateAgentFromUser(userId);
	}	

	public int addUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException {
		return userIdProviderService.addUserIdProvider(userIdProvider);
	}	
	
	public UserIdentityProvider getUserIdProvider(String idProviderUrl, String providerAccountId) 
			throws RMapAuthException{
		return userIdProviderService.getUserIdProvider(idProviderUrl, providerAccountId);
	}
	
	public void updateUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException {
		userIdProviderService.updateUserIdProvider(userIdProvider);
	}
	
		
}
