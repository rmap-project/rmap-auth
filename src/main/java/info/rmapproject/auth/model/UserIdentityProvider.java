package info.rmapproject.auth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Java representation of UserIdentityProviders database table.
 * Stores details of ID provider accounts for User
 * @author khanson
 *
 */

@Entity
@Table(name="UserIdentityProviders")
public class UserIdentityProvider {
	
	/**Primary key for UserIdentityProviders table, incrementing integer*/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userIdentityProviderId;
	
	/**Name of identityProvider as a URL e.g. http://www.google.com*/
	private String identityProvider;
	
	/**Account ID for user's id provider account*/
	private String providerAccountId;
	
	/**Public account ID for user's id provider account e.g. gmail address, twitter handle, orcid id*/
	private String providerAccountPublicId;
	
	/**Display name for user's id provider account e.g. Karen Hanson*/
	private String providerAccountDisplayName;
	
	/**URL for user's id provider account e.g. google plus profile, twitter page.*/
	private String providerAccountProfileUrl;
	
	/**Date the user was last authenicated i.e. logged in*/
	private Date lastAuthenticatedDate;
	
	/**Date id provider account record created**/
	private Date createdDate;
	
	/**Users.userId associated with account*/
	private int userId;
		
	public int getUserIdentityProviderId() {
		return userIdentityProviderId;
	}
	public void setUserIdentityProviderId(int userIdentityProviderId) {
		this.userIdentityProviderId = userIdentityProviderId;
	}
	public String getIdentityProvider() {
		return identityProvider;
	}
	public void setIdentityProviderId(String identityProvider) {
		this.identityProvider = identityProvider;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getProviderAccountId() {
		return providerAccountId;
	}
	public void setProviderAccountId(String providerAccountId) {
		this.providerAccountId = providerAccountId;
	}
	public String getProviderAccountPublicId() {
		return providerAccountPublicId;
	}
	public void setProviderAccountPublicId(String providerAccountPublicId) {
		this.providerAccountPublicId = providerAccountPublicId;
	}
	public String getProviderAccountDisplayName() {
		return providerAccountDisplayName;
	}
	public void setProviderAccountDisplayName(String providerAccountDisplayName) {
		this.providerAccountDisplayName = providerAccountDisplayName;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastAuthenticatedDate() {
		return lastAuthenticatedDate;
	}
	public void setLastAuthenticatedDate(Date lastAuthenticatedDate) {
		this.lastAuthenticatedDate = lastAuthenticatedDate;
	}
	public String getProviderAccountProfileUrl() {
		return providerAccountProfileUrl;
	}
	public void setProviderAccountProfileUrl(String providerAccountProfileUrl) {
		this.providerAccountProfileUrl = providerAccountProfileUrl;
	}
	
}
