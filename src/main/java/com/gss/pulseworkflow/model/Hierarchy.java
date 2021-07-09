package com.gss.pulseworkflow.model;

public class Hierarchy {
	private String empId;
	private String empFirstName;
	private String empLastName;
	private String empEmailID;
	private String projectReporManagerId;
	private String projectRepoManagerName;
	private String projectPositionId;
	private String projectPostionValue;
	private String assignedById;
	private String assignedByName;
	private String projectAllocation;
	private long projectStatusID;
	private String projectStatusValue;
	
	public long getProjectStatusID() {
		return projectStatusID;
	}
	public void setProjectStatusID(long projectStatusID) {
		this.projectStatusID = projectStatusID;
	}
	public String getProjectStatusValue() {
		return projectStatusValue;
	}
	public void setProjectStatusValue(String projectStatusValue) {
		this.projectStatusValue = projectStatusValue;
	}
	public String getProjectAllocation() {
		return projectAllocation;
	}
	public void setProjectAllocation(String projectAllocation) {
		this.projectAllocation = projectAllocation;
	}
	public String getEmpEmailID() {
		return empEmailID;
	}
	public void setEmpEmailID(String empEmailID) {
		this.empEmailID = empEmailID;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getProjectReporManagerId() {
		return projectReporManagerId;
	}
	public void setProjectReporManagerId(String projectReporManagerId) {
		this.projectReporManagerId = projectReporManagerId;
	}
	public String getProjectRepoManagerName() {
		return projectRepoManagerName;
	}
	public void setProjectRepoManagerName(String projectRepoManagerName) {
		this.projectRepoManagerName = projectRepoManagerName;
	}
	public String getProjectPositionId() {
		return projectPositionId;
	}
	public void setProjectPositionId(String projectPositionId) {
		this.projectPositionId = projectPositionId;
	}
	public String getProjectPostionValue() {
		return projectPostionValue;
	}
	public void setProjectPostionValue(String projectPostionValue) {
		this.projectPostionValue = projectPostionValue;
	}
	public String getAssignedById() {
		return assignedById;
	}
	public void setAssignedById(String assignedById) {
		this.assignedById = assignedById;
	}
	public String getAssignedByName() {
		return assignedByName;
	}
	public void setAssignedByName(String assignedByName) {
		this.assignedByName = assignedByName;
	}
	public Hierarchy(String empId, String empFirstName,String empLastName,String empEmailID, String projectReporManagerId, String projectRepoManagerName,
			String projectPositionId, String projectPostionValue, String assignedById, String assignedByName,String projectAllocation,long projectStatusID,String projectStatusValue) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmailID = empEmailID;
		this.projectReporManagerId = projectReporManagerId;
		this.projectRepoManagerName = projectRepoManagerName;
		this.projectPositionId = projectPositionId;
		this.projectPostionValue = projectPostionValue;
		this.assignedById = assignedById;
		this.assignedByName = assignedByName;
		this.projectAllocation = projectAllocation;
		this.projectStatusID = projectStatusID;
		this.projectStatusValue = projectStatusValue;
	}
	@Override
	public String toString() {
		return "Hierarchy [empId=" + empId + ", empFirstName=" + empFirstName + ", projectReporManagerId="
				+ projectReporManagerId + ", projectRepoManagerName=" + projectRepoManagerName + ", projectPositionId="
				+ projectPositionId + ", projectPostionValue=" + projectPostionValue + ", assignedById=" + assignedById
				+ ", assignedByName=" + assignedByName + "]";
	}
	public Hierarchy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hierarchy(String empId, String projectReporManagerId,
			String empFirstName, String empLastName,String empEmailID,String projectRepoManagerName,String projectAllocation) {
		super();
		this.empId = empId;
		this.projectReporManagerId = projectReporManagerId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmailID = empEmailID;
		this.projectRepoManagerName = projectRepoManagerName;
		this.projectAllocation = projectAllocation;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	

}
