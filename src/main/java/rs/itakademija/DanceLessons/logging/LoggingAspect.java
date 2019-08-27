package rs.itakademija.DanceLessons.logging;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * Log before every method enter
	 * 
	 * @param joinPoint
	 */
	
	public void logEnterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toString();
		if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
			logger.info("Enter: {}; args = {}", methodName,
                    joinPoint.getArgs());
		} else {
			logger.info("Enter: {}", methodName);
        }
	}
	
	/**
	 * Log every return method
	 * 
	 * @param joinPoint
	 * @param result
	 */
	
	public void logReturnResult(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().toString();
		if(result == null) {
			logger.info("Exit: {}", methodName);
		} else {
			logger.info("Exit: {}; return = {}", methodName, result);
		}
	}
	
	/**
	 * Log every error on exception thrown
	 * 
	 * @param joinPoint
	 * @param error
	 */
	
	public void logError(JoinPoint joinPoint, Throwable error) {
		String methodName = joinPoint.getSignature().toString();
		logger.error("Exception thrown during execution of method " + methodName, error);
	}
	
	
	
}
