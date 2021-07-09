package com.gss.pulseworkflow.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gss.pulseworkflow.dao.AssessmentRepository;
import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.Assessment1;
import com.gss.pulseworkflow.model.AssessmentChild;
import com.gss.pulseworkflow.model.AssessmtDeatilTemp;
import com.gss.pulseworkflow.model.EmpAssmtDetail;
import com.gss.pulseworkflow.response.ResponseHelper;
import com.gss.pulseworkflow.service.AssessmentService;
import com.gss.pulseworkflow.utility.Helper;
@Service
public class AssessmentServiceImpl implements AssessmentService {
	
	@Autowired
	private AssessmentRepository assessmentRepository;

	@Override
	public int save(Assessment1 assessment) {
		return assessmentRepository.save(assessment);
	}

	@Override
	public List<Assessment1> findAll() {
		return assessmentRepository.findAll();
	}

	@Override
	public String getAssmtIntervalType(String assmtInterId) {
		return assessmentRepository.getAssmtIntervalType(assmtInterId);
	}

	@Override
	public int createAssmt(Assessment assessment) {
		return assessmentRepository.createAssmt(assessment);
	}

	/*
	 * @Override public int createAssmtDetailWithProjectId(Assessment assessment,
	 * long assmtId) { return
	 * assessmentRepository.createAssmtDetailWithProjectId(assessment, assmtId); }
	 * 
	 * @Override public int createAssmtDetailWithScheduled(Assessment assessment,
	 * long assmtId) { return
	 * assessmentRepository.createAssmtDetailWithScheduled(assessment, assmtId); }
	 * 
	 * @Override public int createAssmtDetail(Assessment assessment, long assmtId) {
	 * return assessmentRepository.createAssmtDetail(assessment, assmtId); }
	 */


	@Override
	public int createAssmtDetailWithProjectIdTemp(Assessment assessment, long assmtId) {
		return assessmentRepository.createAssmtDetailWithProjectIdTemp(assessment, assmtId);
	}

	@Override
	public int createAssmtDetailWithScheduledTemp(Assessment assessment, long assmtId) {
		return assessmentRepository.createAssmtDetailWithScheduledTemp(assessment, assmtId);
	}

	@Override
	public int createAssmtDetailTemp(Assessment assessment, long assmtId) {
		return assessmentRepository.createAssmtDetailTemp(assessment, assmtId);
	}


	@Override
	@Transactional
	public int publish(long assmtId) {
		int flag=0;
		int responseFlag=0;
		Assessment assessment=assessmentRepository.getAssmtBasicData(assmtId);
		System.out.println("assessment ::"+assessment);
		assessmentRepository.deleteAssmtDataFromTemp(assmtId);
		List<AssessmtDeatilTemp> assmtDetailTempList=assessmentRepository.getAssmtDeatilData(assmtId);
		System.out.println("assmtDetailTempList ::"+assmtDetailTempList.size());
		assessmentRepository.deleteAssmtDetailDataFromTemp(assmtId);
		
		int createFlag = assessmentRepository.createAssmt(assessment);
		System.out.println("createFlag ::"+createFlag);
		if(createFlag>0) {
		//long finalAssmtId = assessmentRepository.getAssmtIdByName(assessment.getAssmtName());
		//for(AssessmtDeatilTemp assmtDetailTemp :assmtDetailTempList) {
		String intervalType = assessmentRepository.getAssmtIntervalType(assessment.getInterval());
		System.out.println("intervalType ::"+intervalType);
		if (intervalType.equalsIgnoreCase("PROJECT")) {
			assessment.setProjectId(assmtDetailTempList.get(0).getProjectId());
			System.out.println("assmtDetailTempList.get(0).getProjectId() ::"+assmtDetailTempList.get(0).getProjectId());
			System.out.println("project if befor ::"+intervalType);
			flag = assessmentRepository.createAssmtDetailWithProjectId(assmtDetailTempList, assessment.getRcdId());
			//empAssmtDetails=assessmentService.assmtCapabilityRoleByProjectId(assessment.getProjectId(),assmtId);
			System.out.println("project if after ::"+intervalType);
		} else if (intervalType.equalsIgnoreCase("SCHEDULED")) {
			System.out.println("project if befor ::"+intervalType);
			flag = assessmentRepository.createAssmtDetailWithScheduled(assmtDetailTempList, assessment.getRcdId());
			//empAssmtDetails=assessmentService.assmtCapabilityRoleByBasic(assmtId);
			System.out.println("project if after ::"+intervalType);
		} else {
			System.out.println("project if befor ::"+intervalType);
			flag = assessmentRepository.createAssmtDetail(assmtDetailTempList, assessment.getRcdId());
			//empAssmtDetails=assessmentService.assmtCapabilityRoleByBasic(assmtId);
			System.out.println("project if after ::"+intervalType);
		}
		if (flag > 0) {
			System.out.println("flag if after ::"+flag);
			int empFlag = assessmentRepository.createAssmtToEmp(assessment);
			System.out.println("empFlag if after ::"+empFlag);
			int empAssmtChild=assmtROleDetails(assessment);
			if(empAssmtChild>0) {
				responseFlag=1;
			}
			
		}
		}

		return responseFlag;
	}

