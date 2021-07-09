package com.gss.pulseworkflow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gss.pulseworkflow.dao.AssessmentRepository;
import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.AssessmentChild;
import com.gss.pulseworkflow.model.EmpAssmtDetail;
import com.gss.pulseworkflow.model.Role;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.AssessmentService;
import com.gss.pulseworkflow.utility.Helper;

@RestController
@RequestMapping("/Assessment")
public class AssessmentController {
	@Autowired
	private AssessmentRepository assessmentRepository;
	
	@Autowired
	private AssessmentService assessmentService;

	/*
	 * @PostMapping("/create1") public Response createAssessment1(@RequestBody
	 * Assessment1 assessment) { try { if (assessment != null) { int var =
	 * assessmentRepository.save(assessment); if (var > 0) { return
	 * ResponseHelper.buildSuccessResponse("Success"); } } } catch (Exception e) {
	 * return ResponseHelper.buildExceptionResponse(e); } return null;
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/getAllAssessments") public Response getAll() { try {
	 * List<Assessment1> assessmentObj = assessmentRepository.findAll(); if
	 * (assessmentObj.size() > 0) { return
	 * ResponseHelper.buildResponse(assessmentObj, "Success"); } else { return
	 * ResponseHelper.buildResponse(assessmentObj, "Success"); }
	 * 
	 * } catch (Exception e) { return ResponseHelper.buildExceptionResponse(e); } }
	 */
	//@PostMapping("/create")
	//@Transactional
	//public Response createAssessment(@RequestBody Assessment assessment) {
	//	try {
		//	if (assessment != null) {
				
				/*int flag = 0;
				if (assessment.isStaticFlag()) {
					List<EmpAssmtDetail> empAssmtDetails=null;
					int createFlag = assessmentRepository.createAssmt(assessment);
					long assmtId = assessmentRepository.getAssmtIdByName(assessment.getAssmtName());
					String intervalType = assessmentRepository.getAssmtIntervalType(assessment.getAssmtType());
					if (intervalType.equalsIgnoreCase("PROJECT")) {
						flag = assessmentRepository.createAssmtDetailWithProjectId(assessment, assmtId);
						//empAssmtDetails=assessmentService.assmtCapabilityRoleByProjectId(assessment.getProjectId(),assmtId);

					} else if (intervalType.equalsIgnoreCase("SCHEDULED")) {
						flag = assessmentRepository.createAssmtDetailWithScheduled(assessment, assmtId);
						//empAssmtDetails=assessmentService.assmtCapabilityRoleByBasic(assmtId);
					} else {
						flag = assessmentRepository.createAssmtDetail(assessment, assmtId);
						//empAssmtDetails=assessmentService.assmtCapabilityRoleByBasic(assmtId);
					}
					if (flag > 0) {
						
						int empFlag = assessmentRepository.createAssmtToEmp(assessment, assmtId);
						int empAssmtChild=assessmentService.assmtROleDetails(assmtId,assessment);
						if(empAssmtChild>0) {
							return ResponseHelper.buildSuccessResponse("Success");
						}
						
						
					}

				} else if (!assessment.isStaticFlag()) {
					int createFlag = assessmentRepository.createAssmtToTemp(assessment);
					
					if (createFlag > 0) {
						return ResponseHelper.buildSuccessResponse("Success");
					}
				}*/
				
		//	}
		//} catch (Exception e) {
		//	return ResponseHelper.buildExceptionResponse(e);
		//}
		//return null;

