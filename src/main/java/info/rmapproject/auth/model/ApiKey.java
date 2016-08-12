package info.rmapproject.auth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Java representation of ApiKeys database table.
 * Api Keys are associated with a user that logged into the GUI
 * The keys can be used for write access to the RMap API.
 * @author khanson
 *
 */

@Entity
@Table(name="ApiKeys")
public class ApiKey {
	
	/**Unique id column for API Key table**/
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int apiKeyId;
	
	/**String of base64 characters that are used as a key to write to RMap API**/
	private String accessKey;
	
	/**String of base64 characters, used with the accessKey as a kind of password, 
	 * the accessKey/secret combo is for API write access.*/
	private String secret;
	
	/** Key URI is a university unique identifier to identify the specific api key used for access
	 * there is an option to associate this key with the Event record in RMap so that you can see which
	 * key was used to create the record.	 */
	private String keyUri;
	
	/**A label associated with the key to tag or describe it*/
	@NotEmpty
	private String label;
	
	/**A longer description of the key*/
	private String note;
	
	/**The status of the key (e.g. inactive, revoked)*/
	@Enumerated(EnumType.STRING)
	private KeyStatus keyStatus;
	
	/**The start date from which the key is valid. If the key is used before this date it will not work */
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date startDate;
	
	/**The end date for the key after which the key is no longer valid.  If the key is used after this date it will not work*/
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date endDate;
	
	/**The date the key was created**/
	private Date createdDate=new Date();
	
	/**The date the key was last modified*/
	private Date lastModifiedDate=new Date();
	
	/**The date the key was revoked (null if empty)**/
	private Date revokedDate;
	
	/**Flag to include the key in the Event information of RMap so that you can identify which key created the DiSCO*/
	private boolean includeInEvent = false;
	
	/**The user that the key is associated with*/
	private int userId;
	
	public int getApiKeyId() {
		return apiKeyId;
	}
	public void setApiKeyId(int apiKeyId) {
		this.apiKeyId = apiKeyId;
	}
	public String getAccessKey() {
		return accessKey;
	}
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getKeyUri() {
		return keyUri;
	}
	public void setKeyUri(String keyUri) {
		this.keyUri = keyUri;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public KeyStatus getKeyStatus() {
		return keyStatus;
	}
	public void setKeyStatus(KeyStatus keyStatus) {
		this.keyStatus = keyStatus;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Date getRevokedDate() {
		return revokedDate;
	}
	public void setRevokedDate(Date revokedDate) {
		this.revokedDate = revokedDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isIncludeInEvent() {
		return includeInEvent;
	}
	public void setIncludeInEvent(boolean includeInEvent) {
		this.includeInEvent = includeInEvent;
	}
	
	
	
}