	@Override
	public List<Assessment> getAllAssessments() {
		return assessmentRepository.getAllAssessments();
	}

	@Override
	public List<AssessmentChild> getAssessmentDtlAndEmpAssmt(Assessment assessment) {
		return assessmentRepository.getAssessmentDtlAndEmpAssmt(assessment);
	}

	@Override
	public int updateAssessment(Assessment assessment) {
		return assessmentRepository.updateAssessment(assessment);
	}

	/*
	 * @Override public int updateAssmtDetailWithProjectId(Assessment assessment) {
	 * return assessmentRepository.updateAssmtDetailWithProjectId(assessment); }
	 * 
	 * @Override public int updateAssmtDetailWithScheduled(Assessment assessment) {
	 * return assessmentRepository.updateAssmtDetailWithScheduled(assessment); }
	 * 
	 * @Override public int updateAssmtDetail(Assessment assessment) { return
	 * assessmentRepository.updateAssmtDetail(assessment); }
	 */

	@Override
	public int updateAssmtToEmp(Assessment assessment) {
		return assessmentRepository.updateAssmtToEmp(assessment);
	}

	@Override
	public String getStatus(long assmtId) {
		return assessmentRepository.getStatus(assmtId);
	}

	@Override
	public int deleteByIdStatus(long assmtId) {
		return assessmentRepository.deleteByIdStatus(assmtId);
	}

	@Override
	public int deleteById(long assmtId) {
		return assessmentRepository.deleteById(assmtId);
	}

	@Override
	public int deleteByIdChildAssmtDtl(long assmtId) {
		return assessmentRepository.deleteByIdChildAssmtDtl(assmtId);
	}

	@Override
	public int deleteByIdChildAssmtEmp(long assmtId) {
		return assessmentRepository.deleteByIdChildAssmtEmp(assmtId);
	}

	@Override
	public int createAssmtToTemp(Assessment assessment) {
		return assessmentRepository.createAssmtToTemp(assessment);
	}



	public int assmtROleDetails(Assessment assessment) {
		List<EmpAssmtDetail> empAssmtDetails=null;
		int addFlag=0;
		String intervalType = assessmentRepository.getAssmtIntervalType(assessment.getInterval());
		if (intervalType.equalsIgnoreCase("PROJECT")) {
			empAssmtDetails= assessmentRepository.assmtCapabilityRoleByProjectId(assessment.getProjectId(),assessment.getRcdId());
		} else {
			empAssmtDetails= assessmentRepository.assmtCapabilityRoleByBasic(assessment.getRcdId());
		}
		System.out.println("empAssmtDetail if after ::"+empAssmtDetails);
		List<String> associatedCapsByRole=assessmentRepository.getassociateCapabilitiesByRole(empAssmtDetails.get(0).getAssesseeRole());
		System.out.println("associatedCapsByRole if after ::"+associatedCapsByRole);
		for(String capability : associatedCapsByRole) {
			for(EmpAssmtDetail empAssmtDetail:empAssmtDetails) {
		addFlag=addFlag+assessmentRepository.createAssmtCapabilities(empAssmtDetail,capability);
			}
		System.out.println("associatedCapsByRole if after ::"+addFlag);
		}
		//empAssmtDetail.setAssesseeCapabilitoes(associatedCapsByRole);
		System.out.println("after for if after ::"+addFlag);
		return addFlag;
	}

