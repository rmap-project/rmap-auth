package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.ApiKey;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementation of ApiKeyDao used to interact with data in the ApiKey table
 * @author khanson
 *
 */

@Repository("apiKeyDao")
public class ApiKeyDaoImpl implements ApiKeyDao {

	private static final Logger logger = LoggerFactory.getLogger(ApiKeyDaoImpl.class);

	/**
	 * Data base session factory instance
	 */
    @Autowired
    private SessionFactory sessionFactory;
 	
	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.ApiKeyDao#addApiKey(ApiKey)
	 */
    @Override
	public int addApiKey(ApiKey apiKey) throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(apiKey);
        logger.info("API key saved successfully, API key=" + apiKey);	
        return apiKey.getApiKeyId();
	}
    
	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.ApiKeyDao#updateApiKey(ApiKey)
	 */
    @Override
	public void updateApiKey(ApiKey apiKey) throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(apiKey);
        logger.info("API key updated successfully, API Key=" + apiKey);
	}

	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.ApiKeyDao#getApiKeyById(int)
	 */
    @Override
	public ApiKey getApiKeyById(int apiKeyId) throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();      
        ApiKey apiKey = (ApiKey) session.load(ApiKey.class, apiKeyId);
        logger.info("User record loaded successfully, User details=" + apiKey);
        return apiKey;
	}


	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.ApiKeyDao#getApiKeyByKeySecret(String,String)
	 */
    @Override    
    @SuppressWarnings("unchecked")
	public ApiKey getApiKeyByKeySecret(String accessKey, String secret) throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();   
        Query query = session.createQuery("from ApiKey where accessKey=:accessKey and secret=:secret");
        query.setParameter("accessKey",accessKey);
        query.setParameter("secret",secret);
		List<ApiKey> apiKeys = query.list();
		if (apiKeys != null && !apiKeys.isEmpty()) {
	        logger.info("Api key list loaded successfully");
			return apiKeys.get(0);
		}
		else	{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.ApiKeyDao#getApiKeyByKeySecret(String)
	 */
    @Override    
    @SuppressWarnings("unchecked")
	public ApiKey getApiKeyByKeyUri(String keyUri) throws RMapAuthException {
        Session session = this.sessionFactory.getCurrentSession();   
        Query query = session.createQuery("from ApiKey where keyUri=:keyUri");
        query.setParameter("keyUri",keyUri);
		List<ApiKey> apiKeys = query.list();
		if (apiKeys != null && !apiKeys.isEmpty()) {
	        logger.info("Api key list loaded successfully");
			return apiKeys.get(0);
		}
		else	{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.ApiKeyDao#getAgentUriByKeySecret(String,String)
	 */
    @Override  
    @SuppressWarnings("unchecked")
	public URI getAgentUriByKeySecret(String accessKey, String secret) throws RMapAuthException {
    	URI agentUri = null;
        Session session = this.sessionFactory.getCurrentSession();   
        Query query = session.createSQLQuery("select distinct rmapAgentUri from ApiKeys "
        									+ "inner join Users on ApiKeys.userId = Users.userId "
        									+ "where accessKey=:accessKey and secret=:secret");
        query.setParameter("accessKey",accessKey);
        query.setParameter("secret",secret);
		List<String> rmapAgentUris = query.list();
		if (rmapAgentUris != null && !rmapAgentUris.isEmpty()) {
	        logger.info("User list loaded successfully");
	        String agentId = rmapAgentUris.get(0);
        	try {
				agentUri = new URI(agentId);
			} catch (URISyntaxException ex) {
				throw new RMapAuthException(ex);
			}
		}
		return agentUri;
		
	}
    
	/* (non-Javadoc)
	 * @see info.rmapproject.auth.dao.ApiKeyDao#listApiKeyByUser(int)
	 */
    @Override 
    @SuppressWarnings("unchecked")
	public List<ApiKey> listApiKeyByUser(int userId) {
        Session session = this.sessionFactory.getCurrentSession();   
        Query query = session.createQuery("from ApiKey where userId=:userId");
        query.setParameter("userId",userId);
		List <ApiKey> apiKeys = query.list();
        logger.info("Api key list loaded successfully");
        return apiKeys;
	}

}
