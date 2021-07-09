package com.gss.pulseworkflow.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.gss.pulseworkflow.model.EmpSearch;
import com.gss.pulseworkflow.model.Project;

public class QueryObj {

	public String buildDynamicQueryForProjSearch(Project project) {
		String query = "SELECT RCD_ID,PROJECT_ID,PROJECT_NAME,PROJECT_START_DATE,PROJECT_END_DATE,PROJECT_CUSTOMER,PROJECT_DESCRIPTION,PROJECT_STATUS_ID,CREATOR_ID FROM PROJECTS WHERE ";
		try {
			//String query2 = "";
			//boolean goalFlag = false;
			boolean dateFlag = false;
			boolean flag = false;
			HashMap<String, Boolean> projectIdStatus = goalIdWithProId(project.getProjectIds(), project.getProjectId());
			if (projectIdStatus != null && !projectIdStatus.isEmpty() && project.getProjectIds().size() > 0
					&& project.getProjectId() != null) {
				for (Entry<String, Boolean> projectIdObj : projectIdStatus.entrySet()) {
					if (project.getProjectId() != null) {
						query = query + "PROJECT_ID like '%" + projectIdObj.getKey().trim() + "%'";
						flag = true;
					}
				}
				if (project.getProjectName() != null && flag) {
					query = query + " AND PROJECT_NAME like '%" + project.getProjectName().trim() + "%'";
					flag = true;
				} else if (project.getProjectName() != null && !flag) {
					query = query + "PROJECT_NAME like '%" + project.getProjectName().trim() + "%'";
					flag = true;
				}
				if (project.getCustomer() != null && flag) {
					query = query + " AND PROJECT_CUSTOMER like '%" + project.getCustomer().trim() + "%'";
					flag = true;
				} else if (project.getCustomer() != null && !flag) {
					query = query + "PROJECT_CUSTOMER like '%" + project.getCustomer().trim() + "%'";
					flag = true;
				}
				if (flag) {
					if (project.getStartDate() != null) {
						query = query + " AND PROJECT_START_DATE >= '" + project.getStartDate().trim() + "'";
						flag = true;
					}
					if (project.getEndDate() != null) {
						query = query + " AND PROJECT_END_DATE <= '" + project.getEndDate().trim() + "'";
						flag = true;
					}
				} else {
					if (project.getStartDate() != null && project.getEndDate() != null) {
						query = query + "PROJECT_START_DATE >= '" + project.getStartDate().trim()
								+ "' AND PROJECT_END_DATE <= '" + project.getEndDate().trim() + "'";
						dateFlag = true;
					}
					if (project.getStartDate() != null && !dateFlag) {
						query = query + "PROJECT_START_DATE >= '" + project.getStartDate().trim() + "'";
					}
					if (project.getEndDate() != null && !dateFlag) {
						query = query + "PROJECT_END_DATE <= '" + project.getEndDate().trim() + "'";
					}
				}
			} else if (projectIdStatus.isEmpty() && project.getProjectIds() != null && project.getProjectId() != null) {
				query = "";
				System.out.println("Else id::" + query);

			} else if (project.getProjectIds() != null
					&& (project.getProjectId() == null || project.getProjectId().isEmpty())) {
				for (int i = 0; i < project.getProjectIds().size(); i++) {
					if (i == 0) {
						query = query + "(";
					}
					query = query + "PROJECT_ID='" + project.getProjectIds().get(i).trim() + "'";
					if (i < project.getProjectIds().size() - 1) {
						query = query + " OR ";
					}
					if (i == project.getProjectIds().size() - 1) {
						query = query + ")";
						flag = true;
					}
				}

				if (project.getProjectName() != null && flag) {
					query = query + " AND PROJECT_NAME like '%" + project.getProjectName().trim() + "%'";
					flag = true;
				} else if (project.getProjectName() != null && !flag) {
					query = query + "PROJECT_NAME like '%" + project.getProjectName().trim() + "%'";
					flag = true;
				}
				if (project.getCustomer() != null && flag) {
					query = query + " AND PROJECT_CUSTOMER like '%" + project.getCustomer().trim() + "%'";
					flag = true;
				} else if (project.getCustomer() != null && !flag) {
					query = query + "PROJECT_CUSTOMER like '%" + project.getCustomer().trim() + "%'";
					flag = true;
				}
				if (flag) {
					if (project.getStartDate() != null) {
						query = query + " AND PROJECT_START_DATE >= '" + project.getStartDate().trim() + "'";
						flag = true;
					}
					if (project.getEndDate() != null) {
						query = query + " AND PROJECT_END_DATE <= '" + project.getEndDate().trim() + "'";
						flag = true;
					}
				} else {
					if (project.getStartDate() != null && project.getEndDate() != null) {
						query = query + "PROJECT_START_DATE >= '" + project.getStartDate().trim()
								+ "' AND PROJECT_END_DATE <= '" + project.getEndDate().trim() + "'";
						dateFlag = true;
					}
					if (project.getStartDate() != null && !dateFlag) {
						query = query + "PROJECT_START_DATE >= '" + project.getStartDate().trim() + "'";
					}
					if (project.getEndDate() != null && !dateFlag) {
						query = query + "PROJECT_END_DATE <= '" + project.getEndDate().trim() + "'";
					}
				}
			} else {
				System.out.println("Else if::zero");
				if (project.getProjectId() != null) {
					query = query + "PROJECT_ID like '%" + project.getProjectId().trim() + "%'";
					flag = true;
				}
				if (project.getProjectName() != null && flag) {
					query = query + " AND PROJECT_NAME like '%" + project.getProjectName().trim() + "%'";
					flag = true;
				} else if (project.getProjectName() != null && !flag) {
					query = query + "PROJECT_NAME like '%" + project.getProjectName().trim() + "%'";
					flag = true;
				}
				if (project.getCustomer() != null && flag) {
					query = query + " AND PROJECT_CUSTOMER like '%" + project.getCustomer().trim() + "%'";
					flag = true;
				} else if (project.getCustomer() != null && !flag) {
					query = query + "PROJECT_CUSTOMER like '%" + project.getCustomer().trim() + "%'";
					flag = true;
				}
				if (flag) {
					if (project.getStartDate() != null) {
						query = query + " AND PROJECT_START_DATE >= '" + project.getStartDate().trim() + "'";
						flag = true;
					}
					if (project.getEndDate() != null) {
						query = query + " AND PROJECT_END_DATE <= '" + project.getEndDate().trim() + "'";
						flag = true;
					}
				} else {
					if (project.getStartDate() != null && project.getEndDate() != null) {
						query = query + "PROJECT_START_DATE >= '" + project.getStartDate().trim()
								+ "' AND PROJECT_END_DATE <= '" + project.getEndDate().trim() + "'";
						dateFlag = true;
					}
					if (project.getStartDate() != null && !dateFlag) {
						query = query + "PROJECT_START_DATE >= '" + project.getStartDate().trim() + "'";
					}
					if (project.getEndDate() != null && !dateFlag) {
						query = query + "PROJECT_END_DATE <= '" + project.getEndDate().trim() + "'";
					}
				}
			}
		} catch (Exception e) {

		}
		return query;

	}

