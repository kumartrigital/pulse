package com.gss.pulseworkflow.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gss.pulseworkflow.dao.ProjectRepository;
import com.gss.pulseworkflow.model.EmpProject;
import com.gss.pulseworkflow.model.Hierarchy;
import com.gss.pulseworkflow.model.ProGoal;
import com.gss.pulseworkflow.model.Project;
import com.gss.pulseworkflow.model.ProjectRole;
import com.gss.pulseworkflow.utility.Helper;
@Repository
public class ProjectRepositoryImpl extends JdbcDaoSupport implements ProjectRepository{
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
	public int save(Project project) {
		project.setStatusId("2");
		return jdbcTemplate.update(
                "insert into PROJECTS (PROJECT_ID, PROJECT_NAME,PROJECT_START_DATE,PROJECT_END_DATE,PROJECT_CUSTOMER,PROJECT_DESCRIPTION,PROJECT_STATUS_ID,CREATOR_ID) values(?,?,?,?,?,?,?,?)",
                project.getProjectId(),project.getProjectName(),project.getStartDate(),project.getEndDate(),project.getCustomer(),project.getProjectDescription(),project.getStatusId(),project.getCreatorId());
	}

	@Override
	public int updateProj(Project project) {
		return jdbcTemplate.update(
                "update PROJECTS set PROJECT_ID = ?, PROJECT_NAME=?, PROJECT_START_DATE=? ,PROJECT_END_DATE = ?, PROJECT_CUSTOMER=?, PROJECT_DESCRIPTION=? where RCD_ID = ?",
                project.getProjectId(),project.getProjectName(),project.getStartDate(),project.getEndDate(),project.getCustomer(),project.getProjectDescription(),project.getRcdId());
	}
	@Override
	public int update(String projectId,List<Hierarchy> hierarchies) {
		int x=0;
		for(Hierarchy hierarchy:hierarchies) {
		x=jdbcTemplate.update(
                "update EMP_PROJECT set PROJ_REPORTING_MGR_ID = ? where PROJECT_ID = ? and EMPLOYEE_ID=?",
                hierarchy.getProjectReporManagerId(), projectId,hierarchy.getEmpId());
		}
		return x;
	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update(
                "DELETE FROM PROJECTS where RCD_ID=?",
                id);
	}

	@Override
	public List<Hierarchy> findAll(String projectId) {
		
		return getJdbcTemplate().query(
                "SELECT EMP_DETAIL.FIRST_NAME as FIRSTNAME,EMP_DETAIL.LAST_NAME AS LASTNAME,EMP_DETAIL.EMAIL AS "
                + "EMAILID,EMP_DETAIL.EMPLOYEE_ID as EMP_ID,EMP_PROJECT.PROJ_REPORTING_MGR_ID as "
                + "MGR_ID,EMP_PROJECT.PROJ_UTL_PERCENT AS PROJECT_ALLOCATION,emp.FIRST_NAME AS MANAGER FROM "
                + "EMP_DETAIL JOIN EMP_PROJECT ON EMP_DETAIL.EMPLOYEE_ID=EMP_PROJECT.EMPLOYEE_ID left JOIN  "
                + "EMP_DETAIL emp on emp.EMPLOYEE_ID=EMP_PROJECT.PROJ_REPORTING_MGR_ID WHERE EMP_PROJECT.STATUS_ID='3' "
                + "AND EMP_PROJECT.PROJECT_ID=?",
                new Object[]{projectId},
                (rs, rowNum) ->
                new Hierarchy(
                        rs.getString("EMP_ID"),
                        rs.getString("MGR_ID"),
                       // rs.getLong("PROJ_POSITION_ID"),
                       // rs.getLong("ASSIGNED_BY"),
                        rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"),
                        rs.getString("EMAILID"),
                        rs.getString("MANAGER"),
                        rs.getString("PROJECT_ALLOCATION")
                )
);
	}

	

	

	

	@Override
	public int publish(long id) {
		return jdbcTemplate.update(
                "update PROJECTS set PROJECT_STATUS_ID = '0' where RCD_ID = ?",
                id);
	}

	

