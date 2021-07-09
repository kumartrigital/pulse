package com.gss.pulseworkflow.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gss.pulseworkflow.dao.EmployeeRepository;
import com.gss.pulseworkflow.model.AssesseeCapability;
import com.gss.pulseworkflow.model.Assessees;
import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.Capability;
import com.gss.pulseworkflow.model.EmpAccessRole;
import com.gss.pulseworkflow.model.EmpAssessee;
import com.gss.pulseworkflow.model.EmpAssessment;
import com.gss.pulseworkflow.model.EmpDisable;
import com.gss.pulseworkflow.model.EmpGoal;
import com.gss.pulseworkflow.model.EmpHierarchy;
import com.gss.pulseworkflow.model.EmpProject;
import com.gss.pulseworkflow.model.EmpProjectNotes;
import com.gss.pulseworkflow.model.EmpSearch;
import com.gss.pulseworkflow.model.EmpTraining;
import com.gss.pulseworkflow.model.Employee;
import com.gss.pulseworkflow.model.EmployeeProject;
import com.gss.pulseworkflow.model.EmployeeSearchResponse;
import com.gss.pulseworkflow.model.HomeObj;
import com.gss.pulseworkflow.model.Notification;
import com.gss.pulseworkflow.model.ProGoal;
import com.gss.pulseworkflow.model.Project;
import com.gss.pulseworkflow.model.Reportee;
import com.gss.pulseworkflow.model.Task;
import com.gss.pulseworkflow.model.Users;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.oauth.service.WSO2UserWebService;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.EmployeeService;
import com.gss.pulseworkflow.utility.Helper;
import com.gss.pulseworkflow.utility.Validation;

