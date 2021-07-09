package com.gss.pulseworkflow.model;

public class Milestone {

	private long recId;
	private String goalId;
	private String taskId;
	private String taskDetail;
	private String taskComments;
	private String startDate;
	private String endDate;
	//private String weight;
	//private String projectId;
	private String taskCreatorId;
	private String taskCreatedDate;
	private String taskStatusId;
	public Milestone(long recId, String goalId, String taskId, String taskDetail, String taskComments, String startDate,
			String endDate, String taskCreatorId, String taskCreatedDate,
			String taskStatusId) {
		super();
		this.recId = recId;
		this.goalId = goalId;
		this.taskId = taskId;
		this.taskDetail = taskDetail;
		this.taskComments = taskComments;
		this.startDate = startDate;
		this.endDate = endDate;
		//this.weight = weight;
		//this.projectId = projectId;
		this.taskCreatorId = taskCreatorId;
		this.taskCreatedDate = taskCreatedDate;
		this.taskStatusId = taskStatusId;
	}
	public Milestone(long recId, String goalId, String taskId,String taskDetail,String taskStatusId, String startDate,
			String endDate,String taskComments) {
		super();
		this.recId = recId;
		this.goalId = goalId;
		this.taskId = taskId;
		//this.weight = weight;
		this.taskDetail = taskDetail;
		this.taskStatusId = taskStatusId;
		this.startDate = startDate;
		this.endDate = endDate;
		//this.projectId = projectId;
		this.taskComments = taskComments;
	}
	@Override
	public String toString() {
		return "Milestone [recId=" + recId + ", goalId=" + goalId + ", taskId=" + taskId + ", taskDetail=" + taskDetail
				+ ", taskComments=" + taskComments + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", taskCreatorId=" + taskCreatorId + ", taskCreatedDate=" + taskCreatedDate + ", taskStatusId="
				+ taskStatusId + "]";
	}
	public long getRecId() {
		return recId;
	}
	public void setRecId(long recId) {
		this.recId = recId;
	}
	public String getGoalId() {
		return goalId;
	}
	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskDetail() {
		return taskDetail;
	}
	public void setTaskDetail(String taskDetail) {
		this.taskDetail = taskDetail;
	}
	public String getTaskComments() {
		return taskComments;
	}
	public void setTaskComments(String taskComments) {
		this.taskComments = taskComments;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/*
	 * public String getWeight() { return weight; } public void setWeight(String
	 * weight) { this.weight = weight; } public String getProjectId() { return
	 * projectId; } public void setProjectId(String projectId) { this.projectId =
	 * projectId; }
	 */
	public String getTaskCreatorId() {
		return taskCreatorId;
	}
	public void setTaskCreatorId(String taskCreatorId) {
		this.taskCreatorId = taskCreatorId;
	}
	public String getTaskCreatedDate() {
		return taskCreatedDate;
	}
	public void setTaskCreatedDate(String taskCreatedDate) {
		this.taskCreatedDate = taskCreatedDate;
	}
	public String getTaskStatusId() {
		return taskStatusId;
	}
	public void setTaskStatusId(String taskStatusId) {
		this.taskStatusId = taskStatusId;
	}
	
	public Milestone() {
		super();
		
	}
}
