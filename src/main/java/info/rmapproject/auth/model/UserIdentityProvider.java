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
	private String accessToken;
	private String refreshToken;
	private Date tokenCreatedDate;
	private Date tokenExpirationDate;
	private int identityProviderId;
	private int userId;
		
	public int getUserIdentityProviderId() {
		return userIdentityProviderId;
	}
	public void setUserIdentityProviderId(int userIdentityProviderId) {
		this.userIdentityProviderId = userIdentityProviderId;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
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
	public int getIdentityProviderId() {
		return identityProviderId;
	}
	public void setIdentityProviderId(int identityProviderId) {
		this.identityProviderId = identityProviderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
