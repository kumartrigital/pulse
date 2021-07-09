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

import com.gss.pulseworkflow.dao.GoalRepository;
import com.gss.pulseworkflow.model.Employee;
import com.gss.pulseworkflow.model.Goal;
import com.gss.pulseworkflow.model.Milestone;
import com.gss.pulseworkflow.oauth.SecurityUtils;
import com.gss.pulseworkflow.response.Response;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.GoalService;

@RestController
@RequestMapping("/Goal")
public class GoalController {

	@Autowired(required = true)
	private GoalRepository goalRepository;
	@Autowired(required = true)
	private GoalService goalService;

	@PostMapping("/create")
	public Response createGoal(@RequestBody Goal goal) {
		try {
			if (goal != null) {
				String loggedInUser=SecurityUtils.getLoggedInUser().getUserId();
				goal.setGoalCreatorId(loggedInUser);
				long exist=goalService.existingGoal(goal.getGoalIntervalId(),goal.getGoalTypeId(),goal.getGoalName());
				if(exist == 0) {
					int var = goalRepository.save(goal);
					if (var > 0) {
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

	@PutMapping("/publishGoal/{goalId}/{comment}")
	public Response publish(@PathVariable(value = "goalId") long goalId,
			@PathVariable(value = "comment") String comment) {
		try {
			int var = goalRepository.publish(goalId);
			if (var > 0) {
				int var2 = goalRepository.saveToLog(goalId, "Add_" + comment);
				if (var2 > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@GetMapping("/getAllGoals")
	public Response getAll() {
		try {
			List<Goal> roleRes = goalRepository.findAll();
			if (roleRes.size() > 0) {
				return ResponseHelper.buildResponse(roleRes, "Success");
			} else {
				return ResponseHelper.buildResponse(roleRes, "Success");
			}

		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
	}

	@PutMapping("/updateGoal")
	public Response update(@RequestBody Goal goal) {
		try {
			if (goal != null) {
				String status = goalRepository.getStatus(goal.getGoalId());
				if (status.equalsIgnoreCase("DRAFT") || status == "DRAFT" || status.equalsIgnoreCase("DISABLED")
						|| status == "DISABLED") {
					int var = goalRepository.update(goal);
					if (var > 0) {
						return ResponseHelper.buildSuccessResponse("Success");
					}
				} else if (status.equalsIgnoreCase("ACTIVE") || status == "ACTIVE") {
					int var = goalRepository.update(goal);
					if (var > 0) {
						int var4 = goalRepository.saveToLog(goal.getGoalId(), "Update_" + goal.getComment());
						if (var4 > 0) {
							return ResponseHelper.buildSuccessResponse("Success");
						}
					}
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}

	@PutMapping("/deleteGoal/{goalId}")
	public Response delete(@PathVariable(value = "goalId") long goalId) {
		try {
			if (goalId > 0) {
				String status = goalRepository.getStatus(goalId);
				if (status.equalsIgnoreCase("DRAFT") || status == "DRAFT" || status.equalsIgnoreCase("DISABLED")
						|| status == "DISABLED") {
					int var = goalRepository.deleteById(goalId);
					if (var > 0) {
						return ResponseHelper.buildSuccessResponse("Success");
					}
				} else if (status.equalsIgnoreCase("ACTIVE") || status == "ACTIVE") {
					int var = goalRepository.deleteByIdStatus(goalId);
					if (var > 0) {
						int var2 = goalRepository.saveToLog(goalId, "Delete");
						if (var2 > 0) {
							return ResponseHelper.buildSuccessResponse("Success");
						}
					}
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}

		return null;
	}

	@PostMapping("/addMilestone")
	public Response addMilestoneToGoal(@RequestBody Milestone milestone) {
		try {
			if (milestone != null) {
				int var = goalRepository.saveMilestone(milestone);
				if (var > 0) {
					return ResponseHelper.buildSuccessResponse("Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;

	}

	@GetMapping("/getMilestones/{goalId}")
	public Response geMilestones(@PathVariable(value = "goalId") String goalId) {
		try {
			if (!goalId.toString().isEmpty() || goalId.toString() != null) {
				List<Milestone> milestoneList = goalRepository.getMilestone(goalId.toString());
				if (milestoneList.size() > 0) {
					return ResponseHelper.buildResponse(milestoneList, "Success");
				} else {
					return ResponseHelper.buildResponse(milestoneList, "Success");
				}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/updateMilestone")
	public Response updateMileStone(@RequestBody Milestone milestone) {
		try {
			if (milestone != null) {
				String status = goalRepository.getMilesoneStatus(milestone.getRecId());
				milestone.setTaskStatusId(status);
					int var = goalRepository.updateMileStone(milestone);
					if (var > 0) {
						return ResponseHelper.buildSuccessResponse("Success");
					}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}
		return null;
	}
	
	@PutMapping("/deleteMileStone/{rcdId}")
	public Response deleteMilestone(@PathVariable(value = "rcdId") long rcdId) {
		try {
			if (rcdId > 0) {
					int var = goalRepository.deleteByIdMilestone(rcdId);
					if (var > 0) {
						return ResponseHelper.buildSuccessResponse("Success");
					}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}

		return null;
	}
	
	@PutMapping("/completeMileStone/{rcdId}")
	public Response completeMilestone(@PathVariable(value = "rcdId") long rcdId) {
		try {
			if (rcdId > 0) {
					int var = goalRepository.completeMilestone(rcdId);
					if (var > 0) {
						return ResponseHelper.buildSuccessResponse("Success");
					}
			}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}

		return null;
	}
	@PostMapping("/search")
	public Response goalSearch(@RequestBody Goal goal) {
		try {
			//if (goal != null) {
			List<Goal> goalSearchRes = goalService.goalSearch(goal);
				if (goalSearchRes.size() > 0) {

					return ResponseHelper.buildResponse(goalSearchRes,"Success");
				}else {
					List<Goal> goalSearchRes2=new ArrayList<Goal>();
					return ResponseHelper.buildResponse(goalSearchRes2,"Success");
				}
			//}
		} catch (Exception e) {
			return ResponseHelper.buildExceptionResponse(e);
		}

	}
}