package com.gss.pulseworkflow.model;

public class EmpAssesseeAssmtDetail {
	private String assmtDtlRcdId;
	private String assessorId;
	private String assessorEmail;
	private String assmtDtlStatus;
	private String assmtOutcome;
	private String assmtInitDate;
	private String assmtDueDate;
	private String assmtCompletedDate;
	private String projectId;
	private String assmtComment;
	private String assmtScheduledInterval;
	public EmpAssesseeAssmtDetail(String assmtDtlRcdId,String assessorId, String assessorEmail,String assmtDtlStatus, String assmtOutcome, String assmtInitDate, String assmtDueDate,
			String assmtCompletedDate, String projectId, String assmtComment, String assmtScheduledInterval) {
		super();
		this.assmtDtlRcdId = assmtDtlRcdId;
		this.assessorId = assessorId;
		this.assessorEmail = assessorEmail;
		this.assmtDtlStatus = assmtDtlStatus;
		this.assmtOutcome = assmtOutcome;
		this.assmtInitDate = assmtInitDate;
		this.assmtDueDate = assmtDueDate;
		this.assmtCompletedDate = assmtCompletedDate;
		this.projectId = projectId;
		this.assmtComment = assmtComment;
		this.assmtScheduledInterval = assmtScheduledInterval;
	}
	
	public EmpAssesseeAssmtDetail() {
		super();
	}

	

	public String getAssmtDtlRcdId() {
		return assmtDtlRcdId;
	}

	public void setAssmtDtlRcdId(String assmtDtlRcdId) {
		this.assmtDtlRcdId = assmtDtlRcdId;
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

	public String getAssmtDtlStatus() {
		return assmtDtlStatus;
	}

	public void setAssmtDtlStatus(String assmtDtlStatus) {
		this.assmtDtlStatus = assmtDtlStatus;
	}

	public String getAssmtOutcome() {
		return assmtOutcome;
	}

	public void setAssmtOutcome(String assmtOutcome) {
		this.assmtOutcome = assmtOutcome;
	}

	public String getAssmtInitDate() {
		return assmtInitDate;
	}

	public void setAssmtInitDate(String assmtInitDate) {
		this.assmtInitDate = assmtInitDate;
	}

	public String getAssmtDueDate() {
		return assmtDueDate;
	}

	public void setAssmtDueDate(String assmtDueDate) {
		this.assmtDueDate = assmtDueDate;
	}

	public String getAssmtCompletedDate() {
		return assmtCompletedDate;
	}

	public void setAssmtCompletedDate(String assmtCompletedDate) {
		this.assmtCompletedDate = assmtCompletedDate;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getAssmtComment() {
		return assmtComment;
	}

	public void setAssmtComment(String assmtComment) {
		this.assmtComment = assmtComment;
	}

	public String getAssmtScheduledInterval() {
		return assmtScheduledInterval;
	}

	public void setAssmtScheduledInterval(String assmtScheduledInterval) {
		this.assmtScheduledInterval = assmtScheduledInterval;
	}

	@Override
	public String toString() {
		return "EmpAssesseeAssmtDetail [assmtDtlRcdId=" + assmtDtlRcdId + ", assessorId="
				+ assessorId + ", assessorEmail=" + assessorEmail + ", assmtDtlStatus=" + assmtDtlStatus
				+ ", assmtOutcome=" + assmtOutcome + ", assmtInitDate=" + assmtInitDate + ", assmtDueDate="
				+ assmtDueDate + ", assmtCompletedDate=" + assmtCompletedDate + ", projectId=" + projectId
				+ ", assmtComment=" + assmtComment + ", assmtScheduledInterval=" + assmtScheduledInterval + "]";
	}
	
	
	
	
}
