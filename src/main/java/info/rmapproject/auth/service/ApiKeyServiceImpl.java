package info.rmapproject.auth.service;

import info.rmapproject.auth.dao.ApiKeyDao;
import info.rmapproject.auth.exception.ErrorCode;
import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;
import info.rmapproject.auth.model.KeyStatus;
import info.rmapproject.auth.utils.Constants;
import info.rmapproject.auth.utils.Utils;
import info.rmapproject.core.idservice.IdService;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for access to ApiKey related methods
 * @author khanson
 *
 */

@Service("apiKeyService")
@Transactional
public class ApiKeyServiceImpl {

	//private static final Logger logger = LoggerFactory.getLogger(ApiKeyServiceImpl.class);
	
	/**ApiKeys table data access component*/
	@Autowired
	ApiKeyDao apiKeyDao;
	
	/**RMap core Id Generator Service*/
	@Autowired
	IdService rmapIdService;
   
	/**
	 * Add new API Key
	 * @param apiKey
	 * @return
	 * @throws RMapAuthException
	 */
	public int addApiKey(ApiKey apiKey) throws RMapAuthException {
		//generate a new key/secret
		String newAccessKey = Utils.generateRandomString(Constants.ACCESS_KEY_LENGTH);
		String newSecret = Utils.generateRandomString(Constants.SECRET_LENGTH);
		//check for the very unlikely occurrence that a duplicate key/secret combo is generated
		URI agent = this.getAgentUriByKeySecret(newAccessKey, newSecret);
		if (agent!=null){
			//a duplicate key combo!!! - try again...
			newAccessKey = Utils.generateRandomString(Constants.ACCESS_KEY_LENGTH);
			newSecret = Utils.generateRandomString(Constants.SECRET_LENGTH);
			agent = null;
			agent = this.getAgentUriByKeySecret(newAccessKey, newSecret);
			if (agent!=null){
				//there is probably a system problem at this point
				throw new RMapAuthException(ErrorCode.ER_PROBLEM_GENERATING_NEW_APIKEY.getMessage());
			}
		}
		apiKey.setAccessKey(newAccessKey);
		apiKey.setSecret(newSecret);
		
		//associate a keyuri that can be included in the event
		URI keyUri = null;
		try {
			keyUri = rmapIdService.createId();
		} catch (Exception e) {
			throw new RMapAuthException(ErrorCode.ER_PROBLEM_GENERATING_NEW_APIKEY.getMessage(), e);
		}
		apiKey.setKeyUri(keyUri.toString());
		return apiKeyDao.addApiKey(apiKey);
	}

	/**
	 * Update API Key
	 * @param updatedApiKey
	 * @throws RMapAuthException
	 */
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

	/**
	 * Retrieve an API key based on a specific apiKey identifier
	 * @param apiKeyId
	 * @return
	 * @throws RMapAuthException
	 */
	public ApiKey getApiKeyById(int apiKeyId) throws RMapAuthException {
        return apiKeyDao.getApiKeyById(apiKeyId);
	}
	
	/**
	 * Retrieve an API key that matches the key/secret combination provided
	 * @param accessKey
	 * @param secret
	 * @return
	 * @throws RMapAuthException
	 */
	public ApiKey getApiKeyByKeySecret(String accessKey, String secret) throws RMapAuthException {
        return apiKeyDao.getApiKeyByKeySecret(accessKey, secret);		
	}

	/**
	 * Retrieve the Agent URI that matches the key/secret combination provided
	 * @param accessKey
	 * @param secret
	 * @return
	 * @throws RMapAuthException
	 */
	public URI getAgentUriByKeySecret(String accessKey, String secret) throws RMapAuthException {
        return apiKeyDao.getAgentUriByKeySecret(accessKey, secret);		
	}	

	/**
	 * Retrieve a list of API keys that are associated with a user
	 * @param userId
	 * @return
	 * @throws RMapAuthException
	 */
	public List<ApiKey> listApiKeyByUser(int userId) throws RMapAuthException {
        return apiKeyDao.listApiKeyByUser(userId);
	}
	
	/**
	 * Validate an API key/secret combination to ensure the user has access to write to RMap
	 * @param accessKey
	 * @param secret
	 * @throws RMapAuthException
	 */
	public void validateApiKey(String accessKey, String secret) throws RMapAuthException {

		ApiKey apiKey = getApiKeyByKeySecret(accessKey, secret);

		if (apiKey !=null){
			KeyStatus keyStatus = apiKey.getKeyStatus();
			Date keyStartDate = apiKey.getStartDate();
			Date keyEndDate = apiKey.getEndDate();
		
	        Calendar now = Calendar.getInstance();
	        now.set(Calendar.HOUR_OF_DAY, 0);
	        now.set(Calendar.MINUTE, 0);
	        now.set(Calendar.SECOND, 0);
			Date today = now.getTime();
			now.add(Calendar.DATE, -1);
			Date yesterday = now.getTime();
			
			if(keyStatus != KeyStatus.ACTIVE
				|| (keyStartDate!=null && keyStartDate.after(today))
				|| (keyEndDate!=null && keyEndDate.before(yesterday))) {
				//key not valid! throw exception
				throw new RMapAuthException(ErrorCode.ER_KEY_INACTIVE.getMessage());				
			}
		}
		else {
			throw new RMapAuthException(ErrorCode.ER_ACCESSCODE_SECRET_NOT_FOUND.getMessage());
		}
		
	}
	
	

}
