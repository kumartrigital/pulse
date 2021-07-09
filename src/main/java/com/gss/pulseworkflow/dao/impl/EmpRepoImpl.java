package com.gss.pulseworkflow.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import com.gss.pulseworkflow.dao.EmpRepo;
import com.gss.pulseworkflow.model.Employee;

@Service
public class EmpRepoImpl extends JdbcDaoSupport implements EmpRepo {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	@Override
	public int saveToDB(Employee employee) {
		// TODO Auto-generated method stub
		int updateCount = 0;
		//for (Employee employee : employees) {
			/*
			 * String empId=jdbcTemplate.queryForObject(
			 * "select EMPLOYEE_ID from EMP_DETAIL_FINAL WHERE EMPLOYEE_ID=?", new
			 * Object[]{employee.getEmployeeId()}, (rs, rowNum) ->new String(
			 * rs.getString("EMPLOYEE_ID"))); if(empId!=null) {
			 * 
			 * }else {
			 */
			updateCount = getJdbcTemplate().update(
					"insert into EMP_DETAIL (EMPLOYEE_ID, FIRST_NAME,MIDDLE_NAME,LAST_NAME,EMAIL,ADDRESS_LINE_1,ADDRESS_LINE_2,ZIP_CODE,CITY,STATE,COUNTRY,ADDRESS_TYPE,CONTACT_NUMBER_1,CONTACT_NUMBER_2,HIRE_DATE,POSITION,POSITION_LEVEL,COST_TO_COMPANY,CTC_CURRENCY,COMMISSION_PCT,MANAGER_ID,MANAGER_EMAIL, "
							+ "DEPARTMENT_ID,DEPARTMENT,LAST_WORKING_DATE,EMPLOYMENT_STATUS,EMPLOYMENT_TYPE,ORGANIZATION_ID,ORGANIZATION,MANAGAR_FIRSTNAME,MANAGAR_MIDDLENAME,MANAGAR_LASTNAME) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					employee.getEmployeeId(), employee.getFirstName(), employee.getMiddleName(), employee.getLastName(),
					employee.getEmailId(), employee.getAddress1(), employee.getAddress2(), employee.getZipcode(),
					employee.getCity(), employee.getState(), employee.getCountry(), employee.getAddressType(),
					employee.getContactNumber1(), employee.getContactNumber2(), employee.getHireDate(),
					employee.getPosition(), employee.getPositionLevel(), employee.getCostTOCompany(),
					employee.getCtcCurrency(), employee.getCommissionPCT(), employee.getManagerId(),
					employee.getManagerEmail(), employee.getDepartmentId(), employee.getDepartment(),
					employee.getLastWorkingDate(), employee.getEmployeeStatus(), employee.getEmploymentType(),
					employee.getOrganizationId(), employee.getOrganization(), employee.getManagerFirstName(),
					employee.getManagerMiddleName(), employee.getManagerLastName());
		//}
		
		return updateCount;
	}


