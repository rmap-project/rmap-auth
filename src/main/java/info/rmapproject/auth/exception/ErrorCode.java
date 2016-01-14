package info.rmapproject.auth.exception;

import info.rmapproject.auth.utils.Constants;

import java.util.Properties;


/**
 * @author khanson
 * Custom error codes for RMap Authentication
 */
public enum ErrorCode {		
	ER_ACCESSCODE_SECRET_NOT_FOUND (4012001),
	ER_KEY_INACTIVE (40012002),
	ER_USER_ACCOUNT_REVOKED (4012003); 

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

