package com.gss.pulseworkflow.dao;

import java.util.List;

import com.gss.pulseworkflow.model.EmpProject;
import com.gss.pulseworkflow.model.Hierarchy;
import com.gss.pulseworkflow.model.ProGoal;
import com.gss.pulseworkflow.model.Project;
import com.gss.pulseworkflow.model.ProjectRole;

public interface ProjectRepository {

	int count();

	int save(Project role);

	int updateProj(Project role);

	int update(String projectId, List<Hierarchy> hierarchy);

	int deleteByIdChild(Long id);

	int deleteById(Long id);

	int deleteByIdChild(String projectId);

	int deleteByIdStatus(Long id);

	List<Hierarchy> findAll(String projectId);

	int saveToLog(String projectId, String action);

	// long getProjectId(String projectName,String customerName);
	int saveToChild(String projectId, List<String> goalIds);

	int publish(long id);

	List<ProGoal> getChildData(String id);

	List<Project> findProject();

	int removeFromChild(String projectId, List<String> removedGoals);

	int updateToChild(String projectId, List<String> addedGoals);

	List<Project> searchProject(String buildQuery);

	List<String> getProjectIdByGoalId(String goalId);
	
	List<EmpProject> getProjectListInDraft();

	List<ProjectRole> getProjecRoles();
	
	int publishResourceToProject(long rcdId);
	
	int releaseResourceFromProject(EmpProject empProject);
	
	int updateResourceProject(EmpProject empProject);
	
	long existingProject(String projectId);

}
