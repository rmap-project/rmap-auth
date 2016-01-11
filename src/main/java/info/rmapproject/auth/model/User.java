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
 * 
 * @author khanson
 *
 */
@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;

	@NotEmpty(message="Name cannot be empty")
	private String name;

	@NotEmpty(message="Email cannot be empty")
	@Email(message="Invalid email")
	private String email;
	private Boolean isActive = true;
	private Boolean hasRMapAgent = false;
	private String rmapAgentUri = null;	
	private String authKeyUri = null;
	private Date createdDate = new Date();
	private Date lastAccessedDate = new Date();
	private Date cancellationDate = new Date();
	private String primaryIdProvider = null;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private Set<UserAgentUri> userAgentUris = new HashSet<UserAgentUri>();

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "userId")  
	private Set<UserAgentType> userAgentTypes = new HashSet<UserAgentType>();  
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private Set<UserIdentityProvider> userIdentityProviders = new HashSet<UserIdentityProvider>();

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private Set<ApiKey> apiKeys = new HashSet<ApiKey>();

	
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
	public Boolean getHasRMapAgent() {
		return hasRMapAgent;
	}
	public void setHasRMapAgent(Boolean hasRMapAgent) {
		this.hasRMapAgent = hasRMapAgent;
	}
	public String getRmapAgentUri() {
		return rmapAgentUri;
	}
	public void setRmapAgentUri(String rmapAgentUri) {
		this.rmapAgentUri = rmapAgentUri;
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

    public Set<UserAgentUri> getUserAgentUris() {
		return userAgentUris;
	}
    
	public void setUserAgentUris(Set<UserAgentUri> userAgentUris) {
		this.userAgentUris = userAgentUris;
	}
	
	public Set<UserAgentType> getUserAgentTypes() {
		return userAgentTypes;
	}
	
	public void setUserAgentTypes(Set<UserAgentType> userAgentTypes) {
		this.userAgentTypes = userAgentTypes;
	}
	
	public Set<UserIdentityProvider> getUserIdentityProviders() {
		return userIdentityProviders;
	}
	
	public void setUserIdentityProviders(
			Set<UserIdentityProvider> userIdentityProviders) {
		this.userIdentityProviders = userIdentityProviders;
	}
	
	public String getPrimaryIdProvider() {
		return primaryIdProvider;
	}
	public void setPrimaryIdProvider(String primaryIdProvider) {
		this.primaryIdProvider = primaryIdProvider;
	}

	
	/*
	public Set<ApiKey> getApiKeys() {
		return apiKeys;
	}
	
	public void setApiKeys(Set<ApiKey> apiKeys) {
		this.apiKeys = apiKeys;
	}*/
	
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