package com.gss.pulseworkflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gss.pulseworkflow.model.UserRoles;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.UserRoleService;

@RestController
@RequestMapping("/UserAccessRoles")
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	@GetMapping("/")
	public Response getUserROles() {
		try {
			List<UserRoles> userAccessRoles=userRoleService.getUserAccessRoles();
			if(userAccessRoles.size()>0) {
				return ResponseHelper.buildResponse(userAccessRoles, "Success");
			}else {
				return ResponseHelper.buildResponse(userAccessRoles, "Success");
			}
		}catch(Exception e) {
			
		}
		return null;
		
	}

}
