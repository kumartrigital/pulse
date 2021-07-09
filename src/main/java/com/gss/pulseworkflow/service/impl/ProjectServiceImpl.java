package com.gss.pulseworkflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gss.pulseworkflow.dao.ProjectRepository;
import com.gss.pulseworkflow.model.EmpProject;
import com.gss.pulseworkflow.model.Hierarchy;
import com.gss.pulseworkflow.model.ProGoal;
import com.gss.pulseworkflow.model.Project;
import com.gss.pulseworkflow.model.ProjectRole;
import com.gss.pulseworkflow.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int saveProject(Project project) {
		int childFlag = 0;
		int addFlag = projectRepository.save(project);
		if (addFlag > 0) {
			childFlag = projectRepository.saveToChild(project.getProjectId(), project.getGoalIds());
		}
		return childFlag;
	}

	@Override
	@Transactional
	public int updateProject(Project project, boolean updateflag) {
		int updateProFlag = 0;
		int resFlag = 0;
		if (updateflag) {
			updateProFlag = projectRepository.updateProj(project);
			if (updateProFlag > 0) {
				if (project.getRemovedGoals().size() > 0) {
					projectRepository.removeFromChild(project.getProjectId(), project.getRemovedGoals());
				}
				if (project.getGoalIds().size() > 0) {
					projectRepository.updateToChild(project.getProjectId(), project.getGoalIds());
				}
				resFlag = 1;
			}
		} else if (!updateflag) {
			updateProFlag = projectRepository.updateProj(project);
			if (updateProFlag > 0) {
				if (project.getRemovedGoals().size() > 0) {
					projectRepository.removeFromChild(project.getProjectId(), project.getRemovedGoals());
				}
				if (project.getGoalIds().size() > 0) {
					projectRepository.updateToChild(project.getProjectId(), project.getGoalIds());
				}

				int logFlag = projectRepository.saveToLog(project.getProjectId(), "Update_" + project.getComment());
				if (logFlag > 0) {
					resFlag = 1;
				}
			}
		}
		return resFlag;
	}

	@Override
	public List<Hierarchy> updateProjectHierarchy(String projectId, List<Hierarchy> hierarchy) {
		int updateProjectHierarchyFlag = projectRepository.update(projectId, hierarchy);
		if (updateProjectHierarchyFlag > 0) {
			return projectRepository.findAll(projectId.trim());
		}
		return null;
		
	}

	@Override
	public int deleteByIdChild(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIdChild(String projectId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByIdStatus(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Hierarchy> getProjectHierarchy(String projectId) {
		return projectRepository.findAll(projectId.trim());
	}

	@Override
	public int saveToLog(String projectId, String action) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveToChild(String projectId, List<String> goalIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int publishProject(long id,String comment,String projectID) {
		int logFlag=0;
		int publishFlag = projectRepository.publish(id);
		if (publishFlag > 0) {
			logFlag = projectRepository.saveToLog(projectID, "Add_" + comment);
		}
		return logFlag;
	}

	@Override
	public List<ProGoal> getChildData(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projectRes = projectRepository.findProject();
		if (projectRes.size() > 0) {
			for (Project projObj : projectRes) {
				List<ProGoal> proGaolObj = projectRepository.getChildData(projObj.getProjectId());
				projObj.setGoals(proGaolObj);
			}
		}
		return projectRes;
	}

	@Override
	public int removeFromChild(String projectId, List<String> removedGoals) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateToChild(String projectId, List<String> addedGoals) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Project> searchProject(String buildQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getProjectIdByGoalId(String goalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProjectRole> getProjecRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public int deleteProject(long rcdId, String projectID, boolean deleteFlag) {
		int deleteResFlag=0;
		int deletedFlag=0;
		if (deleteFlag) {
			deleteResFlag = projectRepository.deleteById(rcdId);
			if (deleteResFlag > 0) {
				projectRepository.deleteByIdChild(projectID);
				deletedFlag=1;
			}
		} else if (!deleteFlag) {
			deleteResFlag = projectRepository.deleteByIdStatus(rcdId);
			if (deleteResFlag > 0) {
				projectRepository.saveToLog(projectID, "Delete");
				deletedFlag=1;
			}
		}
		return deletedFlag;
	}

	@Override
	public List<EmpProject> getProjectListInDraft() {
		return projectRepository.getProjectListInDraft();
	}

	@Override
	public int publishResourceToProject(long rcdId) {
		return projectRepository.publishResourceToProject(rcdId);
	}

	@Override
	public int releaseResourceFromProject(EmpProject empProject) {
		return projectRepository.releaseResourceFromProject(empProject);
	}

	@Override
	public int updateResourceProject(EmpProject empProject) {
		return projectRepository.updateResourceProject(empProject);
	}

	@Override
	public long existingProject(String projectId) {
		// TODO Auto-generated method stub
		return projectRepository.existingProject(projectId);
	}

}
