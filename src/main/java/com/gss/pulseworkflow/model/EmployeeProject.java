package com.gss.pulseworkflow.model;

public class EmployeeProject {
	private String projectId;
	private String projectName;
	private String projStartDate;
	private String projEndDate;
	private String projRole;
	private String reportingManagerFN;
	private String reportingManagerLN;
	private String reportingManagerEmail;
	private String projUtilization;
	public EmployeeProject(String projectId, String projectName, String projStartDate, String projEndDate, String projRole,
			String reportingManagerFN, String reportingManagerLN, String reportingManagerEmail,
			String projUtilization) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projStartDate = projStartDate;
		this.projEndDate = projEndDate;
		this.projRole = projRole;
		this.reportingManagerFN = reportingManagerFN;
		this.reportingManagerLN = reportingManagerLN;
		this.reportingManagerEmail = reportingManagerEmail;
		this.projUtilization = projUtilization;
	}
	
	public EmployeeProject() {
		super();
		
	}
	@Override
	public String toString() {
		return "EmployeeProject [projectId=" + projectId + ", projectName=" + projectName + ", projStartDate="
				+ projStartDate + ", projEndDate=" + projEndDate + ", projRole=" + projRole + ", reportingManagerFN="
				+ reportingManagerFN + ", reportingManagerLN=" + reportingManagerLN + ", reportingManagerEmail="
				+ reportingManagerEmail + ", projUtilization=" + projUtilization + "]";
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
	public String getProjStartDate() {
		return projStartDate;
	}
	public void setProjStartDate(String projStartDate) {
		this.projStartDate = projStartDate;
	}
	public String getProjEndDate() {
		return projEndDate;
	}
	public void setProjEndDate(String projEndDate) {
		this.projEndDate = projEndDate;
	}
	public String getProjRole() {
		return projRole;
	}
	public void setProjRole(String projRole) {
		this.projRole = projRole;
	}
	public String getReportingManagerFN() {
		return reportingManagerFN;
	}
	public void setReportingManagerFN(String reportingManagerFN) {
		this.reportingManagerFN = reportingManagerFN;
	}
	public String getReportingManagerLN() {
		return reportingManagerLN;
	}
	public void setReportingManagerLN(String reportingManagerLN) {
		this.reportingManagerLN = reportingManagerLN;
	}
	public String getReportingManagerEmail() {
		return reportingManagerEmail;
	}
	public void setReportingManagerEmail(String reportingManagerEmail) {
		this.reportingManagerEmail = reportingManagerEmail;
	}
	public String getProjUtilization() {
		return projUtilization;
	}
	public void setProjUtilization(String projUtilization) {
		this.projUtilization = projUtilization;
	}
	
	
	
	
	
	

}