	@Override
	public List<Employee> findErrorRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(List<Employee> failedRecords) {
		int count = 0;
		for (Employee employee : failedRecords) {
			int updateCount = getJdbcTemplate().update(
					"insert into EMP_DETAIL_ERROR (EMPLOYEE_ID, FIRST_NAME,MIDDLE_NAME,LAST_NAME,EMAIL,ADDRESS_LINE_1,ADDRESS_LINE_2,ZIP_CODE,CITY,STATE,COUNTRY,ADDRESS_TYPE,CONTACT_NUMBER_1,CONTACT_NUMBER_2,HIRE_DATE,POSITION,POSITION_LEVEL,COST_TO_COMPANY,CTC_CURRENCY,COMMISSION_PCT,MANAGER_ID,MANAGER_EMAIL, "
							+ "DEPARTMENT_ID,DEPARTMENT,LAST_WORKING_DATE,EMPLOYMENT_STATUS,EMPLOYMENT_TYPE,ORGANIZATION_ID,ORGANIZATION,MANAGAR_FIRSTNAME,MANAGAR_MIDDLENAME,MANAGAR_LASTNAME) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
					employee.getEmployeeId(), employee.getFirstName(), employee.getMiddleName(), employee.getLastName(),
					employee.getEmailId(), employee.getAddress1(), employee.getAddress2(), employee.getZipcode(),
					employee.getCity(), employee.getState(), employee.getCountry(), employee.getAddressType(),
					employee.getContactNumber1(), employee.getContactNumber2(), employee.getHireDate(),
					employee.getPosition(), employee.getPositionLevel(), employee.getCostTOCompany(),
					employee.getCtcCurrency(), employee.getCommissionPCT(), employee.getManagerId(),
					employee.getManagerEmail(), employee.getDepartmentId(), employee.getDepartment(),
					employee.getLastWorkingDate(), employee.getEmployeeStatus(), employee.getEmploymentType(),
					employee.getOrganizationId(), employee.getOrganization(), employee.getManagerFirstName(),
					employee.getManagerMiddleName(), employee.getManagerLastName());
			System.out.println("updateCount ::" + updateCount);
			count = count + updateCount;
			System.out.println("Count ::" + count);
		}
		return count;
	}

	@Override
	public int delete(String empId) {
		return getJdbcTemplate().update("DELETE FROM EMP_DETAIL WHERE EMPLOYEE_ID=?", empId);
	}

	@Override
	public int delete(long rcdId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee findErrorRecordById(long recId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createUser(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int createRoleFromBulkLoad(String roleName) {
		//role.setRoleStatusID("2");
		return jdbcTemplate.update(
                "insert into MSTR_POSITION (POSITION_NAME,POSITION_STATUS_ID) values(?,?)",
                roleName,"2");
	}
	@Override
	public  long positionAvailability(String roleName) {
		System.out.println("inside ");
		return jdbcTemplate.queryForObject(
                "select COUNT(*) from MSTR_POSITION WHERE POSITION_NAME=?",
                new Object[]{roleName},
                long.class
        );
	}
	@Override
	public  String getPositionIdByName(String roleName) {
		return jdbcTemplate.queryForObject(
                "select POSITION_ID from MSTR_POSITION WHERE POSITION_NAME= ?",
                new Object[]{roleName},
                String.class
        );
	}
	@Override
	public int delete() {
		return getJdbcTemplate().update("DELETE FROM EMP_DETAIL_STAGE");
	}
	@Override
	public int createAccessRoleToAnUser(String empId) {
		List<Integer> roles=new ArrayList<>();
		roles.add(1);
		roles.add(3);
		roles.add(4);
		roles.add(5);
		roles.add(6);
		int addedFlag=0;
		for(Integer accessRoleId:roles) {
			//System.out.println("DAO2---ADD+accessRoleId ::"+accessRoleId+"  :;empAccessRole.getEmpId() "+empAccessRole.getEmpId());
			addedFlag=addedFlag+jdbcTemplate.update(
				"insert into EMP_ACCESSROLES (EMP_ID,ROLE_ID) values(?,?)",empId,accessRoleId);
		}
		return addedFlag;
	}
	@Override
	public long userManagerValidationByIdAndEmail(String managerId, String managerEmail) {
		return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM EMP_DETAIL WHERE EMPLOYEE_ID=? AND EMAIL=?",
                new Object[]{managerId,managerEmail},
                long.class
        );
	}
	@Override
	public long userManagerValidationById(String managerId) {
		return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM EMP_DETAIL WHERE EMPLOYEE_ID=?",
                new Object[]{managerId},
                long.class
        );
	}
	@Override
	public long userManagerValidationByEmail(String managerEmail) {
		return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM EMP_DETAIL WHERE EMAIL=?",
                new Object[]{managerEmail},
                long.class
        );
	}
	@Override
	public String getManagerIdByEmail(String managerEmail) {
		return jdbcTemplate.queryForObject(
                "SELECT EMPLOYEE_ID FROM EMP_DETAIL WHERE EMAIL=?",
                new Object[]{managerEmail},
                String.class
        );
	}

}
