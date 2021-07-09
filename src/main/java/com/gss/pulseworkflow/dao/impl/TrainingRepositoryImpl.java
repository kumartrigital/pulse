package com.gss.pulseworkflow.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.gss.pulseworkflow.dao.TrainingRepository;
import com.gss.pulseworkflow.model.Training;
@Repository
public class TrainingRepositoryImpl extends JdbcDaoSupport implements TrainingRepository{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	
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
	public int save(Training training) {
		//capability.setCapabilityStatusId("0");
		training.setTrainingStatusID("0");
		return jdbcTemplate.update(
                "insert into MSTR_TRAINING (TRNG_ID,TRNG_CAPABILITY_ID, TRNG_NAME,TRNG_DESCRIPTION,TRNG_STATUS_ID,CREATOR_ID) values(?,?,?,?,?,?)",
                training.getTainingId().trim(),training.getCapabilityId(),training.getTrainingName().trim(),training.getTrainingDes(),training.getTrainingStatusID(),
                training.getCreator());
	}

	@Override
	public int update(Training training) {
		return jdbcTemplate.update(
                "update MSTR_TRAINING set TRNG_ID =? ,TRNG_DESCRIPTION = ?, TRNG_NAME=?, TRNG_CAPABILITY_ID=? where RCD_ID = ?",
                training.getTainingId(),training.getTrainingDes(),training.getTrainingName(),training.getCapabilityId(),training.getRecID());
	}

	@Override
	public int deleteById(Long id) {
			// TODO Auto-generated method stub
			return jdbcTemplate.update(
	                "DELETE FROM MSTR_TRAINING where RCD_ID=?",
	                id);
	}

	@Override
	public List<Training> findAll() {
		// TODO Auto-generated method stub
				return jdbcTemplate.query(
		                "SELECT MSTR_TRAINING.RCD_ID AS RCDID,MSTR_TRAINING.TRNG_ID as TRANINGID,MSTR_TRAINING.TRNG_NAME as TRANINGNAME,MSTR_TRAINING.TRNG_CAPABILITY_ID as CAPABILITYID,"
		                + " MSTR_TRAINING.TRNG_DESCRIPTION as DESCRIPTION,MSTR_TRAINING.TRNG_STATUS_ID as STATUS,MSTR_CAPABILITY.CAPABILITY_NAME AS CAPABILITYNAME"
		                + " FROM MSTR_TRAINING JOIN MSTR_CAPABILITY ON MSTR_TRAINING.TRNG_CAPABILITY_ID=MSTR_CAPABILITY.CAPABILITY_ID;",
		                (rs, rowNum) ->
		                        new Training(
		                                rs.getString("TRANINGID"),
		                                rs.getString("DESCRIPTION"),
		                                rs.getString("TRANINGNAME"),
		                                rs.getLong("CAPABILITYID"),
		                                rs.getString("STATUS"),
		                                rs.getString("CAPABILITYNAME"),
		                                rs.getLong("RCDID")
		                        )
		        );
	}

	@Override
	public int saveToLog(long capabilityID, String action) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getRecordId(String trainingName, String traingId) {
		return jdbcTemplate.queryForObject(
                "select RCD_ID from MSTR_TRAINING WHERE TRNG_NAME= ? and TRNG_ID=?",
                new Object[]{trainingName,traingId},
                long.class
        );
	}

	@Override
	public int publish(long id) {
		return jdbcTemplate.update(
                "update MSTR_TRAINING set TRNG_STATUS_ID = '0' where RCD_ID = ?",
                id);
	}
	@Override
	public int deleteByIdStatus(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(
                "update MSTR_TRAINING set TRNG_STATUS_ID = '1' where RCD_ID = ?",
                id);
	}
	@Override
	public List<Training> trainingSearch(String query) {
		return jdbcTemplate.query(query,
				(rs, rowNum) -> new Training(rs.getLong("RCD_ID"), rs.getString("TRNG_ID"),
						rs.getString("TRNG_NAME"), rs.getString("TRNG_DESCRIPTION"),
						rs.getString("TRNG_STATUS_ID"),rs.getLong("TRNG_CAPABILITY_ID"),
						rs.getString("CAPABILITY_NAME"),rs.getString("STATUS_VALUE"),rs.getString("EMAIL"),
						rs.getString("CREATOR_ID"),rs.getString("CREATED_DATE")));
	}

	@Override
	public long existingTraining(String trainigId) {
		return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM MSTR_TRAINING WHERE TRNG_ID='Trn1'",
                new Object[]{trainigId},
                long.class
        );
	}
}
