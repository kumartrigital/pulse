package com.gss.pulseworkflow.dao;

import java.util.List;

import com.gss.pulseworkflow.model.AssesseeCapability;
import com.gss.pulseworkflow.model.Assessees;
import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.AssessmentChild;
import com.gss.pulseworkflow.model.AssmtAssesseeCapability;
import com.gss.pulseworkflow.model.AssmtCapability;
import com.gss.pulseworkflow.model.EmpAccessRole;
import com.gss.pulseworkflow.model.EmpAssessee;
import com.gss.pulseworkflow.model.EmpAssesseeAssmtDetail;
import com.gss.pulseworkflow.model.EmpAssessment;
import com.gss.pulseworkflow.model.EmpDisable;
import com.gss.pulseworkflow.model.EmpGoal;
import com.gss.pulseworkflow.model.EmpHierarchy;
import com.gss.pulseworkflow.model.EmpProject;
import com.gss.pulseworkflow.model.EmpProjectNotes;
import com.gss.pulseworkflow.model.EmpTraining;
import com.gss.pulseworkflow.model.Employee;
import com.gss.pulseworkflow.model.EmployeeProject;
import com.gss.pulseworkflow.model.Notification;
import com.gss.pulseworkflow.model.ProGoal;
import com.gss.pulseworkflow.model.Project;
import com.gss.pulseworkflow.model.Reportee;
import com.gss.pulseworkflow.model.User;
import com.gss.pulseworkflow.model.UserRoles;
import com.gss.pulseworkflow.model.UserSkills;
import com.gss.pulseworkflow.model.Usercheck;
import com.gss.pulseworkflow.model.Users;
import com.gss.pulseworkflow.model.Utilization;

public interface EmployeeRepository {
	int save(Users users);
	List<Employee> findAll();
	int saveToDB(Employee employeeToProcess);
	List<Employee> findErrorRecords();
	int save(List<Employee> failedRecords);
	int delete(String empId);
	int delete(long rcdId);
	Employee findErrorRecordById(long recId);
	int createUser(Employee employee);
	int delete();
	int deleteAllErrorecords();
	Employee findUserById(String employeeId);
	List<EmployeeProject> findProjectsByID(String employeeId);
	List<EmpHierarchy> empOrgHierarchy(String employeeId);
	int updateEmpBasicInfo(Employee employee);
	int addResourceToProj(EmpProject empProject);
	List<Employee> findUserByEmailSearch(String email);
	int assignGoalToEmployees(EmpGoal empGoal);
	int assignTrainingToEmployees(EmpTraining empTraining);
	Employee findUserByEmail(String email);
	List<EmpTraining> getEmpActiveTrng(String empId);
	List<EmpTraining> getEmpHistoryTrng(String empId);
	int completeTraining(long rcdId,String comment);
	List<EmpGoal> getEmpActiveGoals(String empId);
	List<EmpGoal> getEmpHistoryGoals(String empId);
	int updateGoalProgress(EmpGoal empGoal);
	List<EmpGoal> getPendingGoalsForApproval(String empId);
	int actionOnGoalByApprover(long rcdId,String status,String approverComment);
	List<EmpProject> getEmpProjectsByID(String employeeId);
	int addNotesOnProjectByEmp(EmpProjectNotes empProjNotes);
	Project getProjectDetailsById(String projectId);
	List<ProGoal> getChildData(String projectId);
	List<EmpProjectNotes> getProjectNotes(String projectId);
	int disableEmployee(EmpDisable empDisable);
	int removeResourceFromProject(List<String> empIds);
	List<EmpAssessment> getAssmtDeatils(String assessorId);
	List<EmpAssessment> getAssmtIdsByAssessee(String empId);
	List<AssessmentChild> getAssessmentDtlAndEmpAssmtAsAssessor(Assessment assesssment);
	Assessment getAssessments(String assmtId);
	List<AssmtCapability> getAssmtCapabilities(String assmtId);
	int completeAssessment(EmpAssessment empAssessment);
	int statusUpdateInAssmtDetail(EmpAssessment empAssessment);
	int updateAssmtEmp(Assessment assessment);
	int updateAssmtDetail(Assessment assessment);
	int updateAssmt(Assessment assessment);
	List<Assessees> getAssesseeDetail(String assmtId);
	List<AssesseeCapability> getAssmentCapabilities(String assmtId,String assmtDtlRcdId,String empAssmtRcdId);
	List<EmpAssesseeAssmtDetail> getAssmtDetailByAssessee(String assmtId);
	int getPendingTrainings(String empId);
	int getPendingGoals(String empId);
	int getPendingAssessments(String empId);
	List<Reportee> getReporteeList(String empId);
	String getEmpUtilization(String empId);
	String getAvgRating(String loggedInUser,String startDate,String endDate);
	List<Notification> myNotifications(String loggedInUser);
	int createEmployeeAccessRole(EmpAccessRole empAccessRole,String sysDate);
	List<UserRoles> getEmployeeAccessRoles(String empId);
	int deleteExistingRoles(String empId);
	List<Usercheck> getUserAccessRoleByEmail(String username);
	List<Employee> employeeBasicSearch(String queryBasicSearch);
	List<UserSkills> empSkills(String querySkillSearch);
	String getAvgRatingForEmp(String ratingQuery);
	List<Utilization> avgratingWithDate(String utilizationQuery);
	List<String> getEmpIdsBySkills(String querySkillSearch);
	Employee getEmployeeDeatailsById(String empId);
	List<String> getEmpIdsByUtilization(String utilization);
	int createAccessRoleToAnUser(String empId);
	//List<AssmtAssesseeCapability> getAssmentCapabilitiesAsAssessee(
			//empAssessee.getAssmtId(), empAssesseeAssmtDetail.getAssmtDtlRcdId(), empAssessee.getEmpAssmtRcdId());
}
