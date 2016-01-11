package info.rmapproject.auth.service;

import info.rmapproject.auth.dao.UserDao;
import info.rmapproject.auth.model.User;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author khanson
 *
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

//private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDao userDao; 	
	
	public void addUser(User user) {
		userDao.addUser(user);
	}

	//user settings are what is available through web form
	public void updateUserSettings(User updatedUser) {
		final User user = getUserById(updatedUser.getUserId());
		user.setName(updatedUser.getName());
		user.setEmail(updatedUser.getEmail());
		user.setUserAgentTypes(updatedUser.getUserAgentTypes());
		user.setUserAgentUris(updatedUser.getUserAgentUris());
		user.setLastAccessedDate(new Date());
		userDao.updateUser(user);
	}

	public User getUserById(int userId) {
        return userDao.getUserById(userId);
	}
	
}
