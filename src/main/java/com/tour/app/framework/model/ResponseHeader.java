package com.tour.app.framework.model;

public class ResponseHeader {
	
	private Status status;
	private String o2SessionId;
	private ResponsePaginationToken paginationToken;
 
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

	public ResponsePaginationToken getPaginationToken() {
		return paginationToken;
	}

	public void setPaginationToken(ResponsePaginationToken paginationToken) {
		this.paginationToken = paginationToken;
	}

	public String getO2SessionId() {
		return o2SessionId;
	}

	public void setO2SessionId(String o2SessionId) {
		this.o2SessionId = o2SessionId;
	}

	@Override
	public String toString() {
		return "ResponseHeader [status=" + status + ", o2SessionId=" + o2SessionId + ", paginationToken="
				+ paginationToken + "]";
	}

	


}
