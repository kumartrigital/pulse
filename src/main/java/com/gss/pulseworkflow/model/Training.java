package com.gss.pulseworkflow.model;

public class Training {
	private String tainingId;
	private String trainingName;
	private String trainingDes;
	private long capabilityId;
	private String trainingStatusID;
	private String creator;
	private String createdDate;
	private String comment;
	private long recID;
	private String capabilityName;
	private String status;
	private String creatorEmail;
	
	
	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getCreatorEmail() {
		return creatorEmail;
	}



	public void setCreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}



	public Training(long recID,String tainingId, String trainingName, String trainingDes,String trainingStatusID,
			long capabilityId, String capabilityName,String status,String creatorEmail,
			String creator, String createdDate) {
	this.recID=recID;
		this.tainingId = tainingId;
		this.trainingName = trainingName;
		this.trainingDes = trainingDes;
		this.trainingStatusID = trainingStatusID;
		this.capabilityId = capabilityId;
		this.capabilityName=capabilityName;
		this.status=status;
		this.creatorEmail = creatorEmail;
		this.creator = creator;
		this.createdDate = createdDate;
		
	}
	
	
	
	public String getCapabilityName() {
		return capabilityName;
	}
	public void setCapabilityName(String capabilityName) {
		this.capabilityName = capabilityName;
	}
	public long getRecID() {
		return recID;
	}
	public void setRecID(long recID) {
		this.recID = recID;
	}
	@Override
	public String toString() {
		return "Training [tainingId=" + tainingId + ", trainingName=" + trainingName + ", trainingDes=" + trainingDes
				+ ", capabilityId=" + capabilityId + ", trainingStatusID=" + trainingStatusID + ", creator=" + creator
				+ ", createdDate=" + createdDate + ", comment=" + comment + ", recID=" + recID + ", capabilityName="
				+ capabilityName + "]";
	}
	public String getTainingId() {
		return tainingId;
	}
	public void setTainingId(String tainingId) {
		this.tainingId = tainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getTrainingDes() {
		return trainingDes;
	}
	public void setTrainingDes(String trainingDes) {
		this.trainingDes = trainingDes;
	}
	public long getCapabilityId() {
		return capabilityId;
	}
	public void setCapabilityId(long capabilityId) {
		this.capabilityId = capabilityId;
	}
	public String getTrainingStatusID() {
		return trainingStatusID;
	}
	public void setTrainingStatusID(String trainingStatusID) {
		this.trainingStatusID = trainingStatusID;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Training() {
		
	}
	
	public Training(String tainingId, String trainingName, String trainingDes, long capabilityId, String trainingStatusID,
			String creator, String createdDate, String comment,long recID) {
	
		this.tainingId = tainingId;
		this.trainingName = trainingName;
		this.trainingDes = trainingDes;
		this.capabilityId = capabilityId;
		this.trainingStatusID = trainingStatusID;
		this.creator = creator;
		this.createdDate = createdDate;
		this.comment = comment;
		this.recID = recID;
	}
	public Training(String tainingId, String trainingDes, String trainingName, long capabilityId, String trainingStatusID) {
		
		this.tainingId = tainingId;
		this.trainingName = trainingName;
		this.trainingDes = trainingDes;
		this.capabilityId = capabilityId;
		this.trainingStatusID = trainingStatusID;
	}
	public Training(String tainingId, String trainingDes, String trainingName, long capabilityId, String trainingStatusID,String capabilityName,long recID) {
		
		this.tainingId = tainingId;
		this.trainingName = trainingName;
		this.trainingDes = trainingDes;
		this.capabilityId = capabilityId;
		this.trainingStatusID = trainingStatusID;
		this.capabilityName=capabilityName;
		this.recID = recID;
	}
	
	

}
