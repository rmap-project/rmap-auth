package info.rmapproject.auth.utils;

/**
 * Class to define system constants that do not need to be configured 
 * externally as a property.
 *
 * @author khanson
 */

public final class Constants  {
	
	  /** File path to RMap Auth Spring context. */
	  public static final String SPRING_CONFIG_FILEPATH = "spring-rmapauth-context.xml";
	
	  /** Name of properties file for RMap API properties. */
	  public static final String RMAP_AUTH_PROPFILE = "rmapauth";
	  
  	  /** Key to retrieve base URL path for RMap. */
	  public static final String RMAP_BASE_URL_KEY = "rmapauth.baseUrl";  
	  
	  
	  /** File path for error message text. */
	  public static final String ERROR_MSGS_PROPS_FILEPATH = "/auth_error_msgs.properties";
	  
	  /** Used as a default message when the error message properties file cannot be found. */
	  public static final String DEFAULT_ERROR_MESSAGE = "An error occurred";  
	  
	  /** Used to form path for AUTH IDs, formed to represent Agents. */
	  public static final String AUTH_ID_FOLDER = "/authids";  
	  
	  /** Length of API access key. */
	  public static final int ACCESS_KEY_LENGTH = 16;  
	  
  	  /** Length of secret that goes with API access key. */
	  public static final int SECRET_LENGTH = 16;  
	  
	 /**
  	 * Instantiates a new constants.
  	 */
  	private Constants(){
		    //this prevents even the native class from calling this ctor as well :
		    throw new AssertionError();
		  }
}
