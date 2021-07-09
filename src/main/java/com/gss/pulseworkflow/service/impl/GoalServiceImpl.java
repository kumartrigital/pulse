package com.gss.pulseworkflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.pulseworkflow.dao.GoalRepository;
import com.gss.pulseworkflow.model.Goal;
import com.gss.pulseworkflow.model.Milestone;
import com.gss.pulseworkflow.service.GoalService;
@Service
public class GoalServiceImpl implements GoalService {
	@Autowired
	private GoalRepository goalRepository;

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Goal goal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Goal goal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goal> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveToLog(long goalId, String action) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getRoleId(String projectName, String roleType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveToChild(long roleId, List<Long> goalIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int publish(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIdStatus(Long goalId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Long> getChildData(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveMilestone(Milestone milestone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Milestone> getMilestone(String goalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatus(long goalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMileStone(Milestone milestone) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIdMilestone(long rcdId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int completeMilestone(long rcdId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMilesoneStatus(long rcdId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Goal> goalSearch(Goal goal) {
		String query="SELECT GOALS.GOAL_ID,GOALS.GOAL_INTERVAL_ID,MSTR_ASSESSMENT_INTERVAL.INTERVAL_NAME,"
				+ "GOALS.GOAL_TYPE_ID,GOALS.GOAL_DESCRIPTION,"
				+ "GOALS.GOAL_NAME,GOALS.GOAL_STATUS_ID,MSTR_STATUS.STATUS_VALUE,"
				+ "GOALS.GOAL_CREATOR_ID,EMP_DETAIL.EMAIL,GOALS.GOAL_START_DATE,"
				+ "GOALS.GOAL_END_DATE,GOALS.CREATED_DATE FROM GOALS JOIN MSTR_STATUS "
				+ "ON MSTR_STATUS.STATUS_ID=GOALS.GOAL_STATUS_ID JOIN MSTR_ASSESSMENT_INTERVAL ON "
				+ "MSTR_ASSESSMENT_INTERVAL.INTERVAL_ID=GOALS.GOAL_INTERVAL_ID JOIN EMP_DETAIL ON "
				+ "GOALS.GOAL_CREATOR_ID=EMP_DETAIL.EMPLOYEE_ID";
		boolean searchFlag = false;
		if (goal.getGoalName() != null) {
			query = query + " WHERE GOALS.GOAL_NAME LIKE '%" + goal.getGoalName().trim() + "%'";
			searchFlag = true;
		}
		if (goal.getGoalIntervalId() != null && searchFlag) {
			query = query + " AND GOALS.GOAL_INTERVAL_ID='" + goal.getGoalIntervalId().trim() + "'";
			searchFlag = true;
		} else if (goal.getGoalIntervalId() != null && !searchFlag) {
			query = query + " WHERE GOALS.GOAL_INTERVAL_ID='" + goal.getGoalIntervalId().trim() + "'";
			searchFlag = true;
		}
		if (goal.getGoalTypeId() != null && searchFlag) {
			query = query + " AND GOALS.GOAL_TYPE_ID='" + goal.getGoalTypeId().trim() + "'";
			searchFlag = true;
		} else if (goal.getGoalTypeId() != null && !searchFlag) {
			query = query + " WHERE GOALS.GOAL_TYPE_ID='" + goal.getGoalTypeId().trim() + "'";
			searchFlag = true;
		}
		if (goal.getGoalStatusId() != null && searchFlag) {
			query = query + " AND GOALS.GOAL_STATUS_ID='" + goal.getGoalStatusId() + "'";
			searchFlag = true;
		} else if (goal.getGoalStatusId() != null && !searchFlag) {
			query = query + " WHERE GOALS.GOAL_STATUS_ID='" + goal.getGoalStatusId() + "'";
			searchFlag = true;
		}
		if (goal.getGoalStartDate() != null && goal.getGoalEndDate() != null && searchFlag) {
			query = query + " AND GOALS.GOAL_START_DATE >='" + goal.getGoalStartDate() + "' AND GOALS.GOAL_END_DATE <='"+goal.getGoalEndDate()+"'";
			searchFlag = true;
		} else if (goal.getGoalStartDate() != null && goal.getGoalEndDate() != null &&  !searchFlag) {
			query = query + " WHERE GOALS.GOAL_START_DATE >='" + goal.getGoalStartDate() + "' AND GOALS.GOAL_END_DATE <='"+goal.getGoalEndDate()+"'";
			searchFlag = true;
		}
		return goalRepository.goalSearch(query);
	}

	@Override
	public long existingGoal(String intervalId, String goalTypeId, String goalName) {
		// TODO Auto-generated method stub
		return goalRepository.existingGoal(intervalId,goalTypeId,goalName);
	}

}
