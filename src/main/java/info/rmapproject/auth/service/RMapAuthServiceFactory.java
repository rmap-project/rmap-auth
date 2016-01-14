/**
 * 
 */
package info.rmapproject.auth.service;

import info.rmapproject.auth.utils.Constants;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
		
/**
 * @author khanson
 *
 */
public class RMapAuthServiceFactory {

	private static RMapAuthService rmapAuthService;
	
	public static RMapAuthService createService()  {		
    	try {
    		if (rmapAuthService==null) {
        		@SuppressWarnings("resource")
    			ApplicationContext context = new ClassPathXmlApplicationContext(Constants.SPRING_CONFIG_FILEPATH);
        		rmapAuthService = (RMapAuthService)context.getBean("rmapAuthService", RMapAuthService.class);    			
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return rmapAuthService;
	}

}
