package com.gss.pulseworkflow.model;

import java.util.List;

public class EmployeeSearchResponse {
	
	private Employee employee;
	private List<UserSkills> userSkills;
	private String avgRating;
	private List<Utilization> utilization;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<UserSkills> getUserSkills() {
		return userSkills;
	}
	public void setUserSkills(List<UserSkills> userSkills) {
		this.userSkills = userSkills;
	}
	public String getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(String avgRating) {
		this.avgRating = avgRating;
	}
	public List<Utilization> getUtilization() {
		return utilization;
	}
	public void setUtilization(List<Utilization> utilization) {
		this.utilization = utilization;
	}
	public EmployeeSearchResponse(Employee employee, List<UserSkills> userSkills, String avgRating,
			List<Utilization> utilization) {
		super();
		this.employee = employee;
		this.userSkills = userSkills;
		this.avgRating = avgRating;
		this.utilization = utilization;
	}
	public EmployeeSearchResponse() {
		super();
	}
	
	

}
