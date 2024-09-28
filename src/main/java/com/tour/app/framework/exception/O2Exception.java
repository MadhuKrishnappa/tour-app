package com.tour.app.framework.exception;


import com.tour.app.common.util.StringUtil;

public class O2Exception extends Exception {

	private static final long serialVersionUID = 1L;

	private int errorCode;
	private String fullErrorDetails;

	private String httpErrorCode;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	 

	public O2Exception(int errorCode, String fullErrorDetails, Throwable th) {
		super(getErrorCause(errorCode, fullErrorDetails, th), th);
		this.httpErrorCode=getMapedHttpErrorCode(errorCode);
		this.errorCode = errorCode;
		this.fullErrorDetails = fullErrorDetails;
	}





	private String getMapedHttpErrorCode(int errorCode) {
		String httpErrorCode = O2ErrorCodeUtil.getHttpErrorCode(errorCode);
		if (StringUtil.isNULLOrBlank(httpErrorCode)) {
			throw new RuntimeException("ErrorCode[" + errorCode
					+ "] not found in [" + O2ErrorCodeUtil.PROPERTY_FILE_NAME
					+ "] file");
		}
		return httpErrorCode;
	}

	private static String getErrorCause(int errorCode, String fullErrorDetails,
			Throwable th) {
		StringBuilder errorCause = new StringBuilder();
		errorCause.append("ERROR_CODE::" + errorCode);

		if (StringUtil.isNULLOrBlank(fullErrorDetails)) {
			throw new RuntimeException("fullErrorDetails cannot be empty");
		} else {
			errorCause.append(", ERROR_DESC::" + fullErrorDetails);
		}
		return errorCause.toString();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getFullErrorDetails() {
		return fullErrorDetails;
	}
	
	public String getHttpErrorCode() {
		return httpErrorCode;
	}

}

	