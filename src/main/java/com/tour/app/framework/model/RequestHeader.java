package com.tour.app.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class RequestHeader {
	private String o2SessionId;
	private String uuId;
	private RequestPaginationToken paginationToken;

	public String getO2SessionId() {
		return o2SessionId;
	}

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	public void setO2SessionId(String o2SessionId) {
		this.o2SessionId = o2SessionId;
	}

	public RequestPaginationToken getPaginationToken() {
		return paginationToken;
	}

	public void setPaginationToken(RequestPaginationToken paginationToken) {
		this.paginationToken = paginationToken;
	}

	@Override
	public String toString() {
		return "RequestHeader [o2SessionId=" + o2SessionId + ", uuId=" + uuId + ", paginationToken=" + paginationToken
				+ "]";
	}

	

}
