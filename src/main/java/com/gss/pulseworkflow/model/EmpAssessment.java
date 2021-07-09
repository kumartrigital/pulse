package com.gss.pulseworkflow.model;

import java.io.Serializable;
import java.util.List;

public class EmpAssessment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String assmtId;
	private String assmtName;
	private String intervalValue;
	private String assmtDes;
	private String assmtStatus;
	private String assmtDtlRcdId;
	private String assmtInitDate;
	private String assmtDueDate;
	private String assmtDtlCompletedDate;
	private String projectId;
	private String assmtComment;
	private String assmtScheduledInterval;
	private String assmtDtlStatus;
	private String assessorId;
	private String assessorEmail;
	private String empAssmtRcdId;
	private String assesseeId;
	private String assesseeEmail;
	private List<AssesseeCapability> assesseeCapabilityInfo;
	
	
	
	
	
	
	public List<AssesseeCapability> getAssesseeCapabilityInfo() {
		return assesseeCapabilityInfo;
	}

	public void setAssesseeCapabilityInfo(List<AssesseeCapability> assesseeCapabilityInfo) {
		this.assesseeCapabilityInfo = assesseeCapabilityInfo;
	}

	public String getEmpAssmtRcdId() {
		return empAssmtRcdId;
	}

	public void setEmpAssmtRcdId(String empAssmtRcdId) {
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

	public EmpAssessment() {
		super();
		
	}
	
	public EmpAssessment(String assmtId, String assmtName, String intervalValue, String assmtDes, String assmtStatus,
			String assmtDtlRcdId, String assmtInitDate, String assmtDueDate, String assmtDtlCompletedDate,
			String projectId, String assmtComment, String assmtScheduledInterval, String assmtDtlStatus,
			String assessorId, String assessorEmail, String empAssmtRcdId, String assesseeId, String assesseeEmail) {
		super();
		this.assmtId = assmtId;
		this.assmtName = assmtName;
		this.intervalValue = intervalValue;
		this.assmtDes = assmtDes;
		this.assmtStatus = assmtStatus;
		this.assmtDtlRcdId = assmtDtlRcdId;
		this.assmtInitDate = assmtInitDate;
		this.assmtDueDate = assmtDueDate;
		this.assmtDtlCompletedDate = assmtDtlCompletedDate;
		this.projectId = projectId;
		this.assmtComment = assmtComment;
		this.assmtScheduledInterval = assmtScheduledInterval;
		this.assmtDtlStatus = assmtDtlStatus;
		this.assessorId = assessorId;
		this.assessorEmail = assessorEmail;
		this.empAssmtRcdId = empAssmtRcdId;
		this.assesseeId = assesseeId;
		this.assesseeEmail = assesseeEmail;
	}
	public String getAssmtId() {
		return assmtId;
	}
	public void setAssmtId(String assmtId) {
		this.assmtId = assmtId;
	}
	public String getAssmtName() {
		return assmtName;
	}
	public void setAssmtName(String assmtName) {
		this.assmtName = assmtName;
	}
	public String getIntervalValue() {
		return intervalValue;
	}
	public void setIntervalValue(String intervalValue) {
		this.intervalValue = intervalValue;
	}
	public String getAssmtDes() {
		return assmtDes;
	}
	public void setAssmtDes(String assmtDes) {
		this.assmtDes = assmtDes;
	}
	public String getAssmtStatus() {
		return assmtStatus;
	}
	public void setAssmtStatus(String assmtStatus) {
		this.assmtStatus = assmtStatus;
	}
	public String getAssmtDtlRcdId() {
		return assmtDtlRcdId;
	}
	public void setAssmtDtlRcdId(String assmtDtlRcdId) {
		this.assmtDtlRcdId = assmtDtlRcdId;
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
	public String getAssmtDtlCompletedDate() {
		return assmtDtlCompletedDate;
	}
	public void setAssmtDtlCompletedDate(String assmtDtlCompletedDate) {
		this.assmtDtlCompletedDate = assmtDtlCompletedDate;
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
	public String getAssmtDtlStatus() {
		return assmtDtlStatus;
	}
	public void setAssmtDtlStatus(String assmtDtlStatus) {
		this.assmtDtlStatus = assmtDtlStatus;
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
	
	
	

}
