package com.gss.pulseworkflow.model;

import java.util.List;

public class HomeObj {
	
	private Task tasks;
	private List<Notifications> notifications;
	private List<Reportee> reporteeDetails;
	private String utilization;
	private List<Rating> rating;
	public HomeObj(Task tasks, List<Notifications> notifications, List<Reportee> reporteeDetails, String utilization,
			List<Rating> rating) {
		super();
		this.tasks = tasks;
		this.notifications = notifications;
		this.reporteeDetails = reporteeDetails;
		this.utilization = utilization;
		this.rating = rating;
	}
	public HomeObj() {
		super();
	}
	public Task getTasks() {
		return tasks;
	}
	public void setTasks(Task tasks) {
		this.tasks = tasks;
	}
	public List<Notifications> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
	}
	public List<Reportee> getReporteeDetails() {
		return reporteeDetails;
	}
	public void setReporteeDetails(List<Reportee> reporteeDetails) {
		this.reporteeDetails = reporteeDetails;
	}
	public String getUtilization() {
		return utilization;
	}
	public void setUtilization(String utilization) {
		this.utilization = utilization;
	}
	public List<Rating> getRating() {
		return rating;
	}
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "HomeObj [tasks=" + tasks + ", notifications=" + notifications + ", reporteeDetails=" + reporteeDetails
				+ ", utilization=" + utilization + ", rating=" + rating + "]";
	}
	
	

}
