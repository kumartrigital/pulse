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

import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.Capability;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.CapabilityService;

/**
 * The type User controller.
 *
 * @author Arjun_kada
 */
@RestController
@RequestMapping("/CapabilityAssessment")
public class CapabilityController {

	@Autowired
	private CapabilityService capabilityService;

	/**
	 * Create user user.
	 *
	 * @param user the user
	 * @return the user
	 */

	@PostMapping("/create")
	public Response createCapability(@RequestBody Capability capability) {
		try {
			if (capability != null) {
				String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
				long exist=capabilityService.existingCapability(capability.getCapabilityName().trim(), capability.getCapabilityType().trim());
				if(exist == 0) {
					int saveFlag = capabilityService.saveCapability(capability,loggedInUser);
					if (saveFlag > 0) {
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

	@PutMapping("/publishCapability/{capabilityID}/{comment}")
	public Response publish(@PathVariable(value = "capabilityID") long capabilityID,
			@PathVariable(value = "comment") String comment) { //
		// System.out.println("RoleID :" + roleId);
		try {
			if (capabilityID > 0 && comment != null) {
				int pulishFlag = capabilityService.publishCapability(capabilityID, comment);
				if (pulishFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) { // logger.error("error in ComplaintTypeController:::" + e);
			// handle exceptions and build response with error details //
			System.out.println("Exception: " + e.getMessage());
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@GetMapping("/getAllCapabilities")
	public Response getAll() {
		try {
			List<Capability> listCapability = capabilityService.getAllCapabilities();
			if (listCapability.size() > 0) {
				return ResponseHelper.buildResponse(listCapability, "Success");
			} else {
				return ResponseHelper.buildResponse(listCapability, "Success");
			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
	}

	@PutMapping("/updateCapability")
	public Response update(@RequestBody Capability capability) {
		try {
			if (capability != null) {

				int updateFlag = capabilityService.updateCapability(capability);
				if (updateFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/deleteCapability/{capabilityId}")
	public Response update(@PathVariable(value = "capabilityId") long capabilityId) {
		try {
			if (capabilityId > 0) {
				int deletedFlag = capabilityService.deleteCapabilityById(capabilityId);
				if (deletedFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PostMapping("/search")
	public Response capabilitySearch(@RequestBody Capability capability) {
		try {
			// if (capability!=null) {
			List<Capability> capabilitySearchObj = capabilityService.capabilitySearch(capability);
			if (capabilitySearchObj.size() > 0) {
				return ResponseHelper.buildResponse(capabilitySearchObj, "Success");
			}else {
				List<Capability> searchRes2=new ArrayList<Capability>();
				return ResponseHelper.buildResponse(searchRes2, "Success");
			}
			// }
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
	}

}
