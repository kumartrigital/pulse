package com.gss.pulseworkflow.dao;

import java.util.List;

import com.gss.pulseworkflow.model.Training;

public interface TrainingRepository {

	int count();

	int save(Training training);

	int update(Training training);

	int deleteById(Long id);

	List<Training> findAll();

	int saveToLog(long capabilityID, String action);

	long getRecordId(String trainingName, String trainingId);

	int publish(long id);

	int deleteByIdStatus(Long id);
	List<Training> trainingSearch(String query);
	long existingTraining(String trainigId);

}
