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

	public static final String RMAPAUTHSERVICE_BEANNAME = "RMapAuthService";
	
	private static RMapAuthService rmapAuthService;
	
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
