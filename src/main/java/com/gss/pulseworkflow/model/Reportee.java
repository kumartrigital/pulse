package com.gss.pulseworkflow.model;

import java.util.List;

public class Reportee {
	private String empId;
	private String empFirstName;
	private String empMiddleName;
	private String empLastName;
	private String empEmail;
	private String positionName;
	//private String costToCompany;
	private String utilization;
	
	public String getUtilization() {
		return utilization;
	}

	public void setUtilization(String utilization) {
		this.utilization = utilization;
	}
	private List<Rating> rating;
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/*
	 * public String getCostToCompany() { return costToCompany; }
	 * 
	 * public void setCostToCompany(String costToCompany) { this.costToCompany =
	 * costToCompany; }
	 */

	public Reportee() {
		super();
	}
	
	public Reportee(String empId, String empFirstName, String empMiddleName, String empLastName, String empEmail,
			String positionName, List<Rating> rating) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empMiddleName = empMiddleName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.positionName = positionName;
		//this.costToCompany = costToCompany;
		this.rating = rating;
	}
	public Reportee(String empId, String empFirstName, String empMiddleName, String empLastName, String empEmail,
			String positionName) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empMiddleName = empMiddleName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.positionName = positionName;
		//this.costToCompany = costToCompany;
		//this.rating = rating;
	}

	@Override
	public String toString() {
		return "Reportee [empFirstName=" + empFirstName + ", empMiddleName=" + empMiddleName + ", empLastName="
				+ empLastName + ", empEmail=" + empEmail + ", rating=" + rating + "]";
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpMiddleName() {
		return empMiddleName;
	}
	public void setEmpMiddleName(String empMiddleName) {
		this.empMiddleName = empMiddleName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public List<Rating> getRating() {
		return rating;
	}
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
	
	

}
