package com.gss.pulseworkflow.model;

import java.util.List;

public class EmpAssmtDetail {
	
	private String dtlRcdId;
	private String assmtId;
	private String assessor;
	private String projectId;
	private String empAssmtRcdId;
	private String assessee;
	private String assesseeRole;
	private List<String> assesseeCapabilitoes;
	
	public EmpAssmtDetail() {
		super();
	}
	@Override
	public String toString() {
		return "EmpAssmtDetail [dtlRcdId=" + dtlRcdId + ", assmtId=" + assmtId + ", assessor=" + assessor
				+ ", projectId=" + projectId + ", empAssmtRcdId=" + empAssmtRcdId + ", assessee=" + assessee
				+ ", assesseeRole=" + assesseeRole + ", assesseeCapabilitoes=" + assesseeCapabilitoes + "]";
	}
	
	
	
	public List<String> getAssesseeCapabilitoes() {
		return assesseeCapabilitoes;
	}
	public void setAssesseeCapabilitoes(List<String> assesseeCapabilitoes) {
		this.assesseeCapabilitoes = assesseeCapabilitoes;
	}
	public String getDtlRcdId() {
		return dtlRcdId;
	}
	public void setDtlRcdId(String dtlRcdId) {
		this.dtlRcdId = dtlRcdId;
	}
	public String getAssmtId() {
		return assmtId;
	}
	public void setAssmtId(String assmtId) {
		this.assmtId = assmtId;
	}
	public String getAssessor() {
		return assessor;
	}
	public void setAssessor(String assessor) {
		this.assessor = assessor;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getEmpAssmtRcdId() {
		return empAssmtRcdId;
	}
	public void setEmpAssmtRcdId(String empAssmtRcdId) {
		this.empAssmtRcdId = empAssmtRcdId;
	}
	public String getAssessee() {
		return assessee;
	}
	public void setAssessee(String assessee) {
		this.assessee = assessee;
	}
	public String getAssesseeRole() {
		return assesseeRole;
	}
	public void setAssesseeRole(String assesseeRole) {
		this.assesseeRole = assesseeRole;
	}
	public EmpAssmtDetail(String dtlRcdId, String assmtId, String assessor, String projectId, String empAssmtRcdId,
			String assessee, String assesseeRole) {
		super();
		this.dtlRcdId = dtlRcdId;
		this.assmtId = assmtId;
		this.assessor = assessor;
		this.projectId = projectId;
		this.empAssmtRcdId = empAssmtRcdId;
		this.assessee = assessee;
		this.assesseeRole = assesseeRole;
	}
	
	
	

}
