package info.rmapproject.auth.service;

import info.rmapproject.auth.model.User;
/**
 * Service method for User data.
 * @author khanson
 *
 */
public interface UserService {
	/**
	 * Creates a new user based User object provided
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * Updates entire user record based on User object provided
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * Only updates any changed settings from the GUI - i.e. name and email
	 * Protects the rest of the record from accidental corruption
	 * @param user
	 */
	public void updateUserSettings(User user);
	
	/**
	 * Retrieves User object by searching using the userId provided
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId);
	
	/**
	 * Retrieves User object by searching using the authKeyUri provided
	 * @param userId
	 * @return
	 */
	public User getUserByAuthKeyUri(String authKeyUri);

}
