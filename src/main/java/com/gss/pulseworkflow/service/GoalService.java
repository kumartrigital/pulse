package com.gss.pulseworkflow.service;

import java.util.List;

import com.gss.pulseworkflow.model.Goal;
import com.gss.pulseworkflow.model.Milestone;

public interface GoalService {
	int count();

	int save(Goal goal);

	int update(Goal goal);

	int deleteById(Long id);

	List<Goal> findAll();

	int saveToLog(long goalId, String action);
	List<Goal> goalSearch(Goal goal);

	long getRoleId(String projectName, String roleType);

	int saveToChild(long roleId, List<Long> goalIds);

	int publish(long id);

	int deleteByIdStatus(Long goalId);

	List<Long> getChildData(long id);

	int saveMilestone(Milestone milestone);

	List<Milestone> getMilestone(String goalId);

	String getStatus(long goalId);

	int updateMileStone(Milestone milestone);

	int deleteByIdMilestone(long rcdId);

	int completeMilestone(long rcdId);

	String getMilesoneStatus(long rcdId);
	long existingGoal(String intervalId,String goalTypeId,String goalName);

}
