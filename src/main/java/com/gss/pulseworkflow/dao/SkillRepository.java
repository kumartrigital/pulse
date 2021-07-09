package com.gss.pulseworkflow.dao;

import java.util.List;

import com.gss.pulseworkflow.model.UserSkills;

public interface SkillRepository {
	List<UserSkills> findSkillById(String employeeId);

	int addSkill(UserSkills userSkills);

	int updateSkill(UserSkills userSkills);

	int deleteSkill(long rcdId);
	long existingSkill(String employeeId, String skillName);
}
