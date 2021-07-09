package com.gss.pulseworkflow.service;

import java.util.List;

import com.gss.pulseworkflow.model.EmpProject;
import com.gss.pulseworkflow.model.Hierarchy;
import com.gss.pulseworkflow.model.ProGoal;
import com.gss.pulseworkflow.model.Project;
import com.gss.pulseworkflow.model.ProjectRole;

public interface ProjectService {
	
	int count();

	int saveProject(Project project);

	int updateProject(Project project,boolean updateflag);

	List<Hierarchy> updateProjectHierarchy(String projectId, List<Hierarchy> hierarchy);

	int deleteByIdChild(Long id);

	int deleteById(Long id);

	int deleteByIdChild(String projectId);

	int deleteByIdStatus(Long id);

	List<Hierarchy> getProjectHierarchy(String projectId);

	int saveToLog(String projectId, String action);

	// long getProjectId(String projectName,String customerName);
	int saveToChild(String projectId, List<String> goalIds);

	int publishProject(long id,String comment,String projectID);

	List<ProGoal> getChildData(String id);

	List<Project> getAllProjects();

	int removeFromChild(String projectId, List<String> removedGoals);

	int updateToChild(String projectId, List<String> addedGoals);

	List<Project> searchProject(String buildQuery);

	List<String> getProjectIdByGoalId(String goalId);

	List<ProjectRole> getProjecRoles();
	
	int deleteProject(long rcdId,String projectID,boolean deleteFlag);
	
	List<EmpProject> getProjectListInDraft();
	
	int publishResourceToProject(long rcdId);
	
	int releaseResourceFromProject(EmpProject empProject);
	
	int updateResourceProject(EmpProject empProject);
	
	long existingProject(String projectId);

}
