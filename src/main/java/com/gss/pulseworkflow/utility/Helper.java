package com.gss.pulseworkflow.utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gss.pulseworkflow.model.Assessment;
import com.gss.pulseworkflow.model.AssessmentChild;
import com.gss.pulseworkflow.model.EmpHierarchy;

public class Helper {

	public EmpHierarchy hierarchyMap(List<EmpHierarchy> listEmpHierarchy) {

		List<HashMap<String, EmpHierarchy>> empHierList = new ArrayList<HashMap<String, EmpHierarchy>>();
		HashMap<String, EmpHierarchy> empHier = new HashMap<String, EmpHierarchy>();
		// List<EmpHierarchy> finaListEmpHierarchy=new ArrayList<EmpHierarchy>();
		Set<String> ids = new HashSet<String>();
		for (EmpHierarchy empHierarchy : listEmpHierarchy) {
			// empHierarchy.get
			ids.add(empHierarchy.getEmpId());
		}
		for (String id : ids) {
			for (EmpHierarchy empHierarchy : listEmpHierarchy) {
				if (id.equalsIgnoreCase(empHierarchy.getEmpId())) {
					empHier.put(id, empHierarchy);
				}
			}
			empHierList.add(empHier);
		}
		for (EmpHierarchy empHierarchy : listEmpHierarchy) {
			for (HashMap<String, EmpHierarchy> empHier1 : empHierList) {
				empHierarchy.setNextHierachy(empHier1.get(empHierarchy.getManagerId()));
				System.out.println("Emp::" + empHierarchy);
			}
			// finaListEmpHierarchy.a
		}

		return null;

	}

	public String getSystemDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return formatter.format(date);

	}
	
	public Assessment dataMap(List<AssessmentChild> assessmentChild,Assessment assessment) {
		HashMap<String,String> assessors=new HashMap<String,String>();
		HashMap<String,String> assessees=new HashMap<String,String>();
		for(AssessmentChild child:assessmentChild) {
			assessors.put(child.getAssessorId(), child.getAssessorEmail());
			assessees.put(child.getAssesseeId(),child.getAssesseeEmail());
		}
		assessment.setAccessors(assessors);
		assessment.setAssessees(assessees);
		assessment.setAssmtDtlRcdId(assessmentChild.get(0).getAssmtDtlRcdId());
		assessment.setAssmtDtlStatusId(assessmentChild.get(0).getAssmtDtlStatusId());
		assessment.setAssmtOutcome(assessmentChild.get(0).getAssmtOutcome());
		assessment.setInitDate(assessmentChild.get(0).getAssmtStartDate());
		assessment.setAssmtCompletedDate(assessmentChild.get(0).getAssmtCompletedDate());
		assessment.setEndDate(assessmentChild.get(0).getAssmtEndDate());
		assessment.setProjectId(assessmentChild.get(0).getProjectId());
		assessment.setProjectName(assessmentChild.get(0).getProjectName());
		assessment.setAssmtComments(assessmentChild.get(0).getAssmtComments());
		assessment.setInterval(assessmentChild.get(0).getScheduedInterval());
		assessment.setEmpAssmtRcdId(assessmentChild.get(0).getEmpAssmtRcdId());
		assessment.setEmpAssmtAssignedDate(assessmentChild.get(0).getEmpAssmtAssignedDate());
		assessment.setEmpInitId(assessmentChild.get(0).getEmpInitId());
		assessment.setEmpAssmtStatusId(assessmentChild.get(0).getEmpAssmtStatusId());
		assessment.setAssmtDtlStatusValue(assessmentChild.get(0).getAssmtDtlStatusValue());
		return assessment;
		
	}
	/*
	 * public static void main(String[] args) { SimpleDateFormat formatter = new
	 * SimpleDateFormat("yyyy-MM-dd"); Date date = new Date();
	 * System.out.println(formatter.format(date)); }
	 */
}
