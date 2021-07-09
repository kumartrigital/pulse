package com.gss.pulseworkflow.model;

public class Weight {
	private Long capabilityId;
	private String weight;
	private String capabilityName;
	public long getCapabilityId() {
		return capabilityId;
	}
	public void setCapabilityId(Long capabilityId) {
		this.capabilityId = capabilityId;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getCapabilityName() {
		return capabilityName;
	}
	public void setCapabilityName(String capabilityName) {
		this.capabilityName = capabilityName;
	}
	public Weight(Long capabilityId, String weight, String capabilityName) {
		super();
		this.capabilityId = capabilityId;
		this.weight = weight;
		this.capabilityName = capabilityName;
	}
	@Override
	public String toString() {
		return "Weight [capabilityId=" + capabilityId + ", weight=" + weight + ", capabilityName=" + capabilityName
				+ "]";
	}
	
	public Weight() {
		super();
		
	}
	
	

}
