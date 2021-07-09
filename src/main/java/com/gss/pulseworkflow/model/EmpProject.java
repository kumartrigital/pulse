package com.gss.pulseworkflow.model;

import java.util.List;

public class EmpProject {
	private List<String> empIds;
	private String proId;
	private String projAssignedDate;
	private String proStartDate;
	private String proEndDate;
	private String proUtlPer;
	private String proRepMgrId;
	private String proEmpstatus;
	private String positionId;
	private String positionDes;
	private long rcdId;
	private String empId;
	private String empEmail;
	private String projectName;
	private String assignedBy;
	private String proRepMgrEmail;
	private String positionName;
	private String proEmpstatusValue;
	private String lastUpdatedDate;
	public EmpProject(long rcdId,String empId, String empEmail,String proId, String projectName, String projAssignedDate,
			 String assignedBy,String proStartDate,String proEndDate, String proUtlPer, String proRepMgrId,  String positionId,
			 String positionName, String proEmpstatus,String proEmpstatusValue, String lastUpdatedDate) {
		super();
		this.proId = proId;
		this.projAssignedDate = projAssignedDate;
		this.proStartDate = proStartDate;
		this.proEndDate = proEndDate;
		this.proUtlPer = proUtlPer;
		this.proRepMgrId = proRepMgrId;
		this.proEmpstatus = proEmpstatus;
		this.positionId = positionId;
		this.rcdId = rcdId;
		this.empId = empId;
		this.empEmail = empEmail;
		this.projectName = projectName;
		this.assignedBy = assignedBy;
		this.positionName = positionName;
		this.proEmpstatusValue = proEmpstatusValue;
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public long getRcdId() {
		return rcdId;
	}
	public void setRcdId(long rcdId) {
		this.rcdId = rcdId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	public String getProRepMgrEmail() {
		return proRepMgrEmail;
	}
	public void setProRepMgrEmail(String proRepMgrEmail) {
		this.proRepMgrEmail = proRepMgrEmail;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public String getProEmpstatusValue() {
		return proEmpstatusValue;
	}
	public void setProEmpstatusValue(String proEmpstatusValue) {
		this.proEmpstatusValue = proEmpstatusValue;
	}
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getPositionId() {
		return positionId;
	}
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}
	public String getPositionDes() {
		return positionDes;
	}
	public void setPositionDes(String positionDes) {
		this.positionDes = positionDes;
	}
	public EmpProject(List<String> empIds, String proId, String projAssignedDate, String proStartDate, String proEndDate,
			String proUtlPer, String proRepMgrId, String proEmpstatus, String positionId, String positionDes) {
		super();
		this.empIds = empIds;
		this.proId = proId;
		this.projAssignedDate = projAssignedDate;
		this.proStartDate = proStartDate;
		this.proEndDate = proEndDate;
		this.proUtlPer = proUtlPer;
		this.proRepMgrId = proRepMgrId;
		this.proEmpstatus = proEmpstatus;
		this.positionId = positionId;
		this.positionDes = positionDes;
	}
	public EmpProject(String empId, String proId, String projAssignedDate, String proStartDate, String proEndDate,
			String proUtlPer, String proRepMgrId, String proEmpstatus) {
		super();
		this.empIds = empIds;
		this.proId = proId;
		this.projAssignedDate = projAssignedDate;
		this.proStartDate = proStartDate;
		this.proEndDate = proEndDate;
		this.proUtlPer = proUtlPer;
		this.proRepMgrId = proRepMgrId;
		this.proEmpstatus = proEmpstatus;
	}
	public List<String> getEmpIds() {
		return empIds;
	}
	public void setEmpIds(List<String> empIds) {
		this.empIds = empIds;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProjAssignedDate() {
		return projAssignedDate;
	}
	public void setProjAssignedDate(String projAssignedDate) {
		this.projAssignedDate = projAssignedDate;
	}
	public String getProStartDate() {
		return proStartDate;
	}
	public void setProStartDate(String proStartDate) {
		this.proStartDate = proStartDate;
	}
	public String getProEndDate() {
		return proEndDate;
	}
	public void setProEndDate(String proEndDate) {
		this.proEndDate = proEndDate;
	}
	public String getProUtlPer() {
		return proUtlPer;
	}
	public void setProUtlPer(String proUtlPer) {
		this.proUtlPer = proUtlPer;
	}
	public String getProRepMgrId() {
		return proRepMgrId;
	}
	public void setProRepMgrId(String proRepMgrId) {
		this.proRepMgrId = proRepMgrId;
	}
	public String getProEmpstatus() {
		return proEmpstatus;
	}
	public void setProEmpstatus(String proEmpstatus) {
		this.proEmpstatus = proEmpstatus;
	}
	public EmpProject() {
		super();
		
	}
	@Override
	public String toString() {
		return "EmpProject [empIds=" + empIds + ", proId=" + proId + ", projAssignedDate=" + projAssignedDate
				+ ", proStartDate=" + proStartDate + ", proEndDate=" + proEndDate + ", proUtlPer=" + proUtlPer
				+ ", proRepMgrId=" + proRepMgrId + ", proEmpstatus=" + proEmpstatus + ", positionId=" + positionId
				+ ", positionDes=" + positionDes + ", rcdId=" + rcdId + ", empId=" + empId + ", empEmail=" + empEmail
				+ ", projectName=" + projectName + ", assignedBy=" + assignedBy + ", proRepMgrEmail=" + proRepMgrEmail
				+ ", positionName=" + positionName + ", proEmpstatusValue=" + proEmpstatusValue + ", lastUpdatedDate="
				+ lastUpdatedDate + "]";
	}
	public EmpProject(String proId, String projAssignedDate, String proStartDate,
			String proEndDate, String proUtlPer, String proRepMgrId, String proEmpstatus, String positionId,
			long rcdId, String empId, String empEmail, String projectName, String assignedBy,
			String proRepMgrEmail, String positionName, String proEmpstatusValue, String lastUpdatedDate) {
		super();
		this.proId = proId;
		this.projAssignedDate = projAssignedDate;
		this.proStartDate = proStartDate;
		this.proEndDate = proEndDate;
		this.proUtlPer = proUtlPer;
		this.proRepMgrId = proRepMgrId;
		this.proEmpstatus = proEmpstatus;
		this.positionId = positionId;
		this.rcdId = rcdId;
		this.empId = empId;
		this.empEmail = empEmail;
		this.projectName = projectName;
		this.assignedBy = assignedBy;
		this.proRepMgrEmail = proRepMgrEmail;
		this.positionName = positionName;
		this.proEmpstatusValue = proEmpstatusValue;
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	
	
	

}
