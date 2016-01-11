package info.rmapproject.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserAgentTypes")
public class UserAgentType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userAgentTypeId;
	private String uri;
	private int userId;
	
	public int getUserAgentTypeId() {
		return userAgentTypeId;
	}
	public void setUserAgentTypeId(int userAgentTypeId) {
		this.userAgentTypeId = userAgentTypeId;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
}
