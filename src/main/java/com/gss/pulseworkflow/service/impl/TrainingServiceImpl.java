package com.gss.pulseworkflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gss.pulseworkflow.dao.TrainingRepository;
import com.gss.pulseworkflow.model.Training;
import com.gss.pulseworkflow.service.TrainingService;
@Service
public class TrainingServiceImpl implements TrainingService {
	@Autowired
	private TrainingRepository trainingRepository;
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveTraining(Training training) {
		int saveFlag = trainingRepository.save(training);
		if (saveFlag > 0) {
			training.setRecID(
					trainingRepository.getRecordId(training.getTrainingName(), training.getTainingId()));
		}
		// TODO Auto-generated method stub
		return saveFlag;
	}

	@Override
	public int updateTraining(Training training) {
		return trainingRepository.update(training);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Training> getAllTrainings() {
		return trainingRepository.findAll();
	}

	@Override
	public int saveToLog(long capabilityID, String action) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getRecordId(String trainingName, String trainingId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int publishTraining(long id,String comment) {
		return trainingRepository.publish(id);
	}

	@Override
	public int deleteTraining(Long id) {
		return trainingRepository.deleteByIdStatus(id);
	}
	@Override
	public List<Training> trainigSearch(Training training) {
		String query="SELECT MSTR_TRAINING.RCD_ID,MSTR_TRAINING.TRNG_ID,MSTR_TRAINING.TRNG_NAME,"
				+ "MSTR_TRAINING.TRNG_DESCRIPTION,MSTR_TRAINING.TRNG_CAPABILITY_ID,"
				+ "MSTR_CAPABILITY.CAPABILITY_NAME,"
				+ "MSTR_TRAINING.TRNG_STATUS_ID,MSTR_STATUS.STATUS_VALUE,EMP_DETAIL.EMAIL,"
				+ "MSTR_TRAINING.CREATOR_ID,MSTR_TRAINING.CREATED_DATE FROM MSTR_TRAINING "
				+ "JOIN MSTR_CAPABILITY ON MSTR_TRAINING.TRNG_CAPABILITY_ID=MSTR_CAPABILITY.CAPABILITY_ID "
				+ "JOIN MSTR_STATUS ON MSTR_TRAINING.TRNG_STATUS_ID=MSTR_STATUS.STATUS_ID "
				+ "JOIN EMP_DETAIL ON EMP_DETAIL.EMPLOYEE_ID=MSTR_TRAINING.CREATOR_ID";
		boolean searchFlag=false;
		if (training.getTainingId() != null) {
			query = query + " WHERE MSTR_TRAINING.TRNG_ID LIKE '%" + training.getTainingId().trim() + "%'";
			searchFlag = true;
		}
	if (training.getTrainingName() != null && searchFlag) {
		query = query + " AND MSTR_TRAINING.TRNG_NAME LIKE '%" + training.getTrainingName().trim() + "%'";
		searchFlag = true;
	} else if (training.getTrainingName() != null && !searchFlag) {
		query = query + " WHERE MSTR_TRAINING.TRNG_NAME LIKE '%" + training.getTrainingName().trim() + "%'";
		searchFlag = true;
	}
	if (training.getTrainingStatusID() != null && searchFlag) {
		query = query + " AND MSTR_TRAINING.TRNG_STATUS_ID='" + training.getTrainingStatusID().trim() + "'";
		searchFlag = true;
	} else if (training.getTrainingStatusID() != null && !searchFlag) {
		query = query + " WHERE MSTR_TRAINING.TRNG_STATUS_ID='" + training.getTrainingStatusID().trim() + "'";
		searchFlag = true;
	}
	if (training.getCapabilityId()>0 && searchFlag) {
		query = query + " AND MSTR_TRAINING.TRNG_CAPABILITY_ID='" + training.getCapabilityId() + "'";
		searchFlag = true;
	} else if (training.getCapabilityId()>0 && !searchFlag) {
		query = query + " WHERE MSTR_TRAINING.TRNG_CAPABILITY_ID='" + training.getCapabilityId() + "'";
		searchFlag = true;
	}
		return trainingRepository.trainingSearch(query);
	}

	@Override
	public long existingTraining(String trainigId) {
		return trainingRepository.existingTraining(trainigId);
	}

}
