/*******************************************************************************
 * Copyright 2016 Johns Hopkins University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This software was produced as part of the RMap Project (http://rmap-project.info),
 * The RMap Project was funded by the Alfred P. Sloan Foundation and is a 
 * collaboration between Data Conservancy, Portico, and IEEE.
 *******************************************************************************/
package info.rmapproject.auth.service;

import info.rmapproject.auth.dao.UserDao;
import info.rmapproject.auth.exception.ErrorCode;
import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;
import info.rmapproject.auth.model.UserIdentityProvider;
import info.rmapproject.auth.utils.Constants;
import info.rmapproject.auth.utils.Sha256HashGenerator;
import info.rmapproject.core.idservice.IdService;
import info.rmapproject.core.utils.ConfigUtils;

import java.net.URI;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for access to Users related methods.
 *
 * @author khanson
 */

@Service("userService")
@Transactional
public class UserServiceImpl {

//private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	/** RMap core Id Generator Service. */
	@Autowired 
	IdService rmapIdService;

	/** Users table data access component. */
	@Autowired
	UserDao userDao; 	
	
	/**
	 * Create a new user.
	 *
	 * @param user the User
	 * @return the User record ID
	 */
	public int addUser(User user) {
		
		String authKeyUri = generateAuthKey(user);
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
	 *  
	 * Generate an authentication key for the user. This uses the idprovider name combined with
	 * the user's idP identifier to generate a sha256 hash string that forms the authentication key.
	 * Given these two pieces of information a 3rd party user can verify someone is who they say they are
	 *
	 * @param user the User
	 * @return the User Auth Key
	 */
	public String generateAuthKey(User user){
		try {
			Set<UserIdentityProvider> idps = user.getUserIdentityProviders();
			
			UserIdentityProvider idp = idps.iterator().next();	
			
			String idpName=idp.getIdentityProvider();
			String idpAccountId=idp.getProviderAccountId();
			String sha256IdHash = Sha256HashGenerator.getSha256Hash(idpName + idpAccountId);
				
			String baseUrl = ConfigUtils.getPropertyValue(Constants.RMAP_AUTH_PROPFILE, Constants.RMAP_BASE_URL_KEY);
			String authKeyUri = baseUrl + Constants.AUTH_ID_FOLDER + "/" + sha256IdHash;
					
			User dupUser = getUserByAuthKeyUri(authKeyUri);
			if (dupUser!=null){
				throw new RMapAuthException(ErrorCode.ER_PROBLEM_GENERATING_NEW_AUTHKEYURI.getMessage());				
			}			
			return authKeyUri;
		} catch (Exception ex){
			throw new RMapAuthException(ErrorCode.ER_PROBLEM_GENERATING_NEW_AUTHKEYURI.getMessage(), ex);
		}
	}

	/**
	 * Only updates any changed settings from the GUI - i.e. name and email
	 * Protects the rest of the record from accidental corruption
	 *
	 * @param updatedUser the User
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
	 * Updates entire user record based on User object provided.
	 *
	 * @param user the User
	 */
	public void updateUser(User user) {
		user.setLastAccessedDate(new Date());
		userDao.updateUser(user);		
	}
	
	/**
	 * Retrieve a user matching the userId provided.
	 *
	 * @param userId the user id
	 * @return the User
	 */
	public User getUserById(int userId) {
        return userDao.getUserById(userId);
	}
	
	/**
	 * Retrieves User object by searching using the authKeyUri provided.
	 *
	 * @param authKeyUri the auth key URI
	 * @return the user
	 */
	public User getUserByAuthKeyUri(String authKeyUri) {
        return userDao.getUserByAuthKeyUri(authKeyUri);
	}

	/**
	 * Retrieve the user that matches a specific id provider account.
	 *
	 * @param idProvider the id provider
	 * @param idProviderId the id provider id
	 * @return the user by provider account
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public User getUserByProviderAccount(String idProvider, String idProviderId) throws RMapAuthException{
		return userDao.getUserByProviderAccount(idProvider, idProviderId);
	}


	/**
	 * Retrieve the user that matches the key/secret combination provided.
	 *
	 * @param key the key
	 * @param secret the secret
	 * @return the User
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public User getUserByKeySecret(String key, String secret) throws RMapAuthException{
		return userDao.getUserByKeySecret(key, secret);
	}
	
	
}
