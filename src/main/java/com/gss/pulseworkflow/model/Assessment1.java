package com.gss.pulseworkflow.model;

public class Assessment1 {
	private long recId;
	private String assessmentName;
	private String assessmentType;
	private String assessProjId;
	private String assesseeId;
	private String initDate;
	private String endDate;
	private String assessmentDes;
	private String assessorsId;
	private String statusId;
	String creatorId;
	
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	
	@Override
	public String toString() {
		return "Assessment [recId=" + recId + ", assessmentName=" + assessmentName + ", assessmentType="
				+ assessmentType + ", assessProjId=" + assessProjId + ", assesseeId=" + assesseeId + ", initDate="
				+ initDate + ", endDate=" + endDate + ", assessmentDes=" + assessmentDes + ", assessorsId="
				+ assessorsId + ", statusId=" + statusId + ", creatorId=" + creatorId + "]";
	}
	public Assessment1(long recId, String assessmentName, String assessmentType, String assessProjId, String assesseeId,
			String initDate, String endDate, String assessmentDes, String assessorsId, String statusId,
			String creatorId) {
		super();
		this.recId = recId;
		this.assessmentName = assessmentName;
		this.assessmentType = assessmentType;
		this.assessProjId = assessProjId;
		this.assesseeId = assesseeId;
		this.initDate = initDate;
		this.endDate = endDate;
		this.assessmentDes = assessmentDes;
		this.assessorsId = assessorsId;
		this.statusId = statusId;
		this.creatorId = creatorId;
	}
	public Assessment1(long recId, String assessmentName, String assessmentType, String assessProjId, String assesseeId,
			String initDate, String endDate, String assessmentDes, String assessorsId, String statusId) {
		// TODO Auto-generated constructor stub
		super();
		this.recId = recId;
		this.assessmentName = assessmentName;
		this.assessmentType = assessmentType;
		this.assessProjId = assessProjId;
		this.assesseeId = assesseeId;
		this.initDate = initDate;
		this.endDate = endDate;
		this.assessmentDes = assessmentDes;
		this.assessorsId = assessorsId;
		this.statusId = statusId;
	}
	public long getRecId() {
		return recId;
	}
	public void setRecId(long recId) {
		this.recId = recId;
	}
	public String getAssessmentName() {
		return assessmentName;
	}
	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}
	public String getAssessmentType() {
		return assessmentType;
	}
	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}
	public String getAssessProjId() {
		return assessProjId;
	}
	public void setAssessProjId(String assessProjId) {
		this.assessProjId = assessProjId;
	}
	public String getAssesseeId() {
		return assesseeId;
	}
	public void setAssesseeId(String assesseeId) {
		this.assesseeId = assesseeId;
	}
	public String getInitDate() {
		return initDate;
	}
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getAssessmentDes() {
		return assessmentDes;
	}
	public void setAssessmentDes(String assessmentDes) {
		this.assessmentDes = assessmentDes;
	}
	public String getAssessorsId() {
		return assessorsId;
	}
	public void setAssessorsId(String assessorsId) {
		this.assessorsId = assessorsId;
	}
	public Assessment1() {
		super();
		
	}
	
}
