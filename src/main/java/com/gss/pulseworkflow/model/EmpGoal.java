package com.gss.pulseworkflow.model;

import java.util.List;

public class EmpGoal {
	private long rcdId;
	private List<String> employeeIds;
	private String goalId;
	private String assignedDate;
	private String creatorId;
	private String statusId;
	private String lastUpdatedDate;
	private String status;
	private String goalName;
	private String goalDes;
	private String startDate;
	private String endDate;
	private String managerId;
	private String managerEmail;
	private String comment;
	private String empEmail;
	private String approverAction;
	
	
    public String getApproverAction() {
		return approverAction;
	}

	public void setApproverAction(String approverAction) {
		this.approverAction = approverAction;
	}

	public EmpGoal(long rcdId, List<String> employeeIds, String goalId, String assignedDate, String creatorId,
			String statusId, String lastUpdatedDate, String status, String goalName, String goalDes, String startDate,
			String endDate, String managerId, String managerEmail, String comment, String empEmail,
			String approverAction) {
		super();
		this.rcdId = rcdId;
		this.employeeIds = employeeIds;
		this.goalId = goalId;
		this.assignedDate = assignedDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.status = status;
		this.goalName = goalName;
		this.goalDes = goalDes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.managerId = managerId;
		this.managerEmail = managerEmail;
		this.comment = comment;
		this.empEmail = empEmail;
		this.approverAction = approverAction;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public EmpGoal(long rcdId, List<String> employeeIds, String goalId, String assignedDate, String creatorId,
			String statusId, String lastUpdatedDate, String status, String goalName, String goalDes, String startDate,
			String endDate, String managerId, String managerEmail, String comment, String empEmail) {
		super();
		this.rcdId = rcdId;
		this.employeeIds = employeeIds;
		this.goalId = goalId;
		this.assignedDate = assignedDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.status = status;
		this.goalName = goalName;
		this.goalDes = goalDes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.managerId = managerId;
		this.managerEmail = managerEmail;
		this.comment = comment;
		this.empEmail = empEmail;
	}

	public EmpGoal(long rcdId, String empId,String empEmail, String goalId,String goalName, String assignedDate, String statusId,String status,
    		String creatorId, String lastUpdatedDate,String comment,String goalDes,String startDate,String endDate) {
		super();
		this.rcdId = rcdId;
		this.empEmail = empEmail;
		this.goalId = goalId;
		this.goalName = goalName;
		this.assignedDate = assignedDate;
		this.statusId = statusId;
		this.status = status;
		this.creatorId = creatorId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.comment = comment;
		this.goalDes = goalDes;
		this.startDate = startDate;
		this.endDate = endDate;
		
		
	}
	
    public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public EmpGoal(long rcdId, List<String> employeeIds, String goalId, String assignedDate, String creatorId,
			String statusId, String lastUpdatedDate, String status, String goalName, String goalDes, String startDate,
			String endDate, String managerId, String managerEmail, String comment) {
		super();
		this.rcdId = rcdId;
		this.employeeIds = employeeIds;
		this.goalId = goalId;
		this.assignedDate = assignedDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.status = status;
		this.goalName = goalName;
		this.goalDes = goalDes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.managerId = managerId;
		this.managerEmail = managerEmail;
		this.comment = comment;
	}
	public EmpGoal(long rcdId, List<String> employeeIds, String goalId, String assignedDate, String creatorId,
			String statusId, String lastUpdatedDate, String status, String goalName, String goalDes, String startDate,
			String endDate, String managerId, String managerEmail) {
		super();
		this.rcdId = rcdId;
		this.employeeIds = employeeIds;
		this.goalId = goalId;
		this.assignedDate = assignedDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.status = status;
		this.goalName = goalName;
		this.goalDes = goalDes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.managerId = managerId;
		this.managerEmail = managerEmail;
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
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public EmpGoal(long rcdId, String empId, String goalId, String assignedDate, String statusId,String status,
    		String creatorId, String lastUpdatedDate,String goalName,String goalDes,String startDate,String endDate,
    		String managerId,String managerEmail,String comment) {
		super();
		this.rcdId = rcdId;
		this.goalId = goalId;
		this.assignedDate = assignedDate;
		this.statusId = statusId;
		this.status = status;
		this.creatorId = creatorId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.goalName = goalName;
		this.goalDes = goalDes;
		this.startDate = startDate;
		this.endDate = endDate;
		this.managerId = managerId;
		this.managerEmail = managerEmail;
		this.comment = comment;
	}
	public EmpGoal(long rcdId, List<String> employeeIds, String goalId, String assignedDate, String creatorId, String statusId,
			String lastUpdatedDate, String status) {
		super();
		this.rcdId = rcdId;
		this.employeeIds = employeeIds;
		this.goalId = goalId;
		this.assignedDate = assignedDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.status = status;
	}
	public EmpGoal() {
		super();
		
	}
	@Override
	public String toString() {
		return "EmpGoal [rcdId=" + rcdId + ", employeeIds=" + employeeIds + ", goalId=" + goalId + ", assignedDate="
				+ assignedDate + ", creatorId=" + creatorId + ", statusId=" + statusId + ", lastUpdatedDate="
				+ lastUpdatedDate + ", status=" + status + ", goalName=" + goalName + ", goalDes=" + goalDes
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", managerId=" + managerId + ", managerEmail="
				+ managerEmail + ", comment=" + comment + ", empEmail=" + empEmail + ", approverAction="
				+ approverAction + "]";
	}
	public long getRcdId() {
		return rcdId;
	}
	public void setRcdId(long rcdId) {
		this.rcdId = rcdId;
	}
	public List<String> getEmployeeIds() {
		return employeeIds;
	}
	public void setEmployeeIds(List<String> employeeIds) {
		this.employeeIds = employeeIds;
	}
	public String getGoalId() {
		return goalId;
	}
	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}
	public String getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
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
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
