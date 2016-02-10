package info.rmapproject.auth.service;

import info.rmapproject.auth.dao.UserIdProviderDao;
import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.UserIdentityProvider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author khanson
 *
 */

@Service("userIdProviderService")
@Transactional
public class UserIdProviderServiceImpl {

//private static final Logger logger = LoggerFactory.getLogger(UserIdProviderServiceImpl.class);
	
	@Autowired
	UserIdProviderDao userIdProviderDao; 	
	
	/**
	 * Creates a new user based on User object provided
	 * @param user
	 * @return
	 */
	public int addUserIdProvider(UserIdentityProvider userIdProvider) {
		return userIdProviderDao.addUserIdProvider(userIdProvider);
	}
	
	public UserIdentityProvider getUserIdProvider(String idProviderUrl, String providerAccountPublicId) 
			throws RMapAuthException{
		return userIdProviderDao.getUserIdProvider(idProviderUrl, providerAccountPublicId);
	}

	public void updateUserIdProvider(UserIdentityProvider userIdProvider) 
			throws RMapAuthException{
		userIdProviderDao.updateUserIdProvider(userIdProvider);
	}
	
	public List<UserIdentityProvider> getUserIdProviders(int userId) throws RMapAuthException{
		return userIdProviderDao.getUserIdProviders(userId);
	}
	
	
}
