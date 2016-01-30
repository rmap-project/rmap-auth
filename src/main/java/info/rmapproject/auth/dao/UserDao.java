package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;
import info.rmapproject.auth.oauth.OAuthProviderAccount;
/**
 * 
 * @author khanson
 *
 */
public interface UserDao {
	public int addUser(User user) throws RMapAuthException;
	public void updateUser(User user) throws RMapAuthException;
	public User getUserById(int userId) throws RMapAuthException;
	public User getUserByAuthKeyUri(String authKeyUri) throws RMapAuthException;	
	public User getUserByProviderAccount(OAuthProviderAccount account) throws RMapAuthException;
}
