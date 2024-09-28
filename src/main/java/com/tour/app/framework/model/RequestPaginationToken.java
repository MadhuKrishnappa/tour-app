package com.tour.app.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties
public class RequestPaginationToken {
	
	private boolean hasMoreRecords;
	private int requestedNoOfRecords;
	private Date lastRecTS;
	private int lastRecIndex;
	
	public boolean isHasMoreRecords() {
		return hasMoreRecords;
	}
	public void setHasMoreRecords(boolean hasMoreRecords) {
		this.hasMoreRecords = hasMoreRecords;
	}
	public int getRequestedNoOfRecords() {
		return requestedNoOfRecords;
	}
	public void setRequestedNoOfRecords(int requestedNoOfRecords) {
		this.requestedNoOfRecords = requestedNoOfRecords;
	}
	public Date getLastRecTS() {
		return lastRecTS;
	}
	public void setLastRecTS(Date lastRecTS) {
		this.lastRecTS = lastRecTS;
	}
	public int getLastRecIndex() {
		return lastRecIndex;
	}
	public void setLastRecIndex(int lastRecIndex) {
		this.lastRecIndex = lastRecIndex;
	}
	@Override
	public String toString() {
		return "RequestPaginationToken [hasMoreRecords=" + hasMoreRecords + ", requestedNoOfRecords="
				+ requestedNoOfRecords + ", lastRecTS=" + lastRecTS + ", lastRecIndex=" + lastRecIndex + "]";
	}



}