	@Override
	@Transactional
	public int createAssessments(Assessment assessment, String loggedInUser) {
		int flag = 0;
		int responseFlg = 0;
		if (assessment.isStaticFlag()) {
			int createFlag = assessmentRepository.createAssmtTemp(assessment, loggedInUser);
			if (createFlag > 0) {
				List<Long> rcdIds = assessmentRepository.getAssmtIdByNameTemp(assessment.getAssmtName());
				String intervalType = assessmentRepository.getAssmtIntervalType(assessment.getAssmtType());
				if (intervalType.equalsIgnoreCase("PROJECT")) {
					flag = assessmentRepository.createAssmtDetailWithProjectIdTemp(assessment, rcdIds);
					// empAssmtDetails=assessmentService.assmtCapabilityRoleByProjectId(assessment.getProjectId(),assmtId);

				} else if (intervalType.equalsIgnoreCase("SCHEDULED")) {
					flag = assessmentRepository.createAssmtDetailWithScheduledTemp(assessment, rcdIds);
					// empAssmtDetails=assessmentService.assmtCapabilityRoleByBasic(assmtId);
				} else {
					flag = assessmentRepository.createAssmtDetailTemp(assessment, rcdIds);
					// empAssmtDetails=assessmentService.assmtCapabilityRoleByBasic(assmtId);
				}
				if (flag > 0) {

					int empFlag = assessmentRepository.createAssmtToEmpTemp(assessment, rcdIds);
					if (empFlag > 0) {
						responseFlg = 1;
					}
					// int empAssmtChild=assessmentService.assmtROleDetails(assmtId,assessment);
				}
			}
		} else if (!assessment.isStaticFlag()) {
			int createFlag = assessmentRepository.createAssmtToTemp(assessment);
			if (createFlag > 0) {
				responseFlg = 1;
			}
		}
		return responseFlg;
	}
	@Override
	public List<Assessment> assessmentSearch(Assessment assessment) {
		String query="SELECT ASSESSMENT_TEMP.RCD_ID AS RCDID,ASSESSMENT_TEMP.ASSMT_NAME AS ASSMTNAME,ASSESSMENT_TEMP.ASSMT_INTERVAL_ID AS ASSMTINTERVAL,"
				+ " MSTR_ASSESSMENT_INTERVAL.INTERVAL_NAME AS INTERVALNAME,"
				+ " ASSESSMENT_TEMP.ASSNT_STATUS_ID AS STATUSID,MSTR_STATUS.STATUS_VALUE AS STATUS,"
				+ " ASSESSMENT_TEMP.ASSNT_DTL_STATUS_ID AS DTLSTATUSID,ASSESSMENT_TEMP.ASSMT_SUMMARY AS SUMMARY,ASSESSMENT_TEMP.ASSMT_CREATED_DATE AS "
				+ " CREATEDDATE,ASSESSMENT_TEMP.ASSMT_DESCRIPTION AS ASSMTDESC,ASSESSMENT_TEMP.LAST_UPDATED_DATE AS UPDATEDDATE FROM ASSESSMENT_TEMP JOIN "
				+ " MSTR_ASSESSMENT_INTERVAL ON MSTR_ASSESSMENT_INTERVAL.INTERVAL_ID=ASSESSMENT_TEMP.ASSMT_INTERVAL_ID LEFT JOIN "
				+ " MSTR_STATUS ON MSTR_STATUS.STATUS_ID=ASSESSMENT_TEMP.ASSNT_STATUS_ID";
				//+ "WHERE ASSESSMENT_TEMP.ASSMT_NAME LIKE '%test%' AND ASSESSMENT_TEMP.ASSMT_INTERVAL_ID='00S'";
		boolean searchFlag=false;
		if (assessment.getAssmtName() != null) {
			query = query + " WHERE ASSESSMENT_TEMP.ASSMT_NAME LIKE '%" + assessment.getAssmtName().trim() + "%'";
			searchFlag = true;
		}
	if (assessment.getAssmtType() != null && searchFlag) {
		query = query + " AND ASSESSMENT_TEMP.ASSMT_INTERVAL_ID='" + assessment.getAssmtType().trim() + "'";
		searchFlag = true;
	} else if (assessment.getAssmtType() != null && !searchFlag) {
		query = query + " WHERE ASSESSMENT_TEMP.ASSMT_INTERVAL_ID='" + assessment.getAssmtType().trim() + "'";
		searchFlag = true;
	}
	
	List<Assessment> assessmentResList =new ArrayList<Assessment>();
		Helper helper=new Helper();
		List<Assessment> assessmentRes = assessmentRepository.assessmentSearch(query);
		if(assessmentRes.size()>0) {
		for(Assessment assessment1:assessmentRes) {
			List<AssessmentChild> assessmentChildList=assessmentRepository.getAssessmentDtlAndEmpAssmt(assessment1);
			assessment1=helper.dataMap(assessmentChildList,assessment1);
			assessmentResList.add(assessment1);
		}
	}
		return assessmentResList;
	}


}
