package com.gss.pulseworkflow.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Notification implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long anncId;
	private String heading;
	private String content;
	private List<String> audienceLevel;
	private String creatorId;
	private String creator;
	private String expiredOn;
	private String statusId;
	private String status;
	private String createdDate;
	private String audiencePosition;
	private String audiencePositionName;
	private Map<String,String> audience;
	private String publishedDate;
	
	
	
	
	
	public String getPublishedDate() {
		return publishedDate;
	}


	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}


	public Map<String, String> getAudience() {
		return audience;
	}


	public void setAudience(Map<String, String> audience) {
		this.audience = audience;
	}


	public String getAudiencePosition() {
		return audiencePosition;
	}


	public void setAudiencePosition(String audiencePosition) {
		this.audiencePosition = audiencePosition;
	}


	public String getAudiencePositionName() {
		return audiencePositionName;
	}


	public void setAudiencePositionName(String audiencePositionName) {
		this.audiencePositionName = audiencePositionName;
	}


	public Notification(long anncId,String audiencePosition,String audiencePositionName) {
		super();
		this.anncId = anncId;
		this.audiencePosition = audiencePosition;
		this.audiencePositionName = audiencePositionName;
	}
	
	
	public long getAnncId() {
		return anncId;
	}
	public void setAnncId(long anncId) {
		this.anncId = anncId;
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
	public Notification() {
		super();
	}
	public Notification(long anncId, String heading, String content, List<String> audienceLevel, String creatorId,
			String creatorName, String expiredOn, String statusId, String status) {
		super();
		this.anncId = anncId;
		this.heading = heading;
		this.content = content;
		this.audienceLevel = audienceLevel;
		this.creatorId = creatorId;
		this.creator = creatorName;
		this.expiredOn = expiredOn;
		this.statusId = statusId;
		this.status = status;
	}
	public Notification(long anncId,String publishedDate,String heading, String content) {
		super();
		this.anncId=anncId;
		this.publishedDate= publishedDate;
		this.heading = heading;
		this.content = content;
		
	}
	public Notification(long anncId, String heading, String content, String creatorId,
			String creatorName, String statusId, String status,String createdDate,String expiredOn) {
		super();
		this.anncId = anncId;
		this.heading = heading;
		this.content = content;
		this.creatorId = creatorId;
		this.creator = creatorName;
		this.statusId = statusId;
		this.status = status;
		this.createdDate=createdDate;
		this.expiredOn = expiredOn;
	}
	@Override
	public String toString() {
		return "Notification [anncId=" + anncId + ", heading=" + heading + ", content=" + content + ", audienceLevel="
				+ audienceLevel + ", creatorId=" + creatorId + ", creatorName=" + creator + ", expiredOn="
				+ expiredOn + ", statusId=" + statusId + ", status=" + status + "]";
	}
	
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getAudienceLevel() {
		return audienceLevel;
	}
	public void setAudienceLevel(List<String> audienceLevel) {
		this.audienceLevel = audienceLevel;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getCreatorName() {
		return creator;
	}
	public void setCreatorName(String creatorName) {
		this.creator = creatorName;
	}
	public String getExpiredOn() {
		return expiredOn;
	}
	public void setExpiredOn(String expiredOn) {
		this.expiredOn = expiredOn;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
