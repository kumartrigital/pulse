package com.gss.pulseworkflow.model;

import java.util.List;

public class Task {
	
	private String pendingAssessmentsCount;
	private String pendingTrainingsCount;
	private String pendingGoalsCount;
	private String utilization;
	private List<Rating> rating;
	
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
	public Task(String pendingAssessmentsCount, String pendingTrainingsCount, String pendingGoalsCount) {
		super();
		this.pendingAssessmentsCount = pendingAssessmentsCount;
		this.pendingTrainingsCount = pendingTrainingsCount;
		this.pendingGoalsCount = pendingGoalsCount;
	}
	public Task() {
		super();
	}
	@Override
	public String toString() {
		return "Task [pendingAssessmentsCount=" + pendingAssessmentsCount + ", pendingTrainingsCount="
				+ pendingTrainingsCount + ", pendingGoalsCount=" + pendingGoalsCount + "]";
	}
	public String getPendingAssessmentsCount() {
		return pendingAssessmentsCount;
	}
	public void setPendingAssessmentsCount(String pendingAssessmentsCount) {
		this.pendingAssessmentsCount = pendingAssessmentsCount;
	}
	public String getPendingTrainingsCount() {
		return pendingTrainingsCount;
	}
	public void setPendingTrainingsCount(String pendingTrainingsCount) {
		this.pendingTrainingsCount = pendingTrainingsCount;
	}
	public String getPendingGoalsCount() {
		return pendingGoalsCount;
	}
	public void setPendingGoalsCount(String pendingGoalsCount) {
		this.pendingGoalsCount = pendingGoalsCount;
	}
	
	

}