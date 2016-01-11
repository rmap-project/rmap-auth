package info.rmapproject.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserAgentUris")
public class UserAgentUri {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userAgentUriId;
	private String uri;
	private int userId;
	
	public int getUserAgentUriId() {
		return userAgentUriId;
	}
	public void setUserAgentUriId(int userAgentUriId) {
		this.userAgentUriId = userAgentUriId;
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
