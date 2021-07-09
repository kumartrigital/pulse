package com.gss.pulseworkflow.model;

public class EmpAssessee {

	private String assmtId;
	private String assmtName;
	private String assmtInterval;
	private String assmtSummary;
	private String assmtDes;
	private String assmtDtlStatus;
	private String empAssmtRcdId;
	private String assesseeId;
	private String assesseeEmail;
	private String empAssmtStatusId;
	private String empAssmtStatusValue;
	
	
	public String getAssmtId() {
		return assmtId;
	}

	public void setAssmtId(String assmtId) {
		this.assmtId = assmtId;
	}

	public String getAssmtName() {
		return assmtName;
	}

	public void setAssmtName(String assmtName) {
		this.assmtName = assmtName;
	}

	public String getAssmtInterval() {
		return assmtInterval;
	}

	public void setAssmtInterval(String assmtInterval) {
		this.assmtInterval = assmtInterval;
	}

	public String getAssmtSummary() {
		return assmtSummary;
	}

	public void setAssmtSummary(String assmtSummary) {
		this.assmtSummary = assmtSummary;
	}

	public String getAssmtDes() {
		return assmtDes;
	}

	public void setAssmtDes(String assmtDes) {
		this.assmtDes = assmtDes;
	}

	public String getAssmtDtlStatus() {
		return assmtDtlStatus;
	}

	public void setAssmtDtlStatus(String assmtDtlStatus) {
		this.assmtDtlStatus = assmtDtlStatus;
	}

	public String getEmpAssmtRcdId() {
		return empAssmtRcdId;
	}

	public void setEmpAssmtRcdId(String empAssmtRcdId) {
		this.empAssmtRcdId = empAssmtRcdId;
	}

	public String getAssesseeId() {
		return assesseeId;
	}

	public void setAssesseeId(String assesseeId) {
		this.assesseeId = assesseeId;
	}

	public String getAssesseeEmail() {
		return assesseeEmail;
	}

	public void setAssesseeEmail(String assesseeEmail) {
		this.assesseeEmail = assesseeEmail;
	}

	public String getEmpAssmtStatusId() {
		return empAssmtStatusId;
	}

	public void setEmpAssmtStatusId(String empAssmtStatusId) {
		this.empAssmtStatusId = empAssmtStatusId;
	}

	public String getEmpAssmtStatusValue() {
		return empAssmtStatusValue;
	}

	public void setEmpAssmtStatusValue(String empAssmtStatusValue) {
		this.empAssmtStatusValue = empAssmtStatusValue;
	}

	public EmpAssessee(String assmtId, String assmtName, String assmtInterval, String assmtSummary, String assmtDes,
			String assmtDtlStatus, String empAssmtRcdId, String assesseeId, String assesseeEmail,
			String empAssmtStatusId, String empAssmtStatusValue) {
		super();
		this.assmtId = assmtId;
		this.assmtName = assmtName;
		this.assmtInterval = assmtInterval;
		this.assmtSummary = assmtSummary;
		this.assmtDes = assmtDes;
		this.assmtDtlStatus = assmtDtlStatus;
		this.empAssmtRcdId = empAssmtRcdId;
		this.assesseeId = assesseeId;
		this.assesseeEmail = assesseeEmail;
		this.empAssmtStatusId = empAssmtStatusId;
		this.empAssmtStatusValue = empAssmtStatusValue;
	}
	
	public EmpAssessee() {
		super();
		
	}

	
	
	
	
	
	
}
