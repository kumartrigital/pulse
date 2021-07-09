package com.gss.pulseworkflow.model;

public class UserRoles {
	
	private long userRoleId;
	private String userRoleName;
	public UserRoles(long userRoleId, String userRoleName) {
		super();
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}
	public UserRoles() {
		super();
	}
	public long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	@Override
	public String toString() {
		return "UserRoles [userRoleId=" + userRoleId + ", userRoleName=" + userRoleName + "]";
	}
	
	

}
