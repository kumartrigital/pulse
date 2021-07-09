package com.gss.pulseworkflow.model;

public class Utilization {
	
	private String monthYear;
	private String utilization;
	public String getMonthYear() {
		return monthYear;
	}
	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
	}
	public String getUtilization() {
		return utilization;
	}
	public void setUtilization(String utilization) {
		this.utilization = utilization;
	}
	public Utilization(String monthYear, String utilization) {
		super();
		this.monthYear = monthYear;
		this.utilization = utilization;
	}
	public Utilization() {
		super();
	}
	
	

}
