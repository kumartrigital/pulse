package com.gss.pulseworkflow.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gss.pulseworkflow.dao.SkillRepository;
import com.gss.pulseworkflow.model.UserSkills;
@Repository
public class SkillRepositoryImpl extends JdbcDaoSupport implements SkillRepository{
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	@Override
	public List<UserSkills> findSkillById(String employeeId) {
		return jdbcTemplate.query(
                "SELECT EMP_SKILL.RCD_ID as RCDID,EMP_SKILL.SKILL_NAME as SKILLNAME,EMP_SKILL.SKILL_DESCRIPTION as SKILLDES,EMP_SKILL.SKILL_EXPERIENCE as SKILLEXPER,EMP_SKILL.CERTIFIED as CERTIFIED,"
                + " EMP_SKILL.FRML_TRAINED as FORMALTRAINED,EMP_SKILL.LAST_USED_DATE as LASTUSEDDATE,EMP_SKILL.ADDED_DATE as ADDEDDATE,EMP_SKILL.SKILL_LEVEL as SKILLLEVEL,EMP_SKILL.CAPABILITY_ID as CAPABILITYID,MSTR_CAPABILITY.CAPABILITY_NAME as CAPABILITYNAME "
                + " FROM  EMP_SKILL JOIN MSTR_CAPABILITY ON "
                + " EMP_SKILL.CAPABILITY_ID=MSTR_CAPABILITY.CAPABILITY_ID AND EMP_SKILL.EMPLOYEE_ID=?",
                new Object[]{employeeId},
                (rs, rowNum) ->
                new UserSkills(
                		rs.getLong("RCDID"),
                        rs.getString("SKILLNAME"),
                        rs.getString("SKILLDES"),
                        rs.getLong("SKILLEXPER"),
                        rs.getString("CERTIFIED"),
                        rs.getString("FORMALTRAINED"),
                        rs.getString("LASTUSEDDATE"),
                        rs.getString("ADDEDDATE"),
                        rs.getString("SKILLLEVEL"),
                        rs.getString("CAPABILITYID"),
                        rs.getString("CAPABILITYNAME")));
	}
	@Override
	public int addSkill(UserSkills userSkills) {
		return jdbcTemplate.update(
                "insert into EMP_SKILL (EMPLOYEE_ID,SKILL_NAME,SKILL_LEVEL,SKILL_EXPERIENCE,LAST_USED_DATE,SKILL_DESCRIPTION,"
                + " CAPABILITY_ID,CERTIFIED,FRML_TRAINED) VALUES(?,?,?,?,?,?,?,?,?)",
                userSkills.getEmployeeId(),userSkills.getSkillName(),userSkills.getSkillLevel(),userSkills.getSkillExperience(),userSkills.getLastUsedDate(),
                userSkills.getSkillDescription(),userSkills.getCapabilityId(),userSkills.getSkillCertified(),userSkills.getFrmlTrained());
	}
	@Override
	public int updateSkill(UserSkills userSkills) {
		return jdbcTemplate.update(
                "update EMP_SKILL set SKILL_NAME = ?, SKILL_LEVEL=?, SKILL_EXPERIENCE=?, LAST_USED_DATE= ?,SKILL_DESCRIPTION=?,"
                + " CAPABILITY_ID=?, CERTIFIED=?, FRML_TRAINED=? where RCD_ID = ?",
                userSkills.getSkillName(),userSkills.getSkillLevel(),userSkills.getSkillExperience(),userSkills.getLastUsedDate(),
                userSkills.getSkillDescription(),userSkills.getCapabilityId(),userSkills.getSkillCertified(),userSkills.getFrmlTrained(),userSkills.getRcdId());
	}
	@Override
	public int deleteSkill(long rcdId) {
		return jdbcTemplate.update(
                "DELETE FROM EMP_SKILL where RCD_ID=?",
                rcdId);
	}
	@Override
	public long existingSkill(String employeeId, String skillName) {
		return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM EMP_SKILL WHERE EMPLOYEE_ID=? AND SKILL_NAME=?",
                new Object[]{employeeId,skillName},
                long.class
        );
	}
	
}
