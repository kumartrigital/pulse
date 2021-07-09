package com.gss.pulseworkflow.model;

public class AssessmtDeatilTemp {
	private String assessorId;
	private String assmtDtlStatus;
	private String outCome;
	private String initDate;
	private String completedDate;
	private String endDate;
	private String projectId;
	private String assmtComment;
	private String scheduledInterval;
	public String getAssessorId() {
		return assessorId;
	}
	public void setAssessorId(String assessorId) {
		this.assessorId = assessorId;
	}
	public String getAssmtDtlStatus() {
		return assmtDtlStatus;
	}
	public void setAssmtDtlStatus(String assmtDtlStatus) {
		this.assmtDtlStatus = assmtDtlStatus;
	}
	public String getOutCome() {
		return outCome;
	}
	public void setOutCome(String outCome) {
		this.outCome = outCome;
	}
	public String getInitDate() {
		return initDate;
	}
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}
	public String getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
	public String getScheduledInterval() {
		return scheduledInterval;
	}
	public void setScheduledInterval(String scheduledInterval) {
		this.scheduledInterval = scheduledInterval;
	}
	@Override
	public String toString() {
		return "AssessmtDeatilTemp [assessorId=" + assessorId + ", assmtDtlStatus=" + assmtDtlStatus + ", outCome="
				+ outCome + ", initDate=" + initDate + ", completedDate=" + completedDate + ", endDate=" + endDate
				+ ", projectId=" + projectId + ", assmtComment=" + assmtComment + ", scheduledInterval="
				+ scheduledInterval + "]";
	}
	public AssessmtDeatilTemp(String assessorId, String assmtDtlStatus, String outCome, String initDate,
			String completedDate, String endDate, String projectId, String assmtComment, String scheduledInterval) {
		super();
		this.assessorId = assessorId;
		this.assmtDtlStatus = assmtDtlStatus;
		this.outCome = outCome;
		this.initDate = initDate;
		this.completedDate = completedDate;
		this.endDate = endDate;
		this.projectId = projectId;
		this.assmtComment = assmtComment;
		this.scheduledInterval = scheduledInterval;
	}
	
	public AssessmtDeatilTemp() {
		super();
	}
	
	
	
	
	
	
	
	
	
	

}
