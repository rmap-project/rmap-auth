package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.UserIdentityProvider;

import java.util.List;
/**
 * Interface for accessing User table Data 
 * @author khanson
 *
 */
public interface UserIdProviderDao {
	/**
	 * Retrieve the UserIdentityProvider record based on the idProvider and provider account 
	 * @param idProviderUrl
	 * @param providerAccountPublicId
	 * @return
	 * @throws RMapAuthException
	 */
	public UserIdentityProvider getUserIdProvider(String idProviderUrl, String providerAccountPublicId) throws RMapAuthException;

	/**
	 * Create a new User IdProvider account record
	 * @param userIdProvider
	 * @return
	 * @throws RMapAuthException
	 */
	public int addUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException;
	
	/**
	 * Update User Id Provider account record
	 * @param userIdProvider
	 * @throws RMapAuthException
	 */
	public void updateUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException;
	
	/**
	 * Get a list of ID provider details associated with a User Id
	 * @param userId
	 * @return
	 * @throws RMapAuthException
	 */
	public List<UserIdentityProvider> getUserIdProviders(int userId) throws RMapAuthException;
}
