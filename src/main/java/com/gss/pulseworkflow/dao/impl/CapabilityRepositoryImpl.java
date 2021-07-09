package com.gss.pulseworkflow.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gss.pulseworkflow.dao.CapabilityRepository;
import com.gss.pulseworkflow.model.Capability;

@Repository
public class CapabilityRepositoryImpl extends JdbcDaoSupport implements CapabilityRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Capability capability,String loggedInUser) {
		capability.setCapabilityStatusId("0");

		return jdbcTemplate.update(
				"insert into MSTR_CAPABILITY (CAPABILITY_DESCRIPTION, CAPABILITY_NAME,CAPABILITY_TYPE,CAPABILITY_STATUS_ID,CREATOR_ID) values(?,?,?,?,?)",
				capability.getCapabilityDescription(), capability.getCapabilityName(), capability.getCapabilityType(),
				capability.getCapabilityStatusId(),loggedInUser);

		/*
		 * return getJdbcTemplate().update(
		 * "insert into MSTR_CAPABILITY (CAPABILITY_DESCRIPTION, CAPABILITY_NAME,CAPABILITY_TYPE,CAPABILITY_STATUS_ID) values(?,?,?,?)"
		 * , capability.getCapabilityDescription(),
		 * capability.getCapabilityName(),capability.getCapabilityType(),capability.
		 * getCapabilityStatusId());
		 */
	}

	@Override
	public int update(Capability capability) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
				"update MSTR_CAPABILITY set CAPABILITY_DESCRIPTION = ?, CAPABILITY_NAME=?, CAPABILITY_TYPE=? where CAPABILITY_ID = ?",
				capability.getCapabilityDescription(), capability.getCapabilityName(), capability.getCapabilityType(),
				capability.getCapabilityID());
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("update MSTR_CAPABILITY set CAPABILITY_STATUS_ID = '1' where CAPABILITY_ID = ?", id);
	}

	@Override
	public List<Capability> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from MSTR_CAPABILITY",
				(rs, rowNum) -> new Capability(rs.getString("CAPABILITY_DESCRIPTION"), rs.getString("CAPABILITY_NAME"),
						rs.getString("CAPABILITY_TYPE"), rs.getLong("CAPABILITY_ID"),
						rs.getString("CAPABILITY_STATUS_ID")));
	}

	@Override
	public int saveToLog(long capabilityId, String action) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into CAPABILITY_LOG (CAPABILITY_ID, EVENT_DESCRIPTION) values(?,?)",
				capabilityId, action);
	}

	@Override
	public long getCapabilityId(String capabilityName, String capabiliyType) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(
				"select CAPABILITY_ID from MSTR_CAPABILITY WHERE CAPABILITY_NAME= ? and CAPABILITY_TYPE=?",
				new Object[] { capabilityName, capabiliyType }, long.class);
	}
	// select * from MSTR_CAPABILITY WHERE CAPABILITY_NAME= ? and CAPABILITY_TYPE=?

	@Override
	public int publish(long capabilityID) {
		return jdbcTemplate.update("update MSTR_CAPABILITY set CAPABILITY_STATUS_ID = '0' where CAPABILITY_ID = ?",
				capabilityID);
	}

	@Override
	public int perDelete(long capabilityId) {
		return jdbcTemplate.update("DELETE FROM MSTR_CAPABILITY where CAPABILITY_ID=?", capabilityId);
	}

	@Override
	public Capability getCapabilityObj(String capabilityName, String capabiliyType) {
		return jdbcTemplate.queryForObject(
				"select * from MSTR_CAPABILITY WHERE CAPABILITY_NAME= ? and CAPABILITY_TYPE=?",
				new Object[] { capabilityName, capabiliyType },
				(rs, rowNum) -> new Capability(rs.getString("CAPABILITY_DESCRIPTION"), rs.getString("CAPABILITY_NAME"),
						rs.getString("CAPABILITY_TYPE"), rs.getLong("CAPABILITY_ID"),
						rs.getString("CAPABILITY_STATUS_ID")));
	}
	@Override
	public List<Capability> capabilitySearch(String query) {
		return jdbcTemplate.query(query,
				(rs, rowNum) -> new Capability(rs.getString("CAPABILITY_DESCRIPTION"), rs.getString("CAPABILITY_NAME"),
						rs.getString("CAPABILITY_TYPE"), rs.getLong("CAPABILITY_ID"),
						rs.getString("CAPABILITY_STATUS_ID"),rs.getString("STATUS_VALUE"),
						rs.getString("CREATOR_ID"),rs.getString("EMAIL"),rs.getString("CREATED_DATE")));
	}

	@Override
	public long existingCapability(String capabilityNmae, String capabilityType) {
		return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM MSTR_CAPABILITY WHERE CAPABILITY_NAME=? AND CAPABILITY_TYPE=?",
                new Object[]{capabilityNmae,capabilityType},
                long.class
        );
	}
	//SELECT COUNT(*) FROM GOALS WHERE GOAL_INTERVAL_ID=? AND GOAL_TYPE_ID=? AND GOAL_NAME=?;
}
