package info.rmapproject.auth.service;

import info.rmapproject.auth.model.User;
/**
 * 
 * @author khanson
 *
 */
public interface UserService {
	public int addUser(User user);
	public void updateUserSettings(User user);
	public User getUserById(int userId);
}
