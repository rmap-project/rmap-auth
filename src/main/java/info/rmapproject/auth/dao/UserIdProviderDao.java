package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;
import info.rmapproject.auth.model.UserIdentityProvider;

import java.util.List;
/**
 * 
 * @author khanson
 *
 */
public interface UserIdProviderDao {
	public int addUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException;
	public void updateUserIdProvider(UserIdentityProvider userIdProvider) throws RMapAuthException;
	public User getUserIdProviderById(int userIdProvider) throws RMapAuthException;
	public List<UserIdentityProvider> getUserByAuthKeyUri(String authKeyUri) throws RMapAuthException;	
	public User getUserByProviderAccount(String idProvider, String idProviderId) throws RMapAuthException;
}
