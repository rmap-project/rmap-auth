package info.rmapproject.auth.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author khanson
 *
 */

@Entity
@Table(name="ApiKeys")
public class ApiKey {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int apiKeyId;
	private String accessKey;
	private String secret;
	private String keyUri;
	@NotEmpty
	private String label;
	private String note;
	private KeyStatus keyStatus;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;
	private Date createdDate=new Date();
	private Date lastModifiedDate=new Date();
	private Date revokedDate;
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
	
	
	
}
