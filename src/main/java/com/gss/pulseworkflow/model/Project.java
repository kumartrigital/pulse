package com.gss.pulseworkflow.model;

import java.util.List;

public class Project {
	private List<EmpProjectNotes> projectNoteHistory;
	private String status;
	private String strategicGoalId;
	private List<String> projectIds;

	public List<String> getProjectIds() {
		return projectIds;
	}

	public void setProjectIds(List<String> projectIds) {
		this.projectIds = projectIds;
	}

	public Project(String strategicGoalId, List<String> projectIds, List<ProGoal> goals, String comment, long rcdId,
			String projectId, String projectName, String projectDescription, String startDate, String endDate,
			String customer, String createdDate, String creatorId, String statusId, List<String> goalIds,
			List<String> removedGoals) {
		super();
		this.strategicGoalId = strategicGoalId;
		this.projectIds = projectIds;
		this.goals = goals;
		this.comment = comment;
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.createdDate = createdDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.goalIds = goalIds;
		this.removedGoals = removedGoals;
	}

	public String getStrategicGoalId() {
		return strategicGoalId;
	}

	public void setStrategicGoalId(String strategicGoalId) {
		this.strategicGoalId = strategicGoalId;
	}

	private List<ProGoal> goals;

	public Project(String strategicGoalId, List<ProGoal> goals, String comment, long rcdId, String projectId,
			String projectName, String projectDescription, String startDate, String endDate, String customer,
			String createdDate, String creatorId, String statusId, List<String> goalIds, List<String> removedGoals) {
		super();
		this.strategicGoalId = strategicGoalId;
		this.goals = goals;
		this.comment = comment;
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.createdDate = createdDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.goalIds = goalIds;
		this.removedGoals = removedGoals;
	}

	private String comment;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Project(List<ProGoal> goals, String comment, long rcdId, String projectId, String projectName,
			String projectDescription, String startDate, String endDate, String customer, String createdDate,
			String creatorId, String statusId, List<String> goalIds, List<String> removedGoals) {
		super();
		this.goals = goals;
		this.comment = comment;
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.createdDate = createdDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.goalIds = goalIds;
		this.removedGoals = removedGoals;
	}

	public Project(List<ProGoal> goals, long rcdId, String projectId, String projectName, String projectDescription,
			String startDate, String endDate, String customer, String createdDate, String creatorId, String statusId,
			List<String> goalIds) {
		super();
		this.goals = goals;
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.createdDate = createdDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.goalIds = goalIds;
	}

	public List<ProGoal> getGoals() {
		return goals;
	}

	public void setGoals(List<ProGoal> goals) {
		this.goals = goals;
	}

	private long rcdId;

	public long getRcdId() {
		return rcdId;
	}

	public void setRcdId(long rcdId) {
		this.rcdId = rcdId;
	}

	public Project(long rcdId, String projectId, String projectName, String projectDescription, String startDate,
			String endDate, String customer, String createdDate, String creatorId, String statusId,
			List<String> goalIds) {
		super();
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.createdDate = createdDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.goalIds = goalIds;
	}

	private String projectId;
	private String projectName;
	private String projectDescription;
	private String startDate;
	private String endDate;
	private String customer;
	private String createdDate;
	private String creatorId;
	private String statusId;
	private List<String> goalIds;
	private List<String> removedGoals;

	public Project(List<ProGoal> goals, long rcdId, String projectId, String projectName, String projectDescription,
			String startDate, String endDate, String customer, String createdDate, String creatorId, String statusId,
			List<String> goalIds, List<String> removedGoals) {
		super();
		this.goals = goals;
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.createdDate = createdDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.goalIds = goalIds;
		this.removedGoals = removedGoals;
	}

	public List<String> getRemovedGoals() {
		return removedGoals;
	}

	public void setRemovedGoals(List<String> removedGoals) {
		this.removedGoals = removedGoals;
	}

	@Override
	public String toString() {
		return "Project [projectNoteHistory=" + projectNoteHistory + ", status=" + status + ", strategicGoalId="
				+ strategicGoalId + ", projectIds=" + projectIds + ", goals=" + goals + ", comment=" + comment
				+ ", rcdId=" + rcdId + ", projectId=" + projectId + ", projectName=" + projectName
				+ ", projectDescription=" + projectDescription + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", customer=" + customer + ", createdDate=" + createdDate + ", creatorId=" + creatorId + ", statusId="
				+ statusId + ", goalIds=" + goalIds + ", removedGoals=" + removedGoals + "]";
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

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
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

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

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

	public List<String> getGoalIds() {
		return goalIds;
	}

	public void setGoalIds(List<String> goalIds) {
		this.goalIds = goalIds;
	}

	public Project(long rcdId, String projectId, String projectName, String startDate, String endDate, String customer,
			String projectDescription, String statusId, String creatorId) {
		super();
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.creatorId = creatorId;
		this.statusId = statusId;
	}
	
	public Project(long rcdId, String projectId, String projectName, String startDate, String endDate, String customer,
			String projectDescription, String statusId,String status, String creatorId) {
		super();
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.status = status;
	}

	public Project() {
		super();

	}

	public List<EmpProjectNotes> getProjectNoteHistory() {
		return projectNoteHistory;
	}

	public void setProjectNoteHistory(List<EmpProjectNotes> projectNoteHistory) {
		this.projectNoteHistory = projectNoteHistory;
	}

	public Project(List<EmpProjectNotes> projectNoteHistory, String strategicGoalId, List<String> projectIds,
			List<ProGoal> goals, String comment, long rcdId, String projectId, String projectName,
			String projectDescription, String startDate, String endDate, String customer, String createdDate,
			String creatorId, String statusId, List<String> goalIds, List<String> removedGoals) {
		super();
		this.projectNoteHistory = projectNoteHistory;
		this.strategicGoalId = strategicGoalId;
		this.projectIds = projectIds;
		this.goals = goals;
		this.comment = comment;
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.createdDate = createdDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.goalIds = goalIds;
		this.removedGoals = removedGoals;
	}

	public Project(List<EmpProjectNotes> projectNoteHistory, String status, String strategicGoalId,
			List<String> projectIds, List<ProGoal> goals, String comment, long rcdId, String projectId,
			String projectName, String projectDescription, String startDate, String endDate, String customer,
			String createdDate, String creatorId, String statusId, List<String> goalIds, List<String> removedGoals) {
		super();
		this.projectNoteHistory = projectNoteHistory;
		this.status = status;
		this.strategicGoalId = strategicGoalId;
		this.projectIds = projectIds;
		this.goals = goals;
		this.comment = comment;
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customer = customer;
		this.createdDate = createdDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.goalIds = goalIds;
		this.removedGoals = removedGoals;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
