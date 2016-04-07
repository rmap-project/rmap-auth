package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;
import info.rmapproject.auth.model.User;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author khanson
 *
 */

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;
 	
	public int addUser(User user) throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User record saved successfully, User Details=" + user);	
        return user.getUserId();
	}

	public void updateUser(User user) throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User record updated successfully, User Details=" + user);
	}

	public User getUserById(int userId) throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();      
        User user = (User) session.load(User.class, userId);
        logger.info("User record loaded successfully, User details=" + user);
        return user;
	}
	
	@SuppressWarnings("unchecked")
	public User getUserByProviderAccount(String idProvider, String providerAccountId) throws RMapAuthException{
		Session session = this.sessionFactory.getCurrentSession();   
	    Query query = session.createSQLQuery("select Users.* from Users "
	        									+ "inner join UserIdentityProviders on UserIdentityProviders.userId = Users.userId "
	        									+ "where identityProvider=:idProvider and providerAccountId=:providerAccountId");
	    query.setParameter("idProvider",idProvider);
        query.setParameter("providerAccountId",providerAccountId);
    	
		List<User> users = query.list();
		if (users != null && !users.isEmpty()) {
	        logger.info("User list loaded successfully");
	        return users.get(0);
		}
		else {
			return null;
		}
	}

    @SuppressWarnings("unchecked")
	public User getUserByAuthKeyUri(String authKeyUri) throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();   
        Query query = session.createQuery("from User where authKeyUri=:authKeyUri");
        query.setParameter("authKeyUri",authKeyUri);
		List<User> users = query.list();
		if (users != null && !users.isEmpty()) {
	        logger.info("User loaded successfully");
			return users.get(0);
		}
		else	{
			return null;
		}
	}
    
    @SuppressWarnings("unchecked")
	public User getUserByKeySecret(String key, String secret) throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();   
        Query query = session.createQuery("from ApiKey where accessKey=:key and secret=:secret");
	    query.setParameter("key",key);
        query.setParameter("secret",secret);
        List<ApiKey> apiKeys = query.list();
        ApiKey apiKey = null;
		if (apiKeys != null && !apiKeys.isEmpty()) {
	        logger.info("Api key list loaded successfully");
			apiKey = apiKeys.get(0);
		}
		else	{
			return null;
		}		
		User user = null;
		if (apiKey!=null){
			int userId = apiKey.getUserId();
			user = this.getUserById(userId);
		}
		return user;		
	}
    
    
    
	
	
}
