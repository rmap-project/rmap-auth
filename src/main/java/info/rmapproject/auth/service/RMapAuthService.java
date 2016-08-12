package info.rmapproject.auth.service;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;
import info.rmapproject.auth.model.User;
import info.rmapproject.auth.model.UserIdentityProvider;
import info.rmapproject.core.model.event.RMapEvent;

import java.net.URI;
import java.util.List;

/**
 * Service interface for managing, validating, and accessing RMap users
 * and user keys
 * @author khanson
 *
 */
public interface RMapAuthService {
	/**
	 * Add new API Key
	 * @param apiKey
	 * @return
	 * @throws RMapAuthException
	 */
	public int addApiKey(ApiKey apiKey) throws RMapAuthException;
	
	/**
	 * Update API Key
	 * @param apiKey
	 * @throws RMapAuthException
	 */
	public void updateApiKey(ApiKey apiKey) throws RMapAuthException;
	
	/**
	 * Retrieve an API key based on a specific apiKey identifier
	 * @param apiKeyId
	 * @return
	 * @throws RMapAuthException
	 */
	public ApiKey getApiKeyById(int apiKeyId) throws RMapAuthException;
	
	/**
	 * Retrieve an API key that matches the key/secret combination provided
	 * @param accessKey
	 * @param secret
	 * @return
	 * @throws RMapAuthException
	 */
	public ApiKey getApiKeyByKeySecret(String accessKey, String secret) throws RMapAuthException;
	
	/**
	 * Retrieve the Agent URI that matches the key/secret combination provided
	 * @param accessKey
	 * @param secret
	 * @return
	 * @throws RMapAuthException
	 */
	public URI getAgentUriByKeySecret(String accessKey, String secret) throws RMapAuthException;
	
	/**
	 * Retrieve a list of API keys that are associated with a user
	 * @param userId
	 * @return
	 * @throws RMapAuthException
	 */
	public List<ApiKey> listApiKeyByUser(int userId) throws RMapAuthException;
	
	/**
	 * Create a new user
	 * @param user
	 * @return
	 * @throws RMapAuthException
	 */
	public int addUser(User user) throws RMapAuthException;
	
	/**
	 * Updates entire User record based on User object provided
	 * @param user
	 * @throws RMapAuthException
	 */
	public void updateUser(User user) throws RMapAuthException;
	
	/**
	 * Only updates any changed settings from the GUI - i.e. name and email
	 * Protects the rest of the record from accidental corruption
	 * @param user
	 * @throws RMapAuthException
	 */
	public void updateUserSettings(User user) throws RMapAuthException;
	
	/**
	 * Retrieve a user matching the userId provided
	 * @param userId
	 * @return
	 * @throws RMapAuthException
	 */
	public User getUserById(int userId) throws RMapAuthException;
	
	/**
	 * Retrieve the user that matches the key/secret combination provided
	 * @param accessKey
	 * @param secret
	 * @return
	 * @throws RMapAuthException
	 */
	public User getUserByKeySecret(String accessKey, String secret) throws RMapAuthException;
	
	/**
	 * Retrieve the user that matches a specific id provider account	
	 * @param idProvider
	 * @param idProviderId
	 * @return
	 * @throws RMapAuthException
	 */
	public User getUserByProviderAccount(String idProvider, String idProviderId) throws RMapAuthException;
	
	/**
	 * Retrieves User object by searching using the authKeyUri provided
	 * @param userId
	 * @return
	 */
	public User getUserByAuthKeyUri(String authKeyUri) throws RMapAuthException;
	
	/**
	 * Validate an API key/secret combination to ensure the user has access to write to RMap
	 * @param accessKey
	 * @param secret
	 * @throws RMapAuthException
	 */
	public void validateApiKey(String accessKey, String secret) throws RMapAuthException;
	
	/**
	 * Compares the user in the user database to the Agents in RMap. If the Agent is already in RMap
	 * and details that have changed are updated. If the Agent is not in RMap it is created.
	 * @param userId
	 * @return
	 * @throws RMapAuthException
	 */
	public RMapEvent createOrUpdateAgentFromUser(int userId) throws RMapAuthException;
	
	/**
	 * Retrieve a the UserIdentityProvider fora given provider name and id - this is an object
	 * containing details of the user profile on specific id provider.
	 * @param idProviderUrl
	 * @param providerAccountPublicId
	 * @return
	 * @throws RMapAuthException
	 */
	public UserIdentityProvider getUserIdProvider(String idProviderUrl, String providerAccountPublicId) throws RMapAuthException;
	
	/**
	 * Creates a new identity provider profile for a specific user
	 * @param userIdProvider
	 * @return
	 * @throws RMapAuthException
	 */
	public int addUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException;
	
	/**
	 * Updates an existing identity provider profile for a specific user
	 * @param userIdProvider
	 * @throws RMapAuthException
	 */
	public void updateUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException;
	
	/**
	 * Retrieves list of Identity Provider 
	 * @param userId
	 * @return
	 * @throws RMapAuthException
	 */
	public List<UserIdentityProvider> getUserIdProviders(int userId) throws RMapAuthException;
}
