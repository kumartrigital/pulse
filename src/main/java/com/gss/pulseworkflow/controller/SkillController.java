package com.gss.pulseworkflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gss.pulseworkflow.model.UserSkills;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.SkillService;
@RestController
@RequestMapping("/Skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;

	@GetMapping("/getUserSkills/{employeeId}")
	public Response getErrorRecById(@PathVariable(value = "employeeId") String employeeId) {
		try {
			String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
			
			List<UserSkills> employeeSkills = skillService.findSkillById(loggedInUser.trim());
			if (employeeSkills.size() > 0) {
				return ResponseHelper.buildResponse(employeeSkills, "Success");
			} else {
				return ResponseHelper.buildResponse(employeeSkills, "Success");
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
	}
	
	@PostMapping("/create")
	public Response addSkills(@RequestBody UserSkills userSkills) {
		try {
			if (userSkills != null) {
				String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
				userSkills.setEmployeeId(loggedInUser);
				long exist=skillService.existingSkill(userSkills.getEmployeeId(),userSkills.getSkillName());
				if(exist == 0) {
					int addFlag=skillService.addSkill(userSkills);
					if (addFlag > 0) {
							return ResponseHelper.buildSuccessResponse("Success");
					}
				}else if(exist > 0) {
					return ResponseHelper.DUPLICATE_VALIDATION_RESPONSE;
				}
				
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/updateSkill")
	public Response updateSkills(@RequestBody UserSkills userSkills) {
		try {
			if (userSkills != null) {
				int updateFlag = skillService.updateSkill(userSkills);
				if (updateFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/deleteSkill/{rcdId}")
	public Response deleteSkill(@PathVariable(value = "rcdId") long rcdId) {
		try {
			if (rcdId > 0) {
				int deleteFlag = skillService.deleteSkill(rcdId);
				if (deleteFlag > 0) {
						return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

}
