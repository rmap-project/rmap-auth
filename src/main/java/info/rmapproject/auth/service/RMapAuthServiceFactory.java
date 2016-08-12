package info.rmapproject.auth.service;

import info.rmapproject.auth.utils.Constants;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This factory provides a way for non-Spring apps to initiate an instance of RMapAuthService using 
 * the Spring bean settings so that internal autowiring works.
 * @author khanson
 *
 */
public class RMapAuthServiceFactory {

	/**Name of RMapAuthService bean*/
	public static final String RMAPAUTHSERVICE_BEANNAME = "RMapAuthService";
	
	/**RMapAuthService object**/
	private static RMapAuthService rmapAuthService;
	
	/**
	 * Create RMapAuthService object instance based on bean name
	 * @return
	 */
	public static RMapAuthService createService() {
		try {
			if (rmapAuthService == null){
				@SuppressWarnings("resource")
				ApplicationContext context = new ClassPathXmlApplicationContext(Constants.SPRING_CONFIG_FILEPATH);
				rmapAuthService = (RMapAuthService)context.getBean(RMAPAUTHSERVICE_BEANNAME, RMapAuthService.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rmapAuthService;
	}
	
}
