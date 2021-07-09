package com.gss.pulseworkflow.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gss.pulseworkflow.dao.GoalRepository;
import com.gss.pulseworkflow.model.Goal;
import com.gss.pulseworkflow.model.Milestone;
@Repository
public class GoalRepositoryImpl extends JdbcDaoSupport implements GoalRepository{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Goal goal) {
		goal.setGoalStatusId("2");
		return jdbcTemplate.update(
                "insert into GOALS (GOAL_INTERVAL_ID,GOAL_TYPE_ID,GOAL_DESCRIPTION,GOAL_NAME,GOAL_STATUS_ID,GOAL_START_DATE,GOAL_END_DATE,GOAL_CREATOR_ID) values(?,?,?,?,?,?,?,?)",
                goal.getGoalIntervalId(),goal.getGoalTypeId(),goal.getGoalDes(),goal.getGoalName(),goal.getGoalStatusId(),goal.getGoalStartDate(),goal.getGoalEndDate(),goal.getGoalCreatorId());
	}

	@Override
	public int update(Goal goal) {
		return jdbcTemplate.update(
                "update GOALS set GOAL_INTERVAL_ID = ?, GOAL_TYPE_ID=?, GOAL_DESCRIPTION=?, GOAL_NAME =?, GOAL_START_DATE=?, GOAL_END_DATE=? where GOAL_ID = ?",
                goal.getGoalIntervalId(),goal.getGoalTypeId(),goal.getGoalDes(),goal.getGoalName(),goal.getGoalStartDate(),goal.getGoalEndDate(),goal.getGoalId());
	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update(
                "DELETE FROM GOALS where GOAL_ID=?",
                id);
	}

	@Override
	public List<Goal> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT GOALS.GOAL_INTERVAL_ID as INTERVALID,GOALS.GOAL_TYPE_ID as TYPEID,GOALS.GOAL_DESCRIPTION as DESCRIPTION,"
				+ " GOALS.GOAL_ID as GOALID,GOALS.GOAL_NAME as GOALNAME,GOALS.GOAL_STATUS_ID AS STATUS,"
				+ " GOALS.GOAL_CREATOR_ID AS CREATORID,GOALS.GOAL_START_DATE AS STARTDATE,GOALS.GOAL_END_DATE AS ENDDATE FROM GOALS",
				(rs, rowNum) ->
                new Goal(
                		rs.getLong("GOALID"),
                		rs.getString("INTERVALID"),
                		rs.getString("TYPEID"),
                		rs.getString("GOALNAME"),
                		rs.getString("DESCRIPTION"),
                		rs.getString("STATUS"),
                		rs.getString("STARTDATE"),
                		rs.getString("ENDDATE"),
                		rs.getString("CREATORID")));
	}

	@Override
	public int saveToLog(long goalId, String action) {
		return jdbcTemplate.update(
                "insert into GOAL_LOG (GOAL_ID, EVENT_DESCRIPTION) values(?,?)",
                goalId, action);
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
		return jdbcTemplate.update(
                "update GOALS set GOAL_STATUS_ID = '0' where GOAL_ID = ?",
                id);
	}

	@Override
	public List<Long> getChildData(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByIdStatus(Long goalId) {
		return jdbcTemplate.update(
                "update GOALS set GOAL_STATUS_ID = '1' where GOAL_ID = ?",
                goalId);
	}

	@Override
	public int saveMilestone(Milestone milestone) {
		milestone.setTaskStatusId("0");
		return jdbcTemplate.update(
                "insert into GOAL_DETAILS (GOAL_ID,GOAL_TASK_ID,GOAL_TASK_DETAIL,GOAL_TASK_STATUS_ID,GOAL_TASK_START_DATE,GOAL_TASK_END_DATE,GOAL_TASK_COMMENTS,CREATOR_ID) values(?,?,?,?,?,?,?,?)",
                milestone.getGoalId(),milestone.getTaskId(),milestone.getTaskDetail(),milestone.getTaskStatusId(),milestone.getStartDate(),milestone.getEndDate(),milestone.getTaskComments(),milestone.getTaskCreatorId());
	}

	@Override
	public List<Milestone> getMilestone(String goalId) {
		return jdbcTemplate.query("SELECT RCD_ID,GOAL_ID,GOAL_TASK_ID,GOAL_TASK_DETAIL,GOAL_TASK_STATUS_ID,GOAL_TASK_START_DATE," 
				+ " GOAL_TASK_END_DATE,GOAL_TASK_COMMENTS FROM GOAL_DETAILS WHERE GOAL_ID=?",
				new Object[]{goalId},
				(rs, rowNum) ->
                new Milestone(
                		rs.getLong("RCD_ID"),
                		rs.getString("GOAL_ID"),
                		rs.getString("GOAL_TASK_ID"),
                		rs.getString("GOAL_TASK_DETAIL"),
                		rs.getString("GOAL_TASK_STATUS_ID"),
                		rs.getString("GOAL_TASK_START_DATE"),
                		rs.getString("GOAL_TASK_END_DATE"),
                		rs.getString("GOAL_TASK_COMMENTS")));
	}

	@Override
	public String getStatus(long roleId) {
		return jdbcTemplate.queryForObject(
                "SELECT STATUS_VALUE FROM MSTR_STATUS WHERE STATUS_ID IN (SELECT GOAL_STATUS_ID FROM GOALS WHERE GOAL_ID=?)",
                new Object[]{roleId},
                String.class
        );
	}

	@Override
	public int updateMileStone(Milestone milestone) {
		return jdbcTemplate.update(
                "Update GOAL_DETAILS set GOAL_ID=?,GOAL_TASK_ID=?,GOAL_TASK_DETAIL=?,GOAL_TASK_STATUS_ID=?,GOAL_TASK_START_DATE=?,GOAL_TASK_END_DATE=?,GOAL_TASK_COMMENTS=? where RCD_ID=?",
                milestone.getGoalId(),milestone.getTaskId(),milestone.getTaskDetail(),milestone.getTaskStatusId(),milestone.getStartDate(),milestone.getEndDate(),milestone.getTaskComments(),milestone.getRecId());
	}

	@Override
	public int deleteByIdMilestone(long rcdId) {
		return jdbcTemplate.update(
                "DELETE FROM GOAL_DETAILS where RCD_ID=?",
                rcdId);
	}

	@Override
	public int completeMilestone(long rcdId) {
		
		return jdbcTemplate.update(
                "UPDATE GOAL_DETAILS SET GOAL_TASK_STATUS_ID='5' WHERE RCD_ID=?",
                rcdId);
	}

	@Override
	public String getMilesoneStatus(long rcdId) {
		return jdbcTemplate.queryForObject(
                "SELECT STATUS_ID FROM MSTR_STATUS WHERE STATUS_ID IN (SELECT GOAL_TASK_STATUS_ID FROM GOAL_DETAILS WHERE RCD_ID=?)",
                new Object[]{rcdId},
                String.class
        );
	}
	@Override
	public List<Goal> goalSearch(String query) {
		return jdbcTemplate.query(query,
				(rs, rowNum) ->
                new Goal(
                		rs.getLong("GOAL_ID"),
                		rs.getString("GOAL_INTERVAL_ID"),
                		rs.getString("INTERVAL_NAME"),
                		rs.getString("GOAL_TYPE_ID"),
                		rs.getString("GOAL_DESCRIPTION"),
                		rs.getString("GOAL_NAME"),
                		rs.getString("GOAL_STATUS_ID"),
                		rs.getString("STATUS_VALUE"),
                		rs.getString("GOAL_CREATOR_ID"),
                		rs.getString("EMAIL"),
                		rs.getString("GOAL_START_DATE"),
                		rs.getString("GOAL_END_DATE"),
                		rs.getString("CREATED_DATE")));
	}
	@Override
	public long existingGoal(String intervalId, String goalTypeId, String goalName) {
		return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM GOALS WHERE GOAL_INTERVAL_ID=? AND GOAL_TYPE_ID=? AND GOAL_NAME=?",
                new Object[]{intervalId,goalTypeId,goalName},
                long.class
        );
	}
}
