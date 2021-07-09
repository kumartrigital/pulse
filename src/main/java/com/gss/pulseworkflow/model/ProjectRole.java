package com.gss.pulseworkflow.model;

public class ProjectRole {
	private long id;
	private String projRole;
	public ProjectRole(long id, String projRole) {
		super();
		this.id = id;
		this.projRole = projRole;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjRole() {
		return projRole;
	}
	public void setProjRole(String projRole) {
		this.projRole = projRole;
	}
	@Override
	public String toString() {
		return "ProjectRole [id=" + id + ", projRole=" + projRole + "]";
	}
	public ProjectRole() {
		super();
		
	}
	

}
