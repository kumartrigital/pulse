package com.gss.pulseworkflow.dao;

import java.util.List;

import com.gss.pulseworkflow.model.Employee;

public interface EmpRepo {
	int saveToDB(Employee employeeToProcess);
	List<Employee> findErrorRecords();
	int save(List<Employee> failedRecords);
	int delete(String empId);
	int delete(long rcdId);
	Employee findErrorRecordById(long recId);
	int createUser(Employee employee);
	int delete();
	int createAccessRoleToAnUser(String empId);
	String getPositionIdByName(String roleName);
	int createRoleFromBulkLoad(String roleName);
	long positionAvailability(String roleName);
	long userManagerValidationByIdAndEmail(String managerId,String managerEmail);
	long userManagerValidationById(String managerId);
	long userManagerValidationByEmail(String managerEmail);
	String getManagerIdByEmail(String managerEmail);

}
