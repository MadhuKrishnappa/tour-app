package com.tour.app.framework.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties
public class ResponsePaginationToken {
	
	private boolean hasMoreRecords;
	private int noOfRecordsFetched;
	private Date lastRecTS;
	private int lastRecIndex;
	
	public boolean isHasMoreRecords() {
		return hasMoreRecords;
	}
	public void setHasMoreRecords(boolean hasMoreRecords) {
		this.hasMoreRecords = hasMoreRecords;
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
	public int getNoOfRecordsFetched() {
		return noOfRecordsFetched;
	}
	public void setNoOfRecordsFetched(int noOfRecordsFetched) {
		this.noOfRecordsFetched = noOfRecordsFetched;
	}
	@Override
	public String toString() {
		return "ResponsePaginationToken [hasMoreRecords=" + hasMoreRecords + ", noOfRecordsFetched="
				+ noOfRecordsFetched + ", lastRecTS=" + lastRecTS + ", lastRecIndex=" + lastRecIndex + "]";
	}



}