@RestController
@RequestMapping("/Employee")
public class EmployeeController { 

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private WSO2UserWebService wSO2UserWebService;

	
	@PostMapping("/bulkUpload")
	public Response userBulkUpload(@RequestBody Users users) {
		// Response response=new Response(); System.out.println("Entering");
		try {
			if (users.getEmployees().size() > 0) {
				System.out.println("Count ::" + users.getEmployees().size());
				int var = employeeRepository.save(users);
				if (var > 0) {
					int processedFlag = employeeService.processFromStaging();
					if (processedFlag > 0) {
						return ResponseHelper.buildSuccessResponse("Success");
					}
				}
				/*
				 * System.out.println("After Save::COntroller"); HashMap<String, Integer> count
				 * = new HashMap<String, Integer>(); count.put("Number of employees uploaded :",
				 * var);
				 */
			}
		} catch (Exception e) {
			// logger.error("error in ComplaintTypeController:::" + e);
			// handle exceptions and build response with error details
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/postStage/{flag}")
	public Response postStage(@PathVariable(value = "flag") boolean flag) {
		// Response response=new Response();
		System.out.println("Entering");
		Validation validation = new Validation();
		try {
			if (!flag) {
				List<Employee> dataFromStaging = employeeRepository.findAll();
				System.out.println("dataFromStaging ::" + dataFromStaging);
				if (dataFromStaging.size() > 0) {
					HashMap<String, List<Employee>> processedUsers = validation.employeeValidation(dataFromStaging);
					System.err.println("Process::" + processedUsers);
					if (processedUsers.size() > 0) {
						//int dbUpdate = employeeService.bulkUsersToDB(processedUsers.get("Process"));
						//int dbUpdate2 = employeeRepository.save(processedUsers.get("Failed"));
						//employeeService.createReport(processedUsers.get("Failed"));
						//int delete = employeeRepository.delete();
						return ResponseHelper.buildSuccessResponse("Success");
					}
				} else {
					return ResponseHelper.buildIdResponse("There is no Data AVailable in staging table to Process");
				}

			}
			/*
			 * if (users.getEmployees().size() > 0) { System.out.println("Count ::" +
			 * users.getEmployees().size()); int var = employeeRepository.save(users);
			 * System.out.println("After Save::COntroller"); HashMap<String, Integer> count
			 * = new HashMap<String, Integer>(); count.put("Number of employees uploaded :",
			 * var); return ResponseHelper.buildIdResponse(count); }
			 */
		} catch (Exception e) {
			// logger.error("error in ComplaintTypeController:::" + e);
			// handle exceptions and build response with error details
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@GetMapping("/getError")
	public Response getErrorRecords() {
		System.out.println("Entering");
		try {
			List<Employee> errorRecods = employeeRepository.findErrorRecords();
			System.out.println("dataFromStaging ::" + errorRecods);
			if (errorRecods.size() > 0) {
				return ResponseHelper.buildResponse(errorRecods, "Success");
			} else {
				return ResponseHelper.buildResponse(errorRecods, "Success");
			}

			/*
			 * if (users.getEmployees().size() > 0) { System.out.println("Count ::" +
			 * users.getEmployees().size()); int var = employeeRepository.save(users);
			 * System.out.println("After Save::COntroller"); HashMap<String, Integer> count
			 * = new HashMap<String, Integer>(); count.put("Number of employees uploaded :",
			 * var); return ResponseHelper.buildIdResponse(count); }
			 */

		} catch (Exception e) {
			// logger.error("error in ComplaintTypeController:::"+ e);
			// handle exceptions and build response with error details
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
	}
	  
	@GetMapping("/getErrorRecord/{rcdId}")
	public Response getErrorRecById(@PathVariable(value = "rcdId") long rcdId) {
		System.out.println("Entering");
		try {
			Employee errorRecods = employeeRepository.findErrorRecordById(rcdId);
			System.out.println("dataFromStaging ::" + errorRecods);
			if (errorRecods != null) {
				return ResponseHelper.buildResponse(errorRecods, "Success");
			} else {
				return ResponseHelper.buildResponse(errorRecods, "Success");
			}

			/*
			 * if (users.getEmployees().size() > 0) { System.out.println("Count ::" +
			 * users.getEmployees().size()); int var = employeeRepository.save(users);
			 * System.out.println("After Save::COntroller"); HashMap<String, Integer> count
			 * = new HashMap<String, Integer>(); count.put("Number of employees uploaded :",
			 * var); return ResponseHelper.buildIdResponse(count); }
			 */

		} catch (Exception e) {
			// logger.error("error in ComplaintTypeController:::" + e);
			// handle exceptions and build response with error details
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
	}
	  
	@PostMapping("/createUser")
	public Response createUser(@RequestBody Employee employee) { // Response response=new Response();
		System.out.println("Entering");
		try {
			if (employee != null) {
				System.out.println("Count ::" + employee);
				int flag=employeeService.createUser(employee);
				if(flag>0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
				

			}
		} catch (Exception e) {
			System.out.println(e);
			return ResponseHelper.buildExceptionResponse(e);
			
		}
		return null;
	}

	@PutMapping("/deleteErrorRecord/{rcdId}")
	public Response deleteErrorRecord(@PathVariable(value = "rcdId") long rcdId) {
		System.out.println("Entering");
		try {
			int deleteFlag = employeeRepository.delete(rcdId);
			if (deleteFlag > 0) {
				return ResponseHelper.buildSuccessResponse("Success");
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@GetMapping("/getUserBasicDetails/{employeeId}")
	public Response getUserDetatilsById(@PathVariable(value = "employeeId") String employeeId) {
		System.out.println("Entering");
		try {
			Employee employee = employeeRepository.findUserById(employeeId.trim());
			System.out.println("dataFromStaging ::" + employee);
			if (employee != null) {
				return ResponseHelper.buildResponse(employee, "Success");
			} else {
				return ResponseHelper.buildResponse(employee, "Success");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
	}
	  
	@GetMapping("/getUserProjects/{employeeId}")
	public Response getUserProjects(@PathVariable(value = "employeeId") String employeeId) {
		System.out.println("Entering");
		try {
			List<EmployeeProject> employeeProject = employeeRepository.findProjectsByID(employeeId.trim());
			System.out.println("dataFromStaging ::" + employeeProject);
			if (employeeProject.size() > 0) {
				return ResponseHelper.buildResponse(employeeProject, "Success");
			} else {
				return ResponseHelper.buildResponse(employeeProject, "Success");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
	}
	  
	@GetMapping("/getEmpOrgHierarchy/{employeeId}")
	public Response getEmployeeOrgHierarchy(@PathVariable(value = "employeeId") String employeeId) {
		try {

			List<EmpHierarchy> employeeProject = employeeRepository.empOrgHierarchy(employeeId.trim());

			if (employeeProject.size() > 0) {
				Helper helper = new Helper();
				EmpHierarchy employee = helper.hierarchyMap(employeeProject);
				System.out.println("dataFromStaging ::" + employeeProject);
				return ResponseHelper.buildResponse(employeeProject.get(0), "Success");
			} else {
				return ResponseHelper.buildResponse(employeeProject, "Success");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
	}
	  
	@PutMapping("/discardAllError")
	public Response discardAllErrorRecords() { //
		System.out.println("Entering");
		try {
			int deleteFlag = employeeRepository.deleteAllErrorecords();
			if (deleteFlag > 0) {
				return ResponseHelper.buildSuccessResponse("Success");
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/updateEmpBasicInfo")
	public Response updateEmpBasicInfo(@RequestBody Employee employee) { //
		System.out.println("Entering");
		try {
			int updateFlag = employeeRepository.updateEmpBasicInfo(employee);
			if (updateFlag > 0) {
				return ResponseHelper.buildSuccessResponse("Success");
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	@PostMapping("/addToProject")
	public Response addEmpToProject(@RequestBody EmpProject empProject) {
		// System.out.println("Entering");
		try {
			if (empProject != null) {
			int updateFlag = employeeRepository.addResourceToProj(empProject);
			if (updateFlag > 0) {
				return ResponseHelper.buildSuccessResponse("Success");
			}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	@GetMapping("/getUserDetail/{emailId}")
	public Response getUserdetailsByEmail(@PathVariable(value = "emailId") String emailId) {
		System.out.println("Entering");
		try {
			Employee employee = employeeRepository.findUserByEmail(emailId.trim());
			System.out.println("dataFromStaging ::" + employee);
			if (employee != null) {
				return ResponseHelper.buildResponse(employee, "Success");
			} else {
				return ResponseHelper.DUPLICATE_EMAIL_RESPONSE;
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
	}
	  
	@RequestMapping("/errorRecordDownload/{fileName:.+}")
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("fileName") String fileName
	/* @RequestHeader String referer */) {
		// System.out.println(fileName);
		/*
		 * if(referer != null && !referer.isEmpty()) { //do nothing //or send error }
		 */
		// If user is not authorized - he should be thrown out from here itself

		// Authorized user will download the file
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/download/");
		Path file = Paths.get(dataDirectory, fileName);
		if (Files.exists(file)) {
			//response.setContentType("application/pdf");
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	  
	@PostMapping("/assignGoal")
	public Response assignGoalToEmployees(@RequestBody EmpGoal empGoal) { //
		//System.out.println("Entering");
		try {
			int addedFlag = employeeRepository.assignGoalToEmployees(empGoal);
			if (addedFlag > 0) {
				return ResponseHelper.buildSuccessResponse("Success");
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	@PostMapping("/assignTraining")
	public Response assignTrainingToEmployees(@RequestBody EmpTraining empTraining) { //
		System.out.println("Entering");
		try {
			int addedFlag = employeeRepository.assignTrainingToEmployees(empTraining);
			if (addedFlag > 0) {
				return ResponseHelper.buildSuccessResponse("Success");
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@GetMapping("/getUserDetails/{emailId}")
	public Response getUserdetailsByEmailSearch(@PathVariable(value = "emailId") String emailId) {
		System.out.println("Entering");
		try {
			List<Employee> employee = employeeRepository.findUserByEmailSearch(emailId.trim());
			System.out.println("dataFromStaging ::" + employee);
			if (employee.size() > 0) {
				return ResponseHelper.buildResponse(employee, "Success");
			} else {
				return ResponseHelper.DUPLICATE_EMAIL_RESPONSE;
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
	}
	  
	@GetMapping("/getEmpTraining/{empId}/{activeFlag}")
	public Response getEmpTrng(@PathVariable(value = "empId") String empId,

			@PathVariable(value = "activeFlag") boolean activeFlag) {
		try {
			String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
			if (!loggedInUser.isEmpty() && loggedInUser != null) {
				List<EmpTraining> empTrng = null;
				if (activeFlag) {
					empTrng = employeeRepository.getEmpActiveTrng(loggedInUser.trim());
				} else if (!activeFlag) {
					empTrng = employeeRepository.getEmpHistoryTrng(loggedInUser.trim());
				} //
				System.out.println("dataFromStaging ::" + empTrng);
				if (empTrng.size() > 0) {
					return ResponseHelper.buildResponse(empTrng, "Success");
				} else {
					return ResponseHelper.buildResponse(empTrng, "Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	@PutMapping("/completeTraining/{rcdId}/{comment}")
	public Response completeTraining(@PathVariable(value = "rcdId") long rcdId,

			@PathVariable(value = "comment") String comment) {
		try {
			if (rcdId > 0) {
				int var = employeeRepository.completeTraining(rcdId, comment);
				if (var > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	@GetMapping("/getEmpGoals/{empId}/{activeFlag}")
	public Response getEmpGoals(@PathVariable(value = "empId") String empId,

			@PathVariable(value = "activeFlag") boolean activeFlag) {
		try {
			String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
			if (!loggedInUser.isEmpty() && loggedInUser != null) {
				List<EmpGoal> empTrng = null;
				if (activeFlag) {
					empTrng = employeeRepository.getEmpActiveGoals(loggedInUser.trim());
				} else if (!activeFlag) {
					empTrng = employeeRepository.getEmpHistoryGoals(loggedInUser.trim());
				} //
				System.out.println("dataFromStaging ::" + empTrng);
				if (empTrng.size() > 0) {
					return ResponseHelper.buildResponse(empTrng, "Success");
				} else {
					return ResponseHelper.buildResponse(empTrng, "Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	@PutMapping("/updateGoalProgress")
	public Response updateGoalProgress(@RequestBody EmpGoal empGoal) {
		try {
			if (empGoal != null) {

				int var = employeeRepository.updateGoalProgress(empGoal);
				if (var > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}

			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	@GetMapping("/getGoalsForApproval/{approverId}")
	public Response getPendingGoalsForApproval(@PathVariable(value = "approverId") String approverId) {
		try {
			String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
			if (!loggedInUser.isEmpty() && loggedInUser != null) {
				System.out.println("emp controller");
				List<EmpGoal> empGoals = employeeRepository.getPendingGoalsForApproval(approverId.trim());
				if (empGoals.size() > 0) {
					return ResponseHelper.buildResponse(empGoals, "Success");
				} else {
					return ResponseHelper.buildResponse(empGoals, "Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	@PutMapping("/approverActionOnGoal/{approverId}")
	public Response actionOnGoalByApprover(@RequestBody EmpGoal empGoal,

			@PathVariable(value = "approverId") String approverId) {
		try {
			String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
			if (loggedInUser != null && !loggedInUser.isEmpty()) {
				String status = null;
				if (empGoal.getApproverAction().equalsIgnoreCase("REJECT")) {
					status = "7";
				} else if (empGoal.getApproverAction().equalsIgnoreCase("APPROVE")) {
					status = "9";
				}
				int var = employeeRepository.actionOnGoalByApprover(empGoal.getRcdId(), status, empGoal.getComment());
				if (var > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}

			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	/*
	 * @PostMapping("/searchEmpByBasicDetails") public Response
	 * searchEmpByBasicDetails(@RequestBody Employee employee) { //
	 * System.out.println("Entering"); try { if (employee != null) {
	 * 
	 * }
	 * 
	 * int addedFlag = employeeRepository.assignGoalToEmployees(empGoal); if
	 * (addedFlag > 0) { return ResponseHelper.buildSuccessResponse("Success"); }
	 * 
	 * } catch (Exception e) { return ResponseHelper.buildExceptionResponse(e); }
	 * return null; }
	 */
	  
	@GetMapping("/getEmpProjects/{employeeId}")
	public Response getEmpProjectsById(@PathVariable(value = "employeeId") String employeeId) {
		try {
			String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
			if (!loggedInUser.isEmpty() && loggedInUser != null) {
				System.out.println("emp controller");
				List<EmpProject> empProjects = employeeRepository.getEmpProjectsByID(loggedInUser.trim());
				if (empProjects.size() > 0) {
					return ResponseHelper.buildResponse(empProjects, "Success");
				} else {
					return ResponseHelper.buildResponse(empProjects, "Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	@PostMapping("/addCommentsOnProject")
	public Response addNotesOnProjectByEmp(@RequestBody EmpProjectNotes empProNotes) { //
		System.out.println("Entering");
		try {
			if (empProNotes != null) {
				String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
				empProNotes.setProjectCommentorId(loggedInUser);
				int addedFlag = employeeRepository.addNotesOnProjectByEmp(empProNotes);
				if (addedFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}

			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	  
	@GetMapping("/viewProjectDetails/{projectId}")
	public Response getProjectDetails(@PathVariable(value = "projectId") String projectId) {

		try {
			if (!projectId.isEmpty() && projectId != null) {
				System.out.println("emp controller");
				Project empProjects = employeeRepository.getProjectDetailsById(projectId.trim());
				System.out.println("emp controller2");
				if (empProjects != null) {
					System.out.println("emp controller3");
					List<ProGoal> proGaolObj = employeeRepository.getChildData(projectId.trim());
					empProjects.setGoals(proGaolObj);
					System.out.println("emp controller4");
					List<EmpProjectNotes> empProjectNotes = employeeRepository.getProjectNotes(projectId.trim());
					System.out.println("emp controller5" + empProjectNotes.size());
					empProjects.setProjectNoteHistory(empProjectNotes);
					System.out.println("emp controller6");
					return ResponseHelper.buildResponse(empProjects, "Success");
				} else {
					return ResponseHelper.buildResponse(empProjects, "Success");
				}

			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	 

	@PostMapping("/disableEmployee")
	public Response disableEmployee(@RequestBody EmpDisable empDisable) {
		// System.out.println("Entering");
		try {
			if (empDisable != null) {

				int addedFlag = employeeService.disableEmployee(empDisable);
				if (addedFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}

			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PostMapping("/removeResourceFromProject")
	public Response removeResourceFromProject(@RequestBody List<String> empIds) {
		// System.out.println("Entering");
		try {
			if (empIds.size()>0) {

				int addedFlag = employeeService.removeResourceFromProject(empIds);
				if (addedFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}

			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@GetMapping("/getEmpAssessments/asAssessor/{empId}")
	public Response getAssessmentsByEmpIdAsAssessor(@PathVariable(value = "empId") String empId) {
		try {
			List<EmpAssessment> empAssessments=null;
			String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
			if(loggedInUser!=null) {
				empAssessments = employeeService.getAssessmentsByEmpIdAsAssessor(loggedInUser);
				if (empAssessments.size() > 0) {
					return ResponseHelper.buildResponse(empAssessments, "Success");
				}else {
					return ResponseHelper.buildResponse(empAssessments, "Success");
				}

			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@GetMapping("/getEmpAssessments/asAssessee/{empId}")
	public Response getAssessmentsByEmpIdAsAssessee(@PathVariable(value = "empId") String empId) {
		System.out.println("Entering");
		List<EmpAssessment> empAssessments=null;
		try {
			String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
			if(loggedInUser!=null) {
				empAssessments = employeeService.getAssessmentsByEmpIdAsAssessee(loggedInUser);
				if (empAssessments.size() > 0) {
					return ResponseHelper.buildResponse(empAssessments, "Success");
				}else {
					return ResponseHelper.buildResponse(empAssessments, "Success");
				}

			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PostMapping("/completeAssessments")
	public Response completeAssessments(@RequestBody EmpAssessment empAssessment) {
		 System.out.println("Entering");
		try {
			if (empAssessment!=null) {
				int updatedFlag = employeeService.completeAssessment(empAssessment);
				System.out.println("flag"+updatedFlag);
				if (updatedFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}

			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/search")
	//@PutMapping(value = "/search", consumes = "application/json", produces = "application/json")
	//@RequestMapping(value = "/search", method = RequestMethod.PUT, headers = "Accept=application/json")
	//@ResponseBody
	public Response employeeSearch(@RequestBody EmpSearch empSearch) {
		try {
			//System.out.println("empSearch::before"+empSearch);
			//if(empSearch!=null) {
			//	System.out.println("empSearch::"+empSearch);
			 List<Employee> employeeList=employeeService.employeeSearch(empSearch);
				if(employeeList.size()>0) {
					return ResponseHelper.buildResponse(employeeList,"Success");
				}else {
					List<Employee> employeeList2=new ArrayList<Employee>();
					return ResponseHelper.buildResponse(employeeList2,"Success");
				}
			//}
	} catch (Exception e) {
		return ResponseHelper.buildExceptionResponse(e);
	}
	
	}
	
	@PutMapping("/dashboard/tasks")
	public Response myTaks() {
		try {
			String loggedInUser = SecurityUtils.getLoggedInUser().getUserId();
			if (loggedInUser != null) {
				Task task = employeeService.myTasks(loggedInUser);
				if (task != null) {
					return ResponseHelper.buildResponse(task, "Success");
				}else {
					return ResponseHelper.buildResponse(task, "Success");
				}

			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;

	}
	
	@PutMapping("/dashboard/reportee")
	public Response myReportees() {
		try {
			String loggedInUser = SecurityUtils.getLoggedInUser().getUserId();
			if (loggedInUser != null) {
				List<Reportee> reporteeList = employeeService.myReportees(loggedInUser);
				if (reporteeList != null) {
					return ResponseHelper.buildResponse(reporteeList, "Success");
				}else {
					return ResponseHelper.buildResponse(reporteeList, "Success");
				}

			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;

	}
	
	@PutMapping("/dashboard/notifications")
	public Response myNotifications() {
		try {
			String loggedInUser = SecurityUtils.getLoggedInUser().getUserId();
			//String loggedInUser ="12348";
			//System.out.println("12348");
			if (loggedInUser != null) {
				List<Notification> notificationList = employeeService.myNotifications(loggedInUser);
				if (notificationList != null) {
					return ResponseHelper.buildResponse(notificationList, "Success");
				}else {
					return ResponseHelper.buildResponse(notificationList, "Success");
				}

			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;

	}
	
	@PostMapping("/createEmployeeAccessRole")
	public Response createEmployeeAccessRole(@RequestBody EmpAccessRole empAccessRole) {
		 System.out.println("Entering");
		try {
			if (empAccessRole!=null) {
				System.out.println("flag");
				int updatedFlag = employeeService.createEmployeeAccessRole(empAccessRole);
				//System.out.println("flag"+updatedFlag);
				if (updatedFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}

			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/getEmplpoyeeAccessRoles")
	public Response getEmployeeAccessRoles(@RequestBody EmpAccessRole empAccessRole) {
		 System.out.println("Entering");
		try {
			if (empAccessRole.getEmpId()!=null) {
				EmpAccessRole empAccessRoles= employeeService.getEmployeeAccessRoles(empAccessRole.getEmpId().trim());
				//System.out.println("flag"+updatedFlag);
				if (empAccessRoles!=null) {
					return ResponseHelper.buildResponse(empAccessRoles, "Success");
				}else {
					return ResponseHelper.buildResponse(empAccessRoles, "Success");
				}

			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	/*
	 * public static void main(String args[]) {
	 * 
	 * boolean flag = wSO2UserServiceImpl.createUser("devendra.kada",
	 * "devendra.kada@gmail.com"); System.out.println("flag ::"+flag); }
	 */

}
