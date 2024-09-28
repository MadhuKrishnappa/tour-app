package com.tour.app.framework.util;


import jakarta.servlet.http.HttpServletResponse;

public class O2HTTPUtil {
	
	private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";

	public static void addHeader(HttpServletResponse response,
								 String headerName, String headerValue) {
		response.addHeader(headerName, headerValue);
		response.addHeader(ACCESS_CONTROL_ALLOW_HEADERS, headerName);
	}

}
