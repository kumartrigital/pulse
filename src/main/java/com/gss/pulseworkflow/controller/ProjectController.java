package com.gss.pulseworkflow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gss.pulseworkflow.dao.ProjectRepository;
import com.gss.pulseworkflow.model.EmpProject;
import com.gss.pulseworkflow.model.Hierarchies;
import com.gss.pulseworkflow.model.Hierarchy;
import com.gss.pulseworkflow.model.Project;
import com.gss.pulseworkflow.model.ProjectRole;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.ProjectService;
import com.gss.pulseworkflow.utility.QueryObj;

@RestController
@RequestMapping("/Project")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ProjectService projectService;

	@PostMapping("/create")
	public Response createProject(@RequestBody Project project) {
		try {
			if (project != null) {
				long exist=projectService.existingProject(project.getProjectId().trim());
				if(exist == 0) {
					String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
					project.setCreatorId(loggedInUser);
					int addFlag = projectService.saveProject(project);
					if (addFlag > 0) {
						return ResponseHelper.buildSuccessResponse("Success");
					}
				}else if(exist > 0) {
					return ResponseHelper.DUPLICATE_VALIDATION_RESPONSE;
				}
				
			}
		} catch (Exception e) {
			// logger.error("error in ComplaintTypeController:::" + e);
			// handle exceptions and build response with error details
			// System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/publishPro/{rcdId}/{projectID}/{comment}")
	public Response publish(@PathVariable(value = "rcdId") long rcdId, @PathVariable(value = "comment") String comment,
			@PathVariable(value = "projectID") String projectID) {
		try {
			if (rcdId > 0) {
				int publishFlag = projectService.publishProject(rcdId, comment, projectID);
				if (publishFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			// logger.error("error in ComplaintTypeController:::" + e);
			// handle exceptions and build response with error details
			// System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@GetMapping("/getAllProjects")
	public Response getAll() {
		List<Project> projectRes = null;
		try {
			projectRes = projectService.getAllProjects();
			if (projectRes.size() > 0) {
				return ResponseHelper.buildResponse(projectRes, "Success");
			}else {
				return ResponseHelper.buildResponse(projectRes, "Success");
			}

		} catch (Exception e) {
			// logger.error("error in ComplaintTypeController:::" + e);
			// handle exceptions and build response with error details
			// System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}

	}

	@PutMapping("/updatePro/{updateflag}")
	public Response update(@RequestBody Project project, @PathVariable(value = "updateflag") boolean updateflag) {
		try {
			if (project != null) {
				int updateProFlag = projectService.updateProject(project, updateflag);
				if (updateProFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/deleteProj/{deleteFlag}/{rcdId}/{projectID}")
	public Response delete(@PathVariable(value = "rcdId") long rcdId,
			@PathVariable(value = "projectID") String projectID,
			@PathVariable(value = "deleteFlag") boolean deleteFlag) {
		try {
			if (rcdId > 0 && !projectID.isEmpty()) {
				int deleteResFlag = projectService.deleteProject(rcdId, projectID, deleteFlag);
				if (deleteResFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			
			return ResponseHelper.buildExceptionResponse(e);
		}

		return null;
	}

	@GetMapping("/getProjectHierarchy/{projectId}")
	public Response getProjectHierarchy(@PathVariable(value = "projectId") String projectId) {
		try {
		if (!projectId.isEmpty()) {
			List<Hierarchy> roleRes = projectService.getProjectHierarchy(projectId.trim());
			if(roleRes.size() > 0) {
				return ResponseHelper.buildResponse(roleRes, "Success");
			}else {
				return ResponseHelper.buildResponse(roleRes, "Success");	
			}
		}
		} catch (Exception e) {
			System.out.print("error ::"+e);
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/updateHierarchy/{projectId}")
	public Response updateupdateHierarchy(@RequestBody Hierarchies updateHierarchy,
			@PathVariable(value = "projectId") String projectId) {
		try {
			if (!projectId.isEmpty() && updateHierarchy.getUpdateHierarchy().size() > 0) {
				List<Hierarchy> roleRes = projectService.updateProjectHierarchy(projectId, updateHierarchy.getUpdateHierarchy());
				if (roleRes.size() > 0) {
					return ResponseHelper.buildResponse(roleRes, "Success");
				}
			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/searchProject")
	public Response findProject(@RequestBody Project project) {
		try {
		if (project!=null) {
			//List<Project> seachProObj=null;
			QueryObj query=new QueryObj();
			if(project.getStrategicGoalId()!=null) {
				List<String> projectIds=projectRepository.getProjectIdByGoalId(project.getStrategicGoalId());
				System.out.println("ProjectId's::"+projectIds);
				//query.goalIdWithProId(projectIds,project);
				project.setProjectIds(projectIds);
			}
			String buildQuery=query.buildDynamicQueryForProjSearch(project);
			System.out.println("buildQuery::"+buildQuery);
			if(!buildQuery.isEmpty() && buildQuery!=null) {
				List<Project> seachProObj=projectRepository.searchProject(buildQuery);
				//List<Project> proResult=query.filterActivePro(seachProObj);
				return ResponseHelper.buildResponse(seachProObj, "Success");
			}else {
				List<Project> seachProObj2=new ArrayList<Project>();
				return ResponseHelper.buildResponse(seachProObj2, "Success");
			}
			
		}

	} catch (Exception e) {
		// logger.error("error in ComplaintTypeController:::" + e);
		// handle exceptions and build response with error details
		// System.out.println("Exception: " + e.getMessage());
		return ResponseHelper.buildExceptionResponse(e);
	}

	return null;
	}
	
	@GetMapping("/getProjectRoles")
	public Response getProjecRoles() {
		try {
			List<ProjectRole> roleRes = projectRepository.getProjecRoles();
			if(roleRes!=null) {
				return ResponseHelper.buildResponse(roleRes, "Success");
			}
			
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@GetMapping("/getListOfResouceProjectsInDraft")
	public Response getProjectListInDraft() {
		try {
			List<EmpProject> empProjects = projectService.getProjectListInDraft();
			// List<ProjectRole> roleRes = projectRepository.getProjecRoles();
			if (empProjects.size() > 0) {
				return ResponseHelper.buildResponse(empProjects, "Success");
			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/publishResourceToProject/{rcdId}")
	public Response publishResourceToProject(@PathVariable(value = "rcdId") long rcdId) {
		try {
			if (rcdId > 0) {
				int updateFlag=projectService.publishResourceToProject(rcdId);
				//List<Hierarchy> roleRes = projectService.updateProjectHierarchy(projectId, updateHierarchy.getUpdateHierarchy());
				if (updateFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/releaseResourceFromProject")
	public Response releaseResourceFromProject(@RequestBody EmpProject empProject) {
		try {
			if (empProject!=null) {
				int updateFlag=projectService.releaseResourceFromProject(empProject);
				//List<Hierarchy> roleRes = projectService.updateProjectHierarchy(projectId, updateHierarchy.getUpdateHierarchy());
				if (updateFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/updateResourceToProject")
	public Response updateResourceProject(@RequestBody EmpProject empProject) {
		try {
			if (empProject!=null) {
				int updateFlag=projectService.updateResourceProject(empProject);
				//List<Hierarchy> roleRes = projectService.updateProjectHierarchy(projectId, updateHierarchy.getUpdateHierarchy());
				if (updateFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
}
