package com.gss.pulseworkflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gss.pulseworkflow.model.UserPassword;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.oauth.service.WSO2UserWebService;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;

@RestController
@RequestMapping("/UserManagement")
public class UserManagmentController {
	@Autowired
	private WSO2UserWebService wSO2UserWebService;
	@PostMapping("/changePassword")
	public Response capabilitySearch(@RequestBody UserPassword userPassword) {
		try {
			if (userPassword!=null) {
			String loggedInUserEmail=SecurityUtils.getLoggedInUser().getEmailId();
				boolean updateFlag = wSO2UserWebService.changePassword(loggedInUserEmail, userPassword.getOldPassword(), userPassword.getNewPassword());
				if (!updateFlag) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

}
