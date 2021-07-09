package com.gss.pulseworkflow.model;

public class EmpHierarchy {
	private String empId;
	private String empEmail;
	private String empFirstName;
	private String empLastName;
	private String managerId;
	private String managerFirstName;
	private String managerLastName;
	private Object nextHierachy;
	public EmpHierarchy(String empId, String empEmail, String empFirstName, String empLastName, String managerId,
			String managerFirstName, String managerLastName) {
		super();
		this.empId = empId;
		this.empEmail = empEmail;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.managerId = managerId;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
	}
	public EmpHierarchy(String empId, String empEmail, String empFirstName, String empLastName, String managerId,
			String managerFirstName, String managerLastName,Object nextHierachy) {
		super();
		this.empId = empId;
		this.empEmail = empEmail;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.managerId = managerId;
		this.managerFirstName = managerFirstName;
		this.managerLastName = managerLastName;
		this.nextHierachy=nextHierachy;
	}
	public EmpHierarchy() {
		super();
		
	}
	public Object getNextHierachy() {
		return nextHierachy;
	}
	public void setNextHierachy(Object nextHierachy) {
		this.nextHierachy = nextHierachy;
	}
	@Override
	public String toString() {
		return "EmpHierarchy [empId=" + empId + ", empEmail=" + empEmail + ", empFirstName=" + empFirstName
				+ ", empLastName=" + empLastName + ", managerId=" + managerId + ", managerFirstName=" + managerFirstName
				+ ", managerLastName=" + managerLastName + ", nextHierachy=" + nextHierachy + "]";
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
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerFirstName() {
		return managerFirstName;
	}
	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}
	public String getManagerLastName() {
		return managerLastName;
	}
	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}
	
	

}
