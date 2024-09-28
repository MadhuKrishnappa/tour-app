package com.tour.app.framework.exception;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class O2ErrorCodeUtil {

	static final String PROPERTY_FILE_NAME = "O2ErrorCodesMapping.properties";
	private static Properties errorCodeResgistry = new Properties();

	static {
		loadProperties();
	}

	private static void loadProperties() {
		InputStream is = null;
		try {
			is = O2ErrorCodeUtil.class.getClassLoader().getResourceAsStream(
					PROPERTY_FILE_NAME);
			errorCodeResgistry.load(is);
		} catch (Throwable th) {
			throw new RuntimeException("Failed to load property file ["
					+ PROPERTY_FILE_NAME + "]", th);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					throw new RuntimeException("Failed to load property file ["
							+ PROPERTY_FILE_NAME + "]", e);
				}
			}
		}
	}
 
	public static String getHttpErrorCode(int errorCode) {
		return errorCodeResgistry.getProperty(String.valueOf(errorCode));
	}

}
