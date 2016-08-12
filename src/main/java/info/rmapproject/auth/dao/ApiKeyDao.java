package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;

import java.net.URI;
import java.util.List;
/**
 * Interface for accessing API Key table data 
 * @author khanson
 *
 */
public interface ApiKeyDao {
	/**
	 * Insert new API Key into the database
	 * @param apiKey
	 * @return
	 * @throws RMapAuthException
	 */
	public int addApiKey(ApiKey apiKey) throws RMapAuthException;
	
	/** 
	 * Update existing API key in database
	 * @param apiKey
	 * @throws RMapAuthException
	 */
	public void updateApiKey(ApiKey apiKey) throws RMapAuthException;
	
	/**
	 * Retrieve API key from database matching apiKey identifier provided
	 * @param apiKeyId
	 * @return
	 * @throws RMapAuthException
	 */
	public ApiKey getApiKeyById(int apiKeyId) throws RMapAuthException;
	
	/**
	 * Retrieve API key from database based on key/secret combination provided
	 * @param key
	 * @param secret
	 * @return
	 * @throws RMapAuthException
	 */
	public ApiKey getApiKeyByKeySecret(String key, String secret) throws RMapAuthException;
	
	/**
	 * Retrieve API key from database based on key URI provided
	 * @param accessKey
	 * @return
	 * @throws RMapAuthException
	 */
	public ApiKey getApiKeyByKeyUri(String accessKey) throws RMapAuthException;
	
	/**
	 * Retrieve list of API keys associated with userId provided
	 * @param userId
	 * @return
	 * @throws RMapAuthException
	 */
	public List<ApiKey> listApiKeyByUser(int userId) throws RMapAuthException;
	
	/**
	 * Retrieve the Agent URI associated with a key/secret comination
	 * @param accessKey
	 * @param secret
	 * @return
	 * @throws RMapAuthException
	 */
	public URI getAgentUriByKeySecret(String accessKey, String secret) throws RMapAuthException;
}