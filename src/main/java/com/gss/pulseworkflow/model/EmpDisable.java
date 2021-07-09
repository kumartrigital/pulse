package com.gss.pulseworkflow.model;

import java.io.Serializable;

public class EmpDisable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long rcdId;
	private String employeeId;
	private String lastWorkingDate;
	public EmpDisable(long rcdId, String employeeId, String lastWorkingDate) {
		super();
		this.rcdId = rcdId;
		this.employeeId = employeeId;
		this.lastWorkingDate = lastWorkingDate;
	}
	public long getRcdId() {
		return rcdId;
	}
	public void setRcdId(long rcdId) {
		this.rcdId = rcdId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastWorkingDate() {
		return lastWorkingDate;
	}
	public void setLastWorkingDate(String lastWorkingDate) {
		this.lastWorkingDate = lastWorkingDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "EmpDisable [rcdId=" + rcdId + ", employeeId=" + employeeId + ", lastWorkingDate=" + lastWorkingDate
				+ "]";
	}
	
	public EmpDisable() {
		super();
		
	}
	
	

}
