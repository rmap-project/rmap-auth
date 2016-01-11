package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;

import java.net.URI;
import java.util.List;
/**
 * 
 * @author khanson
 *
 */
public interface ApiKeyDao {
	public void addApiKey(ApiKey apiKey) throws RMapAuthException;
	public void updateApiKey(ApiKey apiKey) throws RMapAuthException;
	public ApiKey getApiKeyById(int apiKeyId) throws RMapAuthException;
	public ApiKey getApiKeyByKeySecret(String key, String secret) throws RMapAuthException;
	public List<ApiKey> listApiKeyByUser(int userId) throws RMapAuthException;
	public URI getAgentUriByKeySecret(String accessKey, String secret) throws RMapAuthException;
}