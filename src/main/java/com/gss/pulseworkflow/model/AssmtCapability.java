package com.gss.pulseworkflow.model;

import java.io.Serializable;

public class AssmtCapability implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long rcdId;
	private String assmtId;
	private String assmtDtlRcdId;
	private String assmtCapabilityId;
	private String assmtCapabilityName;
	private String assmtComment;
	private String assmtCapabilityWeight;
	private String lastUpdatedDate;
	//private String completedStatusValue;
	
	/*
	 * public String getCompletedStatusValue() { return completedStatusValue; }
	 * 
	 * public void setCompletedStatusValue(String completedStatusValue) {
	 * this.completedStatusValue = completedStatusValue; }
	 */
	public AssmtCapability(long rcdId, String assmtId, String assmtDtlRcdId, String assmtCapabilityId,
			String assmtCapabilityName, String assmtComment, String assmtCapabilityWeight, String lastUpdatedDate) {
		super();
		this.rcdId = rcdId;
		this.assmtId = assmtId;
		this.assmtDtlRcdId = assmtDtlRcdId;
		this.assmtCapabilityId = assmtCapabilityId;
		this.assmtCapabilityName = assmtCapabilityName;
		this.assmtComment = assmtComment;
		this.assmtCapabilityWeight = assmtCapabilityWeight;
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	public AssmtCapability() {
		super();
	}

	public long getRcdId() {
		return rcdId;
	}

	public void setRcdId(long rcdId) {
		this.rcdId = rcdId;
	}

	public String getAssmtId() {
		return assmtId;
	}

	public void setAssmtId(String assmtId) {
		this.assmtId = assmtId;
	}

	public String getAssmtDtlRcdId() {
		return assmtDtlRcdId;
	}

	public void setAssmtDtlRcdId(String assmtDtlRcdId) {
		this.assmtDtlRcdId = assmtDtlRcdId;
	}

	public String getAssmtCapabilityId() {
		return assmtCapabilityId;
	}

	public void setAssmtCapabilityId(String assmtCapabilityId) {
		this.assmtCapabilityId = assmtCapabilityId;
	}

	public String getAssmtCapabilityName() {
		return assmtCapabilityName;
	}

	public void setAssmtCapabilityName(String assmtCapabilityName) {
		this.assmtCapabilityName = assmtCapabilityName;
	}

	public String getAssmtComment() {
		return assmtComment;
	}

	public void setAssmtComment(String assmtComment) {
		this.assmtComment = assmtComment;
	}

	public String getAssmtCapabilityWeight() {
		return assmtCapabilityWeight;
	}

	public void setAssmtCapabilityWeight(String assmtCapabilityWeight) {
		this.assmtCapabilityWeight = assmtCapabilityWeight;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AssmtCapability [rcdId=" + rcdId + ", assmtId=" + assmtId + ", assmtDtlRcdId=" + assmtDtlRcdId
				+ ", assmtCapabilityId=" + assmtCapabilityId + ", assmtCapabilityName=" + assmtCapabilityName
				+ ", assmtComment=" + assmtComment + ", assmtCapabilityWeight=" + assmtCapabilityWeight
				+ ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}
	
	
	

}
