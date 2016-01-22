package info.rmapproject.auth.exception;

import info.rmapproject.auth.utils.Constants;

import java.util.Properties;


/**
 * @author khanson
 * Custom error codes for RMap Authentication
 */
public enum ErrorCode {		
	ER_ACCESSCODE_SECRET_NOT_FOUND (4019001),
	ER_KEY_INACTIVE (4019002),
	ER_USER_ACCOUNT_REVOKED (4019003),
	ER_USER_AGENT_NOT_FORMED_IN_DB (4019004),
	ER_NULL_USER_PROVIDED (4019005),
	ER_AGENT_SYNC_NOT_CONFIGURED (4019006),
	ER_COULD_NOT_CREATE_ID_FOR_APIKEY (4019007),
	ER_PROBLEM_GENERATING_NEW_APIKEY (4019008);

	private final int number;

	private ErrorCode (int number) {
		this.number = number;
	}

	public int getNumber()  {
		return number;
	}

	private static Properties properties;

	private String message;
	
    private void init() {
		
		try {	
	        if (properties == null) {
	            properties = new Properties();
	            properties.load(ErrorCode.class.getResourceAsStream(Constants.ERROR_MSGS_PROPS_FILEPATH));
	        }
	        message = (String) properties.get(this.toString());
		} 
		catch(Exception e){
			message = Constants.DEFAULT_ERROR_MESSAGE;
			if (message == null){
				message = "";
			}
		}   
    }
    	
	/**
	 * @return String
	 * Returns the message that corresponds to the error code.
	 */
	public String getMessage() {
        if (this.message == null) {
            init();
        }
        return message;
	}
	
	
	
}