	@Override
	public int saveToChild(String projectId, List<String> goalIds) {
		int x=0;
		for(String goalId:goalIds) {
			x=jdbcTemplate.update(
	                "insert into COMP_PROJECT_GOAL (PROJECT_ID, GOAL_ID) values(?,?)",
	                projectId,goalId);
		}
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public int saveToLog(String projectId, String action) {
		return jdbcTemplate.update(
                "insert into PROJECT_LOG (PROJECT_ID, EVENT_DESCRIPTION) values(?,?)",
                projectId, action);
	}

	@Override
	public List<Project> findProject() {
		return jdbcTemplate.query(
                "select RCD_ID,PROJECT_ID,PROJECT_NAME,PROJECT_START_DATE,PROJECT_END_DATE,PROJECT_CUSTOMER,PROJECT_DESCRIPTION,PROJECT_STATUS_ID,CREATOR_ID from PROJECTS",
                (rs, rowNum) ->
                        new Project(
                        		rs.getLong("RCD_ID"),
                                rs.getString("PROJECT_ID"),
                                rs.getString("PROJECT_NAME"),
                                rs.getString("PROJECT_START_DATE"),
                                rs.getString("PROJECT_END_DATE"),
                                rs.getString("PROJECT_CUSTOMER"),
                                rs.getString("PROJECT_DESCRIPTION"),
                                rs.getString("PROJECT_STATUS_ID"),
                                rs.getString("CREATOR_ID"))
        );
	}

	@Override
	public List<ProGoal> getChildData(String id) {
		return jdbcTemplate.query("SELECT COMP_PROJECT_GOAL.GOAL_ID AS GOALID, GOALS.GOAL_NAME AS GOALNAME FROM "
				+ "COMP_PROJECT_GOAL JOIN GOALS ON COMP_PROJECT_GOAL.GOAL_ID=GOALS.GOAL_ID WHERE "
				+ " COMP_PROJECT_GOAL.PROJECT_ID=?", new Object[]{id},
				(rs, rowNum) ->new ProGoal(
                rs.getString("GOALID"),
                rs.getString("GOALNAME")));
	}

	@Override
	public int deleteByIdChild(String projectId) {
		return jdbcTemplate.update(
                "DELETE FROM COMP_PROJECT_GOAL where PROJECT_ID=?",
                projectId);
	}

	@Override
	public int deleteByIdChild(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIdStatus(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "update PROJECTS set PROJECT_STATUS_ID = '1' where RCD_ID = ?",
                id);
	}

	@Override
	public int removeFromChild(String projectId, List<String> removedGoals) {
		int x=0;
		for(String goalId:removedGoals) {
			x=jdbcTemplate.update(
	                "DELETE from COMP_PROJECT_GOAL where PROJECT_ID=? and GOAL_ID=?",
	                projectId,goalId);
		}
		return x;
	}

	@Override
	public int updateToChild(String projectId, List<String> addedGoals) {
		int x=0;
		for(String goalId:addedGoals) {
			x=jdbcTemplate.update(
	                "insert into COMP_PROJECT_GOAL (PROJECT_ID, GOAL_ID) values(?,?)",
	                projectId,goalId);
		}
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public List<Project> searchProject(String buildQuery) {
		return jdbcTemplate.query(buildQuery,
                (rs, rowNum) ->
                        new Project(
                        		rs.getLong("RCD_ID"),
                                rs.getString("PROJECT_ID"),
                                rs.getString("PROJECT_NAME"),
                                rs.getString("PROJECT_START_DATE"),
                                rs.getString("PROJECT_END_DATE"),
                                rs.getString("PROJECT_CUSTOMER"),
                                rs.getString("PROJECT_DESCRIPTION"),
                                rs.getString("PROJECT_STATUS_ID"),
                                rs.getString("CREATOR_ID"))
        );
	}

	@Override
	public List<String> getProjectIdByGoalId(String goalId) {
		// TODO Auto-generated method stub
		
				return jdbcTemplate.query("SELECT PROJECT_ID FROM COMP_PROJECT_GOAL WHERE goal_id='"+goalId.trim()+"'",
						(rs, rowNum) ->new String(
		                rs.getString("PROJECT_ID")));
	}

	@Override
	public List<ProjectRole> getProjecRoles() {
		return jdbcTemplate.query(
                "SELECT ROLE_ID,ROLE_NAME FROM ORG_PROJECT_ROLE",
                (rs, rowNum) ->
                new ProjectRole(
                        rs.getLong("ROLE_ID"),
                        rs.getString("ROLE_NAME")));
	}
	@Override
	public List<EmpProject> getProjectListInDraft() {
		return jdbcTemplate.query("SELECT EMP_PROJECT.RCD_ID,EMP_PROJECT.EMPLOYEE_ID,EMP_DETAIL.EMAIL,EMP_PROJECT.PROJECT_ID,"
				+ "PROJECTS.PROJECT_NAME,EMP_PROJECT.PROJECT_ASSIGNED_DATE,"
				+ "EMP_PROJECT.ASSIGNED_BY,EMP_PROJECT.PROJ_START_DATE,EMP_PROJECT.PROJ_END_DATE,"
				+ "EMP_PROJECT.PROJ_UTL_PERCENT,EMP_PROJECT.PROJ_REPORTING_MGR_ID,EMP_PROJECT.PROJ_POSITION_ID,"
				+ "MSTR_POSITION.POSITION_NAME,EMP_PROJECT.STATUS_ID,MSTR_STATUS.STATUS_VALUE,"
				+ "EMP_PROJECT.LAST_UPDATED_DATE FROM EMP_PROJECT JOIN MSTR_STATUS ON "
				+ "MSTR_STATUS.STATUS_ID=EMP_PROJECT.STATUS_ID LEFT JOIN PROJECTS "
				+ "ON PROJECTS.PROJECT_ID=EMP_PROJECT.PROJECT_ID LEFT JOIN EMP_DETAIL ON "
				+ "EMP_PROJECT.EMPLOYEE_ID=EMP_DETAIL.EMPLOYEE_ID LEFT JOIN MSTR_POSITION ON "
				+ "EMP_PROJECT.PROJ_POSITION_ID=MSTR_POSITION.POSITION_ID WHERE EMP_PROJECT.STATUS_ID='2'",
                (rs, rowNum) ->
                        new EmpProject(
                        		rs.getLong("RCD_ID"),
                                rs.getString("EMPLOYEE_ID"),
                                rs.getString("EMAIL"),
                                rs.getString("PROJECT_ID"),
                                rs.getString("PROJECT_NAME"),
                                rs.getString("PROJECT_ASSIGNED_DATE"),
                                rs.getString("ASSIGNED_BY"),
                                rs.getString("PROJ_START_DATE"),
                                rs.getString("PROJ_END_DATE"),
                                rs.getString("PROJ_UTL_PERCENT"),
                                rs.getString("PROJ_REPORTING_MGR_ID"),
                                rs.getString("PROJ_POSITION_ID"),
                                rs.getString("POSITION_NAME"),
                                rs.getString("STATUS_ID"),
                                rs.getString("STATUS_VALUE"),
                                rs.getString("LAST_UPDATED_DATE"))
        );
	}
	@Override
	public int publishResourceToProject(long rcdId) {
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		return jdbcTemplate.update(
                "update EMP_PROJECT set STATUS_ID = '3',LAST_UPDATED_DATE=? where RCD_ID = ?",
                sysDate,rcdId);
	}
	@Override
	public int releaseResourceFromProject(EmpProject empProject) {
		int updatedCount=0;
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		for(String empId:empProject.getEmpIds()) {
			updatedCount= jdbcTemplate.update(
                "update EMP_PROJECT set STATUS_ID = '4',LAST_UPDATED_DATE=? where EMPLOYEE_ID = ? and PROJECT_ID=?",
                sysDate,empId,empProject.getProId());
		}
		 return updatedCount;
	}
	@Override
	public int updateResourceProject(EmpProject empProject) {
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		return jdbcTemplate.update(
                "update EMP_PROJECT set EMPLOYEE_ID=?,PROJECT_ID=?,PROJ_START_DATE=?,PROJ_END_DATE=?,"
                + "PROJ_UTL_PERCENT=?,PROJ_REPORTING_MGR_ID=?,PROJ_POSITION_ID=?,LAST_UPDATED_DATE=? where RCD_ID = ?",
                empProject.getEmpId(),empProject.getProId(),empProject.getProStartDate(),empProject.getProEndDate(),
                empProject.getProUtlPer(),empProject.getProRepMgrId(),empProject.getPositionId(),sysDate,empProject.getRcdId());
	}
	@Override
	public long existingProject(String projectId) {
		return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM PROJECTS WHERE PROJECTS.PROJECT_ID=?",
                new Object[]{projectId},
                long.class
        );
	}

	

	
}
