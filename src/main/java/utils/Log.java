package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	
	private static final Logger logger =LogManager.getLogger();
	
	//info=General information
	
	public static void info(String message) {
		logger.info(message);
		
	}
	//warn - warnings
	public static void warn(String message) {
		logger.warn(message);
		
	}
	//error - Errors
	public static void error(String message) {
		logger.error(message);
		
	}
	//debug- debugging details
	public static void debug(String message) {
		logger.debug(message);
		
	}
}
