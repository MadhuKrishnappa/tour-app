package com.tour.app.framework.logging;

import com.tour.app.common.constants.LoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class O2Logger {
	private Logger logger=null;
 
	public O2Logger(Class c) {
		logger=LoggerFactory.getLogger(c);
	}
	
	public void debug(LoggingEvent event, Object info) {
		logger.debug("^EVENT::"+event+"^, ^DEBUG::"+info+"^");
	}

	public void info(LoggingEvent event, Object info) {
		logger.info("^EVENT::"+event+"^, ^INFO::"+info+"^");
	}
	
	public void error(LoggingEvent event, Object errorMessage, Throwable throwable) {
		
		logger.error("^EVENT::"+event+"^, ^ERROR::"+errorMessage+"^", throwable);
	}

}
