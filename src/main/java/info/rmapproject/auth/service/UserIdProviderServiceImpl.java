package info.rmapproject.auth.service;

import info.rmapproject.auth.dao.UserIdProviderDao;
import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.UserIdentityProvider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for access to UserIdProvider related methods.
 *
 * @author khanson
 */

@Service("userIdProviderService")
@Transactional
public class UserIdProviderServiceImpl {

//private static final Logger logger = LoggerFactory.getLogger(UserIdProviderServiceImpl.class);
	
	/** UserIdProvider table data access component. */
	@Autowired
	UserIdProviderDao userIdProviderDao; 	
	
	/**
	 * Creates a new identity provider profile for a specific user.
	 *
	 * @param userIdProvider the user id provider
	 * @return the user ID provider record ID
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public int addUserIdProvider(UserIdentityProvider userIdProvider) {
		return userIdProviderDao.addUserIdProvider(userIdProvider);
	}
	
	/**
	 * Retrieve a the UserIdentityProvider fora given provider name and id - this is an object
	 * containing details of the user profile on specific id provider.
	 *
	 * @param idProviderUrl the id provider url
	 * @param providerAccountId the provider account id
	 * @return the user id provider
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public UserIdentityProvider getUserIdProvider(String idProviderUrl, String providerAccountId) 
			throws RMapAuthException{
		return userIdProviderDao.getUserIdProvider(idProviderUrl, providerAccountId);
	}

	/**
	 * Updates an existing identity provider profile for a specific user.
	 *
	 * @param userIdProvider the user id provider
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public void updateUserIdProvider(UserIdentityProvider userIdProvider) 
			throws RMapAuthException{
		userIdProviderDao.updateUserIdProvider(userIdProvider);
	}
	
	/**
	 * Retrieves list of Identity Provider account records for user.
	 *
	 * @param userId the user id
	 * @return the user id providers
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public List<UserIdentityProvider> getUserIdProviders(int userId) throws RMapAuthException{
		return userIdProviderDao.getUserIdProviders(userId);
	}
	
	
}
