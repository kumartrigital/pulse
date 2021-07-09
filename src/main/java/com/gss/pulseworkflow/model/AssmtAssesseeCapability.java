package com.gss.pulseworkflow.model;

public class AssmtAssesseeCapability {
	
	private String assmtCapabilityRcdId;
	private String assmtCapabilityId;
	private String assmtCapabilityName;
	private String assmtCapabilityComment;
	private String assmtCapabilityWeight;
	private String assmtCapabilityStatus;
	private String lastUpdatedDate;
	public AssmtAssesseeCapability(String assmtCapabilityRcdId, String assmtCapabilityId, String assmtCapabilityName,
			String assmtCapabilityComment, String assmtCapabilityWeight, String assmtCapabilityStatus,
			String lastUpdatedDate) {
		super();
		this.assmtCapabilityRcdId = assmtCapabilityRcdId;
		this.assmtCapabilityId = assmtCapabilityId;
		this.assmtCapabilityName = assmtCapabilityName;
		this.assmtCapabilityComment = assmtCapabilityComment;
		this.assmtCapabilityWeight = assmtCapabilityWeight;
		this.assmtCapabilityStatus = assmtCapabilityStatus;
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public AssmtAssesseeCapability() {
		super();
		
	}
	@Override
	public String toString() {
		return "AssmtAssesseeCapability [assmtCapabilityRcdId=" + assmtCapabilityRcdId + ", assmtCapabilityId="
				+ assmtCapabilityId + ", assmtCapabilityName=" + assmtCapabilityName + ", assmtCapabilityComment="
				+ assmtCapabilityComment + ", assmtCapabilityWeight=" + assmtCapabilityWeight
				+ ", assmtCapabilityStatus=" + assmtCapabilityStatus + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}
	public String getAssmtCapabilityRcdId() {
		return assmtCapabilityRcdId;
	}
	public void setAssmtCapabilityRcdId(String assmtCapabilityRcdId) {
		this.assmtCapabilityRcdId = assmtCapabilityRcdId;
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
	public String getAssmtCapabilityComment() {
		return assmtCapabilityComment;
	}
	public void setAssmtCapabilityComment(String assmtCapabilityComment) {
		this.assmtCapabilityComment = assmtCapabilityComment;
	}
	public String getAssmtCapabilityWeight() {
		return assmtCapabilityWeight;
	}
	public void setAssmtCapabilityWeight(String assmtCapabilityWeight) {
		this.assmtCapabilityWeight = assmtCapabilityWeight;
	}
	public String getAssmtCapabilityStatus() {
		return assmtCapabilityStatus;
	}
	public void setAssmtCapabilityStatus(String assmtCapabilityStatus) {
		this.assmtCapabilityStatus = assmtCapabilityStatus;
	}
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	
	

}