	//}
	@PostMapping("/create")
	public Response createAssessments(@RequestBody Assessment assessment) {
		try {
			String loggedInUser=null;
			if (assessment != null) {
				loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
				int createdFlag=assessmentService.createAssessments(assessment,loggedInUser);
				if(createdFlag>0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
				
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;

	}

	@PutMapping("/publishAssssment/{assmtId}/{comment}")
	public Response publish(@PathVariable(value = "assmtId") long assmtId,
			@PathVariable(value = "comment") String comment) {
		// System.out.println("RoleID :" + roleId);
		try {
			if (assmtId > 0) {
				int var = assessmentService.publish(assmtId);
				if (var > 0) {
					return ResponseHelper.buildSuccessResponse("Success");

				}
			}
		} catch (Exception e) {
			System.out.println("Exception:"+e);
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@GetMapping("/getAllAssessments")
	public Response getAllAssessments() {
		List<Assessment> assessmentRes = null;
		List<Assessment> assessmentResList =new ArrayList<Assessment>();
		try {
			Helper helper=new Helper();
			assessmentRes = assessmentRepository.getAllAssessments();
			//System.out.println("assessmentRes"+assessmentRes);
			if(assessmentRes.size()>0) {
			for(Assessment assessment:assessmentRes) {
				//System.out.println("Child ::"+assessment);
				List<AssessmentChild> assessmentChildList=assessmentRepository.getAssessmentDtlAndEmpAssmt(assessment);
				//System.out.println("Child ::"+assessmentChildList);
				assessment=helper.dataMap(assessmentChildList,assessment);
				//System.out.println("Child assessment::"+assessment);
				assessmentResList.add(assessment);
			}
			
			//System.out.println("assessmentResList"+assessmentResList.size());
			if (assessmentResList.size() > 0) {

				return ResponseHelper.buildResponse(assessmentResList, "Success");
			}else {
				return ResponseHelper.buildResponse(assessmentResList, "Success");
			}
			}else {
				return ResponseHelper.buildResponse(assessmentResList, "Success");
			}
		} catch (Exception e) { 
			return ResponseHelper.buildExceptionResponse(e);
		}

	}

	@PutMapping("/updateAssessment")
	public Response updateAssessment(@RequestBody Assessment assessment) {
		try {
			if (assessment!=null) {
				int var = assessmentRepository.updateAssessment(assessment);
				assessmentRepository.deleteByIdChildAssmtDtl(assessment.getAssmtId());
				assessmentRepository.deleteByIdChildAssmtEmp(assessment.getAssmtId());
				String intervalType = assessmentRepository.getAssmtIntervalType(assessment.getAssmtType());
				//List<Long> rcdIds=new ArrayList<Long>();
				//rcdIds.add(assessment.getAssmtId());
				/*
				 * int updateAssmtDetailWithProjectId(Assessment assessment); int
				 * updateAssmtDetailWithScheduled(Assessment assessment); int
				 * updateAssmtDetail(Assessment assessment); int updateAssmtToEmp(Assessment
				 * assessment);
				 */
				int flag = 0;
				if (var > 0) {
					if (intervalType.equalsIgnoreCase("PROJECT")) {
						flag = assessmentRepository.updateAssmtDetailWithProjectId(assessment);

					} else if (intervalType.equalsIgnoreCase("SCHEDULED")) {
						flag = assessmentRepository.updateAssmtDetailWithScheduled(assessment);
					} else {
					flag = assessmentRepository.updateAssmtDetail(assessment);
					}

				
				if (flag > 0) {
					int empFlag = assessmentRepository.updateAssmtToEmp(assessment);
					return ResponseHelper.buildSuccessResponse("Success");
				}
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/deleteAssessment/{assmtId}")
	public Response delete(@PathVariable(value = "assmtId") long assmtId) {
		try {
			if (assmtId > 0) {
				//String status=assessmentRepository.getStatus(assmtId);
				//if (status.equalsIgnoreCase("DRAFT") || status=="DRAFT") {
					int var = assessmentRepository.deleteById(assmtId);
					if (var > 0) {
						assessmentRepository.deleteByIdChildAssmtDtl(assmtId);
						assessmentRepository.deleteByIdChildAssmtEmp(assmtId);
						return ResponseHelper.buildSuccessResponse("Success");
					//}
				/*} else if (status.equalsIgnoreCase("ACTIVE") || status=="ACTIVE") {
					int var = assessmentRepository.deleteByIdStatus(assmtId);
					if (var > 0) {
							return ResponseHelper.buildSuccessResponse("Success");
					}
				}*/
			}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}

		return null;
	}

	@PutMapping("/search")
	public Response assessmentSearch(@RequestBody Assessment assessment) {
		try {
			// String loggedInUser=null;
			// if (assessment != null) {
			// loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
			 List<Assessment> assessmentRes = assessmentService.assessmentSearch(assessment);
			if (assessmentRes != null) {
				return ResponseHelper.buildResponse(assessmentRes, "Success");
			}else {
				List<Assessment> searchRes2=new ArrayList<Assessment>();
				return ResponseHelper.buildResponse(searchRes2, "Success");
			}

			// }
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}

	}
}
