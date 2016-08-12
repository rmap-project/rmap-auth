package info.rmapproject.auth.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Java representation of Users database table.
 * Captures details of a user that has signed in through the GUI
 * This tables stores relevant user information
 * @author khanson
 *
 */
@Entity
@Table(name="Users")
public class User {
	/**Primary key for Users database, incrementing integer*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	/**Name of user**/
	@NotEmpty(message="Name cannot be empty")
	private String name;

	/**User email**/
	@NotEmpty(message="Email cannot be empty")
	@Email(message="Invalid email")
	private String email;
	
	/**Determines whether user is active or not*/
	private Boolean isActive = true;
	
	/**Unique URI representing Agent - generated from RMap Core ID creator*/
	private String rmapAgentUri = null;	
	
	/**URI of a DiSCO associate directly with the Agent. Not implemented yet, but
	 * eventually will be able to generate a DiSCO about the Agent through the GUI*/
	private String rmapDiSCOUri = null;	
	
	/**Unique URI representing the auth key, generated from RMap Core ID generator.*/
	private String authKeyUri = null;
	
	/**Date user record created**/
	private Date createdDate = new Date();
	
	/**Date user last accessed the the database**/
	private Date lastAccessedDate = new Date();
	
	/**Date the user cancelled account*/
	private Date cancellationDate = null;
	private boolean doRMapAgentSync = false;
	
	/**List of ID provider records corresponding to the user.*/
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private Set<UserIdentityProvider> userIdentityProviders = new HashSet<UserIdentityProvider>();

	/**List of API Keys corresponding to the User**/
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private Set<ApiKey> apiKeys = new HashSet<ApiKey>();
	
	public User(){}
	
	public User (String name, String email){
		this.setName(name);	
		this.setEmail(email);	
	}
	
	public User (String name) {
		this.setName(name);
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getRmapAgentUri() {
		return rmapAgentUri;
	}
	public void setRmapAgentUri(String rmapAgentUri) {
		this.rmapAgentUri = rmapAgentUri;
	}
	public String getRmapDiSCOUri() {
		return rmapDiSCOUri;
	}
	public void setRmapDiSCOUri(String rmapDiSCOUri) {
		this.rmapDiSCOUri = rmapDiSCOUri;
	}
	public String getAuthKeyUri() {
		return authKeyUri;
	}
	public void setAuthKeyUri(String authKeyUri) {
		this.authKeyUri = authKeyUri;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastAccessedDate() {
		return lastAccessedDate;
	}
	public void setLastAccessedDate(Date lastAccessedDate) {
		this.lastAccessedDate = lastAccessedDate;
	}
	public Date getCancellationDate() {
		return cancellationDate;
	}
	public void setCancellationDate(Date cancellationDate) {
		this.cancellationDate = cancellationDate;
	}
	
	public Set<UserIdentityProvider> getUserIdentityProviders() {
		return userIdentityProviders;
	}
	
	public void setUserIdentityProviders(
			Set<UserIdentityProvider> userIdentityProviders) {
		this.userIdentityProviders = userIdentityProviders;
	}

	public boolean isDoRMapAgentSync() {
		return doRMapAgentSync;
	}
	public void setDoRMapAgentSync(boolean doRMapAgentSync) {
		this.doRMapAgentSync = doRMapAgentSync;
	}

	public Boolean hasRMapAgent() {
		return (this.rmapAgentUri!=null&&this.rmapAgentUri.length()>0);
	}	

	public Boolean hasRMapDiSCO() {
		return (this.rmapDiSCOUri!=null&&this.rmapDiSCOUri.length()>0);
	}	
	
	@Override
    public int hashCode() {
		 return this.name.hashCode() + this.email.hashCode();  
    }
 
    @Override
    public boolean equals(Object obj) {
    	  if (obj instanceof User) {  
    		   User user = (User) obj;      		  
    		   if (this.email.equals(user.getEmail())  
    		     && this.name.equals(user.getName()) )  
    		    return true;  
    	  }
    	  return false;
    	
    }
 
	@Override
    public String toString() {
		return "id=" + userId + ", name=" + name + ", email=" + email + ";";
    }
	
}
