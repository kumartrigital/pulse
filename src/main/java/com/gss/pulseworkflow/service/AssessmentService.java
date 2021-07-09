package com.gss.pulseworkflow.service;

import java.util.List;

import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.Assessment1;
import com.gss.pulseworkflow.model.AssessmentChild;
import com.gss.pulseworkflow.model.EmpAssmtDetail;

public interface AssessmentService {
		 int save(Assessment1 assessment);
		 List<Assessment1> findAll();
		 String getAssmtIntervalType(String assmtInterId);
		 int createAssmt(Assessment assessment);
		// int createAssmtDetailWithProjectId(Assessment assessment,long assmtId);
		// int createAssmtDetailWithScheduled(Assessment assessment,long assmtId);
		// int createAssmtDetail(Assessment assessment,long assmtId);
		// int createAssmtToEmp(Assessment assessment,long assmtId);
		 int createAssmtDetailWithProjectIdTemp(Assessment assessment,long assmtId);
		 int createAssmtDetailWithScheduledTemp(Assessment assessment,long assmtId);
		 int createAssmtDetailTemp(Assessment assessment,long assmtId);
		// long getAssmtIdByName(String assmtName);
		 int publish(long assmtId);
		 List<Assessment> getAllAssessments();
		 List<AssessmentChild> getAssessmentDtlAndEmpAssmt(Assessment assessment);
		 int updateAssessment(Assessment assessment);
		 //int updateAssmtDetailWithProjectId(Assessment assessment);
		 //int updateAssmtDetailWithScheduled(Assessment assessment);
		 //int updateAssmtDetail(Assessment assessment);
		 int updateAssmtToEmp(Assessment assessment);
		 String getStatus(long assmtId);
		 int deleteByIdStatus(long assmtId);
		 int deleteById(long assmtId);
		 int deleteByIdChildAssmtDtl(long assmtId);
		 int deleteByIdChildAssmtEmp(long assmtId);
		 int createAssmtToTemp(Assessment assessment);
		// List<EmpAssmtDetail> assmtCapabilityRoleByProjectId(String projectId,long assmtId);
		 //List<EmpAssmtDetail> assmtCapabilityRoleByBasic(long assmtId);
		// int assmtROleDetails(long assmtId,Assessment assessment);
		 int createAssessments(Assessment assessment,String loggedInUser);
		 List<Assessment> assessmentSearch(Assessment assessment);

}
