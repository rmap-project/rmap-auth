package info.rmapproject.auth.service;

import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;
import info.rmapproject.core.model.event.RMapEvent;
/**
 * 
 * @author khanson
 *
 */
public interface UserRMapAgentService {
	public RMapEvent createOrUpdateAgentFromUser(User user) throws RMapAuthException;
}