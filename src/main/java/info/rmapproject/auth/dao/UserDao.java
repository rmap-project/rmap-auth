package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;
/**
 * Interface for accessing User table Data 
 * @author khanson
 *
 */
public interface UserDao {
	/**
	 * Create new RMap User account in database
	 * @param user
	 * @return
	 * @throws RMapAuthException
	 */
	public int addUser(User user) throws RMapAuthException;
	
	/**
	 * Update existing User account in database
	 * @param user
	 * @throws RMapAuthException
	 */
	public void updateUser(User user) throws RMapAuthException;
	
	/**
	 * Retrieve a user based on userId provided
	 * @param userId
	 * @return
	 * @throws RMapAuthException
	 */
	public User getUserById(int userId) throws RMapAuthException;
	
	/**
	 * Retrieve a user based on the auth key URI
	 * @param authKeyUri
	 * @return
	 * @throws RMapAuthException
	 */
	public User getUserByAuthKeyUri(String authKeyUri) throws RMapAuthException;	
	
	/**
	 * Retrieve a user based on the id provider and id provider account id passed in
	 * @param idProvider
	 * @param idProviderId
	 * @return
	 * @throws RMapAuthException
	 */
	public User getUserByProviderAccount(String idProvider, String idProviderId) throws RMapAuthException;
	
	/**
	 * Retrieve a user based on the key/secret combination provided
	 * @param key
	 * @param secret
	 * @return
	 * @throws RMapAuthException
	 */
	public User getUserByKeySecret(String key, String secret) throws RMapAuthException;
}
