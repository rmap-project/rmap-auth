package info.rmapproject.auth.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author khanson
 * Lookup table for agent types
 * 
 */

@Entity
@Table(name="AgentTypes")
public class AgentType {

	@Id	
	private String uri;
	private String label;
	

	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	
}
