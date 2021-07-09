package com.gss.pulseworkflow.dao;

import java.util.List;

import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.Assessment1;
import com.gss.pulseworkflow.model.AssessmentChild;
import com.gss.pulseworkflow.model.AssessmtDeatilTemp;
import com.gss.pulseworkflow.model.EmpAssmtDetail;

public interface AssessmentRepository {
	 int save(Assessment1 assessment);
	 List<Assessment1> findAll();
	 String getAssmtIntervalType(String assmtInterId);
	 int createAssmt(Assessment assessment);
	 int createAssmtTemp(Assessment assessment,String loggedInUser);
	 int createAssmtDetailWithProjectId(List<AssessmtDeatilTemp> assmtDetailTempList,long assmtId);
	 int createAssmtDetailWithProjectIdTemp(Assessment assessment,List<Long> rcdIds);
	 int createAssmtDetailWithScheduled(List<AssessmtDeatilTemp> assmtDetailTempList,long assmtId);
	 int createAssmtDetailWithScheduledTemp(Assessment assessment,List<Long> rcdIds);
	 int createAssmtDetail(List<AssessmtDeatilTemp> assmtDetailTempList,long assmtId);
	 int createAssmtDetailTemp(Assessment assessment,List<Long> rcdIds);
	 int createAssmtToEmp(Assessment assessment);
	 int createAssmtToEmpTemp(Assessment assessment,List<Long> rcdIds);
	 int createAssmtDetailWithProjectIdTemp(Assessment assessment,long assmtId);
	 int createAssmtDetailWithScheduledTemp(Assessment assessment,long assmtId);
	 int createAssmtDetailTemp(Assessment assessment,long assmtId);
	 //long getAssmtIdByName(String assmtName);
	 List<Long> getAssmtIdByNameTemp(String assmtName);
	 int publish(long assmtId);
	 List<Assessment> getAllAssessments();
	 List<AssessmentChild> getAssessmentDtlAndEmpAssmt(Assessment assessment);
	 int updateAssessment(Assessment assessment);
	 int updateAssmtDetailWithProjectId(Assessment assessment);
	 int updateAssmtDetailWithScheduled(Assessment assessment);
	 int updateAssmtDetail(Assessment assessment);
	 int updateAssmtToEmp(Assessment assessment);
	 String getStatus(long assmtId);
	 int deleteByIdStatus(long assmtId);
	 int deleteById(long assmtId);
	 int deleteByIdChildAssmtDtl(long assmtId);
	 int deleteByIdChildAssmtEmp(long assmtId);
	 int createAssmtToTemp(Assessment assessment);
	 List<EmpAssmtDetail> assmtCapabilityRoleByProjectId(String projectId, long assmtId);
	 List<EmpAssmtDetail> assmtCapabilityRoleByBasic(long assmtId);
	 List<String> getassociateCapabilitiesByRole(String role);
	 int createAssmtCapabilities(EmpAssmtDetail empAssmtDetail,String capability);
	 Assessment getAssmtBasicData(long assmtId);
	 List<AssessmtDeatilTemp> getAssmtDeatilData(long assmtId);
	 void deleteAssmtDataFromTemp(long rcdId);
	 void deleteAssmtDetailDataFromTemp(long rcdId);
	 List<Assessment> assessmentSearch(String query);
}
