package com.tour.app.framework.model;

public class VersionVO implements IServiceVO {
	private String apiVersion;
	private boolean validateVersion;

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}


	public boolean isValidateVersion() {
		return validateVersion;
	}

	public void setValidateVersion(boolean validateVersion) {
		this.validateVersion = validateVersion;
	}
	

	@Override
	public String toString() {
		return "VersionVO [apiVersion=" + apiVersion + ", validateVersion="
				+ validateVersion + "]";
	}
}
