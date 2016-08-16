package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;

/**
 * Interface for accessing User table Data .
 *
 * @author khanson
 */
public interface UserDao {
	
	/**
	 * Create new RMap User account in database.
	 *
	 * @param user the User
	 * @return the User ID
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public int addUser(User user) throws RMapAuthException;
	
	/**
	 * Update existing User account in database.
	 *
	 * @param user the user
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public void updateUser(User user) throws RMapAuthException;
	
	/**
	 * Retrieve a user based on userId provided.
	 *
	 * @param userId the user id
	 * @return the User
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public User getUserById(int userId) throws RMapAuthException;
	
	/**
	 * Retrieve a user based on the auth key URI.
	 *
	 * @param authKeyUri the auth key URI
	 * @return the User
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public User getUserByAuthKeyUri(String authKeyUri) throws RMapAuthException;	
	
	/**
	 * Retrieve a user based on the id provider and id provider account id passed in.
	 *
	 * @param idProvider the id provider
	 * @param idProviderId the id provider id
	 * @return the User
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public User getUserByProviderAccount(String idProvider, String idProviderId) throws RMapAuthException;
	
	/**
	 * Retrieve a user based on the key/secret combination provided.
	 *
	 * @param key the key
	 * @param secret the secret
	 * @return the User
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public User getUserByKeySecret(String key, String secret) throws RMapAuthException;
}
