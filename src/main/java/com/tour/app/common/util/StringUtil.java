package com.tour.app.common.util;

import java.util.List;

public class StringUtil {

	public static boolean isNULLOrBlank(String inputString) {
		return inputString == null || inputString.trim().length() == 0;
	}

	public static boolean isNotNULLAndNotBlank(String inputString) {
		return inputString != null && inputString.trim().length() != 0;
	}

	public static boolean isNULLorBlankID(List<Long> list) {
		boolean iD = list == null;
		return iD;
	}

	public static boolean isNULLorBlankID(long id) {
		boolean iD = id == 0;
		return iD;
	}
	
	public static boolean isNULLOrBlankArray(String[] inputString) {
		return inputString==null || inputString.length==0;
	}

	public static boolean isNotNULLAndNotBlankID(long id) {
		boolean iD = id != 0;
		return iD;
	}

	public static boolean isNotNULLAndNotBlankArray(String[] inputString) {
		return inputString != null && inputString.length != 0;
	}

	public static String getTrimmedToken(String access_token) {
		if (access_token.contains("&expires")) {
			access_token = access_token.substring(0,
					access_token.indexOf("&expires"));
			if (access_token.contains("access_token=")) {
				access_token = access_token.replace("access_token=", "");
				return access_token;
			}
			return access_token;

		} else {
			return access_token;
		}

	}

	public static String truncate(String test, int length) {
		if (test.length() > length) {
			return test.substring(0, length);
		} else {
			return test;
		}
	}

	public static String toDisplayCase(String string) {

		final String ACTIONABLE_DELIMITERS = " '-/";

		StringBuilder stringBuilder = new StringBuilder();
		boolean capNext = true;

		for (char c : string.toCharArray()) {
			c = (capNext) ? Character.toUpperCase(c) : Character.toLowerCase(c);
			stringBuilder.append(c);
			capNext = (ACTIONABLE_DELIMITERS.indexOf((int) c) >= 0);
		}
		return stringBuilder.toString();
	}

}
