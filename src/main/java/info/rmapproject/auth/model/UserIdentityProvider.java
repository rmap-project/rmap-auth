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
	private String requestToken;
	private Date tokenCreatedDate;
	private Date tokenExpirationDate;
	private Date createdDate;
	private Date modifiedDate;
	private int userId;
		
	public int getUserIdentityProviderId() {
		return userIdentityProviderId;
	}
	public void setUserIdentityProviderId(int userIdentityProviderId) {
		this.userIdentityProviderId = userIdentityProviderId;
	}
	public String getRefreshToken() {
		return requestToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.requestToken = refreshToken;
	}
	public Date getTokenCreatedDate() {
		return tokenCreatedDate;
	}
	public void setTokenCreatedDate(Date tokenCreatedDate) {
		this.tokenCreatedDate = tokenCreatedDate;
	}
	public Date getTokenExpirationDate() {
		return tokenExpirationDate;
	}
	public void setTokenExpirationDate(Date tokenExpirationDate) {
		this.tokenExpirationDate = tokenExpirationDate;
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
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
	
}
