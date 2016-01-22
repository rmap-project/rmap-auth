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
	  
	  private Constants(){
		    //this prevents even the native class from calling this ctor as well :
		    throw new AssertionError();
		  }
}
