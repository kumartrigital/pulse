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

import com.gss.pulseworkflow.model.Goal;
import com.gss.pulseworkflow.model.Training;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.TrainingService;

@RestController
@RequestMapping("/Training")
public class TrainingController {

	@Autowired
	private TrainingService trainingService;

	@PostMapping("/create")
	public Response createTraining(@RequestBody Training training) {
		try {
			if (training != null) {
				String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
				training.setCreator(loggedInUser);
				long exist=trainingService.existingTraining(training.getTainingId().trim());
				if(exist == 0) {
					int saveFlag = trainingService.saveTraining(training);
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

	@GetMapping("/getAllTrainings")
	public Response getAll() {
		try {
			List<Training> trainingList = trainingService.getAllTrainings();
			if (trainingList.size() > 0) {
				return ResponseHelper.buildResponse(trainingList, "Success");
			} else {
				return ResponseHelper.buildResponse(trainingList, "Success");
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
	}

	@PutMapping("/publishTraining/{recID}/{comment}")
	public Response publish(@PathVariable(value = "recID") long recID,
			@PathVariable(value = "comment") String comment) {
		try {
			int publishFlag = trainingService.publishTraining(recID, comment);
			if (publishFlag > 0) {
				return ResponseHelper.buildSuccessResponse("Success");
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/updateTraining")
	public Response update(@RequestBody Training training) {
		try {
			if (training != null) {
				int updateFlag = trainingService.updateTraining(training);
				if (updateFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/deleteTraining/{recID}")
	public Response delete(@PathVariable(value = "recID") long recID) {
		try {
			if (recID > 0) {
				int deleteFlag = trainingService.deleteTraining(recID);
				if (deleteFlag > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	@PostMapping("/search")
	public Response trainingSearch(@RequestBody Training training) {
		try {
			//if (training != null) {
				List<Training> trainigSearchRes= trainingService.trainigSearch(training);
				if (trainigSearchRes.size()>0) {
					return ResponseHelper.buildResponse(trainigSearchRes,"Success");
				}else {
					List<Training> trainigSearchRes2=new ArrayList<Training>();
					return ResponseHelper.buildResponse(trainigSearchRes2,"Success");
				}
			//}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
	}

}
