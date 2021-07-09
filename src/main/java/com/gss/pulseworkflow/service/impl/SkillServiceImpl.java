package com.gss.pulseworkflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.pulseworkflow.dao.SkillRepository;
import com.gss.pulseworkflow.model.UserSkills;
import com.gss.pulseworkflow.service.SkillService;
@Service
public class SkillServiceImpl implements SkillService{
	@Autowired
	private SkillRepository skillRepository;
	@Override
	public List<UserSkills> findSkillById(String employeeId) {
		return skillRepository.findSkillById(employeeId);
	}

	@Override
	public int addSkill(UserSkills userSkills) {
		return skillRepository.addSkill(userSkills);
	}

	@Override
	public int updateSkill(UserSkills userSkills) {
		return skillRepository.updateSkill(userSkills);
	}

	@Override
	public int deleteSkill(long rcdId) {
		return skillRepository.deleteSkill(rcdId);
	}

	@Override
	public long existingSkill(String employeeId, String skillName) {
		return skillRepository.existingSkill(employeeId,skillName);
	}

}
