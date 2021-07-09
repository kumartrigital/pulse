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

import com.gss.pulseworkflow.model.Notification;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.NotificationService;

@RestController
@RequestMapping("/ContentManagment") 
public class NotificationController {
	@Autowired
	private NotificationService notificationservice;
	
	@PostMapping("/create")
	public Response createNotification(@RequestBody Notification notification) {
		try {
			String loggedInUser = SecurityUtils.getLoggedInUser().getUserId();
			//String loggedInUser ="12348";
			if (notification != null) {
				notification.setCreatorId(loggedInUser);
				int saveFlag = notificationservice.createNotification(notification);
				if (saveFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	 
	@PutMapping("/publishContent/{anncId}/{comment}")
	public Response publish(@PathVariable(value = "anncId") long anncId,
			@PathVariable(value = "comment") String comment) { //
		try {
			if (anncId > 0 && comment != null) {
				int pulishFlag = notificationservice.publishContent(anncId, comment);
				if (pulishFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) { 
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@GetMapping("/getAllContents")
	public Response getAll() {
		try {
			List<Notification> notificationList = notificationservice.getAllContents();
			if (notificationList.size() > 0) {
				return ResponseHelper.buildResponse(notificationList, "Success");
			} else {
				return ResponseHelper.buildResponse(notificationList, "Success");
			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
	}

	@PutMapping("/updateContent")
	public Response update(@RequestBody Notification notification) {
		System.out.println("Con");
		try {
			String loggedInUser = SecurityUtils.getLoggedInUser().getUserId();
			//String loggedInUser ="12348";
			System.out.println("Con2");
			if (notification != null) {
				//String loggedInUser="";
				int updateFlag = notificationservice.updateContent(notification,loggedInUser);
				if (updateFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/deleteContent/{anncId}")
	public Response delete(@PathVariable(value = "anncId") long anncId) {
		try {
			if (anncId > 0) {
				int deletedFlag = notificationservice.deleteContecnt(anncId);
				if (deletedFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

}
