package info.rmapproject.auth.service;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.AgentType;
import info.rmapproject.auth.model.ApiKey;
import info.rmapproject.auth.model.User;

import java.net.URI;
import java.util.List;

public interface RMapAuthService {
	public List<AgentType> getAgentTypes() throws RMapAuthException;
	public int addApiKey(ApiKey apiKey) throws RMapAuthException;
	public void updateApiKey(ApiKey apiKey) throws RMapAuthException;
	public ApiKey getApiKeyById(int apiKeyId) throws RMapAuthException;
	public ApiKey getApiKeyByKeySecret(String accessKey, String secret) throws RMapAuthException;
	public URI getAgentUriByKeySecret(String accessKey, String secret) throws RMapAuthException;
	public List<ApiKey> listApiKeyByUser(int userId) throws RMapAuthException;
	public int addUser(User user) throws RMapAuthException;
	public void updateUserSettings(User user) throws RMapAuthException;
	public User getUserById(int userId) throws RMapAuthException;
	public void validateApiKey(String accessKey, String secret) throws RMapAuthException;
}
