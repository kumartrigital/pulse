package com.gss.pulseworkflow.service;

import java.util.HashMap;
import java.util.List;

import com.gss.pulseworkflow.model.Assessees;
import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.EmpAccessRole;
import com.gss.pulseworkflow.model.EmpAssessee;
import com.gss.pulseworkflow.model.EmpAssessment;
import com.gss.pulseworkflow.model.EmpDisable;
import com.gss.pulseworkflow.model.EmpSearch;
import com.gss.pulseworkflow.model.Employee;
import com.gss.pulseworkflow.model.EmployeeSearchResponse;
import com.gss.pulseworkflow.model.HomeObj;
import com.gss.pulseworkflow.model.Notification;
import com.gss.pulseworkflow.model.Reportee;
import com.gss.pulseworkflow.model.Task;

public interface EmployeeService {
	int disableEmployee(EmpDisable empDisable);
	int removeResourceFromProject(List<String> empIds);
	List<EmpAssessment> getAssessmentsByEmpIdAsAssessor(String empId);
	List<EmpAssessment> getAssessmentsByEmpIdAsAssessee(String empId);
	int completeAssessment(EmpAssessment empAssessment);
	List<Employee> employeeSearch(EmpSearch empSearch);
	HomeObj myHomeDetails(String empId);
	Task myTasks(String loggedInUser);
	List<Reportee> myReportees(String loggedInUser);
	List<Notification> myNotifications(String loggedInUser);
	int createEmployeeAccessRole(EmpAccessRole empAccessRole);
	EmpAccessRole getEmployeeAccessRoles(String empId);
	//int bulkUsersToDB(List<Employee> processedUsers);
	int createAccessRoles(String empId);
	//void createReport(List<Employee> processedUsers);
	int createUser(Employee employee);
	int processFromStaging();

}
