package com.gss.pulseworkflow.model;

public class EmployeeValidation {
	
	private String validationComments;
	private int numberOfValidationsFailed;
	private Employee employeeDetails;
	public String getValidationComments() {
		return validationComments;
	}
	public void setValidationComments(String validationComments) {
		this.validationComments = validationComments;
	}
	public int getNumberOfValidationsFailed() {
		return numberOfValidationsFailed;
	}
	public void setNumberOfValidationsFailed(int numberOfValidationsFailed) {
		this.numberOfValidationsFailed = numberOfValidationsFailed;
	}
	public Employee getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(Employee employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	
	

}