	public String empSearchBuildQuery(EmpSearch empSearch) {

		String basicSearch = "SELECT EMP_DETAIL.RCD_ID,EMP_DETAIL.EMPLOYEE_ID,EMP_DETAIL.FIRST_NAME,EMP_DETAIL.MIDDLE_NAME,"
				+ "EMP_DETAIL.LAST_NAME,EMP_DETAIL.EMAIL,EMP_DETAIL.ADDRESS_LINE_1,EMP_DETAIL.ADDRESS_LINE_2,"
				+ "EMP_DETAIL.ZIP_CODE,EMP_DETAIL.CITY,EMP_DETAIL.STATE,EMP_DETAIL.COUNTRY,EMP_DETAIL.ADDRESS_TYPE,"
				+ "EMP_DETAIL.CONTACT_NUMBER_1,EMP_DETAIL.CONTACT_NUMBER_2,EMP_DETAIL.HIRE_DATE,EMP_DETAIL.POSITION,"
				+ "MSTR_POSITION.POSITION_NAME,EMP_DETAIL.POSITION_LEVEL,EMP_DETAIL.COST_TO_COMPANY,EMP_DETAIL.CTC_CURRENCY,"
				+ "EMP_DETAIL.COMMISSION_PCT,EMP_DETAIL.MANAGER_ID,emp.EMAIL AS MANAGEREMAIL,EMP_DETAIL.DEPARTMENT,"
				+ "EMP_DETAIL.DEPARTMENT_ID,EMP_DETAIL.EMPLOYMENT_STATUS,MSTR_STATUS.STATUS_VALUE,EMP_DETAIL.EMPLOYMENT_TYPE "
				+ "FROM EMP_DETAIL JOIN MSTR_POSITION ON EMP_DETAIL.POSITION=MSTR_POSITION.POSITION_ID LEFT JOIN MSTR_STATUS ON "
				+ "EMP_DETAIL.EMPLOYMENT_STATUS=MSTR_STATUS.STATUS_ID LEFT JOIN EMP_DETAIL emp ON "
				+ "EMP_DETAIL.MANAGER_ID=emp.EMPLOYEE_ID LEFT JOIN EMP_SKILL ON EMP_SKILL.EMPLOYEE_ID=EMP_DETAIL.EMPLOYEE_ID WHERE ";
		String skillSearch="SELECT EMPLOYEE_ID,GROUP_CONCAT(SKILL_NAME) AS 'SKILLS' FROM EMP_SKILL WHERE (EMP_SKILL.SKILL_NAME=";
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
		/*
		 * if (empSearch.getManagerName() != null && basicSearchFlag) { basicSearch =
		 * basicSearch + " AND (emp.FIRST_NAME LIKE '%" +
		 * empSearch.getManagerName().trim() + "%' OR emp.MIDDLE_NAME LIKE '%" +
		 * empSearch.getManagerName().trim() + "%' OR emp.LAST_NAME LIKE '%" +
		 * empSearch.getManagerName().trim() + "%'"; basicSearchFlag = true; } else if
		 * (empSearch.getManagerName() != null && !basicSearchFlag) { basicSearch =
		 * basicSearch + "(emp.FIRST_NAME LIKE '%" + empSearch.getManagerName().trim() +
		 * "%' OR emp.MIDDLE_NAME LIKE '%" + empSearch.getManagerName().trim() +
		 * "%' OR emp.LAST_NAME LIKE '%" + empSearch.getManagerName().trim() + "%')";
		 * basicSearchFlag = true; } if (empSearch.getManagerEmail() != null &&
		 * basicSearchFlag) { basicSearch = basicSearch + " AND emp.EMAIL LIKE '%" +
		 * empSearch.getManagerEmail().trim() + "%'"; basicSearchFlag = true; } else if
		 * (empSearch.getManagerEmail() != null && basicSearchFlag) { basicSearch =
		 * basicSearch + "emp.EMAIL LIKE '%" + empSearch.getManagerEmail().trim() +
		 * "%'"; basicSearchFlag = true; }
		 */
		
		if(empSearch.getSkills().size()>0) {
			
			for(int i=0;i<empSearch.getSkills().size();i++) {
				skillSearch=skillSearch+empSearch.getSkills().get(i);
				if(i<empSearch.getSkills().size()-1) {
					skillSearch=skillSearch+" OR EMP_SKILL.SKILL_NAME=";
				}
				if(i==empSearch.getSkills().size()-1) {
					skillSearch=skillSearch+") group by EMPLOYEE_ID";
				}
				
			}
			
		}
		if(basicSearchFlag) {
			return basicSearch;
		}
		return emptyReturnFlag;

	}
	
