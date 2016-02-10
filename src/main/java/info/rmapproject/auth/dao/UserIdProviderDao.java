package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.UserIdentityProvider;

import java.util.List;
/**
 * 
 * @author khanson
 *
 */
public interface UserIdProviderDao {
	public UserIdentityProvider getUserIdProvider(String idProviderUrl, String providerAccountPublicId) throws RMapAuthException;
	public int addUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException;
	public void updateUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException;
	public List<UserIdentityProvider> getUserIdProviders(int userId) throws RMapAuthException;
}
