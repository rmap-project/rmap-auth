package info.rmapproject.auth.model;

/**
 * ENUM to describe possible API key statuses.
 *
 * @author khanson
 */
public enum KeyStatus {
	ACTIVE("ACTIVE"), 
	INACTIVE("INACTIVE"), 
	REVOKED("REVOKED");

	/** Key status as string. */
	private final String keyStatus;

	/**
	 * Initiate key status with a status string.
	 *
	 * @param keyStatus the key status
	 */
	private KeyStatus (String keyStatus) {
		this.keyStatus = keyStatus;
	}
	
	/**
	 * Retrieve current key status as string.
	 *
	 * @return the key status
	 */
	public String getKeyStatus()  {
		return keyStatus;
	}
		
}
