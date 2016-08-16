package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.UserIdentityProvider;

import java.util.List;

/**
 * Interface for accessing User table Data .
 *
 * @author khanson
 */
public interface UserIdProviderDao {
	
	/**
	 * Retrieve the UserIdentityProvider record based on the idProvider and provider account .
	 *
	 * @param idProviderUrl the id provider URL
	 * @param providerAccountPublicId the provider account's public ID
	 * @return the user's id provider record
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public UserIdentityProvider getUserIdProvider(String idProviderUrl, String providerAccountPublicId) throws RMapAuthException;

	/**
	 * Create a new User IdProvider account record.
	 *
	 * @param userIdProvider the user id provider
	 * @return the user ID Provider record ID
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public int addUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException;
	
	/**
	 * Update User Id Provider account record.
	 *
	 * @param userIdProvider the user id provider
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public void updateUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException;
	
	/**
	 * Get a list of ID provider details associated with a User Id.
	 *
	 * @param userId the user id
	 * @return the user's id providers
	 * @throws RMapAuthException the RMap Auth exception
	 */
	public List<UserIdentityProvider> getUserIdProviders(int userId) throws RMapAuthException;
}
