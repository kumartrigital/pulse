package com.gss.pulseworkflow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gss.pulseworkflow.model.Role;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.RoleService;

@RestController
@RequestMapping("/Role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping(value="/create",produces = MediaType.APPLICATION_JSON_VALUE)
	public Response createCapability(@RequestBody Role role) {
		try {
			if (role != null) {
				String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
				role.setCreatorId(loggedInUser);
				long exist=roleService.existingRole(role.getRoleName(), role.getRoleType());
				if(exist == 0) {
					int addFlag = roleService.saveRole(role);
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

	@PutMapping("/publishRole/{roleId}/{comment}")
	public Response publish(@PathVariable(value = "roleId") long roleId,
			@PathVariable(value = "comment") String comment) {
		try {
			if (roleId > 0) {
				int publishFlag = roleService.publishRole(roleId, comment);
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

	@GetMapping("/getAllRoles")
	public Response getAll() {
		List<Role> roleRes = null;
		try {
			roleRes = roleService.getAllRoles();
			if (roleRes.size() > 0) {
				return ResponseHelper.buildResponse(roleRes, "Success");
			}else {
				return ResponseHelper.buildResponse(roleRes, "Success");
			}

		} catch (Exception e) {
			// logger.error("error in ComplaintTypeController:::" + e);
			// handle exceptions and build response with error details
			// System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}

	}

	@PutMapping("/updateRole")
	public Response update(@RequestBody Role role) {
		try {
			if (role != null) {
				int updateFlag = roleService.updateRole(role);
				if (updateFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/deleteRole/{roleId}")
	public Response delete(@PathVariable(value = "roleId") long roleId) {
		try {
			if (roleId > 0) {
				int deleteFlag = roleService.deleteById(roleId);
				if (deleteFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}

			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}

		return null;
	}
	
	@PutMapping("/search")
	public Response roleSearch(@RequestBody Role role) {
		try {
			//if (role != null) {
			List<Role> searchRes= roleService.roleSearch(role);
				if (searchRes!=null) {
					return ResponseHelper.buildResponse(searchRes,"Success");
				}else {
					List<Role> searchRes2=new ArrayList<Role>();
					return ResponseHelper.buildResponse(searchRes2,"Success");
				}
			//}
		} catch (Exception e) { // logger.error("error in ComplaintTypeController:::"+ e); // handle exceptions
								// and build response with error details //
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
	}

}
