package info.rmapproject.auth.dao;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;
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
	public User getUserByProviderAccount(String idProvider, String idProviderId) throws RMapAuthException;
	public User getUserByKeySecret(String key, String secret) throws RMapAuthException;
}
