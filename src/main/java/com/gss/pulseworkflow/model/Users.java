package com.gss.pulseworkflow.model;

import java.util.List;

public class Users {
	
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Users [users=" + employees + "]";
	}

	
	  public Users(List<Employee> employees) { super(); this.employees = employees; }
	 
	public Users() {
		super();
	}

}
