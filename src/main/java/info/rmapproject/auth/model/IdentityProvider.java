package info.rmapproject.auth.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author khanson
 *
 */
@Entity
@Table(name="IdentityProviders")
public class IdentityProvider {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identityProviderId;
	private String name;
	private String clientId;
	private String secret;
	private String authUrl;
	private String logoPath;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="identityProviderId")
	List<UserIdentityProvider> userIdentityProviders;

	public int getIdentityProviderId() {
		return identityProviderId;
	}

	public void setIdentityProviderId(int identityProviderId) {
		this.identityProviderId = identityProviderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public List<UserIdentityProvider> getUserIdentityProviders() {
		return userIdentityProviders;
	}

	public void setUserIdentityProviders(
			List<UserIdentityProvider> userIdentityProviders) {
		this.userIdentityProviders = userIdentityProviders;
	}
	
	
	
	
}
