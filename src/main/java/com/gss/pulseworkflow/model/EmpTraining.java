package com.gss.pulseworkflow.model;

import java.util.List;

public class EmpTraining {
	private long rcdId;
	private List<String> employeeIds;
	private String trainingId;
	private String assignedDate;
	private String dueDate;
	private String creatorId;
	private String statusId;
	private String lastUpdatedDate;
	private String status;
	private String trainingName;
	private String comments;
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTrngDes() {
		return trngDes;
	}

	public void setTrngDes(String trngDes) {
		this.trngDes = trngDes;
	}
	private String empId;
	private String trngDes;
	
	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public EmpTraining(long rcdId, List<String> employeeIds, String trainingId, String assignedDate, String dueDate,
			String creatorId, String statusId, String lastUpdatedDate, String status, String trainingName) {
		super();
		this.rcdId = rcdId;
		this.employeeIds = employeeIds;
		this.trainingId = trainingId;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.status = status;
		this.trainingName = trainingName;
	}

	public EmpTraining(long rcdId, List<String> employeeIds, String trainingId, String assignedDate, String dueDate,
			String creatorId, String statusId, String lastUpdatedDate, String status) {
		super();
		this.rcdId = rcdId;
		this.employeeIds = employeeIds;
		this.trainingId = trainingId;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.status = status;
	}
	
	public EmpTraining(long rcdId,String trainingId,String trainingName,String trngDes, String assignedDate, String dueDate,
			String creatorId, String lastUpdatedDate,String comments,String status,String empId,String statusId) {
		super();
		this.rcdId = rcdId;
		this.trainingId = trainingId;
		this.trainingName = trainingName;
		this.trngDes = trngDes;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
		this.creatorId = creatorId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.comments = comments;
		this.status = status;
		this.empId = empId;
		this.statusId = statusId;
	}
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public EmpTraining(long rcdId, List<String> employeeIds, String trainingId, String assignedDate, String dueDate,
			String creatorId, String statusId, String lastUpdatedDate, String status, String trainingName,
			String empId) {
		super();
		this.rcdId = rcdId;
		this.employeeIds = employeeIds;
		this.trainingId = trainingId;
		this.assignedDate = assignedDate;
		this.dueDate = dueDate;
		this.creatorId = creatorId;
		this.statusId = statusId;
		this.lastUpdatedDate = lastUpdatedDate;
		this.status = status;
		this.trainingName = trainingName;
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "EmpTraining [rcdId=" + rcdId + ", employeeIds=" + employeeIds + ", trainingId=" + trainingId
				+ ", assignedDate=" + assignedDate + ", dueDate=" + dueDate + ", creatorId=" + creatorId + ", statusId="
				+ statusId + ", lastUpdatedDate=" + lastUpdatedDate + ", status=" + status + ", trainingName="
				+ trainingName + ", comments=" + comments + ", empId=" + empId + ", trngDes=" + trngDes + "]";
	}
	
	public EmpTraining() {
		super();
		
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
	public String getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}
	public String getAssignedDate() {
		return assignedDate;
	}
	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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
