package info.rmapproject.auth.dao;

import info.rmapproject.auth.model.AgentType;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("agentTypeDao")
public class AgentTypeDaoImpl implements AgentTypeDao {

	private static final Logger logger = LoggerFactory.getLogger(AgentTypeDaoImpl.class);

	@Autowired
    private SessionFactory sessionFactory;
    
    @SuppressWarnings("unchecked")
	public List<AgentType> getAgentTypes() {
        Session session = this.sessionFactory.getCurrentSession();   
        List <AgentType> agentTypes = session.createCriteria(AgentType.class).list();
        logger.info("Key status list loaded successfully");
        return agentTypes;
	}
}
