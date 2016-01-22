package info.rmapproject.auth.service;

import info.rmapproject.auth.dao.UserDao;
import info.rmapproject.auth.exception.ErrorCode;
import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;
import info.rmapproject.auth.utils.Constants;
import info.rmapproject.auth.utils.Utils;

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
	
	public int addUser(User user) {
		//associate a keyuri that can be included in the event
		String authKeyUri = Constants.RMAP_BASE_URL + "authids/" + Utils.generateRandomString(32);
		User dupUser = this.getUserByAuthKeyUri(authKeyUri);
		if (dupUser!=null){
			authKeyUri = Constants.RMAP_BASE_URL + "authids/" + Utils.generateRandomString(32);
			dupUser = null;
			dupUser = this.getUserByAuthKeyUri(authKeyUri);
			if (dupUser!=null){
				throw new RMapAuthException(ErrorCode.ER_PROBLEM_GENERATING_NEW_APIKEY.getMessage());
			}
		}
		user.setAuthKeyUri(authKeyUri);
		return userDao.addUser(user);
	}

	//user settings are what is available through web form
	public void updateUserSettings(User updatedUser) {
		final User user = getUserById(updatedUser.getUserId());
		user.setName(updatedUser.getName());
		user.setEmail(updatedUser.getEmail());
		user.setDoRMapAgentSync(updatedUser.isDoRMapAgentSync());
		user.setLastAccessedDate(new Date());
		userDao.updateUser(user);
	}
	
	//update whole user record
	public void updateUser(User user) {
		user.setLastAccessedDate(new Date());
		userDao.updateUser(user);		
	}

	public User getUserById(int userId) {
        return userDao.getUserById(userId);
	}

	public User getUserByAuthKeyUri(String authKeyUri) {
        return userDao.getUserByAuthKeyUri(authKeyUri);
	}
	
	
}
