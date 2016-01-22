package info.rmapproject.auth.service;

import info.rmapproject.auth.exception.ErrorCode;
import info.rmapproject.auth.exception.RMapAuthException;
import info.rmapproject.auth.model.User;
import info.rmapproject.core.exception.RMapDefectiveArgumentException;
import info.rmapproject.core.exception.RMapException;
import info.rmapproject.core.model.agent.RMapAgent;
import info.rmapproject.core.model.event.RMapEvent;
import info.rmapproject.core.rmapservice.RMapService;
import info.rmapproject.core.rmapservice.RMapServiceFactoryIOC;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author khanson
 *
 */

@Service("rMapAgentService")
public class UserRMapAgentServiceImpl implements UserRMapAgentService {

	//private static final Logger logger = LoggerFactory.getLogger(ApiKeyServiceImpl.class);
	@Autowired
	UserService userService;
	
	public RMapEvent createOrUpdateAgentFromUser(User user) throws RMapAuthException {
		
		RMapService rmapService = null;
		RMapEvent event = null;

		if (user==null){
			throw new RMapAuthException(ErrorCode.ER_NULL_USER_PROVIDED.getMessage());
		}

		if (!user.isDoRMapAgentSync()){
			throw new RMapAuthException(ErrorCode.ER_AGENT_SYNC_NOT_CONFIGURED.getMessage());
		}
		
		//we have a user and we are permitted to synchronize the user in rmap... proceed...
		try {

			rmapService = RMapServiceFactoryIOC.getFactory().createService();

			String sAgentId = user.getRmapAgentUri();	
			URI uAgentId = null;	
			
			//is there already an RMapAgent for this user?
			if (user.hasRMapAgent()){
				//there is an agent id already, let's use that
				uAgentId = new URI(sAgentId);
			}
		
			//get other properties we need to create/update the agent
			String agentAuthId = user.getAuthKeyUri();
			String primaryIdProvider = user.getPrimaryIdProvider();
			String name = user.getName();
			
			//check the required properties are populated
			if (agentAuthId==null || agentAuthId.length()==0
					|| primaryIdProvider==null || primaryIdProvider.length()==0){
				throw new RMapAuthException(ErrorCode.ER_USER_AGENT_NOT_FORMED_IN_DB.getMessage());
			}	
			
			//if agent isn't in the triplestore, create it!  otherwise, update it
			if (uAgentId==null) { 
				//no id - create agent
				event = rmapService.createAgent(name, new URI(primaryIdProvider), new URI(agentAuthId));	
			}
			else if (!rmapService.isAgentId(uAgentId)){
				//id generated but no record created yet - create agent
				event = rmapService.createAgent(uAgentId, name, new URI(primaryIdProvider), new URI(agentAuthId), uAgentId);
			}
			else if (rmapService.isAgentId(uAgentId)){ 
				//rmap agent exists - but has there been a change?
				RMapAgent origAgent = rmapService.readAgent(uAgentId);
				String oAuthId = origAgent.getAuthId().toString();
				String oName = origAgent.getName().toString();
				String oIdProvider = origAgent.getIdProvider().toString();
				if (!oAuthId.equals(user.getAuthKeyUri()) 
					|| !oName.equals(user.getName())
					|| !oIdProvider.equals(user.getPrimaryIdProvider())){
					
					//something has changed, do update
					event = rmapService.updateAgent(uAgentId, name, new URI(primaryIdProvider), new URI(agentAuthId), uAgentId);					
				}

			}

			user.setRmapAgentUri(uAgentId.toString());
			userService.updateUser(user);
			
		} catch (URISyntaxException uriEx) {
			throw new RMapAuthException(ErrorCode.ER_USER_AGENT_NOT_FORMED_IN_DB.getMessage(),uriEx.getCause());
		} catch (RMapException | RMapDefectiveArgumentException ex) {
			throw new RMapAuthException(ErrorCode.ER_USER_AGENT_NOT_FORMED_IN_DB.getMessage(),ex.getCause());
		} finally {
			if (rmapService!=null){
				rmapService.closeConnection();
			}
		}
		
		return event;
		
	}
	
	

}
