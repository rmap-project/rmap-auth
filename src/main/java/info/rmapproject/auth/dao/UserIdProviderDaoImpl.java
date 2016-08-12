package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.UserIdentityProvider;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementation of UserIdProviderDao used to interact with data in the UserIdProvider table
 * @author khanson
 *
 */

@Repository("userIdProviderDao")
public class UserIdProviderDaoImpl implements UserIdProviderDao {

	private static final Logger logger = LoggerFactory.getLogger(UserIdProviderDaoImpl.class);

	/**
	 * Data base session factory instance
	 */
    @Autowired
    private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.UserIdProviderDao#addUserIdProvider(UserIdentityProvider)
	 */
    @Override
	public int addUserIdProvider(UserIdentityProvider userIdProvider)
			throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(userIdProvider);
        logger.info("User ID Provider record saved successfully. Details=" + userIdProvider);	
        return userIdProvider.getUserIdentityProviderId();
	}

	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.UserIdProviderDao#updateUserIdProvider(UserIdentityProvider)
	 */
    @Override
	public void updateUserIdProvider(UserIdentityProvider userIdProvider)
			throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(userIdProvider);
        logger.info("User record updated successfully, Details=" + userIdProvider);		
	}
    
	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.UserIdProviderDao#getUserIdProvider(String,String)
	 */
    @Override
	@SuppressWarnings("unchecked")
	public UserIdentityProvider getUserIdProvider(String idProviderUrl, String providerAccountId) 
			throws RMapAuthException{
        Session session = this.sessionFactory.getCurrentSession();   
        Query query = session.createQuery("from UserIdentityProvider "
        								+ "	where identityProvider=:providerUrl "
        								+ " and providerAccountId=:accountId");
        query.setParameter("providerUrl",idProviderUrl);
        query.setParameter("accountId",providerAccountId);
		List<UserIdentityProvider> userIdProvider = query.list();
		if (userIdProvider != null && !userIdProvider.isEmpty()) {
	        logger.info("User Identity Provider loaded successfully");
			return userIdProvider.get(0);
		}
		else	{
			return null;
		}
		
	}
    
	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.UserIdProviderDao#getUserIdProviders(int)
	 */
    @Override
	@SuppressWarnings("unchecked")
	public List<UserIdentityProvider> getUserIdProviders(int userId) throws RMapAuthException {
		Session session = this.sessionFactory.getCurrentSession();   
        Query query = session.createQuery("from UserIdentityProvider where userId=:userId");
        query.setParameter("userId",userId);
		List <UserIdentityProvider> userIdProviders = query.list();
        logger.info("User identity provider list loaded successfully");
        return userIdProviders;
	}
	
	
}
