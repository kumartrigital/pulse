package com.gss.pulseworkflow.service;

import java.util.List;

import com.gss.pulseworkflow.model.UserSkills;

public interface SkillService {

	List<UserSkills> findSkillById(String employeeId);

	int addSkill(UserSkills userSkills);

	int updateSkill(UserSkills userSkills);

	int deleteSkill(long rcdId);
	long existingSkill(String employeeId,String skillName);

}
