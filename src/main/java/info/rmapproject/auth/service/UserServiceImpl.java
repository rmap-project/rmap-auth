package info.rmapproject.auth.service;

import info.rmapproject.auth.dao.UserDao;
import info.rmapproject.auth.exception.ErrorCode;
import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;
import info.rmapproject.auth.utils.Constants;
import info.rmapproject.auth.utils.Utils;
import info.rmapproject.core.idservice.IdService;
import info.rmapproject.core.utils.ConfigUtils;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author khanson
 *
 */

@Service("userService")
@Transactional
public class UserServiceImpl {

//private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired 
	IdService rmapIdService;
	
	@Autowired
	UserDao userDao; 	
	
	/**
	 * Creates a new user based on User object provided
	 * @param user
	 * @return
	 */
	public int addUser(User user) {
		//TODO: this is a temporary measure - need to calculate authorization key using base64 of email + IDproviders
		String baseUrl = ConfigUtils.getPropertyValue(Constants.RMAP_AUTH_PROPFILE, Constants.RMAP_BASE_URL_KEY);
		
		String authKeyUri = baseUrl + Constants.AUTH_ID_FOLDER + "/" + Utils.generateRandomString(32);
		User dupUser = this.getUserByAuthKeyUri(authKeyUri);
		if (dupUser!=null){
			authKeyUri = baseUrl + Constants.AUTH_ID_FOLDER + "/" + Utils.generateRandomString(32);
			dupUser = null;
			dupUser = this.getUserByAuthKeyUri(authKeyUri);
			if (dupUser!=null){
				throw new RMapAuthException(ErrorCode.ER_PROBLEM_GENERATING_NEW_AUTHKEYURI.getMessage());
			}
		}
		user.setAuthKeyUri(authKeyUri);
		
		URI agentUri = null;
		try {
			agentUri = rmapIdService.createId();
		} catch (Exception e) {
			throw new RMapAuthException(ErrorCode.ER_PROBLEM_GENERATING_NEW_AGENTURI.getMessage(), e);
		}
		user.setRmapAgentUri(agentUri.toString());
		return userDao.addUser(user);
	}

	/**
	 * Only updates any changed settings from the GUI - i.e. name and email
	 * Protects the rest of the record from accidental corruption
	 * @param user
	 */
	public void updateUserSettings(User updatedUser) {
		final User user = getUserById(updatedUser.getUserId());
		user.setName(updatedUser.getName());
		user.setEmail(updatedUser.getEmail());
		user.setDoRMapAgentSync(updatedUser.isDoRMapAgentSync());
		user.setLastAccessedDate(new Date());
		userDao.updateUser(user);
	}
	
	/**
	 * Updates entire user record based on User object provided
	 * @param user
	 */
	public void updateUser(User user) {
		user.setLastAccessedDate(new Date());
		userDao.updateUser(user);		
	}
	
	/**
	 * Retrieves User object by searching using the userId provided
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId) {
        return userDao.getUserById(userId);
	}
	
	/**
	 * Retrieves User object by searching using the authKeyUri provided
	 * @param userId
	 * @return
	 */
	public User getUserByAuthKeyUri(String authKeyUri) {
        return userDao.getUserByAuthKeyUri(authKeyUri);
	}
	
	/**
	 * Retrieves User object by matching the idProvider name and idProviderAccountId provided
	 * @param userId
	 * @return
	 */	
	public User getUserByProviderAccount(String idProvider, String idProviderId) throws RMapAuthException{
		return userDao.getUserByProviderAccount(idProvider, idProviderId);
	}

	/**
	 * Retrieves User object by matching the API key and secret provided
	 * @param key
	 * @param secret
	 * @return
	 */	
	public User getUserByKeySecret(String key, String secret) throws RMapAuthException{
		return userDao.getUserByKeySecret(key, secret);
	}
	
	
}
