package com.gss.pulseworkflow.model;

public class AssesseeCapability {
	private long rcdId;
	private String assmtId;
	private String assmtDtlRcdId;
	private String empAssessmtRcdId;
	private String capabilityId;
	private String capabilityName;
	private String completionComment;
	private String capabilityWeight;
	private String completedStatus;
	private String completedStatusValue;
	public AssesseeCapability() {
		super();
		
	}
	public AssesseeCapability(long rcdId, String assmtId, String assmtDtlRcdId, String empAssessmtRcdId,
			String capabilityId, String capabilityName, String completionComment, String capabilityWeight,
			String completedStatus, String completedStatusValue) {
		super();
		this.rcdId = rcdId;
		this.assmtId = assmtId;
		this.assmtDtlRcdId = assmtDtlRcdId;
		this.empAssessmtRcdId = empAssessmtRcdId;
		this.capabilityId = capabilityId;
		this.capabilityName = capabilityName;
		this.completionComment = completionComment;
		this.capabilityWeight = capabilityWeight;
		this.completedStatus = completedStatus;
		this.completedStatusValue = completedStatusValue;
	}
	@Override
	public String toString() {
		return "AssesseeCapability [rcdId=" + rcdId + ", assmtId=" + assmtId + ", assmtDtlRcdId=" + assmtDtlRcdId
				+ ", empAssessmtRcdId=" + empAssessmtRcdId + ", capabilityId=" + capabilityId + ", capabilityName="
				+ capabilityName + ", completionComment=" + completionComment + ", capabilityWeight=" + capabilityWeight
				+ ", completedStatus=" + completedStatus + ", completedStatusValue=" + completedStatusValue + "]";
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
	public String getEmpAssessmtRcdId() {
		return empAssessmtRcdId;
	}
	public void setEmpAssessmtRcdId(String empAssessmtRcdId) {
		this.empAssessmtRcdId = empAssessmtRcdId;
	}
	public String getCapabilityId() {
		return capabilityId;
	}
	public void setCapabilityId(String capabilityId) {
		this.capabilityId = capabilityId;
	}
	public String getCapabilityName() {
		return capabilityName;
	}
	public void setCapabilityName(String capabilityName) {
		this.capabilityName = capabilityName;
	}
	public String getCompletionComment() {
		return completionComment;
	}
	public void setCompletionComment(String completionComment) {
		this.completionComment = completionComment;
	}
	public String getCapabilityWeight() {
		return capabilityWeight;
	}
	public void setCapabilityWeight(String capabilityWeight) {
		this.capabilityWeight = capabilityWeight;
	}
	public String getCompletedStatus() {
		return completedStatus;
	}
	public void setCompletedStatus(String completedStatus) {
		this.completedStatus = completedStatus;
	}
	public String getCompletedStatusValue() {
		return completedStatusValue;
	}
	public void setCompletedStatusValue(String completedStatusValue) {
		this.completedStatusValue = completedStatusValue;
	}
	
	

}
