package com.gss.pulseworkflow.model;

public class ProGoal {
	private String goalName;
	private String goalId;
	@Override
	public String toString() {
		return "ProGoal [goalName=" + goalName + ", goalId=" + goalId + "]";
	}
	public ProGoal(String goalId, String goalName) {
		super();
		this.goalId = goalId;
		this.goalName = goalName;
	}
	public String getGoalName() {
		return goalName;
	}
	public void setGoalName(String goalName) {
		this.goalName = goalName;
	}
	public String getGoalId() {
		return goalId;
	}
	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}
	

}
