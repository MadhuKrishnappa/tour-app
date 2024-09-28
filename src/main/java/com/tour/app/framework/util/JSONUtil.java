package com.tour.app.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tour.app.common.constants.ErrorCodes;
import com.tour.app.common.util.StringUtil;
import com.tour.app.framework.exception.O2Exception;

public class JSONUtil {

	public static String convertToJSON(Object obj) throws O2Exception {
		String jsonString = null;
		if(obj!=null){
			// Create a JaxBContext
			ObjectMapper mapper = new ObjectMapper();
			try {
				jsonString = mapper.writeValueAsString(obj);
			} catch (Exception ex) {
				throw new O2Exception(ErrorCodes.JSON_CONVERSION_FAILED,
						"Error occurred while converting JAVA to JSON. Input object= " + obj, ex);
			}
		}
		return jsonString;
	}

	public static <T> T convertFromJSON(String jsonString, Class<T> c) throws O2Exception {
		// Create a JaxBContext
		T jsonObj = null;
		if(StringUtil.isNotNULLAndNotBlank(jsonString)){
			ObjectMapper mapper = new ObjectMapper();
			try {
				jsonObj = mapper.readValue(jsonString, c);
			} catch (Exception ex) {
				throw new O2Exception(ErrorCodes.JSON_CONVERSION_FAILED,
						"Error occurred while converting JSON to JAVA. Input json string= " + jsonString, ex);
			}
		}
		return jsonObj;
	}

}
