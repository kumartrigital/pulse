package com.gss.pulseworkflow.model;

public class EmpProjectNotes {
	
	private long rcdId;
	private String projectId;
	private String projectNotes;
	private String projectCommentorId;
	private String commentorEmail;
	private String commentDate;
	public EmpProjectNotes(long rcdId, String projectId, String projectNotes, String projectCommentorId,
			String commentorEmail, String commentDate) {
		super();
		this.rcdId = rcdId;
		this.projectId = projectId;
		this.projectNotes = projectNotes;
		this.projectCommentorId = projectCommentorId;
		this.commentorEmail = commentorEmail;
		this.commentDate = commentDate;
	}
	
	
	public EmpProjectNotes() {
		super();
		
	}

	public long getRcdId() {
		return rcdId;
	}

	public void setRcdId(long rcdId) {
		this.rcdId = rcdId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectNotes() {
		return projectNotes;
	}

	public void setProjectNotes(String projectNotes) {
		this.projectNotes = projectNotes;
	}

	public String getProjectCommentorId() {
		return projectCommentorId;
	}

	public void setProjectCommentorId(String projectCommentorId) {
		this.projectCommentorId = projectCommentorId;
	}

	public String getCommentorEmail() {
		return commentorEmail;
	}

	public void setCommentorEmail(String commentorEmail) {
		this.commentorEmail = commentorEmail;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "EmpProjectNotes [rcdId=" + rcdId + ", projectId=" + projectId + ", projectNotes=" + projectNotes
				+ ", projectCommentorId=" + projectCommentorId + ", commentorName=" + commentorEmail + ", commentDate="
				+ commentDate + "]";
	}
	
	
	

}
