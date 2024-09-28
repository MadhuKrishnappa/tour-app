package com.tour.app.framework.model;

public class Status {
	public static final int SUCCESS = 0;

	private int statusCode;
	private String statusMessage;

	public Status(int statusCode, String statusMessage) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	@Override
	public String toString() {
		return "Status [statusCode=" + statusCode + ", statusMessage="
				+ statusMessage + "]";
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
