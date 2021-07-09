/**
 * 
 */
package com.gss.pulseworkflow.model;

/**
 * @author Arjun
 *
 */
/*
 * @Entity
 * 
 * @Table(name = "MSTR_CAPABILITY")
 * 
 * @EntityListeners(AuditingEntityListener.class)
 */
public class Capability {

	

   // @Column(name = "CAPABILITY_NAME", nullable = false)
    private String capabilityName;

   // @Column(name = "CAPABILITY_TYPE", nullable = false)
    private String capabilityType;

   // @Column(name = "CAPABILITY_DESCRIPTION", nullable = false)
    private String capabilityDescription;
    private long capabilityID;
    private String comment;
    public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Capability(String capabilityDescription,String capabilityName, String capabilityType, long capabilityID) {
		super();
		this.capabilityName = capabilityName;
		this.capabilityType = capabilityType;
		this.capabilityDescription = capabilityDescription;
		this.capabilityID = capabilityID;
		
	}
	public Capability() {
		super();
		
	}
	public Capability(String capabilityDescription,String capabilityName, String capabilityType, long capabilityID,String capabilityStatusId) {
		super();
		this.capabilityName = capabilityName;
		this.capabilityType = capabilityType;
		this.capabilityDescription = capabilityDescription;
		this.capabilityID = capabilityID;
		this.capabilityStatusId=capabilityStatusId;
		
	}
	public Capability(String capabilityDescription,String capabilityName, String capabilityType, long capabilityID,String capabilityStatusId,
			String status,String creatorId,String creatorEmail,String createdDate) {
		super();
		this.capabilityDescription = capabilityDescription;
		this.capabilityName = capabilityName;
		this.capabilityType = capabilityType;
		
		this.capabilityID = capabilityID;
		this.capabilityStatusId=capabilityStatusId;
		this.status=status;
		this.creatorId=creatorId;
		this.creatorEmail=creatorEmail;
		this.createdDate=createdDate;
		
	}
	public Capability(long capabilityID) {
		// TODO Auto-generated constructor stub
		this.capabilityID = capabilityID;
	}
	private String capabilityStatusId;
    private String createdDate;
    private String creatorId;
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
	/*
	 * public Capability(String string, String string2, String string3, long l) { //
	 * TODO Auto-generated constructor stub }
	 */
	@Override
	public String toString() {
		return "Capability [capabilityName=" + capabilityName + ", capabilityType=" + capabilityType
				+ ", capabilityDescription=" + capabilityDescription + ", capabilityID=" + capabilityID
				+ ", capabilityStatusId=" + capabilityStatusId + ", createdDate=" + createdDate + ", creatorId="
				+ creatorId + "]";
	}
	public String getCapabilityName() {
		return capabilityName;
	}
	public void setCapabilityName(String capabilityName) {
		this.capabilityName = capabilityName;
	}
	public String getCapabilityType() {
		return capabilityType;
	}
	public void setCapabilityType(String capabilityType) {
		this.capabilityType = capabilityType;
	}
	public String getCapabilityDescription() {
		return capabilityDescription;
	}
	public void setCapabilityDescription(String capabilityDescription) {
		this.capabilityDescription = capabilityDescription;
	}
	public long getCapabilityID() {
		return capabilityID;
	}
	public void setCapabilityID(long capabilityID) {
		this.capabilityID = capabilityID;
	}
	public String getCapabilityStatusId() {
		return capabilityStatusId;
	}
	public void setCapabilityStatusId(String capabilityStatusId) {
		this.capabilityStatusId = capabilityStatusId;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
    


 }
