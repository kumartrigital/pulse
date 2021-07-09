package com.gss.pulseworkflow.model;

public class UserSkills {
	private long rcdId;
	private String skillName;
	private String skillDescription;
	private long skillExperience;
	private String skillCertified;
	private String frmlTrained;
	private String lastUsedDate;
	private String skillAddedDate;
	private String skillLevel;
	private String capabilityId;
	private String capabilityName;
	private String employeeId;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
    public UserSkills(String skillName,long skillExperience,
			String skillCertified,String skillLevel) {
		super();
		this.skillName = skillName;
		this.skillExperience = skillExperience;
		this.skillCertified = skillCertified;
		this.skillLevel = skillLevel;
	}
	public UserSkills(long rcdId, String skillName, String skillDescription, long skillExperience,
			String skillCertified, String frmlTrained, String lastUsedDate, String skillAddedDate, String skillLevel,
			String capabilityId, String capabilityName, String employeeId) {
		super();
		this.rcdId = rcdId;
		this.skillName = skillName;
		this.skillDescription = skillDescription;
		this.skillExperience = skillExperience;
		this.skillCertified = skillCertified;
		this.frmlTrained = frmlTrained;
		this.lastUsedDate = lastUsedDate;
		this.skillAddedDate = skillAddedDate;
		this.skillLevel = skillLevel;
		this.capabilityId = capabilityId;
		this.capabilityName = capabilityName;
		this.employeeId = employeeId;
	}
	@Override
	public String toString() {
		return "UserSkills [rcdId=" + rcdId + ", skillName=" + skillName + ", skillDescription=" + skillDescription
				+ ", skillExperience=" + skillExperience + ", skillCertified=" + skillCertified + ", frmlTrained="
				+ frmlTrained + ", lastUsedDate=" + lastUsedDate + ", skillAddedDate=" + skillAddedDate
				+ ", skillLevel=" + skillLevel + ", capabilityId=" + capabilityId + ", capabilityName=" + capabilityName
				+ ", employeeId=" + employeeId + "]";
	}
	public long getRcdId() {
		return rcdId;
	}
	public void setRcdId(long rcdId) {
		this.rcdId = rcdId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillDescription() {
		return skillDescription;
	}
	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	public long getSkillExperience() {
		return skillExperience;
	}
	public void setSkillExperience(long skillExperience) {
		this.skillExperience = skillExperience;
	}
	public String getSkillCertified() {
		return skillCertified;
	}
	public void setSkillCertified(String skillCertified) {
		this.skillCertified = skillCertified;
	}
	public String getFrmlTrained() {
		return frmlTrained;
	}
	public void setFrmlTrained(String frmlTrained) {
		this.frmlTrained = frmlTrained;
	}
	public String getLastUsedDate() {
		return lastUsedDate;
	}
	public void setLastUsedDate(String lastUsedDate) {
		this.lastUsedDate = lastUsedDate;
	}
	public String getSkillAddedDate() {
		return skillAddedDate;
	}
	public void setSkillAddedDate(String skillAddedDate) {
		this.skillAddedDate = skillAddedDate;
	}
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	public String getCapabilityId() {
		return capabilityId;
	}
	public void setCapabilityId(String capabilityId) {
		this.capabilityId = capabilityId;
	}
	public String getCapabilityName() {
		return capabilityName;
	}
	public void setCapabilityName(String capabilityName) {
		this.capabilityName = capabilityName;
	}
	public UserSkills(long rcdId, String skillName, String skillDescription, long skillExperience,
			String skillCertified, String frmlTrained, String lastUsedDate, String skillAddedDate, String skillLevel,
			String capabilityId, String capabilityName) {
		super();
		this.rcdId = rcdId;
		this.skillName = skillName;
		this.skillDescription = skillDescription;
		this.skillExperience = skillExperience;
		this.skillCertified = skillCertified;
		this.frmlTrained = frmlTrained;
		this.lastUsedDate = lastUsedDate;
		this.skillAddedDate = skillAddedDate;
		this.skillLevel = skillLevel;
		this.capabilityId = capabilityId;
		this.capabilityName = capabilityName;
	}
	
	
	
	public UserSkills() {
		super();
		
	}
	
	

}
