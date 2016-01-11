package info.rmapproject.auth.service;

import info.rmapproject.auth.dao.AgentTypeDao;
import info.rmapproject.auth.model.AgentType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("agentTypeService")
@Transactional
public class AgentTypeServiceImpl implements AgentTypeService {
    
	//private static final Logger logger = LoggerFactory.getLogger(AgentTypeServiceImpl.class);

	@Autowired
	AgentTypeDao agentTypeDao;
	
	public List<AgentType> getAgentTypes() {
        return agentTypeDao.getAgentTypes();
	}
}
