package info.rmapproject.auth.service;

import info.rmapproject.auth.dao.ApiKeyDao;
import info.rmapproject.auth.exception.ErrorCode;
import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;
import info.rmapproject.auth.model.KeyStatus;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author khanson
 *
 */

@Service("apiKeyService")
@Transactional
public class ApiKeyServiceImpl implements ApiKeyService {

	//private static final Logger logger = LoggerFactory.getLogger(ApiKeyServiceImpl.class);
	
	@Autowired
	ApiKeyDao apiKeyDao;
   
	public int addApiKey(ApiKey apiKey) throws RMapAuthException {
		//TODO:putting values here so db doesn't reject, need to go out and get these.
		apiKey.setAccessKey("abcdefg");
		apiKey.setSecret("123456789");
		apiKey.setKeyUri("ark:/29297/12345");
		return apiKeyDao.addApiKey(apiKey);
	}

	public void updateApiKey(ApiKey updatedApiKey) throws RMapAuthException {
		final ApiKey apiKey = getApiKeyById(updatedApiKey.getApiKeyId());
		apiKey.setLabel(updatedApiKey.getLabel());
		apiKey.setNote(updatedApiKey.getNote());
		apiKey.setKeyStatus(updatedApiKey.getKeyStatus());
		apiKey.setStartDate(updatedApiKey.getStartDate());
		apiKey.setEndDate(updatedApiKey.getEndDate());
		apiKey.setLastModifiedDate(new Date());
		if (apiKey.getKeyStatus()==KeyStatus.REVOKED){
			apiKey.setRevokedDate(new Date());
		}
		apiKeyDao.updateApiKey(apiKey);
	}

	public ApiKey getApiKeyById(int apiKeyId) throws RMapAuthException {
        return apiKeyDao.getApiKeyById(apiKeyId);
	}
	
	public ApiKey getApiKeyByKeySecret(String accessKey, String secret) throws RMapAuthException {
        return apiKeyDao.getApiKeyByKeySecret(accessKey, secret);		
	}

	public URI getAgentUriByKeySecret(String accessKey, String secret) throws RMapAuthException {
        return apiKeyDao.getAgentUriByKeySecret(accessKey, secret);		
	}
	
	public List<ApiKey> listApiKeyByUser(int userId) throws RMapAuthException {
        return apiKeyDao.listApiKeyByUser(userId);
	}
	
	public void validateApiKey(String accessKey, String secret) throws RMapAuthException {

		ApiKey apiKey = getApiKeyByKeySecret(accessKey, secret);

		if (apiKey !=null){
			Date currdate = new Date();
			KeyStatus keyStatus = apiKey.getKeyStatus();
			Date keyStartDate = apiKey.getStartDate();
			Date keyEndDate = apiKey.getEndDate();
		
			if(keyStatus != KeyStatus.ACTIVE
				|| (keyStartDate!=null && keyStartDate.after(currdate))
				|| (keyEndDate!=null && keyEndDate.after(currdate))) {
				//key not valid! throw exception
				throw new RMapAuthException(ErrorCode.ER_KEY_INACTIVE.getMessage());				
			}
		}
		else {
			throw new RMapAuthException(ErrorCode.ER_ACCESSCODE_SECRET_NOT_FOUND.getMessage());
		}
		
	}
	
	

}
