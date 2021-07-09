package com.gss.pulseworkflow.model;

import java.util.List;

public class EmpAccessRole {
	
	private String empId;
	private List<Long> userRoleIds;
	private List<UserRoles> empRoles;
	
	public List<UserRoles> getEmpRoles() {
		return empRoles;
	}
	public void setEmpRoles(List<UserRoles> empRoles) {
		this.empRoles = empRoles;
	}
	public EmpAccessRole(String empId, List<Long> userRoleIds) {
		super();
		this.empId = empId;
		this.userRoleIds = userRoleIds;
	}
	public EmpAccessRole() {
		super();
		
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public List<Long> getUserRoleIds() {
		return userRoleIds;
	}
	public void setUserRoleIds(List<Long> userRoleIds) {
		this.userRoleIds = userRoleIds;
	}
	@Override
	public String toString() {
		return "EmpAccessRole [empId=" + empId + ", userRoleIds=" + userRoleIds + "]";
	}
	

}
