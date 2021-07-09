package com.gss.pulseworkflow.model;

import java.util.List;

public class Assessees {
	
	private String assesseeRcdId;
	private String assessee;
	private String assesseeEmial;
	private List<AssesseeCapability> assesseeCapabilityInfo;
	
	public List<AssesseeCapability> getAssesseeCapabilityInfo() {
		return assesseeCapabilityInfo;
	}

	public void setAssesseeCapabilityInfo(List<AssesseeCapability> assesseeCapabilityInfo) {
		this.assesseeCapabilityInfo = assesseeCapabilityInfo;
	}

	public Assessees(String assesseeRcdId, String assessee, String assesseeEmial) {
		super();
		this.assesseeRcdId = assesseeRcdId;
		this.assessee = assessee;
		this.assesseeEmial = assesseeEmial;
	}
	
	public Assessees() {
		super();
		
	}

	public String getAssesseeRcdId() {
		return assesseeRcdId;
	}

	public void setAssesseeRcdId(String assesseeRcdId) {
		this.assesseeRcdId = assesseeRcdId;
	}

	public String getAssessee() {
		return assessee;
	}

	public void setAssessee(String assessee) {
		this.assessee = assessee;
	}

	public String getAssesseeEmial() {
		return assesseeEmial;
	}

	public void setAssesseeEmial(String assesseeEmial) {
		this.assesseeEmial = assesseeEmial;
	}
	
	

}
