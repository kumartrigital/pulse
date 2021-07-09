package com.gss.pulseworkflow.model;

import java.util.List;

public class Role {
	
	private String roleType;
	private long roleId;
	private String roleName;
	private String roleDescription;
	private List<Long> roleCapabilities;
	private String creatorId;
	private String roleStatusID;
	private String creatprId;
	private long weight;
	private String comment;
	private List<Long> removeCap;
	private List<Weight> addedCap;
	private List<Weight> existingCap;
	public List<Weight> getRoleCapWeight() {
		return roleCapWeight;
	}
	public void setRoleCapWeight(List<Weight> roleCapWeight) {
		this.roleCapWeight = roleCapWeight;
	}
	public Role(String roleType, long roleId, String roleName, String roleDescription, List<Long> roleCapabilities,
			String creatorId, String roleStatusID, String creatprId, long weight, String comment, List<Long> removeCap,
			List<Weight> addedCap, List<Weight> existingCap, List<Weight> roleCapWeight) {
		super();
		this.roleType = roleType;
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.roleCapabilities = roleCapabilities;
		this.creatorId = creatorId;
		this.roleStatusID = roleStatusID;
		this.creatprId = creatprId;
		this.weight = weight;
		this.comment = comment;
		this.removeCap = removeCap;
		this.addedCap = addedCap;
		this.existingCap = existingCap;
		this.roleCapWeight = roleCapWeight;
	}
	private List<Weight> roleCapWeight;
	

	public List<Weight> getExistingCap() {
		return existingCap;
	}
	public void setExistingCap(List<Weight> existingCap) {
		this.existingCap = existingCap;
	}
	/*
	 * public Role(String roleType, long roleId, String roleName, String
	 * roleDescription, List<Long> roleCapabilities, String creatorId, String
	 * roleStatusID, String creatprId, long weight) { super(); this.roleType =
	 * roleType; this.roleId = roleId; this.roleName = roleName;
	 * this.roleDescription = roleDescription; this.roleCapabilities =
	 * roleCapabilities; this.creatorId = creatorId; this.roleStatusID =
	 * roleStatusID; this.creatprId = creatprId; this.weight = weight; }
	 */
	public Role(String roleDescription, String roleName, String roleType, long roleId, String roleStatusID) {
		// TODO Auto-generated constructor stub
		this.roleType = roleType;
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.roleStatusID = roleStatusID;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public List<Long> getRoleCapabilities() {
		return roleCapabilities;
	}
	public void setRoleCapabilities(List<Long> roleCapabilities) {
		this.roleCapabilities = roleCapabilities;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getRoleStatusID() {
		return roleStatusID;
	}
	public void setRoleStatusID(String roleStatusID) {
		this.roleStatusID = roleStatusID;
	}
	public String getCreatprId() {
		return creatprId;
	}
	public void setCreatprId(String creatprId) {
		this.creatprId = creatprId;
	}
	public long getWeight() {
		return weight;
	}
	public void setWeight(long weight) {
		this.weight = weight;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public List<Long> getRemoveCap() {
		return removeCap;
	}
	public void setRemoveCap(List<Long> removeCap) {
		this.removeCap = removeCap;
	}
	public List<Weight> getAddedCap() {
		return addedCap;
	}
	public void setAddedCap(List<Weight> addedCap) {
		this.addedCap = addedCap;
	}
	@Override
	public String toString() {
		return "Role [roleType=" + roleType + ", roleId=" + roleId + ", roleName=" + roleName + ", roleDescription="
				+ roleDescription + ", roleCapabilities=" + roleCapabilities + ", creatorId=" + creatorId
				+ ", roleStatusID=" + roleStatusID + ", creatprId=" + creatprId + ", weight=" + weight + ", comment="
				+ comment + ", removeCap=" + removeCap + ", addedCap=" + addedCap + ", existingCap=" + existingCap
				+ ", roleCapWeight=" + roleCapWeight + "]";
	}
	public Role(String roleType, long roleId, String roleName, String roleDescription, List<Long> roleCapabilities,
			String creatorId, String roleStatusID, String creatprId, long weight, String comment, List<Long> removeCap,
			List<Weight> addedCap, List<Weight> existingCap) {
		super();
		this.roleType = roleType;
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.roleCapabilities = roleCapabilities;
		this.creatorId = creatorId;
		this.roleStatusID = roleStatusID;
		this.creatprId = creatprId;
		this.weight = weight;
		this.comment = comment;
		this.removeCap = removeCap;
		this.addedCap = addedCap;
		this.existingCap = existingCap;
	}
	public Role() {
		super();
		
	}
	
	

}
