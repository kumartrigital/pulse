package com.gss.pulseworkflow.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gss.pulseworkflow.dao.EmployeeRepository;
import com.gss.pulseworkflow.model.AssesseeCapability;
import com.gss.pulseworkflow.model.Assessees;
import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.AssessmentChild;
import com.gss.pulseworkflow.model.AssmtCapability;
import com.gss.pulseworkflow.model.EmpAccessRole;
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
import com.gss.pulseworkflow.model.UserRoles;
import com.gss.pulseworkflow.model.UserSkills;
import com.gss.pulseworkflow.model.Usercheck;
import com.gss.pulseworkflow.model.Users;
import com.gss.pulseworkflow.model.Utilization;
import com.gss.pulseworkflow.utility.Helper;

@Repository
public class EmployeeRepositoryImpl extends JdbcDaoSupport implements EmployeeRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	

	@Override
	public int save(Users users) {
		int count = 0;
		for (Employee employee : users.getEmployees()) {
			int updateCount = jdbcTemplate.update(
					"insert into EMP_DETAIL_STAGE (EMPLOYEE_ID, FIRST_NAME,MIDDLE_NAME,LAST_NAME,EMAIL,ADDRESS_LINE_1,ADDRESS_LINE_2,ZIP_CODE,CITY,STATE,COUNTRY,ADDRESS_TYPE,CONTACT_NUMBER_1,CONTACT_NUMBER_2,HIRE_DATE,POSITION,POSITION_LEVEL,COST_TO_COMPANY,CTC_CURRENCY,COMMISSION_PCT,MANAGER_ID,MANAGER_EMAIL, "
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
	public List<Employee> findAll() {

		List<Employee> dataObj = jdbcTemplate.query("select * from EMP_DETAIL_STAGE",
				(rs, rowNum) -> new Employee(rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
						rs.getString("MIDDLE_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"),
						rs.getString("ADDRESS_LINE_1"), rs.getString("ADDRESS_LINE_2"), rs.getString("ZIP_CODE"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("COUNTRY"),
						rs.getString("ADDRESS_TYPE"), rs.getString("CONTACT_NUMBER_1"),
						rs.getString("CONTACT_NUMBER_2"), rs.getString("HIRE_DATE"), rs.getString("POSITION"),
						rs.getString("POSITION_LEVEL"), rs.getString("COST_TO_COMPANY"), rs.getString("CTC_CURRENCY"),
						rs.getString("COMMISSION_PCT"), rs.getString("MANAGER_ID"), rs.getString("MANAGER_EMAIL"),
						rs.getString("DEPARTMENT_ID"), rs.getString("DEPARTMENT"), rs.getString("LAST_WORKING_DATE"),
						rs.getString("EMPLOYMENT_STATUS"), rs.getString("EMPLOYMENT_TYPE"),
						rs.getString("ORGANIZATION_ID"), rs.getString("ORGANIZATION"),
						rs.getString("MANAGAR_FIRSTNAME"), rs.getString("MANAGAR_MIDDLENAME"),
						rs.getString("MANAGAR_LASTNAME")));
		System.out.println("dataObj ::" + dataObj);
		return dataObj;
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
			updateCount = jdbcTemplate.update(
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
		List<Employee> dataObj = jdbcTemplate.query("select * from EMP_DETAIL_ERROR",
				(rs, rowNum) -> new Employee(rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
						rs.getString("MIDDLE_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"),
						rs.getString("ADDRESS_LINE_1"), rs.getString("ADDRESS_LINE_2"), rs.getString("ZIP_CODE"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("COUNTRY"),
						rs.getString("ADDRESS_TYPE"), rs.getString("CONTACT_NUMBER_1"),
						rs.getString("CONTACT_NUMBER_2"), rs.getString("HIRE_DATE"), rs.getString("POSITION"),
						rs.getString("POSITION_LEVEL"), rs.getString("COST_TO_COMPANY"), rs.getString("CTC_CURRENCY"),
						rs.getString("COMMISSION_PCT"), rs.getString("MANAGER_ID"), rs.getString("MANAGER_EMAIL"),
						rs.getString("DEPARTMENT_ID"), rs.getString("DEPARTMENT"), rs.getString("LAST_WORKING_DATE"),
						rs.getString("EMPLOYMENT_STATUS"), rs.getString("EMPLOYMENT_TYPE"),
						rs.getString("ORGANIZATION_ID"), rs.getString("ORGANIZATION"),
						rs.getString("MANAGAR_FIRSTNAME"), rs.getString("MANAGAR_MIDDLENAME"),
						rs.getString("MANAGAR_LASTNAME"), rs.getLong("RCD_ID")));
		System.out.println("dataObj ::" + dataObj);
		return dataObj;
	}

	@Override
	public int save(List<Employee> failedRecords) {
		int count = 0;
		for (Employee employee : failedRecords) {
			int updateCount = jdbcTemplate.update(
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
	public int delete() {
		return jdbcTemplate.update("DELETE FROM EMP_DETAIL_STAGE");
	}

	@Override
	public Employee findErrorRecordById(long recId) {
		return jdbcTemplate.queryForObject("select * from EMP_DETAIL_ERROR WHERE RCD_ID=?", new Object[] { recId },
				(rs, rowNum) -> new Employee(rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
						rs.getString("MIDDLE_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"),
						rs.getString("ADDRESS_LINE_1"), rs.getString("ADDRESS_LINE_2"), rs.getString("ZIP_CODE"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("COUNTRY"),
						rs.getString("ADDRESS_TYPE"), rs.getString("CONTACT_NUMBER_1"),
						rs.getString("CONTACT_NUMBER_2"), rs.getString("HIRE_DATE"), rs.getString("POSITION"),
						rs.getString("POSITION_LEVEL"), rs.getString("COST_TO_COMPANY"), rs.getString("CTC_CURRENCY"),
						rs.getString("COMMISSION_PCT"), rs.getString("MANAGER_ID"), rs.getString("MANAGER_EMAIL"),
						rs.getString("DEPARTMENT_ID"), rs.getString("DEPARTMENT"), rs.getString("LAST_WORKING_DATE"),
						rs.getString("EMPLOYMENT_STATUS"), rs.getString("EMPLOYMENT_TYPE"),
						rs.getString("ORGANIZATION_ID"), rs.getString("ORGANIZATION"),
						rs.getString("MANAGAR_FIRSTNAME"), rs.getString("MANAGAR_MIDDLENAME"),
						rs.getString("MANAGAR_LASTNAME"), rs.getLong("RCD_ID")));
	}

	@Override
	public int createUser(Employee employee) {
		return jdbcTemplate.update(
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
	}

	@Override
	public int delete(String empId) {
		return jdbcTemplate.update("DELETE FROM EMP_DETAIL WHERE EMPLOYEE_ID=?", empId);
	}
	@Override
	public int delete(long rcdId) {
		return jdbcTemplate.update("DELETE FROM EMP_DETAIL_ERROR WHERE RCD_ID=?", rcdId);
	}

	@Override
	public Employee findUserById(String employeeId) {
		return jdbcTemplate.queryForObject("select * from EMP_DETAIL WHERE EMPLOYEE_ID=?", new Object[] { employeeId },
				(rs, rowNum) -> new Employee(rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
						rs.getString("MIDDLE_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"),
						rs.getString("ADDRESS_LINE_1"), rs.getString("ADDRESS_LINE_2"), rs.getString("ZIP_CODE"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("COUNTRY"),
						rs.getString("ADDRESS_TYPE"), rs.getString("CONTACT_NUMBER_1"),
						rs.getString("CONTACT_NUMBER_2"), rs.getString("HIRE_DATE"), rs.getString("POSITION"),
						rs.getString("POSITION_LEVEL"), rs.getString("COST_TO_COMPANY"), rs.getString("CTC_CURRENCY"),
						rs.getString("COMMISSION_PCT"), rs.getString("MANAGER_ID"), rs.getString("MANAGER_EMAIL"),
						rs.getString("DEPARTMENT_ID"), rs.getString("DEPARTMENT"), rs.getString("LAST_WORKING_DATE"),
						rs.getString("EMPLOYMENT_STATUS"), rs.getString("EMPLOYMENT_TYPE"),
						rs.getString("ORGANIZATION_ID"), rs.getString("ORGANIZATION"),
						rs.getString("MANAGAR_FIRSTNAME"), rs.getString("MANAGAR_MIDDLENAME"),
						rs.getString("MANAGAR_LASTNAME")));
	}

	@Override
	public List<EmployeeProject> findProjectsByID(String employeeId) {
		return jdbcTemplate.query(
				"SELECT PROJECTS.PROJECT_ID AS PROJECTID, PROJECTS.PROJECT_NAME AS PROJECTNAME,PROJECTS.PROJECT_START_DATE AS STARTDATE,"
						+ " PROJECTS.PROJECT_END_DATE AS ENDDATE,MSTR_POSITION.POSITION_NAME AS POSITIONNAME,EMP_DETAIL.FIRST_NAME AS REPORTING_FN,"
						+ " EMP_DETAIL.LAST_NAME AS REPORTING_LN,EMP_DETAIL.EMAIL AS REPORTING_EMAIL,EMP_PROJECT.PROJ_UTL_PERCENT  AS UTIIZATION FROM EMP_PROJECT JOIN EMP_DETAIL"
						+ " ON EMP_PROJECT.PROJ_REPORTING_MGR_ID=EMP_DETAIL.EMPLOYEE_ID LEFT JOIN PROJECTS ON PROJECTS.PROJECT_ID=EMP_PROJECT.PROJECT_ID LEFT JOIN "
						+ " MSTR_POSITION ON MSTR_POSITION.POSITION_ID=EMP_PROJECT.PROJ_POSITION_ID WHERE EMP_PROJECT.EMPLOYEE_ID=?",
				new Object[] { employeeId },
				(rs, rowNum) -> new EmployeeProject(rs.getString("PROJECTID"), rs.getString("PROJECTNAME"),
						rs.getString("STARTDATE"), rs.getString("ENDDATE"), rs.getString("POSITIONNAME"),
						rs.getString("REPORTING_FN"), rs.getString("REPORTING_LN"), rs.getString("REPORTING_EMAIL"),
						rs.getString("UTIIZATION")));
	}

	@Override
	public List<EmpHierarchy> empOrgHierarchy(String employeeId) {
		return jdbcTemplate.query("select employee_id," + " first_name,last_name,email,"
				+ " manager_id,managar_firstname,managar_lastname,manager_email " + " from (select * from EMP_DETAIL "
				+ " order by manager_id, employee_id) manager_id, " + " (select @pv := ?) initialisation "
				+ " where find_in_set(employee_id, @pv) " + " and length(@pv := concat(@pv, ',', manager_id))",
				new Object[] { employeeId },
				(rs, rowNum) -> new EmpHierarchy(rs.getString("employee_id"), rs.getString("email"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getString("manager_id"),
						rs.getString("managar_firstname"), rs.getString("managar_lastname")));
	}

	@Override
	public int deleteAllErrorecords() {
		return jdbcTemplate.update("DELETE FROM EMP_DETAIL_ERROR");
	}

	@Override
	public int updateEmpBasicInfo(Employee employee) {
		return jdbcTemplate.update(
				"update EMP_DETAIL set FIRST_NAME=?,MIDDLE_NAME=?,LAST_NAME=?,EMAIL=?,ADDRESS_LINE_1=?,ADDRESS_LINE_2=?,ZIP_CODE=?,CITY=?,STATE=?,COUNTRY=?,ADDRESS_TYPE=?,CONTACT_NUMBER_1=?,CONTACT_NUMBER_2=?,HIRE_DATE=?,POSITION=?,POSITION_LEVEL=?,COST_TO_COMPANY=?,CTC_CURRENCY=?,COMMISSION_PCT=?,MANAGER_ID=?,MANAGER_EMAIL=?, "
						+ "DEPARTMENT_ID=?,DEPARTMENT=?,LAST_WORKING_DATE=?,EMPLOYMENT_STATUS=?,EMPLOYMENT_TYPE=?,ORGANIZATION_ID=?,ORGANIZATION=?,MANAGAR_FIRSTNAME=?,MANAGAR_MIDDLENAME=?,MANAGAR_LASTNAME=? where EMPLOYEE_ID=?",
				employee.getFirstName(), employee.getMiddleName(), employee.getLastName(), employee.getEmailId(),
				employee.getAddress1(), employee.getAddress2(), employee.getZipcode(), employee.getCity(),
				employee.getState(), employee.getCountry(), employee.getAddressType(), employee.getContactNumber1(),
				employee.getContactNumber2(), employee.getHireDate(), employee.getPosition(),
				employee.getPositionLevel(), employee.getCostTOCompany(), employee.getCtcCurrency(),
				employee.getCommissionPCT(), employee.getManagerId(), employee.getManagerEmail(),
				employee.getDepartmentId(), employee.getDepartment(), employee.getLastWorkingDate(),
				employee.getEmployeeStatus(), employee.getEmploymentType(), employee.getOrganizationId(),
				employee.getOrganization(), employee.getManagerFirstName(), employee.getManagerMiddleName(),
				employee.getManagerLastName(), employee.getEmployeeId());
	}

	@Override
	public int addResourceToProj(EmpProject empProject) {
		// empProject.setProEmpstatus();
		int count = 0;
		int updateCount = 0;
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		for (String employeeId : empProject.getEmpIds()) {
			long exist=jdbcTemplate.queryForObject(
	                "SELECT COUNT(*) FROM EMP_PROJECT WHERE EMPLOYEE_ID=? AND PROJECT_ID=? AND STATUS_ID!='3'",
	                new Object[]{employeeId,empProject.getProId()},
	                long.class
	        );
			if(exist==0) {
			if (employeeId.equalsIgnoreCase(empProject.getProRepMgrId())) {
				updateCount = jdbcTemplate.update(
						"insert into EMP_PROJECT (EMPLOYEE_ID,PROJECT_ID,PROJECT_ASSIGNED_DATE,PROJ_START_DATE,PROJ_END_DATE,PROJ_UTL_PERCENT,PROJ_POSITION_ID,STATUS_ID,LAST_UPDATED_DATE) VALUES(?,?,?,?,?,?,?,?,?)",
						employeeId, empProject.getProId(), sysDate, empProject.getProStartDate(),
						empProject.getProEndDate(), empProject.getProUtlPer(), empProject.getPositionId(), "3",
						sysDate);
			} else {
				updateCount = jdbcTemplate.update(
						"insert into EMP_PROJECT (EMPLOYEE_ID,PROJECT_ID,PROJECT_ASSIGNED_DATE,PROJ_START_DATE,PROJ_END_DATE,PROJ_UTL_PERCENT,PROJ_REPORTING_MGR_ID,PROJ_POSITION_ID,STATUS_ID,LAST_UPDATED_DATE) VALUES(?,?,?,?,?,?,?,?,?,?)",
						employeeId, empProject.getProId(), sysDate, empProject.getProStartDate(),
						empProject.getProEndDate(), empProject.getProUtlPer(), empProject.getProRepMgrId(),
						empProject.getPositionId(), "3", sysDate);
			}
			count = count + updateCount;
		}
		}
		return count;
	}

	@Override
	public Employee findUserByEmail(String email) {
		return jdbcTemplate.queryForObject("select * from EMP_DETAIL WHERE EMAIL=?", new Object[] { email },
				(rs, rowNum) -> new Employee(rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
						rs.getString("MIDDLE_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"),
						rs.getString("ADDRESS_LINE_1"), rs.getString("ADDRESS_LINE_2"), rs.getString("ZIP_CODE"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("COUNTRY"),
						rs.getString("ADDRESS_TYPE"), rs.getString("CONTACT_NUMBER_1"),
						rs.getString("CONTACT_NUMBER_2"), rs.getString("HIRE_DATE"), rs.getString("POSITION"),
						rs.getString("POSITION_LEVEL"), rs.getString("COST_TO_COMPANY"), rs.getString("CTC_CURRENCY"),
						rs.getString("COMMISSION_PCT"), rs.getString("MANAGER_ID"), rs.getString("MANAGER_EMAIL"),
						rs.getString("DEPARTMENT_ID"), rs.getString("DEPARTMENT"), rs.getString("LAST_WORKING_DATE"),
						rs.getString("EMPLOYMENT_STATUS"), rs.getString("EMPLOYMENT_TYPE"),
						rs.getString("ORGANIZATION_ID"), rs.getString("ORGANIZATION"),
						rs.getString("MANAGAR_FIRSTNAME"), rs.getString("MANAGAR_MIDDLENAME"),
						rs.getString("MANAGAR_LASTNAME")));
	}

	@Override
	public List<Employee> findUserByEmailSearch(String email) {
		return jdbcTemplate.query("SELECT * from EMP_DETAIL WHERE EMAIL LIKE '" + email + "%'",

				(rs, rowNum) -> new Employee(rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
						rs.getString("MIDDLE_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"),
						rs.getString("ADDRESS_LINE_1"), rs.getString("ADDRESS_LINE_2"), rs.getString("ZIP_CODE"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("COUNTRY"),
						rs.getString("ADDRESS_TYPE"), rs.getString("CONTACT_NUMBER_1"),
						rs.getString("CONTACT_NUMBER_2"), rs.getString("HIRE_DATE"), rs.getString("POSITION"),
						rs.getString("POSITION_LEVEL"), rs.getString("COST_TO_COMPANY"), rs.getString("CTC_CURRENCY"),
						rs.getString("COMMISSION_PCT"), rs.getString("MANAGER_ID"), rs.getString("MANAGER_EMAIL"),
						rs.getString("DEPARTMENT_ID"), rs.getString("DEPARTMENT"), rs.getString("LAST_WORKING_DATE"),
						rs.getString("EMPLOYMENT_STATUS"), rs.getString("EMPLOYMENT_TYPE"),
						rs.getString("ORGANIZATION_ID"), rs.getString("ORGANIZATION"),
						rs.getString("MANAGAR_FIRSTNAME"), rs.getString("MANAGAR_MIDDLENAME"),
						rs.getString("MANAGAR_LASTNAME")));
	}

	@Override
	public int assignGoalToEmployees(EmpGoal empGoal) {
		int count = 0;
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		for (String employeeId : empGoal.getEmployeeIds()) {
			int updateCount = jdbcTemplate.update(
					"insert into EMP_GOAL (EMPLOYEE_ID, GOAL_ID,GOAL_ASSIGNED_DATE,GOAL_STATUS_ID,GOAL_SETTER_ID,LAST_UPDATED_DATE) values(?,?,?,?,?,?)",
					employeeId, empGoal.getGoalId(), sysDate, "6", "", sysDate);
			// System.out.println("updateCount ::"+updateCount);
			count = count + updateCount;
			// System.out.println("Count ::"+count);
		}
		return count;
	}

	@Override
	public int assignTrainingToEmployees(EmpTraining empTraining) {
		int count = 0;
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		for (String employeeId : empTraining.getEmployeeIds()) {
			int updateCount = jdbcTemplate.update(
					"insert into EMP_TRNG (EMPLOYEE_ID, TRNG_ID,TRNG_ASSIGNED_DATE,TRNG_DUE_DATE,TRNG_STATUS_ID,TRNG_SETTER_ID,LAST_UPDATED_DATE) values(?,?,?,?,?,?,?)",
					employeeId, empTraining.getTrainingId(), sysDate, empTraining.getDueDate(), "6", "", sysDate);
			// System.out.println("updateCount ::"+updateCount);
			count = count + updateCount;
			// System.out.println("Count ::"+count);
		}
		return count;
	}

	@Override
	public List<EmpTraining> getEmpActiveTrng(String empId) {
		return jdbcTemplate.query(
				"SELECT EMP_TRNG.RCD_ID AS RCDID,EMP_TRNG.TRNG_ID AS TRNGID,MSTR_TRAINING.TRNG_NAME AS TRNGNAME,"
						+ " MSTR_TRAINING.TRNG_DESCRIPTION AS TRNGDES, EMP_TRNG.TRNG_ASSIGNED_DATE"
						+ " AS INITDATE,EMP_TRNG.TRNG_DUE_DATE AS DUEDATE,EMP_TRNG.TRNG_SETTER_ID AS ASSIGNEDBY,"
						+ " EMP_TRNG.LAST_UPDATED_DATE AS COMPLETEDDATE,EMP_TRNG.TRNG_COMPLETED_COMMENTS AS COMMENTS FROM EMP_TRNG JOIN MSTR_TRAINING ON "
						+ " EMP_TRNG.TRNG_ID=MSTR_TRAINING.TRNG_ID WHERE EMP_TRNG.TRNG_STATUS_ID!='8' AND EMP_TRNG.EMPLOYEE_ID=?",
				new Object[] { empId },
				(rs, rowNum) -> new EmpTraining(rs.getLong("RCDID"), rs.getString("TRNGID"), rs.getString("TRNGNAME"),
						rs.getString("TRNGDES"), rs.getString("INITDATE"), rs.getString("DUEDATE"),
						rs.getString("ASSIGNEDBY"), rs.getString("COMPLETEDDATE"), rs.getString("COMMENTS"), "OPEN",
						empId, "6"));
	}

	@Override
	public List<EmpTraining> getEmpHistoryTrng(String empId) {
		return jdbcTemplate.query(
				"SELECT EMP_TRNG.RCD_ID AS RCDID,EMP_TRNG.TRNG_ID AS TRNGID,MSTR_TRAINING.TRNG_NAME AS TRNGNAME,"
						+ " MSTR_TRAINING.TRNG_DESCRIPTION AS TRNGDES, EMP_TRNG.TRNG_ASSIGNED_DATE"
						+ " AS INITDATE,EMP_TRNG.TRNG_DUE_DATE AS DUEDATE,EMP_TRNG.TRNG_SETTER_ID AS ASSIGNEDBY,"
						+ " EMP_TRNG.LAST_UPDATED_DATE AS COMPLETEDDATE,EMP_TRNG.TRNG_COMPLETED_COMMENTS AS COMMENTS FROM EMP_TRNG JOIN MSTR_TRAINING ON "
						+ " EMP_TRNG.TRNG_ID=MSTR_TRAINING.TRNG_ID WHERE EMP_TRNG.TRNG_STATUS_ID='8' AND EMP_TRNG.EMPLOYEE_ID=?",
				new Object[] { empId },
				(rs, rowNum) -> new EmpTraining(rs.getLong("RCDID"), rs.getString("TRNGID"), rs.getString("TRNGNAME"),
						rs.getString("TRNGDES"), rs.getString("INITDATE"), rs.getString("DUEDATE"),
						rs.getString("ASSIGNEDBY"), rs.getString("COMPLETEDDATE"), rs.getString("COMMENTS"),
						"COMPLETED", empId, "8"));
	}

	@Override
	public int completeTraining(long rcdId, String comment) {
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		return jdbcTemplate.update(
				"update EMP_TRNG set TRNG_STATUS_ID='8',TRNG_COMPLETED_COMMENTS=?,LAST_UPDATED_DATE=? where RCD_ID=?",
				comment, sysDate, rcdId);
	}

	@Override
	public List<EmpGoal> getEmpActiveGoals(String empId) {
		return jdbcTemplate.query(
				"SELECT EMP_GOAL.RCD_ID AS RCDID,EMP_GOAL.EMPLOYEE_ID AS EMPID,EMP_GOAL.GOAL_ID AS GOALID,EMP_GOAL.GOAL_ASSIGNED_DATE AS ASSIGNEDDATE,"
						+ " EMP_GOAL.GOAL_STATUS_ID AS STATUID,MSTR_STATUS.STATUS_VALUE AS STATUS,EMP_GOAL.GOAL_SETTER_ID AS CREATORID,EMP_GOAL.LAST_UPDATED_DATE AS UPDATEDATE,"
						+ " GOALS.GOAL_NAME AS GOALNAME,GOALS.GOAL_DESCRIPTION AS GOALDES,GOALS.GOAL_START_DATE AS STARTDATE,GOALS.GOAL_END_DATE AS ENDDATE,"
						+ " emp.MANAGER_ID AS MANAGERID,emp2.EMAIL AS MANAGEREMAIL,EMP_GOAL.COMMENTS AS COMMENTS FROM EMP_GOAL JOIN GOALS ON "
						+ " EMP_GOAL.GOAL_ID=GOALS.GOAL_ID LEFT JOIN EMP_DETAIL emp ON emp.EMPLOYEE_ID=EMP_GOAL.EMPLOYEE_ID LEFT JOIN "
						+ " MSTR_STATUS ON MSTR_STATUS.STATUS_ID=EMP_GOAL.GOAL_STATUS_ID LEFT JOIN EMP_DETAIL emp2 ON emp2.EMPLOYEE_ID=emp.MANAGER_ID "
						+ " WHERE EMP_GOAL.GOAL_STATUS_ID!='9' AND EMP_GOAL.EMPLOYEE_ID=?",
				new Object[] { empId },
				(rs, rowNum) -> new EmpGoal(rs.getLong("RCDID"), rs.getString("EMPID"), rs.getString("GOALID"),
						rs.getString("ASSIGNEDDATE"), rs.getString("STATUID"), rs.getString("STATUS"),
						rs.getString("CREATORID"), rs.getString("UPDATEDATE"), rs.getString("GOALNAME"),
						rs.getString("GOALDES"), rs.getString("STARTDATE"), rs.getString("ENDDATE"),
						rs.getString("MANAGERID"), rs.getString("MANAGEREMAIL"), rs.getString("COMMENTS")));
	}

	@Override
	public List<EmpGoal> getEmpHistoryGoals(String empId) {
		return jdbcTemplate.query(
				"SELECT EMP_GOAL.RCD_ID AS RCDID,EMP_GOAL.EMPLOYEE_ID AS EMPID,EMP_GOAL.GOAL_ID AS GOALID,EMP_GOAL.GOAL_ASSIGNED_DATE AS ASSIGNEDDATE,"
						+ " EMP_GOAL.GOAL_STATUS_ID AS STATUID,MSTR_STATUS.STATUS_VALUE AS STATUS,EMP_GOAL.GOAL_SETTER_ID AS CREATORID,EMP_GOAL.LAST_UPDATED_DATE AS UPDATEDATE,"
						+ " GOALS.GOAL_NAME AS GOALNAME,GOALS.GOAL_DESCRIPTION AS GOALDES,GOALS.GOAL_START_DATE AS STARTDATE,GOALS.GOAL_END_DATE AS ENDDATE,"
						+ " emp.MANAGER_ID AS MANAGERID,emp2.EMAIL AS MANAGEREMAIL,EMP_GOAL.COMMENTS AS COMMENTS FROM EMP_GOAL JOIN GOALS ON "
						+ " EMP_GOAL.GOAL_ID=GOALS.GOAL_ID LEFT JOIN EMP_DETAIL emp ON emp.EMPLOYEE_ID=EMP_GOAL.EMPLOYEE_ID LEFT JOIN "
						+ " MSTR_STATUS ON MSTR_STATUS.STATUS_ID=EMP_GOAL.GOAL_STATUS_ID LEFT JOIN EMP_DETAIL emp2 ON emp2.EMPLOYEE_ID=emp.MANAGER_ID "
						+ " WHERE EMP_GOAL.GOAL_STATUS_ID='9' AND EMP_GOAL.EMPLOYEE_ID=?",
				new Object[] { empId },
				(rs, rowNum) -> new EmpGoal(rs.getLong("RCDID"), rs.getString("EMPID"), rs.getString("GOALID"),
						rs.getString("ASSIGNEDDATE"), rs.getString("STATUID"), rs.getString("STATUS"),
						rs.getString("CREATORID"), rs.getString("UPDATEDATE"), rs.getString("GOALNAME"),
						rs.getString("GOALDES"), rs.getString("STARTDATE"), rs.getString("ENDDATE"),
						rs.getString("MANAGERID"), rs.getString("MANAGEREMAIL"), rs.getString("COMMENTS")));
	}

	@Override
	public int updateGoalProgress(EmpGoal empGoal) {
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		String status = null;
		if (empGoal.getStatus().equalsIgnoreCase("INPROGRESS")) {
			status = "7";
		} else if (empGoal.getStatus().equalsIgnoreCase("COMPLETED")) {
			status = "8";
		} else if (empGoal.getStatus().equalsIgnoreCase("COMPLETED-APPROVED")) {
			status = "9";
		}
		return jdbcTemplate.update("update EMP_GOAL set GOAL_STATUS_ID=?,COMMENTS=?,LAST_UPDATED_DATE=? where RCD_ID=?",
				status, empGoal.getComment(), sysDate, empGoal.getRcdId());
	}

	@Override
	public List<EmpGoal> getPendingGoalsForApproval(String empId) {
		System.out.println("emp DAO");
		return jdbcTemplate.query(
				"SELECT EMP_GOAL.RCD_ID AS RCDID,EMP_GOAL.EMPLOYEE_ID AS EMPID,emp2.EMAIL AS EMPLOYEEEMAIL,"
						+ "EMP_GOAL.GOAL_ID AS GOALID,GOALS.GOAL_NAME AS GOALNAME,EMP_GOAL.GOAL_ASSIGNED_DATE AS ASSIGNEDDATE,"
						+ "EMP_GOAL.GOAL_STATUS_ID AS STATUID,MSTR_STATUS.STATUS_VALUE AS STATUS,EMP_GOAL.GOAL_SETTER_ID AS CREATORID,"
						+ "EMP_GOAL.LAST_UPDATED_DATE AS UPDATEDATE,EMP_GOAL.COMMENTS AS COMMENTS,GOALS.GOAL_DESCRIPTION AS GOALDES,"
						+ "GOALS.GOAL_START_DATE AS STARTDATE,GOALS.GOAL_END_DATE AS ENDDATE FROM EMP_GOAL JOIN "
						+ "MSTR_STATUS ON MSTR_STATUS.STATUS_ID=EMP_GOAL.GOAL_STATUS_ID LEFT JOIN GOALS ON "
						+ "EMP_GOAL.GOAL_ID=GOALS.GOAL_ID LEFT JOIN  EMP_DETAIL emp2 ON emp2.EMPLOYEE_ID=EMP_GOAL.EMPLOYEE_ID "
						+ "WHERE EMP_GOAL.EMPLOYEE_ID IN (SELECT emp.EMPLOYEE_ID FROM EMP_DETAIL emp "
						+ "WHERE emp.MANAGER_ID=?) AND EMP_GOAL.GOAL_STATUS_ID='8'",
				new Object[] { empId },
				(rs, rowNum) -> new EmpGoal(rs.getLong("RCDID"), rs.getString("EMPID"), rs.getString("EMPLOYEEEMAIL"),
						rs.getString("GOALID"), rs.getString("GOALNAME"), rs.getString("ASSIGNEDDATE"),
						rs.getString("STATUID"), rs.getString("STATUS"), rs.getString("CREATORID"),
						rs.getString("UPDATEDATE"), rs.getString("COMMENTS"), rs.getString("GOALDES"),
						rs.getString("STARTDATE"), rs.getString("ENDDATE")));
	}

	@Override
	public int actionOnGoalByApprover(long rcdId, String status, String approverComment) {
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		return jdbcTemplate.update(
				"update EMP_GOAL set GOAL_STATUS_ID=?,APPROVERCOMMENTS=?,LAST_UPDATED_DATE=? where RCD_ID=?", status,
				approverComment, sysDate, rcdId);
	}

	@Override
	public List<EmpProject> getEmpProjectsByID(String employeeId) {
		return jdbcTemplate.query(
				"SELECT EMP_PROJECT.RCD_ID AS RCDID,EMP_PROJECT.EMPLOYEE_ID AS EMPLOYEEID,"
				+ "emp.EMAIL AS EMPEMAIL,EMP_PROJECT.PROJECT_ID AS PROJECTID,PROJECTS.PROJECT_NAME AS PROJECTNAME,"
				+ "EMP_PROJECT.PROJECT_ASSIGNED_DATE AS ASSIGNEDDATE,EMP_PROJECT.ASSIGNED_BY AS ASSIGNEDBY,EMP_PROJECT.PROJ_START_DATE AS STARTDATE,"
				+ "EMP_PROJECT.PROJ_END_DATE AS ENDDATE,EMP_PROJECT.PROJ_UTL_PERCENT AS UTLIZATION,EMP_PROJECT.PROJ_REPORTING_MGR_ID AS MANAGERID,"
				+ "emp2.EMAIL AS RMANAGEREMAIL,EMP_PROJECT.PROJ_POSITION_ID AS POSITIONID,"
				+ "MSTR_POSITION.POSITION_NAME AS POSITIONNAME,EMP_PROJECT.STATUS_ID AS STATUSID,"
				+ "MSTR_STATUS.STATUS_VALUE AS STATUSVALUE,EMP_PROJECT.LAST_UPDATED_DATE AS UPDATEDDATE "
				+ "FROM EMP_PROJECT JOIN EMP_DETAIL emp ON EMP_PROJECT.EMPLOYEE_ID=emp.EMPLOYEE_ID LEFT JOIN "
				+ "EMP_DETAIL emp2 ON EMP_PROJECT.PROJ_REPORTING_MGR_ID=emp2.EMPLOYEE_ID LEFT JOIN PROJECTS ON "
				+ "EMP_PROJECT.PROJECT_ID=PROJECTS.PROJECT_ID LEFT JOIN MSTR_STATUS ON "
				+ "EMP_PROJECT.STATUS_ID=MSTR_STATUS.STATUS_ID LEFT JOIN MSTR_POSITION ON EMP_PROJECT.PROJ_POSITION_ID=MSTR_POSITION.POSITION_ID "
				+ "WHERE EMP_PROJECT.STATUS_ID!='2' AND EMP_PROJECT.EMPLOYEE_ID=?",
				new Object[] { employeeId },
				(rs, rowNum) -> new EmpProject(rs.getString("PROJECTID"),rs.getString("ASSIGNEDDATE"),
						rs.getString("STARTDATE"),rs.getString("ENDDATE"),rs.getString("UTLIZATION"),rs.getString("MANAGERID"),
						rs.getString("STATUSID"),rs.getString("POSITIONID"),
						rs.getLong("RCDID"), rs.getString("EMPLOYEEID"), rs.getString("EMPEMAIL"),
						rs.getString("PROJECTNAME"), rs.getString("ASSIGNEDBY"), rs.getString("RMANAGEREMAIL"),
						rs.getString("POSITIONNAME"), rs.getString("STATUSVALUE"), rs.getString("UPDATEDDATE")));
		
		
	}

	@Override
	public int addNotesOnProjectByEmp(EmpProjectNotes empProjNotes) {
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		//empProjNotes.setProjectCommentorId("12347");
		return jdbcTemplate.update(
				"insert into PROJECT_HISTORY (PROJECT_ID,PROJECT_NOTES,PROJECT_COMMENTOR_ID,COMMENT_DATE) values(?,?,?,?)",
				empProjNotes.getProjectId(),empProjNotes.getProjectNotes(),empProjNotes.getProjectCommentorId(),
				sysDate);
	}

	@Override
	public Project getProjectDetailsById(String projectId) {
		return jdbcTemplate.queryForObject("SELECT PROJECTS.RCD_ID,PROJECTS.PROJECT_ID,PROJECTS.PROJECT_NAME,"
				+ "PROJECTS.PROJECT_START_DATE,PROJECTS.PROJECT_END_DATE,PROJECTS.PROJECT_CUSTOMER,"
				+ "PROJECTS.PROJECT_DESCRIPTION,PROJECTS.PROJECT_STATUS_ID,MSTR_STATUS.STATUS_VALUE,"
				+ "PROJECTS.CREATOR_ID FROM PROJECTS JOIN MSTR_STATUS ON "
				+ "PROJECTS.PROJECT_STATUS_ID=MSTR_STATUS.STATUS_ID WHERE PROJECTS.PROJECT_ID=?",
				new Object[] { projectId },
                (rs, rowNum) ->
                        new Project(
                        		rs.getLong("RCD_ID"),
                                rs.getString("PROJECT_ID"),
                                rs.getString("PROJECT_NAME"),
                                rs.getString("PROJECT_START_DATE"),
                                rs.getString("PROJECT_END_DATE"),
                                rs.getString("PROJECT_CUSTOMER"),
                                rs.getString("PROJECT_DESCRIPTION"),
                                rs.getString("PROJECT_STATUS_ID"),
                                rs.getString("STATUS_VALUE"),
                                rs.getString("CREATOR_ID"))
        );
	}
	
	@Override
	public List<ProGoal> getChildData(String id) {
		return jdbcTemplate.query("SELECT COMP_PROJECT_GOAL.GOAL_ID AS GOALID, GOALS.GOAL_NAME AS GOALNAME FROM "
				+ "COMP_PROJECT_GOAL JOIN GOALS ON COMP_PROJECT_GOAL.GOAL_ID=GOALS.GOAL_ID WHERE "
				+ " COMP_PROJECT_GOAL.PROJECT_ID=?", new Object[]{id},
				(rs, rowNum) ->new ProGoal(
                rs.getString("GOALID"),
                rs.getString("GOALNAME")));
	}

	@Override
	public List<EmpProjectNotes> getProjectNotes(String projectId) {
		System.out.println("DAO");
		return jdbcTemplate.query("SELECT PROJECT_HISTORY.RCD_ID,PROJECT_HISTORY.PROJECT_ID,PROJECT_HISTORY.PROJECT_NOTES,"
				+ "PROJECT_HISTORY.PROJECT_COMMENTOR_ID,EMP_DETAIL.EMAIL,PROJECT_HISTORY.COMMENT_DATE FROM PROJECT_HISTORY JOIN EMP_DETAIL ON "
				+ "EMP_DETAIL.EMPLOYEE_ID=PROJECT_HISTORY.PROJECT_COMMENTOR_ID WHERE PROJECT_HISTORY.PROJECT_ID=?", new Object[]{projectId},
				(rs, rowNum) ->new EmpProjectNotes(
                rs.getLong("RCD_ID"),
                rs.getString("PROJECT_ID"),
                rs.getString("PROJECT_NOTES"),
                rs.getString("PROJECT_COMMENTOR_ID"),
                rs.getString("EMAIL"),
                rs.getString("COMMENT_DATE")));
	}

	@Override
	public int disableEmployee(EmpDisable empDisable) {
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		return getJdbcTemplate().update("insert into EMP_DISABLE_TEMP (EMPLOYEE_ID,LAST_WORKING_DATE,ACTION_CREATED_DATE,UPDATED_BY) "
				+ "values(?,?,?,?)",empDisable.getEmployeeId(),empDisable.getLastWorkingDate(),sysDate,"");
	}


	@Override
	public int removeResourceFromProject(List<String> empIds) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<AssessmentChild> getAssessmentDtlAndEmpAssmtAsAssessor(Assessment assessment) {
		System.out.println("DAO");
		String projectIdAvilableQueryFlag="";
		String projectIdAvilableCondition="";
		if(assessment.getIntervalTypeValue().equalsIgnoreCase("PROJECT")) {
			projectIdAvilableQueryFlag="PROJECTS.PROJECT_NAME AS PROJECTNAME,";
			projectIdAvilableCondition=" PROJECTS ON ASSMT_DETAIL.PROJECT_ID=PROJECTS.PROJECT_ID LEFT JOIN ";
			
		}else {
			projectIdAvilableQueryFlag="ASSMT_DETAIL.PROJECT_ID AS PROJECTNAME,";
		}
		 return jdbcTemplate.query("SELECT ASSMT_DETAIL.RCD_ID AS ASSMTDETAILRCDID,"
		 		+ "ASSMT_DETAIL.ASSMT_ID AS ASSMTID,ASSMT_DETAIL.ASSNT_ASSESSOR_ID AS ASSESSORID,"
		 		+ "EMP.EMAIL AS ASSESSOREMAIL,ASSMT_DETAIL.ASSNT_STATUS_ID AS ASSMTDTLSTATUSID,"
		 		+ "ASSMT_DETAIL.ASSMT_OUTCOME AS ASSMTOUTCOME,ASSMT_DETAIL.ASSMT_INIT_DATE AS STARTDATE,"
		 		+ "ASSMT_DETAIL.ASSMT_COMPLETED_DATE AS COMPLETEDDATE,ASSMT_DETAIL.ASSMT_DUE_DATE AS ENDDATE,"
		 		+ "ASSMT_DETAIL.PROJECT_ID AS PROJECTID,"+projectIdAvilableQueryFlag
		 		+ "ASSMT_DETAIL.ASSMT_COMMENT AS ASSMTCOMMENTS,ASSMT_DETAIL.SCHEDULED_INTERVAL_MONTHS AS SCHEDULEDINTERVALS,"
		 		+ "EMPASSMT.RCD_ID AS EMPASSMTRCDID,EMPASSMT.EMPLOYEE_ID AS ASSESSEEID,"
		 		+ "EMP2.EMAIL AS assesseeemail,EMPASSMT.ASSNT_ASSIGNED_DATE AS EMPASSMTASSIGNEDDATE,"
		 		+ "EMPASSMT.ASSMT_INIT_ID AS EMPASSMTINITID,EMPASSMT.ASSMT_STATUS_ID AS EMPASSMTSTATUSID,"
		 		+ "MSTR_STATUS.STATUS_VALUE AS DTLSTATUSVALUE FROM "
		 		+ "ASSMT_DETAIL JOIN"+projectIdAvilableCondition+ " EMP_DETAIL EMP ON EMP.EMPLOYEE_ID=ASSMT_DETAIL.ASSNT_ASSESSOR_ID "
		 		+ "LEFT JOIN EMP_ASSMT EMPASSMT ON EMPASSMT.ASSMT_ID=ASSMT_DETAIL.ASSMT_ID"
		 		+ " LEFT JOIN MSTR_STATUS ON MSTR_STATUS.STATUS_ID=ASSMT_DETAIL.ASSNT_STATUS_ID "
		 		+ "LEFT JOIN EMP_DETAIL EMP2 ON EMP2.EMPLOYEE_ID=EMPASSMT.EMPLOYEE_ID "
		 		+ "WHERE ASSMT_DETAIL.ASSMT_ID=?",
				new Object[]{assessment.getAssmtId()},(rs, rowNum) ->
                new AssessmentChild(
                		rs.getLong("ASSMTDETAILRCDID"),
                		rs.getString("ASSMTID"),
                		rs.getString("ASSESSORID"),
                		rs.getString("ASSESSOREMAIL"),
                		rs.getString("ASSMTDTLSTATUSID"),
                		rs.getString("ASSMTOUTCOME"),
                		rs.getString("STARTDATE"),
                		rs.getString("COMPLETEDDATE"),
                		rs.getString("ENDDATE"),
                		rs.getString("PROJECTID"),
                		rs.getString("PROJECTNAME"),
                		rs.getString("ASSMTCOMMENTS"),
                		rs.getString("SCHEDULEDINTERVALS"),
                		rs.getLong("EMPASSMTRCDID"),
                		rs.getString("ASSESSEEID"),
                		rs.getString("ASSESSEEEMAIL"),
                		rs.getString("EMPASSMTASSIGNEDDATE"),
                		rs.getString("EMPASSMTINITID"),
                		rs.getString("EMPASSMTSTATUSID"),
                		rs.getString("DTLSTATUSVALUE")));
	}


	@Override
	public List<EmpAssessment> getAssmtDeatils(String assessorId){
		return jdbcTemplate.query("SELECT ASSMT_DETAIL.ASSMT_ID,ASSESSMENT.ASSMT_NAME,ASSESSMENT.ASSMT_INTERVAL_ID,"
				+ "MSTR_ASSESSMENT_INTERVAL.INTERVAL_NAME,ASSESSMENT.ASSMT_DESCRIPTION,ASSESSMENT.ASSNT_STATUS_ID,"
				+ "MSTS1.STATUS_VALUE as ASSMTSTATUS,ASSMT_DETAIL.RCD_ID AS ASSMTDTLRCDID,"
				+ "ASSMT_DETAIL.ASSMT_INIT_DATE,ASSMT_DETAIL.ASSMT_DUE_DATE,ASSMT_DETAIL.ASSMT_COMPLETED_DATE,"
				+ "ASSMT_DETAIL.PROJECT_ID,ASSMT_DETAIL.ASSMT_COMMENT,ASSMT_DETAIL.SCHEDULED_INTERVAL_MONTHS,"
				+ "ASSMT_DETAIL.ASSNT_STATUS_ID,MSTS2.STATUS_VALUE ASSMTDTLSTATUS,ASSMT_DETAIL.ASSNT_ASSESSOR_ID,"
				+ "emp1.EMAIL AS ASSESSOR,EMP_ASSMT.RCD_ID AS EMPASSMTRCDID,EMP_ASSMT.EMPLOYEE_ID,emp2.EMAIL AS ASSESSEE FROM "
				+ "ASSMT_DETAIL JOIN ASSESSMENT ON ASSMT_DETAIL.ASSMT_ID=ASSESSMENT.ASSMT_ID "
				+ "INNER JOIN EMP_ASSMT ON  EMP_ASSMT.ASSMT_ID=ASSMT_DETAIL.ASSMT_ID "
				+ "LEFT JOIN MSTR_ASSESSMENT_INTERVAL "
				+ "ON MSTR_ASSESSMENT_INTERVAL.INTERVAL_ID=ASSESSMENT.ASSMT_INTERVAL_ID LEFT JOIN MSTR_STATUS MSTS1 ON "
				+ "MSTS1.STATUS_ID=ASSESSMENT.ASSNT_STATUS_ID LEFT JOIN MSTR_STATUS MSTS2 ON "
				+ "MSTS2.STATUS_ID=ASSMT_DETAIL.ASSNT_STATUS_ID LEFT JOIN EMP_DETAIL emp1 ON "
				+ "ASSMT_DETAIL.ASSNT_ASSESSOR_ID=emp1.EMPLOYEE_ID LEFT JOIN EMP_DETAIL emp2 ON "
				+ "EMP_ASSMT.EMPLOYEE_ID=emp2.EMPLOYEE_ID WHERE ASSMT_DETAIL.ASSNT_ASSESSOR_ID=?",
				new Object[] { assessorId },(rs, rowNum) ->
                new EmpAssessment(
                		rs.getString("ASSMT_ID"),
                		rs.getString("ASSMT_NAME"),
                		rs.getString("INTERVAL_NAME"),
                		rs.getString("ASSMT_DESCRIPTION"),
                		rs.getString("ASSMTSTATUS"),
                		rs.getString("ASSMTDTLRCDID"),
                		rs.getString("ASSMT_INIT_DATE"),
                		rs.getString("ASSMT_DUE_DATE"),
                		rs.getString("ASSMT_COMPLETED_DATE"),
                		rs.getString("PROJECT_ID"),
                		rs.getString("ASSMT_COMMENT"),
                		rs.getString("SCHEDULED_INTERVAL_MONTHS"),
                		rs.getString("ASSMTDTLSTATUS"),
                		rs.getString("ASSNT_ASSESSOR_ID"),
                		rs.getString("ASSESSOR"),
                		rs.getString("EMPASSMTRCDID"),
                		rs.getString("EMPLOYEE_ID"),
                		rs.getString("ASSESSEE")));
	}
	@Override
	public List<Assessees> getAssesseeDetail(String assmtId) {
		return jdbcTemplate.query("SELECT EMP_ASSMT.RCD_ID,EMP_ASSMT.EMPLOYEE_ID,EMP_DETAIL.EMAIL,EMP_ASSMT."
				+ "ASSMT_ID FROM EMP_ASSMT JOIN "
				+ "EMP_DETAIL ON EMP_ASSMT.EMPLOYEE_ID=EMP_DETAIL.EMPLOYEE_ID WHERE EMP_ASSMT.ASSMT_ID=?",
				new Object[] { assmtId },(rs, rowNum) ->
                new Assessees(
                		rs.getString("RCD_ID"),
                		rs.getString("EMPLOYEE_ID"),
                		rs.getString("EMAIL")));
		
		
	}
	@Override
	public List<AssesseeCapability> getAssmentCapabilities(String assmtId, String assmtDtlRcdId, String empAssmtRcdId) {
		return jdbcTemplate.query("SELECT ASSMT_CAPBLTY.RCD_ID,ASSMT_CAPBLTY.ASSMT_ID,ASSMT_CAPBLTY.ASSMT_DTL_RCD,ASSMT_CAPBLTY.EMP_ASSMT_RCD,"
				+ "ASSMT_CAPBLTY.ASSMT_CAPABILITY_ID,MSTR_CAPABILITY.CAPABILITY_NAME,"
				+ "ASSMT_CAPBLTY.ASSMT_COMMENT,ASSMT_CAPBLTY.ASSMT_CAPABILITY_WEIGHT,"
				+ "ASSMT_CAPBLTY.ASSMT_COMPLETED_STATUS,MSTR_STATUS.STATUS_VALUE FROM ASSMT_CAPBLTY JOIN MSTR_CAPABILITY ON "
				+ "ASSMT_CAPBLTY.ASSMT_CAPABILITY_ID=MSTR_CAPABILITY.CAPABILITY_ID LEFT JOIN MSTR_STATUS ON "
				+ "ASSMT_CAPBLTY.ASSMT_COMPLETED_STATUS=MSTR_STATUS.STATUS_ID WHERE ASSMT_CAPBLTY.ASSMT_ID=? AND "
				+ "ASSMT_CAPBLTY.ASSMT_DTL_RCD=? AND ASSMT_CAPBLTY.EMP_ASSMT_RCD=?",
				new Object[] { assmtId,assmtDtlRcdId,empAssmtRcdId },(rs, rowNum) ->
                new AssesseeCapability(
                		rs.getLong("RCD_ID"),
                		rs.getString("ASSMT_ID"),
                		rs.getString("ASSMT_DTL_RCD"),
                		rs.getString("EMP_ASSMT_RCD"),
                		rs.getString("ASSMT_CAPABILITY_ID"),
                		rs.getString("CAPABILITY_NAME"),
                		rs.getString("ASSMT_COMMENT"),
                		rs.getString("ASSMT_CAPABILITY_WEIGHT"),
                		rs.getString("ASSMT_COMPLETED_STATUS"),
                		rs.getString("STATUS_VALUE")));
	}
	@Override
	public Assessment getAssessments(String assmtId) {
		return jdbcTemplate.queryForObject("SELECT ASSESSMENT.ASSMT_ID AS ASSMTID,ASSESSMENT.ASSMT_NAME AS ASSMTNAME,ASSESSMENT.ASSMT_INTERVAL_ID AS ASSMTINTERVAL,"
				+ " MSTR_ASSESSMENT_INTERVAL.INTERVAL_NAME AS INTERVALNAME,"
				+ " ASSESSMENT.ASSNT_STATUS_ID AS STATUSID,MSTR_STATUS.STATUS_VALUE AS STATUS,"
				+ " ASSESSMENT.ASSNT_DTL_STATUS_ID AS DTLSTATUSID,ASSESSMENT.ASSMT_SUMMARY AS SUMMARY,ASSESSMENT.ASSMT_CREATED_DATE AS "
				+ " CREATEDDATE,ASSESSMENT.ASSMT_DESCRIPTION AS ASSMTDESC,ASSESSMENT.LAST_UPDATED_DATE AS UPDATEDDATE FROM ASSESSMENT JOIN "
				+ " MSTR_ASSESSMENT_INTERVAL ON MSTR_ASSESSMENT_INTERVAL.INTERVAL_ID=ASSESSMENT.ASSMT_INTERVAL_ID LEFT JOIN "
				+ " MSTR_STATUS ON MSTR_STATUS.STATUS_ID=ASSESSMENT.ASSNT_STATUS_ID where ASSESSMENT.ASSMT_ID=?",
				new Object[] { assmtId.trim() },
				(rs, rowNum) ->
                new Assessment(
                		rs.getLong("ASSMTID"),
                		rs.getString("ASSMTNAME"),
                		rs.getString("ASSMTINTERVAL"),
                		rs.getString("INTERVALNAME"),
                		rs.getString("STATUSID"),
                		rs.getString("STATUS"),
                		rs.getString("DTLSTATUSID"),
                		rs.getString("SUMMARY"),
                		rs.getString("CREATEDDATE"),
                		rs.getString("ASSMTDESC"),
                		rs.getString("UPDATEDDATE")));
	}


	@Override
	public List<AssmtCapability> getAssmtCapabilities(String assmtId) {
		return jdbcTemplate.query("SELECT ASSMT_CAPBLTY.RCD_ID,ASSMT_CAPBLTY.ASSMT_ID,ASSMT_CAPBLTY.ASSMT_DTL_RCD,"
				+ "ASSMT_CAPBLTY.ASSMT_CAPABILITY_ID,MSTR_CAPABILITY.CAPABILITY_NAME,ASSMT_CAPBLTY.ASSMT_COMMENT,ASSMT_CAPBLTY.ASSMT_CAPABILITY_WEIGHT,"
				+ "ASSMT_CAPBLTY.LAST_UPDATED_DATE FROM ASSMT_CAPBLTY JOIN MSTR_CAPABILITY ON "
				+ " ASSMT_CAPBLTY.ASSMT_CAPABILITY_ID=MSTR_CAPABILITY.CAPABILITY_ID "
				+ "WHERE ASSMT_CAPBLTY.ASSMT_ID=?", 
				new Object[]{assmtId},
				(rs, rowNum) ->new AssmtCapability(
                rs.getLong("RCD_ID"),
                rs.getString("ASSMT_ID"),
                rs.getString("ASSMT_DTL_RCD"),
                rs.getString("ASSMT_CAPABILITY_ID"),
                rs.getString("CAPABILITY_NAME"),
                rs.getString("ASSMT_COMMENT"),
                rs.getString("ASSMT_CAPABILITY_WEIGHT"),
                rs.getString("LAST_UPDATED_DATE")));
	}


	@Override
	public List<EmpAssessment> getAssmtIdsByAssessee(String empId) {
		return jdbcTemplate.query("SELECT ASSMT_DETAIL.ASSMT_ID,ASSESSMENT.ASSMT_NAME,"
				+ "ASSESSMENT.ASSMT_INTERVAL_ID,"
				+ "MSTR_ASSESSMENT_INTERVAL.INTERVAL_NAME,ASSESSMENT.ASSMT_DESCRIPTION,"
				+ "ASSESSMENT.ASSNT_STATUS_ID,MSTS1.STATUS_VALUE as ASSMTSTATUS,"
				+ "ASSMT_DETAIL.RCD_ID AS ASSMTDTLRCDID,"
				+ "ASSMT_DETAIL.ASSMT_INIT_DATE,ASSMT_DETAIL.ASSMT_DUE_DATE,ASSMT_DETAIL.ASSMT_COMPLETED_DATE,"
				+ "ASSMT_DETAIL.PROJECT_ID,ASSMT_DETAIL.ASSMT_COMMENT,ASSMT_DETAIL.SCHEDULED_INTERVAL_MONTHS,"
				+ "ASSMT_DETAIL.ASSNT_STATUS_ID,MSTS2.STATUS_VALUE as ASSMTDTLSTATUS,ASSMT_DETAIL.ASSNT_ASSESSOR_ID,"
				+ "emp2.EMAIL AS ASSESSOR,"
				+ "ASSESSMENT.ASSMT_SUMMARY,ASSESSMENT.ASSNT_DTL_STATUS_ID,"
				+ "EMP_ASSMT.RCD_ID AS EMPASSMTRCDID,EMP_ASSMT.EMPLOYEE_ID,emp1.EMAIL ASASSESSEE "
				+ "FROM EMP_ASSMT JOIN ASSESSMENT ON EMP_ASSMT.ASSMT_ID=ASSESSMENT.ASSMT_ID JOIN EMP_DETAIL emp1 "
				+ "ON EMP_ASSMT.EMPLOYEE_ID=emp1.EMPLOYEE_ID LEFT JOIN MSTR_ASSESSMENT_INTERVAL ON MSTR_ASSESSMENT_INTERVAL.INTERVAL_ID=ASSESSMENT.ASSMT_INTERVAL_ID INNER JOIN ASSMT_DETAIL "
				+ "ON EMP_ASSMT.ASSMT_ID=ASSMT_DETAIL.ASSMT_ID LEFT JOIN EMP_DETAIL emp2 ON emp2.EMPLOYEE_ID=ASSMT_DETAIL.ASSNT_ASSESSOR_ID "
				+ "LEFT JOIN MSTR_STATUS MSTS1 ON MSTS1.STATUS_ID=ASSESSMENT.ASSNT_STATUS_ID left JOIN MSTR_STATUS MSTS2 on "
				+ "ASSMT_DETAIL.ASSNT_STATUS_ID=MSTS2.STATUS_ID WHERE EMP_ASSMT.EMPLOYEE_ID=?",
				new Object[] { empId },
				(rs, rowNum) ->  new EmpAssessment(
                		rs.getString("ASSMT_ID"),
                		rs.getString("ASSMT_NAME"),
                		rs.getString("INTERVAL_NAME"),
                		rs.getString("ASSMT_DESCRIPTION"),
                		rs.getString("ASSMTSTATUS"),
                		rs.getString("ASSMTDTLRCDID"),
                		rs.getString("ASSMT_INIT_DATE"),
                		rs.getString("ASSMT_DUE_DATE"),
                		rs.getString("ASSMT_COMPLETED_DATE"),
                		rs.getString("PROJECT_ID"),
                		rs.getString("ASSMT_COMMENT"),
                		rs.getString("SCHEDULED_INTERVAL_MONTHS"),
                		rs.getString("ASSMTDTLSTATUS"),
                		rs.getString("ASSNT_ASSESSOR_ID"),
                		rs.getString("ASSESSOR"),
                		rs.getString("EMPASSMTRCDID"),
                		rs.getString("EMPLOYEE_ID"),
                		rs.getString("ASASSESSEE")));
		

	}

	@Override
	public List<EmpAssesseeAssmtDetail> getAssmtDetailByAssessee(String assmtId) {
		return jdbcTemplate.query("SELECT ASSMT_DETAIL.RCD_ID,ASSMT_DETAIL.ASSNT_ASSESSOR_ID,"
				+ "EMP_DETAIL.EMAIL,ASSMT_DETAIL.ASSNT_STATUS_ID,MSTR_STATUS.STATUS_VALUE,"
				+ "ASSMT_DETAIL.ASSMT_OUTCOME,ASSMT_DETAIL.ASSMT_INIT_DATE,ASSMT_DETAIL.ASSMT_DUE_DATE,"
				+ "ASSMT_DETAIL.ASSMT_COMPLETED_DATE,ASSMT_DETAIL.PROJECT_ID,ASSMT_DETAIL.ASSMT_COMMENT,"
				+ "ASSMT_DETAIL.SCHEDULED_INTERVAL_MONTHS FROM ASSMT_DETAIL JOIN EMP_DETAIL ON "
				+ "ASSMT_DETAIL.ASSNT_ASSESSOR_ID=EMP_DETAIL.EMPLOYEE_ID LEFT JOIN MSTR_STATUS ON "
				+ "ASSMT_DETAIL.ASSNT_STATUS_ID=MSTR_STATUS.STATUS_ID WHERE ASSMT_DETAIL.ASSMT_ID=?",
				new Object[] { assmtId },
				(rs, rowNum) -> new EmpAssesseeAssmtDetail(rs.getString("RCD_ID"), rs.getString("ASSNT_ASSESSOR_ID"),
						rs.getString("EMAIL"), rs.getString("STATUS_VALUE"), rs.getString("ASSMT_OUTCOME"),
						rs.getString("ASSMT_INIT_DATE"), rs.getString("ASSMT_DUE_DATE"), 
						rs.getString("ASSMT_COMPLETED_DATE"), rs.getString("PROJECT_ID"), rs.getString("ASSMT_COMMENT"),
						rs.getString("SCHEDULED_INTERVAL_MONTHS")));
		
		
	}
	@Override
	public int completeAssessment(EmpAssessment empAssessment) {
		 System.out.println("Entering DAO");
		int updatedCount=0;
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		for(AssesseeCapability assmtCapability:empAssessment.getAssesseeCapabilityInfo()) {
			updatedCount=jdbcTemplate.update("update ASSMT_CAPBLTY set ASSMT_CAPABILITY_WEIGHT=?,ASSMT_COMMENT=?,LAST_UPDATED_DATE=?,"
					+ "ASSMT_COMPLETED_STATUS=? where RCD_ID=? and ASSMT_DTL_RCD=? and ASSMT_ID=? and EMP_ASSMT_RCD=?",
					assmtCapability.getCapabilityWeight(),assmtCapability.getCompletionComment(),sysDate,"8",assmtCapability.getRcdId(),
					empAssessment.getAssmtDtlRcdId(),empAssessment.getAssmtId(),assmtCapability.getEmpAssessmtRcdId());
		}
		return updatedCount;
	}


	@Override
	public int updateAssmtEmp(Assessment assessment) {
		int updatedCount=0;
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		/*
		 * for(String assessee : assessment.getAssesseeIds()) {
		 * updatedCount=jdbcTemplate.update(
		 * "update EMP_ASSMT set ASSMT_STATUS_ID=? where RCD_ID=? and EMPLOYEE_ID=? and ASSMT_ID=?"
		 * , //assessment.); }
		 */
		return updatedCount;
	}


	@Override
	public int updateAssmtDetail(Assessment assessment) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int updateAssmt(Assessment assessment) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int statusUpdateInAssmtDetail(EmpAssessment empAssessment) {
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		return jdbcTemplate.update(
				"update ASSMT_DETAIL set ASSMT_COMMENT=?,ASSMT_COMPLETED_DATE=? where ASSMT_ID=? and RCD_ID=?", empAssessment.getAssmtComment(),
				sysDate,empAssessment.getAssmtId(), empAssessment.getAssmtDtlRcdId());
	}


	@Override
	public int getPendingTrainings(String empId) {
		System.out.println("DAO--train");
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMP_TRNG WHERE EMP_TRNG.EMPLOYEE_ID=?"
				+ " AND EMP_TRNG.TRNG_STATUS_ID!='8'", new Object[] { empId },int.class);
				
	}


	@Override
	public int getPendingGoals(String empId) {
		System.out.println("DAO--gaol");
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMP_GOAL WHERE "
				+ "EMP_GOAL.EMPLOYEE_ID=? AND EMP_GOAL.GOAL_STATUS_ID!='9'", new Object[] { empId },int.class);
	}


	@Override
	public int getPendingAssessments(String empId) {
		System.out.println("DAO--assess");
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ASSMT_DETAIL WHERE "
				+ "ASSMT_DETAIL.ASSNT_ASSESSOR_ID=? AND ASSMT_DETAIL.ASSNT_STATUS_ID!='8'", new Object[] { empId },int.class);
	}


	@Override
	public List<Reportee> getReporteeList(String empId) {
		System.out.println("DAO--reportee");
		return jdbcTemplate.query("SELECT EMP_DETAIL.EMPLOYEE_ID,EMP_DETAIL.FIRST_NAME,"
				+ "EMP_DETAIL.MIDDLE_NAME,"
				+ "EMP_DETAIL.LAST_NAME,EMP_DETAIL.EMAIL,EMP_DETAIL.POSITION,EMP_DETAIL.COST_TO_COMPANY,"
				+ "MSTR_POSITION.POSITION_NAME FROM EMP_DETAIL JOIN MSTR_POSITION ON "
				+ "MSTR_POSITION.POSITION_ID=EMP_DETAIL.POSITION WHERE EMP_DETAIL.MANAGER_ID=?",
				new Object[] { empId },
				(rs, rowNum) -> new Reportee(rs.getString("EMPLOYEE_ID"),
						rs.getString("FIRST_NAME"),
						rs.getString("MIDDLE_NAME"),
						rs.getString("LAST_NAME"),
						rs.getString("EMAIL"),
						rs.getString("POSITION_NAME")));
	}


	@Override
	public String getEmpUtilization(String empId) {
		System.out.println("DAO--util");
		return jdbcTemplate.queryForObject("SELECT SUM(PROJ_UTL_PERCENT) AS utilization FROM "
				+ "EMP_PROJECT WHERE EMP_PROJECT.EMPLOYEE_ID=? AND "
				+ "EMP_PROJECT.STATUS_ID='3'", new Object[] { empId },String.class);
	}


	@Override
	public String getAvgRating(String loggedInUser, String startDate, String endDate) {
		return jdbcTemplate.queryForObject("SELECT AVG(ASSESSMENT.ASSMT_SUMMARY) FROM EMP_ASSMT "
				+ "JOIN ASSMT_DETAIL ON EMP_ASSMT.ASSMT_ID=ASSMT_DETAIL.ASSMT_ID "
				+ "LEFT JOIN ASSESSMENT ON EMP_ASSMT.ASSMT_ID=ASSESSMENT.ASSMT_ID "
				+ "WHERE ASSMT_DETAIL.ASSNT_STATUS_ID='8' AND "
				+ "ASSMT_DETAIL.ASSMT_INIT_DATE>=? AND "
				+ "ASSMT_DETAIL.ASSMT_DUE_DATE<=? AND "
				+ "EMP_ASSMT.EMPLOYEE_ID=?", new Object[] { startDate,endDate,loggedInUser },String.class);
	}
	
	@Override
	public List<Notification> myNotifications(String loggedInUser) {
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		
		  return jdbcTemplate.query("SELECT ANNOUNCEMENT_DETAIL.ANNOUNCEMENT_ID,"
		  		+ "COMPANY_ANNOUNCEMENTS.PUBLISHED_DATE,ANNOUNCEMENT_DETAIL.AUDIENCE_LEVEL,"
		  		+ "COMPANY_ANNOUNCEMENTS.VALID_TO,COMPANY_ANNOUNCEMENTS.ANNC_TITLE,COMPANY_ANNOUNCEMENTS.ANNC_DESCRIPTION FROM "
		  		+ "ANNOUNCEMENT_DETAIL JOIN COMPANY_ANNOUNCEMENTS ON "
		  		+ "ANNOUNCEMENT_DETAIL.ANNOUNCEMENT_ID=COMPANY_ANNOUNCEMENTS.ANNC_ID "
		  		+ "WHERE COMPANY_ANNOUNCEMENTS.STATUS_ID='0' AND COMPANY_ANNOUNCEMENTS.VALID_TO >=? AND "
		  		+ "(ANNOUNCEMENT_DETAIL.AUDIENCE_LEVEL='15' || ANNOUNCEMENT_DETAIL.AUDIENCE_LEVEL='ALL')", 
		  		new Object[] { sysDate },(rs, rowNum) -> new Notification(rs.getLong("ANNOUNCEMENT_ID"),
		  				rs.getString("PUBLISHED_DATE"),rs.getString("ANNC_TITLE"),
						rs.getString("ANNC_DESCRIPTION")));
		 
	}
	
	@Override
	public int deleteExistingRoles(String empId) {
		System.out.println("DAO-DEL");
		return jdbcTemplate.update("DELETE FROM EMP_ACCESSROLES WHERE EMP_ID=?", empId);
	}


	@Override
	public int createEmployeeAccessRole(EmpAccessRole empAccessRole, String sysDate) {
		System.out.println("DAO2---ADD");
		int addedFlag=0;
		for(Long accessRoleId:empAccessRole.getUserRoleIds()) {
			System.out.println("DAO2---ADD+accessRoleId ::"+accessRoleId+"  :;empAccessRole.getEmpId() "+empAccessRole.getEmpId());
			addedFlag=addedFlag+jdbcTemplate.update(
				"insert into EMP_ACCESSROLES (EMP_ID,ROLE_ID) values(?,?)",empAccessRole.getEmpId(),accessRoleId);
		}
		return addedFlag;
		
	}


	@Override
	public List<UserRoles> getEmployeeAccessRoles(String empId) {
		return jdbcTemplate.query("SELECT EMP_ACCESSROLES.EMP_ID,EMP_ACCESSROLES.ROLE_ID,ROLES.ROLE_NAME FROM EMP_ACCESSROLES JOIN \r\n" + 
				"ROLES ON ROLES.ID=EMP_ACCESSROLES.ROLE_ID WHERE EMP_ACCESSROLES.EMP_ID=?", 
		  		new Object[] { empId },(rs, rowNum) -> new UserRoles(rs.getLong("ROLE_ID"),
		  				rs.getString("ROLE_NAME")));
	}


	@Override
	public List<Usercheck> getUserAccessRoleByEmail(String username) {
		return jdbcTemplate.query(
				"SELECT EMP_DETAIL.FIRST_NAME,EMP_DETAIL.LAST_NAME,EMP_DETAIL.EMAIL,EMP_ACCESSROLES.EMP_ID,EMP_ACCESSROLES.ROLE_ID,ROLES.CODE,ROLES.ROLE_NAME FROM "
						+ "EMP_DETAIL JOIN EMP_ACCESSROLES ON EMP_DETAIL.EMPLOYEE_ID=EMP_ACCESSROLES.EMP_ID JOIN ROLES ON "
						+ "ROLES.ID=EMP_ACCESSROLES.ROLE_ID WHERE " + "EMP_DETAIL.EMAIL='"+username+"'",
				/* new Object[] { username }, */(rs, rowNum) -> new Usercheck(rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"),rs.getString("EMP_ID"),rs.getString("CODE")));
	}

	@Override
	public List<Employee> employeeBasicSearch(String queryBasicSearch) {
		return jdbcTemplate.query(queryBasicSearch,
				(rs, rowNum) -> new Employee(rs.getLong("RCD_ID"),rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
						rs.getString("MIDDLE_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"),
						rs.getString("ADDRESS_LINE_1"), rs.getString("ADDRESS_LINE_2"), rs.getString("ZIP_CODE"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("COUNTRY"),
						rs.getString("ADDRESS_TYPE"), rs.getString("CONTACT_NUMBER_1"),
						rs.getString("CONTACT_NUMBER_2"), rs.getString("HIRE_DATE"), rs.getString("POSITION"),rs.getString("POSITION_NAME"),
						rs.getString("POSITION_LEVEL"), rs.getString("COST_TO_COMPANY"), rs.getString("CTC_CURRENCY"),
						rs.getString("COMMISSION_PCT"), rs.getString("MANAGER_ID"), rs.getString("MANAGEREMAIL"),
						rs.getString("DEPARTMENT_ID"), rs.getString("DEPARTMENT"),
						rs.getString("EMPLOYMENT_STATUS"),rs.getString("STATUS_VALUE"), rs.getString("EMPLOYMENT_TYPE")
						));
	}


	@Override
	public List<UserSkills> empSkills(String querySkillSearch) {
		return jdbcTemplate.query(querySkillSearch,
                
                (rs, rowNum) ->
                new UserSkills(
                        rs.getString("SKILL_NAME"),
                        rs.getLong("SKILL_EXPERIENCE"),
                        rs.getString("CERTIFIED"),
                        rs.getString("SKILL_LEVEL")));
	}


	@Override
	public String getAvgRatingForEmp(String ratingQuery) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(ratingQuery,String.class);
	}


	@Override
	public List<Utilization> avgratingWithDate(String utilizationQuery) {
		return jdbcTemplate.query(utilizationQuery,

				(rs, rowNum) -> new Utilization(rs.getString("MONTH"), rs.getString("UTILIZATION")));
	}


	@Override
	public List<String> getEmpIdsBySkills(String querySkillSearch) {
		return jdbcTemplate.query(querySkillSearch,

				(rs, rowNum) -> new String(rs.getString("EMPLOYEE_ID")));
	}


	@Override
	public Employee getEmployeeDeatailsById(String empId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT EMP_DETAIL.RCD_ID,EMP_DETAIL.EMPLOYEE_ID,EMP_DETAIL.FIRST_NAME,EMP_DETAIL.MIDDLE_NAME,"
				+ "EMP_DETAIL.LAST_NAME,EMP_DETAIL.EMAIL,EMP_DETAIL.ADDRESS_LINE_1,EMP_DETAIL.ADDRESS_LINE_2,"
				+ "EMP_DETAIL.ZIP_CODE,EMP_DETAIL.CITY,EMP_DETAIL.STATE,EMP_DETAIL.COUNTRY,EMP_DETAIL.ADDRESS_TYPE,"
				+ "EMP_DETAIL.CONTACT_NUMBER_1,EMP_DETAIL.CONTACT_NUMBER_2,EMP_DETAIL.HIRE_DATE,EMP_DETAIL.POSITION,"
				+ "MSTR_POSITION.POSITION_NAME,EMP_DETAIL.POSITION_LEVEL,EMP_DETAIL.COST_TO_COMPANY,"
				+ "EMP_DETAIL.CTC_CURRENCY,EMP_DETAIL.COMMISSION_PCT,EMP_DETAIL.MANAGER_ID,emp.EMAIL AS "
				+ "MANAGEREMAIL,EMP_DETAIL.DEPARTMENT,EMP_DETAIL.DEPARTMENT_ID,EMP_DETAIL.EMPLOYMENT_STATUS,"
				+ "MSTR_STATUS.STATUS_VALUE,EMP_DETAIL.EMPLOYMENT_TYPE FROM EMP_DETAIL JOIN MSTR_POSITION ON "
				+ "EMP_DETAIL.POSITION=MSTR_POSITION.POSITION_ID LEFT JOIN MSTR_STATUS ON "
				+ "EMP_DETAIL.EMPLOYMENT_STATUS=MSTR_STATUS.STATUS_ID LEFT JOIN EMP_DETAIL emp ON "
				+ "EMP_DETAIL.MANAGER_ID=emp.EMPLOYEE_ID WHERE EMP_DETAIL.EMPLOYEE_ID=?",new Object[] { empId },
				(rs, rowNum) -> new Employee(rs.getLong("RCD_ID"),rs.getString("EMPLOYEE_ID"), rs.getString("FIRST_NAME"),
						rs.getString("MIDDLE_NAME"), rs.getString("LAST_NAME"), rs.getString("EMAIL"),
						rs.getString("ADDRESS_LINE_1"), rs.getString("ADDRESS_LINE_2"), rs.getString("ZIP_CODE"),
						rs.getString("CITY"), rs.getString("STATE"), rs.getString("COUNTRY"),
						rs.getString("ADDRESS_TYPE"), rs.getString("CONTACT_NUMBER_1"),
						rs.getString("CONTACT_NUMBER_2"), rs.getString("HIRE_DATE"), rs.getString("POSITION"),rs.getString("POSITION_NAME"),
						rs.getString("POSITION_LEVEL"), rs.getString("COST_TO_COMPANY"), rs.getString("CTC_CURRENCY"),
						rs.getString("COMMISSION_PCT"), rs.getString("MANAGER_ID"), rs.getString("MANAGEREMAIL"),
						rs.getString("DEPARTMENT_ID"), rs.getString("DEPARTMENT"),
						rs.getString("EMPLOYMENT_STATUS"),rs.getString("STATUS_VALUE"), rs.getString("EMPLOYMENT_TYPE")
						));
	}


	@Override
	public List<String> getEmpIdsByUtilization(String utilization) {
		return jdbcTemplate.query("SELECT utilization.EMPLOYEE_ID,GROUP_CONCAT(utilization.MONTH) AS MONTHYEAR FROM utilization "
				+ "WHERE utilization.UTILIZATION <= '"+utilization+"' GROUP BY utilization.EMPLOYEE_ID",

				(rs, rowNum) -> new String(rs.getString("EMPLOYEE_ID")));
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
	
	/*
	 * @Override public List<Long> getEmployeeMyAccessRoles() { return jdbcTemplate.
	 * query("SELECT EMP_ACCESSROLES.EMP_ID,EMP_ACCESSROLES.ROLE_ID,ROLES.ROLE_NAME FROM EMP_ACCESSROLES JOIN \r\n"
	 * + "ROLES ON ROLES.ID=EMP_ACCESSROLES.ROLE_ID WHERE ", (rs, rowNum) -> new
	 * UserRoles(rs.getLong("ROLE_ID"), rs.getString("ROLE_NAME"))); }
	 */


	
	
}
