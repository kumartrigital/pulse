package com.gss.pulseworkflow.model;

import java.io.Serializable;
import java.util.List;

public class EmpSearch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String rating;
	private String employeeName;
	private String emailId;
	private String position;
	private String utilization;
	private List<String> skills;
	private String startDate;
	private String endDate;
	

	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public EmpSearch(String rating, String employeeName, String emailId, String position,
			String utilization, List<String> skills) {
		super();
		this.rating = rating;
		this.employeeName = employeeName;
		this.emailId = emailId;
		this.position = position;
		this.utilization = utilization;
		this.skills = skills;
	}
	public EmpSearch() {
		super();
		
	}

	@Override
	public String toString() {
		return "EmpSearch [rating=" + rating + ", firstName=" + employeeName + ", emailId="
				+ emailId + ", position=" + position + ", utilization=" + utilization + ", skills="
				+ skills + "]";
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	

	
	

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPosition() {
		return position;
	}

	public void setPosition(String managerName) {
		this.position = managerName;
	}

	public String getUtilization() {
		return utilization;
	}

	public void setUtilization(String utilization) {
		this.utilization = utilization;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
/*
 * "employeeId":"", "utilization":"", "skills":"", "rating":"", "name":"",
 * "managerName":"", "employeeName":
 */

