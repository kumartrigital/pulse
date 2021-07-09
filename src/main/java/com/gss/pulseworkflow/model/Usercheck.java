package com.gss.pulseworkflow.model;

public class Usercheck {
	private String loggedInUserFirstName;
	private String loggedInUserLastName;
	private String loggedInUserId;
    private String userRole;
	public String getLoggedInUserId() {
		return loggedInUserId;
	}
	public void setLoggedInUserId(String loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public String getLoggedInUserFirstName() {
		return loggedInUserFirstName;
	}
	public void setLoggedInUserFirstName(String loggedInUserFirstName) {
		this.loggedInUserFirstName = loggedInUserFirstName;
	}
	public String getLoggedInUserLastName() {
		return loggedInUserLastName;
	}
	public void setLoggedInUserLastName(String loggedInUserLastName) {
		this.loggedInUserLastName = loggedInUserLastName;
	}
	public Usercheck(String loggedInUserFirstName, String loggedInUserLastName, String loggedInUserId,
			String userRole) {
		super();
		this.loggedInUserFirstName = loggedInUserFirstName;
		this.loggedInUserLastName = loggedInUserLastName;
		this.loggedInUserId = loggedInUserId;
		this.userRole = userRole;
	}
	public Usercheck() {
		super();
	}
	@Override
	public String toString() {
		return "User [loggedInUserId=" + loggedInUserId + ", userRole=" + userRole + "]";
	}

}
