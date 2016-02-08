package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;
import info.rmapproject.auth.model.UserIdentityProvider;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author khanson
 *
 */

@Repository("userIdProviderDao")
public class UserIdProviderDaoImpl implements UserIdProviderDao {

	//private static final Logger logger = LoggerFactory.getLogger(UserIdProviderDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public int addUserIdProvider(UserIdentityProvider userIdProvider)
			throws RMapAuthException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateUserIdProvider(UserIdentityProvider userIdProvider)
			throws RMapAuthException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserIdProviderById(int userIdProvider)
			throws RMapAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserIdentityProvider> getUserByAuthKeyUri(String authKeyUri)
			throws RMapAuthException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByProviderAccount(String idProvider, String idProviderId)
			throws RMapAuthException {
		// TODO Auto-generated method stub
		return null;
	}
 		

	    
	
	
}