	public static void main(String args[]) {
		String skillSearch="SELECT EMPLOYEE_ID,GROUP_CONCAT(SKILL_NAME) AS 'SKILLS' FROM EMP_SKILL WHERE (EMP_SKILL.SKILL_NAME='";
		List<String> skills=new ArrayList<String>();
		
		skills.add("Node JS");
		//skills.add("React JS");
		for(int i=0;i<skills.size();i++) {
			skillSearch=skillSearch+skills.get(i)+"'";
			if(i<skills.size()-1) {
				skillSearch=skillSearch+" OR EMP_SKILL.SKILL_NAME='";
			}
			if(i==skills.size()-1) {
				skillSearch=skillSearch+") group by EMPLOYEE_ID";
			}
			
		}
		System.out.println("skillSearch ::"+skillSearch);
	}
	/*
	 * public static void main(String args[]) { Project project=new Project();
	 * project.setProjectId("test"); //project.setProjectName("pro");
	 * //project.setStartDate("2020-10-27"); //project.setEndDate("");
	 * //project.setCustomer(""); //String // // String
	 * quesy=buildDynamicQueryForProjSearch(project); //System.err.println(quesy);
	 * // String rest="Arjun not"; System.out.println(quesy);
	 * 
	 * //query=query+")"; } //flag=true; //} } System.out.println("Quesy::"+query);
	 * 
	 * List<String> projectIds=new ArrayList<String>(); projectIds.add("Test123");
	 * projectIds.add("Apple ID"); projectIds.add("kalyan_test_proje_1");
	 * HashMap<String,Boolean> flag=goalIdWithProId(projectIds,"hello");
	 * System.out.println("flag ::"+flag); if(flag.isEmpty()) {
	 * System.out.println("flag2 ::"+flag); }
	 * 
	 * }
	 */

	public HashMap<String, Boolean> goalIdWithProId(List<String> projectIds, String projectId) {
		HashMap<String, Boolean> projIdStatus = new HashMap<String, Boolean>();
		try {
			boolean projectIdStatusFlag = false;
			if (projectId != null && !projectIds.isEmpty() && projectIds != null) {
				for (String projectIdList : projectIds) {
					if (projectIdList.toUpperCase().contains(projectId.toUpperCase())
							|| projectIdList.toUpperCase().equalsIgnoreCase(projectId.toUpperCase())) {
						projectIdStatusFlag = true;
						projIdStatus.put(projectIdList, projectIdStatusFlag);
						break;
					}
				}
			}
		} catch (Exception e) {

		}
		return projIdStatus;

	}
	
	public Set<String> filterActivePro(List<Project> projObjs){
		//Set<String> projectIds=new 
		for(Project project:projObjs) {
			project.getProjectId();
			
		}
		return null;
		
	}
}
