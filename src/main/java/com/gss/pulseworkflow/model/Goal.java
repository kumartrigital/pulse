package com.gss.pulseworkflow.model;

public class Goal {
	private long goalId;
	private String goalIntervalId;
	private String goalTypeId;
	private String goalName;
	private String goalDes;
	private String goalStatusId;
	private String goalStartDate;
	private String goalEndDate;
	private String goalCreatorId;
	private String comment;
	private String intervalName;
	private String status;
	private String creatorEmail;
	private String createdDate;
	
	
	
	
	public String getIntervalName() {
		return intervalName;
	}

	public void setIntervalName(String intervalName) {
		this.intervalName = intervalName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatorEmail() {
		return creatorEmail;
	}

	public void setCreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Goal(long goalId, String goalIntervalId,String intervalName, String goalTypeId, String goalDes,
			 String goalName,String goalStatusId,String status,String goalCreatorId,String creatorEmail,
			 String goalStartDate, String goalEndDate,String createdDate) {
		super();
		this.goalId = goalId;
		this.goalIntervalId = goalIntervalId;
		this.intervalName=intervalName;
		this.goalTypeId = goalTypeId;
		this.goalDes = goalDes;
		this.goalName = goalName;
		this.goalStatusId = goalStatusId;
		this.status=status;
		this.goalCreatorId=goalCreatorId;
		this.creatorEmail=creatorEmail;
		this.goalStartDate = goalStartDate;
		this.goalEndDate = goalEndDate;
		this.createdDate = createdDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getGoalId() {
		return goalId;
	}

	public void setGoalId(long goalId) {
		this.goalId = goalId;
	}

	public String getGoalIntervalId() {
		return goalIntervalId;
	}

	public void setGoalIntervalId(String goalIntervalId) {
		this.goalIntervalId = goalIntervalId;
	}

	public String getGoalTypeId() {
		return goalTypeId;
	}

	public void setGoalTypeId(String goalTypeId) {
		this.goalTypeId = goalTypeId;
	}

	public String getGoalName() {
		return goalName;
	}

	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}

	public String getGoalDes() {
		return goalDes;
	}

	public void setGoalDes(String goalDes) {
		this.goalDes = goalDes;
	}

	public String getGoalStatusId() {
		return goalStatusId;
	}

	public void setGoalStatusId(String goalStatusId) {
		this.goalStatusId = goalStatusId;
	}

	public String getGoalStartDate() {
		return goalStartDate;
	}

	public void setGoalStartDate(String goalStartDate) {
		this.goalStartDate = goalStartDate;
	}

	public String getGoalEndDate() {
		return goalEndDate;
	}

	public void setGoalEndDate(String goalEndDate) {
		this.goalEndDate = goalEndDate;
	}

	public String getGoalCreatorId() {
		return goalCreatorId;
	}

	public void setGoalCreatorId(String goalCreatorId) {
		this.goalCreatorId = goalCreatorId;
	}

	public Goal(long goalId, String goalIntervalId, String goalTypeId, String goalName, String goalDes,
			String goalStatusId, String goalStartDate, String goalEndDate, String goalCreatorId) {
		super();
		this.goalId = goalId;
		this.goalIntervalId = goalIntervalId;
		this.goalTypeId = goalTypeId;
		this.goalName = goalName;
		this.goalDes = goalDes;
		this.goalStatusId = goalStatusId;
		this.goalStartDate = goalStartDate;
		this.goalEndDate = goalEndDate;
		this.goalCreatorId = goalCreatorId;
	}

	@Override
	public String toString() {
		return "Goal [goalId=" + goalId + ", goalIntervalId=" + goalIntervalId + ", goalTypeId=" + goalTypeId
				+ ", goalName=" + goalName + ", goalDes=" + goalDes + ", goalStatusId=" + goalStatusId
				+ ", goalStartDate=" + goalStartDate + ", goalEndDate=" + goalEndDate + ", goalCreatorId="
				+ goalCreatorId + ", comment=" + comment + "]";
	}

	public Goal() {
		super();

	}

}
