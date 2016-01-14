package info.rmapproject.auth.service;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;

import java.net.URI;
import java.util.List;
/**
 * 
 * @author khanson
 *
 */
public interface ApiKeyService {
	public int addApiKey(ApiKey apiKey) throws RMapAuthException;
	public void updateApiKey(ApiKey apiKey) throws RMapAuthException;
	public ApiKey getApiKeyById(int apiKeyId) throws RMapAuthException;
	public ApiKey getApiKeyByKeySecret(String accessKey, String secret) throws RMapAuthException;
	public URI getAgentUriByKeySecret(String accessKey, String secret) throws RMapAuthException;
	public List<ApiKey> listApiKeyByUser(int userId) throws RMapAuthException;
	public void validateApiKey(String accessKey, String secret) throws RMapAuthException;
}