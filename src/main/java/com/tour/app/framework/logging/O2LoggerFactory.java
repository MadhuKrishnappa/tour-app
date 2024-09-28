package com.tour.app.framework.logging;


public class O2LoggerFactory {
	
	public static O2Logger getLogger(Class c){
		O2Logger o2Logger = new O2Logger(c);
		return o2Logger;
	}

}
