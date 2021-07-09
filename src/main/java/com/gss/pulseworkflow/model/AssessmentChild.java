package com.gss.pulseworkflow.model;

public class AssessmentChild {
	private long assmtDtlRcdId;
	private String assmtId;
	private String assessorId;
	private String assessorEmail;
	private String assmtDtlStatusId;
	private String assmtOutcome;
	private String assmtStartDate;
	private String assmtCompletedDate;
	private String assmtEndDate;
	private String projectId;
	private String projectName;
	private String assmtComments;
	private String scheduedInterval;
	private long empAssmtRcdId;
	private String assesseeId;
	private String assesseeEmail;
	private String empAssmtAssignedDate;
	private String empInitId;
	private String empAssmtStatusId;
	private String assmtDtlStatusValue;
	
	
	
	public String getAssmtDtlStatusValue() {
		return assmtDtlStatusValue;
	}

	public void setAssmtDtlStatusValue(String assmtDtlStatusValue) {
		this.assmtDtlStatusValue = assmtDtlStatusValue;
	}

	public AssessmentChild(long assmtDtlRcdId, String assmtId, String assessorId, String assessorEmail,
			String assmtDtlStatusId, String assmtOutcome, String assmtStartDate, String assmtCompletedDate,
			String assmtEndDate, String projectId, String projectName, String assmtComments, String scheduedInterval,
			long empAssmtRcdId, String assesseeId, String assesseeEmail, String empAssmtAssignedDate,
			String empInitId, String empAssmtStatusId,String assmtDtlStatusValue) {
		super();
		this.assmtDtlRcdId = assmtDtlRcdId;
		this.assmtId = assmtId;
		this.assessorId = assessorId;
		this.assessorEmail = assessorEmail;
		this.assmtDtlStatusId = assmtDtlStatusId;
		this.assmtOutcome = assmtOutcome;
		this.assmtStartDate = assmtStartDate;
		this.assmtCompletedDate = assmtCompletedDate;
		this.assmtEndDate = assmtEndDate;
		this.projectId = projectId;
		this.projectName = projectName;
		this.assmtComments = assmtComments;
		this.scheduedInterval = scheduedInterval;
		this.empAssmtRcdId = empAssmtRcdId;
		this.assesseeId = assesseeId;
		this.assesseeEmail = assesseeEmail;
		this.empAssmtAssignedDate = empAssmtAssignedDate;
		this.empInitId = empInitId;
		this.empAssmtStatusId = empAssmtStatusId;
		this.assmtDtlStatusValue=assmtDtlStatusValue;
	}
	
	public AssessmentChild() {
		super();
		
	}
	public long getAssmtDtlRcdId() {
		return assmtDtlRcdId;
	}
	public void setAssmtDtlRcdId(long assmtDtlRcdId) {
		this.assmtDtlRcdId = assmtDtlRcdId;
	}
	public String getAssmtId() {
		return assmtId;
	}
	public void setAssmtId(String assmtId) {
		this.assmtId = assmtId;
	}
	public String getAssessorId() {
		return assessorId;
	}
	public void setAssessorId(String assessorId) {
		this.assessorId = assessorId;
	}
	public String getAssessorEmail() {
		return assessorEmail;
	}
	public void setAssessorEmail(String assessorEmail) {
		this.assessorEmail = assessorEmail;
	}
	public String getAssmtDtlStatusId() {
		return assmtDtlStatusId;
	}
	public void setAssmtDtlStatusId(String assmtDtlStatusId) {
		this.assmtDtlStatusId = assmtDtlStatusId;
	}
	public String getAssmtOutcome() {
		return assmtOutcome;
	}
	public void setAssmtOutcome(String assmtOutcome) {
		this.assmtOutcome = assmtOutcome;
	}
	public String getAssmtStartDate() {
		return assmtStartDate;
	}
	public void setAssmtStartDate(String assmtStartDate) {
		this.assmtStartDate = assmtStartDate;
	}
	public String getAssmtCompletedDate() {
		return assmtCompletedDate;
	}
	public void setAssmtCompletedDate(String assmtCompletedDate) {
		this.assmtCompletedDate = assmtCompletedDate;
	}
	public String getAssmtEndDate() {
		return assmtEndDate;
	}
	public void setAssmtEndDate(String assmtEndDate) {
		this.assmtEndDate = assmtEndDate;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getAssmtComments() {
		return assmtComments;
	}
	public void setAssmtComments(String assmtComments) {
		this.assmtComments = assmtComments;
	}
	public String getScheduedInterval() {
		return scheduedInterval;
	}
	public void setScheduedInterval(String scheduedInterval) {
		this.scheduedInterval = scheduedInterval;
	}
	public long getEmpAssmtRcdId() {
		return empAssmtRcdId;
	}
	public void setEmpAssmtRcdId(long empAssmtRcdId) {
		this.empAssmtRcdId = empAssmtRcdId;
	}
	public String getAssesseeId() {
		return assesseeId;
	}
	public void setAssesseeId(String assesseeId) {
		this.assesseeId = assesseeId;
	}
	public String getAssesseeEmail() {
		return assesseeEmail;
	}
	public void setAssesseeEmail(String assesseeEmail) {
		this.assesseeEmail = assesseeEmail;
	}
	public String getEmpAssmtAssignedDate() {
		return empAssmtAssignedDate;
	}
	public void setEmpAssmtAssignedDate(String empAssmtAssignedDate) {
		this.empAssmtAssignedDate = empAssmtAssignedDate;
	}
	public String getEmpInitId() {
		return empInitId;
	}
	public void setEmpInitId(String empInitId) {
		this.empInitId = empInitId;
	}
	public String getEmpAssmtStatusId() {
		return empAssmtStatusId;
	}
	public void setEmpAssmtStatusId(String empAssmtStatusId) {
		this.empAssmtStatusId = empAssmtStatusId;
	}
	@Override
	public String toString() {
		return "AssessmentChild [assmtDtlRcdId=" + assmtDtlRcdId + ", assmtId=" + assmtId + ", assessorId=" + assessorId
				+ ", assessorEmail=" + assessorEmail + ", assmtDtlStatusId=" + assmtDtlStatusId + ", assmtOutcome="
				+ assmtOutcome + ", assmtStartDate=" + assmtStartDate + ", assmtCompletedDate=" + assmtCompletedDate
				+ ", assmtEndDate=" + assmtEndDate + ", projectId=" + projectId + ", projectName=" + projectName
				+ ", assmtComments=" + assmtComments + ", scheduedInterval=" + scheduedInterval + ", empAssmtRcdId="
				+ empAssmtRcdId + ", assesseeId=" + assesseeId + ", assesseeEmail=" + assesseeEmail
				+ ", empAssmtAssignedDate=" + empAssmtAssignedDate + ", empInitId=" + empInitId + ", empAssmtStatusId="
				+ empAssmtStatusId + ", assmtDtlStatusValue=" + assmtDtlStatusValue + "]";
	}
	
	

}
