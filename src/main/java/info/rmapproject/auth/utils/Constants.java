package info.rmapproject.auth.utils;

public final class Constants  {
	  /**Used as a default message when the error message properties file cannot be found*/
	  public static final String SPRING_CONFIG_FILEPATH = "/spring-config.xml";  
	  
	  /**File path for error message text*/
	  public static final String ERROR_MSGS_PROPS_FILEPATH = "/error_msgs.properties";
	  
	  /**Used as a default message when the error message properties file cannot be found*/
	  public static final String DEFAULT_ERROR_MESSAGE = "An error occurred";  
	  
	  /**Base URL path for RMap*/
	  public static final String RMAP_BASE_URL = "http://rmap-project.org/";  
	  /**Used to form path for AUTH IDs, formed to represent Agents*/
	  public static final String AUTH_ID_FOLDER = "/authids";  
	  /**Used to form path for KEY IDs, formed to represent Keys*/
	  public static final String KEY_ID_FOLDER = "/keyids";  
	  
	  /**Length of API access key*/
	  public static final int ACCESS_KEY_LENGTH = 32;  
	  /**Length of secret that goes with API access key*/
	  public static final int SECRET_LENGTH = 64;  
	  /**Length of ID that is used to form key id. Key ID is not used to access API, it is a unique ID given to the key.*/
	  public static final int KEY_ID_LENGTH = 32;  
	  
	  private Constants(){
		    //this prevents even the native class from calling this ctor as well :
		    throw new AssertionError();
		  }
}
