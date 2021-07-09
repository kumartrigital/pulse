package com.gss.pulseworkflow.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gss.pulseworkflow.dao.EmpRepo;
import com.gss.pulseworkflow.dao.EmployeeRepository;
import com.gss.pulseworkflow.model.AssesseeCapability;
import com.gss.pulseworkflow.model.EmpAccessRole;
import com.gss.pulseworkflow.model.EmpAssessment;
import com.gss.pulseworkflow.model.EmpDisable;
import com.gss.pulseworkflow.model.EmpSearch;
import com.gss.pulseworkflow.model.Employee;
import com.gss.pulseworkflow.model.EmployeeValidation;
import com.gss.pulseworkflow.model.HomeObj;
import com.gss.pulseworkflow.model.Notification;
import com.gss.pulseworkflow.model.Rating;
import com.gss.pulseworkflow.model.Reportee;
import com.gss.pulseworkflow.model.Task;
import com.gss.pulseworkflow.model.UserRoles;
import com.gss.pulseworkflow.model.UserSkills;
import com.gss.pulseworkflow.model.Utilization;
import com.gss.pulseworkflow.oauth.service.WSO2UserWebService;
import com.gss.pulseworkflow.service.EmployeeService;
import com.gss.pulseworkflow.utility.Helper;
import com.gss.pulseworkflow.utility.Validation;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private WSO2UserWebService wSO2UserWebService;
	@Autowired(required=true)
	private EmpRepo empRepo;

	@Override
	public int disableEmployee(EmpDisable empDisable) {
		return employeeRepository.disableEmployee(empDisable);
	}

	@Override
	public int removeResourceFromProject(List<String> empIds) {
		return employeeRepository.removeResourceFromProject(empIds);
	}

	@Override
	public List<EmpAssessment> getAssessmentsByEmpIdAsAssessor(String empId) {

		List<EmpAssessment> empAssessments = employeeRepository.getAssmtDeatils(empId);

		for (EmpAssessment empAssessment : empAssessments) {
			//List<Assessees> listOfAssessees = employeeRepository.getAssesseeDetail(empAssessment.getAssmtId());
			//for (Assessees assessees : listOfAssessees) {
				List<AssesseeCapability> listofAssesseeCapabilities = employeeRepository.getAssmentCapabilities(
						empAssessment.getAssmtId(), empAssessment.getAssmtDtlRcdId(), empAssessment.getEmpAssmtRcdId());
				empAssessment.setAssesseeCapabilityInfo(listofAssesseeCapabilities);
			//}
			//empAssessment.setAssesseeAssmtDetails(listOfAssessees);
		}
		
		return empAssessments;
	}

	@Override
	public List<EmpAssessment> getAssessmentsByEmpIdAsAssessee(String empId) {
		List<EmpAssessment> empAssesseeList = employeeRepository.getAssmtIdsByAssessee(empId);
		for (EmpAssessment empAssessment : empAssesseeList) {
			/*
			 * List<EmpAssesseeAssmtDetail> empAssesseeAssmtDetailList = employeeRepository
			 * .getAssmtDetailByAssessee(empAssessee.getAssmtId());
			 */
			//for(EmpAssesseeAssmtDetail empAssesseeAssmtDetail:empAssesseeAssmtDetailList) {
			List<AssesseeCapability> listofAssesseeCapabilities = employeeRepository.getAssmentCapabilities(
					empAssessment.getAssmtId(), empAssessment.getAssmtDtlRcdId(), empAssessment.getEmpAssmtRcdId());
			empAssessment.setAssesseeCapabilityInfo(listofAssesseeCapabilities);
			//}
			
		}
		
		//System.out.println("assmtIds ::" + assmtIds.size()+"  "+assmtIds.get(0)+assmtIds.get(1));
		/*
		 * if (assmtIds.size() > 0) { //System.out.println("assmtIds :: if" +
		 * assmtIds.size()); List<Assessment> assessmentResList = new
		 * ArrayList<Assessment>(); Helper helper = new Helper(); for (String assmtId :
		 * assmtIds) { //System.out.println("assmtIds :: if for" + assmtId.toString());
		 * Assessment assessment = employeeRepository.getAssessments(assmtId);
		 * //System.out.println("assessment::"+assessment);
		 * 
		 * List<AssessmentChild> assessmentChildList = employeeRepository
		 * .getAssessmentDtlAndEmpAssmtAsAssessor(assessment); assessment =
		 * helper.dataMap(assessmentChildList, assessment);
		 * //System.out.println("Child assessment::" + assessment);
		 * List<AssmtCapability> assmtCapability =
		 * employeeRepository.getAssmtCapabilities(assmtId);
		 * assessment.setAssmtCapabilities(assmtCapability);
		 * assessmentResList.add(assessment);
		 * 
		 * } return assessmentResList; }
		 */
		return empAssesseeList;
	}

	@Override
	@Transactional
	public int completeAssessment(EmpAssessment empAssessment) {
		 System.out.println("Entering Service");
		 int updateStatus=0;
		int updatedCapabilityFlag=employeeRepository.completeAssessment(empAssessment);
		if(updatedCapabilityFlag>0) {
			updateStatus=employeeRepository.statusUpdateInAssmtDetail(empAssessment);
		}
		/*
		 * if(updatedCapabilityFlag >0) { employeeRepository.updateAssmtEmp(assessment);
		 * employeeRepository.updateAssmtDetail(assessment);
		 * employeeRepository.updateAssmt(assessment); }
		 */
		return updateStatus;
	}

	@Override
	public List<Employee> employeeSearch(EmpSearch empSearch) {
		
		 // QueryObj query=new QueryObj(); 
		List<Employee> resObj=new ArrayList<Employee>();
		try {
		
		  String queryBasicSearch= empSearchBuildQuery(empSearch); 
		  System.out.println("queryBasicSearch:: "+queryBasicSearch);
		  boolean conditionFlag=false;
		  if(!queryBasicSearch.isEmpty() &&queryBasicSearch!=null) { 
			  System.out.println("queryBasicSearch:: if"+queryBasicSearch);
			  List<Employee> employeeBasicSearch=employeeRepository.employeeBasicSearch(queryBasicSearch);
			  for(Employee empBasicDetails:employeeBasicSearch) {
				  boolean flag=false;
				  Employee response=new Employee();
				 
				  String querySkillSearch=null;
				  if(empSearch.getSkills()==null) {
					  querySkillSearch=empSkillSearchBuildQueryByEmpty(empBasicDetails.getEmployeeId());
				  }else if(empSearch.getSkills().size() > 0 || empSearch.getSkills()!=null) {
					  querySkillSearch=empSkillSearchBuildQuery(empSearch.getSkills(),empBasicDetails.getEmployeeId());
				  }
				  List<UserSkills> skillList=employeeRepository.empSkills(querySkillSearch);
				  
				  if(empSearch.getRating()!=null && !empSearch.getRating().isEmpty()) {
					  String ratingQuery=empRatingBuildQuery(empBasicDetails.getEmployeeId());
					String rating=employeeRepository.getAvgRatingForEmp(ratingQuery);
					  //String rating="80";
						if (rating!=null && Double.parseDouble(empSearch.getRating()) <= Double.parseDouble(rating)) {
							response.setAvgRating(rating);
						}else {
							break;
						}
				  }else{
					  String ratingQuery=empRatingBuildQuery(empBasicDetails.getEmployeeId()); 
					  String rating=employeeRepository.getAvgRatingForEmp(ratingQuery);
					  response.setAvgRating(rating);
				  }
				  String utilizationQuery=null;
				  if(empSearch.getStartDate()!=null && empSearch.getEndDate()!=null && empSearch.getUtilization()!=null) {
					  utilizationQuery=empUtilizationBuildQuery(empBasicDetails.getEmployeeId(),empSearch.getStartDate(),
							  empSearch.getEndDate(),empSearch.getUtilization());
					  flag=true;
					  
				  }else if(empSearch.getStartDate()!=null && empSearch.getEndDate()!=null && !flag){
					  utilizationQuery=empUtilizationBuildQueryWithDates(empBasicDetails.getEmployeeId(),empSearch.getStartDate(),
							  empSearch.getEndDate());
					  flag=true;
				  }else if(empSearch.getUtilization()!=null && !flag) {
					  utilizationQuery=empUtilizationBuildQueryWithUTL(empBasicDetails.getEmployeeId(),empSearch.getUtilization());
					  flag=true;
				  }else {
					  utilizationQuery=empUtilizationBuildQueryWithEmp(empBasicDetails.getEmployeeId());
					  flag=true;
				  }
				  List<Utilization> utilizationRes=null;
				  if(flag) {
					  utilizationRes=employeeRepository.avgratingWithDate(utilizationQuery); 
				  }
				  
				  response.setUtilization(utilizationRes);
				  response=dataMapping(response,empBasicDetails);
				 // response.setEmployee(empBasicDetails);
				  response.setUserSkills(skillList);
				  resObj.add(response); 
			  }
			  conditionFlag=true;
			} else if ((queryBasicSearch.isEmpty() || queryBasicSearch == null) && !conditionFlag
					&& ( empSearch.getSkills() != null)) {
				String querySkillSearch=empSkillSearchBuildQueyBySkills(empSearch.getSkills());
				List<String> employeeIds=employeeRepository.getEmpIdsBySkills(querySkillSearch);
				for(String empId:employeeIds) {
					boolean flag=false;
					  Employee response=new Employee();
				Employee empObj=employeeRepository.getEmployeeDeatailsById(empId);
				  String querySkillSearch2=null;
				  if(empSearch.getSkills().size() > 0 || empSearch.getSkills()!=null) {
					  querySkillSearch2=empSkillSearchBuildQuery(empSearch.getSkills(),empObj.getEmployeeId());
				  }
				  List<UserSkills> skillList=employeeRepository.empSkills(querySkillSearch2);
				  
				  if(empSearch.getRating()!=null && !empSearch.getRating().isEmpty()) {
					  String ratingQuery=empRatingBuildQuery(empObj.getEmployeeId());
					String rating=employeeRepository.getAvgRatingForEmp(ratingQuery);
					  //String rating="80";
						if (rating!=null && Double.parseDouble(empSearch.getRating()) <= Double.parseDouble(rating)) {
							response.setAvgRating(rating);
						}else {
							break;
						}
				  }else{
					  String ratingQuery=empRatingBuildQuery(empObj.getEmployeeId()); 
					  String rating=employeeRepository.getAvgRatingForEmp(ratingQuery);
					  response.setAvgRating(rating);
				  }
				  String utilizationQuery=null;
				  if(empSearch.getStartDate()!=null && empSearch.getEndDate()!=null && empSearch.getUtilization()!=null) {
					  utilizationQuery=empUtilizationBuildQuery(empObj.getEmployeeId(),empSearch.getStartDate(),
							  empSearch.getEndDate(),empSearch.getUtilization());
					  flag=true;
					  
				  }else if(empSearch.getStartDate()!=null && empSearch.getEndDate()!=null && !flag){
					  utilizationQuery=empUtilizationBuildQueryWithDates(empObj.getEmployeeId(),empSearch.getStartDate(),
							  empSearch.getEndDate());
					  flag=true;
				  }else if(empSearch.getUtilization()!=null && !flag) {
					  utilizationQuery=empUtilizationBuildQueryWithUTL(empObj.getEmployeeId(),empSearch.getUtilization());
					  flag=true;
				  }else {
					  utilizationQuery=empUtilizationBuildQueryWithEmp(empObj.getEmployeeId());
					  flag=true;
				  }
				  List<Utilization> utilizationRes=null;
				  if(flag) {
					  utilizationRes=employeeRepository.avgratingWithDate(utilizationQuery); 
				  }
				  
				  response.setUtilization(utilizationRes);
				  response=dataMapping(response,empObj);
				  //response.setEmployee(empObj);
				  response.setUserSkills(skillList);
				  resObj.add(response); 
				}
				conditionFlag=true;
			}else if(!conditionFlag && (empSearch.getUtilization()!=null )) {
				List<String> empIds=employeeRepository.getEmpIdsByUtilization(empSearch.getUtilization());
				System.out.println("empSearch.getUtilization()"+empSearch.getUtilization()+"empIds.size()"+empIds.size());
				//if(empIds.size() >0 || empIds!=null) {
				for(String empId:empIds) {
				boolean flag=false;
				  Employee response=new Employee();
			Employee empObj=employeeRepository.getEmployeeDeatailsById(empId);
			  String querySkillSearch2=null;
			  if(empSearch.getSkills()!=null) {
				  querySkillSearch2=empSkillSearchBuildQuery(empSearch.getSkills(),empObj.getEmployeeId());
			  }else if(empSearch.getSkills()==null) {
				  querySkillSearch2=empSkillSearchBuildQueryByEmpty(empObj.getEmployeeId());
			  }
			  List<UserSkills> skillList=employeeRepository.empSkills(querySkillSearch2);
			  
			  if(empSearch.getRating()!=null && !empSearch.getRating().isEmpty()) {
				  String ratingQuery=empRatingBuildQuery(empObj.getEmployeeId());
				String rating=employeeRepository.getAvgRatingForEmp(ratingQuery);
				 // String rating="80";
					if (rating!=null && Double.parseDouble(empSearch.getRating()) <= Double.parseDouble(rating)) {
						response.setAvgRating(rating);
					}else {
						break;
					}
			  }else{
				  String ratingQuery=empRatingBuildQuery(empObj.getEmployeeId()); 
				  String rating=employeeRepository.getAvgRatingForEmp(ratingQuery);
				  response.setAvgRating(rating);
			  }
			  String utilizationQuery=null;
			  if(empSearch.getStartDate()!=null && empSearch.getEndDate()!=null && empSearch.getUtilization()!=null) {
				  utilizationQuery=empUtilizationBuildQuery(empObj.getEmployeeId(),empSearch.getStartDate(),
						  empSearch.getEndDate(),empSearch.getUtilization());
				  flag=true;
				  
			  }else if(empSearch.getStartDate()!=null && empSearch.getEndDate()!=null && !flag){
				  utilizationQuery=empUtilizationBuildQueryWithDates(empObj.getEmployeeId(),empSearch.getStartDate(),
						  empSearch.getEndDate());
				  flag=true;
			  }else if(empSearch.getUtilization()!=null && !flag) {
				  utilizationQuery=empUtilizationBuildQueryWithUTL(empObj.getEmployeeId(),empSearch.getUtilization());
				  flag=true;
			  }else {
				  utilizationQuery=empUtilizationBuildQueryWithEmp(empObj.getEmployeeId());
				  flag=true;
			  }
			  List<Utilization> utilizationRes=null;
			  if(flag) {
				  utilizationRes=employeeRepository.avgratingWithDate(utilizationQuery); 
			  }
			  
			  response.setUtilization(utilizationRes);
			  response=dataMapping(response,empObj);
			  //response.setEmployee(empObj);
			  response.setUserSkills(skillList);
			  resObj.add(response); 
			}
			//}
			conditionFlag=true;
			}else if(!conditionFlag) {
				String queryBasicSearchEmpty=getQuesryForBasicEmpty();
				System.out.println("queryBasicSearchEmpty ::"+queryBasicSearchEmpty);
				List<Employee> employeeBasicSearch=employeeRepository.employeeBasicSearch(queryBasicSearchEmpty);
				  for(Employee empBasicDetails:employeeBasicSearch) {
					  boolean flag=false;
					  Employee response=new Employee();
					 
					  String querySkillSearch=null;
					  if(empSearch.getSkills()==null) {
						  querySkillSearch=empSkillSearchBuildQueryByEmpty(empBasicDetails.getEmployeeId());
					  }else if(empSearch.getSkills().size() > 0 || empSearch.getSkills()!=null) {
						  querySkillSearch=empSkillSearchBuildQuery(empSearch.getSkills(),empBasicDetails.getEmployeeId());
					  }
					  List<UserSkills> skillList=employeeRepository.empSkills(querySkillSearch);
					  
					  if(empSearch.getRating()!=null && !empSearch.getRating().isEmpty()) {
						  String ratingQuery=empRatingBuildQuery(empBasicDetails.getEmployeeId());
						  String rating=employeeRepository.getAvgRatingForEmp(ratingQuery);
						//  String rating="80";
							if (rating!=null && Double.parseDouble(empSearch.getRating()) <= Double.parseDouble(rating)) {
								response.setAvgRating(rating);
							}else {
								break;
							}
					  }else{
						  String ratingQuery=empRatingBuildQuery(empBasicDetails.getEmployeeId()); 
						  String rating=employeeRepository.getAvgRatingForEmp(ratingQuery);
						  response.setAvgRating(rating);
					  }
					  String utilizationQuery=null;
					  if(empSearch.getStartDate()!=null && empSearch.getEndDate()!=null && empSearch.getUtilization()!=null) {
						  utilizationQuery=empUtilizationBuildQuery(empBasicDetails.getEmployeeId(),empSearch.getStartDate(),
								  empSearch.getEndDate(),empSearch.getUtilization());
						  flag=true;
						  
					  }else if(empSearch.getStartDate()!=null && empSearch.getEndDate()!=null && !flag){
						  utilizationQuery=empUtilizationBuildQueryWithDates(empBasicDetails.getEmployeeId(),empSearch.getStartDate(),
								  empSearch.getEndDate());
						  flag=true;
					  }else if(empSearch.getUtilization()!=null && !flag) {
						  utilizationQuery=empUtilizationBuildQueryWithUTL(empBasicDetails.getEmployeeId(),empSearch.getUtilization());
						  flag=true;
					  }else {
						  utilizationQuery=empUtilizationBuildQueryWithEmp(empBasicDetails.getEmployeeId());
						  flag=true;
					  }
					  List<Utilization> utilizationRes=null;
					  if(flag) {
						  utilizationRes=employeeRepository.avgratingWithDate(utilizationQuery); 
					  }
					  
					  response.setUtilization(utilizationRes);
					  response=dataMapping(response,empBasicDetails);
					 // response.setEmployee(empBasicDetails);
					  response.setUserSkills(skillList);
					  resObj.add(response); 
				  }
			}
		}catch(Exception e) {
			
		}
		
		// TODO Auto-generated method stub
		return resObj;
	}
	
	private Employee dataMapping(Employee response,Employee basicDetails) {
		response.setAddress1(basicDetails.getAddress1());
		response.setAddress2(basicDetails.getAddress2());
		response.setAddressType(basicDetails.getAddressType());
		response.setCity(basicDetails.getCity());
		response.setCommissionPCT(basicDetails.getCommissionPCT());
		response.setContactNumber1(basicDetails.getContactNumber1());
		response.setContactNumber2(basicDetails.getContactNumber2());
		response.setCostTOCompany(basicDetails.getCostTOCompany());
		response.setCountry(basicDetails.getCountry());
		response.setCtcCurrency(basicDetails.getCtcCurrency());
		response.setDepartment(basicDetails.getDepartment());
		response.setDepartmentId(basicDetails.getDepartmentId());
		response.setEmailId(basicDetails.getEmailId());
		response.setEmployeeId(basicDetails.getEmployeeId());
		response.setEmployeeStatus(basicDetails.getEmployeeStatus());
		response.setEmployeeStatusValue(basicDetails.getEmployeeStatusValue());
		response.setEmploymentType(basicDetails.getEmploymentType());
		response.setFirstName(basicDetails.getFirstName());
		response.setHireDate(basicDetails.getHireDate());
		response.setLastName(basicDetails.getLastName());
		response.setLastWorkingDate(basicDetails.getLastWorkingDate());
		response.setManagerEmail(basicDetails.getManagerEmail());
		response.setManagerId(basicDetails.getManagerId());
		response.setMiddleName(basicDetails.getMiddleName());
		response.setPosition(basicDetails.getPosition());
		response.setPositionLevel(basicDetails.getPositionLevel());
		response.setPositionName(basicDetails.getPositionName());
		response.setRcdId(basicDetails.getRcdId());
		response.setState(basicDetails.getState());
		response.setZipcode(basicDetails.getZipcode());
		return response;
		
		
	}
	
	private String getQuesryForBasicEmpty() {
		String basicSearch = "SELECT EMP_DETAIL.RCD_ID,EMP_DETAIL.EMPLOYEE_ID,EMP_DETAIL.FIRST_NAME,EMP_DETAIL.MIDDLE_NAME,"
				+ "EMP_DETAIL.LAST_NAME,EMP_DETAIL.EMAIL,EMP_DETAIL.ADDRESS_LINE_1,EMP_DETAIL.ADDRESS_LINE_2,"
				+ "EMP_DETAIL.ZIP_CODE,EMP_DETAIL.CITY,EMP_DETAIL.STATE,EMP_DETAIL.COUNTRY,EMP_DETAIL.ADDRESS_TYPE,"
				+ "EMP_DETAIL.CONTACT_NUMBER_1,EMP_DETAIL.CONTACT_NUMBER_2,EMP_DETAIL.HIRE_DATE,EMP_DETAIL.POSITION,"
				+ "MSTR_POSITION.POSITION_NAME,EMP_DETAIL.POSITION_LEVEL,EMP_DETAIL.COST_TO_COMPANY,EMP_DETAIL.CTC_CURRENCY,"
				+ "EMP_DETAIL.COMMISSION_PCT,EMP_DETAIL.MANAGER_ID,emp.EMAIL AS MANAGEREMAIL,EMP_DETAIL.DEPARTMENT,"
				+ "EMP_DETAIL.DEPARTMENT_ID,EMP_DETAIL.EMPLOYMENT_STATUS,MSTR_STATUS.STATUS_VALUE,EMP_DETAIL.EMPLOYMENT_TYPE "
				+ "FROM EMP_DETAIL JOIN MSTR_POSITION ON EMP_DETAIL.POSITION=MSTR_POSITION.POSITION_ID LEFT JOIN MSTR_STATUS ON "
				+ "EMP_DETAIL.EMPLOYMENT_STATUS=MSTR_STATUS.STATUS_ID LEFT JOIN EMP_DETAIL emp ON "
				+ "EMP_DETAIL.MANAGER_ID=emp.EMPLOYEE_ID";
		return basicSearch;
	}
	
	private String empSkillSearchBuildQueyBySkills(List<String> skills){
		String skillSearch = "SELECT EMP_SKILL.EMPLOYEE_ID,GROUP_CONCAT(EMP_SKILL.SKILL_NAME) AS 'SKILLS' FROM EMP_SKILL WHERE "
				+ "(EMP_SKILL.SKILL_NAME='";
		if (skills.size() > 0) {

			for (int i = 0; i < skills.size(); i++) {
				skillSearch = skillSearch + skills.get(i);
				if (i < skills.size() - 1) {
					skillSearch = skillSearch + "' OR EMP_SKILL.SKILL_NAME='";
				}
				if (i == skills.size() - 1) {
					skillSearch = skillSearch + "') group by EMP_SKILL.EMPLOYEE_ID";
				}

			}

		}
		return skillSearch;
		
	}
	private String empUtilizationBuildQuery(String employeeId,String startDate,
			  String endDate,String utilization) {
		
		String utilizationQuery="SELECT utilization.MONTH,utilization.UTILIZATION FROM utilization "
				+ "JOIN utilization utl ON utilization.ID=utl.ID "
				+ "WHERE utilization.EMPLOYEE_ID='"+employeeId+"' AND utilization.MONTH >='"+startDate.substring(0,7)+
				"' AND utl.MONTH <='"+endDate+"' AND utilization.UTILIZATION <= '"+utilization+"'";
				return utilizationQuery;
		
	}
	private String empUtilizationBuildQueryWithEmp(String employeeId) {
		String utilizationQuery="SELECT utilization.MONTH,utilization.UTILIZATION FROM utilization "
				+ "JOIN utilization utl ON utilization.ID=utl.ID "
				+ "WHERE utilization.EMPLOYEE_ID='"+employeeId+"'";
				return utilizationQuery;
	}
	private String empUtilizationBuildQueryWithDates(String employeeId,String startDate,
			  String endDate) {
		String utilizationQuery="SELECT utilization.MONTH,utilization.UTILIZATION FROM utilization "
				+ "JOIN utilization utl ON utilization.ID=utl.ID "
				+ "WHERE utilization.EMPLOYEE_ID='"+employeeId+"' AND utilization.MONTH >='"+startDate.substring(0,7)+
				"' AND utl.MONTH <='"+endDate+"'";
				return utilizationQuery;
	}
	private String empUtilizationBuildQueryWithUTL(String employeeId,String utilization) {
		String utilizationQuery="SELECT utilization.MONTH,utilization.UTILIZATION FROM utilization "
				+ "JOIN utilization utl ON utilization.ID=utl.ID "
				+ "WHERE utilization.EMPLOYEE_ID='"+employeeId+"' AND utilization.UTILIZATION <= '"+utilization+"'";
				return utilizationQuery;
		
	}
	
	private String empRatingBuildQuery(String employeeId) {
		String ratingQuery="SELECT AVG(ASSESSMENT.ASSMT_SUMMARY) FROM ASSESSMENT JOIN "
				+ "EMP_ASSMT ON ASSESSMENT.ASSMT_ID=EMP_ASSMT.ASSMT_ID LEFT JOIN ASSMT_DETAIL "
				+ "ON ASSESSMENT.ASSMT_ID=ASSMT_DETAIL.ASSMT_ID WHERE EMP_ASSMT.EMPLOYEE_ID='"+employeeId+"' AND "
						+ "ASSMT_DETAIL.ASSNT_STATUS_ID='8'";
		return ratingQuery;
	}
	
	private String empSearchBuildQuery(EmpSearch empSearch) {

		String basicSearch = "SELECT EMP_DETAIL.RCD_ID,EMP_DETAIL.EMPLOYEE_ID,EMP_DETAIL.FIRST_NAME,EMP_DETAIL.MIDDLE_NAME,"
				+ "EMP_DETAIL.LAST_NAME,EMP_DETAIL.EMAIL,EMP_DETAIL.ADDRESS_LINE_1,EMP_DETAIL.ADDRESS_LINE_2,"
				+ "EMP_DETAIL.ZIP_CODE,EMP_DETAIL.CITY,EMP_DETAIL.STATE,EMP_DETAIL.COUNTRY,EMP_DETAIL.ADDRESS_TYPE,"
				+ "EMP_DETAIL.CONTACT_NUMBER_1,EMP_DETAIL.CONTACT_NUMBER_2,EMP_DETAIL.HIRE_DATE,EMP_DETAIL.POSITION,"
				+ "MSTR_POSITION.POSITION_NAME,EMP_DETAIL.POSITION_LEVEL,EMP_DETAIL.COST_TO_COMPANY,EMP_DETAIL.CTC_CURRENCY,"
				+ "EMP_DETAIL.COMMISSION_PCT,EMP_DETAIL.MANAGER_ID,emp.EMAIL AS MANAGEREMAIL,EMP_DETAIL.DEPARTMENT,"
				+ "EMP_DETAIL.DEPARTMENT_ID,EMP_DETAIL.EMPLOYMENT_STATUS,MSTR_STATUS.STATUS_VALUE,EMP_DETAIL.EMPLOYMENT_TYPE "
				+ "FROM EMP_DETAIL JOIN MSTR_POSITION ON EMP_DETAIL.POSITION=MSTR_POSITION.POSITION_ID LEFT JOIN MSTR_STATUS ON "
				+ "EMP_DETAIL.EMPLOYMENT_STATUS=MSTR_STATUS.STATUS_ID LEFT JOIN EMP_DETAIL emp ON "
				+ "EMP_DETAIL.MANAGER_ID=emp.EMPLOYEE_ID WHERE ";
		
		String emptyReturnFlag="";

		boolean basicSearchFlag = false;
		boolean skillSearchFlag = false;
		if (empSearch.getEmployeeName() != null) {
			basicSearch = basicSearch + "(EMP_DETAIL.FIRST_NAME LIKE '%" + empSearch.getEmployeeName().trim()
					+ "%' OR EMP_DETAIL.MIDDLE_NAME LIKE '%" + empSearch.getEmployeeName().trim()
					+ "%' OR EMP_DETAIL.LAST_NAME LIKE '%" + empSearch.getEmployeeName().trim() + "%')";
			basicSearchFlag = true;
		}
		/*
		 * if (empSearch.getEmployeeId() != null && basicSearchFlag) { basicSearch =
		 * basicSearch + " AND EMP_DETAIL.EMPLOYEE_ID LIKE'%" +
		 * empSearch.getEmployeeId().trim() + "%'"; basicSearchFlag = true; } else if
		 * (empSearch.getEmployeeId() != null && !basicSearchFlag) { basicSearch =
		 * basicSearch + "EMP_DETAIL.EMPLOYEE_ID LIKE'%" +
		 * empSearch.getEmployeeId().trim() + "%'"; basicSearchFlag = true; }
		 */
		if (empSearch.getEmailId() != null && basicSearchFlag) {
			basicSearch = basicSearch + " AND EMP_DETAIL.EMAIL LIKE '%" + empSearch.getEmailId().trim() + "%'";
			basicSearchFlag = true;
		} else if (empSearch.getEmailId() != null && !basicSearchFlag) {
			basicSearch = basicSearch + "EMP_DETAIL.EMAIL LIKE '%" + empSearch.getEmailId().trim() + "%'";
			basicSearchFlag = true;
		}
		if (empSearch.getPosition() != null && basicSearchFlag) {
			basicSearch = basicSearch + " AND EMP_DETAIL.POSITION='" + empSearch.getPosition().trim() + "'";
			basicSearchFlag = true;
		} else if (empSearch.getPosition() != null && basicSearchFlag) {
			basicSearch = basicSearch + "EMP_DETAIL.POSITION='" + empSearch.getPosition().trim() + "'";
			basicSearchFlag = true;
		}
		
		
		if(basicSearchFlag) {
			return basicSearch;
		}else {
			return emptyReturnFlag;
		}
		
		

	}
	
	private String empSkillSearchBuildQuery(List<String> skills, String employeeId) {
		String skillSearch = "SELECT EMP_SKILL.SKILL_NAME,"
				+ "EMP_SKILL.SKILL_EXPERIENCE,EMP_SKILL.CERTIFIED,EMP_SKILL.SKILL_LEVEL FROM EMP_SKILL WHERE (EMP_SKILL.SKILL_NAME='";
		if (skills.size() > 0) {

			for (int i = 0; i < skills.size(); i++) {
				skillSearch = skillSearch + skills.get(i);
				if (i < skills.size() - 1) {
					skillSearch = skillSearch + "' OR EMP_SKILL.SKILL_NAME='";
				}
				if (i == skills.size() - 1) {
					skillSearch = skillSearch + "') AND EMPLOYEE_ID='"+employeeId+"'";
				}

			}

		}
		return skillSearch;

	}
	private String empSkillSearchBuildQueryByEmpty(String employeeId) {
		String skillSearchQuery = "SELECT EMP_SKILL.SKILL_NAME,"
				+ "EMP_SKILL.SKILL_EXPERIENCE,EMP_SKILL.CERTIFIED,EMP_SKILL.SKILL_LEVEL FROM EMP_SKILL WHERE EMPLOYEE_ID='"+employeeId+"'";
				return skillSearchQuery;

	}

	@Override
	public HomeObj myHomeDetails(String empId) {
		// TODO Auto-generated method stub
		HomeObj home=new HomeObj();
		Task tasks=new Task();
		tasks.setPendingAssessmentsCount(String.valueOf(employeeRepository.getPendingAssessments(empId)));
		tasks.setPendingGoalsCount(String.valueOf(employeeRepository.getPendingGoals(empId)));
		tasks.setPendingTrainingsCount(String.valueOf(employeeRepository.getPendingTrainings(empId)));
		home.setTasks(tasks);
		List<Reportee> list=employeeRepository.getReporteeList(empId);
		for(Reportee reportee:list) {
			//reportee.setUtilization(String.valueOf());
			String utl=employeeRepository.getEmpUtilization(reportee.getEmpId());
			System.out.println("utl:"+utl);
			if(utl==null) {
				utl="0";
			
			}
			reportee.setUtilization(String.valueOf(utl));
		}
		home.setReporteeDetails(list);
		System.out.println("home"+home);
		//System.out.println(String.valueOf(employeeRepository.getEmpUtilization(empId)));
		home.setUtilization(employeeRepository.getEmpUtilization(empId));
		System.out.println("home2"+home);
		
		return home;
	}

	@Override
	public Task myTasks(String loggedInUser) {
		Task tasks=new Task();
		tasks.setPendingAssessmentsCount(String.valueOf(employeeRepository.getPendingAssessments(loggedInUser)));
		tasks.setPendingGoalsCount(String.valueOf(employeeRepository.getPendingGoals(loggedInUser)));
		tasks.setPendingTrainingsCount(String.valueOf(employeeRepository.getPendingTrainings(loggedInUser)));
		String utl=employeeRepository.getEmpUtilization(loggedInUser);
		System.out.println("utl:"+utl);
		if(utl==null) {
			utl="0";
		
		}
		tasks.setUtilization(String.valueOf(utl));
		List<Rating> avgRating=getAvgRating(loggedInUser);
		tasks.setRating(avgRating);
		
		return tasks;
	}

	@Override
	public List<Reportee> myReportees(String loggedInUser) {
		List<Reportee> list=employeeRepository.getReporteeList(loggedInUser);
		for(Reportee reportee:list) {
			//reportee.setUtilization(String.valueOf());
			String utl=employeeRepository.getEmpUtilization(reportee.getEmpId());
			System.out.println("utl:"+utl);
			if(utl==null) {
				utl="0";
			
			}
			reportee.setUtilization(String.valueOf(utl));
			List<Rating> avgRating=getAvgRating(loggedInUser);
			reportee.setRating(avgRating);
		}
		return list;
	}
	
	public List<Rating> getAvgRating(String loggedInUser) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		List<Rating> ratingList=new ArrayList<Rating>();
		
		for (int i = 0; i < 3; i++) {
			Rating rating=new Rating();
			String startDate = "";
			String endDate = "";
			if (i >= 1) {
				year = year - 1;
			}
			startDate = startDate + year + "-01-01";
			endDate = endDate + year + "-12-31";
			String avgRating = employeeRepository.getAvgRating(loggedInUser, startDate.trim(), endDate.trim());
			if(avgRating!=null) {
				rating.setYear(year+"");
				rating.setAvgRating(avgRating);
			}
			ratingList.add(rating);
			System.out.println("startDate ::" + startDate + " :: " + "endDate ::" + endDate);
		}

		return ratingList;
	}
	
	@Override
	public List<Notification> myNotifications(String loggedInUser) {
		//String looggedInUserRole=employeeRepository.getLoggedInUserRole();
		List<Notification> finalList=new ArrayList<Notification>();
		List<Notification> notificationList = employeeRepository.myNotifications(loggedInUser);
		Set<Long> anncIds=new HashSet<Long>();
		for(Notification notification :notificationList) {
			anncIds.add(notification.getAnncId());
		}
		//System.out.println("anncIds ::"+anncIds);
		for(Long anncId:anncIds) {
		for(int i=0;i<=notificationList.size();i++) {
				if(notificationList.get(i).getAnncId()==anncId) {
					finalList.add(notificationList.get(i));
					notificationList.remove(i);
					break;
				}
				
			}
		}
		//System.out.println("finalList::"+finalList);
		return finalList;
	}
	
	@Override
	@Transactional
	public int createEmployeeAccessRole(EmpAccessRole empAccessRole) {
		System.out.println("Ser");
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		int deleteFlag=employeeRepository.deleteExistingRoles(empAccessRole.getEmpId());
		System.out.println("Ser +deleteFlag ::"+deleteFlag);
		int addedFlag=0;
		//if(deleteFlag >0) {
			addedFlag=employeeRepository.createEmployeeAccessRole(empAccessRole,sysDate);
			System.out.println("Ser +addedFlag ::"+addedFlag);
		//}
		//int createEmployeeAccessRole(EmpAccessRole empAccessRole,String sysDate);
		return addedFlag;
	}

	@Override
	public EmpAccessRole getEmployeeAccessRoles(String empId) {
		EmpAccessRole responseObj=new EmpAccessRole();
		responseObj.setEmpId(empId);
		List<UserRoles> empRoles=employeeRepository.getEmployeeAccessRoles(empId);
		//System.out.println("empRoles ::"+empRoles);
		responseObj.setEmpRoles(empRoles);
		// TODO Auto-generated method stub
		return responseObj;
	}

	//@Override
	private int bulkUsersToDB(List<Employee> processedUsers) {
		// List<Employee> employeesList=processedUsers.get("Process");
		int dbUpdate = 0;
		int deleteFlag =0;
		int responseFlag=0;
		for (Employee employeeToProcess : processedUsers) {
			dbUpdate=employeeRepository.createUser(employeeToProcess);
			//dbUpdate = employeeRepository.saveToDB(employeeToProcess);
			if (dbUpdate > 0) {
				boolean createdFlag = wSO2UserWebService.createUser(
						employeeToProcess.getEmailId(),
						employeeToProcess.getEmailId());
				if (!createdFlag) {
					deleteFlag = employeeRepository.delete(employeeToProcess.getEmployeeId());
				}else {
					responseFlag=responseFlag+1;
				}
				if(deleteFlag > 0) {}
				
			}
		}
		return responseFlag;
	}

	@Override
	public int createAccessRoles(String empId) {
		// TODO Auto-generated method stub
		Helper helper = new Helper();
		String sysDate = helper.getSystemDate();
		//int flag=employeeRepository.createAccessRoleToAnUser(empId,sysDate);
		return 0;
	}
	
	//@Override
	private void createReport(List<Employee> processedUsers,List<EmployeeValidation> managerKeyValidationFaild) {
		Validation validation = new Validation();
		try {
			validation.writingTOReport(processedUsers,managerKeyValidationFaild);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return 0;
	}

	@Override
	public int createUser(Employee employee) {
		int var = employeeRepository.createUser(employee);
		if (var > 0) {
			boolean flag1 = wSO2UserWebService
					.createUser(employee.getEmailId(), employee.getEmailId());
			
			//System.out.println("flag ::"+flag1);employeeRepository.createUser(employee);
			 if (!flag1) {
				int deleteFlag = employeeRepository.delete(employee.getEmployeeId());
				var=0;
				//return ;
			}else if(flag1) {
				int flag=employeeRepository.createAccessRoleToAnUser(employee.getEmployeeId());
				if(employee.getRcdId() >0) {
					employeeRepository.delete(employee.getRcdId());
				}
				return var;
			}
			
		}
		return var;
	}

	@Override
	//@Transactional
	public int processFromStaging() {
		int flag=0;
		Validation validation = new Validation();
		List<Employee> dataFromStaging = employeeRepository.findAll();
		System.out.println("dataFromStaging ::" + dataFromStaging);
		if (dataFromStaging.size() > 0) {
			HashMap<String, List<Employee>> processedUsers = validation.employeeValidation(dataFromStaging);
			System.err.println("Process::" + processedUsers);
			if (processedUsers.size() > 0) {
				//List<Employee> managerKeyValidationFaild=new ArrayList<Employee>();
				List<EmployeeValidation> managerKeyValidationFaild = new ArrayList<>();
				//int dbUpdate = bulkUsersToDB(processedUsers.get("Process"));
				for (Employee employeeToProcess : processedUsers.get("Process")) {
					int dbUpdate = 0;
					int deleteFlag =0;
					int responseFlag=0;
					long validationFlag=0;
					String managerId=null;
					if(employeeToProcess.getManagerId()!=null && employeeToProcess.getManagerEmail()!=null) {
						validationFlag=empRepo.userManagerValidationByIdAndEmail(employeeToProcess.getManagerId(),employeeToProcess.getManagerEmail());
					}else if(employeeToProcess.getManagerId()!=null && employeeToProcess.getManagerEmail()==null) {
						validationFlag=empRepo.userManagerValidationById(employeeToProcess.getManagerId());
					}else if(employeeToProcess.getManagerId()==null && employeeToProcess.getManagerEmail()!=null) {
						validationFlag=empRepo.userManagerValidationByEmail(employeeToProcess.getManagerEmail());
					}
					if (validationFlag > 0) {
						if (employeeToProcess.getManagerId() == null && employeeToProcess.getManagerEmail() != null) {
							managerId=empRepo.getManagerIdByEmail(employeeToProcess.getManagerEmail());
							employeeToProcess.setManagerId(managerId);
						}
						long count=empRepo.positionAvailability(employeeToProcess.getPosition());
						//String positionId=;
						System.out.println("count "+count);
						if(count==0){
							int flag2=empRepo.createRoleFromBulkLoad(employeeToProcess.getPosition());
							if(flag2 > 0) {
								String positionId2=empRepo.getPositionIdByName(employeeToProcess.getPosition());
								employeeToProcess.setPosition(positionId2);
							}
						}else if(count>0) {
							employeeToProcess.setPosition(empRepo.getPositionIdByName(employeeToProcess.getPosition()));
						}
						//dbUpdate=employeeRepository.createUser(employeeToProcess);
						dbUpdate = empRepo.saveToDB(employeeToProcess);
						if (dbUpdate > 0) {
							boolean createdFlag = wSO2UserWebService.createUser(
									employeeToProcess.getEmailId(),
									employeeToProcess.getEmailId());
							if (!createdFlag) {
								deleteFlag = empRepo.delete(employeeToProcess.getEmployeeId());
							}else {
								int flagUpdate=employeeRepository.createAccessRoleToAnUser(employeeToProcess.getEmployeeId());
								responseFlag=responseFlag+1;
							}
							if(deleteFlag > 0) {}
							
						}
					} else if (validationFlag == 0) {
						EmployeeValidation validationObj = new EmployeeValidation();
						//managerKeyValidationFaild.add(employeeToProcess);
						validationObj.setEmployeeDetails(employeeToProcess);
						validationObj.setNumberOfValidationsFailed(1);
						validationObj.setValidationComments("Provided Manager Id or Manager Email does not exist in the system");
						managerKeyValidationFaild.add(validationObj);
					}
					
					
				}
				int dbUpdate2 = empRepo.save(processedUsers.get("Failed"));
				if(processedUsers.get("Failed").size()>0 || managerKeyValidationFaild.size()>0) {
				createReport(processedUsers.get("Failed"),managerKeyValidationFaild);
				}
				int delete = empRepo.delete();
				flag=1;
			}
		
	}
		return flag;
	}
}
