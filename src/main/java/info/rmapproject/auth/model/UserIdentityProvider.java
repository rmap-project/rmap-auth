package info.rmapproject.auth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author khanson
 *
 */

@Entity
@Table(name="UserIdentityProviders")
public class UserIdentityProvider {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userIdentityProviderId;
	private String identityProvider;
	private String providerAccountInternalId;
	private String providerAccountPublicId;
	private String providerAccountDisplayName;
	private Date lastAuthenticatedDate;
	private Date createdDate;
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
	public String getProviderAccountInternalId() {
		return providerAccountInternalId;
	}
	public void setProviderAccountInternalId(String providerAccountInternalId) {
		this.providerAccountInternalId = providerAccountInternalId;
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
	
}
